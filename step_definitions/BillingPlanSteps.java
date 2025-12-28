package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;

import com.pageobjects.BillingPlanPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class BillingPlanSteps extends BillingPlanPage {

    @Given("the user has valid credentials")
    public void theUserHasValidCredentials() {
        enterCredentials("validUsername", "validPassword");
    }

    @When("the user logs into the SAP S/4HANA Cloud system")
    public void theUserLogsIntoTheSAPSystem() {
        clickLoginButton();
    }

    @Then("the user is successfully logged into the system")
    public void theUserIsSuccessfullyLoggedIn() {
        verifySuccessfulLogin();
    }

    @Given("the user is logged into the SAP S/4HANA Cloud system")
    public void theUserIsLoggedIntoTheSAPSystem() {
        verifySuccessfulLogin();
    }

    @When("the user navigates to the billing plan creation module")
    public void theUserNavigatesToBillingPlanCreationModule() {
        navigateToBillingPlanModule();
    }

    @Then("the billing plan creation module is displayed")
    public void theBillingPlanCreationModuleIsDisplayed() {
        verifyBillingPlanModuleDisplayed();
    }

    @Given("the user is in the billing plan creation module")
    public void theUserIsInBillingPlanCreationModule() {
        verifyBillingPlanModuleDisplayed();
    }

    @When("the user attempts to create a billing plan using an unlinked milestone")
    public void theUserAttemptsToCreateBillingPlanWithUnlinkedMilestone() {
        attemptBillingPlanCreationWithUnlinkedMilestone();
    }

    @Then("the system prevents the creation of the billing plan")
    public void theSystemPreventsBillingPlanCreation() {
        verifyBillingPlanCreationPrevented();
    }

    @Given("the user attempted to create a billing plan with an unlinked milestone")
    public void theUserAttemptedToCreateBillingPlanWithUnlinkedMilestone() {
        attemptBillingPlanCreationWithUnlinkedMilestone();
    }

    @When("the system detects the missing milestone linkage")
    public void theSystemDetectsMissingMilestoneLinkage() {
        detectMissingMilestoneLinkage();
    }

    @Then("an error message is displayed indicating the missing linkage to the milestone")
    public void anErrorMessageIsDisplayedForMissingMilestoneLinkage() {
        verifyErrorMessageDisplayed();
    }

    @When("the user checks the system logs")
    public void theUserChecksSystemLogs() {
        checkSystemLogs();
    }

    @Then("the system logs contain detailed information about the missing milestone linkage error")
    public void theSystemLogsContainDetailedErrorInformation() {
        verifyDetailedErrorInLogs();
    }

    @Given("the user manually links the milestone")
    public void theUserManuallyLinksMilestone() {
        linkMilestoneManually();
    }

    @When("the user retries the billing plan creation")
    public void theUserRetriesBillingPlanCreation() {
        retryBillingPlanCreation();
    }

    @Then("the system allows the creation of the billing plan after the linkage is restored")
    public void theSystemAllowsBillingPlanCreationAfterLinkageRestored() {
        verifyBillingPlanCreationAllowed();
    }

    @Given("the user successfully created the billing plan")
    public void theUserSuccessfullyCreatedBillingPlan() {
        verifyBillingPlanCreationAllowed();
    }

    @When("the user verifies the newly created billing plan")
    public void theUserVerifiesNewlyCreatedBillingPlan() {
        verifyBillingPlanDetails();
    }

    @Then("the billing plan is accurate and linked to the correct milestone")
    public void theBillingPlanIsAccurateAndLinkedToCorrectMilestone() {
        verifyBillingPlanAccuracy();
    }

    @Given("the user completed the test scenarios")
    public void theUserCompletedTestScenarios() {
        completeTestScenarios();
    }

    @When("the user documents the test results and any observations")
    public void theUserDocumentsTestResultsAndObservations() {
        documentTestResults();
    }

    @Then("the test results are documented, and observations are noted for further analysis")
    public void theTestResultsAreDocumented() {
        verifyTestResultsDocumented();
    }

    @Given("the user completed all actions in the system")
    public void theUserCompletedAllActionsInSystem() {
        completeAllActions();
    }

    @When("the user logs out of the SAP S/4HANA Cloud system")
    public void theUserLogsOutOfSAPSystem() {
        logoutFromSystem();
    }

    @Then("the user is successfully logged out of the system")
    public void theUserIsSuccessfullyLoggedOut() {
        verifySuccessfulLogout();
    }
}