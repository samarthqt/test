package com.cucumber.steps;

import com.pageobjects.ZGC1FormPage;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class ZGC1FormSteps {

    private ZGC1FormPage zgc1FormPage = new ZGC1FormPage();
    private TestHarness testHarness = new TestHarness();

    @Given("the user has appropriate credentials")
    public void theUserHasAppropriateCredentials() {
        zgc1FormPage.enterCredentials("validUsername", "validPassword");
    }

    @When("the user logs into the SAP S/4HANA system")
    public void theUserLogsIntoTheSAPSystem() {
        zgc1FormPage.loginToSystem();
    }

    @Then("the user is successfully logged into the system")
    public void theUserIsSuccessfullyLoggedIntoTheSystem() {
        zgc1FormPage.verifyLoginSuccess();
    }

    @Given("the user is logged into the SAP S/4HANA system")
    public void theUserIsLoggedIntoTheSAPSystem() {
        zgc1FormPage.verifyUserLoggedIn();
    }

    @When("the user navigates to the Billing Correction Output form generation screen")
    public void theUserNavigatesToTheBillingCorrectionScreen() {
        zgc1FormPage.navigateToBillingCorrectionScreen();
    }

    @Then("the Billing Correction Output form generation screen is displayed")
    public void theBillingCorrectionScreenIsDisplayed() {
        zgc1FormPage.verifyBillingCorrectionScreenDisplayed();
    }

    @Given("the user is on the Billing Correction Output form generation screen")
    public void theUserIsOnTheBillingCorrectionScreen() {
        zgc1FormPage.verifyBillingCorrectionScreenDisplayed();
    }

    @When("the user attempts to generate a ZGC1 form with the following details:")
    public void theUserAttemptsToGenerateZGC1Form(String invoiceCorrectionRequestID, String billingDocumentReference) {
        zgc1FormPage.attemptToGenerateZGC1Form(invoiceCorrectionRequestID, billingDocumentReference);
    }

    @Then("the system prevents form generation and displays the error message {string}")
    public void theSystemPreventsFormGeneration(String errorMessage) {
        zgc1FormPage.verifyErrorMessageDisplayed(errorMessage);
    }

    @Given("the user attempts to generate a ZGC1 form without providing an Invoice Correction Request ID")
    public void theUserAttemptsToGenerateZGC1FormWithoutInvoiceID() {
        zgc1FormPage.attemptToGenerateZGC1Form("", "Valid");
    }

    @When("the error message is displayed")
    public void theErrorMessageIsDisplayed() {
        zgc1FormPage.verifyErrorMessageDisplayed("Invoice Correction Request is missing");
    }

    @Then("the error message explicitly states that the Invoice Correction Request is missing")
    public void theErrorMessageExplicitlyStatesMissingInvoiceID() {
        zgc1FormPage.verifyErrorMessageDisplayed("Invoice Correction Request is missing");
    }

    @Given("the user encounters an error while generating a ZGC1 form")
    public void theUserEncountersAnErrorWhileGeneratingZGC1Form() {
        zgc1FormPage.attemptToGenerateZGC1Form("", "Valid");
    }

    @When("the user checks the system logs")
    public void theUserChecksTheSystemLogs() {
        zgc1FormPage.checkSystemLogs();
    }

    @Then("the system logs contain relevant error details for troubleshooting")
    public void theSystemLogsContainRelevantErrorDetails() {
        zgc1FormPage.verifySystemLogsContainErrorDetails();
    }

    @Given("the user is logged into the SAP S/4HANA system with valid credentials")
    public void theUserIsLoggedIntoTheSAPSystemWithValidCredentials() {
        zgc1FormPage.loginToSAPSystem("validUsername", "validPassword");
    }

    @Given("a valid Invoice Correction Request {string} exists in the system")
    public void aValidInvoiceCorrectionRequestExistsInTheSystem(String invoiceCorrectionRequestId) {
        zgc1FormPage.verifyInvoiceCorrectionRequestExists(invoiceCorrectionRequestId);
    }

    @When("the user navigates to the Billing Correction Output form generation screen")
    public void theUserNavigatesToTheBillingCorrectionOutputFormGenerationScreen() {
        zgc1FormPage.navigateToBillingCorrectionOutputScreen();
    }

    @When("the user selects the Invoice Correction Request with {string} and {string}")
    public void theUserSelectsTheInvoiceCorrectionRequestWithBillingDocumentReferenceAndCorrectionType(String billingDocumentReference, String correctionType) {
        zgc1FormPage.selectInvoiceCorrectionRequest(billingDocumentReference, correctionType);
    }

    @When("the user attempts to generate the ZGC1 form")
    public void theUserAttemptsToGenerateTheZGC1Form() {
        zgc1FormPage.generateZGC1Form();
    }

    @Then("the system successfully generates the ZGC1 form")
    public void theSystemSuccessfullyGeneratesTheZGC1Form() {
        zgc1FormPage.verifyZGC1FormGenerated();
    }

    @Then("the generated ZGC1 form is linked to the Invoice Correction Request and original billing document")
    public void theGeneratedZGC1FormIsLinkedToTheInvoiceCorrectionRequestAndOriginalBillingDocument() {
        zgc1FormPage.verifyZGC1FormLinkage();
    }

    @Then("the ZGC1 form contains accurate and complete information")
    public void theZGC1FormContainsAccurateAndCompleteInformation() {
        zgc1FormPage.verifyZGC1FormContent();
    }
}
