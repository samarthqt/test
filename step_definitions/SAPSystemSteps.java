package com.cucumber.steps;

import com.pageobjects.SAPSystemPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class SAPSystemSteps {

    private SAPSystemPage sapSystemPage = new SAPSystemPage();

    @Given("the user navigates to the SAP system login page")
    public void theUserNavigatesToTheSAPSystemLoginPage() {
        sapSystemPage.navigateToLoginPage();
    }

    @Given("the user has authorized credentials")
    public void theUserHasAuthorizedCredentials() {
        sapSystemPage.enterCredentials("username", "password");
    }

    @Given("the user has valid credentials")
    public void theUserHasValidCredentials() {
        sapSystemPage.enterCredentials("validUsername", "validPassword");
    }

    @When("the user logs into the SAP system")
    public void theUserLogsIntoTheSAPSystem() {
        sapSystemPage.loginToSAPSystem();
    }

    @Then("the user is successfully logged in")
    public void theUserIsSuccessfullyLoggedIn() {
        sapSystemPage.verifySuccessfulLogin();
    }

    @Then("the user successfully logs into the SAP system")
    public void theUserSuccessfullyLogsIntoTheSAPSystem() {
        sapSystemPage.verifySuccessfulLogin();
    }

    @Given("the user is logged into the SAP system")
    public void theUserIsLoggedIntoTheSAPSystem() {
        sapSystemPage.verifyUserLoggedIn();
    }

    @When("the user navigates to transaction VF03")
    public void theUserNavigatesToTransactionVF03() {
        sapSystemPage.navigateToTransactionVF03();
    }

    @Then("the VF03 transaction screen is displayed")
    public void theVF03TransactionScreenIsDisplayed() {
        sapSystemPage.verifyVF03ScreenDisplayed();
    }

    @When("the user enters the cancellation billing document number {string} and executes")
    public void theUserEntersTheCancellationBillingDocumentNumberAndExecutes(String documentNumber) {
        sapSystemPage.enterCancellationBillingDocumentNumber(documentNumber);
        sapSystemPage.executeTransaction();
    }

    @Then("the cancellation billing document details are displayed")
    public void theCancellationBillingDocumentDetailsAreDisplayed() {
        sapSystemPage.verifyCancellationBillingDocumentDetails();
    }

    @When("the user selects the output rendering option from the menu")
    public void theUserSelectsTheOutputRenderingOptionFromTheMenu() {
        sapSystemPage.selectOutputRenderingOption();
    }

    @Then("the output rendering options are displayed")
    public void theOutputRenderingOptionsAreDisplayed() {
        sapSystemPage.verifyOutputRenderingOptionsDisplayed();
    }

    @When("the user chooses Output Type ZPBL for rendering")
    public void theUserChoosesOutputTypeZPBLForRendering() {
        sapSystemPage.chooseOutputTypeZPBL();
    }

    @Then("the system attempts to process the output rendering")
    public void theSystemAttemptsToProcessTheOutputRendering() {
        sapSystemPage.verifyOutputRenderingProcessAttempted();
    }

    @Given("the Output Type ZPBL configuration is missing")
    public void theOutputTypeZPBLConfigurationIsMissing() {
        sapSystemPage.verifyOutputTypeZPBLConfigurationMissing();
    }

    @When("the user attempts to render Output Type ZPBL")
    public void theUserAttemptsToRenderOutputTypeZPBL() {
        sapSystemPage.attemptToRenderOutputTypeZPBL();
    }

    @Then("the system displays an error message indicating Output Type ZPBL is not configured")
    public void theSystemDisplaysAnErrorMessageIndicatingOutputTypeZPBLIsNotConfigured() {
        sapSystemPage.verifyErrorMessageForMissingConfiguration();
    }

    @When("the user configures Output Type ZPBL and repeats the rendering process")
    public void theUserConfiguresOutputTypeZPBLAndRepeatsTheRenderingProcess() {
        sapSystemPage.configureOutputTypeZPBL();
        sapSystemPage.repeatRenderingProcess();
    }

    @Then("the system accepts the configuration and allows rendering")
    public void theSystemAcceptsTheConfigurationAndAllowsRendering() {
        sapSystemPage.verifyRenderingAllowedAfterConfiguration();
    }

    @Given("the Output Type ZPBL is configured")
    public void theOutputTypeZPBLIsConfigured() {
        sapSystemPage.verifyOutputTypeZPBLConfigured();
    }

    @When("the user renders the output document")
    public void theUserRendersTheOutputDocument() {
        sapSystemPage.renderOutputDocument();
    }

    @Then("the output document is generated successfully with expected details")
    public void theOutputDocumentIsGeneratedSuccessfullyWithExpectedDetails() {
        sapSystemPage.verifyOutputDocumentGeneratedSuccessfully();
    }

    @When("the user checks the system logs")
    public void theUserChecksTheSystemLogs() {
        sapSystemPage.checkSystemLogs();
    }

    @Then("the system logs confirm successful rendering of Output Type ZPBL")
    public void theSystemLogsConfirmSuccessfulRenderingOfOutputTypeZPBL() {
        sapSystemPage.verifySystemLogsForSuccessfulRendering();
    }

    @When("the user validates the outputs")
    public void theUserValidatesTheOutputs() {
        sapSystemPage.validateOutputs();
    }

    @Then("the outputs are accurate and complete")
    public void theOutputsAreAccurateAndComplete() {
        sapSystemPage.verifyOutputsAccuracyAndCompleteness();
    }

    @When("the user verifies compliance with standards")
    public void theUserVerifiesComplianceWithStandards() {
        sapSystemPage.verifyComplianceWithStandards();
    }

    @Then("the system complies with operational and billing standards")
    public void theSystemCompliesWithOperationalAndBillingStandards() {
        sapSystemPage.verifyOperationalAndBillingCompliance();
    }

    @When("the user logs out from the SAP system")
    public void theUserLogsOutFromTheSAPSystem() {
        sapSystemPage.logoutFromSAPSystem();
    }

    @Then("the user logs out successfully")
    public void theUserLogsOutSuccessfully() {
        sapSystemPage.verifySuccessfulLogout();
    }
}
