package com.cucumber.steps;

import com.pageobjects.SAPInboundFilePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class SAPInboundFileSteps {

    private SAPInboundFilePage sapInboundFilePage = new SAPInboundFilePage();

    @Given("the user has valid SAP S/4HANA credentials")
    public void theUserHasValidSAPCredentials() {
        sapInboundFilePage.verifySAPCredentials();
    }

    @When("the user logs into the SAP S/4HANA system")
    public void theUserLogsIntoSAPSystem() {
        sapInboundFilePage.loginToSAPSystem();
    }

    @Then("the user is successfully logged into the SAP S/4HANA system")
    public void theUserIsSuccessfullyLoggedIn() {
        sapInboundFilePage.verifySuccessfulLogin();
    }

    @Given("the user is logged into the SAP S/4HANA system")
    public void theUserIsLoggedIntoSAPSystem() {
        sapInboundFilePage.ensureUserLoggedIn();
    }

    @When("the user navigates to the Sales Order processing screen")
    public void theUserNavigatesToSalesOrderScreen() {
        sapInboundFilePage.navigateToSalesOrderScreen();
    }

    @Then("the Sales Order processing screen is displayed")
    public void theSalesOrderScreenIsDisplayed() {
        sapInboundFilePage.verifySalesOrderScreenDisplayed();
    }

    @Given("the user is on the Sales Order processing screen")
    public void theUserIsOnSalesOrderScreen() {
        sapInboundFilePage.ensureOnSalesOrderScreen();
    }

    @Given("a pipe-delimited file with {string} is prepared")
    public void aPipeDelimitedFileIsPrepared(String fileCondition) {
        sapInboundFilePage.preparePipeDelimitedFile(fileCondition);
    }

    @When("the user uploads the file using the inbound interface")
    public void theUserUploadsFile() {
        sapInboundFilePage.uploadFileUsingInboundInterface();
    }

    @Then("the system {string}")
    public void theSystemPerformsAction(String systemAction) {
        sapInboundFilePage.verifySystemAction(systemAction);
    }

    @Given("the user has uploaded a pipe-delimited file with maximum allowable null fields")
    public void theUserHasUploadedFileWithMaxNullFields() {
        sapInboundFilePage.uploadFileWithMaxNullFields();
    }

    @When("the user attempts to display or process sales orders from the uploaded file")
    public void theUserAttemptsToDisplayOrProcessSalesOrders() {
        sapInboundFilePage.attemptToDisplayOrProcessSalesOrders();
    }

    @Then("the system rejects the file and logs an error indicating the null fields")
    public void theSystemRejectsFileAndLogsError() {
        sapInboundFilePage.verifyFileRejectionAndErrorLog();
    }

    @When("the user checks the system log")
    public void theUserChecksSystemLog() {
        sapInboundFilePage.checkSystemLog();
    }

    @Then("the error logs clearly indicate the null fields")
    public void theErrorLogsIndicateNullFields() {
        sapInboundFilePage.verifyErrorLogsForNullFields();
    }

    @When("the user attempts to view or process sales orders")
    public void theUserAttemptsToViewOrProcessSalesOrders() {
        sapInboundFilePage.attemptToViewOrProcessSalesOrders();
    }

    @Then("no sales orders are displayed or processed")
    public void noSalesOrdersDisplayedOrProcessed() {
        sapInboundFilePage.verifyNoSalesOrdersDisplayedOrProcessed();
    }

    @When("the system logs an error")
    public void theSystemLogsAnError() {
        sapInboundFilePage.logSystemError();
    }

    @Then("the error message provides clear details about the null fields and corrective actions")
    public void theErrorMessageProvidesDetails() {
        sapInboundFilePage.verifyErrorMessageDetails();
    }

    @Given("the user has corrected the data in the pipe-delimited file")
    public void theUserHasCorrectedFileData() {
        sapInboundFilePage.correctFileData();
    }

    @When("the user uploads the corrected file using the inbound interface")
    public void theUserUploadsCorrectedFile() {
        sapInboundFilePage.uploadCorrectedFile();
    }

    @Then("the system accepts and processes the corrected file successfully")
    public void theSystemProcessesCorrectedFile() {
        sapInboundFilePage.verifyCorrectedFileProcessing();
    }

    @Given("the user has uploaded a corrected pipe-delimited file")
    public void theUserHasUploadedCorrectedFile() {
        sapInboundFilePage.uploadCorrectedFile();
    }

    @When("the system processes the file")
    public void theSystemProcessesFile() {
        sapInboundFilePage.processUploadedFile();
    }

    @Then("valid sales orders are created and displayed in the system")
    public void validSalesOrdersCreatedAndDisplayed() {
        sapInboundFilePage.verifyValidSalesOrdersCreated();
    }

    @Given("the user uploads a pipe-delimited file with null fields")
    public void theUserUploadsFileWithNullFields() {
        sapInboundFilePage.uploadFileWithNullFields();
    }

    @Then("the system consistently rejects files with null fields")
    public void theSystemRejectsFilesWithNullFields() {
        sapInboundFilePage.verifyConsistentFileRejection();
    }

    @Then("the error log entries are stored and accessible for audit")
    public void theErrorLogEntriesStoredForAudit() {
        sapInboundFilePage.verifyErrorLogStorageForAudit();
    }

    @Then("notifications are sent to the relevant stakeholders with error details")
    public void notificationsSentToStakeholders() {
        sapInboundFilePage.verifyErrorNotificationsSent();
    }
}
