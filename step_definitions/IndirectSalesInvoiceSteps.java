package com.cucumber.steps;

import com.pageobjects.IndirectSalesInvoicePage;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class IndirectSalesInvoiceSteps {

    private IndirectSalesInvoicePage indirectSalesInvoicePage = new IndirectSalesInvoicePage();

    @Given("the user is logged into the SAP S/4HANA system with valid credentials")
    public void theUserIsLoggedIntoTheSAPSystem() {
        indirectSalesInvoicePage.loginToSAPSystem("validUsername", "validPassword");
    }

    @When("the user navigates to the transaction code for creating an indirect sales invoice")
    public void theUserNavigatesToTransactionCode() {
        indirectSalesInvoicePage.navigateToTransactionCode("VF01");
    }

    @When("the user enters the billing document type as {string}")
    public void theUserEntersBillingDocumentType(String billingDocumentType) {
        indirectSalesInvoicePage.enterBillingDocumentType(billingDocumentType);
    }

    @When("the user sets the VBTYP value to {string}")
    public void theUserSetsVBTYPValue(String vbtyp) {
        indirectSalesInvoicePage.setVBTYPValue(vbtyp);
    }

    @When("the user provides the Sales Order ID as {string}")
    public void theUserProvidesSalesOrderID(String salesOrderID) {
        indirectSalesInvoicePage.enterSalesOrderID(salesOrderID);
    }

    @When("the user saves the invoice")
    public void theUserSavesTheInvoice() {
        indirectSalesInvoicePage.saveInvoice();
    }

    @Then("the invoice is saved successfully")
    public void theInvoiceIsSavedSuccessfully() {
        indirectSalesInvoicePage.verifyInvoiceSaved();
    }

    @Then("the user navigates to the created invoice and opens the details")
    public void theUserNavigatesToCreatedInvoice() {
        indirectSalesInvoicePage.navigateToCreatedInvoice();
    }

    @Then("the Sale Type field in the invoice is {string}")
    public void theSaleTypeFieldInInvoiceIs(String expectedSaleType) {
        indirectSalesInvoicePage.verifySaleType(expectedSaleType);
    }

    @Then("the relevant tables maintain data consistency")
    public void theRelevantTablesMaintainDataConsistency() {
        indirectSalesInvoicePage.verifyTableDataConsistency();
    }

    @Then("the system logs contain no errors or warnings during the process")
    public void theSystemLogsContainNoErrors() {
        indirectSalesInvoicePage.verifySystemLogs();
    }

    @Then("the invoice is correctly linked in the document flow")
    public void theInvoiceIsCorrectlyLinkedInDocumentFlow() {
        indirectSalesInvoicePage.verifyDocumentFlowLinkage();
    }

    @Then("the output for the created invoice is rendered correctly as per the configuration")
    public void theOutputForCreatedInvoiceIsRenderedCorrectly() {
        indirectSalesInvoicePage.verifyInvoiceOutput();
    }

    @Given("the user has valid credentials")
    public void theUserHasValidCredentials() {
        indirectSalesInvoicePage.enterCredentials("validUsername", "validPassword");
    }

    @When("the user logs into the SAP S/4HANA system")
    public void theUserLogsIntoTheSAPSystem() {
        indirectSalesInvoicePage.loginToSAP();
    }

    @Then("the user is logged in successfully")
    public void theUserIsLoggedInSuccessfully() {
        indirectSalesInvoicePage.verifyLoginSuccess();
    }

    @Given("the user is on the transaction screen for creating an indirect sales invoice after cancellation")
    public void theUserIsOnTheTransactionScreen() {
        indirectSalesInvoicePage.navigateToTransactionScreen();
    }

    @Given("an indirect sales cancellation invoice exists for Sales Order ID {string}")
    public void anIndirectSalesCancellationInvoiceExists(String salesOrderID) {
        indirectSalesInvoicePage.verifyCancellationInvoiceExists(salesOrderID);
    }

    @Then("the Sale Type field in the invoice should be set to {string}")
    public void theSaleTypeFieldShouldBeSet(String expectedSaleType) {
        indirectSalesInvoicePage.verifySaleType(expectedSaleType);
    }

    @Then("no errors or warnings are logged in the system logs")
    public void noErrorsOrWarningsInSystemLogs() {
        indirectSalesInvoicePage.verifySystemLogs();
    }

    @Then("the linkage between the cancellation invoice and the new invoice is correctly established in the document flow")
    public void theLinkageIsCorrectlyEstablished() {
        indirectSalesInvoicePage.verifyCancellationInvoiceLinkage();
    }
}
