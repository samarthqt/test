package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;

import com.pageobjects.RevenueRecognitionPage;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class RevenueRecognitionSteps extends RevenueRecognitionPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has valid credentials")
    public void theUserHasValidCredentials() {
        String username = testHarness.getData("LoginData", "Username");
        String password = testHarness.getData("LoginData", "Password");
        enterCredentials(username, password);
    }

    @When("the user logs into the SAP S/4HANA Cloud system")
    public void theUserLogsIntoTheSAPSystem() {
        clickLoginButton();
    }

    @Then("the user is successfully logged into the SAP S/4HANA Cloud system")
    public void theUserIsSuccessfullyLoggedIn() {
        verifyLoginSuccess();
    }

    @Given("the user is logged into the SAP S/4HANA Cloud system")
    public void theUserIsLoggedIn() {
        verifyLoginSuccess();
    }

    @When("the user navigates to the Billing Plan module")
    public void theUserNavigatesToBillingPlanModule() {
        navigateToBillingPlanModule();
    }

    @Then("the user confirms the last billing plan is set as 'Due'")
    public void theUserConfirmsLastBillingPlanIsDue() {
        verifyLastBillingPlanStatus("Due");
    }

    @Given("the last billing plan is set as 'Due'")
    public void theLastBillingPlanIsDue() {
        verifyLastBillingPlanStatus("Due");
    }

    @When("the user triggers the creation of a billing document for the last billing plan")
    public void theUserCreatesBillingDocument() {
        createBillingDocument();
    }

    @Then("the billing document is created successfully")
    public void theBillingDocumentIsCreatedSuccessfully() {
        verifyBillingDocumentCreation();
    }

    @Given("the billing document is created")
    public void theBillingDocumentIsCreated() {
        verifyBillingDocumentCreation();
    }

    @When("the user opens the created billing document and navigates to the revenue recognition section")
    public void theUserNavigatesToRevenueRecognitionSection() {
        openBillingDocument();
        navigateToRevenueRecognitionSection();
    }

    @Then("the revenue recognition section is accessible for the billing document")
    public void theRevenueRecognitionSectionIsAccessible() {
        verifyRevenueRecognitionSectionAccessibility();
    }

    @Given("the user is in the revenue recognition section of the billing document")
    public void theUserIsInRevenueRecognitionSection() {
        verifyRevenueRecognitionSectionAccessibility();
    }

    @When("the user verifies the readiness status of the billing document")
    public void theUserVerifiesReadinessStatus() {
        verifyReadinessStatus();
    }

    @Then("the billing document is marked as ready for revenue recognition")
    public void theBillingDocumentIsReadyForRevenueRecognition() {
        verifyBillingDocumentReadyForRevenueRecognition();
    }

    @Given("the billing document is marked as ready for revenue recognition")
    public void theBillingDocumentIsMarkedReady() {
        verifyBillingDocumentReadyForRevenueRecognition();
    }

    @When("the user checks the revenue recognition configuration settings applied to the billing document")
    public void theUserChecksRevenueRecognitionSettings() {
        checkRevenueRecognitionSettings();
    }

    @Then("the revenue recognition configuration settings are correctly applied to the billing document")
    public void theRevenueRecognitionSettingsAreCorrectlyApplied() {
        verifyRevenueRecognitionSettings();
    }

    @Given("the revenue recognition configuration settings are applied to the billing document")
    public void theRevenueRecognitionSettingsAreApplied() {
        verifyRevenueRecognitionSettings();
    }

    @When("the user validates the revenue recognition status in the financial ledger")
    public void theUserValidatesRevenueRecognitionStatus() {
        validateRevenueRecognitionStatusInLedger();
    }

    @Then("the revenue recognition status is updated in the financial ledger without errors")
    public void theRevenueRecognitionStatusIsUpdated() {
        verifyRevenueRecognitionStatusInLedger();
    }

    @Given("the revenue recognition status is updated in the financial ledger")
    public void theRevenueRecognitionStatusIsUpdatedInLedger() {
        verifyRevenueRecognitionStatusInLedger();
    }

    @When("the user checks the revenue recognition report")
    public void theUserChecksRevenueRecognitionReport() {
        checkRevenueRecognitionReport();
    }

    @Then("the billing document is included in the revenue recognition report")
    public void theBillingDocumentIsIncludedInReport() {
        verifyBillingDocumentInRevenueRecognitionReport();
    }

    @Given("the user is performing the revenue recognition readiness check")
    public void theUserIsPerformingReadinessCheck() {
        startReadinessCheck();
    }

    @When("the readiness check is completed")
    public void theReadinessCheckIsCompleted() {
        completeReadinessCheck();
    }

    @Then("no errors or warnings are generated during the revenue recognition readiness check")
    public void noErrorsOrWarningsGenerated() {
        verifyNoErrorsOrWarnings();
    }

    @Given("the revenue recognition readiness check is completed")
    public void theReadinessCheckIsCompletedSuccessfully() {
        completeReadinessCheck();
    }

    @When("the user ensures the readiness status is logged in the system")
    public void theUserEnsuresReadinessStatusLogged() {
        logReadinessStatus();
    }

    @Then("the revenue recognition readiness status is logged in the system with all relevant details")
    public void readinessStatusLoggedWithDetails() {
        verifyReadinessStatusLogged();
    }

    @Given("the revenue recognition readiness status is logged")
    public void readinessStatusIsLogged() {
        verifyReadinessStatusLogged();
    }

    @When("the user validates the readiness status against the configured business rules")
    public void theUserValidatesReadinessStatus() {
        validateReadinessStatusAgainstBusinessRules();
    }

    @Then("the revenue recognition readiness aligns with the configured business rules")
    public void readinessAlignsWithBusinessRules() {
        verifyAlignmentWithBusinessRules();
    }

    @Given("the revenue recognition readiness process is completed")
    public void readinessProcessCompleted() {
        completeReadinessCheck();
    }

    @When("the user checks the statuses of the billing document")
    public void theUserChecksBillingDocumentStatuses() {
        checkBillingDocumentStatuses();
    }

    @Then("the revenue recognition readiness process does not impact the billing document's other statuses")
    public void readinessProcessDoesNotImpactOtherStatuses() {
        verifyNoImpactOnOtherStatuses();
    }
}