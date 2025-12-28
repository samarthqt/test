package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;

import com.pageobjects.SAPOutputRenderingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class SAPOutputRenderingSteps extends SAPOutputRenderingPage {

    @Given("the user has valid credentials")
    public void theUserHasValidCredentials() {
        loginToSAP("validUsername", "validPassword");
    }

    @When("the user logs into the SAP S/4HANA system")
    public void theUserLogsIntoTheSAPSystem() {
        navigateToSAPHomeScreen();
    }

    @Then("the user is successfully logged in and navigates to the SAP home screen")
    public void theUserIsSuccessfullyLoggedIn() {
        verifySAPHomeScreen();
    }

    @Given("a cancellation billing document number \"{string}\" exists in the system")
    public void aCancellationBillingDocumentExists(String documentNumber) {
        verifyBillingDocumentExists(documentNumber);
    }

    @Given("Output Type ZPBL is configured")
    public void outputTypeZPBLIsConfigured() {
        verifyOutputTypeConfigured("ZPBL");
    }

    @When("the user navigates to transaction VF03")
    public void theUserNavigatesToTransactionVF03() {
        navigateToTransactionVF03();
    }

    @Then("the cancellation billing document details are displayed")
    public void theCancellationBillingDocumentDetailsAreDisplayed() {
        verifyBillingDocumentDetails();
    }

    @Then("the Output Type is \"{string}\"")
    public void theOutputTypeIs(String outputType) {
        verifyOutputType(outputType);
    }

    @Given("the print program \"{string}\" is set up")
    public void thePrintProgramIsSetUp(String printProgram) {
        verifyPrintProgramSetup(printProgram);
    }

    @Given("the form \"{string}\" is updated as per requirements")
    public void theFormIsUpdated(String formName) {
        verifyFormUpdated(formName);
    }

    @When("the user executes the output rendering process using Output Type ZPBL")
    public void theUserExecutesTheOutputRenderingProcess() {
        executeOutputRendering("ZPBL");
    }

    @Then("the output rendering process is executed successfully")
    public void theOutputRenderingProcessIsExecutedSuccessfully() {
        verifyOutputRenderingSuccess();
    }

    @When("the user views the rendered output")
    public void theUserViewsTheRenderedOutput() {
        viewRenderedOutput();
    }

    @Then("the form \"{string}\" is displayed with updated formatting")
    public void theFormIsDisplayedWithUpdatedFormatting(String formName) {
        verifyRenderedForm(formName);
    }

    @Then("the header text is displayed as \"{string}\"")
    public void theHeaderTextIsDisplayed(String headerText) {
        verifyHeaderText(headerText);
    }

    @Then("the page number is replaced with the Original Invoice Number")
    public void thePageNumberIsReplaced() {
        verifyPageNumberReplacement();
    }

    @Then("the Reference Invoice Number is correctly displayed")
    public void theReferenceInvoiceNumberIsDisplayed() {
        verifyReferenceInvoiceNumber();
    }

    @Then("the footer displays page numbering correctly at the bottom-right \(e.g., \"{string}\"\)")
    public void theFooterDisplaysPageNumbering(String pageNumberFormat) {
        verifyFooterPageNumbering(pageNumberFormat);
    }

    @Then("the Period Covered and Incoterms sections are not displayed")
    public void thePeriodCoveredAndIncotermsAreNotDisplayed() {
        verifySectionsOmitted();
    }

    @When("the user validates the printed output")
    public void theUserValidatesThePrintedOutput() {
        validatePrintedOutput();
    }

    @Then("the printed output matches all specified formatting requirements")
    public void thePrintedOutputMatchesFormatting() {
        verifyPrintedOutputFormatting();
    }

    @When("the user checks the system logs after rendering")
    public void theUserChecksSystemLogs() {
        checkSystemLogs();
    }

    @Then("no errors are logged during the rendering process")
    public void noErrorsAreLogged() {
        verifyNoErrorsInLogs();
    }

    @When("the user saves the rendered output")
    public void theUserSavesTheRenderedOutput() {
        saveRenderedOutput();
    }

    @Then("the rendered output is saved successfully")
    public void theRenderedOutputIsSavedSuccessfully() {
        verifyOutputSaved();
    }
}