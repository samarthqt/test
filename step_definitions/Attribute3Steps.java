package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;

import com.pageobjects.Attribute3Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class Attribute3Steps extends Attribute3Page {

    @Given("the user logs in to the SAP S/4HANA Cloud system with valid credentials")
    public void theUserLogsInToTheSAPSystem() {
        loginToSAPSystem("validUsername", "validPassword");
    }

    @Given("the user navigates to the billing due program using transaction code {string}")
    public void theUserNavigatesToTheBillingDueProgram(String transactionCode) {
        navigateToBillingDueProgram(transactionCode);
    }

    @Given("the user locates the configuration section for Attribute 3")
    public void theUserLocatesTheConfigurationSectionForAttribute3() {
        locateConfigurationSectionForAttribute3();
    }

    @When("the user sets Attribute 3 to {string}")
    public void theUserSetsAttribute3To(String frequencyValue) {
        setAttribute3Frequency(frequencyValue);
    }

    @Then("the system {string}")
    public void theSystemBehavior(String systemBehavior) {
        verifySystemBehavior(systemBehavior);
    }

    @Then("the user attempts to save the configuration changes")
    public void theUserAttemptsToSaveTheConfigurationChanges() {
        attemptToSaveConfigurationChanges();
    }

    @Then("the system {string}")
    public void theSystemSaveBehavior(String saveBehavior) {
        verifySaveBehavior(saveBehavior);
    }

    @Then("no billing documents are generated if the frequency value is invalid")
    public void noBillingDocumentsAreGeneratedIfFrequencyIsInvalid() {
        verifyNoBillingDocumentsGenerated();
    }

    @Then("the error logs {string}")
    public void theErrorLogsBehavior(String errorLogBehavior) {
        verifyErrorLogBehavior(errorLogBehavior);
    }

    @Then("the system {string}")
    public void theSystemErrorHandlingBehavior(String errorHandlingBehavior) {
        verifyErrorHandlingBehavior(errorHandlingBehavior);
    }

    @When("the user sets Attribute 3 to a valid frequency value")
    public void theUserSetsAttribute3ToValidFrequencyValue() {
        setAttribute3Frequency("VALID_FREQ");
    }

    @Then("the user saves the configuration changes successfully")
    public void theUserSavesTheConfigurationChangesSuccessfully() {
        saveConfigurationChanges();
    }

    @Then("the system allows the generation of billing documents")
    public void theSystemAllowsTheGenerationOfBillingDocuments() {
        verifyBillingDocumentsGeneration();
    }
}