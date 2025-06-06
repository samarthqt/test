//package com.cucumber.steps;
//import com.framework.components.Settings;
//import com.framework.cucumber.TestHarness;
//import com.pageobjects.eBook1;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.When;
//import java.io.IOException;
//import java.util.Properties;
//
//
//public class eBook1WebSteps extends eBook1 {
//    protected TestHarness testHarness = new TestHarness();
//    protected Properties properties = Settings.getInstance();
//
//
//    @Given("Launch Application using {string}")
//    public void launch_Application(String tcid) {
//        String url = properties.getProperty("ApplicationUrl");
//        testHarness.initializeTestData(tcid);
//        launchApp(url);
//    }
//
//    @When("I click on acceptAll button")
//    public void iClickOnAcceptAllButton() {
//        clickAcceptAllBtn();
//
//    }
//
//    @When("User enters user credentials in the text field")
//    public void userEntersUserCredentialsInTheTextField() {
//        String username = testHarness.getData("General_Data", "userName");
//        String password = testHarness.getData("General_Data", "password");
//        enterUserNameTxt(username);
//        enterPasswordTxt(password);
//    }
//
//    @And("I click on signIn button")
//    public void iClickOnSignInButton() {
//        clickSignInBtn();
//    }
//
//    @And("Image and External Links Scraping Utility")
//    public void ImageAndExternalLinksScrapingUtility() throws IOException {
//        clickTableOfContentBtnIcon();
//        String bookTitle = testHarness.getData("General_Data", "bookTitle");
//        String bookAuthor = testHarness.getData("General_Data", "bookAuthor");
//        System.out.println("Test Data - Book Title: " + bookTitle);
//        System.out.println("Test Data - Book Author: " + bookAuthor);
//        handleBookDetails(bookTitle, bookAuthor);
////        extractAllImagesFromRightSide();
//        extractImageFromSpecificPage(6);
//        extractAllLinksFromRightSide();
//    }
//
//
//
//}
