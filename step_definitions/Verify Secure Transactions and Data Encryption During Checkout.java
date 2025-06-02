package com.cucumber.steps;

import com.page_objects.CheckoutPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutSteps extends CheckoutPage {

    @Given("a user with items in the cart")
    public void userWithItemsInCart() {
        addItemsToCart();
    }

    @When("the user navigates to the checkout page")
    public void navigateToCheckoutPage() {
        proceedToCheckout();
    }

    @Then("the checkout page is displayed with SSL encryption")
    public void verifyCheckoutPageSSL() {
        verifySSLOnCheckoutPage();
    }

    @Given("the checkout page is displayed with SSL encryption")
    public void checkoutPageWithSSL() {
        verifySSLOnCheckoutPage();
    }

    @When("the user checks the SSL certificate")
    public void checkSSLCertificate() {
        verifySSLCertificate();
    }

    @Then("the SSL certificate is valid and active")
    public void verifySSLCertificateValidity() {
        assertSSLCertificateValidity();
    }

    @Given("the user is on the checkout page")
    public void userOnCheckoutPage() {
        proceedToCheckout();
    }

    @When("the user enters payment details including card number {string}, expiry date {string}, and CVV {string}")
    public void enterPaymentDetails(String cardNumber, String expiryDate, String cvv) {
        enterCreditCardDetails(cardNumber, expiryDate, cvv);
    }

    @Then("the payment details are entered securely")
    public void verifySecurePaymentDetailsEntry() {
        assertSecurePaymentDetailsEntry();
    }

    @Given("the payment details are entered securely")
    public void paymentDetailsEnteredSecurely() {
        assertSecurePaymentDetailsEntry();
    }

    @When("the user submits the payment information")
    public void submitPaymentInformation() {
        submitPaymentDetails();
    }

    @Then("the payment information is submitted securely")
    public void verifySecurePaymentSubmission() {
        assertSecurePaymentSubmission();
    }

    @Given("the payment information is submitted securely")
    public void paymentInformationSubmittedSecurely() {
        assertSecurePaymentSubmission();
    }

    @When("the transaction is processed")
    public void processTransaction() {
        processTransactionSecurely();
    }

    @Then("data is encrypted during the transaction")
    public void verifyDataEncryptionDuringTransaction() {
        assertDataEncryptionDuringTransaction();
    }

    @Given("the transaction is processed")
    public void transactionProcessed() {
        processTransactionSecurely();
    }

    @When("checking for security alerts or notifications")
    public void checkSecurityAlerts() {
        checkForSecurityAlerts();
    }

    @Then("no security alerts or notifications are triggered")
    public void verifyNoSecurityAlerts() {
        assertNoSecurityAlerts();
    }

    @When("the user checks the transaction status")
    public void checkTransactionStatus() {
        verifyTransactionStatus();
    }

    @Then("the transaction is processed successfully and confirmation is received")
    public void verifyTransactionSuccess() {
        assertTransactionSuccess();
    }

    @Given("the transaction is processed successfully")
    public void transactionProcessedSuccessfully() {
        assertTransactionSuccess();
    }

    @When("the user views their transaction history")
    public void viewTransactionHistory() {
        viewUserTransactionHistory();
    }

    @Then("the transaction details are correctly recorded in the history")
    public void verifyTransactionDetailsInHistory() {
        assertTransactionDetailsInHistory();
    }

    @When("the payment gateway logs the transaction")
    public void logTransactionInPaymentGateway() {
        logTransactionSecurelyInGateway();
    }

    @Then("the transaction is logged securely in the payment gateway")
    public void verifySecureLoggingInGateway() {
        assertSecureLoggingInGateway();
    }

    @When("checking for data leaks or breaches")
    public void checkForDataLeaks() {
        checkForDataLeaksOrBreaches();
    }

    @Then("no data leaks or breaches are detected")
    public void verifyNoDataLeaks() {
        assertNoDataLeaksOrBreaches();
    }

    @When("verifying the encryption protocol used")
    public void verifyEncryptionProtocol() {
        verifyEncryptionProtocolUpToDate();
    }

    @Then("the encryption protocol is up to date and secure")
    public void verifyEncryptionProtocolSecurity() {
        assertEncryptionProtocolSecurity();
    }

    @When("the user enters payment details using {string}")
    public void enterPaymentDetailsUsingMethod(String paymentMethod) {
        enterPaymentDetailsUsingMethod(paymentMethod);
    }

    @Then("all payment methods are processed securely")
    public void verifySecurePaymentMethodsProcessing() {
        assertSecurePaymentMethodsProcessing();
    }

    @Given("the transaction is in progress")
    public void transactionInProgress() {
        initiateTransaction();
    }

    @When("a network interruption occurs")
    public void simulateNetworkInterruption() {
        simulateNetworkInterruptionDuringTransaction();
    }

    @Then("the transaction resumes securely after interruption")
    public void verifyTransactionResumption() {
        assertTransactionResumptionAfterInterruption();
    }

    @Given("a user with incorrect payment details")
    public void userWithIncorrectPaymentDetails() {
        enterIncorrectPaymentDetails();
    }

    @Then("the system alerts the user and does not process the transaction")
    public void verifySystemAlertForIncorrectDetails() {
        assertSystemAlertForIncorrectDetails();
    }

    @When("the transaction is completed")
    public void completeTransaction() {
        completeTransactionProcess();
    }

    @Then("a confirmation email is sent securely with transaction details")
    public void verifyConfirmationEmailSent() {
        assertConfirmationEmailSentSecurely();
    }
}