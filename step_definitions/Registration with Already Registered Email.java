package com.cucumber.steps;

import com.page_objects.RegistrationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationSteps extends RegistrationPage {

    @Given("I am on the registration page")
    public void iAmOnTheRegistrationPage() {
        navigateToRegistrationPage();
    }

    @When("I enter email {string} and password {string} in the registration form")
    public void iEnterEmailAndPasswordInTheRegistrationForm(String email, String password) {
        enterEmail(email);
        enterPassword(password);
    }

    @When("I submit the registration form")
    public void iSubmitTheRegistrationForm() {
        clickRegisterButton();
    }

    @Then("I should see an error message indicating the email is already registered")
    public void iShouldSeeAnErrorMessageIndicatingTheEmailIsAlreadyRegistered() {
        verifyErrorMessage("Email is already registered.");
    }

    @Then("the error logs should contain messages about the already registered email")
    public void theErrorLogsShouldContainMessagesAboutTheAlreadyRegisteredEmail() {
        verifyErrorLogsContain("already registered email");
    }

    @Then("I should not be able to proceed with registration using the same email")
    public void iShouldNotBeAbleToProceedWithRegistrationUsingTheSameEmail() {
        verifyRegistrationNotProceeded();
    }

    @Then("I should be registered successfully with a new email")
    public void iShouldBeRegisteredSuccessfullyWithANewEmail() {
        verifyRegistrationSuccess("Registration successful.");
    }

    @When("I attempt registration with multiple registered emails")
    public void iAttemptRegistrationWithMultipleRegisteredEmails() {
        attemptMultipleRegistrations();
    }

    @Then("the system should handle multiple errors gracefully and display appropriate messages")
    public void theSystemShouldHandleMultipleErrorsGracefullyAndDisplayAppropriateMessages() {
        verifyMultipleErrorsHandledGracefully();
    }

    @Then("the system should return to a stable state after handling errors")
    public void theSystemShouldReturnToAStableStateAfterHandlingErrors() {
        verifySystemStableState();
    }

    @Then("I should receive clear and informative feedback about the registration error")
    public void iShouldReceiveClearAndInformativeFeedbackAboutTheRegistrationError() {
        verifyClearFeedbackForErrors();
    }

    @Then("there should be no unhandled exceptions present")
    public void thereShouldBeNoUnhandledExceptionsPresent() {
        verifyNoUnhandledExceptions();
    }

    @Then("the system logs should not contain critical errors")
    public void theSystemLogsShouldNotContainCriticalErrors() {
        verifyNoCriticalErrorsInLogs();
    }

    @Then("I should receive information about alternative registration methods")
    public void iShouldReceiveInformationAboutAlternativeRegistrationMethods() {
        verifyAlternativeRegistrationInfo();
    }

    @Then("the system should scale resources appropriately to handle multiple attempts")
    public void theSystemShouldScaleResourcesAppropriatelyToHandleMultipleAttempts() {
        verifySystemScalability();
    }

    @Then("the system should remain stable and responsive")
    public void theSystemShouldRemainStableAndResponsive() {
        verifySystemStability();
    }
}