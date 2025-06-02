package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.PasswordRecoveryPage;

public class PasswordRecoverySteps extends PasswordRecoveryPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user account with a registered email \"user@example.com\"")
    public void aUserAccountWithARegisteredEmail() {
        // Assume the user account is already registered
    }

    @When("the user navigates to the login page")
    public void theUserNavigatesToTheLoginPage() {
        navigateToLoginPage();
    }

    @Then("the login page is displayed")
    public void theLoginPageIsDisplayed() {
        verifyLoginPageDisplayed();
    }

    @When("the user clicks on the \"Forgot Password\" link")
    public void theUserClicksOnTheForgotPasswordLink() {
        clickForgotPasswordLink();
    }

    @Then("the \"Forgot Password\" page is displayed")
    public void theForgotPasswordPageIsDisplayed() {
        verifyForgotPasswordPageDisplayed();
    }

    @When("the user enters the registered email address \"user@example.com\"")
    public void theUserEntersTheRegisteredEmailAddress() {
        enterRegisteredEmail("user@example.com");
    }

    @Then("the email address is accepted")
    public void theEmailAddressIsAccepted() {
        verifyEmailAccepted();
    }

    @When("the user submits the password recovery request")
    public void theUserSubmitsThePasswordRecoveryRequest() {
        submitPasswordRecoveryRequest();
    }

    @Then("a confirmation message for password recovery is displayed")
    public void aConfirmationMessageForPasswordRecoveryIsDisplayed() {
        verifyPasswordRecoveryConfirmationMessage();
    }

    @When("the user checks the registered email inbox for the recovery email")
    public void theUserChecksTheRegisteredEmailInboxForTheRecoveryEmail() {
        checkEmailInboxForRecoveryEmail();
    }

    @Then("the password recovery email is received")
    public void thePasswordRecoveryEmailIsReceived() {
        verifyRecoveryEmailReceived();
    }

    @When("the user opens the password recovery email")
    public void theUserOpensThePasswordRecoveryEmail() {
        openRecoveryEmail();
    }

    @Then("the email content is displayed")
    public void theEmailContentIsDisplayed() {
        verifyEmailContentDisplayed();
    }

    @When("the user verifies the presence of a secure link in the email")
    public void theUserVerifiesThePresenceOfASecureLinkInTheEmail() {
        verifySecureLinkInEmail();
    }

    @Then("a secure link is present in the email")
    public void aSecureLinkIsPresentInTheEmail() {
        verifySecureLinkPresence();
    }

    @When("the user clicks on the secure link")
    public void theUserClicksOnTheSecureLink() {
        clickSecureLink();
    }

    @Then("the link redirects to the password reset page")
    public void theLinkRedirectsToThePasswordResetPage() {
        verifyPasswordResetPageRedirection();
    }

    @When("the user ensures the password reset page is secure \(HTTPS\)")
    public void theUserEnsuresThePasswordResetPageIsSecureHTTPS() {
        verifyPasswordResetPageIsSecure();
    }

    @Then("the password reset page is secured with HTTPS")
    public void thePasswordResetPageIsSecuredWithHTTPS() {
        verifyPageIsSecuredWithHTTPS();
    }

    @When("the user logs out of any active sessions")
    public void theUserLogsOutOfAnyActiveSessions() {
        logoutActiveSessions();
    }

    @Then("the user is logged out successfully")
    public void theUserIsLoggedOutSuccessfully() {
        verifyUserLoggedOut();
    }
}