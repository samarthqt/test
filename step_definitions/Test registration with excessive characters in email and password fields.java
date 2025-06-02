package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.RegistrationPage;

public class RegistrationSteps extends RegistrationPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user registration page is accessible")
    public void theUserRegistrationPageIsAccessible() {
        navigateToRegistrationPage();
    }

    @When("I navigate to the registration page of the application")
    public void iNavigateToTheRegistrationPageOfTheApplication() {
        navigateToRegistrationPage();
    }

    @Then("the registration page is displayed")
    public void theRegistrationPageIsDisplayed() {
        verifyRegistrationPageDisplayed();
    }

    @Given("I understand maximum character limits for email and password fields")
    public void iUnderstandMaximumCharacterLimitsForEmailAndPasswordFields() {
        // Understanding is assumed
    }

    @When("I enter excessive characters in the email field")
    public void iEnterExcessiveCharactersInTheEmailField() {
        enterEmail(testHarness.getData("RegistrationData", "ExcessiveEmail"));
    }

    @Then("the system displays an error message for exceeding character limit")
    public void theSystemDisplaysAnErrorMessageForExceedingCharacterLimit() {
        verifyErrorMessageForExcessiveCharacters();
    }

    @When("I enter excessive characters in the password field")
    public void iEnterExcessiveCharactersInThePasswordField() {
        enterPassword(testHarness.getData("RegistrationData", "ExcessivePassword"));
    }

    @Given("I have entered excessive characters in the email and password fields")
    public void iHaveEnteredExcessiveCharactersInTheEmailAndPasswordFields() {
        enterEmail(testHarness.getData("RegistrationData", "ExcessiveEmail"));
        enterPassword(testHarness.getData("RegistrationData", "ExcessivePassword"));
    }

    @When("I fill in other required registration fields with valid data")
    public void iFillInOtherRequiredRegistrationFieldsWithValidData() {
        enterFirstName(testHarness.getData("RegistrationData", "FirstName"));
        enterLastName(testHarness.getData("RegistrationData", "LastName"));
        enterConfirmPassword(testHarness.getData("RegistrationData", "ExcessivePassword"));
    }

    @Then("all fields are populated correctly")
    public void allFieldsArePopulatedCorrectly() {
        verifyAllFieldsPopulatedCorrectly();
    }

    @When("I click on the 'Register' button")
    public void iClickOnTheRegisterButton() {
        clickRegisterButton();
    }

    @Then("the registration process is not initiated due to errors")
    public void theRegistrationProcessIsNotInitiatedDueToErrors() {
        verifyRegistrationNotInitiated();
    }

    @Given("I have attempted to register with excessive characters")
    public void iHaveAttemptedToRegisterWithExcessiveCharacters() {
        // Attempt is assumed
    }

    @When("I check if the registration error message is displayed")
    public void iCheckIfTheRegistrationErrorMessageIsDisplayed() {
        verifyErrorMessageForExcessiveCharacters();
    }

    @Then("the registration error message is displayed for email and password")
    public void theRegistrationErrorMessageIsDisplayedForEmailAndPassword() {
        verifyErrorMessageForExcessiveCharacters();
    }

    @When("I attempt to log in using the email and password with excessive characters")
    public void iAttemptToLogInUsingTheEmailAndPasswordWithExcessiveCharacters() {
        attemptLoginWithExcessiveCharacters();
    }

    @Then("the user is unable to log in due to invalid credentials")
    public void theUserIsUnableToLogInDueToInvalidCredentials() {
        verifyLoginFailureDueToInvalidCredentials();
    }

    @When("I verify that no registration email is received")
    public void iVerifyThatNoRegistrationEmailIsReceived() {
        verifyNoRegistrationEmailReceived();
    }

    @Then("no registration confirmation email is received")
    public void noRegistrationConfirmationEmailIsReceived() {
        verifyNoRegistrationEmailReceived();
    }

    @When("I check the user profile for any registration details")
    public void iCheckTheUserProfileForAnyRegistrationDetails() {
        verifyUserProfileNotCreated();
    }

    @Then("the user profile is not created")
    public void theUserProfileIsNotCreated() {
        verifyUserProfileNotCreated();
    }

    @When("I verify that the system does not store excessive characters in email or password")
    public void iVerifyThatTheSystemDoesNotStoreExcessiveCharactersInEmailOrPassword() {
        verifyExcessiveCharactersNotStored();
    }

    @Then("the system does not store excessive characters")
    public void theSystemDoesNotStoreExcessiveCharacters() {
        verifyExcessiveCharactersNotStored();
    }

    @Given("I am logged in")
    public void iAmLoggedIn() {
        // Assume user is logged in
    }

    @When("I log out from the application")
    public void iLogOutFromTheApplication() {
        logOut();
    }

    @Then("the user is logged out successfully")
    public void theUserIsLoggedOutSuccessfully() {
        verifyLogoutSuccess();
    }

    @When("I attempt to reset the password using the email with excessive characters")
    public void iAttemptToResetThePasswordUsingTheEmailWithExcessiveCharacters() {
        attemptPasswordResetWithExcessiveEmail();
    }

    @Then("the system displays an error message for invalid email")
    public void theSystemDisplaysAnErrorMessageForInvalidEmail() {
        verifyErrorMessageForInvalidEmail();
    }

    @When("I verify the password reset functionality with excessive characters")
    public void iVerifyThePasswordResetFunctionalityWithExcessiveCharacters() {
        verifyPasswordResetFailureWithExcessiveEmail();
    }

    @Then("the password reset is unsuccessful due to invalid email")
    public void thePasswordResetIsUnsuccessfulDueToInvalidEmail() {
        verifyPasswordResetFailureWithExcessiveEmail();
    }

    @When("I check the system logs for errors during registration attempts")
    public void iCheckTheSystemLogsForErrorsDuringRegistrationAttempts() {
        verifySystemLogsForErrors();
    }

    @Then("errors are logged for exceeding character limits")
    public void errorsAreLoggedForExceedingCharacterLimits() {
        verifySystemLogsForErrors();
    }

    @When("I ensure the system does not store invalid registration data")
    public void iEnsureTheSystemDoesNotStoreInvalidRegistrationData() {
        verifyInvalidRegistrationDataNotStored();
    }

    @Then("invalid registration data is not stored")
    public void invalidRegistrationDataIsNotStored() {
        verifyInvalidRegistrationDataNotStored();
    }
}