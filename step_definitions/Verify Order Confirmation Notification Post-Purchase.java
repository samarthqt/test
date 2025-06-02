package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.OrderConfirmationPage;

public class OrderConfirmationSteps extends OrderConfirmationPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into the application")
    public void theUserIsLoggedIntoTheApplication() {
        loginToApplication();
    }

    @When("the user completes a purchase transaction")
    public void theUserCompletesAPurchaseTransaction() {
        completePurchaseTransaction();
    }

    @Then("the purchase transaction is completed successfully")
    public void thePurchaseTransactionIsCompletedSuccessfully() {
        verifyPurchaseCompletion();
    }

    @Then("the user has completed a purchase")
    public void theUserHasCompletedAPurchase() {
        verifyPurchaseCompletion();
    }

    @Given("the user's email is \"user@example.com\"")
    public void theUsersEmailIs() {
        setUserEmail("user@example.com");
    }

    @When("the purchase transaction is completed")
    public void thePurchaseTransactionIsCompleted() {
        completePurchaseTransaction();
    }

    @Then("the user receives an order confirmation email with correct order details")
    public void theUserReceivesAnOrderConfirmationEmailWithCorrectOrderDetails() {
        verifyOrderConfirmationEmail();
    }

    @Given("the user's phone number is \"+1234567890\"")
    public void theUsersPhoneNumberIs() {
        setUserPhoneNumber("+1234567890");
    }

    @Then("the user receives an order confirmation SMS with correct order details")
    public void theUserReceivesAnOrderConfirmationSMSWithCorrectOrderDetails() {
        verifyOrderConfirmationSMS();
    }

    @Given("the user has received an order confirmation email")
    public void theUserHasReceivedAnOrderConfirmationEmail() {
        checkEmailReceived();
    }

    @Then("the email contains order ID, product details, and total amount")
    public void theEmailContainsOrderIDProductDetailsAndTotalAmount() {
        verifyEmailContent();
    }

    @Given("the user has received an order confirmation SMS")
    public void theUserHasReceivedAnOrderConfirmationSMS() {
        checkSMSReceived();
    }

    @Then("the SMS contains order ID and total amount")
    public void theSMSContainsOrderIDAndTotalAmount() {
        verifySMSContent();
    }

    @Given("the user has completed a purchase")
    public void theUserHasCompletedAPurchase() {
        verifyPurchaseCompletion();
    }

    @Then("notifications are received immediately after purchase")
    public void notificationsAreReceivedImmediatelyAfterPurchase() {
        verifyNotificationTimeliness();
    }

    @When("the user logs out from the account")
    public void theUserLogsOutFromTheAccount() {
        logoutFromApplication();
    }

    @Then("the user is logged out successfully")
    public void theUserIsLoggedOutSuccessfully() {
        verifyLogoutSuccess();
    }
}