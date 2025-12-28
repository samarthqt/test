package com.cucumber.steps;

import com.pageobjects.InvoiceCorrectionPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class InvoiceCorrectionSteps {

    private InvoiceCorrectionPage invoiceCorrectionPage = new InvoiceCorrectionPage();
    private TestHarness testHarness = new TestHarness();

    @Given("the user has valid credentials")
    public void theUserHasValidCredentials() {
        invoiceCorrectionPage.enterCredentials("validUsername", "validPassword");
    }

    @When("the user logs into the SAP S/4HANA system")
    public void theUserLogsIntoTheSAPSystem() {
        invoiceCorrectionPage.clickLoginButton();
    }

    @Then("the user should be successfully logged in and have access to the Invoice Correction Request module")
    public void theUserShouldBeLoggedInSuccessfully() {
        invoiceCorrectionPage.verifyModuleAccess("Invoice Correction Request");
    }

    @Given("the user is logged into the SAP S/4HANA system")
    public void theUserIsLoggedIntoTheSAPSystem() {
        invoiceCorrectionPage.verifyLoginStatus();
    }

    @When("the user navigates to the Invoice Correction Request creation screen")
    public void theUserNavigatesToTheInvoiceCorrectionScreen() {
        invoiceCorrectionPage.navigateToCorrectionRequestScreen();
    }

    @Then("the Invoice Correction Request creation screen should be displayed")
    public void theInvoiceCorrectionScreenShouldBeDisplayed() {
        invoiceCorrectionPage.verifyScreenDisplayed("Invoice Correction Request");
    }

    @Given("the user is on the Invoice Correction Request creation screen")
    public void theUserIsOnTheCorrectionScreen() {
        invoiceCorrectionPage.verifyScreenDisplayed("Invoice Correction Request");
    }

    @When("the user selects an existing sales invoice {string} for correction")
    public void theUserSelectsAnExistingInvoice(String invoiceNumber) {
        invoiceCorrectionPage.selectInvoice(invoiceNumber);
    }

    @Then("the selected invoice details should be populated on the screen")
    public void theSelectedInvoiceDetailsShouldBePopulated() {
        invoiceCorrectionPage.verifyInvoiceDetailsPopulated();
    }

    @Given("the user has selected an invoice for correction")
    public void theUserHasSelectedAnInvoice() {
        invoiceCorrectionPage.verifyInvoiceSelection();
    }

    @When("the user enters the correction type as {string}")
    public void theUserEntersCorrectionType(String correctionType) {
        invoiceCorrectionPage.enterCorrectionType(correctionType);
    }

    @Then("the correction type {string} should be accepted and displayed")
    public void theCorrectionTypeShouldBeDisplayed(String correctionType) {
        invoiceCorrectionPage.verifyCorrectionTypeDisplayed(correctionType);
    }

    @Given("the user has entered the correction type")
    public void theUserHasEnteredCorrectionType() {
        invoiceCorrectionPage.verifyCorrectionTypeEntered();
    }

    @When("the user enters the price adjustment as {string}")
    public void theUserEntersPriceAdjustment(String priceAdjustment) {
        invoiceCorrectionPage.enterPriceAdjustment(priceAdjustment);
    }

    @Then("the price adjustment {string} should be accepted and displayed")
    public void thePriceAdjustmentShouldBeDisplayed(String priceAdjustment) {
        invoiceCorrectionPage.verifyPriceAdjustmentDisplayed(priceAdjustment);
    }

    @Given("the user has entered the price adjustment")
    public void theUserHasEnteredPriceAdjustment() {
        invoiceCorrectionPage.verifyPriceAdjustmentEntered();
    }

    @When("the user enters the quantity adjustment as {string}")
    public void theUserEntersQuantityAdjustment(String quantityAdjustment) {
        invoiceCorrectionPage.enterQuantityAdjustment(quantityAdjustment);
    }

    @Then("the quantity adjustment {string} should be accepted and displayed")
    public void theQuantityAdjustmentShouldBeDisplayed(String quantityAdjustment) {
        invoiceCorrectionPage.verifyQuantityAdjustmentDisplayed(quantityAdjustment);
    }

    @Given("the user has entered all required details for the Invoice Correction Request")
    public void theUserHasEnteredAllDetails() {
        invoiceCorrectionPage.verifyAllDetailsEntered();
    }

    @When("the user saves the Invoice Correction Request")
    public void theUserSavesTheCorrectionRequest() {
        invoiceCorrectionPage.saveCorrectionRequest();
    }

    @Then("the Invoice Correction Request should be saved successfully with a unique request number")
    public void theCorrectionRequestShouldBeSavedSuccessfully() {
        invoiceCorrectionPage.verifyCorrectionRequestSaved();
    }

    @Given("the Invoice Correction Request has been saved successfully")
    public void theCorrectionRequestHasBeenSaved() {
        invoiceCorrectionPage.verifyCorrectionRequestSaved();
    }

    @When("the system generates a debit memo {string} for the correction request")
    public void theSystemGeneratesDebitMemo(String debitMemo) {
        invoiceCorrectionPage.generateDebitMemo(debitMemo);
    }

    @Then("the debit memo {string} should be generated successfully and linked to the correction request")
    public void theDebitMemoShouldBeGeneratedSuccessfully(String debitMemo) {
        invoiceCorrectionPage.verifyDebitMemoGenerated(debitMemo);
    }

    @Given("the debit memo has been generated and linked to the correction request")
    public void theDebitMemoHasBeenGenerated() {
        invoiceCorrectionPage.verifyDebitMemoLinked();
    }

    @When("the user views the document flow")
    public void theUserViewsDocumentFlow() {
        invoiceCorrectionPage.viewDocumentFlow();
    }

    @Then("the linkage between the correction request and the original billing document should be correctly displayed")
    public void theLinkageShouldBeCorrectlyDisplayed() {
        invoiceCorrectionPage.verifyDocumentFlowLinkage();
    }

    @Given("the debit memo has been generated")
    public void theDebitMemoHasBeenGeneratedSuccessfully() {
        invoiceCorrectionPage.verifyDebitMemoGeneratedSuccessfully();
    }

    @When("the user checks the financial postings for the debit memo")
    public void theUserChecksFinancialPostings() {
        invoiceCorrectionPage.checkFinancialPostings();
    }

    @Then("the financial postings should reflect the price and quantity adjustments accurately")
    public void theFinancialPostingsShouldBeAccurate() {
        invoiceCorrectionPage.verifyFinancialPostingsAccuracy();
    }

    @Given("the user has completed all actions")
    public void theUserHasCompletedAllActions() {
        invoiceCorrectionPage.verifyAllActionsCompleted();
    }

    @When("the user logs out of the SAP S/4HANA system")
    public void theUserLogsOutOfTheSAPSystem() {
        invoiceCorrectionPage.clickLogoutButton();
    }

    @Then("the user should be logged out successfully")
    public void theUserShouldBeLoggedOutSuccessfully() {
        invoiceCorrectionPage.verifyLogoutSuccess();
    }
}
