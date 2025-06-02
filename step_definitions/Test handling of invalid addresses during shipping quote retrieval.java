package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.ShippingPage;

public class ShippingSteps extends ShippingPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user account exists")
    public void aUserAccountExists() {
        // Assume user account setup is done
    }

    @When("the user logs into the application using valid credentials")
    public void theUserLogsIntoTheApplicationUsingValidCredentials() {
        String username = testHarness.getData("UserData", "Username");
        String password = testHarness.getData("UserData", "Password");
        login(username, password);
    }

    @Then("the user is successfully logged in and navigated to the homepage")
    public void theUserIsSuccessfullyLoggedInAndNavigatedToTheHomepage() {
        verifyHomePage();
    }

    @Given("the user has added products to the cart")
    public void theUserHasAddedProductsToTheCart() {
        addProductsToCart();
    }

    @When("the user navigates to the shopping cart")
    public void theUserNavigatesToTheShoppingCart() {
        navigateToCart();
    }

    @Then("all items added to the cart are displayed with their respective details")
    public void allItemsAddedToTheCartAreDisplayedWithTheirRespectiveDetails() {
        verifyCartItems();
    }

    @Given("the user is on the shopping cart page")
    public void theUserIsOnTheShoppingCartPage() {
        verifyCartPage();
    }

    @When("the user proceeds to checkout")
    public void theUserProceedsToCheckout() {
        proceedToCheckout();
    }

    @Then("the checkout page is displayed with options to enter shipping information")
    public void theCheckoutPageIsDisplayedWithOptionsToEnterShippingInformation() {
        verifyCheckoutPage();
    }

    @Given("the user is on the checkout page")
    public void theUserIsOnTheCheckoutPage() {
        verifyCheckoutPage();
    }

    @When("the user enters invalid shipping address details")
    public void theUserEntersInvalidShippingAddressDetails() {
        String invalidAddress = testHarness.getData("AddressData", "InvalidAddress");
        enterShippingDetails(invalidAddress);
    }

    @Then("the system detects the invalid address and displays an error message")
    public void theSystemDetectsTheInvalidAddressAndDisplaysAnErrorMessage() {
        verifyInvalidAddressError();
    }

    @Given("an error message is displayed for the invalid address")
    public void anErrorMessageIsDisplayedForTheInvalidAddress() {
        verifyInvalidAddressError();
    }

    @Then("the error message provides guidance on correcting the address")
    public void theErrorMessageProvidesGuidanceOnCorrectingTheAddress() {
        verifyErrorGuidance();
    }

    @Given("the user has entered an invalid shipping address")
    public void theUserHasEnteredAnInvalidShippingAddress() {
        String invalidAddress = testHarness.getData("AddressData", "InvalidAddress");
        enterShippingDetails(invalidAddress);
    }

    @When("the user attempts to retrieve shipping quotes")
    public void theUserAttemptsToRetrieveShippingQuotes() {
        attemptRetrieveShippingQuotes();
    }

    @Then("the system prevents retrieval of shipping quotes due to invalid address")
    public void theSystemPreventsRetrievalOfShippingQuotesDueToInvalidAddress() {
        verifyShippingQuotePrevention();
    }

    @Given("the user has corrected the shipping address")
    public void theUserHasCorrectedTheShippingAddress() {
        String validAddress = testHarness.getData("AddressData", "ValidAddress");
        enterShippingDetails(validAddress);
    }

    @When("the user attempts retrieval again")
    public void theUserAttemptsRetrievalAgain() {
        attemptRetrieveShippingQuotes();
    }

    @Then("the system accepts the corrected address and successfully retrieves shipping quotes")
    public void theSystemAcceptsTheCorrectedAddressAndSuccessfullyRetrievesShippingQuotes() {
        verifySuccessfulShippingQuoteRetrieval();
    }

    @Given("shipping quotes are retrieved successfully")
    public void shippingQuotesAreRetrievedSuccessfully() {
        verifySuccessfulShippingQuoteRetrieval();
    }

    @When("the user reviews the shipping quotes")
    public void theUserReviewsTheShippingQuotes() {
        reviewShippingQuotes();
    }

    @Then("the user selects a preferred provider and confirms for checkout")
    public void theUserSelectsAPreferredProviderAndConfirmsForCheckout() {
        selectPreferredProvider();
    }

    @Given("an invalid address attempt was made")
    public void anInvalidAddressAttemptWasMade() {
        verifyInvalidAddressAttempt();
    }

    @Then("the invalid address attempt is logged for auditing purposes")
    public void theInvalidAddressAttemptIsLoggedForAuditingPurposes() {
        verifyAddressAttemptLogging();
    }

    @Given("an invalid address entry was made")
    public void anInvalidAddressEntryWasMade() {
        verifyInvalidAddressAttempt();
    }

    @When("the user checks their email")
    public void theUserChecksTheirEmail() {
        checkEmailNotification();
    }

    @Then("an email notification is sent with details about the invalid address entry")
    public void anEmailNotificationIsSentWithDetailsAboutTheInvalidAddressEntry() {
        verifyEmailNotification();
    }

    @Given("the user is logged into the application")
    public void theUserIsLoggedIntoTheApplication() {
        verifyUserLoggedIn();
    }

    @When("the user logs out")
    public void theUserLogsOut() {
        logout();
    }

    @Then("the user is successfully logged out")
    public void theUserIsSuccessfullyLoggedOut() {
        verifyUserLoggedOut();
    }

    @Given("the user has logged out of the application")
    public void theUserHasLoggedOutOfTheApplication() {
        verifyUserLoggedOut();
    }

    @When("the user re-logs into the application")
    public void theUserReLogsIntoTheApplication() {
        String username = testHarness.getData("UserData", "Username");
        String password = testHarness.getData("UserData", "Password");
        login(username, password);
    }

    @Then("the user navigates to order history")
    public void theUserNavigatesToOrderHistory() {
        navigateToOrderHistory();
    }

    @Given("the user is on the order history page")
    public void theUserIsOnTheOrderHistoryPage() {
        verifyOrderHistoryPage();
    }

    @When("the user selects the order to view")
    public void theUserSelectsTheOrderToView() {
        selectOrderToView();
    }

    @Then("detailed shipping information including provider and tracking number is displayed")
    public void detailedShippingInformationIncludingProviderAndTrackingNumberIsDisplayed() {
        verifyDetailedShippingInformation();
    }

    @Given("the user has detailed shipping information")
    public void theUserHasDetailedShippingInformation() {
        verifyDetailedShippingInformation();
    }

    @When("the user tracks the order using the provided tracking number")
    public void theUserTracksTheOrderUsingTheProvidedTrackingNumber() {
        trackOrder();
    }

    @Then("tracking information is accessible and updates are displayed in real-time")
    public void trackingInformationIsAccessibleAndUpdatesAreDisplayedInRealTime() {
        verifyTrackingInformation();
    }

    @Given("shipping quotes were provided during checkout")
    public void shippingQuotesWereProvidedDuringCheckout() {
        verifySuccessfulShippingQuoteRetrieval();
    }

    @When("the user reviews the estimated delivery date")
    public void theUserReviewsTheEstimatedDeliveryDate() {
        reviewEstimatedDeliveryDate();
    }

    @Then("the estimated delivery date matches the shipping provider's quote")
    public void theEstimatedDeliveryDateMatchesTheShippingProviderSQuote() {
        verifyEstimatedDeliveryDate();
    }
}