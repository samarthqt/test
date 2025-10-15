package com.cucumber.steps;

import com.pageobjects.SalesDocumentPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class SalesDocumentSteps {

    private SalesDocumentPage salesDocumentPage = new SalesDocumentPage();

    @Given("the user is logged into the SAP S/4HANA Cloud system")
    public void theUserIsLoggedIntoTheSAPSystem() {
        salesDocumentPage.loginToSAPSystem();
    }

    @Given("the user logs in to the SAP system with valid credentials")
    public void theUserLogsInToTheSAPSystemWithValidCredentials() {
        salesDocumentPage.loginToSAPSystem("validUsername", "validPassword");
    }

    @Given("user logs in to the SAP system with valid credentials")
    public void userLogsInToSAPSystem() {
        salesDocumentPage.loginToSAPSystem("validUsername", "validPassword");
    }

    @Given("the user navigates to the transaction for creating Sales documents")
    public void theUserNavigatesToTransactionForCreatingSalesDocuments() {
        salesDocumentPage.navigateToSalesDocumentTransaction();
    }

    @Given("the user navigates to the transaction code for creating Sales documents {string}")
    public void theUserNavigatesToTheTransactionCodeForCreatingSalesDocuments(String transactionCode) {
        salesDocumentPage.navigateToTransactionCode(transactionCode);
    }

    @When("user navigates to the transaction code for creating Sales documents {string}")
    public void userNavigatesToTransactionCode(String transactionCode) {
        salesDocumentPage.navigateToTransactionCode(transactionCode);
    }

    @Given("the user inputs the original Billing document number {string} as the reference")
    public void theUserInputsOriginalBillingDocumentNumberAsReference(String billingDocumentNumber) {
        salesDocumentPage.inputBillingDocumentNumber(billingDocumentNumber);
    }

    @When("the user inputs the Billing document ID {string} in the reference field")
    public void theUserInputsTheBillingDocumentIDInTheReferenceField(String billingDocumentId) {
        salesDocumentPage.inputBillingDocumentId(billingDocumentId);
    }

    @When("user inputs the Billing document ID {string} in the reference field")
    public void userInputsBillingDocumentID(String billingDocumentID) {
        salesDocumentPage.inputBillingDocumentID(billingDocumentID);
    }

    @Given("the reference items contain non-unique partner data {string}")
    public void theReferenceItemsContainNonUniquePartnerData(String referenceItems) {
        salesDocumentPage.inputReferenceItems(referenceItems);
    }

    @Given("the header partner data is missing in the Billing document")
    public void theHeaderPartnerDataIsMissingInTheBillingDocument() {
        salesDocumentPage.verifyHeaderPartnerDataIsMissing();
    }

    @When("the user selects the Sales document type {string} for creation")
    public void theUserSelectsTheSalesDocumentTypeForCreation(String salesDocumentType) {
        salesDocumentPage.selectSalesDocumentType(salesDocumentType);
    }

    @When("user selects the Sales document type {string} for creation")
    public void userSelectsSalesDocumentType(String salesDocumentType) {
        salesDocumentPage.selectSalesDocumentType(salesDocumentType);
    }

    @When("the user executes the FV45C003 routine for copying partner data")
    public void theUserExecutesTheFV45C003RoutineForCopyingPartnerData() {
        salesDocumentPage.executeFV45C003Routine();
    }

    @When("user executes the FV45C003 routine for copying partner data")
    public void userExecutesFV45C003Routine() {
        salesDocumentPage.executeFV45C003Routine();
    }

    @When("the user executes the creation process for the Sales document")
    public void theUserExecutesCreationProcessForSalesDocument() {
        salesDocumentPage.executeSalesDocumentCreation();
    }

    @Then("the system processes the Billing document and identifies missing partner data {string}")
    public void theSystemProcessesTheBillingDocumentAndIdentifiesMissingPartnerData(String missingPartnerData) {
        salesDocumentPage.verifyMissingPartnerData(missingPartnerData);
    }

    @Then("the system identifies non-unique partner data in the reference items")
    public void theSystemIdentifiesNonUniquePartnerDataInReferenceItems() {
        salesDocumentPage.verifyNonUniquePartnerDataInReferenceItems();
    }

    @Then("the system identifies non-unique partner data and aborts the process")
    public void theSystemIdentifiesNonUniquePartnerDataAndAbortsTheProcess() {
        salesDocumentPage.verifyNonUniquePartnerData();
    }

    @Then("the system displays a detailed error message {string}")
    public void theSystemDisplaysADetailedErrorMessage(String errorMessage) {
        salesDocumentPage.verifyErrorMessage(errorMessage);
    }

    @Then("the system aborts the creation process with the error message {string}")
    public void theSystemAbortsCreationProcessWithErrorMessage(String errorMessage) {
        salesDocumentPage.verifyErrorMessage(errorMessage);
    }

    @When("the user attempts to save the Sales document despite the error")
    public void theUserAttemptsToSaveTheSalesDocumentDespiteTheError() {
        salesDocumentPage.attemptToSaveSalesDocument();
    }

    @Then("the system prevents saving the Sales document")
    public void theSystemPreventsSavingTheSalesDocument() {
        salesDocumentPage.verifySavePrevention();
    }

    @Then("the system prevents saving of the document and retains data integrity")
    public void theSystemPreventsSavingOfDocumentAndRetainsDataIntegrity() {
        salesDocumentPage.verifyDocumentNotSaved();
    }

    @Then("the Billing document remains unaltered")
    public void theBillingDocumentRemainsUnaltered() {
        salesDocumentPage.verifyBillingDocumentUnaltered();
    }

    @Then("the system logs the error in the audit trail")
    public void theSystemLogsTheErrorInTheAuditTrail() {
        salesDocumentPage.verifyErrorLoggingInAuditTrail();
    }

    @When("the user generates a report of the attempted Sales document creation")
    public void theUserGeneratesAReportOfTheAttemptedSalesDocumentCreation() {
        salesDocumentPage.generateSalesDocumentCreationReport();
    }

    @Then("the report shows the attempt failed due to {string}")
    public void theReportShowsTheAttemptFailedDueTo(String failureReason) {
        salesDocumentPage.verifyReportFailureReason(failureReason);
    }

    @Then("the user notifies the relevant team about the error for resolution")
    public void theUserNotifiesRelevantTeamAboutErrorForResolution() {
        salesDocumentPage.notifyRelevantTeam();
    }

    @Then("user notifies the relevant team about the error for resolution")
    public void userNotifiesTheRelevantTeamAboutTheErrorForResolution() {
        salesDocumentPage.notifyRelevantTeam();
    }

    @Then("the user logs out of the system")
    public void theUserLogsOutOfTheSystem() {
        salesDocumentPage.logoutFromSAPSystem();
    }

    @When("the user logs out of the SAP system")
    public void theUserLogsOutOfTheSAPSystem() {
        salesDocumentPage.logoutOfSAPSystem();
    }

    @Then("the user is logged out successfully")
    public void theUserIsLoggedOutSuccessfully() {
        salesDocumentPage.verifySuccessfulLogout();
    }

    @Then("user logs out of the SAP system successfully")
    public void userLogsOutOfSAPSystem() {
        salesDocumentPage.logoutOfSAPSystem();
    }
}
