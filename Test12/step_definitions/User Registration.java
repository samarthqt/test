package com.cucumber.steps;

import com.page_objects.RegistrationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserRegistrationSteps extends RegistrationPage {

    @Given("the user is on the registration page")
    public void theUserIsOnTheRegistrationPage() {
        navigateToRegistrationPage();
    }

    @When("the user enters valid email and password")
    public void theUserEntersValidEmailAndPassword() {
        enterEmail("valid.email@example.com");
        enterPassword("ValidPassword123");
    }

    @When("the user submits the registration form")
    public void theUserSubmitsTheRegistrationForm() {
        clickRegisterButton();
    }

    @Then("the user should receive an email verification link")
    public void theUserShouldReceiveAnEmailVerificationLink() {
        verifyEmailVerificationLinkSent();
    }

    @Then("the user should be redirected to the home page upon successful verification")
    public void theUserShouldBeRedirectedToTheHomePageUponSuccessfulVerification() {
        verifyHomePageRedirection();
    }

    @When("the user chooses to register using Google")
    public void theUserChoosesToRegisterUsingGoogle() {
        clickGoogleRegisterButton();
    }

    @When("the user completes the Google authentication process")
    public void theUserCompletesTheGoogleAuthenticationProcess() {
        completeGoogleAuthentication();
    }

    @Then("the user should be redirected to the home page")
    public void theUserShouldBeRedirectedToTheHomePage() {
        verifyHomePageRedirection();
    }

    @When("the user chooses to register using Facebook")
    public void theUserChoosesToRegisterUsingFacebook() {
        clickFacebookRegisterButton();
    }

    @When("the user completes the Facebook authentication process")
    public void theUserCompletesTheFacebookAuthenticationProcess() {
        completeFacebookAuthentication();
    }

    @When("the user submits the registration form with invalid details")
    public void theUserSubmitsTheRegistrationFormWithInvalidDetails() {
        enterEmail("invalid.email");
        enterPassword("short");
        clickRegisterButton();
    }

    @Then("the user should see an error message indicating the registration failed")
    public void theUserShouldSeeAnErrorMessageIndicatingTheRegistrationFailed() {
        verifyRegistrationErrorMessage();
    }

    @Then("the user should see options to register using email, Google, and Facebook clearly")
    public void theUserShouldSeeOptionsToRegisterUsingEmailGoogleAndFacebookClearly() {
        verifyRegistrationOptionsDisplayed();
    }

    @Given("the user completes the registration process")
    public void theUserCompletesTheRegistrationProcess() {
        completeRegistrationProcess();
    }

    @Then("the system should log the registration activity for monitoring")
    public void theSystemShouldLogTheRegistrationActivityForMonitoring() {
        verifyRegistrationActivityLogged();
    }

    @Given("the user has successfully registered")
    public void theUserHasSuccessfullyRegistered() {
        verifyUserRegistrationSuccess();
    }

    @Then("the user's profile should be integrated with the user profile management system")
    public void theUsersProfileShouldBeIntegratedWithTheUserProfileManagementSystem() {
        verifyUserProfileIntegration();
    }

    @Given("the user is registering on the platform")
    public void theUserIsRegisteringOnThePlatform() {
        navigateToRegistrationPage();
    }

    @Then("the registration process should comply with data protection regulations")
    public void theRegistrationProcessShouldComplyWithDataProtectionRegulations() {
        verifyDataProtectionCompliance();
    }
}