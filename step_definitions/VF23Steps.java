package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

import com.pageobjects.VF23Page;

public class VF23Steps extends VF23Page {

    @Given("user has valid SAP S/4HANA credentials with VF23 execution authorization")
    public void userHasValidSAPCredentials() {
        verifyUserAuthorization();
    }

    @When("user logs into the SAP S/4HANA system")
    public void userLogsIntoSAPSystem() {
        loginToSAPSystem();
    }

    @Then("user is successfully logged into the SAP system")
    public void userIsSuccessfullyLoggedIn() {
        verifySuccessfulLogin();
    }

    @Given("user is logged into the SAP S/4HANA system")
    public void userIsLoggedIntoSAPSystem() {
        verifyUserLoggedIn();
    }

    @When("user navigates to the VF23 transaction")
    public void userNavigatesToVF23Transaction() {
        navigateToVF23Transaction();
    }

    @Then("VF23 transaction screen is displayed")
    public void vf23TransactionScreenIsDisplayed() {
        verifyVF23ScreenDisplayed();
    }

    @Given("user is on the VF23 transaction screen")
    public void userIsOnVF23TransactionScreen() {
        verifyVF23ScreenDisplayed();
    }

    @When("user inputs the required parameters {string} to select an invoice list document")
    public void userInputsParameters(String parameters) {
        inputInvoiceListParameters(parameters);
    }

    @Then("the invoice list document is selected successfully")
    public void invoiceListDocumentSelectedSuccessfully() {
        verifyInvoiceListDocumentSelected();
    }

    @Then("at least one invoice list document exists in the system linked to multiple invoices")
    public void verifyInvoiceListDocumentExists() {
        verifyInvoiceListDocumentExistsInSystem();
    }

    @Given("user has selected an invoice list document in VF23")
    public void userHasSelectedInvoiceListDocument() {
        verifyInvoiceListDocumentSelected();
    }

    @When("user executes the transaction to trigger the Invoice List output")
    public void userExecutesTransaction() {
        executeTransactionToTriggerOutput();
    }

    @Then("the system attempts to trigger the output")
    public void systemAttemptsToTriggerOutput() {
        verifyOutputTriggerAttempt();
    }

    @Given("user has executed the transaction in VF23")
    public void userHasExecutedTransaction() {
        verifyTransactionExecuted();
    }

    @When("user checks for error messages")
    public void userChecksForErrorMessages() {
        checkForErrorMessages();
    }

    @Then("an error message is displayed indicating that Output Type ZPIL is not configured")
    public void errorMessageDisplayed() {
        verifyErrorMessageDisplayed();
    }

    @Given("user has encountered an error message indicating missing Output Type ZPIL configuration")
    public void userHasEncounteredErrorMessage() {
        verifyErrorMessageDisplayed();
    }

    @When("user verifies the output generation")
    public void userVerifiesOutputGeneration() {
        verifyNoOutputGenerated();
    }

    @Then("no output is generated")
    public void noOutputGenerated() {
        verifyNoOutputGenerated();
    }

    @When("user documents the error message")
    public void userDocumentsErrorMessage() {
        documentErrorMessage();
    }

    @Then("the error message is documented successfully")
    public void errorMessageDocumentedSuccessfully() {
        verifyErrorMessageDocumented();
    }

    @When("user validates the system behavior")
    public void userValidatesSystemBehavior() {
        validateSystemBehavior();
    }

    @Then("the system halts further processing due to the missing configuration")
    public void systemHaltsFurtherProcessing() {
        verifySystemHalted();
    }
}