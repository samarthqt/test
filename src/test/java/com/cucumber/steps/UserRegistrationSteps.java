package com.cucumber.steps;
import io.cucumber.java.en.When;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import com.framework.cucumber.TestHarness;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;

public class UserRegistrationSteps extends RegistrationPage {

    private TestHarness testHarness = new TestHarness();

    @Given("user navigates to the registration page")
    public void userNavigatesToTheRegistrationPage() {
        navigateToRegistrationPage();
    }

    @When("user enters a valid email {string}")
    public void userEntersAValidEmail(String email) {
        enterEmail(email);
    }

    @When("user enters a valid password {string}")
    public void userEntersAValidPassword(String password) {
        enterPassword(password);
    }

    @When("user completes the CAPTCHA verification")
    public void userCompletesTheCAPTCHAVerification() {
        completeCaptchaVerification();
    }

    @When("user selects the 'Register' button")
    public void userSelectsTheRegisterButton() {
        clickRegisterButton();
    }

    @Then("user is registered successfully and a confirmation email is sent")
    public void userIsRegisteredSuccessfullyAndAConfirmationEmailIsSent() {
        verifyRegistrationSuccess("Registration successful. Please check your email for confirmation.");
    }

    @When("user checks the email inbox for the confirmation email")
    public void userChecksTheEmailInboxForTheConfirmationEmail() {
        checkEmailInboxForConfirmationEmail();
    }

    @Then("confirmation email is received")
    public void confirmationEmailIsReceived() {
        verifyConfirmationEmailReceived();
    }

    @When("user selects the activation link in the confirmation email")
    public void userSelectsTheActivationLinkInTheConfirmationEmail() {
        selectActivationLinkInEmail();
    }

    @Then("user account is activated")
    public void userAccountIsActivated() {
        verifyAccountActivation();
    }

    @When("user attempts to log in with the registered email and password")
    public void userAttemptsToLogInWithTheRegisteredEmailAndPassword() {
        attemptLoginWithRegisteredCredentials();
    }

    @Then("user is able to log in successfully")
    public void userIsAbleToLogInSuccessfully() {
        verifySuccessfulLogin();
    }

    @Given("user is on the homepage")
    public void userIsOnTheHomepage() {
        navigateToHomepage();
    }

    @When("user navigates to the registration page")
    public void userNavigatesToTheRegistrationPageAgain() {
        navigateToRegistrationPage();
    }

    @Then("the registration page is displayed prominently")
    public void theRegistrationPageIsDisplayedProminently() {
        verifyRegistrationPageDisplayed();
    }

    @When("user enters an existing email {string}")
    public void userEntersAnExistingEmail(String email) {
        enterEmail(email);
    }

    @Then("an error message is displayed indicating duplicate registration is not allowed")
    public void anErrorMessageIsDisplayedIndicatingDuplicateRegistrationIsNotAllowed() {
        verifyDuplicateRegistrationError();
    }

    @When("user enters a weak password {string}")
    public void userEntersAWeakPassword(String password) {
        enterPassword(password);
    }

    @Then("an error message is displayed indicating the password is too weak")
    public void anErrorMessageIsDisplayedIndicatingThePasswordIsTooWeak() {
        verifyWeakPasswordError();
    }

    @When("user does not accept the terms and conditions")
    public void userDoesNotAcceptTheTermsAndConditions() {
        doNotAcceptTermsAndConditions();
    }

    @Then("an error message is displayed indicating terms and conditions must be accepted")
    public void anErrorMessageIsDisplayedIndicatingTermsAndConditionsMustBeAccepted() {
        verifyTermsAndConditionsError();
    }

    @Given("user navigates to the login page")
    public void userNavigatesToTheLoginPage() {
        navigateToLoginPage();
    }

    @When("user enters a registered email {string}")
    public void userEntersARegisteredEmail(String email) {
        enterUserName(email);
    }

    @When("user enters the correct password {string}")
    public void userEntersTheCorrectPassword(String password) {
        enterPassword(password);
    }

    @When("user selects the 'Login' button")
    public void userSelectsTheLoginButton() {
        clickLoginButton();
    }

    @Then("a prompt is displayed to complete account activation via the confirmation link")
    public void aPromptIsDisplayedToCompleteAccountActivationViaTheConfirmationLink() {
        verifyActivationPrompt();
    }

    @When("user enters an invalid email {string}")
    public void userEntersAnInvalidEmail(String email) {
        enterEmail(email);
    }

    @Then("an error message is displayed indicating the email format is invalid")
    public void anErrorMessageIsDisplayedIndicatingTheEmailFormatIsInvalid() {
        verifyInvalidEmailFormatError();
    }
}