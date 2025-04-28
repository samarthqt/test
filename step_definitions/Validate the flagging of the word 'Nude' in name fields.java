package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NameValidationSteps extends RegistrationPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is on the registration page")
    public void theUserIsOnTheRegistrationPage() {
        navigateToRegistrationPage();
    }

    @When("the user enters {string} in the first name field")
    public void theUserEntersInTheFirstNameField(String firstName) {
        enterFirstName(firstName);
    }

    @When("the user enters {string} in the last name field")
    public void theUserEntersInTheLastNameField(String lastName) {
        enterLastName(lastName);
    }

    @When("the user submits the registration form")
    public void theUserSubmitsTheRegistrationForm() {
        clickRegisterButton();
    }

    @Then("the form submission is blocked with an appropriate error message")
    public void theFormSubmissionIsBlockedWithAnAppropriateErrorMessage() {
        verifyErrorMessage("Name contains inappropriate content.");
    }

    @Then("the form is submitted successfully without errors")
    public void theFormIsSubmittedSuccessfullyWithoutErrors() {
        verifyRegistrationSuccess("Registration successful.");
    }

    @Then("the names {string} and {string} are displayed correctly on the profile page")
    public void theNamesAreDisplayedCorrectlyOnTheProfilePage(String firstName, String lastName) {
        verifyProfileNames(firstName, lastName);
    }

    @Given("the user is on the profile update page")
    public void theUserIsOnTheProfileUpdatePage() {
        navigateToProfileUpdatePage();
    }

    @When("the user enters {string} in any name field and attempts to update")
    public void theUserEntersInAnyNameFieldAndAttemptsToUpdate(String name) {
        enterNameInProfileUpdate(name);
        submitProfileUpdate();
    }

    @Then("the update is blocked with an appropriate error message")
    public void theUpdateIsBlockedWithAnAppropriateErrorMessage() {
        verifyErrorMessage("Name contains inappropriate content.");
    }

    @When("the user submits the profile update")
    public void theUserSubmitsTheProfileUpdate() {
        submitProfileUpdate();
    }

    @Then("the profile is updated successfully without errors")
    public void theProfileIsUpdatedSuccessfullyWithoutErrors() {
        verifyProfileUpdateSuccess("Profile updated successfully.");
    }

    @Given("the system logs are accessible")
    public void theSystemLogsAreAccessible() {
        accessSystemLogs();
    }

    @When("checking the system logs for errors or warnings related to name entries")
    public void checkingTheSystemLogsForErrorsOrWarningsRelatedToNameEntries() {
        checkSystemLogsForNameErrors();
    }

    @Then("no errors or warnings are logged for acceptable names")
    public void noErrorsOrWarningsAreLoggedForAcceptableNames() {
        verifyNoErrorsInLogs();
    }
}