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

    @When("I enter {string} in the email field")
    public void iEnterInTheEmailField(String email) {
        enterEmail(email);
    }

    @Then("the email with special characters is entered successfully")
    public void theEmailWithSpecialCharactersIsEnteredSuccessfully() {
        verifyEmailEnteredSuccessfully();
    }

    @When("I enter {string} in the password field")
    public void iEnterInThePasswordField(String password) {
        enterPassword(password);
    }

    @Then("the password with special characters is entered successfully")
    public void thePasswordWithSpecialCharactersIsEnteredSuccessfully() {
        verifyPasswordEnteredSuccessfully();
    }

    @When("I fill in other required registration fields with valid data")
    public void iFillInOtherRequiredRegistrationFieldsWithValidData() {
        fillOtherRegistrationFields();
    }

    @Then("all fields are populated correctly")
    public void allFieldsArePopulatedCorrectly() {
        verifyAllFieldsPopulatedCorrectly();
    }

    @When("I click on the 'Register' button")
    public void iClickOnTheRegisterButton() {
        clickRegisterButton();
    }

    @Then("the registration process is initiated")
    public void theRegistrationProcessIsInitiated() {
        verifyRegistrationInitiated();
    }

    @When("I check if the registration confirmation message is displayed")
    public void iCheckIfTheRegistrationConfirmationMessageIsDisplayed() {
        verifyRegistrationConfirmationMessageDisplayed();
    }

    @Then("the registration confirmation message is displayed")
    public void theRegistrationConfirmationMessageIsDisplayed() {
        verifyRegistrationConfirmationMessageDisplayed();
    }

    @When("I verify the email received for registration confirmation")
    public void iVerifyTheEmailReceivedForRegistrationConfirmation() {
        verifyEmailReceivedForConfirmation();
    }

    @Then("email confirmation is received successfully")
    public void emailConfirmationIsReceivedSuccessfully() {
        verifyEmailConfirmationReceivedSuccessfully();
    }

    @When("I attempt to log in using the registered email and password")
    public void iAttemptToLogInUsingTheRegisteredEmailAndPassword() {
        attemptLoginWithRegisteredCredentials();
    }

    @Then("the user is able to log in successfully")
    public void theUserIsAbleToLogInSuccessfully() {
        verifyUserLoggedInSuccessfully();
    }

    @When("I check the user profile for registration details")
    public void iCheckTheUserProfileForRegistrationDetails() {
        checkUserProfileForRegistrationDetails();
    }

    @Then("the user profile displays correct registration details")
    public void theUserProfileDisplaysCorrectRegistrationDetails() {
        verifyUserProfileDisplaysCorrectDetails();
    }

    @When("I verify that the system does not truncate special characters in email or password")
    public void iVerifyThatTheSystemDoesNotTruncateSpecialCharactersInEmailOrPassword() {
        verifyNoTruncationOfSpecialCharacters();
    }

    @Then("email and password are stored completely with special characters")
    public void emailAndPasswordAreStoredCompletelyWithSpecialCharacters() {
        verifyEmailAndPasswordStoredCorrectly();
    }

    @When("I log out from the application")
    public void iLogOutFromTheApplication() {
        logOutFromApplication();
    }

    @Then("the user is logged out successfully")
    public void theUserIsLoggedOutSuccessfully() {
        verifyUserLoggedOutSuccessfully();
    }

    @When("I attempt to reset the password using the registered email")
    public void iAttemptToResetThePasswordUsingTheRegisteredEmail() {
        attemptPasswordResetWithRegisteredEmail();
    }

    @Then("the password reset link is sent to the email")
    public void thePasswordResetLinkIsSentToTheEmail() {
        verifyPasswordResetLinkSent();
    }

    @When("I verify the password reset functionality with special characters")
    public void iVerifyThePasswordResetFunctionalityWithSpecialCharacters() {
        verifyPasswordResetWithSpecialCharacters();
    }

    @Then("password reset is successful using special characters")
    public void passwordResetIsSuccessfulUsingSpecialCharacters() {
        verifyPasswordResetSuccessful();
    }

    @When("I check the system logs for any errors during registration")
    public void iCheckTheSystemLogsForAnyErrorsDuringRegistration() {
        checkSystemLogsForErrors();
    }

    @Then("no errors are logged in the system")
    public void noErrorsAreLoggedInTheSystem() {
        verifyNoErrorsLogged();
    }

    @When("I ensure the registration data is encrypted in the database")
    public void iEnsureTheRegistrationDataIsEncryptedInTheDatabase() {
        ensureRegistrationDataEncrypted();
    }

    @Then("registration data is encrypted")
    public void registrationDataIsEncrypted() {
        verifyRegistrationDataEncrypted();
    }
}