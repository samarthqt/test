package com.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

import com.pageobjects.BillingCorrectionPage;
import com.framework.cucumber.TestHarness;

public class BillingCorrectionSteps {

    private BillingCorrectionPage billingCorrectionPage = new BillingCorrectionPage();
    private TestHarness testHarness = new TestHarness();

    @Given("the user has appropriate credentials")
    public void theUserHasAppropriateCredentials() {
        billingCorrectionPage.loginToSAPSystem("username", "password");
    }

    @When("the user logs into the SAP S/4HANA system")
    public void theUserLogsIntoTheSAPSystem() {
        billingCorrectionPage.verifyLoginSuccess();
    }

    @Then("the user is successfully logged into the system")
    public void theUserIsSuccessfullyLoggedIntoTheSystem() {
        billingCorrectionPage.verifyLoginSuccess();
    }

    @Given("the user is logged into the SAP S/4HANA system")
    public void theUserIsLoggedIntoTheSAPSystem() {
        billingCorrectionPage.verifyUserLoggedIn();
    }

    @When("the user navigates to the billing correction request creation screen")
    public void theUserNavigatesToBillingCorrectionRequestCreationScreen() {
        billingCorrectionPage.navigateToBillingCorrectionScreen();
    }

    @Then("the billing correction request creation screen is displayed")
    public void theBillingCorrectionRequestCreationScreenIsDisplayed() {
        billingCorrectionPage.verifyBillingCorrectionScreenDisplayed();
    }

    @Given("the user is on the billing correction request creation screen")
    public void theUserIsOnBillingCorrectionRequestCreationScreen() {
        billingCorrectionPage.verifyBillingCorrectionScreenDisplayed();
    }

    @When("the user enters an original billing document number {string}")
    public void theUserEntersAnOriginalBillingDocumentNumber(String originalBillingDocumentNumber) {
        billingCorrectionPage.enterBillingDocumentNumber(originalBillingDocumentNumber);
    }

    @When("the user selects billing correction request type {string}")
    public void theUserSelectsBillingCorrectionRequestType(String billingCorrectionRequestType) {
        billingCorrectionPage.selectBillingCorrectionRequestType(billingCorrectionRequestType);
    }

    @When("the user attempts to save the billing correction request")
    public void theUserAttemptsToSaveTheBillingCorrectionRequest() {
        billingCorrectionPage.saveBillingCorrectionRequest();
    }

    @Then("the system displays an error message {string}")
    public void theSystemDisplaysAnErrorMessage(String errorMessage) {
        billingCorrectionPage.verifyErrorMessageDisplayed(errorMessage);
    }

    @Then("the system prevents the billing correction request from being saved")
    public void theSystemPreventsTheBillingCorrectionRequestFromBeingSaved() {
        billingCorrectionPage.verifyBillingCorrectionRequestNotSaved();
    }

    @When("the user attempts to generate a ZL2C billing document linked to the invalid billing correction request")
    public void theUserAttemptsToGenerateAZL2CBillingDocumentLinkedToTheInvalidBillingCorrectionRequest() {
        billingCorrectionPage.attemptToGenerateZL2CBillingDocument();
    }

    @Then("the system prevents the ZL2C billing document from being generated")
    public void theSystemPreventsTheZL2CBillingDocumentFromBeingGenerated() {
        billingCorrectionPage.verifyZL2CBillingDocumentNotGenerated();
    }

    @Given("the user attempted to create a billing correction request with a missing original billing document")
    public void theUserAttemptedToCreateABillingCorrectionRequestWithAMissingOriginalBillingDocument() {
        billingCorrectionPage.verifyBillingCorrectionRequestAttempted();
    }

    @When("the user checks the system logs")
    public void theUserChecksTheSystemLogs() {
        billingCorrectionPage.checkSystemLogs();
    }

    @Then("the system logs contain detailed error messages regarding the missing original billing document references")
    public void theSystemLogsContainDetailedErrorMessagesRegardingTheMissingOriginalBillingDocumentReferences() {
        billingCorrectionPage.verifyErrorMessagesInLogs();
    }

    @When("the user logs out of the SAP S/4HANA system")
    public void theUserLogsOutOfTheSAPSystem() {
        billingCorrectionPage.logoutFromSAPSystem();
    }

    @Then("the user is successfully logged out")
    public void theUserIsSuccessfullyLoggedOut() {
        billingCorrectionPage.verifyLogoutSuccess();
    }

    @Given("the user has valid credentials and appropriate permissions to create correction requests")
    public void theUserHasValidCredentialsAndPermissions() {
        billingCorrectionPage.loginToSAPSystem("validUsername", "validPassword");
        billingCorrectionPage.verifyUserPermissions("BillingCorrection");
    }

    @When("the user navigates to the billing correction form")
    public void theUserNavigatesToTheBillingCorrectionForm() {
        billingCorrectionPage.navigateToBillingCorrectionForm();
    }

    @Then("the billing correction form is displayed")
    public void theBillingCorrectionFormIsDisplayed() {
        billingCorrectionPage.verifyBillingCorrectionFormDisplayed();
    }

    @When("the user selects {string} as the correction request type")
    public void theUserSelectsCorrectionRequestType(String correctionRequestType) {
        billingCorrectionPage.selectCorrectionRequestType(correctionRequestType);
    }

    @When("the user leaves all mandatory fields blank")
    public void theUserLeavesAllMandatoryFieldsBlank() {
        billingCorrectionPage.leaveMandatoryFieldsBlank();
    }

    @When("the user attempts to submit the form")
    public void theUserAttemptsToSubmitTheForm() {
        billingCorrectionPage.submitForm();
    }

    @Then("the system prevents submission and displays an error message indicating mandatory fields are missing")
    public void theSystemPreventsSubmissionAndDisplaysErrorMessage() {
        billingCorrectionPage.verifyErrorMessage("Mandatory fields are missing.");
    }

    @When("the user attempts to bypass the error message and submit the form again")
    public void theUserAttemptsToBypassErrorMessage() {
        billingCorrectionPage.submitForm();
    }

    @Then("the system continues to block submission and displays the same error message")
    public void theSystemContinuesToBlockSubmission() {
        billingCorrectionPage.verifyErrorMessage("Mandatory fields are missing.");
    }

    @When("the user verifies if any correction request is created in the system")
    public void theUserVerifiesIfCorrectionRequestIsCreated() {
        billingCorrectionPage.verifyNoCorrectionRequestCreated();
    }

    @Then("no correction request is created in the system")
    public void noCorrectionRequestIsCreatedInTheSystem() {
        billingCorrectionPage.verifyNoCorrectionRequestCreated();
    }

    @When("the user attempts to navigate away from the form without correcting the errors")
    public void theUserAttemptsToNavigateAwayFromForm() {
        billingCorrectionPage.attemptToNavigateAway();
    }

    @Then("the system prompts the user to save or discard changes")
    public void theSystemPromptsToSaveOrDiscardChanges() {
        billingCorrectionPage.verifySaveOrDiscardPrompt();
    }

    @When("the user chooses to discard the changes and exit the form")
    public void theUserChoosesToDiscardChanges() {
        billingCorrectionPage.discardChangesAndExit();
    }

    @Then("the changes are discarded, and the user is redirected to the previous page")
    public void theChangesAreDiscarded() {
        billingCorrectionPage.verifyRedirectionToPreviousPage();
    }

    @When("the user logs back into the SAP system")
    public void theUserLogsBackIntoSAPSystem() {
        billingCorrectionPage.loginToSAPSystem("validUsername", "validPassword");
    }

    @Then("the user verifies no incomplete correction requests exist")
    public void theUserVerifiesNoIncompleteRequestsExist() {
        billingCorrectionPage.verifyNoIncompleteCorrectionRequests();
    }

    @Then("no incomplete correction requests are found in the system")
    public void noIncompleteCorrectionRequestsAreFound() {
        billingCorrectionPage.verifyNoIncompleteCorrectionRequests();
    }
}
