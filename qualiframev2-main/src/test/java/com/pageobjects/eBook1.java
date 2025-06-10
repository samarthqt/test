package com.pageobjects;

import com.framework.reusable.WebReusableComponents;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.*;

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
    protected By rightSideTextLocator = By.cssSelector(".spf-rce-element.spf-element-text h1, .spf-rce-element.spf-element-text h2, .spf-rce-element.spf-element-text h3, .spf-rce-element.spf-element-text h4, .spf-rce-element.spf-element-text p, .spf-rce-element.spf-element-text blockquote, .spf-rce-element-table table, .stage-element.spf-rce-element h4.component-label-section span.component-title p");

    public eBook1() {
        PageFactory.initElements(driver, this);
    }

    public void launchApp(String url) {
        launchUrl(url);
        maximizeWindow();
    }

    public void clickAcceptAllBtn() {
        waitUntilElementVisible(btn_CookieAcceptAll, 20);
        clickElement(btn_CookieAcceptAll);
    }

    public void enterUserNameTxt(String username) {
        waitUntilElementVisible(txt_UserName, 3);
        enterText(txt_UserName, username);
    }

    public void enterPasswordTxt(String password) {
        waitUntilElementVisible(txt_Password, 3);
        enterText(txt_Password, password);
    }

    public void clickSignInBtn() {
        waitUntilElementVisible(btn_SignIn, 3);
        clickElement(btn_SignIn);
    }

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
                    System.out.println("Total images on current page: " + totalImagesOnPage);
                    writer.println("Total images on current page: " + totalImagesOnPage);

                    for (WebElement imageElement : imageElements) {
                        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", imageElement);
                        imageElement.click();
                        writer.println("Clicked on image: " + imageElement.getAttribute("alt"));
                        System.out.println("Clicked on image: " + imageElement.getAttribute("alt"));

                        clickImageCloseBtn();
                    }
                } catch (TimeoutException e) {
                    System.out.println("No images found on current page.");
                    writer.println("No images found on current page.");
                }

                overallTotalImages += totalImagesOnPage;
            }
            writer.println("Overall total images extracted: " + overallTotalImages);
            System.out.println("Overall total images extracted: " + overallTotalImages);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clickImageCloseBtn() {
        waitUntilElementVisible(btn_ImageClose, 3);
        clickElement(btn_ImageClose);
    }

    public void clickZoomInBtn() {
        waitUntilElementVisible(btn_zoomIn, 3);
        clickElement(btn_zoomIn);
    }

    public void clickZoomOutBtn() {
        waitUntilElementVisible(btn_zoomOut, 3);
        clickElement(btn_zoomOut);
    }

    public void switchToIframeContainer() {
        driver.switchTo().frame(driver.findElement(switchToIframe));
    }

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public boolean hasHtmlCode(String text) {
        return text.contains("<") && text.contains(">");
    }

    public void extractFigureGenericLabelHeading() {
        // Implementation logic here
    }

    public void extractAndCleanTitle() {
        // Implementation logic here
    }

    public void disableSSLCertificateValidation() {
        // Implementation logic here
    }

    public void extractAndCleanCaption() {
        // Implementation logic here
    }

    public void extractAllImagesFromRightSide() {
        // Implementation logic here
    }

    public void checkServerTrusted() {
        // Implementation logic here
    }

    public void performGoogleSearch() {
        // Implementation logic here
    }

    public void outputTextDifferences() {
        // Implementation logic here
    }

    public void extractFigCaptionFromLightbox() {
        // Implementation logic here
    }

    public void getResponseStatusMessage() {
        // Implementation logic here
    }

    public void extractAllLinksFromRightSide() {
        // Implementation logic here
    }

    public void handleMfracTag() {
        // Implementation logic here
    }

    public void removeInvisibleCharacters() {
        // Implementation logic here
    }

    public void extractAttributeValue() {
        // Implementation logic here
    }

    public void handleMsqrtTag() {
        // Implementation logic here
    }

    public void checkExternalLinkForLinkPattern() {
        // Implementation logic here
    }

    public void checkExternalLinkForHref() {
        // Implementation logic here
    }

    public void getAcceptedIssuers() {
        // Implementation logic here
    }

    public void replaceMfracWithFraction() {
        // Implementation logic here
    }

    public void handleMfencedTags() {
        // Implementation logic here
    }

    public void extractLinksUsingPattern() {
        // Implementation logic here
    }

    public void checkClientTrusted() {
        // Implementation logic here
    }

    public void extractFigureComponentLabelHeading() {
        // Implementation logic here
    }

    public void processCaptionText() {
        // Implementation logic here
    }

    public void handleBookDetails() {
        // Implementation logic here
    }

    public void extractFigCaption() {
        // Implementation logic here
    }

    public void updateTransformProperty() {
        // Implementation logic here
    }
}