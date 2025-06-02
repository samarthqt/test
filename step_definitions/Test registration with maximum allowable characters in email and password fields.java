package com.cucumber.steps;

import com.page_objects.RegistrationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationSteps extends RegistrationPage {

    @Given("the user registration page is accessible")
    public void theUserRegistrationPageIsAccessible() {
        navigateToRegistrationPage();
    }

    @When("the user navigates to the registration page of the application")
    public void theUserNavigatesToTheRegistrationPageOfTheApplication() {
        navigateToRegistrationPage();
    }

    @Then("the registration page is displayed")
    public void theRegistrationPageIsDisplayed() {
        verifyRegistrationPageDisplayed();
    }

    @Given("the maximum character limits for email and password fields are understood")
    public void theMaximumCharacterLimitsForEmailAndPasswordFieldsAreUnderstood() {
        // Assume understanding of limits
    }

    @When("the user enters the maximum allowable characters in the email field")
    public void theUserEntersTheMaximumAllowableCharactersInTheEmailField() {
        enterEmail(maxEmailCharacters());
    }

    @Then("the email is entered successfully")
    public void theEmailIsEnteredSuccessfully() {
        verifyEmailEntrySuccess();
    }

    @When("the user enters the maximum allowable characters in the password field")
    public void theUserEntersTheMaximumAllowableCharactersInThePasswordField() {
        enterPassword(maxPasswordCharacters());
    }

    @Then("the password is entered successfully")
    public void thePasswordIsEnteredSuccessfully() {
        verifyPasswordEntrySuccess();
    }

    @Given("all required registration fields are filled with valid data")
    public void allRequiredRegistrationFieldsAreFilledWithValidData() {
        fillRegistrationFieldsWithValidData();
    }

    @When("the user clicks on the 'Register' button")
    public void theUserClicksOnTheRegisterButton() {
        clickRegisterButton();
    }

    @Then("the registration process is initiated")
    public void theRegistrationProcessIsInitiated() {
        verifyRegistrationInitiated();
    }

    @When("the registration confirmation message is displayed")
    public void theRegistrationConfirmationMessageIsDisplayed() {
        verifyRegistrationConfirmationMessage();
    }

    @Then("the registration confirmation message is displayed")
    public void theRegistrationConfirmationMessageIsDisplayedAgain() {
        verifyRegistrationConfirmationMessage();
    }

    @When("the user verifies the email received for registration confirmation")
    public void theUserVerifiesTheEmailReceivedForRegistrationConfirmation() {
        verifyEmailReceivedForConfirmation();
    }

    @Then("the email confirmation is received successfully")
    public void theEmailConfirmationIsReceivedSuccessfully() {
        verifyEmailConfirmationSuccess();
    }

    @When("the user attempts to log in using the registered email and password")
    public void theUserAttemptsToLogInUsingTheRegisteredEmailAndPassword() {
        loginWithRegisteredCredentials();
    }

    @Then("the user is able to log in successfully")
    public void theUserIsAbleToLogInSuccessfully() {
        verifyLoginSuccess();
    }

    @When("the user checks the user profile for registration details")
    public void theUserChecksTheUserProfileForRegistrationDetails() {
        checkUserProfileForRegistrationDetails();
    }

    @Then("the user profile displays correct registration details")
    public void theUserProfileDisplaysCorrectRegistrationDetails() {
        verifyUserProfileDetails();
    }

    @When("the system stores the email and password")
    public void theSystemStoresTheEmailAndPassword() {
        storeEmailAndPassword();
    }

    @Then("the email and password are stored completely")
    public void theEmailAndPasswordAreStoredCompletely() {
        verifyEmailAndPasswordStorage();
    }

    @When("the user logs out from the application")
    public void theUserLogsOutFromTheApplication() {
        logoutFromApplication();
    }

    @Then("the user is logged out successfully")
    public void theUserIsLoggedOutSuccessfully() {
        verifyLogoutSuccess();
    }

    @When("the user attempts to reset the password using the registered email")
    public void theUserAttemptsToResetThePasswordUsingTheRegisteredEmail() {
        resetPasswordUsingRegisteredEmail();
    }

    @Then("the password reset link is sent to the email")
    public void thePasswordResetLinkIsSentToTheEmail() {
        verifyPasswordResetLinkSent();
    }

    @When("the user resets the password using the maximum allowable characters")
    public void theUserResetsThePasswordUsingTheMaximumAllowableCharacters() {
        resetPasswordWithMaxCharacters();
    }

    @Then("the password reset is successful")
    public void thePasswordResetIsSuccessful() {
        verifyPasswordResetSuccess();
    }

    @When("the system logs are checked for errors during registration")
    public void theSystemLogsAreCheckedForErrorsDuringRegistration() {
        checkSystemLogsForErrors();
    }

    @Then("no errors are logged in the system")
    public void noErrorsAreLoggedInTheSystem() {
        verifyNoErrorsInLogs();
    }

    @When("the registration data is stored in the database")
    public void theRegistrationDataIsStoredInTheDatabase() {
        storeRegistrationDataInDatabase();
    }

    @Then("the registration data is encrypted")
    public void theRegistrationDataIsEncrypted() {
        verifyDataEncryption();
    }
}