package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import com.pageobjects.Attribute7ValidationPage;
import com.framework.cucumber.TestHarness;

public class Attribute7ValidationSteps extends Attribute7ValidationPage {

    @Given("the user is logged into the SAP system with access to the Payer Business Partner master data")
    public void userLoggedIntoSAPSystem() {
        loginToSAPSystem();
    }

    @Given("the Payer Business Partner master data screen is available")
    public void payerBusinessPartnerScreenAvailable() {
        navigateToPayerBusinessPartnerScreen();
    }

    @When("the user sets Attribute 7 to {string} and saves the changes")
    public void userSetsAttribute7(String attribute7Value) {
        setAttribute7Value(attribute7Value);
        saveChanges();
    }

    @When("the user creates a new billing document for the Payer Business Partner with billing document type {string}")
    public void userCreatesBillingDocument(String billingDocumentType) {
        createBillingDocument(billingDocumentType);
    }

    @When("the user triggers the output determination process for the billing document")
    public void userTriggersOutputDetermination() {
        triggerOutputDetermination();
    }

    @Then("the output log should indicate {string}")
    public void verifyOutputLog(String expectedOutputLog) {
        validateOutputLog(expectedOutputLog);
    }

    @Then("the document flow should reflect {string}")
    public void verifyDocumentFlow(String expectedDocumentFlow) {
        validateDocumentFlow(expectedDocumentFlow);
    }

    @Then("the system logs should indicate {string}")
    public void verifySystemLogs(String expectedSystemLog) {
        validateSystemLogs(expectedSystemLog);
    }

    @When("the user sets Attribute 7 to \"INVALID\" for a different Payer Business Partner and saves the changes")
    public void userSetsAttribute7ForDifferentPayer() {
        setAttribute7ValueForDifferentPayer("INVALID");
        saveChanges();
    }

    @Then("the results should align with the expected outcomes, confirming successful handling of invalid Attribute 7 values")
    public void verifyResultsAlignment() {
        validateResultsAlignment();
    }

    @When("the user documents the results and compares them with the expected outcomes")
    public void userDocumentsResults() {
        documentResults();
    }

    @Then("the test report should be submitted successfully with all results documented")
    public void submitTestReport() {
        submitReport();
    }
}