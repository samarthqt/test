package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;

import com.pageobjects.ZRKCorrectionRequestPage;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class ZRKCorrectionRequestSteps extends ZRKCorrectionRequestPage {

    @Given("user logs in to the SAP system with valid credentials")
    public void userLogsInToTheSAPSystemWithValidCredentials() {
        loginToSAPSystem("validUsername", "validPassword");
    }

    @Given("user navigates to the billing correction form")
    public void userNavigatesToTheBillingCorrectionForm() {
        navigateToBillingCorrectionForm();
    }

    @Given("user selects {string} as the correction request type")
    public void userSelectsCorrectionRequestType(String correctionRequestType) {
        selectCorrectionRequestType(correctionRequestType);
    }

    @Given("user leaves the {string} and {string} fields blank")
    public void userLeavesMandatoryFieldsBlank(String mandatoryField1, String mandatoryField2) {
        leaveMandatoryFieldsBlank(mandatoryField1, mandatoryField2);
    }

    @Given("user fills in other optional fields with valid data")
    public void userFillsInOtherOptionalFieldsWithValidData() {
        fillOptionalFields("OptionalField1Value", "OptionalField2Value");
    }

    @When("user submits the correction request form")
    public void userSubmitsTheCorrectionRequestForm() {
        submitCorrectionRequestForm();
    }

    @Then("the system prevents submission and displays error messages indicating the {string} and {string} fields are missing")
    public void theSystemPreventsSubmissionAndDisplaysErrorMessages(String mandatoryField1, String mandatoryField2) {
        verifyErrorMessagesForMissingFields(mandatoryField1, mandatoryField2);
    }

    @Then("the system displays error messages clearly specifying that {string} and {string} are missing")
    public void theSystemDisplaysErrorMessagesClearlySpecifyingMissingFields(String mandatoryField1, String mandatoryField2) {
        verifyErrorMessagesForMissingFields(mandatoryField1, mandatoryField2);
    }

    @When("user attempts to navigate away from the form without correcting the errors")
    public void userAttemptsToNavigateAwayFromTheFormWithoutCorrectingTheErrors() {
        attemptToNavigateAwayFromForm();
    }

    @Then("the system prompts the user to save or discard changes")
    public void theSystemPromptsTheUserToSaveOrDiscardChanges() {
        verifySaveOrDiscardPrompt();
    }

    @When("user corrects the {string} and {string} fields and resubmits the form")
    public void userCorrectsMandatoryFieldsAndResubmitsTheForm(String mandatoryField1, String mandatoryField2) {
        correctMandatoryFieldsAndResubmit(mandatoryField1, mandatoryField2);
    }

    @Then("the system accepts the correction request and displays a success message")
    public void theSystemAcceptsTheCorrectionRequestAndDisplaysASuccessMessage() {
        verifySuccessMessage();
    }

    @Given("user fills in all mandatory fields including {string} and {string}")
    public void userFillsInAllMandatoryFields(String mandatoryField1, String mandatoryField2) {
        fillMandatoryFields(mandatoryField1, mandatoryField2);
    }

    @Then("the correction request is successfully saved in the system with all mandatory fields populated")
    public void theCorrectionRequestIsSuccessfullySavedInTheSystem() {
        verifyCorrectionRequestSaved();
    }

    @Given("user is logged into the SAP system")
    public void userIsLoggedIntoTheSAPSystem() {
        verifyUserLoggedIn();
    }

    @When("user logs out of the SAP system")
    public void userLogsOutOfTheSAPSystem() {
        logoutFromSAPSystem();
    }

    @Then("the user is successfully logged out")
    public void theUserIsSuccessfullyLoggedOut() {
        verifyUserLoggedOut();
    }
}