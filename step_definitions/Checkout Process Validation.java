package com.cucumber.steps;

import com.page_objects.CheckoutPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutSteps extends CheckoutPage {

    @Given("the user has items with IDs {int}, {int}, and {int} in the cart")
    public void theUserHasItemsInTheCart(int itemId1, int itemId2, int itemId3) {
        addItemsToCart(itemId1, itemId2, itemId3);
    }

    @When("the user navigates to the cart page")
    public void theUserNavigatesToTheCartPage() {
        navigateToCartPage();
    }

    @Then("the cart page is displayed with items {int}, {int}, and {int} listed")
    public void theCartPageIsDisplayedWithItemsListed(int itemId1, int itemId2, int itemId3) {
        verifyCartItems(itemId1, itemId2, itemId3);
    }

    @When("the user clicks on the 'Proceed to Checkout' button")
    public void theUserClicksOnProceedToCheckoutButton() {
        clickProceedToCheckout();
    }

    @Then("the user is redirected to the checkout page")
    public void theUserIsRedirectedToCheckoutPage() {
        verifyCheckoutPageRedirection();
    }

    @Then("the user account is logged in")
    public void theUserAccountIsLoggedIn() {
        verifyUserLoggedIn();
    }

    @When("the user attempts to complete the checkout without entering any shipping or billing information")
    public void theUserAttemptsCheckoutWithoutInformation() {
        attemptCheckoutWithoutInformation();
    }

    @Then("an error message is displayed indicating that shipping and billing information is required")
    public void anErrorMessageIsDisplayed() {
        verifyErrorMessageDisplayed();
    }

    @Then("the error message reads: 'Shipping and billing information is required to proceed.'")
    public void theErrorMessageReads() {
        verifyErrorMessageContent("Shipping and billing information is required to proceed.");
    }

    @Then("the checkout button remains disabled")
    public void theCheckoutButtonRemainsDisabled() {
        verifyCheckoutButtonDisabled();
    }

    @Given("the user is on the checkout page")
    public void theUserIsOnCheckoutPage() {
        verifyUserOnCheckoutPage();
    }

    @When("the user enters partial shipping information only")
    public void theUserEntersPartialShippingInformation() {
        enterPartialShippingInformation();
    }

    @Then("the error message persists")
    public void theErrorMessagePersists() {
        verifyErrorMessagePersists();
    }

    @Then("checkout cannot proceed")
    public void checkoutCannotProceed() {
        verifyCheckoutCannotProceed();
    }

    @When("the user enters partial billing information only")
    public void theUserEntersPartialBillingInformation() {
        enterPartialBillingInformation();
    }

    @When("the user enters invalid shipping and billing information")
    public void theUserEntersInvalidInformation() {
        enterInvalidShippingAndBillingInformation();
    }

    @Then("the error message indicates invalid information")
    public void theErrorMessageIndicatesInvalidInformation() {
        verifyErrorMessageIndicatesInvalidInformation();
    }

    @Then("assistance options such as help links or FAQs are available")
    public void assistanceOptionsAreAvailable() {
        verifyAssistanceOptionsAvailable();
    }

    @When("the user refreshes the page and retries checkout")
    public void theUserRefreshesPageAndRetriesCheckout() {
        refreshPageAndRetryCheckout();
    }

    @Then("page refresh does not bypass the requirement for shipping and billing information")
    public void pageRefreshDoesNotBypassRequirement() {
        verifyPageRefreshDoesNotBypassRequirement();
    }

    @When("the user checks the browser console for any error logs")
    public void theUserChecksBrowserConsole() {
        checkBrowserConsoleForErrors();
    }

    @Then("no unexpected errors are logged in the console")
    public void noUnexpectedErrorsInConsole() {
        verifyNoUnexpectedErrorsInConsole();
    }

    @When("the user checks the cart contents")
    public void theUserChecksCartContents() {
        checkCartContents();
    }

    @Then("the cart still contains items {int}, {int}, and {int}")
    public void theCartStillContainsItems(int itemId1, int itemId2, int itemId3) {
        verifyCartContents(itemId1, itemId2, itemId3);
    }

    @When("the user navigates away and returns to the checkout page")
    public void theUserNavigatesAwayAndReturns() {
        navigateAwayAndReturnToCheckoutPage();
    }

    @Then("the checkout page still requires shipping and billing information")
    public void checkoutPageStillRequiresInformation() {
        verifyCheckoutPageStillRequiresInformation();
    }

    @When("the user logs out and logs back in, then attempts checkout again")
    public void theUserLogsOutAndBackIn() {
        logoutAndLoginAgain();
    }

    @Then("checkout requirement for shipping and billing information remains")
    public void checkoutRequirementRemains() {
        verifyCheckoutRequirementRemains();
    }

    @When("the user attempts checkout using a different browser")
    public void theUserAttemptsCheckoutDifferentBrowser() {
        attemptCheckoutDifferentBrowser();
    }

    @Then("shipping and billing information is required across all browsers")
    public void informationRequiredAcrossAllBrowsers() {
        verifyInformationRequiredAcrossAllBrowsers();
    }
}