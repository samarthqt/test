package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;

import com.pageobjects.ZGL1OutputPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class ZGL1OutputSteps extends ZGL1OutputPage {

    @Given("the user logs into the SAP system with billing administrator credentials")
    public void theUserLogsIntoTheSAPSystemWithBillingAdministratorCredentials() {
        loginToSAPSystem("billingAdmin", "password123");
    }

    @Given("the user navigates to the billing output generation module")
    public void theUserNavigatesToTheBillingOutputGenerationModule() {
        navigateToBillingOutputModule();
    }

    @When("the user attempts to generate a ZGL1 form with a {string} template")
    public void theUserAttemptsToGenerateAZGL1FormWithATemplate(String templateConfiguration) {
        attemptToGenerateZGL1Form(templateConfiguration);
    }

    @Then("the system prevents the generation of the ZGL1 form")
    public void theSystemPreventsTheGenerationOfTheZGL1Form() {
        verifyZGL1GenerationPrevention();
    }

    @Then("the system displays an error message indicating that the ZPDT template is corrupted")
    public void theSystemDisplaysAnErrorMessageIndicatingThatTheZPDTTemplateIsCorrupted() {
        verifyErrorMessage("The ZPDT template is corrupted.");
    }

    @Then("the user captures a screenshot of the error message for documentation")
    public void theUserCapturesAScreenshotOfTheErrorMessageForDocumentation() {
        captureErrorMessageScreenshot();
    }

    @Then("the system logs contain entries indicating the corrupted ZPDT template")
    public void theSystemLogsContainEntriesIndicatingTheCorruptedZPDTTemplate() {
        verifySystemLogsForCorruptedTemplate();
    }

    @When("the user retries the generation process after the error message")
    public void theUserRetriesTheGenerationProcessAfterTheErrorMessage() {
        retryZGL1Generation();
    }

    @Then("the system consistently prevents the generation of the ZGL1 form")
    public void theSystemConsistentlyPreventsTheGenerationOfTheZGL1Form() {
        verifyZGL1GenerationPrevention();
    }

    @Then("no ZGL1 outputs are generated")
    public void noZGL1OutputsAreGenerated() {
        verifyNoZGL1OutputsGenerated();
    }

    @Then("the system remains stable after the error")
    public void theSystemRemainsStableAfterTheError() {
        verifySystemStability();
    }

    @Then("the user is successfully logged into the system")
    public void theUserIsSuccessfullyLoggedIntoTheSystem() {
        verifySuccessfulLogin();
    }

    @When("the user logs out of the SAP system")
    public void theUserLogsOutOfTheSAPSystem() {
        logoutOfSAPSystem();
    }

    @Then("the user is successfully logged out")
    public void theUserIsSuccessfullyLoggedOut() {
        verifySuccessfulLogout();
    }

    @Given("the user has completed the validation process")
    public void theUserHasCompletedTheValidationProcess() {
        verifyValidationProcessCompletion();
    }

    @When("the user documents all findings and screenshots in the test report")
    public void theUserDocumentsAllFindingsAndScreenshotsInTheTestReport() {
        documentFindingsAndScreenshots();
    }

    @Then("the findings and screenshots are documented successfully")
    public void theFindingsAndScreenshotsAreDocumentedSuccessfully() {
        verifyDocumentationSuccess();
    }
}