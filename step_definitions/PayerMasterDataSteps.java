package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;

import com.pageobjects.PayerMasterDataPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class PayerMasterDataSteps extends PayerMasterDataPage {

    @Given("the user logs into the SAP system with valid credentials")
    public void theUserLogsIntoTheSAPSystemWithValidCredentials() {
        loginToSAP();
    }

    @When("the user navigates to the transaction for maintaining payer master data")
    public void theUserNavigatesToTheTransactionForMaintainingPayerMasterData() {
        navigateToPayerMasterDataTransaction();
    }

    @When("the user populates Attribute 7 in the payer master data with {string}")
    public void theUserPopulatesAttribute7InThePayerMasterDataWith(String attribute7Value) {
        populateAttribute7(attribute7Value);
    }

    @When("the user saves the changes to the payer master data")
    public void theUserSavesTheChangesToThePayerMasterData() {
        savePayerMasterDataChanges();
    }

    @When("the user navigates to the field catalog configuration screen \(ZPDT\)")
    public void theUserNavigatesToTheFieldCatalogConfigurationScreen() {
        navigateToFieldCatalogConfiguration();
    }

    @Then("Attribute 7 should be present in the field catalog")
    public void attribute7ShouldBePresentInTheFieldCatalog() {
        verifyAttribute7InFieldCatalog();
    }

    @When("the user creates a new billing document with standard data")
    public void theUserCreatesANewBillingDocumentWithStandardData() {
        createNewBillingDocument();
    }

    @When("the user triggers the output determination process for the billing document")
    public void theUserTriggersTheOutputDeterminationProcessForTheBillingDocument() {
        triggerOutputDetermination();
    }

    @Then("the system logs should indicate {string}")
    public void theSystemLogsShouldIndicate(String logMessage) {
        verifySystemLogs(logMessage);
    }

    @Then("no output should be generated due to invalid Attribute 7 values")
    public void noOutputShouldBeGeneratedDueToInvalidAttribute7Values() {
        verifyNoOutputGenerated();
    }

    @Then("the logs should contain {string}")
    public void theLogsShouldContain(String errorMessage) {
        verifyErrorMessageInLogs(errorMessage);
    }

    @When("the user documents the test results and closes the session")
    public void theUserDocumentsTheTestResultsAndClosesTheSession() {
        documentTestResultsAndCloseSession();
    }

    @Then("the session should be closed successfully")
    public void theSessionShouldBeClosedSuccessfully() {
        verifySessionClosed();
    }
}