package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.OrderConfirmationPage;

public class OrderConfirmationSteps extends OrderConfirmationPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user completes the checkout process")
    public void aUserCompletesTheCheckoutProcess() {
        completeCheckoutProcess();
    }

    @When("the order is placed successfully")
    public void theOrderIsPlacedSuccessfully() {
        placeOrderSuccessfully();
    }

    @Then("the user should receive an order confirmation via email")
    public void theUserShouldReceiveAnOrderConfirmationViaEmail() {
        verifyEmailConfirmationReceived();
    }

    @Then("the user should receive an order confirmation via SMS")
    public void theUserShouldReceiveAnOrderConfirmationViaSMS() {
        verifySMSConfirmationReceived();
    }

    @Given("a user receives an order confirmation")
    public void aUserReceivesAnOrderConfirmation() {
        receiveOrderConfirmation();
    }

    @Then("the confirmation should include the order number")
    public void theConfirmationShouldIncludeTheOrderNumber() {
        verifyOrderNumberIncluded();
    }

    @Then("the confirmation should include the shipping address")
    public void theConfirmationShouldIncludeTheShippingAddress() {
        verifyShippingAddressIncluded();
    }

    @Then("the confirmation should include the items purchased")
    public void theConfirmationShouldIncludeTheItemsPurchased() {
        verifyItemsPurchasedIncluded();
    }

    @Then("the confirmation should include the estimated delivery date")
    public void theConfirmationShouldIncludeTheEstimatedDeliveryDate() {
        verifyEstimatedDeliveryDateIncluded();
    }

    @Then("the system should ensure timely delivery of confirmation messages")
    public void theSystemShouldEnsureTimelyDeliveryOfConfirmationMessages() {
        ensureTimelyDeliveryOfMessages();
    }

    @Then("the confirmation message should be formatted for easy reading")
    public void theConfirmationMessageShouldBeFormattedForEasyReading() {
        verifyMessageFormatting();
    }

    @Then("the user should be able to access order details from the confirmation message")
    public void theUserShouldBeAbleToAccessOrderDetailsFromTheConfirmationMessage() {
        accessOrderDetailsFromMessage();
    }

    @Then("the system should log the confirmation message for record-keeping")
    public void theSystemShouldLogTheConfirmationMessageForRecordKeeping() {
        logConfirmationMessage();
    }
}