package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.SortingPage;

public class SortingSteps extends SortingPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into the retail application")
    public void theUserIsLoggedIntoTheRetailApplication() {
        loginToApplication();
    }

    @Given("the product catalog is displayed with a list of available products")
    public void theProductCatalogIsDisplayedWithAListOfAvailableProducts() {
        verifyProductCatalogDisplayed();
    }

    @When("the user selects 'Sort by Price' in ascending order")
    public void theUserSelectsSortByPriceInAscendingOrder() {
        sortByPriceAscending();
    }

    @Then("the products are sorted from lowest to highest price")
    public void theProductsAreSortedFromLowestToHighestPrice() {
        verifyProductsSortedAscending();
    }

    @Then("each subsequent product has a higher price than the previous one")
    public void eachSubsequentProductHasAHigherPriceThanThePreviousOne() {
        verifyAscendingOrder();
    }

    @When("the user selects 'Sort by Price' in descending order")
    public void theUserSelectsSortByPriceInDescendingOrder() {
        sortByPriceDescending();
    }

    @Then("the products are sorted from highest to lowest price")
    public void theProductsAreSortedFromHighestToLowestPrice() {
        verifyProductsSortedDescending();
    }

    @Then("each subsequent product has a lower price than the previous one")
    public void eachSubsequentProductHasALowerPriceThanThePreviousOne() {
        verifyDescendingOrder();
    }

    @Given("the product catalog is empty")
    public void theProductCatalogIsEmpty() {
        verifyProductCatalogEmpty();
    }

    @When("the user attempts to sort products by price")
    public void theUserAttemptsToSortProductsByPrice() {
        attemptSortOnEmptyCatalog();
    }

    @Then("the system displays a message indicating no products are available to sort")
    public void theSystemDisplaysAMessageIndicatingNoProductsAreAvailableToSort() {
        verifyNoProductsMessage();
    }

    @Given("the product catalog contains a large number of products")
    public void theProductCatalogContainsALargeNumberOfProducts() {
        verifyLargeProductCatalog();
    }

    @When("the user selects 'Sort by Price'")
    public void theUserSelectsSortByPrice() {
        sortByPrice();
    }

    @Then("the sorting operation completes within acceptable time limits")
    public void theSortingOperationCompletesWithinAcceptableTimeLimits() {
        verifySortingPerformance();
    }

    @Then("the UI remains responsive and no errors are displayed")
    public void theUIRemainsResponsiveAndNoErrorsAreDisplayed() {
        verifyUIResponsiveness();
    }

    @When("the user logs out from the application")
    public void theUserLogsOutFromTheApplication() {
        logoutFromApplication();
    }

    @Then("the user is successfully logged out and redirected to the login page")
    public void theUserIsSuccessfullyLoggedOutAndRedirectedToTheLoginPage() {
        verifyLogoutSuccess();
    }

    @Given("the user logs into the retail application using a different user account")
    public void theUserLogsIntoTheRetailApplicationUsingADifferentUserAccount() {
        loginWithDifferentAccount();
    }

    @Then("the sorting functionality works consistently across different user accounts")
    public void theSortingFunctionalityWorksConsistentlyAcrossDifferentUserAccounts() {
        verifySortingConsistencyAcrossAccounts();
    }

    @Given("the product catalog contains products with invalid price data")
    public void theProductCatalogContainsProductsWithInvalidPriceData() {
        verifyInvalidPriceData();
    }

    @Then("the system handles invalid data gracefully and displays an error message")
    public void theSystemHandlesInvalidDataGracefullyAndDisplaysAnErrorMessage() {
        verifyErrorMessageForInvalidData();
    }

    @Given("the user is logged into the retail application on different supported browsers")
    public void theUserIsLoggedIntoTheRetailApplicationOnDifferentSupportedBrowsers() {
        loginOnDifferentBrowsers();
    }

    @Then("the sorting works consistently on all supported browsers")
    public void theSortingWorksConsistentlyOnAllSupportedBrowsers() {
        verifySortingConsistencyAcrossBrowsers();
    }

    @Given("the user is logged into the retail application on a mobile device")
    public void theUserIsLoggedIntoTheRetailApplicationOnAMobileDevice() {
        loginOnMobileDevice();
    }

    @Then("products can be sorted by price on mobile devices without any issues")
    public void productsCanBeSortedByPriceOnMobileDevicesWithoutAnyIssues() {
        verifySortingOnMobileDevices();
    }
}