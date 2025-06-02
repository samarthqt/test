package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.SignUpPage;

public class SignUpSteps extends SignUpPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user navigates to the application URL {string}")
    public void theUserNavigatesToTheApplicationURL(String url) {
        launchUrl(url);
        maximizeWindow();
    }

    @When("the user clicks on the {string} button")
    public void theUserClicksOnTheButton(String buttonName) {
        if (buttonName.equals("Sign Up")) {
            clickSignUpButton();
        }
    }

    @Then("sign-up options are displayed")
    public void signUpOptionsAreDisplayed() {
        verifySignUpOptionsDisplayed();
    }

    @When("the user enters the registered email {string} in the email field")
    public void theUserEntersTheRegisteredEmailInTheEmailField(String email) {
        enterEmail(email);
    }

    @When("the user enters a new password {string} in the password field")
    public void theUserEntersANewPasswordInThePasswordField(String password) {
        enterPassword(password);
    }

    @When("the user clicks on {string} to proceed")
    public void theUserClicksOnToProceed(String buttonName) {
        if (buttonName.equals("Sign Up")) {
            clickProceedSignUp();
        }
    }

    @Then("the system processes the sign-up request")
    public void theSystemProcessesTheSignUpRequest() {
        verifySignUpRequestProcessing();
    }

    @Then("the system checks email registration status")
    public void theSystemChecksEmailRegistrationStatus() {
        verifyEmailRegistrationStatus();
    }

    @Then("an error message indicating the email is already registered is displayed")
    public void anErrorMessageIndicatingTheEmailIsAlreadyRegisteredIsDisplayed() {
        verifyErrorMessageDisplayed();
    }

    @Then("the error message includes guidance for recovering password or contacting support")
    public void theErrorMessageIncludesGuidanceForRecoveringPasswordOrContactingSupport() {
        verifyErrorMessageGuidance();
    }

    @When("the user enters a different email in the email field")
    public void theUserEntersADifferentEmailInTheEmailField() {
        String differentEmail = testHarness.getData("SignUpData", "DifferentEmail");
        enterEmail(differentEmail);
    }

    @When("the user enters a new password in the password field")
    public void theUserEntersANewPasswordInThePasswordField() {
        String newPassword = testHarness.getData("SignUpData", "NewPassword");
        enterPassword(newPassword);
    }

    @Then("the sign-up is successful with a different email")
    public void theSignUpIsSuccessfulWithADifferentEmail() {
        verifySignUpSuccess();
    }

    @Then("email confirmation is received for the new account")
    public void emailConfirmationIsReceivedForTheNewAccount() {
        verifyEmailConfirmationReceived();
    }

    @Then("no duplicate account is created")
    public void noDuplicateAccountIsCreated() {
        verifyNoDuplicateAccount();
    }

    @Given("the user attempts to sign up with an already registered email")
    public void theUserAttemptsToSignUpWithAnAlreadyRegisteredEmail() {
        String registeredEmail = testHarness.getData("SignUpData", "RegisteredEmail");
        enterEmail(registeredEmail);
        clickProceedSignUp();
    }

    @When("the error message is displayed")
    public void theErrorMessageIsDisplayed() {
        verifyErrorMessageDisplayed();
    }

    @Then("the system logs the error event")
    public void theSystemLogsTheErrorEvent() {
        verifyErrorEventLogged();
    }

    @Then("privacy policies are adhered to")
    public void privacyPoliciesAreAdheredTo() {
        verifyPrivacyPoliciesAdherence();
    }

    @Then("terms and conditions are displayed during sign-up attempt")
    public void termsAndConditionsAreDisplayedDuringSignUpAttempt() {
        verifyTermsAndConditionsDisplayed();
    }

    @Then("support contact information is available")
    public void supportContactInformationIsAvailable() {
        verifySupportContactInformation();
    }
}