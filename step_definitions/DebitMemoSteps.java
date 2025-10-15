package com.cucumber.steps;

import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.pageobjects.DebitMemoPage;
import com.framework.cucumber.TestHarness;

public class DebitMemoSteps {

    private DebitMemoPage debitMemoPage = new DebitMemoPage();
    private TestHarness testHarness = new TestHarness();

    @Given("the user has appropriate credentials")
    public void theUserHasAppropriateCredentials() {
        debitMemoPage.enterCredentials("username", "password");
    }

    @When("the user logs in to the SAP S/4HANA system")
    public void theUserLogsInToTheSAPSystem() {
        debitMemoPage.clickLoginButton();
    }

    @Then("the user successfully gains access to the system")
    public void theUserSuccessfullyGainsAccessToTheSystem() {
        debitMemoPage.verifySystemAccess("Dashboard");
    }

    @Given("the user is logged into the SAP S/4HANA system")
    public void theUserIsLoggedIntoTheSAPSystem() {
        debitMemoPage.verifySystemAccess("Dashboard");
    }

    @When("the user navigates to the Debit Memo Request section")
    public void theUserNavigatesToTheDebitMemoRequestSection() {
        debitMemoPage.navigateToDebitMemoSection();
    }

    @Then("the Debit Memo Request section is displayed")
    public void theDebitMemoRequestSectionIsDisplayed() {
        debitMemoPage.verifySectionDisplayed("Debit Memo Request");
    }

    @Given("the user is in the Debit Memo Request section")
    public void theUserIsInTheDebitMemoRequestSection() {
        debitMemoPage.verifySectionDisplayed("Debit Memo Request");
    }

    @When("the user searches for the Debit Memo Request with ID {string}")
    public void theUserSearchesForTheDebitMemoRequestWithID(String debitMemoRequestID) {
        debitMemoPage.searchDebitMemoRequest(debitMemoRequestID);
    }

    @Then("the details of the Debit Memo Request with ID {string} are displayed")
    public void theDetailsOfTheDebitMemoRequestWithIDAreDisplayed(String debitMemoRequestID) {
        debitMemoPage.verifyDebitMemoDetails(debitMemoRequestID);
    }

    @Given("the user has opened the Debit Memo Request with ID {string}")
    public void theUserHasOpenedTheDebitMemoRequestWithID(String debitMemoRequestID) {
        debitMemoPage.openDebitMemoRequest(debitMemoRequestID);
    }

    @When("the user updates the price field to {string}")
    public void theUserUpdatesThePriceFieldTo(String updatedPrice) {
        debitMemoPage.updatePriceField(updatedPrice);
    }

    @Then("the price field is updated successfully")
    public void thePriceFieldIsUpdatedSuccessfully() {
        debitMemoPage.verifyPriceUpdate();
    }

    @When("the user updates the data field to include a tax rate of {string}")
    public void theUserUpdatesTheDataFieldToIncludeATaxRateOf(String taxRate) {
        debitMemoPage.updateDataFieldWithTaxRate(taxRate);
    }

    @Then("the data field is updated successfully")
    public void theDataFieldIsUpdatedSuccessfully() {
        debitMemoPage.verifyDataFieldUpdate();
    }

    @Given("the user has updated the price and data fields of the Debit Memo Request")
    public void theUserHasUpdatedThePriceAndDataFieldsOfTheDebitMemoRequest() {
        debitMemoPage.verifyPriceAndDataFieldsUpdated();
    }

    @When("the user saves the changes to the Debit Memo Request")
    public void theUserSavesTheChangesToTheDebitMemoRequest() {
        debitMemoPage.saveDebitMemoChanges();
    }

    @Then("the changes are saved, and the system confirms the update")
    public void theChangesAreSavedAndTheSystemConfirmsTheUpdate() {
        debitMemoPage.verifyChangesSaved();
    }

    @Given("the user has saved changes to the Debit Memo Request")
    public void theUserHasSavedChangesToTheDebitMemoRequest() {
        debitMemoPage.verifyChangesSaved();
    }

    @When("the workflow retriggering process fails due to a simulated error")
    public void theWorkflowRetriggeringProcessFailsDueToASimulatedError() {
        debitMemoPage.simulateWorkflowRetriggerFailure();
    }

    @Then("the system logs an error message indicating the failure in workflow retriggering")
    public void theSystemLogsAnErrorMessageIndicatingTheFailureInWorkflowRetriggering() {
        debitMemoPage.verifyErrorMessageLogged("Workflow retriggering failed");
    }

    @Given("the workflow retriggering process has failed")
    public void theWorkflowRetriggeringProcessHasFailed() {
        debitMemoPage.verifyErrorMessageLogged("Workflow retriggering failed");
    }

    @When("the system logs an error message")
    public void theSystemLogsAnErrorMessage() {
        debitMemoPage.verifyErrorMessageLogged("Workflow retriggering failed");
    }

    @Then("the user is notified about the workflow retriggering failure")
    public void theUserIsNotifiedAboutTheWorkflowRetriggeringFailure() {
        debitMemoPage.verifyUserNotification("Workflow retriggering failed");
    }

    @Given("the user has been notified about the workflow retriggering failure")
    public void theUserHasBeenNotifiedAboutTheWorkflowRetriggeringFailure() {
        debitMemoPage.verifyUserNotification("Workflow retriggering failed");
    }

    @When("the user attempts to manually retrigger the workflow for the Debit Memo Request")
    public void theUserAttemptsToManuallyRetriggerTheWorkflowForTheDebitMemoRequest() {
        debitMemoPage.manuallyRetriggerWorkflow();
    }

    @Then("the system allows the user to manually retrigger the workflow")
    public void theSystemAllowsTheUserToManuallyRetriggerTheWorkflow() {
        debitMemoPage.verifyWorkflowRetriggered();
    }

    @Given("the user has manually retriggered the workflow for the Debit Memo Request")
    public void theUserHasManuallyRetriggeredTheWorkflowForTheDebitMemoRequest() {
        debitMemoPage.verifyWorkflowRetriggered();
    }

    @When("the workflow is retriggered")
    public void theWorkflowIsRetriggered() {
        debitMemoPage.verifyWorkflowRetriggered();
    }

    @Then("the manually retriggered workflow reflects the updated price and data fields")
    public void theManuallyRetriggeredWorkflowReflectsTheUpdatedPriceAndDataFields() {
        debitMemoPage.verifyUpdatedWorkflowData();
    }

    @Given("the workflow has been manually retriggered")
    public void theWorkflowHasBeenManuallyRetriggered() {
        debitMemoPage.verifyWorkflowRetriggered();
    }

    @When("the user checks the status of the previous workflow instance")
    public void theUserChecksTheStatusOfThePreviousWorkflowInstance() {
        debitMemoPage.checkPreviousWorkflowStatus();
    }

    @Then("the previous workflow instance is closed or marked as obsolete")
    public void thePreviousWorkflowInstanceIsClosedOrMarkedAsObsolete() {
        debitMemoPage.verifyPreviousWorkflowClosed();
    }
}
