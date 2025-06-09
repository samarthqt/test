package com.cucumber.steps;

import com.framework.components.Settings;
import com.framework.cucumber.TestHarness;
import com.pageobjects.eBook;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import java.io.IOException;
import java.util.Properties;


public class eBookWebSteps extends eBook {
    protected TestHarness testHarness = new TestHarness();
    protected Properties properties = Settings.getInstance();


    @Given("Launch Application using {string}")
    public void launch_Application(String tcid) {
        String url = properties.getProperty("ApplicationUrl");
        testHarness.initializeTestData(tcid);
        launchApp(url);
    }

    @When("I click on acceptAll button")
    public void iClickOnAcceptAllButton() {
        clickAcceptAllBtn();

    }

    @When("User enters user credentials in the text field")
    public void userEntersUserCredentialsInTheTextField() {
        String username = testHarness.getData("General_Data", "userName");
        String password = testHarness.getData("General_Data", "password");
        enterUserNameTxt(username);
        enterPasswordTxt(password);
    }

    @And("I click on signIn button")
    public void iClickOnSignInButton() {
        clickSignInBtn();

    }

    @And("Search a book in library")
    public void searchABookInLibrary() {
        clickSearchLibrary();
        String bookName = testHarness.getData("General_Data", "bookName");
        enterBookNameTxt(bookName);
        clickOpenBook();
    }

    @And("I click on home icon button navigation")
    public void iClickOnHomeIconButtonNavigation() {
        clickHomeBtn();
    }

    @And("I click on table of contents Navigation")
    public void iClickOnTableOfContentsNavigation() throws InterruptedException, IOException {
        clickTableOfContentBtnIcon();
        String bookTitle = testHarness.getData("General_Data", "bookTitle");
        String bookAuthor = testHarness.getData("General_Data", "bookAuthor");
        System.out.println("Test Data - Book Title: " + bookTitle);
        System.out.println("Test Data - Book Author: " + bookAuthor);
        handleBookDetails(bookTitle, bookAuthor);
//        clickExpandContainersAndNestedElementsOfTOC();
        clickAllExpandContainersAndNestedElementsOfTOC();
    }

    @And("I click on the bookmarks and recent and current page navigation")
    public void iClickOnTheBookMarksAndRecentAndCurrentPageNavigation() {
        checkAddBookmark();
        clickNavigationIconBtn();
        Navigation();
    }

    @And("Verification of search functionality")
    public void verificationOfSearchFunctionality() throws InterruptedException {
        performSearchFunctionality();

    }

    @And("Verify RightSide Note Creation")
    public void verifyRightSideNoteCreation() throws InterruptedException {
        clickTableOfContentBtnIcon();
        clickExpandContainerNotebook();
        copyFirstParagraph();
        clickHighlightYellowColor();
        clickCreateNoteBook();
        enterNotes("Important Notes");
        clickViewNote();
        clickSaveNote();
        clickNoteBtn();
        verifyNoteContent();
        clickExportNote();
        verifyImportNote();
        clickDotBtn();
        clickDeleteNote();
        verifyDeleteNote();
    }


    @And("Verification of flashcardNote")
    public void verificationOfFlashcardNote() {
        clickFlashcard();
        clickCreateNewDeck();
        clickDeckName();
        String newNotes = testHarness.getData("General_Data", "deckName");
        enterDeckName(newNotes);
        clickNext();
        String front = testHarness.getData("General_Data", "Front");
        enterDeckFront(front);
        String back = testHarness.getData("General_Data", "Back");
        enterDeckBack(back);
        clickAnotherFlashcard();
        String front1 = testHarness.getData("General_Data", "Front1");
        enterDeckFront(front1);
        String back2 = testHarness.getData("General_Data", "Back1");
        enterDeckBack(back2);
        click_btn_save();
        VerifyFlashCard();
    }

    @And("I click on the display settings navigation")
    public void iClickOnTheDisplaySettingsNavigation() {
        clickDisplaySettingsNavigation();
        performColorModeActions();
        performFontSizeActions();
        enableShowHighlightsCheckbox();
    }

    @And("I click on the hide menu option button")
    public void iClickOnTheHideMenuOptionButton() {
        String resultMessage = clickHideMenuOptionBtn();
        System.out.println(resultMessage);
    }

    @And("Check signOut functionality")
    public void checkSignOutFunctionality() {
        clickCBDropDownBtn();
        clickSignOutBtn();
        isPearsonLogoDisplayed();
    }

    @And("I click on the add bookmark and remove bookmark button")
    public void iClickOnTheAddBookMarkAndRemoveBookMarkButton() {
        checkAddAndRemoveBookmark();
    }

    @And("I click on the left and right arrow navigation")
    public void iClickOnTheLeftAndRightArrowNavigation() throws InterruptedException {
//        checkLeftAndRightArrowNavigation();
        navigateThroughPages();
    }

    @And("Extract links in page of content")
    public void ExtractLinksInPageOfContent() throws IOException {
        clickTableOfContentBtnIcon();
        String bookTitle = testHarness.getData("General_Data", "bookTitle");
        String bookAuthor = testHarness.getData("General_Data", "bookAuthor");
        System.out.println("Test Data - Book Title: " + bookTitle);
        System.out.println("Test Data - Book Author: " + bookAuthor);
        handleBookDetails(bookTitle, bookAuthor);
        extractAllLinksFromRightSide();
    }


    @And("Video test functionality")
    public void checkVideoTestFunctionality() {
        extractAllVideos();
    }

    @And("Light box image viewer functionality")
    public void checkLightBoxImageViewerFunctionality() throws IOException {
        clickTableOfContentBtnIcon();
        String bookTitle = testHarness.getData("General_Data", "bookTitle");
        String bookAuthor = testHarness.getData("General_Data", "bookAuthor");
        System.out.println("Test Data - Book Title: " + bookTitle);
        System.out.println("Test Data - Book Author: " + bookAuthor);
        handleBookDetails(bookTitle, bookAuthor);
        extractAllImagesFromRightSide();
//            extractAllImagesFromRightSide1(13);
    }


    @And("Extract left side TOC content")
    public void extractLeftSideTOCContent() {
        extractLeftSideTOC();
    }

    @And("Extract text from right side")
    public void extractTextFromRightSide() {
        clickAllTextFromRightSide();
    }
}


























