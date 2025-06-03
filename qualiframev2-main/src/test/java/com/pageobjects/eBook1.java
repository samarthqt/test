package com.pageobjects;

import com.framework.components.ApplitoolsOperations;
import com.framework.reusable.WebReusableComponents;
import org.jsoup.Jsoup;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class eBook1 extends WebReusableComponents {

    protected By btn_CookieAcceptAll = By.id("onetrust-accept-btn-handler");
    protected By txt_UserName = By.id("username");
    protected By txt_Password = By.id("password");
    protected By btn_SignIn = By.id("submitBttn");
    protected By expandContainerLocator = By.cssSelector(".toc-parent > a");
    protected By childElementLocator = By.xpath("./following-sibling::ul/li | ./ul/li");
    protected By btn_ImageClose = By.xpath("(//div[@aria-label='Close']//*[name()='svg']//*[name()='path' and contains(@d,'M12 12c2.2')])");
    protected By btn_zoomIn = By.xpath("(//div[@aria-label='Zoomin'])[1]");
    protected By btn_zoomOut = By.xpath("(//div[@aria-label='Zoomout'])[1]");
    protected By switchToIframe = By.xpath("(//iframe[@id='contentIframe'])");
    protected By bookTitleLocator = By.xpath(".//h3[@class='drawer-book-title']");
    protected By bookAuthorLocator = By.xpath(".//div[@class='drawer-book-author']/span");
    protected By rightSideTextLocator = By.cssSelector(".spf-rce-element.spf-element-text h1, .spf-rce-element.spf-element-text h2, .spf-rce-element.spf-element-text h3, .spf-rce-element.spf-element-text h4, .spf-rce-element.spf-element-text p, .spf-rce-element.spf-element-text blockquote, .spf-rce-element.spf-element-table table, .stage-element.spf-rce-element h4.component-label-section span.component-title p");


    protected ApplitoolsOperations appliTools = new ApplitoolsOperations();

    private int linksUsingPatternCount;

    public void launchApp(String url) {
        launchUrl(url);
        maximizeWindow();
        appliTools.captureContent("");
    }
    /**
     * Login Process
     **/
    public void clickAcceptAllBtn() {
        waitUntilElementVisible(btn_CookieAcceptAll, 20);
        clickElement(btn_CookieAcceptAll);
    }

    public void enterUserNameTxt(String username) {
        enterText(txt_UserName, username);
    }

    public void enterPasswordTxt(String password) {
        enterText(txt_Password, password);
    }

    public void clickSignInBtn() {
        clickElement(btn_SignIn);
    }


    /** TOC **/
    public void clickTableOfContentBtnIcon() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 200);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[title='Table of contents']")));
            WebElement tableOfContentButton = driver.findElement(By.cssSelector("div[title='Table of contents']"));
            tableOfContentButton.click();
        } catch (TimeoutException | StaleElementReferenceException ex) {
            driver.navigate().refresh();
            clickTableOfContentBtnIcon();
        }
    }

    /**
     * 1. Check for presence of HTML code in title or caption
     * 2. Check if image opens in light box (image viewer) and closed to exit the light box.
     * 3. Image can be zoomed in/out
     * 4. If image contains a caption in the narrative, verify that the caption is also displayed in the lightbox
     **/
    public void extractImageFromSpecificPage(int pageNumber) {
        int overallTotalImages = 0;
        try (PrintWriter writer = new PrintWriter(new FileWriter("CWQA", true))) {
            driver.manage().timeouts().setScriptTimeout(20, TimeUnit.HOURS);
            waitUntilElementVisible(expandContainerLocator, 100);
            List<WebElement> expandContainers = driver.findElements(expandContainerLocator);
            int totalExpandContainers = expandContainers.size();


            if (pageNumber <= 0 || pageNumber > totalExpandContainers) {
                System.out.println("Invalid page number. Please provide a valid page number.");
                return;
            }

            int page = pageNumber - 1;
            WebElement expandContainer = expandContainers.get(page);
            writer.println();
            writer.println("*************************************************************************************");
            writer.println("Total Parent Expand Containers (Main Menu) on this book: " + totalExpandContainers);
            System.out.println();
            System.out.println("*************************************************************************************");
            System.out.println("Total Expand Containers (Main Menu) on this book: " + totalExpandContainers);
            writer.println("*************************************************************************************");
            writer.println("Navigating to Page " + pageNumber + ": " + expandContainer.getText());
            System.out.println("*************************************************************************************");
            System.out.println("Navigating to Page " + pageNumber + ": " + expandContainer.getText());
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", expandContainer);
            expandContainer.click();
            writer.println("Clicked on parent element (Main Menu): " + expandContainer.getText());
            System.out.println("Clicked on parent element (main Menu): " + expandContainer.getText());

            List<WebElement> childElements = expandContainer.findElements(childElementLocator);
            for (WebElement childElement : childElements) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", childElement);
                childElement.click();
                writer.println("*************************************************************************************");
                writer.println("Clicked on child element (Sub Menu): " + childElement.getText());
                System.out.println("*************************************************************************************");
                System.out.println("Clicked on child element (Sub Menu): " + childElement.getText());
                writer.println("Current page: " + childElement.getText());
                System.out.println("Current page: " + childElement.getText());
                int totalImagesOnPage = 0;

                switchToIframeContainer();
                WebDriverWait wait = new WebDriverWait(driver, 30);

                try {
                    List<WebElement> imageElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='pearson-component image']//img[not(contains(@alt, 'The figure illustrates a data set icon.'))]")));

                    totalImagesOnPage = imageElements.size();
                    System.out.println("Total images on this page: " + totalImagesOnPage);
                    System.out.println("---------------------------------------------------------------------------------------------");
                    writer.println("Total images on this page: " + totalImagesOnPage);
                    writer.println("---------------------------------------------------------------------------------------------");

                    for (int i = 0; i < totalImagesOnPage; i++) {
                        writer.println("Click on Image " + (i + 1) + ": ");
                        System.out.println("Click on Image " + (i + 1) + ": ");

                        try {
                            WebElement imageElement = imageElements.get(i);

                            String genericLabel = extractFigureGenericLabelHeading(imageElement, writer);
                            extractFigureComponentLabelHeading(imageElement, writer);

                            String imageUrl = imageElement.getAttribute("src");
                            assert imageUrl != null && !imageUrl.isEmpty() : "Fail: Image source is null or empty!";
                            writer.println("Log: Image source: " + imageUrl);
                            System.out.println("Log: Image source: " + imageUrl);

                            String figCaptionBeforeClick = extractFigCaption(imageElement, writer);


                            WebElement clickableImage = wait.until(ExpectedConditions.elementToBeClickable(imageElement));
                            try {
                                clickableImage.click();
                                writer.println("Pass: Image clicked successfully.");
                                System.out.println("Pass: Image clicked successfully.");
                            } catch (WebDriverException e) {
                                writer.println("Fail: Image not clickable. Moving to the next image.");
                                writer.println("-----------------------------------------------------------------------------------------------");
                                writer.println();
                                System.out.println("Fail: Image not clickable. Moving to the next image.");
                                System.out.println("-----------------------------------------------------------------------------------------------");
                                System.out.println();
                                continue;
                            }

                            driver.switchTo().defaultContent();

                            By zoomInButtonLocator = By.xpath("(//div[@aria-label='Zoomin'])[1]");
                            WebDriverWait zoomInButtonWait = new WebDriverWait(driver, 20);
                            WebElement zoomInButton = zoomInButtonWait.until(ExpectedConditions.visibilityOfElementLocated(zoomInButtonLocator));

                            if (zoomInButton.isDisplayed()) {
                                writer.println("Pass: LightBox opened, and zoom-in button is visible.");
                                System.out.println("Pass: LightBox opened, and zoom-in button is visible.");
                            } else {
                                writer.println("Fail: Failed to open LightBox, and zoom-in button is invisible.");
                                System.out.println("Fail: Failed to open LightBox, and zoom-in button is invisible.");
                            }

                            String lightboxCaption = extractFigCaptionFromLightbox(writer, figCaptionBeforeClick, figCaptionBeforeClick);

                            if (figCaptionBeforeClick.isEmpty() && lightboxCaption.isEmpty()) {
                                writer.println("Pass: Both Figure caption and Lightbox caption not present.");
                                System.out.println("Pass: Both Figure caption and Lightbox caption not present.");
                            } else if (lightboxCaption.isEmpty()) {
                                writer.println("Fail: Figure Caption is present but LightBox caption not present");
                                System.out.println("Fail: Figure Caption is present but LightBox caption not present");
                            } else if (figCaptionBeforeClick.isEmpty()) {
                                writer.println("Fail: LightBox Caption is present but Figure caption not present.");
                                System.out.println("Fail: LightBox Caption is present but Figure caption not present.");
                            }

                            clickZoomInBtn(writer);
                            writer.println("Pass: Zoom In clicked successfully.");
                            System.out.println("Pass: Zoom In clicked successfully.");

                            clickZoomInBtn(writer);
                            writer.println("Pass: Zoom In clicked successfully.");
                            System.out.println("Pass: Zoom In clicked successfully.");

                            clickZoomOutBtn(writer);
                            writer.println("Pass: Zoom Out clicked successfully.");
                            System.out.println("Pass: Zoom Out clicked successfully.");

                            clickImageCloseBtn(writer);
                            writer.println("---------------------------------------------------------------------------------------------");
                            writer.println();
                            System.out.println("---------------------------------------------------------------------------------------------");
                            System.out.println();

                            driver.switchTo().defaultContent();
                            switchToIframeContainer();
                            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", imageElement);
                            overallTotalImages++;
                        } catch (StaleElementReferenceException e) {
                            imageElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//img[@class='img-align-center']")));
                            i--;
                        }
                    }
                } catch (TimeoutException e) {
                    writer.println("No images found in the current page. Skipping to the next page.");
                    writer.println("---------------------------------------------------------------------------------------------");
                    System.out.println("No images found in the current page. Skipping to the next page.");
                    System.out.println("---------------------------------------------------------------------------------------------");
                } finally {
                    driver.switchTo().defaultContent();
                }
            }
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
            writer.println("*************************************************************************************");
            writer.println("Log:Total images in the Ebook: " + overallTotalImages);
            writer.println("Log:Total images scraped by Automation: " + (overallTotalImages - skippedMathMLHandlingCount));
            writer.println("Log:Total images recommended to test manually: " + skippedMathMLHandlingCount);
            if (skippedMathMLHandlingCount > 0) {
                writer.println("Log:Reasons for manual test recommendation: Images contain mathml expressions beyond [], (), /, √");
                writer.println("Log:To search for images that are recommended for manual checking, use the phrase - 'Image contains MathMl expressions beyond ([],(),/,√). Recommended to check this image manually' in the generated log file.");
            }
            writer.println("*************************************************************************************");

            System.out.println("*************************************************************************************");
            System.out.println("Log:Total images in the Ebook: " + overallTotalImages);
            System.out.println("Log:Total images scraped by Automation: " + (overallTotalImages - skippedMathMLHandlingCount));
            System.out.println("Log:Total images recommended to test manually: " + skippedMathMLHandlingCount);
            if (skippedMathMLHandlingCount > 0) {
                System.out.println("Log:Reasons for manual test recommendation: Images contain mathml expressions beyond [], (), /, √");
                System.out.println("Log:To search for images that are recommended for manual checking, use the phrase - 'Image contains MathMl expressions beyond ([],(),/,√). Recommended to check this image manually' in the generated log file.");
            }
            System.out.println("*************************************************************************************");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void extractAllImagesFromRightSide() {
        driver.manage().timeouts().setScriptTimeout(120, TimeUnit.SECONDS);
        int overallTotalImages = 0;
        try (PrintWriter writer = new PrintWriter(new FileWriter("Course_Image.txt", true))) {
            waitUntilElementVisible(expandContainerLocator, 30);
            List<WebElement> expandContainers = driver.findElements(expandContainerLocator);
            int totalExpandContainers = expandContainers.size();
            writer.println();
            writer.println("*************************************************************************************");
            writer.println("Total Parent Expand Containers (Main Menu) on this book: " + totalExpandContainers);
            System.out.println();
            System.out.println("*************************************************************************************");
            System.out.println("Total Parent Expand Containers (Main Menu) on this book: " + totalExpandContainers);

            for (int page = 0; page < totalExpandContainers; page++) {
                WebElement expandContainer = expandContainers.get(page);
                writer.println("*************************************************************************************");
                writer.println("Navigating to Page " + (page + 1) + ": " + expandContainer.getText());
                System.out.println("*************************************************************************************");
                System.out.println("Navigating to Page " + (page + 1) + ": " + expandContainer.getText());
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", expandContainer);
                expandContainer.click();
                writer.println("Clicked on parent element (main Menu): " + expandContainer.getText());
                System.out.println("Clicked on parent element (main Menu): " + expandContainer.getText());

                List<WebElement> childElements = expandContainer.findElements(childElementLocator);
                for (WebElement childElement : childElements) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", childElement);
                    childElement.click();
                    writer.println("*************************************************************************************");
                    writer.println("Clicked on child element (Sub Menu): " + childElement.getText());
                    System.out.println("*************************************************************************************");
                    System.out.println("Clicked on child element (Sub Menu): " + childElement.getText());
                    writer.println("Current page: " + childElement.getText());
                    System.out.println("Current page: " + childElement.getText());
                    int totalImagesOnPage = 0;

                    switchToIframeContainer();
                    WebDriverWait wait = new WebDriverWait(driver, 60);

                    try {
                        List<WebElement> imageElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='pearson-component image']//img[not(contains(@alt, 'The figure illustrates a data set icon.'))]")));

                        totalImagesOnPage = imageElements.size();
                        System.out.println("Total images on this page: " + totalImagesOnPage);
                        System.out.println("---------------------------------------------------------------------------------------------");
                        writer.println("Total images on this page: " + totalImagesOnPage);
                        writer.println("---------------------------------------------------------------------------------------------");

                        for (int i = 0; i < totalImagesOnPage; i++) {
                            writer.println("Click on Image " + (i + 1) + ": ");
                            System.out.println("Click on Image " + (i + 1) + ": ");

                            try {
                                WebElement imageElement = imageElements.get(i);

                                String genericLabel = extractFigureGenericLabelHeading(imageElement, writer);
                                extractFigureComponentLabelHeading(imageElement, writer);

                                String imageUrl = imageElement.getAttribute("src");
                                assert imageUrl != null && !imageUrl.isEmpty() : "Fail: Image source is null or empty!";
                                writer.println("Log: Image source: " + imageUrl);
                                System.out.println("Log: Image source: " + imageUrl);

                                String figCaptionBeforeClick = extractFigCaption(imageElement, writer);


                                WebElement clickableImage = wait.until(ExpectedConditions.elementToBeClickable(imageElement));
                                try {
                                    clickableImage.click();
                                    writer.println("Pass: Image clicked successfully.");
                                    System.out.println("Pass: Image clicked successfully.");
                                } catch (WebDriverException e) {
                                    writer.println("Fail: Image not clickable. Moving to the next image.");
                                    writer.println("-----------------------------------------------------------------------------------------------");
                                    writer.println();
                                    System.out.println("Fail: Image not clickable. Moving to the next image.");
                                    System.out.println("-----------------------------------------------------------------------------------------------");
                                    System.out.println();
                                    continue;
                                }

                                driver.switchTo().defaultContent();

                                By zoomInButtonLocator = By.xpath("(//div[@aria-label='Zoomin'])[1]");
                                WebDriverWait zoomInButtonWait = new WebDriverWait(driver, 10);
                                WebElement zoomInButton = zoomInButtonWait.until(ExpectedConditions.visibilityOfElementLocated(zoomInButtonLocator));

                                if (zoomInButton.isDisplayed()) {
                                    writer.println("Pass: LightBox opened, and zoom-in button is visible.");
                                    System.out.println("Pass: LightBox opened, and zoom-in button is visible.");
                                } else {
                                    writer.println("Fail: Failed to open LightBox, and zoom-in button is invisible.");
                                    System.out.println("Fail: Failed to open LightBox, and zoom-in button is invisible.");
                                }

                                String lightboxCaption = extractFigCaptionFromLightbox(writer, figCaptionBeforeClick, figCaptionBeforeClick);

                                if (figCaptionBeforeClick.isEmpty() && lightboxCaption.isEmpty()) {
                                    writer.println("Pass: Both Figure caption and Lightbox caption not present.");
                                    System.out.println("Pass: Both Figure caption and Lightbox caption not present.");
                                } else if (lightboxCaption.isEmpty()) {
                                    writer.println("Fail: Figure Caption is present but LightBox caption not present");
                                    System.out.println("Fail: Figure Caption is present but LightBox caption not present");
                                } else if (figCaptionBeforeClick.isEmpty()) {
                                    writer.println("Fail: LightBox Caption is present but Figure caption not present.");
                                    System.out.println("Fail: LightBox Caption is present but Figure caption not present.");
                                }
                                clickZoomInBtn(writer);
                                writer.println("Pass: Zoom In clicked successfully.");
                                System.out.println("Pass: Zoom In clicked successfully.");

                                clickZoomInBtn(writer);
                                writer.println("Pass: Zoom In clicked successfully.");
                                System.out.println("Pass: Zoom In clicked successfully.");

                                clickZoomOutBtn(writer);
                                writer.println("Pass: Zoom Out clicked successfully.");
                                System.out.println("Pass: Zoom Out clicked successfully.");

                                clickImageCloseBtn(writer);
                                writer.println("---------------------------------------------------------------------------------------------");
                                writer.println();
                                System.out.println("---------------------------------------------------------------------------------------------");
                                System.out.println();

                                driver.switchTo().defaultContent();
                                switchToIframeContainer();
                                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", imageElement);

                                overallTotalImages++;
                            } catch (StaleElementReferenceException e) {
                                imageElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//img[@class='img-align-center']")));
                                i--;
                            }
                        }
                    } catch (TimeoutException e) {
                        writer.println("No images found in the current page. Skipping to the next page.");
                        writer.println("---------------------------------------------------------------------------------------------");
                        System.out.println("No images found in the current page. Skipping to the next page.");
                        System.out.println("---------------------------------------------------------------------------------------------");
                    } finally {
                        driver.switchTo().defaultContent();
                    }
                }
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
            }
            writer.println("*************************************************************************************");
            writer.println("Log:Total images in the Ebook: " + overallTotalImages);
            writer.println("Log:Total images scraped by Automation: " + (overallTotalImages - skippedMathMLHandlingCount));
            writer.println("Log:Total images recommended to test manually: " + skippedMathMLHandlingCount);
            if (skippedMathMLHandlingCount > 0) {
                writer.println("Log:Reasons for manual test recommendation: Images contain mathml expressions beyond [], (), /, √");
                writer.println("Log:To search for images that are recommended for manual checking, use the phrase - 'Image contains MathMl expressions beyond ([],(),/,√). Recommended to check this image manually' in the generated log file.");
            }
            writer.println("*************************************************************************************");

            System.out.println("*************************************************************************************");
            System.out.println("Log:Total images in the Ebook: " + overallTotalImages);
            System.out.println("Log:Total images scraped by Automation: " + (overallTotalImages - skippedMathMLHandlingCount));
            System.out.println("Log:Total images recommended to test manually: " + skippedMathMLHandlingCount);
            if (skippedMathMLHandlingCount > 0) {
                System.out.println("Log:Reasons for manual test recommendation: Images contain mathml expressions beyond [], (), /, √");
                System.out.println("Log:To search for images that are recommended for manual checking, use the phrase - 'Image contains MathMl expressions beyond ([],(),/,√). Recommended to check this image manually' in the generated log file.");
            }
            System.out.println("*************************************************************************************");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String extractFigureGenericLabelHeading(WebElement imageElement, PrintWriter writer) {
        try {
            WebElement figureNumberElement;
            WebElement figureTitleElement;

            try {
                figureNumberElement = imageElement.findElement(By.xpath("./ancestor::div[contains(@class, 'spf-element-image')]/preceding-sibling::div[contains(@class, 'stage-element spf-rce-element spf-element-text figure-title')][1]//p[1]"));
                figureTitleElement = imageElement.findElement(By.xpath("./ancestor::div[contains(@class, 'spf-element-image')]/preceding-sibling::div[contains(@class, 'stage-element spf-rce-element spf-element-text figure-title')][1]//p[2]"));
            } catch (NoSuchElementException e) {
                try {
                    figureNumberElement = null;
                    figureTitleElement = imageElement.findElement(By.xpath("./ancestor::div[contains(@class, 'spf-element-image')]/preceding-sibling::div[contains(@class, 'spf-element-text figure-title')][1]//b"));
                } catch (NoSuchElementException ex) {
//                    figureNumberElement = imageElement.findElement(By.xpath("./ancestor::div[contains(@class, 'spf-element-image')]/preceding-sibling::div[contains(@class, 'spf-element-text')][1]//p[1]"));
//                    figureTitleElement = imageElement.findElement(By.xpath("./ancestor::div[contains(@class, 'spf-element-image')]/preceding-sibling::div[contains(@class, 'spf-element-text')][1]//p[2]"));
                    throw new NoSuchElementException("Pass: Generic label-Figure Number and Title not present.");
                }
            }

            String figureNumber = (figureNumberElement != null) ? figureNumberElement.getText().trim() : "";
            String figureTitle = (figureTitleElement != null) ? extractAndCleanTitle(figureTitleElement, writer) : "";

            if (!figureNumber.isEmpty()) {
                writer.println("Log: Figure Number: " + figureNumber);
                System.out.println("Log: Figure Number: " + figureNumber);
                boolean hasHtmlCodeInNumber = hasHtmlCode(figureNumber, writer);
                if (hasHtmlCodeInNumber) {
                    writer.println("Fail: Figure Number contains HTML code: " + hasHtmlCodeInNumber);
                    System.out.println("Fail: Figure Number contains HTML code: " + hasHtmlCodeInNumber);
                } else {
                    writer.println("Pass: Figure Number does not contain HTML code");
                    System.out.println("Pass: Figure Number does not contain HTML code");
                }
            }

            if (!figureTitle.isEmpty()) {
                writer.println("Log: Figure Title: " + figureTitle);
                System.out.println("Log: Figure Title: " + figureTitle);
                boolean hasHtmlCodeInTitle = hasHtmlCode(figureTitle, writer);
                if (hasHtmlCodeInTitle) {
                    writer.println("Fail: Figure Title contains HTML code: " + hasHtmlCodeInTitle);
                    System.out.println("Fail: Figure Title contains HTML code: " + hasHtmlCodeInTitle);
                } else {
                    writer.println("Pass: Figure Title does not contain HTML code");
                    System.out.println("Pass: Figure Title does not contain HTML code");
                }
            }
        } catch (NoSuchElementException e) {
            writer.println("Pass: Generic label-Figure Number and Title not present.");
            System.out.println("Pass: Generic label-Figure Number and Title not present.");
        } catch (Exception ex) {
            ex.printStackTrace();
            writer.println("Fail: Error extracting figure heading-Generic Label: " + ex.getMessage());
            System.out.println("Fail: Error extracting figure heading-Generic Label: " + ex.getMessage());
        }
        return null;
    }

    public void extractFigureComponentLabelHeading(WebElement imageElement, PrintWriter writer) {
        try {
            WebElement figureTitleElement;
            WebElement figureNumberElement;

            try {
                figureNumberElement = imageElement.findElement(By.xpath("./ancestor::div[@class='stage-element spf-rce-element spf-element-image']//h4[@class='component-label-section']//span[@class='component-label']/p"));
                figureTitleElement = imageElement.findElement(By.xpath("./ancestor::div[@class='stage-element spf-rce-element spf-element-image']//h4[@class='component-label-section']//span[@class='component-title']//p"));
            } catch (NoSuchElementException e1) {
                try {
                    figureNumberElement = imageElement.findElement(By.xpath("./ancestor::div[@class='stage-element spf-rce-element spf-element-image']//h4[@class='component-label-section']//span[@class='component-label']"));
                    figureTitleElement = imageElement.findElement(By.xpath("./ancestor::div[@class='stage-element spf-rce-element spf-element-image']//h4[@class='component-label-section']//span[@class='component-title']"));
                } catch (NoSuchElementException e2) {
                    try {
                        figureNumberElement = imageElement.findElement(By.xpath("./ancestor::div[@class='stage-element spf-rce-element spf-element-image']//h4[@class='component-label-section']//span[@class='component-label']/p"));
                        figureTitleElement = null;
                    } catch (NoSuchElementException e3) {
                        try {
                            figureNumberElement = imageElement.findElement(By.xpath("./ancestor::div[@class='stage-element spf-rce-element spf-element-image']//h4[@class='component-label-section']//span[@class='component-label']"));
                            figureTitleElement = null;
                        } catch (NoSuchElementException e4) {
                            throw new NoSuchElementException("Pass: Component Label-Figure Number and Title not present.");
                        }
                    }
                }
            }

            String figureNumberText = (figureNumberElement != null) ? figureNumberElement.getText().trim() : "";
            String figureTitleText = (figureTitleElement != null) ? extractAndCleanTitle(figureTitleElement, writer) : "";

            if (!figureNumberText.isEmpty()) {
                writer.println("Log: Figure Number: " + figureNumberText);
                System.out.println("Log: Figure Number: " + figureNumberText);

                boolean hasHtmlCodeInNumber = hasHtmlCode(figureNumberText, writer);
                if (hasHtmlCodeInNumber) {
                    writer.println("Fail: Figure Number contains HTML code: " + hasHtmlCodeInNumber);
                    System.out.println("Fail: Figure Number contains HTML code: " + hasHtmlCodeInNumber);
                } else {
                    writer.println("Pass: Figure Number does not contain HTML code");
                    System.out.println("Pass: Figure Number does not contain HTML code");
                }
            }

            if (figureTitleElement != null) {
                if (!figureTitleText.isEmpty()) {
                    writer.println("Log: Figure Title: " + figureTitleText);
                    System.out.println("Log: Figure Title: " + figureTitleText);

                    boolean hasHtmlCodeInTitle = hasHtmlCode(figureTitleText, writer);
                    if (hasHtmlCodeInTitle) {
                        writer.println("Fail: Figure Title contains HTML code: " + hasHtmlCodeInTitle);
                        System.out.println("Fail: Figure Title contains HTML code: " + hasHtmlCodeInTitle);
                    } else {
                        writer.println("Pass: Figure Title does not contain HTML code");
                        System.out.println("Pass: Figure Title does not contain HTML code");
                    }
                }
            }

        } catch (NoSuchElementException e) {
            writer.println("Pass: Component Label-Figure Number and Title not present.");
            System.out.println("Pass: Component Label-Figure Number and Title not present.");
        } catch (Exception ex) {
            ex.printStackTrace();
            writer.println("Fail: Error extracting figure heading-Component Label: " + ex.getMessage());
            System.out.println("Fail: Error extracting figure heading-Component Label: " + ex.getMessage());
        }
    }

    private String extractAndCleanTitle(WebElement titleElement, PrintWriter writer) {
        try {
            String titleText = titleElement.getAttribute("innerHTML");
            String cleanText;
            cleanText = Jsoup.parse(titleText).text();
            return cleanText;
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    private String removeInvisibleCharacters(String text, PrintWriter writer) {
        return text.replaceAll("[\\p{C}\\p{Z}]+", " ").trim();
    }


    private static void outputTextDifferences(String text1, String text2, PrintWriter writer) {
        try {
            String[] words1 = text1.split("\\s");
            String[] words2 = text2.split("\\s");

            int i = 0;
            while (i < words1.length) {
                if (!text2.contains(words1[i])) {
                    writer.println(words1[i] + " is not present in LightBox Caption");
                    System.out.println(words1[i] + " is not present in LightBox Caption");
                }
                i++;
            }
        } catch (Exception e) {
            writer.println("Fail: Error in outputTextDifferences: " + e.getMessage());
            System.out.println("Fail: Error in outputTextDifferences: " + e.getMessage());
        }
    }

    public String extractFigCaption(WebElement imageElement, PrintWriter writer) {
        try {
            WebElement figCaptionElement = imageElement.findElement(By.xpath("./ancestor::figure//figcaption[@class='component-caption']"));
            return extractAndCleanCaption(figCaptionElement, writer);
        } catch (NoSuchElementException e) {
            try {
                WebElement creditElement = imageElement.findElement(By.xpath("./ancestor::figure//div[@class='component-credit']"));
                return extractAndCleanCaption(creditElement, writer);
            } catch (NoSuchElementException ex) {
                try {
                    WebElement captionElement = imageElement.findElement(By.xpath("./ancestor::div[contains(@class, 'spf-element-image')]/following-sibling::div[contains(@class, 'spf-element-text') and contains(@class, 'p_caption')]//p"));
                    return extractAndCleanCaption(captionElement, writer);
                } catch (NoSuchElementException exception) {
                    try {
                        WebElement pCreditElement = imageElement.findElement(By.xpath("./ancestor::div[contains(@class, 'spf-element-image')]/following-sibling::div[contains(@class, 'spf-element-text') and contains(@class, 'p_credit')]//p"));
                        return extractAndCleanCaption(pCreditElement, writer);
                    } catch (NoSuchElementException exc) {
                        return "";
                    }
                }
            }
        }
    }


    private String extractAndCleanCaption(WebElement captionElement, PrintWriter writer) {
        try {
            String captionText = captionElement.getAttribute("innerHTML");
            boolean containsMathML = captionText.contains("MathJax_SVG") || captionText.contains("math/mml");
            String cleanText = processCaptionText(captionText, containsMathML, writer);

            writer.println("Figure Caption: " + cleanText);
            System.out.println("Figure Caption: " + cleanText);

            if (containsMathML) {
                writer.println("Log: Figure Caption contains MathML");
                System.out.println("Log: Figure Caption contains MathML");

            } else {
                writer.println("Log: Figure Caption does not contain MathML");
                System.out.println("Log: Figure Caption does not contain MathML");
            }
            boolean hasHtmlCode = hasHtmlCode(cleanText, writer);

            if (hasHtmlCode) {
                writer.println("Fail: Figure Caption contains HTML code: " + hasHtmlCode);
                System.out.println("Fail: Figure Caption contains HTML code: " + hasHtmlCode);
            } else {
                writer.println("Pass: Figure Caption does not contain HTML code");
                System.out.println("Pass: Figure Caption does not contain HTML code");
            }


            return cleanText;
        } catch (NoSuchElementException e) {
            writer.println("Error extracting caption: " + e.getMessage());
            System.out.println("Error extracting caption: " + e.getMessage());
            return "";
        }
    }


    private int skippedMathMLHandlingCount = 0;

    private String processCaptionText(String captionText, boolean containsMathML, PrintWriter writer) {
        if (containsMathML) {
            boolean handled = false;
            String originalCaption = captionText;
            captionText = handleMfencedTags(captionText);
            if (!originalCaption.equals(captionText)) {
                handled = true;
            }

            captionText = handleMsqrtTag(captionText);
            if (!originalCaption.equals(captionText)) {
                handled = true;
            }

            captionText = handleMfracTag(captionText);
            if (!originalCaption.equals(captionText)) {
                handled = true;
            }

            if (handled) {
            } else {
                skippedMathMLHandlingCount++;
                writer.println("Log: Image contains MathMl expressions beyond ([],(),/,√). Recommended to check this image manually.");
                System.out.println("Log: Image contains MathMl expressions beyond ([],(),/,√). Recommended to check this image manually.");

            }
        }
        String cleanText;
        cleanText = Jsoup.parse(captionText).text();
        return cleanText;
    }


    private String handleMfencedTags(String captionText) {
        if (captionText.contains("<mfenced>")) {
            if (captionText.contains("<mfenced>") && !captionText.contains("open=") && !captionText.contains("close=")) {
                captionText = captionText.replace("<mfenced>", "(").replace("</mfenced>", ")");
            } else if (captionText.contains("<mfenced") && captionText.contains("open=") && captionText.contains("close=")) {
                String openAttr = extractAttributeValue(captionText, "open");
                String closeAttr = extractAttributeValue(captionText, "close");
                if (captionText.contains("mfenced>") && captionText.contains("</mfenced>")) {
                    captionText = captionText.replace("<mfenced open=\"" + openAttr + "\" close=\"" + closeAttr + "\">", openAttr)
                            .replace("</mfenced>", closeAttr);
                } else {
                    captionText = captionText.replace("<mfenced open=\"" + openAttr + "\" close=\"" + closeAttr + "\">", "(" + openAttr + ")")
                            .replace("</mfenced>", closeAttr);
                }
            } else if (captionText.contains("<mfenced>") && captionText.contains("</mfenced>") && !captionText.contains("open=") && !captionText.contains("close=")) {
                captionText = captionText.replace("<mfenced>", "(").replace("</mfenced>", ")");
            }
        }
        return captionText;
    }


    private String handleMsqrtTag(String captionText) {
        if (captionText.contains("<msqrt>")) {
            captionText = captionText.replace("<msqrt>", "√").replace("</msqrt>", "");
        }
        return captionText;
    }

    private String handleMfracTag(String captionText) {
        if (captionText.contains("<mfrac>")) {
            captionText = replaceMfracWithFraction(captionText);
        }
        return captionText;
    }

    private String replaceMfracWithFraction(String captionText) {
        String[] fractions = captionText.split("<mfrac>");
        StringBuilder replacedText = new StringBuilder();
        for (String fraction : fractions) {
            if (fraction.contains("</mfrac>")) {
                String[] parts = fraction.split("</mfrac>");
                String[] numsAndDenoms = parts[0].trim().split("<mn>");

                if (numsAndDenoms.length == 3) {
                    String numerator = numsAndDenoms[1].split("</mn>")[0];
                    String denominator = numsAndDenoms[2].split("</mn>")[0];
                    replacedText.append(numerator).append("/").append(denominator);
                } else {
                    replacedText.append(fraction);
                }
                replacedText.append(parts[1].trim());
            } else {
                replacedText.append(fraction);
            }
        }
        return replacedText.toString();
    }


    private String extractAttributeValue(String input, String attributeName) {
        String attribute = attributeName + "=\"";
        int startIndex = input.indexOf(attribute) + attribute.length();
        int endIndex = input.indexOf("\"", startIndex);
        return input.substring(startIndex, endIndex);
    }

    private boolean hasHtmlCode(String text, PrintWriter writer) {
        return text.matches(".*<.*>.*") && !text.contains("mathml") && !text.matches(".*[^a-zA-Z0-9\\s].*");
    }


    public String extractFigCaptionFromLightbox(PrintWriter writer, String figureCaptionBeforeClick, String figCaptionBeforeClick) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement lightboxElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'show-caption')]")));
            WebElement lightboxCaptionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'caption-scroll')]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lightboxCaptionElement);
            List<WebElement> lightboxParagraphs = lightboxCaptionElement.findElements(By.xpath(".//p"));
            StringBuilder lightboxCaptionTextBuilder = new StringBuilder();
            for (WebElement paragraph : lightboxParagraphs) {
                lightboxCaptionTextBuilder.append(paragraph.getText().trim()).append("\n");
            }

            String lightboxCaptionText = lightboxCaptionTextBuilder.toString().trim();
            boolean hasHtmlCode = lightboxCaptionText.contains("<") && lightboxCaptionText.contains(">");
            boolean captionsMatch = false;

            if (figureCaptionBeforeClick.equals(lightboxCaptionText)) {
                captionsMatch = true;
            } else {

                if (removeInvisibleCharacters(figCaptionBeforeClick, writer).equals(removeInvisibleCharacters(lightboxCaptionText, writer))) {
                    writer.println("Pass: Lightbox Figure Caption: " + lightboxCaptionText + ",figure caption matches!");
                    System.out.println("Pass: Lightbox Figure Caption: " + lightboxCaptionText + ",figure caption matches!");
                } else {
                    writer.println("Fail: Lightbox Figure Caption: " + lightboxCaptionText + ",Figure captions do not match!");
                    System.out.println("Fail: Lightbox Figure Caption: " + lightboxCaptionText + ",Figure captions do not match!");
                    outputTextDifferences(figureCaptionBeforeClick, lightboxCaptionText, writer);
                }
            }

            if (captionsMatch) {
                writer.println("Pass: Lightbox Figure Caption: " + lightboxCaptionText + ", figure caption matches!");
                System.out.println("Pass: Lightbox Figure Caption: " + lightboxCaptionText + ", figure caption matches!");
            }
            if (hasHtmlCode) {
                writer.println("Fail: Lightbox Figure Caption contains HTML code.");
                System.out.println("Fail: Lightbox Figure Caption contains HTML code.");
            } else {
                writer.println("Pass: Lightbox Figure Caption does not contain HTML code.");
                System.out.println("Pass: Lightbox Figure Caption does not contain HTML code.");
            }

            return lightboxCaptionText;
        } catch (TimeoutException | NoSuchElementException e) {
            return "";
        } catch (Exception ex) {
            ex.printStackTrace();
            writer.println("Fail: Error extracting Lightbox Figure Caption: " + ex.getMessage());
            System.out.println("Fail: Error extracting Lightbox Figure Caption: " + ex.getMessage());
            return "";
        }
    }

    public void clickZoomInBtn(PrintWriter writer) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            WebElement zoomInBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_zoomIn));
            String ariaLabel = zoomInBtn.getAttribute("aria-label");
            writer.println("Pass: Zoom In Button Aria Label: " + ariaLabel);
            System.out.println("Pass: Zoom In Button Aria Label: " + ariaLabel);
            Actions actions = new Actions(driver);
            actions.click(zoomInBtn).perform();

            updateTransformProperty(writer);
        } catch (TimeoutException e) {
            writer.println("Fail: Timeout waiting for Zoom In button to be clickable.");
            System.out.println("Fail: Timeout waiting for Zoom In button to be clickable.");
        } catch (StaleElementReferenceException e) {
            writer.println("Fail: Zoom In button is stale and not attached to the DOM.");
            System.out.println("Fail: Zoom In button is stale and not attached to the DOM.");
        } catch (Exception e) {
            writer.println("Fail: Error clicking Zoom In button: " + e.getMessage());
            System.out.println("Fail: Error clicking Zoom In button: " + e.getMessage());
        }
    }



    public void clickZoomOutBtn(PrintWriter writer) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement zoomOutBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_zoomOut));
            String ariaLabel = zoomOutBtn.getAttribute("aria-label");
            writer.println("Pass: Zoom Out Button Aria Label: " + ariaLabel);
            System.out.println("Pass: Zoom Out Button Aria Label: " + ariaLabel);
            Actions actions = new Actions(driver);
            actions.click(zoomOutBtn).perform();
            updateTransformProperty(writer);
        } catch (TimeoutException e) {
            writer.println("Fail: Timeout waiting for Zoom Out button to be clickable.");
            System.out.println("Fail: Timeout waiting for Zoom Out button to be clickable.");
        } catch (StaleElementReferenceException e) {
            writer.println("Fail: Zoom Out button is stale and not attached to the DOM.");
            System.out.println("Fail: Zoom Out button is stale and not attached to the DOM.");
        } catch (Exception e) {
            writer.println("Fail: Error clicking Zoom Out button: " + e.getMessage());
            System.out.println("Fail: Error clicking Zoom Out button: " + e.getMessage());
        }
    }


    private void updateTransformProperty(PrintWriter writer) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            WebElement imgElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.img-zoom-move")));
            String transformValue = imgElement.getAttribute("style");
            if (transformValue != null && transformValue.contains("transform")) {
                int startIndex = transformValue.indexOf("transform:");
                int endIndex = transformValue.indexOf(";", startIndex);
                if (endIndex == -1) {
                    endIndex = transformValue.length();
                }
                transformValue = transformValue.substring(startIndex, endIndex);
                writer.println("Pass: Transform Property: " + transformValue);
                System.out.println("Pass: Transform Property: " + transformValue);
            } else {
                writer.println("Fail: Transform Property not found");
                System.out.println("Fail: Transform Property not found");
            }
        } catch (Exception e) {
            writer.println("Fail: Error updating transform property: " + e.getMessage());
            System.out.println("Fail: Error updating transform property: " + e.getMessage());
        }
    }

    public void clickImageCloseBtn(PrintWriter writer) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            WebElement closeBtn1 = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_ImageClose));
            closeBtn1.click();

            writer.println("Pass: Image close button clicked successfully.");
            System.out.println("Pass: Image close button clicked successfully.");
        } catch (TimeoutException | NoSuchElementException e) {
            writer.println("Fail: Image close button not found or not clickable.");
            System.out.println("Fail: Image close button not found or not clickable.");
        }
    }

    /**
     *  External references: Check if external links open to a secure website
     **/

    static List<String> reachableLinks = new ArrayList<>();
    static List<String> notReachableLinks = new ArrayList<>();

    public void extractAllLinksFromRightSide() {

        int totalHrefLinks = 0;
        int totalPatternLinks = 0;

        try (PrintWriter writer = new PrintWriter(new FileWriter("CWQA", true))) {
            driver.manage().timeouts().setScriptTimeout(20, TimeUnit.HOURS);
            waitUntilElementVisible(expandContainerLocator, 100);
            List<WebElement> expandContainers = driver.findElements(expandContainerLocator);
            int totalExpandContainers = expandContainers.size();
            writer.println("*************************************************************************************");
            writer.println("Total Parent Expand Containers (Main Menu) on this book: " + totalExpandContainers);
            System.out.println("*************************************************************************************");
            System.out.println("Total Parent Expand Containers (Main Menu) on this book: " + totalExpandContainers);

            for (int page = 0; page < totalExpandContainers; page++) {
                WebElement expandContainer = expandContainers.get(page);
                writer.println("*************************************************************************************");
                writer.println("Navigating to Page " + (page + 1) + ": " + expandContainer.getText());
                System.out.println("*************************************************************************************");
                System.out.println("Navigating to Page " + (page + 1) + ": " + expandContainer.getText());
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", expandContainer);
                expandContainer.click();
                writer.println("Clicked on parent (Main Menu) element: " + expandContainer.getText());
                System.out.println("Clicked on parent (Main Menu) element: " + expandContainer.getText());

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                List<WebElement> childElements = expandContainer.findElements(childElementLocator);

                int totalHrefLinksOnPage = 0;
                for (WebElement childElement : childElements) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", childElement);
                    childElement.click();
                    writer.println("*************************************************************************************");
                    writer.println("Clicked on child (Sub Menu) element: " + childElement.getText());
                    System.out.println("*************************************************************************************");
                    System.out.println("Clicked on child (Sub Menu) element: " + childElement.getText());
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    writer.println("Current page: " + childElement.getText());
                    writer.println("---------------------------------------------------------------------------------------------");
                    System.out.println("Current page: " + childElement.getText());
                    System.out.println("---------------------------------------------------------------------------------------------");

                    totalHrefLinksOnPage = 0;

                    boolean externalLinksFound = false;
                    switchToIframeContainer();
                    try {
                        List<WebElement> externalLinks = driver.findElements(By.cssSelector(".stage-element a[target='_blank']"));
                        for (WebElement externalLink : externalLinks) {
                            String linkText = externalLink.getText();
                            String href = externalLink.getAttribute("href");
                            if (linkText.startsWith("http") || linkText.startsWith("www")) {
                                writer.println("Log: External Link Text: " + linkText);
                                System.out.println("Log: External Link Text: " + linkText);
                                writer.println("Log: External Link Href:  " + href);
                                System.out.println("Log: External Link Href: " + href);
                                checkExternalLinkForHref(href, writer);
                                totalHrefLinks++;
                                totalHrefLinksOnPage++;
                                externalLinksFound = true;
                            }
                        }
                        if (!externalLinksFound) {
                            extractLinksUsingPattern(writer);
                            totalPatternLinks += linksUsingPatternCount;
                        }

                    } catch (TimeoutException e) {
                        writer.println("No href links or links using pattern found on this page. Moving to the next page.");
                        writer.println("---------------------------------------------------------------------------------------------");
                        System.out.println("No href links or links using pattern found on this page. Moving to the next page.");
                        System.out.println("---------------------------------------------------------------------------------------------");
                    } finally {
                        driver.switchTo().defaultContent();
                    }

                    writer.println("Total Href Links on this page: " + totalHrefLinksOnPage);
                    System.out.println("Total Href Links on this page: " + totalHrefLinksOnPage);

                    if (totalHrefLinksOnPage == 0 && linksUsingPatternCount == 0) {
                        writer.println("No href links or links using pattern found on this page. Moving to the next page.");
                        writer.println("---------------------------------------------------------------------------------------------");
                        System.out.println("No href links or links using pattern found on this page. Moving to the next page.");
                        System.out.println("---------------------------------------------------------------------------------------------");
                    }
                    ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
                }
            }

            writer.println("*************************************************************************************");
            writer.println("Total Href Links in the Ebook: " + totalHrefLinks);
            writer.println("Total Links Extracted using pattern in the Ebook: " + totalPatternLinks);
            writer.println("*************************************************************************************");
            System.out.println("*************************************************************************************");
            System.out.println("Total Href Links in the Ebook: " + totalHrefLinks);
            System.out.println("Total Links Extracted using pattern in the Ebook: " + totalPatternLinks);
            System.out.println("*************************************************************************************");

            writer.println("Total Reachable Links in the Ebook: " + reachableLinks.size());
            writer.println("Total Not Reachable Links in the Ebook: " + notReachableLinks.size());

            System.out.println("Total Reachable Links in the Ebook: " + reachableLinks.size());
            System.out.println("Total Not Reachable Links in the Ebook: " + notReachableLinks.size());
            System.out.println("*************************************************************************************");
            writer.println("*************************************************************************************");



            if (!notReachableLinks.isEmpty()) {
                writer.println("Not Reachable Links:");
                System.out.println("Not Reachable Links:");
                for (String notReachableLink : notReachableLinks) {
                    writer.println(notReachableLink);
                    System.out.println(notReachableLink);
                    System.out.println("*************************************************************************************");
                    writer.println("*************************************************************************************");
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void extractLinksUsingPattern(PrintWriter writer) throws InterruptedException, IOException {
        this.linksUsingPatternCount = 0;
        StringBuilder rightSideText = new StringBuilder();
        List<WebElement> rightSideTextElements = driver.findElements(rightSideTextLocator);

        for (WebElement rightSideTextElement : rightSideTextElements) {
            String text = rightSideTextElement.getText();
            String linkPattern = "\\b(?:https?://|www\\.)\\S+\\b";

            Pattern r = Pattern.compile(linkPattern);
            Matcher m = r.matcher(text);

            while (m.find()) {
                String link = m.group();
                rightSideText.append(link).append("\n");

                if (link.startsWith("http") || link.startsWith("www")) {
                    System.out.println("Log: External Reference Link using pattern: " + link);
                    writer.println("Log: External Reference Link using pattern: " + link);
                    Thread.sleep(5000);
                    checkExternalLinkForLinkPattern(link, writer);
                    this.linksUsingPatternCount++;
                }
            }

            String emailPattern = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b";
            Matcher emailMatcher = Pattern.compile(emailPattern).matcher(text);
            while (emailMatcher.find()) {
                String email = emailMatcher.group();
                writer.println("Log: Email Link: " + email);
                System.out.println("Log: Email Link: " + email);
                Thread.sleep(5000);
                System.out.println("mailto:" + email);
                writer.println("mailto:" + email);
                checkExternalLinkForLinkPattern("mailto:" + email, writer);
                this.linksUsingPatternCount++;
            }
        }
        System.out.println();
        System.out.println("Total Links Extracted using pattern on this page: " + this.linksUsingPatternCount);
        writer.println();
        writer.println("Total Links Extracted using pattern on this page: " + this.linksUsingPatternCount);
    }

    public static void checkExternalLinkForHref(String link, PrintWriter writer) throws IOException, InterruptedException {
        int maxRetries = 3;

        if (link == null || link.isEmpty()) {
            writer.println("Fail: External Link is not reachable: Href is empty");
            System.out.println("Fail: External Link is not reachable: Href is empty");
            writer.println();
            System.out.println();
            notReachableLinks.add(link);
            return;
        }

        for (int attempt = 1; attempt <= maxRetries; attempt++) {
            try {
                URL url = new URL(link);

                disableSSLCertificateValidation();

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setConnectTimeout(10000);
                connection.setReadTimeout(10000);
                connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");
                connection.setRequestMethod("GET");

                int responseCode = connection.getResponseCode();

                if (responseCode == HttpURLConnection.HTTP_OK) {
                    writer.println("Pass: External Link is reachable: " + link);
                    System.out.println("Pass: External Link is reachable: " + link);
                    writer.println();
                    System.out.println();
                    reachableLinks.add(link);
                } else if (responseCode == HttpURLConnection.HTTP_MOVED_PERM || responseCode == HttpURLConnection.HTTP_MOVED_TEMP ||
                        responseCode == HttpURLConnection.HTTP_SEE_OTHER || responseCode == 307 ||
                        responseCode == 308) {

                    String newLocation = connection.getHeaderField("Location");
                    writer.println("Log: Redirecting to: " + newLocation);
                    System.out.println("Log: Redirecting to: " + newLocation);

                    if (!newLocation.startsWith("http://") && !newLocation.startsWith("https://")) {
                        URL originalUrl = new URL(link);
                        URL absoluteUrl = new URL(originalUrl, newLocation);
                        newLocation = absoluteUrl.toString();
                    }
                    checkExternalLinkForHref(newLocation, writer);
                } else if (responseCode == HttpURLConnection.HTTP_FORBIDDEN) {
                    System.out.println("Pass: External Link is reachable, but access is forbidden(403): " + link);
                    System.out.println();
                    writer.println("Pass: External Link is reachable, but access is forbidden(403): " + link);
                    writer.println();
                    reachableLinks.add(link);

                } else if (responseCode == HttpURLConnection.HTTP_UNAUTHORIZED) {
                    System.out.println("Pass: External Link is reachable, but authentication is required(401): " + link);
                    System.out.println();
                    writer.println("Pass: External Link is reachable, but authentication is required(401): " + link);
                    writer.println();
                    reachableLinks.add(link);


                } else if (responseCode == 429) {
                    System.out.println("Log: Too Many Requests (429) for link: " + link);
                    writer.println("Log: Too Many Requests (429) for link: " + link);

                    String googleSearchResult = performGoogleSearch(link);
                    if (googleSearchResult.contains("No results found")) {
                        System.out.println("Fail: Google search indicates that the link is not reachable: " + link);
                        writer.println("Fail: Google search indicates that the link is not reachable: " + link);
                        System.out.println();
                        writer.println();
                        notReachableLinks.add(link);
                    } else {
                        System.out.println("Pass: Google search indicates that the link is reachable: " + link);
                        writer.println("Pass: Google search indicates that the link is reachable: " + link);
                        System.out.println();
                        writer.println();
                        reachableLinks.add(link);
                    }
                } else if (responseCode == 400) {
                    System.out.println("Log: External Link is not reachable (HTTP 400 error): " + link);
                    writer.println("Log: External Link is not reachable (HTTP 400 error): " + link);
                    System.out.println("Log: Trying with trimmed white spaces");
                    writer.println("Log: Trying with trimmed white spaces");

                    String trimmedLink = link.replaceAll("\\s+", "").trim();
                    checkExternalLinkForHref(trimmedLink, writer);
                } else {
                    System.out.println("Fail: External Link is not reachable: " + link);
                    writer.println("Fail: External Link is not reachable: " + link);
                    System.out.println("Reason: " + getResponseStatusMessage(responseCode));
                    writer.println("Reason: " + getResponseStatusMessage(responseCode));
                    writer.println();
                    System.out.println();
                    notReachableLinks.add(link);
                }
                connection.disconnect();
                Thread.sleep(5000);
                break;
            } catch (SocketTimeoutException e) {
                if (attempt < maxRetries) {
                    System.out.println("Log: Timeout Exception for link (Attempt " + attempt + "): " + link);
                    writer.println("Log: Timeout Exception for link (Attempt " + attempt + "): " + link);
                    Thread.sleep(5000);
                } else {
                    System.out.println("Fail: External Link is not Reachable after " + maxRetries + " attempts: " + link);
                    writer.println("Fail: External Link is not Reachable after " + maxRetries + " attempts: " + link);
                    writer.println();
                    System.out.println();
                    notReachableLinks.add(link);
                }
            } catch (Exception e) {
                System.out.println("Fail: External Link is not Reachable, Exception while checking external link: " + e.getMessage());
                System.out.println();
                writer.println("Fail: External Link is not Reachable, Exception while checking external link: " + e.getMessage());
                writer.println();
                notReachableLinks.add(link);

            }
        }
    }


    public static void checkExternalLinkForLinkPattern(String link, PrintWriter writer) throws IOException, InterruptedException {
        int maxRetries = 3;

        for (int attempt = 1; attempt <= maxRetries; attempt++) {
            try {
                if (!link.startsWith("http://") && !link.startsWith("https://")) {
                    link = "https://" + link;
                }

                URL url = new URL(link);

                disableSSLCertificateValidation();

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setConnectTimeout(10000);
                connection.setReadTimeout(10000);
                connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");
                connection.setRequestMethod("GET");

                int responseCode = connection.getResponseCode();

                if (responseCode == HttpURLConnection.HTTP_OK) {
                    System.out.println("Pass: External Link is reachable: " + link);
                    System.out.println();
                    writer.println("Pass: External Link is reachable: " + link);
                    writer.println();
                    reachableLinks.add(link);
                } else if (responseCode == HttpURLConnection.HTTP_MOVED_PERM || responseCode == HttpURLConnection.HTTP_MOVED_TEMP ||
                        responseCode == HttpURLConnection.HTTP_SEE_OTHER || responseCode == 307 ||
                        responseCode == 308) {

                    String newLocation = connection.getHeaderField("Location");
                    System.out.println("Log: Redirecting to: " + newLocation);
                    writer.println("Log: Redirecting to: " + newLocation);

                    if (!newLocation.startsWith("http://") && !newLocation.startsWith("https://")) {
                        URL originalUrl = new URL(link);
                        URL absoluteUrl = new URL(originalUrl, newLocation);
                        newLocation = absoluteUrl.toString();
                    }
                    checkExternalLinkForLinkPattern(newLocation, writer);
                } else if (responseCode == HttpURLConnection.HTTP_FORBIDDEN) {
                    System.out.println("Pass: External Link is reachable, but access is forbidden(403): " + link);
                    System.out.println();
                    writer.println("Pass: External Link is reachable, but access is forbidden(403): " + link);
                    writer.println();
                    reachableLinks.add(link);
                } else if (responseCode == HttpURLConnection.HTTP_UNAUTHORIZED) {
                    System.out.println("Pass: External Link is reachable, but authentication is required(401): " + link);
                    System.out.println();
                    writer.println("Pass: External Link is reachable, but authentication is required(401): " + link);
                    writer.println();
                    reachableLinks.add(link);
                } else if (responseCode == 429) {
                    System.out.println("Log: Too Many Requests (429) for link: " + link);
                    writer.println("Log: Too Many Requests (429) for link: " + link);
                    String googleSearchResult = performGoogleSearch(link);
                    if (googleSearchResult.contains("No results found")) {
                        System.out.println("Fail: Google search indicates that the link is not reachable: " + link);
                        writer.println("Fail: Google search indicates that the link is not reachable: " + link);
                        System.out.println();
                        writer.println();
                        notReachableLinks.add(link);
                    } else {
                        System.out.println("Pass: Google search indicates that the link is reachable: " + link);
                        writer.println("Pass: Google search indicates that the link is reachable: " + link);
                        System.out.println();
                        reachableLinks.add(link);
                    }
                } else if (responseCode == 400) {
                    System.out.println("Log: External Link is not reachable (HTTP 400 error): " + link);
                    writer.println("Log: External Link is not reachable (HTTP 400 error): " + link);
                    System.out.println("Log: Trying with trimmed white spaces");
                    writer.println("Log: Trying with trimmed white spaces");
                    String trimmedLink = link.replaceAll("\\s+", "").trim();
                    checkExternalLinkForLinkPattern(trimmedLink, writer);
                } else {
                    System.out.println("Fail: External Link is not reachable, May be link was not extracted completely using link pattern for checking reachability: " + link);
                    writer.println("Fail: External Link is not reachable, May be link was not extracted completely using link pattern for checking reachability: " + link);
                    System.out.println("Reason: " + getResponseStatusMessage(responseCode));
                    writer.println("Reason: " + getResponseStatusMessage(responseCode));
                    System.out.println();
                    writer.println();
                    notReachableLinks.add(link);
                }
                connection.disconnect();
                Thread.sleep(5000);
                break;
            } catch (SocketTimeoutException e) {
                if (attempt < maxRetries) {
                    System.out.println("Log: Timeout Exception for link (Attempt " + attempt + "): " + link);
                    writer.println("Log: Timeout Exception for link (Attempt " + attempt + "): " + link);
                    Thread.sleep(5000);
                } else {
                    System.out.println("Fail: External Link is not Reachable after " + maxRetries + " attempts: " + link);
                    System.out.println();
                    writer.println("Fail: External Link is not Reachable after " + maxRetries + " attempts: " + link);
                    writer.println();
                    notReachableLinks.add(link);
                }
            } catch (Exception e) {
                System.out.println("Fail: External Link is not Reachable, Exception while checking external link: " + e.getMessage());
                writer.println("Fail: External Link is not Reachable, Exception while checking external link: " + e.getMessage());
                writer.println();
                System.out.println();
                notReachableLinks.add(link);
            }
        }
    }

    private static String getResponseStatusMessage(int responseCode) {
        switch (responseCode) {
            case HttpURLConnection.HTTP_NOT_FOUND:
                return "Not Found (404)";
            case HttpURLConnection.HTTP_UNAUTHORIZED:
                return "Unauthorized (401)";
            default:
                return "HTTP Response Code: " + responseCode;
        }
    }

    private static void disableSSLCertificateValidation() {
        try {
            TrustManager[] trustAll = new TrustManager[]{new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }

                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            }};

            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAll, new java.security.SecureRandom());

            HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String performGoogleSearch(String query) throws IOException {
        URLConnection connection = new URL("https://www.google.com/search?q=" + query).openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);
        connection.connect();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            Thread.sleep(5000);
            return sb.toString();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



    public void handleBookDetails(String expectedBookTitle, String expectedBookAuthor) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter("CWQA", true))) {

            try {
                String bookTitle = getTextFromElement(bookTitleLocator);
                String bookAuthor = getTextFromElement(bookAuthorLocator);
                writer.println("Book Title: " + bookTitle);
                writer.println("Book Author: " + bookAuthor);

                if (!bookTitle.isEmpty() && !bookAuthor.isEmpty()) {
                    if (bookTitle.equals(expectedBookTitle) && bookAuthor.equals(expectedBookAuthor)) {
                        System.out.println("Book title and author matched!");
                        writer.println("Book title and author matched!");
                    } else {
                        System.out.println("Book details did not match. Expected Title: " +
                                expectedBookTitle + ", Actual Title: " + bookTitle +
                                ", Expected Author: " + expectedBookAuthor + ", Actual Author: " + bookAuthor);
                        writer.println("Book details did not match. Expected Title: " +
                                expectedBookTitle + ", Actual Title: " + bookTitle +
                                ", Expected Author: " + expectedBookAuthor + ", Actual Author: " + bookAuthor);
                    }
                } else {
                    System.out.println("Book details could not be retrieved.");
                    writer.println("Book details could not be retrieved.");
                }
            } catch (Exception e) {
                System.out.println("Exception occurred while handling book details: " + e.getMessage());
                writer.println("Exception occurred while handling book details: " + e.getMessage());
            }
        }
    }
    public void switchToIframeContainer() {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.presenceOfElementLocated(switchToIframe));

        WebElement iframeElement = driver.findElement(switchToIframe);
        driver.switchTo().frame(iframeElement);
    }

    public void scrollIntoView(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
