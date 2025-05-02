package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderConfirmationSteps extends OrderConfirmationPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user completes a purchase on the retail platform")
    public void userCompletesPurchase() {
        completePurchase();
    }

    @When("the transaction is successfully processed")
    public void transactionProcessed() {
        processTransaction();
    }

    @Then("an order confirmation email should be sent to the user's registered email address")
    public void orderConfirmationEmailSent() {
        verifyEmailSent();
    }

    @Then("the email should contain details of the transaction including order number, items purchased, total amount, and billing information")
    public void verifyEmailContent() {
        verifyEmailDetails();
    }

    @Then("the user should receive the email within a reasonable time frame after the purchase completion")
    public void verifyEmailReceiptTime() {
        verifyEmailReceiptTime();
    }

    @Given("a user attempts to make a purchase on the retail platform")
    public void userAttemptsPurchase() {
        attemptPurchase();
    }

    @When("the transaction fails")
    public void transactionFails() {
        failTransaction();
    }

    @Then("no order confirmation email should be sent to the user")
    public void noEmailSent() {
        verifyNoEmailSent();
    }

    @Given("a user has completed a purchase")
    public void userHasCompletedPurchase() {
        completePurchase();
    }

    @When("the order confirmation email is received")
    public void emailReceived() {
        receiveEmail();
    }

    @Then("the email should contain the correct order number")
    public void verifyOrderNumber() {
        verifyOrderNumber();
    }

    @Then("the email should list all the items purchased")
    public void verifyItemsPurchased() {
        verifyItemsPurchased();
    }

    @Then("the email should show the correct total amount")
    public void verifyTotalAmount() {
        verifyTotalAmount();
    }

    @Then("the email should include accurate billing information")
    public void verifyBillingInformation() {
        verifyBillingInformation();
    }

    @Given("a user has completed a purchase")
    public void userCompletedPurchase() {
        completePurchase();
    }

    @Given("the user requests a resend of the order confirmation email")
    public void userRequestsResend() {
        requestEmailResend();
    }

    @When("the request is processed")
    public void processResendRequest() {
        processResendRequest();
    }

    @Then("the order confirmation email should be resent to the user's registered email address")
    public void emailResent() {
        verifyEmailResent();
    }

    @Given("a user completes a purchase")
    public void userCompletesPurchaseAgain() {
        completePurchase();
    }

    @Given("the user's registered email address is invalid")
    public void invalidEmailAddress() {
        setInvalidEmailAddress();
    }

    @When("the system attempts to send the order confirmation email")
    public void systemAttemptsEmailSend() {
        attemptEmailSend();
    }

    @Then("the system should log an error indicating the invalid email address")
    public void logInvalidEmailError() {
        logEmailError();
    }

    @Then("no order confirmation email should be sent")
    public void noEmailSentDueToInvalidAddress() {
        verifyNoEmailSent();
    }

    @Then("the user should be notified to update their email address")
    public void notifyUserToUpdateEmail() {
        notifyUserToUpdateEmail();
    }
}