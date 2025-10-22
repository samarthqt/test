package com.cucumber.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import com.framework.cucumber.TestHarness;

public class UserRegistrationSteps {

    private TestHarness testHarness = new TestHarness();
    private RegistrationPage registrationPage = new RegistrationPage();

    @Given("the user is on the registration page")
    public void theUserIsOnTheRegistrationPage() {
        registrationPage.navigateToRegistrationPage();
    }

    @When("the user enters {string} in the {string} field")
    public void theUserEntersValueInField(String value, String fieldName) {
        switch (fieldName) {
            case "First name":
                registrationPage.enterFirstName(value);
                break;
            case "Last name":
                registrationPage.enterLastName(value);
                break;
            case "Email":
                registrationPage.enterEmail(value);
                break;
            case "Password":
                registrationPage.enterPassword(value);
                break;
            case "Confirm password":
                registrationPage.enterConfirmPassword(value);
                break;
            default:
                throw new IllegalArgumentException("Unknown field: " + fieldName);
        }
    }

    @When("the user clicks the {string} button")
    public void theUserClicksTheButton(String buttonName) {
        if (buttonName.equals("Register")) {
            registrationPage.clickRegisterButton();
        }
    }

    @Then("the user should be successfully registered and see a confirmation message")
    public void theUserShouldBeSuccessfullyRegisteredAndSeeAConfirmationMessage() {
        String expectedMessage = testHarness.getData("RegistrationData", "ExpectedConfirmationMessage");
        registrationPage.verifyRegistrationSuccess(expectedMessage);
    }

    @When("the user enters a valid email {string}")
    public void theUserEntersAValidEmail(String email) {
        registrationPage.enterEmail(email);
    }

    @When("the user enters a valid password {string}")
    public void theUserEntersAValidPassword(String password) {
        registrationPage.enterPassword(password);
    }

    @When("the user completes the CAPTCHA verification")
    public void theUserCompletesTheCAPTCHAVerification() {
        // Implement CAPTCHA verification logic
    }

    @Then("the user attempts to register")
    public void theUserAttemptsToRegister() {
        registrationPage.clickRegisterButton();
    }

    @Then("an error message is displayed indicating the email is already registered")
    public void anErrorMessageIsDisplayedIndicatingTheEmailIsAlreadyRegistered() {
        String expectedErrorMessage = testHarness.getData("RegistrationData", "DuplicateEmailErrorMessage");
        registrationPage.verifyErrorMessage(expectedErrorMessage);
    }

    @When("the user enters the existing email {string}")
    public void theUserEntersTheExistingEmail(String email) {
        registrationPage.enterEmail(email);
    }

    @When("the user re-enters the same valid password {string} for confirmation")
    public void theUserReEntersTheSameValidPasswordForConfirmation(String password) {
        registrationPage.enterConfirmPassword(password);
    }

    @When("the user checks the 'I accept the Privacy Policy and Terms & Conditions' checkbox")
    public void theUserChecksThePrivacyPolicyCheckbox() {
        // Implement checkbox selection logic
    }

    @Then("the user submits the registration form")
    public void theUserSubmitsTheRegistrationForm() {
        registrationPage.clickRegisterButton();
    }

    @When("the user enters an invalid email address format {string}")
    public void theUserEntersAnInvalidEmailAddressFormat(String email) {
        registrationPage.enterEmail(email);
    }

    @Then("an error message is displayed indicating invalid email format")
    public void anErrorMessageIsDisplayedIndicatingInvalidEmailFormat() {
        registrationPage.verifyInvalidEmailErrorMessage();
    }

    @Then("the system should {string}")
    public void theSystemShould(String result) {
        registrationPage.verifySystemResponse(result);
    }

    @Then("the system should show {string}")
    public void theSystemShouldShow(String message) {
        registrationPage.verifySystemMessage(message);
    }

    @Then("CAPTCHA is verified successfully")
    public void captchaIsVerifiedSuccessfully() {
        registrationPage.verifyCaptchaSuccess();
    }

    @Then("the system prevents registration and highlights the weak password field")
    public void theSystemPreventsRegistrationAndHighlightsTheWeakPasswordField() {
        registrationPage.verifyWeakPasswordFieldHighlight();
    }

    @When("the user re-enters the same weak password for confirmation")
    public void theUserReEntersTheSameWeakPasswordForConfirmation() {
        registrationPage.enterConfirmPassword("weak");
    }

    @Then("the system shows an error message indicating the password is too weak")
    public void theSystemShowsAnErrorMessageIndicatingThePasswordIsTooWeak() {
        registrationPage.verifyWeakPasswordErrorMessage();
    }
}
