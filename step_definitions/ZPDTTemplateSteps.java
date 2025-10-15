package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import com.pageobjects.ZPDTTemplatePage;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class ZPDTTemplateSteps extends ZPDTTemplatePage {

    @Given("the user has valid credentials")
    public void theUserHasValidCredentials() {
        loginToSAPSystem("validUsername", "validPassword");
    }

    @When("the user logs into the SAP system")
    public void theUserLogsIntoTheSAPSystem() {
        verifyLoginSuccess();
    }

    @Then("the user is successfully logged in")
    public void theUserIsSuccessfullyLoggedIn() {
        verifyLoginSuccess();
    }

    @Given("the user is logged into the SAP system")
    public void theUserIsLoggedIntoTheSAPSystem() {
        verifyLoginSuccess();
    }

    @When("the user navigates to the Invoice Correction Request creation screen")
    public void theUserNavigatesToTheInvoiceCorrectionRequestCreationScreen() {
        navigateToInvoiceCorrectionRequestScreen();
    }

    @Then("the Invoice Correction Request creation screen is displayed")
    public void theInvoiceCorrectionRequestCreationScreenIsDisplayed() {
        verifyInvoiceCorrectionRequestScreenDisplayed();
    }

    @Given("the user is on the Invoice Correction Request creation screen")
    public void theUserIsOnTheInvoiceCorrectionRequestCreationScreen() {
        verifyInvoiceCorrectionRequestScreenDisplayed();
    }

    @When("the user creates an Invoice Correction Request \(ZRK\) for a credit adjustment with a missing ZPDT template")
    public void theUserCreatesAnInvoiceCorrectionRequestForACreditAdjustmentWithAMissingZPDTTemplate() {
        createInvoiceCorrectionRequest("ZRK", "credit adjustment", false);
    }

    @Then("the Invoice Correction Request \(ZRK\) is created successfully")
    public void theInvoiceCorrectionRequestIsCreatedSuccessfully() {
        verifyInvoiceCorrectionRequestCreated();
    }

    @Given("the user has created an Invoice Correction Request \(ZRK\) with a missing ZPDT template")
    public void theUserHasCreatedAnInvoiceCorrectionRequestWithAMissingZPDTTemplate() {
        createInvoiceCorrectionRequest("ZRK", "credit adjustment", false);
    }

    @When("the user attempts to generate the \"{string}\" output using the Print Program \"{string}\"")
    public void theUserAttemptsToGenerateTheOutputUsingThePrintProgram(String outputType, String printProgram) {
        attemptToGenerateOutput(outputType, printProgram);
    }

    @Then("the system displays an error indicating the missing ZPDT template")
    public void theSystemDisplaysAnErrorIndicatingTheMissingZPDTTemplate() {
        verifyErrorForMissingZPDTTemplate();
    }

    @Then("the system logs indicate the absence of the ZPDT template")
    public void theSystemLogsIndicateTheAbsenceOfTheZPDTTemplate() {
        verifySystemLogsForMissingZPDTTemplate();
    }

    @Given("the ZPDT template is missing")
    public void theZPDTTemplateIsMissing() {
        verifyZPDTTemplateMissing();
    }

    @When("the user attempts to print outputs ZGC1 and ZGL1")
    public void theUserAttemptsToPrintOutputsZGC1AndZGL1() {
        attemptToPrintOutputs("ZGC1", "ZGL1");
    }

    @Then("the system does not allow printing of outputs without the ZPDT template")
    public void theSystemDoesNotAllowPrintingOfOutputsWithoutTheZPDTTemplate() {
        verifyPrintingNotAllowedWithoutZPDTTemplate();
    }

    @When("the user attempts to perform template-dependent operations")
    public void theUserAttemptsToPerformTemplateDependentOperations() {
        performTemplateDependentOperations();
    }

    @Then("the system provides clear and actionable error messages")
    public void theSystemProvidesClearAndActionableErrorMessages() {
        verifyClearAndActionableErrorMessages();
    }

    @When("the user interacts with the system")
    public void theUserInteractsWithTheSystem() {
        interactWithSystem();
    }

    @Then("the system complies with operational and billing standards")
    public void theSystemCompliesWithOperationalAndBillingStandards() {
        verifyComplianceWithStandards();
    }
}