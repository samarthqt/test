package com.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.pageobjects.MilestoneManagementPage;
import com.framework.cucumber.TestHarness;

public class MilestoneManagementSteps {

    private MilestoneManagementPage milestoneManagementPage = new MilestoneManagementPage();
    private TestHarness testHarness = new TestHarness();

    @Given("the user logs into the SAP S/4HANA Cloud system using {string} and {string}")
    public void theUserLogsIntoTheSAPCloudSystemUsing(String username, String password) {
        milestoneManagementPage.launchApplication("https://sap-cloud-system-url.com");
        milestoneManagementPage.enterUsername(username);
        milestoneManagementPage.enterPassword(password);
        milestoneManagementPage.clickLoginButton();
    }

    @Given("the user navigates to the milestone management module")
    public void theUserNavigatesToTheMilestoneManagementModule() {
        milestoneManagementPage.navigateToMilestoneManagementModule();
    }

    @When("the user searches for the milestone ID {string}")
    public void theUserSearchesForTheMilestoneID(String milestoneId) {
        milestoneManagementPage.searchMilestoneByID(milestoneId);
    }

    @When("the user marks the milestone as {string}")
    public void theUserMarksTheMilestoneAs(String status) {
        milestoneManagementPage.markMilestoneAs(status);
    }

    @Then("the milestone details for the milestone ID {string} are displayed")
    public void theMilestoneDetailsForTheMilestoneIDAreDisplayed(String milestoneId) {
        milestoneManagementPage.verifyMilestoneDetailsDisplayed(milestoneId);
    }

    @Then("the milestone status is updated to {string}")
    public void theMilestoneStatusIsUpdatedTo(String status) {
        milestoneManagementPage.verifyMilestoneStatusUpdated(status);
    }

    @Then("the system triggers the creation of a Periodic Billing order")
    public void theSystemTriggersTheCreationOfAPeriodicBillingOrder() {
        milestoneManagementPage.verifyPeriodicBillingOrderTriggered();
    }

    @Then("a Periodic Billing order is automatically created without errors")
    public void aPeriodicBillingOrderIsAutomaticallyCreatedWithoutErrors() {
        milestoneManagementPage.verifyPeriodicBillingOrderCreated();
    }

    @Then("the document type of the created order is {string}")
    public void theDocumentTypeOfTheCreatedOrderIs(String documentType) {
        milestoneManagementPage.verifyDocumentTypeOfCreatedOrder(documentType);
    }

    @Then("the system should not create a Periodic Billing order")
    public void theSystemShouldNotCreateAPeriodicBillingOrder() {
        milestoneManagementPage.verifyNoPeriodicBillingOrderCreated();
    }

    @Then("the system logs should display error messages indicating {string}")
    public void theSystemLogsShouldDisplayErrorMessagesIndicating(String errorMessage) {
        milestoneManagementPage.verifyErrorMessageInLogs(errorMessage);
    }

    @Then("the user documents the test results")
    public void theUserDocumentsTheTestResults() {
        milestoneManagementPage.documentTestResults();
    }

    @Then("the test results are documented successfully")
    public void theTestResultsAreDocumentedSuccessfully() {
        milestoneManagementPage.verifyTestResultsDocumented();
    }

    @Given("the user is logged into the SAP system")
    public void theUserIsLoggedIntoTheSAPSystem() {
        milestoneManagementPage.verifyUserLoggedIn();
    }

    @When("the user logs out of the system")
    public void theUserLogsOutOfTheSystem() {
        milestoneManagementPage.logoutFromSAPSystem();
    }

    @Then("the user is successfully logged out")
    public void theUserIsSuccessfullyLoggedOut() {
        milestoneManagementPage.verifyUserLoggedOut();
    }

    @Given("the test execution is complete")
    public void theTestExecutionIsComplete() {
        milestoneManagementPage.verifyTestExecutionComplete();
    }

    @When("the user documents the test results")
    public void theUserDocumentsTheTestResults() {
        milestoneManagementPage.documentTestResults();
    }

    @Then("the test results are documented successfully")
    public void theTestResultsAreDocumentedSuccessfully() {
        milestoneManagementPage.verifyTestResultsDocumented();
    }
}
