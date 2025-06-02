package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.CheckoutPage;

public class CheckoutSteps extends CheckoutPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user logs in to the application with valid credentials")
    public void theUserLogsInToTheApplicationWithValidCredentials() {
        String username = testHarness.getData("LoginData", "Username");
        String password = testHarness.getData("LoginData", "Password");
        login(username, password);
    }

    @Given("navigates to the checkout page")
    public void navigatesToTheCheckoutPage() {
        navigateToCheckoutPage();
    }

    @When("the user enters payment details and confirms the payment")
    public void theUserEntersPaymentDetailsAndConfirmsThePayment() {
        String cardNumber = testHarness.getData("PaymentData", "CardNumber");
        String expiryDate = testHarness.getData("PaymentData", "ExpiryDate");
        String cvv = testHarness.getData("PaymentData", "CVV");
        enterPaymentDetails(cardNumber, expiryDate, cvv);
        confirmPayment();
    }

    @Then("the payment is processed successfully")
    public void thePaymentIsProcessedSuccessfully() {
        verifyPaymentSuccess();
    }

    @Then("a confirmation message is displayed immediately")
    public void aConfirmationMessageIsDisplayedImmediately() {
        verifyConfirmationMessage();
    }

    @Given("the payment is processed successfully")
    public void thePaymentIsProcessedSuccessfullyAgain() {
        verifyPaymentSuccess();
    }

    @When("the user checks the email notification")
    public void theUserChecksTheEmailNotification() {
        checkEmailNotification();
    }

    @Then("the email notification is received with payment confirmation")
    public void theEmailNotificationIsReceivedWithPaymentConfirmation() {
        verifyEmailNotification();
    }

    @When("the user verifies the transaction details in the order history")
    public void theUserVerifiesTheTransactionDetailsInTheOrderHistory() {
        verifyTransactionDetailsInOrderHistory();
    }

    @Then("the transaction details are updated in the order history")
    public void theTransactionDetailsAreUpdatedInTheOrderHistory() {
        verifyTransactionDetailsUpdate();
    }

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        verifyUserLoggedIn();
    }

    @When("the user logs out from the application")
    public void theUserLogsOutFromTheApplication() {
        logout();
    }

    @Then("the user is logged out successfully")
    public void theUserIsLoggedOutSuccessfully() {
        verifyLogoutSuccess();
    }

    @When("the user repeats the payment process using a different payment method")
    public void theUserRepeatsThePaymentProcessUsingADifferentPaymentMethod() {
        String newPaymentMethod = testHarness.getData("PaymentData", "NewPaymentMethod");
        repeatPaymentProcess(newPaymentMethod);
    }

    @Then("a confirmation message is displayed successfully for the different payment method")
    public void aConfirmationMessageIsDisplayedSuccessfullyForTheDifferentPaymentMethod() {
        verifyConfirmationMessage();
    }

    @When("the user attempts payment with incorrect payment details")
    public void theUserAttemptsPaymentWithIncorrectPaymentDetails() {
        String incorrectCardNumber = testHarness.getData("PaymentData", "IncorrectCardNumber");
        enterIncorrectPaymentDetails(incorrectCardNumber);
    }

    @Then("the system displays an error message for invalid payment details")
    public void theSystemDisplaysAnErrorMessageForInvalidPaymentDetails() {
        verifyErrorMessageForInvalidPaymentDetails();
    }

    @When("the user attempts payment without entering payment details")
    public void theUserAttemptsPaymentWithoutEnteringPaymentDetails() {
        attemptPaymentWithoutDetails();
    }

    @Then("the system displays an error message for missing payment details")
    public void theSystemDisplaysAnErrorMessageForMissingPaymentDetails() {
        verifyErrorMessageForMissingPaymentDetails();
    }

    @When("the payment is declined")
    public void thePaymentIsDeclined() {
        simulatePaymentDecline();
    }

    @Then("the system displays an error message for declined payment")
    public void theSystemDisplaysAnErrorMessageForDeclinedPayment() {
        verifyErrorMessageForDeclinedPayment();
    }

    @When("the payment gateway is unavailable")
    public void thePaymentGatewayIsUnavailable() {
        simulatePaymentGatewayUnavailability();
    }

    @Then("the system displays an error message for unavailable payment gateway")
    public void theSystemDisplaysAnErrorMessageForUnavailablePaymentGateway() {
        verifyErrorMessageForUnavailablePaymentGateway();
    }

    @When("the network connection is lost during payment")
    public void theNetworkConnectionIsLostDuringPayment() {
        simulateNetworkConnectionLoss();
    }

    @Then("the system displays an error message for network connection issues")
    public void theSystemDisplaysAnErrorMessageForNetworkConnectionIssues() {
        verifyErrorMessageForNetworkConnectionIssues();
    }

    @When("the user attempts payment with expired payment method")
    public void theUserAttemptsPaymentWithExpiredPaymentMethod() {
        String expiredCardNumber = testHarness.getData("PaymentData", "ExpiredCardNumber");
        enterExpiredPaymentDetails(expiredCardNumber);
    }

    @Then("the system displays an error message for expired payment method")
    public void theSystemDisplaysAnErrorMessageForExpiredPaymentMethod() {
        verifyErrorMessageForExpiredPaymentMethod();
    }

    @When("the payment is successful but the confirmation message is delayed")
    public void thePaymentIsSuccessfulButTheConfirmationMessageIsDelayed() {
        simulateDelayedConfirmationMessage();
    }

    @Then("the system eventually displays the confirmation message after a delay")
    public void theSystemEventuallyDisplaysTheConfirmationMessageAfterADelay() {
        verifyDelayedConfirmationMessage();
    }
}