package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.OrderDetailsPage;

public class OrderDetailsSteps extends OrderDetailsPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into their account")
    public void theUserIsLoggedIntoTheirAccount() {
        loginToAccount();
    }

    @When("the user navigates to the 'Order History' section")
    public void theUserNavigatesToTheOrderHistorySection() {
        navigateToOrderHistory();
    }

    @When("selects an order to view detailed information")
    public void selectsAnOrderToViewDetailedInformation() {
        selectOrder();
    }

    @Then("the product names are listed in the order details")
    public void theProductNamesAreListedInTheOrderDetails() {
        verifyProductNames();
    }

    @Then("the quantities for each product are displayed")
    public void theQuantitiesForEachProductAreDisplayed() {
        verifyProductQuantities();
    }

    @Then("the prices for each product are displayed")
    public void thePricesForEachProductAreDisplayed() {
        verifyProductPrices();
    }

    @Then("the total cost of the order is displayed")
    public void theTotalCostOfTheOrderIsDisplayed() {
        verifyTotalCost();
    }

    @Then("any discounts or promotions applied to the order are displayed")
    public void anyDiscountsOrPromotionsAppliedToTheOrderAreDisplayed() {
        verifyDiscountsAndPromotions();
    }

    @Then("the order details include tax information, if applicable")
    public void theOrderDetailsIncludeTaxInformationIfApplicable() {
        verifyTaxInformation();
    }

    @Then("a download or print option for the order details is available")
    public void aDownloadOrPrintOptionForTheOrderDetailsIsAvailable() {
        verifyDownloadOrPrintOption();
    }

    @Then("product images are displayed alongside product details")
    public void productImagesAreDisplayedAlongsideProductDetails() {
        verifyProductImages();
    }

    @Given("the user is not logged into their account")
    public void theUserIsNotLoggedIntoTheirAccount() {
        ensureUserIsLoggedOut();
    }

    @When("the user attempts to view order details")
    public void theUserAttemptsToViewOrderDetails() {
        attemptToViewOrderDetails();
    }

    @Then("the user is prompted to log in before viewing order details")
    public void theUserIsPromptedToLogInBeforeViewingOrderDetails() {
        verifyLoginPrompt();
    }

    @Given("the user has past orders with multiple quantities of products")
    public void theUserHasPastOrdersWithMultipleQuantitiesOfProducts() {
        verifyPastOrdersWithMultipleQuantities();
    }

    @When("the user views the order details")
    public void theUserViewsTheOrderDetails() {
        viewOrderDetails();
    }

    @Then("the total cost accurately reflects the quantities ordered")
    public void theTotalCostAccuratelyReflectsTheQuantitiesOrdered() {
        verifyTotalCostAccuracy();
    }

    @Given("the user has international orders")
    public void theUserHasInternationalOrders() {
        verifyInternationalOrders();
    }

    @Then("the currency is displayed correctly according to the user's location")
    public void theCurrencyIsDisplayedCorrectlyAccordingToTheUsersLocation() {
        verifyCurrencyDisplay();
    }

    @Given("the user is logged out of their account")
    public void theUserIsLoggedOutOfTheirAccount() {
        logoutFromAccount();
    }

    @Then("the user is redirected to the login page")
    public void theUserIsRedirectedToTheLoginPage() {
        verifyRedirectionToLoginPage();
    }
}