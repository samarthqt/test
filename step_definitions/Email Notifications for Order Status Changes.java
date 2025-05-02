package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmailNotificationSteps extends EmailNotificationPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user has placed an order")
    public void aUserHasPlacedAnOrder() {
        String orderId = testHarness.getData("OrderData", "OrderId");
        verifyOrderPlaced(orderId);
    }

    @When("the order status changes to {string}")
    public void theOrderStatusChangesTo(String status) {
        updateOrderStatus(status);
    }

    @Then("an email notification should be sent to the user")
    public void anEmailNotificationShouldBeSentToTheUser() {
        String userEmail = testHarness.getData("UserData", "Email");
        verifyEmailSent(userEmail);
    }

    @Then("the email should contain the order details")
    public void theEmailShouldContainTheOrderDetails() {
        String orderDetails = testHarness.getData("OrderData", "Details");
        verifyEmailContainsOrderDetails(orderDetails);
    }

    @Then("the email should indicate that the order has been {string}")
    public void theEmailShouldIndicateThatTheOrderHasBeen(String status) {
        verifyEmailContainsStatus(status);
    }

    @Then("no email notification should be sent to the user")
    public void noEmailNotificationShouldBeSentToTheUser() {
        String userEmail = testHarness.getData("UserData", "Email");
        verifyNoEmailSent(userEmail);
    }

    @Then("the email should contain the user's name and email address")
    public void theEmailShouldContainTheUsersNameAndEmailAddress() {
        String userName = testHarness.getData("UserData", "Name");
        String userEmail = testHarness.getData("UserData", "Email");
        verifyEmailContainsUserInfo(userName, userEmail);
    }

    @Given("the user has opted out of email notifications")
    public void theUserHasOptedOutOfEmailNotifications() {
        optOutOfEmailNotifications();
    }
}