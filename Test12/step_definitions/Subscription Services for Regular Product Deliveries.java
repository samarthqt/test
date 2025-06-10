package com.cucumber.steps;

import com.page_objects.SubscriptionPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SubscriptionSteps extends SubscriptionPage {

    @Given("a user is logged into their account")
    public void aUserIsLoggedIntoTheirAccount() {
        loginToAccount();
    }

    @When("the user navigates to the subscription services section")
    public void theUserNavigatesToTheSubscriptionServicesSection() {
        navigateToSubscriptionServices();
    }

    @When("the user selects a product to subscribe to")
    public void theUserSelectsAProductToSubscribeTo() {
        selectProductForSubscription();
    }

    @When("the user chooses a delivery frequency option \(e.g., weekly, monthly\)")
    public void theUserChoosesADeliveryFrequencyOption() {
        chooseDeliveryFrequency();
    }

    @Then("the user should be subscribed to the regular product deliveries")
    public void theUserShouldBeSubscribedToTheRegularProductDeliveries() {
        verifySubscriptionSuccess();
    }

    @Given("a user is subscribed to regular product deliveries")
    public void aUserIsSubscribedToRegularProductDeliveries() {
        verifyUserSubscription();
    }

    @When("a delivery date is approaching")
    public void aDeliveryDateIsApproaching() {
        checkUpcomingDeliveryDate();
    }

    @Then("the user should receive a notification for the upcoming delivery")
    public void theUserShouldReceiveANotificationForTheUpcomingDelivery() {
        verifyNotificationReceived();
    }

    @When("the user navigates to the subscription management section")
    public void theUserNavigatesToTheSubscriptionManagementSection() {
        navigateToSubscriptionManagement();
    }

    @Then("the user should be able to view and manage their subscriptions")
    public void theUserShouldBeAbleToViewAndManageTheirSubscriptions() {
        verifySubscriptionManagementAccess();
    }

    @When("the user selects a subscription to cancel")
    public void theUserSelectsASubscriptionToCancel() {
        selectSubscriptionToCancel();
    }

    @Then("the subscription should be successfully canceled")
    public void theSubscriptionShouldBeSuccessfullyCanceled() {
        verifySubscriptionCancellation();
    }

    @When("the user selects a subscription to modify")
    public void theUserSelectsASubscriptionToModify() {
        selectSubscriptionToModify();
    }

    @When("the user changes the delivery frequency or product")
    public void theUserChangesTheDeliveryFrequencyOrProduct() {
        modifySubscriptionDetails();
    }

    @Then("the subscription should be successfully updated with the new details")
    public void theSubscriptionShouldBeSuccessfullyUpdatedWithTheNewDetails() {
        verifySubscriptionUpdate();
    }
}