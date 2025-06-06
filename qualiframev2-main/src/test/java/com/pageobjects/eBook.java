package com.pageobjects;

import com.framework.components.ApplitoolsOperations;
import com.framework.reusable.WebReusableComponents;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.security.cert.X509Certificate;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.cucumber.steps.Hooks.i;


public class eBook extends WebReusableComponents {


    protected By btn_CookieAcceptAll = By.id("onetrust-accept-btn-handler");
    protected By txt_UserName = By.id("username");
    protected By txt_Password = By.id("password");
    protected By btn_SignIn = By.id("submitBttn");
    protected By btn_Home = By.xpath("(//button[@title='Home'])[1]");
    protected By pearsonHomeLogo = By.cssSelector(".pearson-logo");
    protected By homePageIdentifier = By.xpath("//div[@class='one-reader-maincontainer']");
    protected By btn_TableOfContent = By.cssSelector("div[title='Table of contents']:first-child");
    protected By btn_Content = By.xpath("((//span[normalize-space()='Contents'])[1])");

    protected By bookTitleLocator = By.xpath(".//h3[@class='drawer-book-title']");
    protected By bookAuthorLocator = By.xpath(".//div[@class='drawer-book-author']/span");
    protected By rightSideTextLocator = By.cssSelector(".spf-rce-element.spf-element-text h1, .spf-rce-element.spf-element-text h2, .spf-rce-element.spf-element-text h3, .spf-rce-element.spf-element-text h4, .spf-rce-element.spf-element-text p, .spf-rce-element.spf-element-text blockquote, .spf-rce-element.spf-element-table table, .stage-element.spf-rce-element h4.component-label-section span.component-title p");
    protected By switchToIframe = By.xpath("(//iframe[@id='contentIframe'])");
    protected By btn_DisplaySettings = By.xpath("(//div[@title='Display settings'])[1]");
    protected By btn_colorMode = By.className("colorSelector");
    protected By btn_IncreaseFontSize = By.xpath("//button[@aria-label='Increase size']");
    protected By btn_DecreaseFontSize = By.xpath("//button[@aria-label='Decrease size']");
    protected By btn_NavigationIcon = By.xpath("//div[@title='Navigation' and @aria-label='Scrubber Navigation']");
    protected By searchResultContainer = By.id("searchResultContainer");
    protected By btn_HideMenuOption = By.xpath("(//button[@aria-label='Hide Menu Options'])[2]");
    protected By txtLink_Container = By.xpath("(//div[contains(@class,'title')])[11]");
    protected By btn_Bookmark = By.xpath("//button[@aria-label='Add bookmark']");
    protected By Btn_RemoveBookmark = By.xpath("(//button[@aria-label='Remove Bookmark'])[1]");
    protected By Btn_RemoveAllBookmark = By.xpath("//button[contains(@aria-label,'Remove all bookmarks')]");
    protected By TxtLink_BookmarkNavigation = By.xpath("//span[normalize-space()='Bookmarks']");
    protected By arrow_RightNavigation = By.xpath("//button[contains(@aria-label, 'next page')]");
    protected By arrow_LeftNavigation = By.xpath("//button[contains(@aria-label, 'previous page')]");
    protected By txtLink_FrontMatter = By.xpath("(//div[contains(@class,'title')])[3]");
    protected By Btn_SearchIcon = By.xpath("//div[@title='Search' and @aria-label='Search']");
    protected By clickTextField_Search = By.xpath("(//div[@role='combobox'])[1]");
    protected By TxtField_Search = By.xpath("//input[@placeholder='Search']");
    protected By dropDownBtn_CB = By.xpath("//button[@id='vega-app-bar-overflow-menu']");
    protected By btn_SignOut = By.xpath("(//span[contains(text(),'Sign out')])[1]");
    protected By titleLogo = By.xpath("//div[@class='pearson-logo__wrapper']");
    protected By btn_ImageClose = By.xpath("(//div[@aria-label='Close']//*[name()='svg']//*[name()='path' and contains(@d,'M12 12c2.2')])");
    protected By btn_zoomIn = By.xpath("(//div[@aria-label='Zoomin'])[1]");
    protected By btn_zoomOut = By.xpath("(//div[@aria-label='Zoomout'])[1]");
    protected By txtLink_CopyRights = By.xpath("(//span[contains(text(),'Copyright')])[1]");
    protected By createNote = By.xpath("//span[contains(text(),'New note')]");
    protected By enterNotes = By.xpath("(//textarea[@id='note-add-edit-textarea'])[1]");
    protected By clickViewNote = By.xpath("(//span[normalize-space()='View'])[1]");
    protected By clickSaveNote = By.xpath("(//button[@id='savePopupBtn'])[1]");
    protected By expandContainerNotebook = By.xpath("(//div[contains(@class,'title')])[13]");
    protected By highlightsYellow = By.xpath("(//label[@aria-label='Yellow Highlight'])[1]");
    protected By btn_exportNote = By.cssSelector(".MuiButtonBase-root[aria-label='Export notes']");
    protected By btn_DeleteNote = By.xpath("//li[normalize-space()='Delete note']");
    protected By btn_Note = By.xpath("//div[@aria-label='Notebook']");
    protected By btn_3dot = By.xpath("//div/button[@role='menu']");
    protected By btn_NavigationIcon1 = By.xpath("//div[@aria-label='Scrubber Navigation']");
    protected By btn_FlashCard = By.xpath("//div[@aria-label='Flashcards' and @title='Flashcards']");
    protected By deckName = By.cssSelector("#deckNameTextAreaIdInPrepCreateDeckComponent");
    protected By btn_DeckNext = By.xpath("//button[normalize-space()='Next']");
    protected By deck_TextFront = By.xpath("//textarea[@id='frontTextAreaIdInPrepCreateCardComponent']");
    protected By deck_TextBack = By.xpath("//textarea[@id='backTextAreaIdInPrepCreateCardComponent']");
    protected By btn_DeckSave = By.xpath("//div[@class='button-save']");
    protected By btn_CreateDeck = By.xpath("//span[text()='Create']");
    protected By anotherFlashCard = By.xpath("(//button[normalize-space()='Add another'])[1]");
    protected By btn_createADesk = By.xpath(" //div[contains(text(),'Create a deck')]");
    protected By createDesk2 = By.xpath("//p[contains(text(),'My decks')]");
    protected By openBook = By.xpath("//div[contains(@class, 'MuiPaper-root') and contains(@class, 'MuiCard-root')]");
    protected By searchLibrary = By.xpath("//div[contains(@class, 'searchContainer')]");
    protected By txt_BookName = By.xpath("(//input[@placeholder='Search your library'])[1]");
    protected By expandContainerLocator = By.xpath("//ul[contains(@class, 'expanded-list')]/li[contains(@class, 'toc-parent')]/a[contains(@class, 'MuiLink-root')]");
    protected By expandContainerLocator1 = By.cssSelector(".toc-parent > a");
    protected By childElementLocator = By.xpath("./following-sibling::ul/li | ./ul/li");

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

    /**
     * Left Navigation-Home
     **/

    public void clickHomeBtn() {
        int attempts = 0;
        while (attempts < 3) {
            try {
                waitUntilElementVisible(btn_Home, 20);
                clickElement(btn_Home);
                waitUntilElementVisible(homePageIdentifier, 120);
                Thread.sleep(2000);
                isPearsonLogoDisplayedInHome();
                break;
            } catch (StaleElementReferenceException ex) {
                attempts++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void isPearsonLogoDisplayedInHome() {
        try {
            WebElement pearsonLogoHome = driver.findElement(pearsonHomeLogo);
            Assert.assertTrue(pearsonLogoHome.isDisplayed(), "Pearson logo is not displayed.");
            System.out.println("Pearson logo is displayed.");
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e) {
            Assert.fail("Logo not found or not displayed.");
        }
    }


    /**
     * Search  a book in library
     **/
    public void clickSearchLibrary() {
        try {
            waitUntilElementVisible(searchLibrary, 20);
            clickElement(searchLibrary);
        } catch (StaleElementReferenceException ex) {
            waitUntilElementVisible(searchLibrary, 20);
            clickElement(searchLibrary);
        }
    }

    public void enterBookNameTxt(String bookName) {
        scrollIntoView(txt_BookName);
        enterText(txt_BookName, bookName);
    }

    public void clickOpenBook() {
        waitUntilElementVisible(openBook, 20);

        try {
            clickElement(openBook);
        } catch (StaleElementReferenceException ex) {
            clickElement(openBook);
        }
    }


    /**
     * 1. Match the book title, edition and author
     * 2. Click all Contents links in left-hand pane.
     * 3. TOC links should hit intended page/section.
     **/

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

    public void handleBookDetails(String expectedBookTitle, String expectedBookAuthor) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter("CourseA_Links.txt", true))) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

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

    public void clickAllExpandContainersAndNestedElementsOfTOC() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("TOC.txt", true))) {
            waitUntilElementVisible(expandContainerLocator, 100);
            List<WebElement> expandContainers = driver.findElements(expandContainerLocator);

            for (WebElement expandContainer : expandContainers) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", expandContainer);
                expandContainer.click();
                System.out.println();
                System.out.println("Clicked on Parent Elements: " + expandContainer.getText());
                writer.println();
                writer.println("Clicked on Parent Elements: " + expandContainer.getText());

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                switchToIframeContainer();
                StringBuilder rightSideTextParent = new StringBuilder();
                List<WebElement> rightSideTextElementsParent = driver.findElements(rightSideTextLocator);
                for (WebElement rightSideTextElementParent : rightSideTextElementsParent) {
                    rightSideTextParent.append(rightSideTextElementParent.getText()).append("\n");
                }
                writer.println("Text on the Right Side (Parent): " + rightSideTextParent.toString());
                driver.switchTo().defaultContent();

                List<WebElement> childElements = expandContainer.findElements(childElementLocator);
                for (WebElement childElement : childElements) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", childElement);
                    childElement.click();
                    System.out.println();
                    System.out.println("Clicked on Child Elements: " + childElement.getText());
                    writer.println();
                    writer.println("Clicked on Child Elements: " + childElement.getText());

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    switchToIframeContainer();
                    StringBuilder rightSideTextChild = new StringBuilder();
                    List<WebElement> rightSideTextElementsChild = driver.findElements(rightSideTextLocator);
                    for (WebElement rightSideTextElementChild : rightSideTextElementsChild) {
                        rightSideTextChild.append(rightSideTextElementChild.getText()).append("\n");
                    }
                    System.out.println("Text on the Right Side (Child): " + rightSideTextChild.toString());
                    writer.println("Text on the Right Side (Child): " + rightSideTextChild.toString());
                    driver.switchTo().defaultContent();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clickExpandContainersAndNestedElementsOfTOC() {
        waitUntilElementVisible(expandContainerLocator, 100);
        List<WebElement> expandContainers = driver.findElements(expandContainerLocator);
        int pageCount = 0;
        for (WebElement expandContainer : expandContainers) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", expandContainer);
            expandContainer.click();
            System.out.println();
            System.out.println("Clicked on Parent Elements: " + expandContainer.getText());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            switchToIframeContainer();
            StringBuilder rightSideTextParent = new StringBuilder();
            List<WebElement> rightSideTextElementsParent = driver.findElements(rightSideTextLocator);
            for (WebElement rightSideTextElementParent : rightSideTextElementsParent) {
                rightSideTextParent.append(rightSideTextElementParent.getText()).append("\n");
            }
            System.out.println("Text on the Right Side (Parent): " + rightSideTextParent.toString());
            driver.switchTo().defaultContent();

            List<WebElement> childElements = expandContainer.findElements(childElementLocator);
            for (WebElement childElement : childElements) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", childElement);
                childElement.click();
                System.out.println();
                System.out.println("Clicked on Child Elements: " + childElement.getText());

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                switchToIframeContainer();
                StringBuilder rightSideTextChild = new StringBuilder();
                List<WebElement> rightSideTextElementsChild = driver.findElements(rightSideTextLocator); // Assuming rightSideTextLocator is defined for child elements
                for (WebElement rightSideTextElementChild : rightSideTextElementsChild) {
                    rightSideTextChild.append(rightSideTextElementChild.getText()).append("\n");
                }
                System.out.println("Text on the Right Side (Child): " + rightSideTextChild.toString());
                driver.switchTo().defaultContent();
            }
            pageCount++;
            if (pageCount >= 2) {
                break;
            }
        }
    }

    /**
     * Check Navigation bar to toggle on namely Bookmark, User’s Last read location, User’s Current Location
     **/

    public void checkAddBookmark() {
        clickTableOfContentBtnIcon();
        clickContainerTxtLinkArrow();
        boolean addBookmarkSuccess = clickBookMarkBtn();
        Assert.assertTrue(addBookmarkSuccess, "Failed to add bookmark.");
        System.out.println("Bookmark added successfully.");
    }

    public void clickNavigationIconBtn() {
        try {
            waitUntilElementVisible(btn_NavigationIcon, 150);
            scrollIntoView(btn_NavigationIcon);
            clickElement(btn_NavigationIcon);
        } catch (StaleElementReferenceException ex) {
            driver.navigate().refresh();
            waitUntilElementVisible(btn_NavigationIcon, 150);
            scrollIntoView(btn_NavigationIcon);
            clickElement(btn_NavigationIcon);
        }
    }


    public void Navigation() {
        By scrubberLocator = By.cssSelector(".vega-scrubber");
        waitUntilElementVisible(scrubberLocator, 10);
        WebElement scrubber = driver.findElement(scrubberLocator);
        String beforeCssValue = getScrubberNavigationCssValue();
        simulateScrubberMovement(driver, scrubber, 100);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getBookmarkNames();
        getLastHistory();
        simulateScrubberMovement(driver, scrubber, 86.5667);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        geCurrentLocation();
        String afterCssValue = getScrubberNavigationCssValue();
        System.out.println("Before scrubber movement CSS value: " + beforeCssValue);
        System.out.println("After scrubber movement CSS value: " + afterCssValue);
    }

    private static void simulateScrubberMovement(WebDriver driver, WebElement scrubber, double bottomPercentage) {
        int sliderHeight = scrubber.getSize().getHeight();
        int pixelsToMove = (int) (sliderHeight * (1 - bottomPercentage / 100.0));
        Actions actions = new Actions(driver);
        actions.clickAndHold(scrubber).moveByOffset(0, pixelsToMove).release().build().perform();
    }

    public void geCurrentLocation() {
        WebElement scrubberNavigation = driver.findElement(By.xpath("//span[@aria-label='Scrubber Navigation']"));
        String attributeValue = scrubberNavigation.getAttribute("title");
        System.out.println("CurrentLocation : " + attributeValue);
    }

    public void getLastHistory() {
        WebElement bookmark = driver.findElement(By.xpath("//button[@id='scrubber-history-icon']"));
        String attributeValue = bookmark.getAttribute("title");
        System.out.println("Last Navigated Page : " + attributeValue);
    }

    public void getBookmarkNames() {
        try {
            List<WebElement> bookmarks = driver.findElements(By.xpath("//button[@id='scrubber-bookmark-icon']"));
            if (!bookmarks.isEmpty()) {
                for (WebElement bookmark : bookmarks) {
                    String attributeValue = bookmark.getAttribute("aria-label");
                    System.out.println("Bookmarked Page: " + attributeValue);
                }
            } else {
                System.out.println("No pages are bookmarked.");
            }
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

    public String getScrubberNavigationCssValue() {
        WebElement scrubberNavigation = driver.findElement(By.xpath("//span[@aria-label='Scrubber Navigation']"));
        return scrubberNavigation.getAttribute("style");
    }

    /**
     * Verification of Search functionality w.r.t. valid terms, Page number, Key-terms, Image/Video titles
     **/

    public void clickSearchBtnIcon() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 200);
            wait.until(ExpectedConditions.presenceOfElementLocated(Btn_SearchIcon));
            WebElement searchButton = driver.findElement(Btn_SearchIcon);
            searchButton.click();
        } catch (TimeoutException | StaleElementReferenceException ex) {
            driver.navigate().refresh();
            clickSearchBtnIcon();
        }
    }


    public void clickSearchTextField() {
        waitUntilElementVisible(clickTextField_Search, 150);
        try {
            clickElement(clickTextField_Search);
        } catch (StaleElementReferenceException ex) {
            clickElement(clickTextField_Search);
        }
    }


    public void enterSearchTxt(String searchName) {
        waitUntilElementVisible(TxtField_Search, 200);
        enterText(TxtField_Search, searchName);
    }

    public void performSearchTestForValidTerms() {
        clickTableOfContentBtnIcon();
        waitUntilElementVisible(expandContainerLocator1, 100);
        List<WebElement> expandContainers = driver.findElements(expandContainerLocator1);

        for (WebElement expandContainer : expandContainers) {
            try {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", expandContainer);
                expandContainer.click();
                System.out.println("Clicked on parent element: " + expandContainer.getText());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                List<WebElement> childElements = expandContainer.findElements(childElementLocator);
                if (childElements.size() >= 4) {
                    String[] words = childElements.get(3).getText().trim().toLowerCase().split("\\s+");

                    String searchWord = "";
                    if (words.length > 0) {
                        if (words[0].matches(".*[a-zA-Z].*")) {
                            searchWord = words[0];
                        } else if (words.length > 1) {
                            searchWord = words[1];
                        }
                    }
                    searchWord = searchWord.replaceAll("[^a-zA-Z]", "");

                    if (!searchWord.isEmpty()) {
                        clickSearchBtnIcon();
                        clickSearchTextField();
                        enterSearchTxt(searchWord);
                        driver.findElement(TxtField_Search).sendKeys(Keys.ENTER);
                        waitUntilElementVisible(searchResultContainer, 10);
                        validateSearchResults();
                        clickFirstSearchResultAndWait();
                        System.out.println();
                    }
                }

            } catch (StaleElementReferenceException e) {
                expandContainers = driver.findElements(expandContainerLocator1);
            }
        }
    }

    public void extractPageNumberAndSearch() {
        clickTableOfContentBtnIcon();
        waitUntilElementVisible(expandContainerLocator1, 100);
        List<WebElement> expandContainers = driver.findElements(expandContainerLocator1);
        boolean pageNumberFound = false;

        for (WebElement expandContainer : expandContainers) {
            try {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", expandContainer);
                expandContainer.click();
                System.out.println();
                System.out.println("Clicked on parent element: " + expandContainer.getText());

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                List<WebElement> childElements = expandContainer.findElements(childElementLocator);
                for (WebElement childElement : childElements) {
                    try {
                        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", childElement);
                        childElement.click();
                        System.out.println();
                        System.out.println("Clicked on child element: " + childElement.getText());

                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        String pageNumberText = extractAndSearchPageNumber();
                        if (pageNumberText != null) {
                            pageNumberFound = true;
                            clickSearchBtnIcon();
                            clickSearchTextField();
                            enterSearchTxt(pageNumberText);
                            driver.findElement(TxtField_Search).sendKeys(Keys.ENTER);
                            waitUntilElementVisible(searchResultContainer, 10);
                            validateSearchResults();
                            clickFirstSearchResultAndWait();
                            System.out.println();
                        }
                    } catch (StaleElementReferenceException e) {
                        childElements = expandContainer.findElements(childElementLocator);
                    }
                }
            } catch (StaleElementReferenceException e) {
                expandContainers = driver.findElements(expandContainerLocator1);
            }
        }

        if (!pageNumberFound) {
            System.out.println("No page number found in the entire book. Skipping the process.");


            if (expandContainers.isEmpty()) {
                System.out.println("No more expand containers. Skipping to other tests.");

            }
        }
    }

    public String extractAndSearchPageNumber() {
        switchToIframeContainer();
        try {
            WebElement pageBreakElement = driver.findElement(By.cssSelector(".pagebreak"));
            String pageNumberText = pageBreakElement.getAttribute("aria-label");
            System.out.println("Page Number: " + pageNumberText);
            return pageNumberText;
        } catch (NoSuchElementException e) {
            System.out.println("Page Number element not found in this container.");
            return null;
        } finally {
            driver.switchTo().defaultContent();
        }
    }

    public void extractGlossaryTermsAndSearch() {
        clickTableOfContentBtnIcon();
        waitUntilElementVisible(expandContainerLocator1, 100);
        List<WebElement> expandContainers = driver.findElements(expandContainerLocator1);
        boolean glossaryTermFound = false;

        for (WebElement expandContainer : expandContainers) {
            try {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", expandContainer);
                expandContainer.click();
                System.out.println();
                System.out.println("Clicked on parent element: " + expandContainer.getText());

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                List<WebElement> childElements = expandContainer.findElements(childElementLocator);
                for (WebElement childElement : childElements) {
                    try {
                        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", childElement);
                        childElement.click();
                        System.out.println("Clicked on child element: " + childElement.getText());

                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        String glossaryTermText = extractAndSearchGlossaryTerm();
                        if (glossaryTermText != null) {
                            glossaryTermFound = true;
                            clickSearchBtnIcon();
                            clickSearchTextField();
                            enterSearchTxt(glossaryTermText);
                            driver.findElement(TxtField_Search).sendKeys(Keys.ENTER);
                            waitUntilElementVisible(searchResultContainer, 10);
                            validateSearchResults();
                            clickFirstSearchResultAndWait();
                            System.out.println();
                        }
                    } catch (StaleElementReferenceException e) {
                        childElements = expandContainer.findElements(childElementLocator);
                    }
                }
            } catch (StaleElementReferenceException e) {
                expandContainers = driver.findElements(expandContainerLocator1);
            }
        }

        if (!glossaryTermFound) {
            System.out.println("No glossary term found in the entire ebook. Skipping the process.");
        }
    }

    public String extractAndSearchGlossaryTerm() {
        switchToIframeContainer();
        try {
            WebElement glossaryTermElement = driver.findElement(By.cssSelector(".keyword"));
            String glossaryTermText = glossaryTermElement.getText();
            System.out.println("Glossary Term: " + glossaryTermText);
            return glossaryTermText;
        } catch (NoSuchElementException e) {
            System.out.println("Glossary Term element not found in this container.");
            return null;
        } finally {
            driver.switchTo().defaultContent();
        }
    }


    public String extractAndSearchFigureText() {
        switchToIframeContainer();
        try {
            WebElement figureTitleElement = driver.findElement(By.cssSelector(".stage-element.spf-rce-element.spf-element-text.figure-title p, h4.component-label-section"));
            String figureText = figureTitleElement.getText();
            System.out.println("Figure Text: " + figureText);
            return figureText;
        } catch (NoSuchElementException e) {
            System.out.println("Figure Text element not found in this container.");
            return null;
        } finally {
            driver.switchTo().defaultContent();
        }
    }

    public void extractFigureTextAndSearch() {
        clickTableOfContentBtnIcon();
        waitUntilElementVisible(expandContainerLocator1, 100);
        List<WebElement> expandContainers = driver.findElements(expandContainerLocator1);
        boolean figureTextFound = false;

        for (WebElement expandContainer : expandContainers) {
            try {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", expandContainer);
                expandContainer.click();
                System.out.println("Clicked on parent element: " + expandContainer.getText());

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                List<WebElement> childElements = expandContainer.findElements(childElementLocator);
                for (WebElement childElement : childElements) {
                    try {
                        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", childElement);
                        childElement.click();
                        System.out.println();
                        System.out.println("Clicked on child element: " + childElement.getText());

                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        String figureText = extractAndSearchFigureText();
                        if (figureText != null) {
                            figureTextFound = true;
                            clickSearchBtnIcon();
                            clickSearchTextField();
                            enterSearchTxt(figureText);
                            driver.findElement(TxtField_Search).sendKeys(Keys.ENTER);
                            waitUntilElementVisible(searchResultContainer, 10);
                            validateSearchResults();
                            clickFirstSearchResultAndWait();
                            System.out.println();
                        }
                    } catch (StaleElementReferenceException e) {
                        childElements = expandContainer.findElements(childElementLocator);
                    }
                }
            } catch (StaleElementReferenceException e) {
                expandContainers = driver.findElements(expandContainerLocator1);
            }
        }

        if (!figureTextFound) {
            System.out.println("No figure text found in the entire ebook. Skipping the process.");
        }
    }

    public void extractVideoTitleURLAndSearch() throws InterruptedException {
        boolean videoFound = false;
        clickTableOfContentBtnIcon();
        waitUntilElementVisible(expandContainerLocator1, 100);
        List<WebElement> expandContainers = driver.findElements(expandContainerLocator1);

        for (int i = 0; i < expandContainers.size(); i++) {
            try {
                WebElement expandContainer = expandContainers.get(i);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", expandContainer);
                expandContainer.click();
                System.out.println("Clicked on parent element: " + expandContainer.getText());

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                List<WebElement> childElements = expandContainer.findElements(childElementLocator);

                for (int j = 0; j < childElements.size(); j++) {
                    try {
                        WebElement childElement = childElements.get(j);
                        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", childElement);
                        childElement.click();
                        System.out.println();
                        System.out.println("Clicked on child element: " + childElement.getText());

                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        String videoTitle = extractAndTestVideo1();
                        if (videoTitle != null) {
                            videoFound = true;
                            clickSearchBtnIcon();
                            clickSearchTextField();
                            enterSearchTxt(videoTitle);
                            driver.findElement(TxtField_Search).sendKeys(Keys.ENTER);
                            waitUntilElementVisible(searchResultContainer, 10);
                            validateSearchResults();
                            System.out.println();
                        }
                    } catch (StaleElementReferenceException e) {
                        childElements = expandContainer.findElements(childElementLocator);
                    }
                }
            } catch (StaleElementReferenceException e) {
                expandContainers = driver.findElements(expandContainerLocator1);
            }
        }

        if (!videoFound) {
            System.out.println("Video not found in the entire book. Skipping to other tests.");

            if (expandContainers.isEmpty()) {
                System.out.println("No more expand containers. Skipping to other tests.");

            }
        }
    }


    public String extractAndTestVideo1() {
        switchToIframeContainer();
        try {
            WebElement videoElement = driver.findElement(By.cssSelector(".pearson-component.video"));
            String videoTitle = driver.findElement(By.cssSelector(".stage-element.spf-rce-element h4.component-label-section span.component-title p")).getText();
            String videoURL = videoElement.getAttribute("data-enhanced");

            System.out.println("Video Title: " + videoTitle);
            System.out.println("Video URL: " + videoURL);
            return videoTitle;
        } catch (NoSuchElementException e) {
            System.out.println("Video element not found in this container.");
        } finally {
            driver.switchTo().defaultContent();
        }
        return null;
    }


    public void performSearchTestForVideo(String searchName) {
        clickSearchBtnIcon();
        clickSearchTextField();
        waitUntilElementVisible(TxtField_Search, 200);
        enterText(TxtField_Search, searchName);
        driver.findElement(TxtField_Search).sendKeys(Keys.ENTER);
        validateSearchResults();
        extractAndTestVideo1();

    }

    public void validateSearchResults() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement searchResultDataWrapper = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("searchResultDataWrapper")));
        List<WebElement> categoryHeadings = searchResultDataWrapper.findElements(By.className("facetHeading"));

        for (WebElement categoryHeading : categoryHeadings) {
            String categoryName = categoryHeading.getText();
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", categoryHeading);

            try {
                WebElement resultElement = categoryHeading.findElement(By.xpath("./following-sibling::span"));
                String resultText = resultElement.getText();
                Pattern pattern = Pattern.compile("\\b(\\d+)\\b");
                Matcher matcher = pattern.matcher(resultText);
                String count = matcher.find() ? matcher.group(1) : "0";
                System.out.println("Category: " + categoryName + " - Result Count: " + count);
            } catch (NoSuchElementException e) {
                System.out.println("Category: " + categoryName + " - Result Count: 0 (No sibling span found)");
            }
        }
    }


    public void clickFirstSearchResultAndWait() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement searchResultDataWrapper = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("searchResultDataWrapper")));
        List<WebElement> resultLinks = searchResultDataWrapper.findElements(By.className("sTitle"));
        for (WebElement resultLink : resultLinks) {
            resultLink.click();

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            List<WebElement> noteContentElements = driver.findElements(By.className("noteContent"));
            if (!noteContentElements.isEmpty()) {
                for (WebElement noteContentElement : noteContentElements) {
                    String clickedResultText = noteContentElement.getText().trim();
                    if (!clickedResultText.isEmpty()) {
                        System.out.println("Text of the clicked result: " + clickedResultText);
                        return;
                    }
                }
            }
            driver.navigate().back();
        }
        System.out.println("NoteContent text not found in any result");
    }

    public void performSearchFunctionality() throws InterruptedException {
        performSearchTestForVideo("video");
        performSearchTestForValidTerms();
        extractGlossaryTermsAndSearch();
        driver.navigate().refresh();
        extractFigureTextAndSearch();
        driver.navigate().refresh();
        extractVideoTitleURLAndSearch();
        driver.navigate().refresh();
        extractPageNumberAndSearch();


    }

    /**
     * "1. Creation of Notes for any content within title.
     * 2. View Notes
     * 3. Filter by color
     * 4. Export Notes as PDF.
     * 5. Delete Note"
     **/

    public void clickExpandContainerNotebook() throws InterruptedException {
        waitUntilElementVisible(expandContainerNotebook, 150);
        scrollIntoView(expandContainerNotebook);
        clickElement(expandContainerNotebook);
        Thread.sleep(3000);
    }

    public void copyFirstParagraph() throws InterruptedException {
        switchToIframeContainer();
        WebElement firstParagraph = driver.findElement(By.cssSelector("p"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstParagraph);
        String script = "var range = document.createRange();"
                + "range.selectNodeContents(arguments[0]);"
                + "var selection = window.getSelection();"
                + "selection.removeAllRanges();"
                + "selection.addRange(range);";
        ((JavascriptExecutor) driver).executeScript(script, firstParagraph);
        String textContent = firstParagraph.getText();
        System.out.println("Paragraph Text: " + textContent);
        Actions actions = new Actions(driver);
        actions.moveToElement(firstParagraph)
                .clickAndHold()
                .release()
                .build()
                .perform();
        Thread.sleep(3000);
        driver.switchTo().defaultContent();

    }

    public void clickHighlightYellowColor() throws InterruptedException {
        waitUntilElementVisible(highlightsYellow, 150);
        scrollIntoView(highlightsYellow);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickElement(highlightsYellow);
        Thread.sleep(3000);
    }

    public void clickCreateNoteBook() {
        waitUntilElementVisible(createNote, 150);
        scrollIntoView(createNote);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickElement(createNote);
    }

    public void enterNotes(String notes) {
        enterText(enterNotes, notes);
    }

    public void clickViewNote() {
        waitUntilElementVisible(clickViewNote, 150);
        scrollIntoView(clickViewNote);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickElement(clickViewNote);
    }

    public void clickSaveNote() {
        waitUntilElementVisible(clickSaveNote, 150);
        scrollIntoView(clickSaveNote);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickElement(clickSaveNote);
    }

    public void clickNoteBtn() {
        waitUntilElementVisible(btn_Note, 200);
        scrollIntoView(btn_Note);
        clickElement(btn_Note);
    }

    public void clickExportNote() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 150);
            WebElement exportButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@aria-label='Export notes'])")));
            exportButton.click();
        } catch (TimeoutException e) {
            System.out.println("Export button not found within the specified time.");
        }
    }

    public void verifyNoteContent() {
        By elementLocator = By.xpath("//div[@class='noteCardItem']/div[@role='button']");
        waitUntilElementVisible(elementLocator, 200);
        String notebookContent = getTextFromElement(elementLocator);
        System.out.println("Notebook Content: " + notebookContent);
    }

    public void verifyImportNote() {
        String expectedTitle = "Your export is ready!";
        By elementLocator = By.xpath("//div[contains(text(),'Your export is ready!')]");
        waitUntilElementVisible(elementLocator, 200);
        String actualTitle = getTextFromElement(elementLocator);
        System.out.println(actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    public void clickDotBtn() {
        waitUntilElementVisible(btn_3dot, 150);
        clickElement(btn_3dot);
    }

    public void clickDeleteNote() {
        waitUntilElementVisible(btn_DeleteNote, 150);
        clickElement(btn_DeleteNote);
    }

    public void verifyDeleteNote() {
        String expectedTitle = "Note deleted";
        By elementLocator = By.xpath("//div[contains(text(),'Note deleted')]");
        waitUntilElementVisible(elementLocator, 200);
        String actualTitle = getTextFromElement(elementLocator);
        System.out.println(actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle);
    }


    //new notebook right side


    /**
     * Creation of custom deck of flashcards
     **/

    public void clickFlashcard() {
        try {
            waitUntilElementVisible(btn_FlashCard, 150);
            clickElement(btn_FlashCard);
        } catch (Exception e) {
            waitUntilElementVisible(btn_FlashCard, 150);
            clickElement(btn_FlashCard);

        }
    }

    public void clickCreateNewDeck() {
        try {
            waitUntilElementVisible(btn_CreateDeck, 150);
            clickElement(btn_CreateDeck);
        } catch (Exception e) {
            clickONCreate2();
            ClickOnCreateDesk();

        }
    }

    public void clickONCreate2() {
        waitUntilElementVisible(createDesk2, 150);
        clickElement(createDesk2);
    }

    public void ClickOnCreateDesk() {
        waitUntilElementVisible(btn_createADesk, 150);
        clickElement(btn_createADesk);
    }

    public void clickDeckName() {
        waitUntilElementVisible(deckName, 150);
        clickElement(deckName);
    }

    public void enterDeckName(String deckname) {
        waitUntilElementVisible(deckName, 150);
        enterText(deckName, deckname);
    }

    public void clickNext() {
        waitUntilElementVisible(btn_DeckNext, 150);
        clickElement(btn_DeckNext);
    }

    public void enterDeckFront(String deckname) {
        waitUntilElementVisible(deck_TextFront, 150);
        enterText(deck_TextFront, deckname);
    }

    public void enterDeckBack(String deckname) {
        waitUntilElementVisible(deck_TextBack, 150);
        enterText(deck_TextBack, deckname);
    }

    public void clickAnotherFlashcard() {
        try {
            waitUntilElementVisible(anotherFlashCard, 150);
            clickElement(anotherFlashCard);
        } catch (Exception e) {
            waitUntilElementVisible(anotherFlashCard, 150);
            clickElement(anotherFlashCard);

        }
    }

    public void click_btn_save() {
        waitUntilElementVisible(btn_DeckSave, 150);
        clickElement(btn_DeckSave);
    }

    public void VerifyFlashCard() {
        WebElement flashCardName = driver.findElement(By.id("Listitem1"));
        String attributeValue = flashCardName.getAttribute("aria-label");
        System.out.println("Deck Name : " + attributeValue);
    }

    /**
     * Check this feature for following options:
     * 1. Display Color modes
     * 2. Text Size
     * 3. Show Highlights
     **/
    public void clickDisplaySettingsNavigation() {
        try {
            waitUntilElementVisible(btn_DisplaySettings, 200);
            scrollIntoView(btn_DisplaySettings);
            clickElement(btn_DisplaySettings);
        } catch (StaleElementReferenceException ex) {
            driver.navigate().refresh();
            waitUntilElementVisible(btn_DisplaySettings, 200);
            scrollIntoView(btn_DisplaySettings);
            clickElement(btn_DisplaySettings);
        }
    }


    public void performColorModeActions() {
        waitUntilElementVisible(btn_colorMode, 10);
        WebElement colorModeContainer = driver.findElement(btn_colorMode);
        List<WebElement> colorModeOptions = colorModeContainer.findElements(By.className("colorSelector"));
        Actions actions = new Actions(driver);
        for (WebElement colorModeOption : colorModeOptions) {
            actions.moveToElement(colorModeOption).perform();
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", colorModeOption);
            String colorModeBackgroundColor = colorModeOption.getCssValue("background-color");
            String colorModeAriaLabel = colorModeOption.getAttribute("aria-label");
            if (!colorModeBackgroundColor.equals("rgba(0, 0, 0, 0)")) {
                System.out.println("Color Mode: " + colorModeAriaLabel);
                System.out.println("Color Mode Background Color: " + colorModeBackgroundColor);
            }
        }
    }

    public void performFontSizeActions() {
        waitUntilElementVisible(btn_IncreaseFontSize, 60);
        driver.findElement(btn_IncreaseFontSize).click();

        By fontSizeLocator = By.cssSelector("span[class*='MuiSlider-thumb']");
        WebElement fontSizeElement = driver.findElement(fontSizeLocator);
        String increasedFontSize = fontSizeElement.getCssValue("left");
        System.out.println("Increased Font Size: " + increasedFontSize);

        waitUntilElementVisible(btn_DecreaseFontSize, 60);
        driver.findElement(btn_DecreaseFontSize).click();

        String decreasedFontSize = fontSizeElement.getCssValue("left");
        System.out.println("Decreased Font Size: " + decreasedFontSize);
    }

    public void enableShowHighlightsCheckbox() {
        waitUntilElementVisible(By.xpath("//span[@id='highlights-label']"), 10);
        WebElement showHighlightsCheckbox = driver.findElement(By.xpath("//span[@id='highlights-label']"));

        if (!showHighlightsCheckbox.isSelected()) {
            showHighlightsCheckbox.click();
            System.out.println("Show highlights checkbox has been enabled.");
        } else {
            System.out.println("Show highlights checkbox is already enabled.");
        }
    }


    /**
     * Enables to hide the left navigation basket
     **/
    public String clickHideMenuOptionBtn() {
        try {
            waitUntilElementVisible(btn_HideMenuOption, 20);
            scrollIntoView(btn_HideMenuOption);
            clickElement(btn_HideMenuOption);
            return "Hide Menu Option clicked successfully.";
        } catch (Exception e) {
            return "Failed to click Hide Menu Option. Reason: " + e.getMessage();
        }
    }

    /**
     * Allows end user to sign out.
     **/
    public void clickCBDropDownBtn() {
        waitUntilElementVisible(dropDownBtn_CB, 150);
        try {
            clickElement(dropDownBtn_CB);
        } catch (StaleElementReferenceException ex) {
            clickElement(dropDownBtn_CB);
        }
    }

    public void clickSignOutBtn() {
        waitUntilElementVisible(btn_SignOut, 150);
        scrollIntoView(btn_SignOut);
        clickElement(btn_SignOut);
        waitUntilElementVisible(titleLogo, 150);
    }

    public void isPearsonLogoDisplayed() {
        try {
            WebElement pearsonLogo = driver.findElement(By.xpath("//div[@class='pearson-logo__wrapper']"));
            boolean isLogoDisplayed = pearsonLogo.isDisplayed();
            if (isLogoDisplayed) {
                System.out.println("Sign Out Successful. Pearson logo is displayed.");
            } else {
                System.out.println("Sign Out Failed. Pearson logo not found.");
            }
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e) {
            System.out.println("Sign Out Failed. Pearson logo not found.");
        }
    }


    /**
     * Check if Bookmark can be created and removed
     **/
    public void clickContainerTxtLinkArrow() {
        try {
            waitUntilElementVisible(txtLink_Container, 50);
            clickElement(txtLink_Container);
        } catch (StaleElementReferenceException ex) {
            waitUntilElementVisible(txtLink_Container, 50);
            clickElement(txtLink_Container);
        }
    }

    public boolean clickBookMarkBtn() {
        try {
            System.out.println("Waiting for bookmark button to be visible...");
            waitUntilElementVisible(btn_Bookmark, 50);

            System.out.println("Clicking on bookmark button...");
            clickElement(btn_Bookmark);

            System.out.println("Bookmark button clicked successfully.");
            return true;
        } catch (Exception e) {
            System.out.println("Failed to click bookmark button. Exception: " + e.getMessage());
            return false;
        }
    }


    public boolean clickRemoveBookmarkBtn() {
        try {
            waitUntilElementVisible(Btn_RemoveBookmark, 60);
            clickElement(Btn_RemoveBookmark);
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }

    public void clickRemoveAllBookmarkBtn() {
        try {
            waitUntilElementVisible(Btn_RemoveAllBookmark, 60);
            clickElement(Btn_RemoveAllBookmark);
        } catch (Exception ignored) {
        }
    }

    public void clickBookMarkNavigation() {
        waitUntilElementVisible(TxtLink_BookmarkNavigation, 20);
        clickElement(TxtLink_BookmarkNavigation);
    }

    public String getBookmarkRemovedPopupText() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement popup = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), 'Your bookmark has been removed')]")));
            return popup.getText();
        } catch (TimeoutException | NoSuchElementException e) {
            return null;
        }
    }

    public void checkAddAndRemoveBookmark() {
        clickTableOfContentBtnIcon();
        clickContainerTxtLinkArrow();
        boolean addBookmarkSuccess = clickBookMarkBtn();

        if (addBookmarkSuccess) {
            System.out.println("Bookmark added successfully.");
        } else {
            System.out.println("Failed to add bookmark.");
            return;
        }

        clickBookMarkNavigation();
        String BookmarkTitle = getFirstBookmarkTitle();
        if (BookmarkTitle != null) {
            System.out.println("Text of the first bookmark: " + BookmarkTitle);
        } else {
            System.out.println("Unable to retrieve the text of the first bookmark.");
        }
        boolean removeBookmarkSuccess = clickRemoveBookmarkBtn();
        if (removeBookmarkSuccess) {
            System.out.println("Bookmark removed successfully.");
            String popupText = getBookmarkRemovedPopupText();
            if (popupText != null) {
                System.out.println("Bookmark removed popup text: " + popupText);
            } else {
                System.out.println("Bookmark removed popup not found.");
            }
        } else {
            System.out.println("Failed to remove bookmark.");
        }
        clickRemoveAllBookmarkBtn();
    }

    public String getFirstBookmarkTitle() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement firstBookmark = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".cardChapterTitle")));
            return firstBookmark.getText();
        } catch (TimeoutException | NoSuchElementException e) {
            return null;
        }
    }


    /**
     * Right navigation should move a page forward and Left navigation should navigate the user to the previous page
     **/

//    public boolean clickArrowRightNavigation() {
//        try {
//            waitUntilElementVisible(arrow_RightNavigation, 150);
//            clickElement(arrow_RightNavigation);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public boolean clickArrowLeftNavigation() {
//        try {
//            waitUntilElementVisible(arrow_LeftNavigation, 150);
//            clickElement(arrow_LeftNavigation);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public String getPageText() {
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        WebElement pageContent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("spf-rce-section-content")));
//        return pageContent.getText();
//    }
//
//    public void checkLeftAndRightArrowNavigation() throws InterruptedException {
//        clickTableOfContentBtnIcon();
//        clickContainerTxtLinkArrow();
//        boolean rightNavigationSuccess = clickArrowRightNavigation();
//        assertNavigation("right", rightNavigationSuccess);
//
//        Thread.sleep(1000);
//        switchToIframeContainer();
//        String rightPageText = getPageText();
//        System.out.println("Text after navigating to the right:\n" + rightPageText);
//        driver.switchTo().defaultContent();
//
//        boolean leftNavigationSuccess = clickArrowLeftNavigation();
//        assertNavigation("left", leftNavigationSuccess);
//
//        Thread.sleep(1000);
//        switchToIframeContainer();
//        String leftPageText = getPageText();
//        System.out.println();
//        System.out.println("Text after navigating to the left:\n" + leftPageText);
//        driver.switchTo().defaultContent();
//
//    }
//
//    private void assertNavigation(String direction, boolean success) {
//        if (success) {
//            System.out.println("Successfully navigated to the " + direction + ".");
//        } else {
//            System.out.println("Failed to navigate to the " + direction + ".");
//        }
//    }

    public void navigateThroughPages() {
        boolean navigateRight = true;
        boolean navigationSuccessful = true;

        while (navigationSuccessful) {
            if (navigateRight) {
                navigationSuccessful = clickArrowRightNavigation();
                navigateRight = navigationSuccessful;
            } else {
                navigationSuccessful = clickArrowLeftNavigation();
                navigateRight = !navigationSuccessful;
            }
        }
    }

    public boolean clickArrowRightNavigation() {
        try {
            waitUntilElementVisible(arrow_RightNavigation, 150);
            clickElement(arrow_RightNavigation);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean clickArrowLeftNavigation() {
        try {
            waitUntilElementVisible(arrow_LeftNavigation, 150);
            clickElement(arrow_LeftNavigation);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickAllNextPages() throws InterruptedException {
        clickTableOfContentBtnIcon();
        clickExpandContainerNotebook();

        WebDriverWait wait = new WebDriverWait(driver, 10);


        while (true) {
            try {

                WebElement nextPageButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@aria-label, 'next page')]")));
                System.out.println("Aria label: " + nextPageButton.getAttribute("aria-label"));
                nextPageButton.click();
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("No more next page buttons found.");
                break;
            }
        }
    }

    /**
     * "1. Internal references: Check if each link navigates to correct location. These internal links can be for Chapters , Appendix, Figures , References
     * 2. External references: Check if external links open to a secure website"
     **/
    static List<String> reachableLinks = new ArrayList<>();
    static List<String> notReachableLinks = new ArrayList<>();

    public void extractAllLinksFromRightSide() {

        int totalHrefLinks = 0;
        int totalPatternLinks = 0;

        try (PrintWriter writer = new PrintWriter(new FileWriter("CourseA_Links.txt", true))) {
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



    /**
     * Check the following features:
     * 1. Video can be played/paused
     * 2. CC is available
     * 3. Presence of Audio option
     * 4. Video replay
     * 5. Transcript
     **/


    public void performFunctionalityTestForVideo(PrintWriter writer) {
        clickFullScreenBtn(writer);
        mute(writer);
        unMute(writer);
        muteAndUnMute(writer);
        clickSettings(writer);
        clickSubtitlesAndCC(writer);
        clickEnglishCC(writer);
        clickBackButton1(writer);
        clickSpeedElement(writer);
        checkSpeedNormal(writer);
        clickBackButton2(writer);
        clickTranscriptElement(writer);
        clickTranscriptEnglishCCElement(writer);
        clickTranscriptCloseBtn(writer);
        clickSettings(writer);
        clickAutoReplayElement(writer);
        clickAutoReplayOn(writer);
        clickBackButton1(writer);
        clickSettingsCloseButton(writer);
        clickPauseButton(writer);
        clickCloseFullScreenBtn(writer);
    }


    public void extractAllVideos() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("Video_Output.txt", true))) {
            driver.manage().timeouts().setScriptTimeout(900000000, TimeUnit.SECONDS);
            clickTableOfContentBtnIcon();
            waitUntilElementVisible(expandContainerLocator, 100);
            List<WebElement> expandContainers = driver.findElements(expandContainerLocator);
            int totalExpandContainers = expandContainers.size();
            writer.println();
            writer.println("*************************************************************************************");
            writer.println("Total Expand Containers on this page: " + totalExpandContainers);
            System.out.println();
            System.out.println("*************************************************************************************");
            System.out.println("Total Expand Containers on this page: " + totalExpandContainers);

            for (int page = 0; page < totalExpandContainers; page++) {
                WebElement expandContainer = expandContainers.get(page);
                writer.println("*************************************************************************************");
                writer.println("Navigating to Page " + (page + 1) + ": " + expandContainer.getText());
                System.out.println("*************************************************************************************");
                System.out.println("Navigating to Page " + (page + 1) + ": " + expandContainer.getText());
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", expandContainer);
                expandContainer.click();
                writer.println("Clicked on parent element: " + expandContainer.getText());
                System.out.println("Clicked on parent element: " + expandContainer.getText());

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                List<WebElement> childElements = expandContainer.findElements(childElementLocator);
                for (WebElement childElement : childElements) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", childElement);
                    childElement.click();
                    writer.println("*************************************************************************************");
                    writer.println("Clicked on child element: " + childElement.getText());
                    System.out.println("*************************************************************************************");
                    System.out.println("Clicked on child element: " + childElement.getText());
                    writer.println("Current page: " + childElement.getText());
                    System.out.println("Current page: " + childElement.getText());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    switchToIframeContainer();
                    extractVideoDetailsFromIframe(writer);
                    driver.switchTo().defaultContent();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void extractVideoDetailsFromIframe(PrintWriter writer) {
        List<WebElement> videoElements = driver.findElements(By.cssSelector("div.divVideo"));

        if (videoElements.isEmpty()) {
            System.out.println("No videos found on this page.");
            System.out.println("---------------------------------------------------------------------------------------------");
            writer.println("No videos found on this page.");
            writer.println("---------------------------------------------------------------------------------------------");
            return;
        }

        int totalVideosOnPage = videoElements.size();
        writer.println("Total videos on this page: " + totalVideosOnPage);
        writer.println("---------------------------------------------------------------------------------------------");
        System.out.println("Total videos on this page: " + totalVideosOnPage);
        System.out.println("---------------------------------------------------------------------------------------------");

        for (WebElement videoElement : videoElements) {
            String videoTitle = extractVideoTitle(videoElement);
            System.out.println("Video Title: " + videoTitle);
            writer.println("Video Title: " + videoTitle);
            String videoUrl = videoElement.findElement(By.cssSelector("div.video source")).getAttribute("src");

            clickPlayButton(videoUrl, writer);
            performFunctionalityTestForVideo(writer);
        }
    }

    private String extractVideoTitle(WebElement videoElement) {
        WebElement Title;
        try {
            Title = videoElement.findElement(By.cssSelector("span.component-title p"));
        } catch (NoSuchElementException e) {
            try {
                Title = videoElement.findElement(By.xpath("..//preceding-sibling::div[@class='stage-element spf-rce-element spf-element-text']/h3"));
            } catch (NoSuchElementException e2) {
                return "Title not found for video";
            }
        }

        return Title.getText();
    }


    public void clickSettingsCloseButton(PrintWriter writer) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 100);
            By settingsCloseButtonLocator = By.xpath("(//button[@aria-label='Close'])[2]");
            WebElement settingsCloseButtonElement = wait.until(ExpectedConditions.presenceOfElementLocated(settingsCloseButtonLocator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility='visible';", settingsCloseButtonElement);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", settingsCloseButtonElement);
            Thread.sleep(5000);
            System.out.println("Pass: Settings Close Button clicked successfully.");
            writer.println("Pass: Settings Close Button clicked successfully.");
        } catch (TimeoutException | InterruptedException e) {
            System.out.println("Fail: Settings Close Button element was not clickable.");
            writer.println("Fail: Settings Close Button element was not clickable.");
        }
    }

    public boolean mute(PrintWriter writer) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 100);
            By muteButtonLocator = By.xpath("//button[@aria-label='Mute']");
            WebElement muteButtonElement = wait.until(ExpectedConditions.presenceOfElementLocated(muteButtonLocator));
            if (!muteButtonElement.isDisplayed()) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility='visible';", muteButtonElement);
            }
            muteButtonElement.click();
            return true;
        } catch (TimeoutException e) {
            System.out.println("Fail: Mute button was not clickable.");
            writer.println("Fail: Mute button was not clickable.");
            return false;
        }
    }

    public boolean unMute(PrintWriter writer) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 100);
            By unMuteButtonLocator = By.xpath("//button[@aria-label='Unmute']");
            WebElement unMuteButtonElement = wait.until(ExpectedConditions.elementToBeClickable(unMuteButtonLocator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility='visible';", unMuteButtonElement);

            unMuteButtonElement.click();
            return true;
        } catch (TimeoutException e) {
            System.out.println("Fail: UnMute button was not clickable.");
            writer.println("Fail: UnMute button was not clickable.");
            return false;
        }
    }

    public void muteAndUnMute(PrintWriter writer) {
        if (mute(writer)) {
            System.out.println("Pass: Mute button clicked successfully.");
            writer.println("Pass: Mute button clicked successfully.");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (unMute(writer)) {
                System.out.println("Pass: UnMute button clicked successfully.");
                writer.println("Pass: UnMute button clicked successfully.");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Fail: UnMute button click failed.");
                writer.println("Fail: UnMute button click failed.");
            }
        } else {
            System.out.println("Fail: Mute button click failed.");
            writer.println("Fail: Mute button click failed.");
        }
    }

    public void clickPlayButton(String videoUrl, PrintWriter writer) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 500);
            By playButtonLocator = By.xpath("//button[@aria-label='Play']");
            wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
            By specificPlayButtonLocator = By.xpath("//div[contains(@class, 'divVideo') and .//source[@src='" + videoUrl + "']]//button[@aria-label='Play']");
            WebElement playButtonElement = wait.until(ExpectedConditions.elementToBeClickable(specificPlayButtonLocator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility='visible';", playButtonElement);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", playButtonElement);
            Actions actions = new Actions(driver);
            actions.moveToElement(playButtonElement).click().perform();
            Thread.sleep(10);
            System.out.println("Pass: Play button clicked successfully for video URL: " + videoUrl);
            writer.println("Pass: Play button clicked successfully for video URL: " + videoUrl);
        } catch (TimeoutException | InterruptedException e) {
            System.out.println("Fail: Play button was not clickable for video URL: " + videoUrl);
            writer.println("Fail: Play button was not clickable for video URL: " + videoUrl);
        }
    }

    public void clickFullScreenBtn(PrintWriter writer) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 500);
            By fullScreenBtnLocator = By.xpath("//button[@aria-label='Open full screen view']");
            WebElement fullScreenBtnElement = wait.until(ExpectedConditions.presenceOfElementLocated(fullScreenBtnLocator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility='visible';", fullScreenBtnElement);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fullScreenBtnElement);
            Actions actions = new Actions(driver);
            actions.moveToElement(fullScreenBtnElement).click().perform();
            Thread.sleep(10);
            System.out.println("Pass: Full screen element clicked successfully.");
            writer.println("Pass: Full screen element clicked successfully.");
        } catch (TimeoutException | InterruptedException e) {
            System.out.println("Fail: Full screen element was not clickable.");
            writer.println("Fail: Full screen element was not clickable.");
        }
    }


    public void clickSettings(PrintWriter writer) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 200);
            By settingsButtonLocator = By.xpath("//button[@aria-label='Settings']");
            WebElement settingsOptionElement = wait.until(ExpectedConditions.presenceOfElementLocated(settingsButtonLocator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility='visible';", settingsOptionElement);
            settingsOptionElement.click();
            Thread.sleep(10);
            System.out.println("Pass: Settings element clicked successfully.");
            writer.println("Pass: Settings element clicked successfully.");
        } catch (TimeoutException | InterruptedException e) {
            System.out.println("Fail: Settings element was not clickable.");
            writer.println("Fail: Settings element was not clickable.");
        }
    }


    public void clickSubtitlesAndCC(PrintWriter writer) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 200);
            By subtitlesAndCCLocator = By.xpath("//span[@aria-label='Subtitles & CC']");
            WebElement subtitlesAndCCElement = wait.until(ExpectedConditions.presenceOfElementLocated(subtitlesAndCCLocator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility='visible';", subtitlesAndCCElement);
            subtitlesAndCCElement.click();
            Thread.sleep(10);
            System.out.println("Pass: Subtitles & CC element clicked successfully.");
            writer.println("Pass: Subtitles & CC element clicked successfully.");
        } catch (TimeoutException | InterruptedException e) {
            System.out.println("Fail: Subtitles & CC element was not clickable.");
            writer.println("Fail: Subtitles & CC element was not clickable.");
        }
    }


    private static int screenshotCounter = 1;

    public void clickEnglishCC(PrintWriter writer) {
        try {
            WebElement englishCCElement = new WebDriverWait(driver, 200)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'English CC')]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility='visible';", englishCCElement);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", englishCCElement);
            Thread.sleep(10);
            System.out.println("Pass: English CC element clicked successfully.");
            writer.println("Pass: English CC element clicked successfully.");
            Thread.sleep(2000);
            captureScreenshot("EnglishCC_" + screenshotCounter, writer);
            screenshotCounter++;

        } catch (TimeoutException | InterruptedException e) {
            System.out.println("Fail: English CC element was not clickable.");
            writer.println("Fail: English CC element was not clickable.");
        }
    }

    public void clickTranscriptEnglishCCElement(PrintWriter writer) {
        try {
            By englishCCLocator = By.xpath("//div[contains(text(),'English CC')]");
            WebElement englishCCElement = new WebDriverWait(driver, 200)
                    .until(ExpectedConditions.presenceOfElementLocated(englishCCLocator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility='visible';", englishCCElement);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", englishCCElement);
            Thread.sleep(10);
            System.out.println("Pass: Transcript English CC element clicked successfully.");
            writer.println("Pass: Transcript English CC element clicked successfully.");
            captureScreenshot("TranscriptEnglishCC_" + screenshotCounter, writer);
            screenshotCounter++;
            String transcriptText = getTranscriptText(writer);
        } catch (TimeoutException | InterruptedException e) {
            System.out.println("Fail: Transcript English CC element was not clickable.");
            writer.println("Fail: Transcript English CC element was not clickable.");
        }
    }

    public void captureScreenshot(String screenshotName, PrintWriter writer) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            String destination = "C:\\Users\\nivethaa.e\\Downloads\\qualiframev2-main\\Course18\\screenshot\\" + screenshotName + ".png";
            File finalDestination = new File(destination);
            FileUtils.copyFile(source, finalDestination);
            System.out.println("Pass: Screenshot captured: " + screenshotName);
            writer.println("Pass: Screenshot captured: " + screenshotName);
        } catch (Exception e) {
            System.out.println("Fail: Exception while capturing screenshot: " + e.getMessage());
            writer.println("Fail: Exception while capturing screenshot: " + e.getMessage());
        }
    }


    public void clickBackButton1(PrintWriter writer) {
        try {
            By backButtonLocator1 = By.xpath("(//button[@aria-label='Back'])[2]");
            WebElement backButtonElement1 = new WebDriverWait(driver, 200)
                    .until(ExpectedConditions.presenceOfElementLocated(backButtonLocator1));
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility='visible';", backButtonElement1);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", backButtonElement1);
            Thread.sleep(10);
            System.out.println("Pass: Back button element clicked successfully.");
            writer.println("Pass: Back button element clicked successfully.");
        } catch (TimeoutException | InterruptedException e) {
            System.out.println("Fail: Back button element was not clickable.");
            writer.println("Fail: Back button element was not clickable.");
        }
    }


    public void clickSpeedElement(PrintWriter writer) {
        try {
            By speedElementLocator = By.xpath("//span[@aria-label='Speed']");
            WebElement speedElement = new WebDriverWait(driver, 200)
                    .until(ExpectedConditions.presenceOfElementLocated(speedElementLocator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility='visible';", speedElement);
            speedElement.click();
            Thread.sleep(10);
            System.out.println("Pass: Speed element clicked successfully.");
            writer.println("Pass: Speed element clicked successfully.");
        } catch (TimeoutException | InterruptedException e) {
            System.out.println("Fail: Speed element was not clickable.");
            writer.println("Fail: Speed element was not clickable.");
        }
    }

    public void checkSpeedNormal(PrintWriter writer) {
        try {
            By speedNormalButtonLocator = By.xpath("//span[normalize-space()='SelectedNormal']");
            WebElement speedNormalButtonElement = new WebDriverWait(driver, 200)
                    .until(ExpectedConditions.presenceOfElementLocated(speedNormalButtonLocator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility='visible';", speedNormalButtonElement);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", speedNormalButtonElement);
            Thread.sleep(10);
            System.out.println("Pass: Speed Normal element clicked successfully.");
            writer.println("Pass: Speed Normal element clicked successfully.");
        } catch (TimeoutException | InterruptedException e) {
            System.out.println("Fail: Speed Normal element was not clickable.");
            writer.println("Fail: Speed Normal element was not clickable.");
        }
    }

    public void clickBackButton2(PrintWriter writer) {
        try {
            By backButton2Locator = By.xpath("(//button[@aria-label='Back'])[1]");
            WebElement backButtonElement2 = new WebDriverWait(driver, 200)
                    .until(ExpectedConditions.presenceOfElementLocated(backButton2Locator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility='visible';", backButtonElement2);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", backButtonElement2);
            Thread.sleep(10);
            System.out.println("Pass: Back button clicked successfully.");
            writer.println("Pass: Back button clicked successfully.");
        } catch (TimeoutException | InterruptedException e) {
            System.out.println("Fail: Back button element was not clickable.");
            writer.println("Fail: Back button element was not clickable.");
        }
    }


    public void clickTranscriptElement(PrintWriter writer) {
        try {
            By transcriptLocator = By.xpath("//span[@aria-label='Transcript']");
            WebElement transcriptElement = new WebDriverWait(driver, 200)
                    .until(ExpectedConditions.presenceOfElementLocated(transcriptLocator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility='visible';", transcriptElement);
            transcriptElement.click();
            Thread.sleep(10);
            System.out.println("Pass:Transcript element clicked successfully.");
            writer.println("Pass: Transcript element clicked successfully.");
        } catch (TimeoutException | InterruptedException e) {
            System.out.println("Fail:Transcript element was not clickable.");
            writer.println("Fail: Transcript element was not clickable.");
        }
    }


    public String getTranscriptText(PrintWriter writer) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 200);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".transcript-inner-container")));
            WebElement transcriptElement = driver.findElement(By.cssSelector(".transcript-inner-container"));
            String transcriptText = transcriptElement.getText();
            if (transcriptText.isEmpty()) {
                System.out.println("Fail: Transcript text is empty.");
                writer.println("Fail: Transcript text is empty.");
            } else {
                System.out.println("Pass: Transcript Text: " + transcriptText);
                writer.println("Pass: Transcript Text: " + transcriptText);
            }
            return transcriptText;
        } catch (TimeoutException | NoSuchElementException e) {
            System.out.println("Fail: Transcript element not found.");
            writer.println("Fail: Transcript element not found.");
        }
        return null;
    }

    public void clickTranscriptCloseBtn(PrintWriter writer) {
        try {
            By transcriptCloseBtnLocator = By.xpath("(//button[@aria-label='Close Transcription'])[1]");
            WebElement transcriptCloseButtonElement = new WebDriverWait(driver, 200)
                    .until(ExpectedConditions.presenceOfElementLocated(transcriptCloseBtnLocator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility='visible';", transcriptCloseButtonElement);
            transcriptCloseButtonElement.click();
            WebDriverWait wait = new WebDriverWait(driver, 100);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(transcriptCloseBtnLocator));
            System.out.println("Pass: Transcript English CC Close element clicked successfully.");
            writer.println("Pass: Transcript English CC Close element clicked successfully.");
        } catch (TimeoutException e) {
            System.out.println("Fail: Transcript English CC Close element was not clickable.");
            writer.println("Fail: Transcript English CC Close element was not clickable.");
        }
    }

    public void clickAutoReplayElement(PrintWriter writer) {
        try {
            By autoReplayButtonLocator = By.xpath("//span[@aria-label='Auto Replay']");
            WebElement autoReplayButtonElement = new WebDriverWait(driver, 200)
                    .until(ExpectedConditions.presenceOfElementLocated(autoReplayButtonLocator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'center' });", autoReplayButtonElement);
            Thread.sleep(100);
            autoReplayButtonElement.click();
            Thread.sleep(10);
            System.out.println("Pass: Auto Replay Button element clicked successfully.");
            writer.println("Pass: Auto Replay Button element clicked successfully.");
        } catch (TimeoutException | InterruptedException e) {
            System.out.println("Fail: Auto Replay Button element was not clickable.");
            writer.println("Fail: Auto Replay Button element was not clickable.");
        }
    }


    public void clickAutoReplayOn(PrintWriter writer) {
        try {
            WebElement autoReplayOnElement = new WebDriverWait(driver, 200)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'On')]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'center' });", autoReplayOnElement);
            Thread.sleep(100);
            autoReplayOnElement.click();
            Thread.sleep(10);
            System.out.println("Pass: Auto Replay On element clicked successfully.");
            writer.println("Pass: Auto Replay On element clicked successfully.");
        } catch (TimeoutException | InterruptedException e) {
            System.out.println("Fail: Auto Replay On element was not clickable.");
            writer.println("Fail: Auto Replay On element was not clickable.");
        }
    }


    public void clickCloseFullScreenBtn(PrintWriter writer) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 200);
            By closeFullScreenBtnLocator = By.xpath("//button[@aria-label='Close full screen view']");
            WebElement closeFullScreenBtnElement = wait.until(ExpectedConditions.presenceOfElementLocated(closeFullScreenBtnLocator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility='visible';", closeFullScreenBtnElement);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", closeFullScreenBtnElement);
            closeFullScreenBtnElement.click();
            Thread.sleep(10);
            System.out.println("Pass: Close full screen element clicked successfully.");
            writer.println("Pass: Close full screen element clicked successfully.");
        } catch (TimeoutException | InterruptedException e) {
            System.out.println("Fail: Close full screen element was not clickable.");
            writer.println("Fail: Close full screen element was not clickable.");
        }
    }


    public void clickPauseButton(PrintWriter writer) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 500);
            By pauseButtonLocator = By.xpath("//button[@aria-label='Pause']");
            WebElement pauseButtonElement = wait.until(ExpectedConditions.presenceOfElementLocated(pauseButtonLocator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility='visible';", pauseButtonElement);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'nearest' });", pauseButtonElement);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".vegaViewerComponent1-335")));

            Actions actions = new Actions(driver);
            actions.moveToElement(pauseButtonElement).click().perform();
            Thread.sleep(10);
            System.out.println("Pass: Pause button element clicked successfully.");
            writer.println("Pass: Pause button element clicked successfully.");
        } catch (TimeoutException | InterruptedException e) {
            System.out.println("Fail: Pause button was not clickable.");
            writer.println("Fail: Pause button was not clickable.");
        }
    }

    /**
     * 1. Check for presence of HTML code in title or caption
     * 2. Check if image opens in light box (image viewer) and closed to exit the light box.
     * 3. Image can be zoomed in/out
     * 4. If image contains a caption in the narrative, verify that the caption is also displayed in the lightbox
     **/
    public void extractAllImagesFromRightSide1(int pageNumber) {
        int overallTotalImages = 0;
        try (PrintWriter writer = new PrintWriter(new FileWriter("Course20_Image.txt", true))) {
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
     * Extract left side TOC contents
     **/

    public void extractLeftSideTOC() {
        driver.manage().timeouts().setScriptTimeout(5000, TimeUnit.SECONDS);
        clickTableOfContentBtnIcon();
        By expandContainerLocator = By.cssSelector(".toc-parent > a");
        By childElementLocator2 = By.xpath(".//following-sibling::ul/li | .//ul/li");
        By childElementLocator1 = By.cssSelector(".toc-child > a");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(expandContainerLocator));

        List<WebElement> expandContainers = driver.findElements(expandContainerLocator);

        for (WebElement expandContainer : expandContainers) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", expandContainer);
            expandContainer.click();
            System.out.println(expandContainer.getText());

            List<WebElement> childElements;
            childElements = expandContainer.findElements(childElementLocator1);
            if (childElements.isEmpty()) {
                childElements = expandContainer.findElements(childElementLocator2);
            }

            for (WebElement childElement : childElements) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", childElement);
                childElement.click();
                System.out.println(childElement.getText());

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Extract Right side content
     **/
    public void clickAllTextFromRightSide() {
        clickTableOfContentBtnIcon();
        waitUntilElementVisible(expandContainerLocator, 100);
        List<WebElement> expandContainers = driver.findElements(expandContainerLocator);
        for (WebElement expandContainer : expandContainers) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", expandContainer);
            expandContainer.click();
            System.out.println("Clicked on Parent Elements: " + expandContainer.getText());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            switchToIframeContainer();
            StringBuilder rightSideTextParent = new StringBuilder();
            List<WebElement> rightSideTextElementsParent = driver.findElements(rightSideTextLocator);
            for (WebElement rightSideTextElementParent : rightSideTextElementsParent) {
                rightSideTextParent.append(rightSideTextElementParent.getText()).append("\n");
            }
            System.out.println("Text on the Right Side (Parent): " + rightSideTextParent.toString());
            driver.switchTo().defaultContent();

            List<WebElement> childElements = expandContainer.findElements(childElementLocator);
            for (WebElement childElement : childElements) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", childElement);
                childElement.click();
                System.out.println();
                System.out.println("Clicked on Child Elements: " + childElement.getText());

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                switchToIframeContainer();
                StringBuilder rightSideTextChild = new StringBuilder();
                List<WebElement> rightSideTextElementsChild = driver.findElements(rightSideTextLocator);
                for (WebElement rightSideTextElementChild : rightSideTextElementsChild) {
                    rightSideTextChild.append(rightSideTextElementChild.getText()).append("\n");
                }
                System.out.println("Text on the Right Side (Child): " + rightSideTextChild.toString());
                driver.switchTo().defaultContent();
            }
        }
    }


    /**
     * Helping Methods
     **/
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


























































