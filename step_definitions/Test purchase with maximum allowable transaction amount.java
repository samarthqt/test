package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.PurchasePage;

public class PurchaseSteps extends PurchasePage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into the application")
    public void theUserIsLoggedIntoTheApplication() {
        loginToApplication();
    }

    @When("the user navigates to the product purchase section")
    public void theUserNavigatesToTheProductPurchaseSection() {
        navigateToPurchaseSection();
    }

    @Then("the user should be able to access the purchase section without errors")
    public void theUserShouldBeAbleToAccessThePurchaseSectionWithoutErrors() {
        verifyAccessToPurchaseSection();
    }

    @Given("the user is in the product purchase section")
    public void theUserIsInTheProductPurchaseSection() {
        verifyInPurchaseSection();
    }

    @When("the user selects products to reach the maximum allowable transaction amount")
    public void theUserSelectsProductsToReachTheMaximumAllowableTransactionAmount() {
        selectProductsForMaxTransaction();
    }

    @Then("the products should be added to the cart successfully")
    public void theProductsShouldBeAddedToTheCartSuccessfully() {
        verifyProductsAddedToCart();
    }

    @Given("the user has products in the cart")
    public void theUserHasProductsInTheCart() {
        verifyProductsInCart();
    }

    @When("the user proceeds to checkout and selects a payment method")
    public void theUserProceedsToCheckoutAndSelectsAPaymentMethod() {
        proceedToCheckoutAndSelectPayment();
    }

    @Then("the checkout process should proceed without errors")
    public void theCheckoutProcessShouldProceedWithoutErrors() {
        verifyCheckoutProcess();
    }

    @Given("the user is at the checkout page")
    public void theUserIsAtTheCheckoutPage() {
        verifyAtCheckoutPage();
    }

    @When("the total transaction amount is displayed")
    public void theTotalTransactionAmountIsDisplayed() {
        displayTotalTransactionAmount();
    }

    @Then("the total amount should equal the maximum allowable transaction amount")
    public void theTotalAmountShouldEqualTheMaximumAllowableTransactionAmount() {
        verifyTotalAmountEqualsMax();
    }

    @Given("the user is ready to make a payment")
    public void theUserIsReadyToMakeAPayment() {
        readyToMakePayment();
    }

    @When("the user initiates the payment process")
    public void theUserInitiatesThePaymentProcess() {
        initiatePaymentProcess();
    }

    @Then("the payment process should begin, showing a loading indicator")
    public void thePaymentProcessShouldBeginShowingALoadingIndicator() {
        verifyPaymentProcessInitiated();
    }

    @Given("the payment process has been initiated")
    public void thePaymentProcessHasBeenInitiated() {
        verifyPaymentProcessInitiated();
    }

    @When("the payment details are processed")
    public void thePaymentDetailsAreProcessed() {
        processPaymentDetails();
    }

    @Then("the payment details should be encrypted and processed securely")
    public void thePaymentDetailsShouldBeEncryptedAndProcessedSecurely() {
        verifyPaymentDetailsSecurity();
    }

    @Given("the payment process is in progress")
    public void thePaymentProcessIsInProgress() {
        verifyPaymentInProgress();
    }

    @When("the transaction is being processed")
    public void theTransactionIsBeingProcessed() {
        processTransaction();
    }

    @Then("no error messages should be displayed related to transaction limits")
    public void noErrorMessagesShouldBeDisplayedRelatedToTransactionLimits() {
        verifyNoTransactionLimitErrors();
    }

    @Given("the transaction has been processed")
    public void theTransactionHasBeenProcessed() {
        verifyTransactionProcessed();
    }

    @When("the transaction logs are checked")
    public void theTransactionLogsAreChecked() {
        checkTransactionLogs();
    }

    @Then("logs should accurately reflect the transaction details and status")
    public void logsShouldAccuratelyReflectTheTransactionDetailsAndStatus() {
        verifyTransactionLogs();
    }

    @Given("the transaction is successful")
    public void theTransactionIsSuccessful() {
        verifyTransactionSuccess();
    }

    @When("the payment is completed")
    public void thePaymentIsCompleted() {
        completePayment();
    }

    @Then("the user should receive an email/SMS confirmation of the successful transaction")
    public void theUserShouldReceiveAnEmailSMSConfirmationOfTheSuccessfulTransaction() {
        verifyConfirmationReceived();
    }

    @Given("the system supports multiple transactions")
    public void theSystemSupportsMultipleTransactions() {
        verifySystemSupportsMultipleTransactions();
    }

    @When("multiple transactions are made at the maximum amount")
    public void multipleTransactionsAreMadeAtTheMaximumAmount() {
        makeMultipleMaxTransactions();
    }

    @Then("the system should process multiple transactions at maximum amount without errors")
    public void theSystemShouldProcessMultipleTransactionsAtMaximumAmountWithoutErrors() {
        verifyMultipleTransactionsProcessed();
    }

    @Given("the user attempts a transaction exceeding the maximum amount")
    public void theUserAttemptsATransactionExceedingTheMaximumAmount() {
        attemptExceedingTransaction();
    }

    @When("the transaction is initiated")
    public void theTransactionIsInitiated() {
        initiateTransaction();
    }

    @Then("the system should display an error message if the transaction amount exceeds the maximum limit")
    public void theSystemShouldDisplayAnErrorMessageIfTheTransactionAmountExceedsTheMaximumLimit() {
        verifyExceedingTransactionError();
    }

    @Given("the transaction amount exceeds the limit")
    public void theTransactionAmountExceedsTheLimit() {
        verifyTransactionAmountExceedsLimit();
    }

    @When("the user adjusts the transaction amount")
    public void theUserAdjustsTheTransactionAmount() {
        adjustTransactionAmount();
    }

    @Then("the user should be able to adjust the transaction amount if it exceeds the limit")
    public void theUserShouldBeAbleToAdjustTheTransactionAmountIfItExceedsTheLimit() {
        verifyTransactionAmountAdjusted();
    }

    @Given("the system processes transactions")
    public void theSystemProcessesTransactions() {
        verifySystemProcessesTransactions();
    }

    @When("the transaction limits are checked")
    public void theTransactionLimitsAreChecked() {
        checkTransactionLimits();
    }

    @Then("the system should comply with all relevant financial regulations regarding transaction limits")
    public void theSystemShouldComplyWithAllRelevantFinancialRegulationsRegardingTransactionLimits() {
        verifyComplianceWithRegulations();
    }

    @Given("the user is on the transaction page")
    public void theUserIsOnTheTransactionPage() {
        navigateToTransactionPage();
    }

    @When("the transaction limits are displayed")
    public void theTransactionLimitsAreDisplayed() {
        displayTransactionLimits();
    }

    @Then("the UI should clearly display information about transaction limits and options")
    public void theUIShouldClearlyDisplayInformationAboutTransactionLimitsAndOptions() {
        verifyTransactionLimitsDisplayed();
    }

    @Given("a high-value transaction is processed")
    public void aHighValueTransactionIsProcessed() {
        processHighValueTransaction();
    }

    @When("the transaction is completed")
    public void theTransactionIsCompleted() {
        completeTransaction();
    }

    @Then("no security vulnerabilities should be exposed during high-value transactions")
    public void noSecurityVulnerabilitiesShouldBeExposedDuringHighValueTransactions() {
        verifyNoSecurityVulnerabilities();
    }
}