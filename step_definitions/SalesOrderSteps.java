package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.pageobjects.SalesOrderPage;
import com.pageobjects.BillingPage;

public class SalesOrderSteps {

    private SalesOrderPage salesOrderPage = new SalesOrderPage();
    private BillingPage billingPage = new BillingPage();
    private TestHarness testHarness = new TestHarness();

    @Given("the user logs into the SAP system and navigates to the ZOTC_SALES_ORDER program")
    public void theUserLogsIntoTheSAPSystemAndNavigatesToTheZOTCSALESORDERProgram() {
        salesOrderPage.loginToSAP();
        salesOrderPage.navigateToSalesOrderProgram();
    }

    @When("the user creates a new sales order with billing document type {string} using valid customer and product data")
    public void theUserCreatesANewSalesOrderWithBillingDocumentTypeUsingValidCustomerAndProductData(String billingDocumentType) {
        salesOrderPage.createSalesOrder(billingDocumentType);
    }

    @Then("the sales order is successfully created with the billing document type {string}")
    public void theSalesOrderIsSuccessfullyCreatedWithTheBillingDocumentType(String billingDocumentType) {
        salesOrderPage.verifySalesOrderCreation(billingDocumentType);
    }

    @When("the user processes the sales order to generate a billing document")
    public void theUserProcessesTheSalesOrderToGenerateABillingDocument() {
        salesOrderPage.processSalesOrderToBillingDocument();
    }

    @Then("the billing document is successfully generated without errors")
    public void theBillingDocumentIsSuccessfullyGeneratedWithoutErrors() {
        salesOrderPage.verifyBillingDocumentGeneration();
    }

    @Then("the generated billing document reflects the correct document type {string}")
    public void theGeneratedBillingDocumentReflectsTheCorrectDocumentType(String billingDocumentType) {
        salesOrderPage.verifyBillingDocumentType(billingDocumentType);
    }

    @Then("the ZOTC_CROSSREFTAB table contains the correct mapping for the document type {string}")
    public void theZOTCCROSSREFTABTableContainsTheCorrectMappingForTheDocumentType(String billingDocumentType) {
        salesOrderPage.verifyCrossReferenceTableMapping(billingDocumentType);
    }

    @Then("the document flow shows the correct linkage between the sales order and the billing document")
    public void theDocumentFlowShowsTheCorrectLinkageBetweenTheSalesOrderAndTheBillingDocument() {
        salesOrderPage.verifyDocumentFlowLinkage();
    }

    @Then("the financial postings created for the billing document are accurate and align with the sales order details")
    public void theFinancialPostingsCreatedForTheBillingDocumentAreAccurateAndAlignWithTheSalesOrderDetails() {
        salesOrderPage.verifyFinancialPostings();
    }

    @Then("the billing document type {string} is included in the Direct Sales reporting")
    public void theBillingDocumentTypeIsIncludedInTheDirectSalesReporting(String billingDocumentType) {
        salesOrderPage.verifyDirectSalesReporting(billingDocumentType);
    }

    @Then("the tax calculations for the billing document are accurate and comply with the configured rules")
    public void theTaxCalculationsForTheBillingDocumentAreAccurateAndComplyWithTheConfiguredRules() {
        salesOrderPage.verifyTaxCalculations();
    }

    @When("the user creates and processes a second sales order with billing document type ZF2 using valid customer and product data")
    public void theUserCreatesAndProcessesASecondSalesOrderWithBillingDocumentTypeZF2UsingValidCustomerAndProductData() {
        salesOrderPage.createAndProcessSecondSalesOrder();
    }

    @Then("the second sales order and billing document are processed successfully with the correct document type ZF2")
    public void theSecondSalesOrderAndBillingDocumentAreProcessedSuccessfullyWithTheCorrectDocumentTypeZF2() {
        salesOrderPage.verifySecondSalesOrderProcessing();
    }

    @Given("the user has processed sales orders with billing document type ZF2")
    public void theUserHasProcessedSalesOrdersWithBillingDocumentTypeZF2() {
        salesOrderPage.verifyProcessedSalesOrders();
    }

    @When("the user checks the system logs")
    public void theUserChecksTheSystemLogs() {
        salesOrderPage.checkSystemLogs();
    }

    @Then("the system logs confirm successful processing without errors")
    public void theSystemLogsConfirmSuccessfulProcessingWithoutErrors() {
        salesOrderPage.verifySystemLogs();
    }

    @Given("the user has completed validation of ZF2 billing document processing")
    public void theUserHasCompletedValidationOfZF2BillingDocumentProcessing() {
        salesOrderPage.completeValidation();
    }

    @When("the user logs out of the SAP system")
    public void theUserLogsOutOfTheSAPSystem() {
        salesOrderPage.logoutFromSAP();
    }

    @Then("the user is successfully logged out")
    public void theUserIsSuccessfullyLoggedOut() {
        salesOrderPage.verifyLogout();
    }

    @Given("the user logs into the SAP S/4HANA Cloud system using valid credentials")
    public void theUserLogsIntoTheSAPSystemUsingValidCredentials() {
        salesOrderPage.loginToSAP();
    }

    @Given("the user navigates to the Sales Order creation screen")
    public void theUserNavigatesToTheSalesOrderCreationScreen() {
        salesOrderPage.navigateToSalesOrderCreationScreen();
    }

    @When("the user creates a Sales Order of type ZOR with Attribute1 set to {string} and Attribute2 set to {string}")
    public void theUserCreatesASalesOrderWithAttributes(String attribute1, String attribute2) {
        salesOrderPage.createSalesOrder(attribute1, attribute2);
    }

    @Then("the Sales Order is created successfully with a unique Order ID")
    public void theSalesOrderIsCreatedSuccessfullyWithAUniqueOrderID() {
        salesOrderPage.verifySalesOrderCreation();
    }

    @Then("the user navigates to the billing due program screen")
    public void theUserNavigatesToTheBillingDueProgramScreen() {
        billingPage.navigateToBillingDueProgramScreen();
    }

    @When("the user triggers the billing due program for the created Sales Order")
    public void theUserTriggersTheBillingDueProgramForTheCreatedSalesOrder() {
        billingPage.triggerBillingDueProgram();
    }

    @Then("the billing due program completes successfully without errors")
    public void theBillingDueProgramCompletesSuccessfullyWithoutErrors() {
        billingPage.verifyBillingDueProgramCompletion();
    }

    @Then("a billing document is created successfully for the Sales Order")
    public void aBillingDocumentIsCreatedSuccessfullyForTheSalesOrder() {
        billingPage.verifyBillingDocumentCreation();
    }

    @Then("the user navigates to the billing document display screen")
    public void theUserNavigatesToTheBillingDocumentDisplayScreen() {
        billingPage.navigateToBillingDocumentDisplayScreen();
    }

    @Then("the Attribute1 value in the billing document matches {string}")
    public void theAttribute1ValueInTheBillingDocumentMatches(String attribute1) {
        billingPage.verifyAttribute1InBillingDocument(attribute1);
    }

    @Then("the user captures the details of the billing document for audit purposes")
    public void theUserCapturesTheDetailsOfTheBillingDocumentForAuditPurposes() {
        billingPage.captureBillingDocumentDetails();
    }

    @Then("the linkage between the Sales Order and the billing document is verified successfully")
    public void theLinkageBetweenTheSalesOrderAndTheBillingDocumentIsVerifiedSuccessfully() {
        billingPage.verifyLinkageBetweenSalesOrderAndBillingDocument();
    }

    @When("the user navigates to the Sales Order module and selects the option to create a new Sales Order")
    public void theUserNavigatesToSalesOrderModule() {
        salesOrderPage.navigateToSalesOrderModule();
    }

    @When("the user enters the required details for the Sales Order with KATR1 \"{string}\" and KATR2 \"{string}\"")
    public void theUserEntersSalesOrderDetails(String katr1, String katr2) {
        salesOrderPage.enterSalesOrderDetails(katr1, katr2);
    }

    @When("the user saves the Sales Order and notes the Sales Order number")
    public void theUserSavesTheSalesOrder() {
        salesOrderPage.saveSalesOrder();
    }

    @When("the user navigates to the Billing module and selects the option to create a Billing Document")
    public void theUserNavigatesToBillingModule() {
        billingPage.navigateToBillingModule();
    }

    @When("the user enters the Sales Order number created in the previous step")
    public void theUserEntersSalesOrderNumber() {
        billingPage.enterSalesOrderNumber(salesOrderPage.getSalesOrderNumber());
    }

    @When("the user executes the process to copy the Sales Order to a Billing Document")
    public void theUserExecutesCopyProcess() {
        billingPage.executeCopyProcess();
    }

    @Then("the system displays a clear and meaningful error message indicating the invalid attribute values")
    public void theSystemDisplaysErrorMessage() {
        billingPage.verifyErrorMessage("Invalid KATR1/KATR2 combination");
    }

    @Then("the Billing Document is not created, and the process is halted")
    public void theBillingDocumentIsNotCreated() {
        billingPage.verifyBillingDocumentNotCreated();
    }

    @Then("the user is successfully logged in and navigates to the SAP home screen")
    public void theUserIsSuccessfullyLoggedIn() {
        salesOrderPage.verifyHomeScreen();
    }

    @When("the user logs out of the SAP system")
    public void theUserLogsOut() {
        salesOrderPage.logoutFromSAP();
    }

    @Then("the user is successfully logged out of the system")
    public void theUserIsSuccessfullyLoggedOut() {
        salesOrderPage.verifyLogout();
    }

    @Given("the user has completed the validation of invalid KATR1/KATR2 combinations")
    public void theUserHasCompletedValidation() {
        // Placeholder for validation completion
    }

    @When("the user documents the error messages and system behavior")
    public void theUserDocumentsErrorMessages() {
        salesOrderPage.documentErrorMessages();
    }

    @Then("the error messages and system behavior are documented for review")
    public void theErrorMessagesAreDocumented() {
        salesOrderPage.verifyDocumentation();
    }
}
