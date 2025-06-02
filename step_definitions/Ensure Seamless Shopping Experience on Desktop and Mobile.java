package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.ShoppingExperiencePage;

public class ShoppingExperienceSteps extends ShoppingExperiencePage {

    private TestHarness testHarness = new TestHarness();

    @Given("the application is deployed and accessible")
    public void theApplicationIsDeployedAndAccessible() {
        launchApplication();
    }

    @When("I open the application on a desktop browser")
    public void iOpenTheApplicationOnADesktopBrowser() {
        openOnDesktop();
    }

    @Then("the application loads successfully on the desktop browser")
    public void theApplicationLoadsSuccessfullyOnTheDesktopBrowser() {
        verifyDesktopLoad();
    }

    @Given("I have valid user credentials")
    public void iHaveValidUserCredentials() {
        loadUserCredentials();
    }

    @When("I log in using valid user credentials")
    public void iLogInUsingValidUserCredentials() {
        loginWithCredentials();
    }

    @Then("I am redirected to the homepage")
    public void iAmRedirectedToTheHomepage() {
        verifyHomepageRedirection();
    }

    @Given("I am on the homepage")
    public void iAmOnTheHomepage() {
        verifyOnHomepage();
    }

    @When("I perform a product search using relevant keywords")
    public void iPerformAProductSearchUsingRelevantKeywords() {
        searchProduct();
    }

    @Then("search results are displayed accurately based on the keywords")
    public void searchResultsAreDisplayedAccuratelyBasedOnTheKeywords() {
        verifySearchResults();
    }

    @Given("search results are displayed")
    public void searchResultsAreDisplayed() {
        verifySearchResultsDisplayed();
    }

    @When("I add a product to the shopping cart")
    public void iAddAProductToTheShoppingCart() {
        addProductToCart();
    }

    @Then("the product is added to the cart successfully")
    public void theProductIsAddedToTheCartSuccessfully() {
        verifyProductAddedToCart();
    }

    @Given("a product is added to the cart")
    public void aProductIsAddedToTheCart() {
        verifyProductInCart();
    }

    @When("I proceed to checkout and fill in the required details")
    public void iProceedToCheckoutAndFillInTheRequiredDetails() {
        proceedToCheckout();
    }

    @Then("checkout process is completed successfully with all details filled")
    public void checkoutProcessIsCompletedSuccessfullyWithAllDetailsFilled() {
        verifyCheckoutCompletion();
    }

    @Given("the checkout process is completed")
    public void theCheckoutProcessIsCompleted() {
        verifyCheckoutCompleted();
    }

    @When("I verify the order confirmation details")
    public void iVerifyTheOrderConfirmationDetails() {
        verifyOrderConfirmation();
    }

    @Then("order confirmation is displayed with correct details")
    public void orderConfirmationIsDisplayedWithCorrectDetails() {
        verifyOrderDetails();
    }

    @Given("I am logged in")
    public void iAmLoggedIn() {
        verifyUserLoggedIn();
    }

    @When("I log out from the desktop session")
    public void iLogOutFromTheDesktopSession() {
        logoutFromDesktop();
    }

    @Then("I log out successfully")
    public void iLogOutSuccessfully() {
        verifyLogoutSuccess();
    }

    @When("I open the application on a mobile browser")
    public void iOpenTheApplicationOnAMobileBrowser() {
        openOnMobile();
    }

    @Then("the application loads successfully on the mobile browser")
    public void theApplicationLoadsSuccessfullyOnTheMobileBrowser() {
        verifyMobileLoad();
    }

    @When("I log in using the same user credentials on mobile")
    public void iLogInUsingTheSameUserCredentialsOnMobile() {
        loginWithCredentialsOnMobile();
    }

    @Then("I am redirected to the homepage on mobile")
    public void iAmRedirectedToTheHomepageOnMobile() {
        verifyHomepageRedirectionOnMobile();
    }

    @Given("I am on the homepage on mobile")
    public void iAmOnTheHomepageOnMobile() {
        verifyOnHomepageOnMobile();
    }

    @When("I perform a product search using relevant keywords and add a different product to the cart")
    public void iPerformAProductSearchUsingRelevantKeywordsAndAddADifferentProductToTheCart() {
        searchAndAddDifferentProductOnMobile();
    }

    @Then("search results are accurate, and the product is added to the cart successfully")
    public void searchResultsAreAccurateAndTheProductIsAddedToTheCartSuccessfully() {
        verifySearchAndAddOnMobile();
    }

    @When("I proceed to checkout on mobile and fill in the required details")
    public void iProceedToCheckoutOnMobileAndFillInTheRequiredDetails() {
        proceedToCheckoutOnMobile();
    }

    @Then("checkout process is completed successfully on mobile")
    public void checkoutProcessIsCompletedSuccessfullyOnMobile() {
        verifyCheckoutCompletionOnMobile();
    }

    @Given("the checkout process is completed on mobile")
    public void theCheckoutProcessIsCompletedOnMobile() {
        verifyCheckoutCompletedOnMobile();
    }

    @When("I verify the order confirmation details on mobile")
    public void iVerifyTheOrderConfirmationDetailsOnMobile() {
        verifyOrderConfirmationOnMobile();
    }

    @Then("order confirmation is displayed with correct details on mobile")
    public void orderConfirmationIsDisplayedWithCorrectDetailsOnMobile() {
        verifyOrderDetailsOnMobile();
    }

    @Given("I have access to both desktop and mobile platforms")
    public void iHaveAccessToBothDesktopAndMobilePlatforms() {
        verifyAccessToBothPlatforms();
    }

    @When("I check the application's responsiveness and UI consistency across desktop and mobile")
    public void iCheckTheApplicationsResponsivenessAndUIConsistencyAcrossDesktopAndMobile() {
        checkResponsivenessAndUIConsistency();
    }

    @Then("the application is responsive and the UI is consistent across both platforms")
    public void theApplicationIsResponsiveAndTheUIIsConsistentAcrossBothPlatforms() {
        verifyUIConsistency();
    }

    @When("I test the application's performance on both platforms")
    public void iTestTheApplicationsPerformanceOnBothPlatforms() {
        testPerformanceOnBothPlatforms();
    }

    @Then("the application performs efficiently without any lag or delay on both platforms")
    public void theApplicationPerformsEfficientlyWithoutAnyLagOrDelayOnBothPlatforms() {
        verifyPerformanceEfficiency();
    }

    @Given("I am logged in on mobile")
    public void iAmLoggedInOnMobile() {
        verifyUserLoggedInOnMobile();
    }

    @When("I log out from the mobile session")
    public void iLogOutFromTheMobileSession() {
        logoutFromMobile();
    }

    @Then("I log out successfully on mobile")
    public void iLogOutSuccessfullyOnMobile() {
        verifyLogoutSuccessOnMobile();
    }
}