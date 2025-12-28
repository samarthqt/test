package com.cucumber.steps;

import com.pageobjects.Routine962Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class Routine962Steps {

    private Routine962Page routine962Page = new Routine962Page();
    private TestHarness testHarness = new TestHarness();

    @Given("the user has valid credentials")
    public void theUserHasValidCredentials() {
        routine962Page.validateCredentials();
    }

    @When("the user logs in to the SAP system")
    public void theUserLogsInToTheSAPSystem() {
        routine962Page.loginToSAP();
    }

    @Then("the user is successfully logged in and has access to the relevant modules")
    public void theUserIsSuccessfullyLoggedIn() {
        routine962Page.verifyLoginSuccess();
    }

    @Given("the user is logged in to the SAP system")
    public void theUserIsLoggedInToTheSAPSystem() {
        routine962Page.verifyLoginSuccess();
    }

    @When("the user navigates to the sales order creation module")
    public void theUserNavigatesToSalesOrderCreationModule() {
        routine962Page.navigateToSalesOrderModule();
    }

    @Then("the sales order creation screen is displayed")
    public void theSalesOrderCreationScreenIsDisplayed() {
        routine962Page.verifySalesOrderCreationScreen();
    }

    @Given("the user is on the sales order creation screen")
    public void theUserIsOnTheSalesOrderCreationScreen() {
        routine962Page.verifySalesOrderCreationScreen();
    }

    @When("the user creates a {string} order with the maximum allowed line items using the provided test data")
    public void theUserCreatesOrderWithMaximumLineItems(String orderType) {
        routine962Page.createOrderWithMaxLineItems(orderType);
    }

    @Then("the {string} order with maximum line items is created successfully")
    public void theOrderWithMaximumLineItemsIsCreatedSuccessfully(String orderType) {
        routine962Page.verifyOrderCreation(orderType);
    }

    @Given("the user has created orders with maximum allowed line items")
    public void theUserHasCreatedOrdersWithMaximumLineItems() {
        routine962Page.verifyOrdersCreated();
    }

    @When("the user navigates to the billing workflow module")
    public void theUserNavigatesToBillingWorkflowModule() {
        routine962Page.navigateToBillingWorkflow();
    }

    @Then("the billing workflow screen is displayed")
    public void theBillingWorkflowScreenIsDisplayed() {
        routine962Page.verifyBillingWorkflowScreen();
    }

    @Given("the user is on the billing workflow screen")
    public void theUserIsOnTheBillingWorkflowScreen() {
        routine962Page.verifyBillingWorkflowScreen();
    }

    @When("the user processes the {string} order through the billing workflow")
    public void theUserProcessesOrderThroughBillingWorkflow(String orderType) {
        routine962Page.processOrderThroughBillingWorkflow(orderType);
    }

    @Then("the {string} order is processed successfully without any issues")
    public void theOrderIsProcessedSuccessfully(String orderType) {
        routine962Page.verifyOrderProcessing(orderType);
    }

    @Given("the user has processed an invoice-list relevant order through the billing workflow")
    public void theUserHasProcessedInvoiceListRelevantOrder() {
        routine962Page.verifyInvoiceListOrderProcessed();
    }

    @When("the user verifies the output determination for the invoice-list relevant order")
    public void theUserVerifiesOutputDeterminationForInvoiceListOrder() {
        routine962Page.verifyOutputDeterminationForInvoiceListOrder();
    }

    @Then("routine 962 does not trigger outputs for the invoice-list relevant order, as expected")
    public void routine962DoesNotTriggerOutputsForInvoiceListOrder() {
        routine962Page.verifyRoutine962NoOutputForInvoiceListOrder();
    }

    @Given("the user has processed a non-invoice-list relevant order through the billing workflow")
    public void theUserHasProcessedNonInvoiceListRelevantOrder() {
        routine962Page.verifyNonInvoiceListOrderProcessed();
    }

    @When("the user verifies the output determination for the non-invoice-list relevant order")
    public void theUserVerifiesOutputDeterminationForNonInvoiceListOrder() {
        routine962Page.verifyOutputDeterminationForNonInvoiceListOrder();
    }

    @Then("routine 962 triggers outputs correctly for the non-invoice-list relevant order, as expected")
    public void routine962TriggersOutputsForNonInvoiceListOrder() {
        routine962Page.verifyRoutine962OutputForNonInvoiceListOrder();
    }

    @Given("the user has processed both invoice-list relevant and non-invoice-list relevant orders")
    public void theUserHasProcessedBothOrders() {
        routine962Page.verifyBothOrdersProcessed();
    }

    @When("the user checks the output determination logs for both orders")
    public void theUserChecksOutputDeterminationLogs() {
        routine962Page.checkOutputDeterminationLogs();
    }

    @Then("the logs confirm the correct output determination behavior for both orders")
    public void theLogsConfirmCorrectOutputDetermination() {
        routine962Page.verifyOutputDeterminationLogs();
    }

    @When("the user validates the document flow for both orders")
    public void theUserValidatesDocumentFlow() {
        routine962Page.validateDocumentFlow();
    }

    @Then("the document flow reflects the correct output determination behavior for both orders")
    public void theDocumentFlowReflectsCorrectBehavior() {
        routine962Page.verifyDocumentFlow();
    }

    @Given("the user has completed all test steps for routine 962 validation")
    public void theUserHasCompletedAllTestSteps() {
        routine962Page.verifyAllTestStepsCompleted();
    }

    @When("the user documents the results of the test case execution")
    public void theUserDocumentsTestCaseResults() {
        routine962Page.documentTestCaseResults();
    }

    @Then("the test case results are documented successfully")
    public void theTestCaseResultsAreDocumentedSuccessfully() {
        routine962Page.verifyTestCaseResultsDocumented();
    }

    @Given("the user has completed all required actions")
    public void theUserHasCompletedAllRequiredActions() {
        routine962Page.verifyAllActionsCompletion();
    }

    @When("the user logs out of the SAP system")
    public void theUserLogsOutOfTheSAPSystem() {
        routine962Page.clickLogoutButton();
    }

    @Then("the user is logged out successfully")
    public void theUserIsLoggedOutSuccessfully() {
        routine962Page.verifyLogoutSuccess();
    }
}
