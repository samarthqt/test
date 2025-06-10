package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.PaymentPage;

public class PaymentSteps extends PaymentPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is on the payment page")
    public void theUserIsOnThePaymentPage() {
        navigateToPaymentPage();
    }

    @When("the user selects a payment method")
    public void theUserSelectsAPaymentMethod() {
        selectPaymentMethod(testHarness.getData("PaymentData", "PaymentMethod"));
    }

    @Then("the user should be able to choose between Stripe and PayPal")
    public void theUserShouldBeAbleToChooseBetweenStripeAndPayPal() {
        verifyPaymentOptions();
    }

    @Given("the user initiates a payment")
    public void theUserInitiatesAPayment() {
        initiatePayment();
    }

    @When("the payment is processed")
    public void thePaymentIsProcessed() {
        processPayment();
    }

    @Then("the transaction should be secure and encrypted")
    public void theTransactionShouldBeSecureAndEncrypted() {
        verifyTransactionSecurity();
    }

    @Given("the user completes a payment successfully")
    public void theUserCompletesAPaymentSuccessfully() {
        completePayment();
    }

    @When("the payment is confirmed")
    public void thePaymentIsConfirmed() {
        confirmPayment();
    }

    @Then("the system should send a confirmation and receipt to the user")
    public void theSystemShouldSendAConfirmationAndReceiptToTheUser() {
        verifyConfirmationAndReceipt();
    }

    @When("the payment fails")
    public void thePaymentFails() {
        failPayment();
    }

    @Then("an error message should be displayed to the user")
    public void anErrorMessageShouldBeDisplayedToTheUser() {
        verifyErrorMessage();
    }

    @When("the user starts the payment process")
    public void theUserStartsThePaymentProcess() {
        startPaymentProcess();
    }

    @Then("the interface should guide the user through the payment steps")
    public void theInterfaceShouldGuideTheUserThroughThePaymentSteps() {
        verifyPaymentGuidance();
    }

    @Given("the payment system is integrated")
    public void thePaymentSystemIsIntegrated() {
        integratePaymentSystem();
    }

    @When("the payment process is initiated")
    public void thePaymentProcessIsInitiated() {
        initiatePaymentProcess();
    }

    @Then("the integration should comply with industry security standards")
    public void theIntegrationShouldComplyWithIndustrySecurityStandards() {
        verifySecurityCompliance();
    }

    @Given("a payment transaction is completed")
    public void aPaymentTransactionIsCompleted() {
        completeTransaction();
    }

    @When("the transaction is processed")
    public void theTransactionIsProcessed() {
        processTransaction();
    }

    @Then("the system should log the transaction for auditing purposes")
    public void theSystemShouldLogTheTransactionForAuditingPurposes() {
        verifyTransactionLogging();
    }

    @Given("the user is logged into their account")
    public void theUserIsLoggedIntoTheirAccount() {
        loginToAccount();
    }

    @When("the user navigates to the payment history section")
    public void theUserNavigatesToThePaymentHistorySection() {
        navigateToPaymentHistory();
    }

    @Then("the user should be able to view their payment history")
    public void theUserShouldBeAbleToViewTheirPaymentHistory() {
        verifyPaymentHistory();
    }

    @Then("the application should support multiple payment methods")
    public void theApplicationShouldSupportMultiplePaymentMethods() {
        verifyMultiplePaymentMethods();
    }

    @Then("the integration should be optimized for performance")
    public void theIntegrationShouldBeOptimizedForPerformance() {
        verifyPerformanceOptimization();
    }
}