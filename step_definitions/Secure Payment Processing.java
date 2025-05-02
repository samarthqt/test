package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SecurePaymentSteps extends SecurePaymentPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user initiates a payment transaction")
    public void aUserInitiatesAPaymentTransaction() {
        initiatePaymentTransaction();
    }

    @When("the payment details are entered")
    public void thePaymentDetailsAreEntered() {
        enterPaymentDetails(testHarness.getData("PaymentData", "CardNumber"), testHarness.getData("PaymentData", "ExpiryDate"), testHarness.getData("PaymentData", "CVV"));
    }

    @Then("the payment details should be encrypted")
    public void thePaymentDetailsShouldBeEncrypted() {
        verifyPaymentDetailsEncrypted();
    }

    @Given("a user is on the payment page")
    public void aUserIsOnThePaymentPage() {
        navigateToPaymentPage();
    }

    @When("the payment page is loaded")
    public void thePaymentPageIsLoaded() {
        verifyPageLoaded();
    }

    @Then("the connection should be secured with HTTPS")
    public void theConnectionShouldBeSecuredWithHTTPS() {
        verifyConnectionSecured();
    }

    @Given("a user provides payment information")
    public void aUserProvidesPaymentInformation() {
        providePaymentInformation(testHarness.getData("PaymentData", "CardNumber"), testHarness.getData("PaymentData", "ExpiryDate"), testHarness.getData("PaymentData", "CVV"));
    }

    @When("the payment is processed")
    public void thePaymentIsProcessed() {
        processPayment();
    }

    @Then("the user data should be protected")
    public void theUserDataShouldBeProtected() {
        verifyUserDataProtected();
    }

    @Given("a payment transaction is completed")
    public void aPaymentTransactionIsCompleted() {
        completePaymentTransaction();
    }

    @When("the confirmation is sent to the user")
    public void theConfirmationIsSentToTheUser() {
        sendConfirmation();
    }

    @Then("the confirmation should be securely delivered")
    public void theConfirmationShouldBeSecurelyDelivered() {
        verifyConfirmationSecurelyDelivered();
    }

    @Given("payment data is received")
    public void paymentDataIsReceived() {
        receivePaymentData();
    }

    @When("the data is stored")
    public void theDataIsStored() {
        storePaymentData();
    }

    @Then("the payment data should be stored securely")
    public void thePaymentDataShouldBeStoredSecurely() {
        verifyPaymentDataStoredSecurely();
    }

    @Given("sensitive payment information is provided")
    public void sensitivePaymentInformationIsProvided() {
        provideSensitivePaymentInformation(testHarness.getData("PaymentData", "CardNumber"), testHarness.getData("PaymentData", "ExpiryDate"), testHarness.getData("PaymentData", "CVV"));
    }

    @When("the information is transmitted")
    public void theInformationIsTransmitted() {
        transmitInformation();
    }

    @Then("the information should be encrypted")
    public void theInformationShouldBeEncrypted() {
        verifyInformationEncrypted();
    }

    @Given("a payment error occurs")
    public void aPaymentErrorOccurs() {
        simulatePaymentError();
    }

    @When("the error is handled")
    public void theErrorIsHandled() {
        handlePaymentError();
    }

    @Then("the error details should be securely handled")
    public void theErrorDetailsShouldBeSecurelyHandled() {
        verifyErrorDetailsSecurelyHandled();
    }
}