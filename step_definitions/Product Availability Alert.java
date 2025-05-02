package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductAvailabilityAlertSteps extends ProductAvailabilityAlertPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user is on the product page")
    public void aUserIsOnTheProductPage() {
        String productPageURL = testHarness.getData("ProductData", "ProductPageURL");
        navigateToPage(productPageURL);
    }

    @Given("the product is currently out of stock")
    public void theProductIsCurrentlyOutOfStock() {
        verifyProductOutOfStock();
    }

    @When("the user subscribes to receive availability alerts")
    public void theUserSubscribesToReceiveAvailabilityAlerts() {
        subscribeToAvailabilityAlerts();
    }

    @Then("the user should receive a confirmation of subscription")
    public void theUserShouldReceiveAConfirmationOfSubscription() {
        verifySubscriptionConfirmation();
    }

    @Given("a product is out of stock")
    public void aProductIsOutOfStock() {
        verifyProductOutOfStock();
    }

    @Given("users have subscribed to availability alerts for the product")
    public void usersHaveSubscribedToAvailabilityAlertsForTheProduct() {
        verifyUsersSubscribed();
    }

    @When("the product comes back in stock")
    public void theProductComesBackInStock() {
        updateProductStockStatus(true);
    }

    @Then("notify all subscribed users via email")
    public void notifyAllSubscribedUsersViaEmail() {
        sendEmailNotificationsToSubscribers();
    }

    @Given("a user has subscribed to receive alerts for a specific product")
    public void aUserHasSubscribedToReceiveAlertsForASpecificProduct() {
        verifyUserSubscription();
    }

    @Given("the product is back in stock")
    public void theProductIsBackInStock() {
        updateProductStockStatus(true);
    }

    @When("the system sends an availability notification")
    public void theSystemSendsAnAvailabilityNotification() {
        sendAvailabilityNotification();
    }

    @Then("the user should receive an email notifying that the product is available")
    public void theUserShouldReceiveAnEmailNotifyingThatTheProductIsAvailable() {
        verifyEmailNotificationReceived();
    }

    @Given("a user has received an email notification about product availability")
    public void aUserHasReceivedAnEmailNotificationAboutProductAvailability() {
        verifyEmailNotificationReceived();
    }

    @When("the user opens the email")
    public void theUserOpensTheEmail() {
        openEmailNotification();
    }

    @Then("the email should contain details about the product")
    public void theEmailShouldContainDetailsAboutTheProduct() {
        verifyEmailContainsProductDetails();
    }

    @Then("a link to the product page")
    public void aLinkToTheProductPage() {
        verifyEmailContainsProductPageLink();
    }

    @Given("a user is subscribed to product availability alerts")
    public void aUserIsSubscribedToProductAvailabilityAlerts() {
        verifyUserSubscription();
    }

    @When("the user chooses to unsubscribe from alerts")
    public void theUserChoosesToUnsubscribeFromAlerts() {
        unsubscribeFromAlerts();
    }

    @Then("the user should receive confirmation of unsubscription")
    public void theUserShouldReceiveConfirmationOfUnsubscription() {
        verifyUnsubscriptionConfirmation();
    }

    @Then("the user should no longer receive notifications for the product availability")
    public void theUserShouldNoLongerReceiveNotificationsForTheProductAvailability() {
        verifyNoFurtherNotifications();
    }
}