package com.cucumber.steps;
import io.cucumber.java.en.When;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;

import com.pageobjects.RegistrationPage;

public class RegistrationSteps extends RegistrationPage {

    @Given("the user navigates to the registration page")
    public void theUserNavigatesToTheRegistrationPage() {
        navigateToRegistrationPage();
    }

    @When("the user enters a valid email {string}")
    public void theUserEntersAValidEmail(String email) {
        enterEmail(email);
    }

    @When("the user enters a password {string}")
    public void theUserEntersAPassword(String password) {
        enterPassword(password);
    }

    @When("the user completes the CAPTCHA verification")
    public void theUserCompletesTheCAPTCHAVerification() {
        completeCaptchaVerification();
    }

    @Then("the system should show {string}")
    public void theSystemShouldShow(String message) {
        verifySystemMessage(message);
    }

    @Then("CAPTCHA is verified successfully")
    public void captchaIsVerifiedSuccessfully() {
        verifyCaptchaSuccess();
    }

    @When("the user attempts to register")
    public void theUserAttemptsToRegister() {
        attemptToRegister();
    }

    @Then("the system prevents registration and highlights the weak password field")
    public void theSystemPreventsRegistrationAndHighlightsTheWeakPasswordField() {
        verifyWeakPasswordFieldHighlighted();
    }
}