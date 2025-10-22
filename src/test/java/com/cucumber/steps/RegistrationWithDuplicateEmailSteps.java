package com.cucumber.steps;
import io.cucumber.java.en.When;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;

import com.pageobjects.RegistrationPage;

public class RegistrationWithDuplicateEmailSteps extends RegistrationPage {

    @Given("the user navigates to the registration page")
    public void theUserNavigatesToTheRegistrationPage() {
        navigateToRegistrationPage();
    }

    @When("the user enters the email {string}")
    public void theUserEntersTheEmail(String email) {
        enterEmail(email);
    }

    @When("the user enters a valid password {string}")
    public void theUserEntersAValidPassword(String password) {
        enterPassword(password);
    }

    @When("the user completes the CAPTCHA verification")
    public void theUserCompletesTheCAPTCHAVerification() {
        completeCaptchaVerification();
    }

    @Then("the user attempts to register")
    public void theUserAttemptsToRegister() {
        clickRegisterButton();
    }

    @Then("an error message is displayed indicating the email is already registered")
    public void anErrorMessageIsDisplayedIndicatingTheEmailIsAlreadyRegistered() {
        verifyEmailAlreadyRegisteredError();
    }
}