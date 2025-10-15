package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import com.pageobjects.CustomBillingDueProgramPage;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class CustomBillingDueProgramSteps extends CustomBillingDueProgramPage {

    @Given("the user logs in to the SAP S/4HANA system with valid credentials")
    public void theUserLogsInToTheSAPSystem() {
        loginToSAPSystem("validUsername", "validPassword");
    }

    @Given("the user navigates to the billing due program configuration screen")
    public void theUserNavigatesToBillingDueProgramScreen() {
        navigateToBillingDueProgramScreen();
    }

    @When("the user selects the option for background execution of the billing program")
    public void theUserSelectsBackgroundExecutionOption() {
        selectBackgroundExecutionOption();
    }

    @When("the user enters {string} as the selection criteria for processing billing due documents")
    public void theUserEntersSelectionCriteria(String selectionCriteria) {
        enterSelectionCriteria(selectionCriteria);
    }

    @When("the user schedules the program as a background job with the entered criteria")
    public void theUserSchedulesBackgroundJob() {
        scheduleBackgroundJob();
    }

    @When("the user executes the background job")
    public void theUserExecutesBackgroundJob() {
        executeBackgroundJob();
    }

    @Then("the background job execution should start successfully")
    public void theBackgroundJobExecutionShouldStartSuccessfully() {
        verifyBackgroundJobStartedSuccessfully();
    }

    @Then("the user accesses the job log to review error messages")
    public void theUserAccessesJobLog() {
        accessJobLog();
    }

    @Then("error messages indicating issues with {string} should be displayed in the job log")
    public void errorMessagesShouldBeDisplayed(String selectionCriteria) {
        verifyErrorMessagesInJobLog(selectionCriteria);
    }

    @Then("no billing documents should be created as a result of the execution")
    public void noBillingDocumentsShouldBeCreated() {
        verifyNoBillingDocumentsCreated();
    }

    @Then("the system logs should provide detailed error descriptions related to {string}")
    public void systemLogsShouldProvideDetailedErrorDescriptions(String selectionCriteria) {
        verifyDetailedErrorDescriptionsInSystemLogs(selectionCriteria);
    }

    @Then("the error messages should be clear and actionable, indicating the exact issue with {string}")
    public void errorMessagesShouldBeClearAndActionable(String selectionCriteria) {
        verifyClearAndActionableErrorMessages(selectionCriteria);
    }

    @Then("the system should maintain data integrity despite the error")
    public void systemShouldMaintainDataIntegrity() {
        verifyDataIntegrityMaintained();
    }

    @Given("the user has executed a background job with invalid selection criteria")
    public void theUserHasExecutedBackgroundJobWithInvalidCriteria() {
        executeBackgroundJobWithInvalidCriteria();
    }

    @When("the user documents the observed behavior and error handling")
    public void theUserDocumentsObservedBehaviorAndErrorHandling() {
        documentObservedBehaviorAndErrorHandling();
    }

    @Then("the documentation should be completed successfully")
    public void documentationShouldBeCompletedSuccessfully() {
        verifyDocumentationCompletedSuccessfully();
    }
}