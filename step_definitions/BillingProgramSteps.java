package com.cucumber.steps;

import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

import com.pageobjects.BillingProgramPage;
import com.framework.cucumber.TestHarness;

public class BillingProgramSteps {

    private BillingProgramPage billingProgramPage = new BillingProgramPage();
    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into the SAP S/4HANA Cloud system with appropriate credentials and has access to the Finance module")
    public void theUserIsLoggedIntoTheSAPSystem() {
        billingProgramPage.loginToSAPSystem("username", "password");
        billingProgramPage.navigateToFinanceModule();
    }

    @Given("the user logs in to the SAP S/4HANA system with appropriate credentials")
    public void theUserLogsInToTheSAPSystem() {
        String username = testHarness.getData("LoginData", "Username");
        String password = testHarness.getData("LoginData", "Password");
        billingProgramPage.loginToSAPSystem(username, password);
    }

    @Given("the billing program {string} is available for use")
    public void theBillingProgramIsAvailableForUse(String billingProgramName) {
        billingProgramPage.verifyBillingProgramAvailability(billingProgramName);
    }

    @Given("a large set of billing due documents \(e.g., maximum allowable records\) is available for processing")
    public void aLargeSetOfBillingDueDocumentsIsAvailableForProcessing() {
        billingProgramPage.verifyBillingDueDocumentsAvailability();
    }

    @When("the user navigates to the Billing Due Program")
    public void theUserNavigatesToTheBillingDueProgram() {
        billingProgramPage.navigateToBillingDueProgram();
    }

    @When("the user navigates to the billing due program in SAP S/4HANA")
    public void theUserNavigatesToTheBillingDueProgramInSAP() {
        billingProgramPage.navigateToBillingProgram();
    }

    @When("the user navigates to the billing due program configuration screen")
    public void theUserNavigatesToTheBillingDueProgramConfigurationScreen() {
        billingProgramPage.navigateToBillingProgramConfigurationScreen();
    }

    @And("the user navigates to the billing due program configuration screen")
    public void theUserNavigatesToBillingProgramScreen() {
        billingProgramPage.navigateToBillingProgramScreen();
    }

    @When("the user inputs Attribute 1 as {string} and Attribute 2 as {string}")
    public void theUserInputsAttributes(String attribute1, String attribute2) {
        billingProgramPage.inputAttributes(attribute1, attribute2);
    }

    @When("the user configures the program to handle maximum line items exceeding 999")
    public void theUserConfiguresProgramForMaxLineItems() {
        billingProgramPage.configureProgramForMaxLineItems();
    }

    @When("the user loads test data with {string} line items")
    public void theUserLoadsTestData(String lineItems) {
        billingProgramPage.loadTestData(lineItems);
    }

    @When("the user selects the source document with \"{string}\" line items")
    public void theUserSelectsTheSourceDocumentWithLineItems(String lineItems) {
        billingProgramPage.selectSourceDocument(lineItems);
    }

    @When("the user selects the {string} execution mode for the billing program")
    public void theUserSelectsExecutionMode(String executionMode) {
        billingProgramPage.selectExecutionMode(executionMode);
    }

    @And("the user leaves the selection criteria {string}")
    public void theUserLeavesSelectionCriteria(String selectionCriteria) {
        billingProgramPage.leaveSelectionCriteria(selectionCriteria);
    }

    @When("the user enters valid selection criteria {string} for processing maximum allowable billing due documents")
    public void theUserEntersValidSelectionCriteria(String selectionCriteria) {
        billingProgramPage.enterSelectionCriteria(selectionCriteria);
    }

    @When("the user schedules the program as a background job with the entered criteria")
    public void theUserSchedulesTheProgramAsABackgroundJob() {
        billingProgramPage.scheduleBackgroundJob();
    }

    @And("the user schedules the program as a background job")
    public void theUserSchedulesTheProgramAsBackgroundJob() {
        billingProgramPage.scheduleBackgroundJob();
    }

    @When("the user executes the Billing Due Program")
    public void theUserExecutesTheBillingDueProgram() {
        billingProgramPage.executeBillingDueProgram();
    }

    @When("the user executes the program to create billing documents")
    public void theUserExecutesTheProgramToCreateBillingDocuments() {
        billingProgramPage.executeBillingProgram();
    }

    @When("the user executes the background job and monitors its status")
    public void theUserExecutesTheBackgroundJobAndMonitorsItsStatus() {
        billingProgramPage.executeBackgroundJob();
        billingProgramPage.monitorJobStatus();
    }

    @When("the user executes the background job and monitors its status")
    public void theUserExecutesBackgroundJob() {
        billingProgramPage.executeAndMonitorBackgroundJob();
    }

    @Then("the system splits the billing document into two documents with {string} and {string} line items respectively")
    public void theSystemSplitsBillingDocument(String split1, String split2) {
        billingProgramPage.verifyDocumentSplits(split1, split2);
    }

    @Then("the system splits the billing document into multiple documents, each containing a maximum of 999 line items")
    public void theSystemSplitsTheBillingDocument() {
        billingProgramPage.verifySplitBillingDocuments();
    }

    @Then("the total number of line items across all split documents equals the source document's total line items")
    public void theTotalNumberOfLineItemsAcrossAllSplitDocumentsEqualsSource() {
        billingProgramPage.verifyTotalLineItemsAcrossSplitDocuments();
    }

    @Then("all resulting billing documents are posted to accounting successfully")
    public void allResultingBillingDocumentsArePostedToAccounting() {
        billingProgramPage.verifyBillingDocumentsPostedToAccounting();
    }

    @Then("accounting documents are generated for each split billing document")
    public void accountingDocumentsAreGeneratedForEachSplitBillingDocument() {
        billingProgramPage.verifyAccountingDocumentsGenerated();
    }

    @Then("accounting entries match the details in the split billing documents")
    public void accountingEntriesMatchDetailsInSplitBillingDocuments() {
        billingProgramPage.verifyAccountingEntriesMatchSplitDocuments();
    }

    @Then("the status of all split billing documents is updated to 'Posted'")
    public void theStatusOfAllSplitBillingDocumentsIsUpdatedToPosted() {
        billingProgramPage.verifyStatusOfSplitBillingDocuments();
    }

    @Then("the document flow shows proper linkage between the source document, split billing documents, and accounting documents")
    public void theDocumentFlowShowsProperLinkage() {
        billingProgramPage.verifyDocumentFlowLinkage();
    }

    @Then("no errors are logged during the posting process")
    public void noErrorsAreLoggedDuringPostingProcess() {
        billingProgramPage.verifyNoErrorsLogged();
    }

    @Then("the system generates a summary report showing successful posting of all split billing documents")
    public void theSystemGeneratesSummaryReport() {
        billingProgramPage.verifySummaryReportGenerated();
    }

    @Then("the background job execution starts successfully")
    public void theBackgroundJobExecutionStartsSuccessfully() {
        billingProgramPage.verifyJobExecutionStart();
    }

    @Then("the background job is scheduled successfully")
    public void theBackgroundJobIsScheduledSuccessfully() {
        billingProgramPage.verifyJobScheduledSuccessfully();
    }

    @Then("the user accesses the job log to review progress and any messages")
    public void theUserAccessesTheJobLog() {
        billingProgramPage.accessJobLog();
    }

    @And("the user accesses the job log to review error messages")
    public void theUserAccessesJobLog() {
        billingProgramPage.accessJobLog();
    }

    @Then("error messages indicating {string} are displayed in the job log")
    public void errorMessagesAreDisplayed(String errorMessage) {
        billingProgramPage.verifyErrorMessagesInJobLog(errorMessage);
    }

    @Then("no billing documents are created as a result of the execution")
    public void noBillingDocumentsAreCreated() {
        billingProgramPage.verifyNoBillingDocumentsCreated();
    }

    @When("the user checks the system logs for detailed error descriptions")
    public void theUserChecksSystemLogs() {
        billingProgramPage.checkSystemLogs();
    }

    @Then("the system logs provide detailed error descriptions related to {string}")
    public void systemLogsProvideErrorDetails(String errorDetails) {
        billingProgramPage.verifyErrorDetailsInSystemLogs(errorDetails);
    }

    @And("the error messages are clear and actionable, indicating {string}")
    public void errorMessagesAreClearAndActionable(String errorClarity) {
        billingProgramPage.verifyErrorClarity(errorClarity);
    }

    @And("the system maintains data integrity with no unintended changes")
    public void systemMaintainsDataIntegrity() {
        billingProgramPage.verifyDataIntegrity();
    }

    @And("the user documents the observed behavior and error handling for further analysis")
    public void theUserDocumentsObservedBehavior() {
        billingProgramPage.documentObservedBehavior();
    }

    @Then("the system logs do not show any errors or warnings during the process")
    public void theSystemLogsShowNoErrors() {
        billingProgramPage.verifySystemLogs();
    }

    @Then("the user generates a report summarizing the document flow, which accurately reflects the document flow details and linkages")
    public void theUserGeneratesDocumentFlowReport() {
        billingProgramPage.generateDocumentFlowReport();
    }

    @Then("the user documents the observed behavior and system performance for further analysis")
    public void theUserDocumentsObservedBehavior() {
        billingProgramPage.documentObservedBehaviorAndPerformance();
    }
}
