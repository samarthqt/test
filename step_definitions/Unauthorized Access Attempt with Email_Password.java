package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UnauthorizedAccessSteps extends SignInPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has access to the sign-in page")
    public void theUserHasAccessToTheSignInPage() {
        navigateToSignInPage();
    }

    @When("the user navigates to the sign-in page")
    public void theUserNavigatesToTheSignInPage() {
        verifySignInPageDisplayed();
    }

    @Then("the sign-in page is displayed")
    public void theSignInPageIsDisplayed() {
        verifySignInPageDisplayed();
    }

    @Given("the user is on the sign-in page")
    public void theUserIsOnTheSignInPage() {
        navigateToSignInPage();
    }

    @When("the user enters {string} in the email field")
    public void theUserEntersInTheEmailField(String email) {
        enterEmail(email);
    }

    @When("the user enters {string} in the password field")
    public void theUserEntersInThePasswordField(String password) {
        enterPassword(password);
    }

    @When("the user clicks on the {string} button")
    public void theUserClicksOnTheButton(String buttonName) {
        if (buttonName.equals("Sign In")) {
            clickSignInButton();
        }
    }

    @Then("the system processes the request")
    public void theSystemProcessesTheRequest() {
        verifyRequestProcessing();
    }

    @Then("an error message indicating unauthorized access is displayed")
    public void anErrorMessageIndicatingUnauthorizedAccessIsDisplayed() {
        verifyUnauthorizedAccessErrorMessage();
    }

    @Then("the error message is clear, concise, and meets security standards")
    public void theErrorMessageIsClearConciseAndMeetsSecurityStandards() {
        verifyErrorMessageStandards();
    }

    @Given("the user has made multiple failed attempts")
    public void theUserHasMadeMultipleFailedAttempts() {
        simulateMultipleFailedAttempts();
    }

    @When("the user tries to sign in again")
    public void theUserTriesToSignInAgain() {
        attemptSignInAgain();
    }

    @Then("the account is temporarily locked")
    public void theAccountIsTemporarilyLocked() {
        verifyAccountLock();
    }

    @Given("an error message is displayed")
    public void anErrorMessageIsDisplayed() {
        verifyErrorMessageDisplayed();
    }

    @When("the user tries to click the sign-in button")
    public void theUserTriesToClickTheSignInButton() {
        attemptClickSignInButton();
    }

    @Then("the sign-in button is disabled")
    public void theSignInButtonIsDisabled() {
        verifySignInButtonDisabled();
    }

    @Then("the error message is logged in the system for auditing")
    public void theErrorMessageIsLoggedInTheSystemForAuditing() {
        verifyErrorMessageLogging();
    }

    @When("the user attempts to reset the password for the unauthorized account")
    public void theUserAttemptsToResetThePasswordForTheUnauthorizedAccount() {
        attemptPasswordReset();
    }

    @Then("the system prompts for security verification before allowing password reset")
    public void theSystemPromptsForSecurityVerificationBeforeAllowingPasswordReset() {
        verifySecurityVerificationPrompt();
    }

    @Given("the account is unlocked")
    public void theAccountIsUnlocked() {
        unlockAccount();
    }

    @When("the user returns to the sign-in page")
    public void theUserReturnsToTheSignInPage() {
        navigateToSignInPage();
    }

    @Then("the error message disappears")
    public void theErrorMessageDisappears() {
        verifyErrorMessageDisappearance();
    }

    @Then("the email field retains the entered email")
    public void theEmailFieldRetainsTheEnteredEmail() {
        verifyEmailFieldRetention();
    }

    @When("the user enters another unauthorized email")
    public void theUserEntersAnotherUnauthorizedEmail() {
        enterAnotherUnauthorizedEmail();
    }

    @Then("a similar error message is displayed")
    public void aSimilarErrorMessageIsDisplayed() {
        verifySimilarErrorMessage();
    }

    @When("the user switches to another page and returns to the sign-in page")
    public void theUserSwitchesToAnotherPageAndReturnsToTheSignInPage() {
        switchPagesAndReturn();
    }

    @Then("the error message remains consistent")
    public void theErrorMessageRemainsConsistent() {
        verifyErrorMessageConsistency();
    }

    @When("the user encounters an error message")
    public void theUserEncountersAnErrorMessage() {
        verifyErrorMessageEncounter();
    }

    @Then("the system provides guidance for authorized access")
    public void theSystemProvidesGuidanceForAuthorizedAccess() {
        verifyGuidanceForAuthorizedAccess();
    }
}