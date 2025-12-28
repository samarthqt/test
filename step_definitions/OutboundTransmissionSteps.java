package com.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import com.pageobjects.OutboundTransmissionPage;

public class OutboundTransmissionSteps {

    private OutboundTransmissionPage outboundTransmissionPage = new OutboundTransmissionPage();

    @Given("the user has authorized credentials")
    public void theUserHasAuthorizedCredentials() {
        outboundTransmissionPage.authorizeCredentials("username", "password");
    }

    @When("the user logs into SAP S/4HANA")
    public void theUserLogsIntoSAP() {
        outboundTransmissionPage.loginToSAP();
    }

    @Then("the user is successfully logged in")
    public void theUserIsSuccessfullyLoggedIn() {
        outboundTransmissionPage.verifyLoginSuccess();
    }

    @Then("the Model N interface is active and ready to receive data")
    public void theModelNInterfaceIsActive() {
        outboundTransmissionPage.verifyModelNInterfaceActive();
    }

    @Given("the user is logged into SAP S/4HANA")
    public void theUserIsLoggedIntoSAP() {
        outboundTransmissionPage.verifyUserLoggedIn();
    }

    @When("the user navigates to transaction ZOTC_SALES_ORDER")
    public void theUserNavigatesToTransaction() {
        outboundTransmissionPage.navigateToTransaction("ZOTC_SALES_ORDER");
    }

    @Then("the transaction ZOTC_SALES_ORDER is opened")
    public void theTransactionIsOpened() {
        outboundTransmissionPage.verifyTransactionOpened("ZOTC_SALES_ORDER");
    }

    @Then("test data for direct sales is available")
    public void testDataIsAvailable() {
        outboundTransmissionPage.verifyTestDataAvailability();
    }

    @Given("the user is on the ZOTC_SALES_ORDER transaction")
    public void theUserIsOnTransaction() {
        outboundTransmissionPage.verifyUserOnTransaction("ZOTC_SALES_ORDER");
    }

    @When("the user enters valid data including Product Number {string}, Ship-to {string}, Sold-to {string}, Quantity {string}, Amount {string}, and Invoice Number {string}")
    public void theUserEntersValidData(String productNumber, String shipTo, String soldTo, String quantity, String amount, String invoiceNumber) {
        outboundTransmissionPage.enterBillingData(productNumber, shipTo, soldTo, quantity, amount, invoiceNumber);
    }

    @Then("the data is entered without errors")
    public void theDataIsEnteredWithoutErrors() {
        outboundTransmissionPage.verifyDataEntrySuccess();
    }

    @Given("the user has entered valid data for the billing document")
    public void theUserHasEnteredValidData() {
        outboundTransmissionPage.verifyValidDataEntered();
    }

    @When("the user saves the direct sales billing document")
    public void theUserSavesBillingDocument() {
        outboundTransmissionPage.saveBillingDocument();
    }

    @Then("the billing document is saved successfully")
    public void theBillingDocumentIsSavedSuccessfully() {
        outboundTransmissionPage.verifyBillingDocumentSaved();
    }

    @Given("the billing document is saved successfully")
    public void theBillingDocumentIsSaved() {
        outboundTransmissionPage.verifyBillingDocumentSaved();
    }

    @When("the user triggers the outbound interface to send the billing document to Model N")
    public void theUserTriggersOutboundInterface() {
        outboundTransmissionPage.triggerOutboundInterface();
    }

    @Then("the outbound interface is triggered successfully")
    public void theOutboundInterfaceIsTriggeredSuccessfully() {
        outboundTransmissionPage.verifyOutboundInterfaceTriggered();
    }

    @Given("the outbound interface is triggered successfully")
    public void theOutboundInterfaceIsTriggered() {
        outboundTransmissionPage.verifyOutboundInterfaceTriggered();
    }

    @When("the user monitors the outbound transmission logs")
    public void theUserMonitorsLogs() {
        outboundTransmissionPage.monitorTransmissionLogs();
    }

    @Then("the logs indicate successful transmission of the direct sales billing document")
    public void theLogsIndicateSuccess() {
        outboundTransmissionPage.verifyTransmissionLogsSuccess();
    }

    @Given("the direct sales billing document is transmitted successfully")
    public void theBillingDocumentIsTransmitted() {
        outboundTransmissionPage.verifyBillingDocumentTransmitted();
    }

    @When("the user verifies data reception in Model N")
    public void theUserVerifiesDataReception() {
        outboundTransmissionPage.verifyDataReceptionInModelN();
    }

    @Then("Model N receives the billing document with all required fields")
    public void modelNReceivesBillingDocument() {
        outboundTransmissionPage.verifyModelNDataReception();
    }

    @When("the user checks the entries in ZOTC_CROSSREFTAB")
    public void theUserChecksEntries() {
        outboundTransmissionPage.checkCrossRefTabEntries();
    }

    @Then("the entries confirm that new document types are updated correctly")
    public void theEntriesConfirmUpdates() {
        outboundTransmissionPage.verifyCrossRefTabUpdates();
    }

    @When("the user validates the linkage between the billing document and Model N")
    public void theUserValidatesLinkage() {
        outboundTransmissionPage.validateLinkageBetweenBillingDocumentAndModelN();
    }

    @Then("the linkage is established successfully")
    public void theLinkageIsEstablishedSuccessfully() {
        outboundTransmissionPage.verifyLinkageEstablished();
    }

    @When("the user reviews error logs")
    public void theUserReviewsErrorLogs() {
        outboundTransmissionPage.reviewErrorLogs();
    }

    @Then("no errors are logged")
    public void noErrorsAreLogged() {
        outboundTransmissionPage.verifyNoErrorsLogged();
    }

    @When("the user generates a report of transmitted billing documents")
    public void theUserGeneratesReport() {
        outboundTransmissionPage.generateTransmittedDocumentsReport();
    }

    @Then("the report shows all transmitted documents including the tested one")
    public void theReportShowsTransmittedDocuments() {
        outboundTransmissionPage.verifyReportContents();
    }

    @When("the user confirms the financial calculations in Model N based on the transmitted data")
    public void theUserConfirmsFinancialCalculations() {
        outboundTransmissionPage.confirmFinancialCalculationsInModelN();
    }

    @Then("Model N calculates rebates and administrative fees accurately")
    public void modelNCalculatesFeesAccurately() {
        outboundTransmissionPage.verifyFinancialCalculationsAccuracy();
    }
}
