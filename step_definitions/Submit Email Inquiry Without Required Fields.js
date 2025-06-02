import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import EmailInquiryPage from "../pages/emailInquiryPage";

Given("I am logged into the user account using valid credentials", () => {
 cy.login();
});

Given("I navigate to the email inquiry form section of the application", () => {
 EmailInquiryPage.visit();
});

Given("I am on the email inquiry form", () => {
 EmailInquiryPage.visit();
});

Given("I have attempted to submit the form without required fields", () => {
 EmailInquiryPage.attemptSubmitWithoutRequiredFields();
});

Given("I have successfully submitted an inquiry", () => {
 EmailInquiryPage.submitFormWithValidData();
});

Given("I have attempted to submit an incomplete form", () => {
 EmailInquiryPage.attemptIncompleteFormSubmission();
});

When("I attempt to submit the form without filling in the required fields", () => {
 EmailInquiryPage.submitFormWithoutRequiredFields();
});

When("I attempt to submit the form with only some required fields filled", () => {
 EmailInquiryPage.submitFormWithSomeRequiredFields();
});

When("I fill in all required fields", () => {
 EmailInquiryPage.fillAllRequiredFields();
});

When("I fill in the required fields with invalid data", () => {
 EmailInquiryPage.fillRequiredFieldsWithInvalidData();
});

When("I fill in all required fields and leave optional fields blank", () => {
 EmailInquiryPage.fillRequiredFieldsLeaveOptionalBlank();
});

When("I submit multiple inquiries in quick succession", () => {
 EmailInquiryPage.submitMultipleInquiriesQuickSuccession();
});

When("I submit the form", () => {
 EmailInquiryPage.submitForm();
});

Then("the system displays an error message indicating missing required fields", () => {
 EmailInquiryPage.verifyErrorMessageForMissingFields();
});

Then("the error message clearly specifies which fields are required", () => {
 EmailInquiryPage.verifySpecificMissingFieldsError();
});

Then("form submission is blocked until required fields are completed", () => {
 EmailInquiryPage.verifySubmissionBlocked();
});

Then("the system displays an error for remaining missing fields", () => {
 EmailInquiryPage.verifyErrorForRemainingFields();
});

Then("the missing fields are highlighted for user attention", () => {
 EmailInquiryPage.verifyHighlightedMissingFields();
});

Then("no errors are logged in the system", () => {
 EmailInquiryPage.verifyNoErrorsLogged();
});

Then("submission attempts are recorded as expected", () => {
 EmailInquiryPage.verifySubmissionAttemptsRecorded();
});

Then("the form submission is successful", () => {
 EmailInquiryPage.verifySuccessfulSubmission();
});

Then("the system displays validation errors for invalid data", () => {
 EmailInquiryPage.verifyValidationErrorsForInvalidData();
});

Then("I receive a confirmation notification", () => {
 EmailInquiryPage.verifyConfirmationNotification();
});

Then("the system handles multiple submissions without errors", () => {
 EmailInquiryPage.verifyMultipleSubmissionsHandled();
});

Then("user attempts are logged correctly in the system", () => {
 EmailInquiryPage.verifyUserAttemptsLoggedCorrectly();
});

Then("the system performance is consistent regardless of submission attempts", () => {
 EmailInquiryPage.verifyConsistentSystemPerformance();
});