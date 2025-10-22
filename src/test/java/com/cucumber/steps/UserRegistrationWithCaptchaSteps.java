package com.cucumber.steps;
import io.cucumber.java.en.When;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import com.framework.cucumber.TestHarness;

import com.pageobjects.RegistrationPageWithCaptcha;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;

public class UserRegistrationWithCaptchaSteps extends RegistrationPageWithCaptcha {

    @Given("the user navigates to the registration page")
    public void theUserNavigatesToTheRegistrationPage() {
        navigateToRegistrationPage();
    }

    @When("the user enters a valid email {string}")
    public void theUserEntersAValidEmail(String email) {
        enterEmail(email);
    }

    @When("the user enters a valid password {string}")
    public void theUserEntersAValidPassword(String password) {
        enterPassword(password);
    }

    @When("the user leaves the CAPTCHA field incomplete")
    public void theUserLeavesTheCaptchaFieldIncomplete() {
        leaveCaptchaFieldIncomplete();
    }

    @When("the user attempts to register")
    public void theUserAttemptsToRegister() {
        clickRegisterButton();
    }

    @Then("the system should prevent registration and prompt to complete CAPTCHA")
    public void theSystemShouldPreventRegistrationAndPromptToCompleteCaptcha() {
        verifyCaptchaPrompt();
    }
}