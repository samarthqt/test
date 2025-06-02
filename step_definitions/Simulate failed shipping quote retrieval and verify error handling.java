package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.ShippingPage;

public class ShippingSteps extends ShippingPage {

    private TestHarness testHarness = new TestHarness();

    @Given("User account exists")
    public void userAccountExists() {
        verifyUserAccountExists();
    }

    @When("User logs into the application using valid credentials")
    public void userLogsIntoApplication() {
        String username = testHarness.getData("LoginData", "Username");
        String password = testHarness.getData("LoginData", "Password");
        login(username, password);
    }

    @Then("User is successfully logged in and navigated to the homepage")
    public void userIsLoggedIn() {
        verifyUserIsOnHomepage();
    }

    @Given("User is on the homepage")
    public void userIsOnHomepage() {
        verifyUserIsOnHomepage();
    }

    @When("User navigates to the shopping cart")
    public void userNavigatesToShoppingCart() {
        navigateToShoppingCart();
    }

    @Then("All items added to the cart are displayed with their respective details")
    public void verifyItemsInCart() {
        verifyCartItems();
    }

    @Given("User is on the shopping cart page")
    public void userIsOnShoppingCartPage() {
        verifyUserIsOnShoppingCartPage();
    }

    @When("User proceeds to checkout")
    public void userProceedsToCheckout() {
        proceedToCheckout();
    }

    @Then("Checkout page is displayed with options to enter shipping information")
    public void verifyCheckoutPage() {
        verifyCheckoutPageDisplayed();
    }

    @Given("User is on the checkout page")
    public void userIsOnCheckoutPage() {
        verifyUserIsOnCheckoutPage();
    }

    @When("User enters valid shipping address details")
    public void userEntersShippingDetails() {
        String fullName = testHarness.getData("ShippingData", "FullName");
        String address = testHarness.getData("ShippingData", "Address");
        String city = testHarness.getData("ShippingData", "City");
        String postalCode = testHarness.getData("ShippingData", "PostalCode");
        String phone = testHarness.getData("ShippingData", "Phone");
        enterShippingDetails(fullName, address, city, postalCode, phone);
    }

    @Then("Shipping address is accepted and saved")
    public void verifyShippingAddressSaved() {
        verifyShippingAddressAccepted();
    }

    @Given("User has entered shipping address details")
    public void userHasEnteredShippingDetails() {
        verifyShippingAddressEntered();
    }

    @When("User selects 'Get Shipping Quotes' option")
    public void userSelectsGetShippingQuotes() {
        selectGetShippingQuotes();
    }

    @Then("System attempts to retrieve shipping quotes")
    public void systemAttemptsToRetrieveQuotes() {
        verifyShippingQuotesRetrieval();
    }

    @Given("System is attempting to retrieve shipping quotes")
    public void systemIsRetrievingQuotes() {
        verifyShippingQuotesRetrieval();
    }

    @When("Network failure or service outage is simulated")
    public void simulateNetworkFailure() {
        simulateNetworkFailureOrOutage();
    }

    @Then("System displays an error message indicating failure to retrieve shipping quotes")
    public void verifyErrorMessageDisplayed() {
        verifyErrorMessageForShippingQuotes();
    }

    @Given("Error message is displayed")
    public void errorMessageIsDisplayed() {
        verifyErrorMessageForShippingQuotes();
    }

    @Then("Error message includes options to retry or contact support")
    public void verifyErrorMessageOptions() {
        verifyErrorMessageOptionsAvailable();
    }

    @Given("Error message includes retry option")
    public void errorMessageIncludesRetryOption() {
        verifyErrorMessageOptionsAvailable();
    }

    @When("User attempts to retrieve shipping quotes again using retry option")
    public void userRetriesShippingQuotes() {
        retryShippingQuotesRetrieval();
    }

    @Then("System attempts to retrieve quotes again and either succeeds or displays error message")
    public void verifyRetryOutcome() {
        verifyRetryOutcomeForShippingQuotes();
    }

    @Given("System has displayed an error message")
    public void systemDisplayedErrorMessage() {
        verifyErrorMessageForShippingQuotes();
    }

    @Then("Error details are logged in the system for troubleshooting")
    public void verifyErrorLogging() {
        verifyErrorDetailsLogged();
    }

    @Given("Error details are logged in the system")
    public void errorDetailsLogged() {
        verifyErrorDetailsLogged();
    }

    @When("User checks email for notification")
    public void userChecksEmail() {
        checkEmailForNotification();
    }

    @Then("Email notification is sent with details about the issue and possible resolutions")
    public void verifyEmailNotification() {
        verifyEmailNotificationSent();
    }

    @Given("User is on any page of the application")
    public void userIsOnAnyPage() {
        verifyUserIsOnAnyPage();
    }

    @When("User logs out from the application")
    public void userLogsOut() {
        logout();
    }

    @Then("User is successfully logged out")
    public void verifyUserLoggedOut() {
        verifyUserIsLoggedOut();
    }

    @Given("User is logged out")
    public void userIsLoggedOut() {
        verifyUserIsLoggedOut();
    }

    @When("User logs into the application again")
    public void userLogsInAgain() {
        String username = testHarness.getData("LoginData", "Username");
        String password = testHarness.getData("LoginData", "Password");
        login(username, password);
    }

    @When("User navigates to order history")
    public void userNavigatesToOrderHistory() {
        navigateToOrderHistory();
    }

    @Then("Order history displays recent order with an indication of shipping quote retrieval issue")
    public void verifyOrderHistory() {
        verifyOrderHistoryForShippingIssue();
    }

    @Given("User is on the order history page")
    public void userIsOnOrderHistoryPage() {
        verifyUserIsOnOrderHistoryPage();
    }

    @When("User attempts to edit shipping details")
    public void userEditsShippingDetails() {
        editShippingDetails();
    }

    @When("User attempts to retrieve quotes again")
    public void userRetrievesQuotesAgain() {
        retryShippingQuotesRetrieval();
    }

    @Then("System allows editing of shipping details and attempts to retrieve quotes")
    public void verifyEditAndRetrieveQuotes() {
        verifyEditAndRetrieveQuotesFunctionality();
    }

    @Given("User has edited shipping details")
    public void userHasEditedShippingDetails() {
        verifyShippingDetailsEdited();
    }

    @When("System successfully retrieves shipping quotes")
    public void systemRetrievesQuotesSuccessfully() {
        verifySuccessfulShippingQuotesRetrieval();
    }

    @Then("System allows selection of preferred provider")
    public void verifyProviderSelection() {
        verifyProviderSelectionAvailable();
    }

    @Given("User has selected preferred shipping provider")
    public void userHasSelectedProvider() {
        verifyProviderSelected();
    }

    @When("User confirms the shipping selection")
    public void userConfirmsShippingSelection() {
        confirmShippingSelection();
    }

    @Then("User is navigated to the payment section with selected shipping details")
    public void verifyNavigationToPayment() {
        verifyNavigationToPaymentSection();
    }
}