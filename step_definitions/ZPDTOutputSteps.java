package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;

import com.pageobjects.ZPDTOutputPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class ZPDTOutputSteps extends ZPDTOutputPage {

    @Given("the user is logged into the SAP system with appropriate permissions")
    public void theUserIsLoggedIntoTheSAPSystemWithAppropriatePermissions() {
        loginToSAPSystem("username", "password");
    }

    @Given("the user has access to the Payer Business Partner master data")
    public void theUserHasAccessToThePayerBusinessPartnerMasterData() {
        verifyAccessToPayerBusinessPartnerData();
    }

    @When("the user navigates to the Payer Business Partner master data screen")
    public void theUserNavigatesToThePayerBusinessPartnerMasterDataScreen() {
        navigateToPayerBusinessPartnerScreen();
    }

    @When("the user locates Attribute 7 in the master data fields")
    public void theUserLocatesAttribute7InTheMasterDataFields() {
        locateAttribute7Field();
    }

    @When("the user sets Attribute 7 to {string} and saves the changes")
    public void theUserSetsAttribute7ToAndSavesTheChanges(String attribute7Value) {
        setAttribute7Value(attribute7Value);
        saveChanges();
    }

    @When("the user creates a new billing document for the Payer Business Partner")
    public void theUserCreatesANewBillingDocumentForThePayerBusinessPartner() {
        createBillingDocument();
    }

    @When("the user triggers the output determination process for the billing document")
    public void theUserTriggersTheOutputDeterminationProcessForTheBillingDocument() {
        triggerOutputDetermination();
    }

    @Then("the output log should indicate that the {string} output is generated as per the configuration")
    public void theOutputLogShouldIndicateThatTheOutputIsGeneratedAsPerTheConfiguration(String billingDocumentType) {
        verifyOutputLog(billingDocumentType);
    }

    @Then("the document flow should show the invoice sent to the customer")
    public void theDocumentFlowShouldShowTheInvoiceSentToTheCustomer() {
        verifyDocumentFlow();
    }

    @Then("the system logs should confirm that the process executed without errors")
    public void theSystemLogsShouldConfirmThatTheProcessExecutedWithoutErrors() {
        verifySystemLogs();
    }

    @Given("the user repeats the process with a different Payer Business Partner having Attribute 7 set to blank")
    public void theUserRepeatsTheProcessWithADifferentPayerBusinessPartnerHavingAttribute7SetToBlank() {
        repeatProcessForDifferentPayer();
    }

    @When("the user completes the steps for output determination")
    public void theUserCompletesTheStepsForOutputDetermination() {
        completeOutputDeterminationSteps();
    }

    @Then("the ZPDT output should be generated for the second Payer Business Partner as well")
    public void theZPDTOutputShouldBeGeneratedForTheSecondPayerBusinessPartnerAsWell() {
        verifyZPDTOutputForSecondPayer();
    }

    @Given("the user has completed the test execution")
    public void theUserHasCompletedTheTestExecution() {
        completeTestExecution();
    }

    @When("the user documents the results and compares them with the expected outcomes")
    public void theUserDocumentsTheResultsAndComparesThemWithTheExpectedOutcomes() {
        documentAndCompareResults();
    }

    @Then("the results should align with the expected outcomes, confirming successful generation of ZPDT output")
    public void theResultsShouldAlignWithTheExpectedOutcomesConfirmingSuccessfulGenerationOfZPDTOutput() {
        verifyResultsAlignment();
    }

    @Then("the test report should be submitted successfully with all results documented")
    public void theTestReportShouldBeSubmittedSuccessfullyWithAllResultsDocumented() {
        submitTestReport();
    }
}