package com.cucumber.steps;

import com.page_objects.RegistrationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationSteps extends RegistrationPage {

    @Given("I navigate to the registration page")
    public void navigateToRegistrationPage() {
        openRegistrationPage();
    }

    @When("I enter email {string} and password {string} in the registration form")
    public void enterEmailAndPassword(String email, String password) {
        enterEmail(email);
        enterPassword(password);
    }

    @When("I submit the registration form")
    public void submitRegistrationForm() {
        clickSubmitButton();
    }

    @Then("the user is registered successfully and redirected to the home page")
    public void verifyRegistrationAndRedirection() {
        verifyHomePageRedirection();
    }

    @Given("I am logged in")
    public void verifyLoggedIn() {
        checkUserLoggedIn();
    }

    @When("I log out")
    public void logOut() {
        performLogout();
    }

    @Then("the registration page is displayed again")
    public void verifyRegistrationPageDisplayed() {
        verifyRegistrationPage();
    }

    @When("I select {string}")
    public void selectRegistrationMethod(String method) {
        selectRegistrationOption(method);
    }

    @When("I enter Google account credentials and submit")
    public void enterGoogleCredentialsAndSubmit() {
        enterGoogleCredentials();
        submitGoogleRegistration();
    }

    @Given("I am logged in with Google account")
    public void verifyLoggedInWithGoogle() {
        checkGoogleAccountLoggedIn();
    }

    @When("I enter Facebook account credentials and submit")
    public void enterFacebookCredentialsAndSubmit() {
        enterFacebookCredentials();
        submitFacebookRegistration();
    }

    @Given("I have registered with email {string}")
    public void verifyEmailRegistration(String email) {
        checkEmailRegistration(email);
    }

    @When("I log in with email {string} and password {string}")
    public void loginWithEmail(String email, String password) {
        performEmailLogin(email, password);
    }

    @Given("I have registered with Google account")
    public void verifyGoogleRegistration() {
        checkGoogleRegistration();
    }

    @When("I log in with Google credentials")
    public void loginWithGoogle() {
        performGoogleLogin();
    }

    @Given("I have registered with Facebook account")
    public void verifyFacebookRegistration() {
        checkFacebookRegistration();
    }

    @When("I log in with Facebook credentials")
    public void loginWithFacebook() {
        performFacebookLogin();
    }

    @Given("registration has occurred")
    public void verifyRegistrationOccurred() {
        checkRegistrationOccurred();
    }

    @When("I check the system logs")
    public void checkSystemLogs() {
        verifySystemLogs();
    }

    @Then("no errors should be present in the logs")
    public void verifyNoErrorsInLogs() {
        assertNoErrorsInLogs();
    }

    @Given("I am registering a user")
    public void startUserRegistration() {
        initiateUserRegistration();
    }

    @When("I complete the registration process")
    public void completeRegistrationProcess() {
        finalizeRegistrationProcess();
    }

    @Then("user receives clear feedback messages about registration status")
    public void verifyFeedbackMessages() {
        assertFeedbackMessages();
    }

    @When("I perform regular system operations")
    public void performSystemOperations() {
        executeSystemOperations();
    }

    @Then("the system should be stable and responsive")
    public void verifySystemStability() {
        assertSystemStability();
    }
}