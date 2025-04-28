package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FacebookSignInSteps extends SignInPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has an account created using Facebook sign-up")
    public void theUserHasAnAccountCreatedUsingFacebookSignUp() {
        // Setup Facebook account
    }

    @Given("the user navigates to the sign-in page")
    public void theUserNavigatesToTheSignInPage() {
        navigateToSignInPage();
    }

    @When("the user enters the email associated with the Facebook account")
    public void theUserEntersTheEmailAssociatedWithTheFacebookAccount() {
        String email = testHarness.getData("SignInData", "FacebookEmail");
        enterEmail(email);
    }

    @When("the user enters an incorrect password")
    public void theUserEntersAnIncorrectPassword() {
        String incorrectPassword = testHarness.getData("SignInData", "IncorrectPassword");
        enterPassword(incorrectPassword);
    }

    @When("the user clicks on the 'Sign In' button")
    public void theUserClicksOnTheSignInButton() {
        clickSignInButton();
    }

    @Then("an error message is displayed indicating the sign-in method is incorrect")
    public void anErrorMessageIsDisplayedIndicatingTheSignInMethodIsIncorrect() {
        String expectedErrorMessage = testHarness.getData("SignInData", "ExpectedErrorMessage");
        verifyErrorMessage(expectedErrorMessage);
    }

    @Then("the error message matches the design specifications")
    public void theErrorMessageMatchesTheDesignSpecifications() {
        verifyErrorMessageDesign();
    }

    @Then("guidance is provided for signing in with Facebook")
    public void guidanceIsProvidedForSigningInWithFacebook() {
        verifyFacebookSignInGuidance();
    }

    @When("the user attempts to reset the password using the 'Forgot Password' link")
    public void theUserAttemptsToResetThePasswordUsingTheForgotPasswordLink() {
        clickForgotPasswordLink();
    }

    @Then("the system does not allow password reset for Facebook sign-up accounts")
    public void theSystemDoesNotAllowPasswordResetForFacebookSignUpAccounts() {
        verifyNoPasswordResetForFacebook();
    }

    @Then("no critical errors are logged in the server during the sign-in attempt")
    public void noCriticalErrorsAreLoggedInTheServerDuringTheSignInAttempt() {
        verifyNoCriticalServerErrors();
    }

    @Then("the account remains accessible after failed attempts")
    public void theAccountRemainsAccessibleAfterFailedAttempts() {
        verifyAccountAccessibility();
    }

    @Then("the user interface remains consistent and the error is displayed clearly")
    public void theUserInterfaceRemainsConsistentAndTheErrorIsDisplayedClearly() {
        verifyUIConsistency();
    }

    @When("the user signs in using the correct Facebook login")
    public void theUserSignsInUsingTheCorrectFacebookLogin() {
        signInWithFacebook();
    }

    @Then("the user is successfully signed in using Facebook")
    public void theUserIsSuccessfullySignedInUsingFacebook() {
        verifySuccessfulFacebookSignIn();
    }

    @Then("the user experience is intuitive and error handling is clear")
    public void theUserExperienceIsIntuitiveAndErrorHandlingIsClear() {
        verifyUserExperience();
    }

    @When("the user attempts to sign in with email/password")
    public void theUserAttemptsToSignInWithEmailPassword() {
        attemptEmailPasswordSignIn();
    }

    @Then("findings are documented and any improvements are noted")
    public void findingsAreDocumentedAndAnyImprovementsAreNoted() {
        documentFindingsAndImprovements();
    }
}