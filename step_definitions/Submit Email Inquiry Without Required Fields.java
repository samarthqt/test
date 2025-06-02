package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.EmailInquiryPage;

public class EmailInquirySteps extends EmailInquiryPage {

    private TestHarness testHarness = new TestHarness();

    @Given("I am logged into the user account using valid credentials")
    public void iAmLoggedIntoTheUserAccountUsingValidCredentials() {
        loginWithValidCredentials();
    }

    @Given("I navigate to the email inquiry form section of the application")
    public void iNavigateToTheEmailInquiryFormSectionOfTheApplication() {
        navigateToEmailInquiryForm();
    }

    @When("I attempt to submit the form without filling in the required fields")
    public void iAttemptToSubmitTheFormWithoutFillingInTheRequiredFields() {
        submitFormWithoutRequiredFields();
    }

    @Then("the system displays an error message indicating missing required fields")
    public void theSystemDisplaysAnErrorMessageIndicatingMissingRequiredFields() {
        verifyErrorMessageForMissingFields();
    }

    @Then("the error message clearly specifies which fields are required")
    public void theErrorMessageClearlySpecifiesWhichFieldsAreRequired() {
        verifySpecificMissingFields();
    }

    @Then("form submission is blocked until required fields are completed")
    public void formSubmissionIsBlockedUntilRequiredFieldsAreCompleted() {
        verifyFormSubmissionBlocked();
    }

    @Given("I am on the email inquiry form")
    public void iAmOnTheEmailInquiryForm() {
        navigateToEmailInquiryForm();
    }

    @When("I attempt to submit the form with only some required fields filled")
    public void iAttemptToSubmitTheFormWithOnlySomeRequiredFieldsFilled() {
        submitFormWithPartialFields();
    }

    @Then("the system displays an error for remaining missing fields")
    public void theSystemDisplaysAnErrorForRemainingMissingFields() {
        verifyErrorForRemainingFields();
    }

    @Then("the missing fields are highlighted for user attention")
    public void theMissingFieldsAreHighlightedForUserAttention() {
        verifyHighlightedMissingFields();
    }

    @Given("I have attempted to submit the form without required fields")
    public void iHaveAttemptedToSubmitTheFormWithoutRequiredFields() {
        attemptFormSubmissionWithoutFields();
    }

    @Then("no errors are logged in the system")
    public void noErrorsAreLoggedInTheSystem() {
        verifyNoErrorsLogged();
    }

    @Then("submission attempts are recorded as expected")
    public void submissionAttemptsAreRecordedAsExpected() {
        verifySubmissionAttemptsRecorded();
    }

    @When("I fill in all required fields")
    public void iFillInAllRequiredFields() {
        fillAllRequiredFields();
    }

    @When("I submit the form")
    public void iSubmitTheForm() {
        submitForm();
    }

    @Then("the form submission is successful")
    public void theFormSubmissionIsSuccessful() {
        verifySuccessfulFormSubmission();
    }

    @When("I fill in the required fields with invalid data")
    public void iFillInTheRequiredFieldsWithInvalidData() {
        fillRequiredFieldsWithInvalidData();
    }

    @Then("the system displays validation errors for invalid data")
    public void theSystemDisplaysValidationErrorsForInvalidData() {
        verifyValidationErrorsForInvalidData();
    }

    @When("I fill in all required fields and leave optional fields blank")
    public void iFillInAllRequiredFieldsAndLeaveOptionalFieldsBlank() {
        fillRequiredFieldsLeaveOptionalBlank();
    }

    @Given("I have successfully submitted an inquiry")
    public void iHaveSuccessfullySubmittedAnInquiry() {
        submitSuccessfulInquiry();
    }

    @Then("I receive a confirmation notification")
    public void iReceiveAConfirmationNotification() {
        verifyConfirmationNotification();
    }

    @When("I submit multiple inquiries in quick succession")
    public void iSubmitMultipleInquiriesInQuickSuccession() {
        submitMultipleInquiriesQuickly();
    }

    @Then("the system handles multiple submissions without errors")
    public void theSystemHandlesMultipleSubmissionsWithoutErrors() {
        verifyMultipleSubmissionsHandled();
    }

    @Given("I have attempted to submit an incomplete form")
    public void iHaveAttemptedToSubmitAnIncompleteForm() {
        attemptIncompleteFormSubmission();
    }

    @Then("user attempts are logged correctly in the system")
    public void userAttemptsAreLoggedCorrectlyInTheSystem() {
        verifyUserAttemptsLoggedCorrectly();
    }

    @Then("the system performance is consistent regardless of submission attempts")
    public void theSystemPerformanceIsConsistentRegardlessOfSubmissionAttempts() {
        verifySystemPerformanceConsistency();
    }
}