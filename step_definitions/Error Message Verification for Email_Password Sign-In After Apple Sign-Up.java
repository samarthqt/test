package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ErrorMessageVerificationSteps extends SignInPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user account created using Apple sign-up")
    public void aUserAccountCreatedUsingAppleSignUp() {
        // Code to ensure user account is created using Apple sign-up
    }

    @Given("access to the sign-in page")
    public void accessToTheSignInPage() {
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

    @When("the user enters the email associated with the Apple account")
    public void theUserEntersTheEmailAssociatedWithTheAppleAccount() {
        String email = testHarness.getData("SignInData", "AppleEmail");
        enterEmail(email);
    }

    @When("the user enters an incorrect password")
    public void theUserEntersAnIncorrectPassword() {
        String incorrectPassword = testHarness.getData("SignInData", "IncorrectPassword");
        enterPassword(incorrectPassword);
    }

    @When("clicks on the 'Sign In' button")
    public void clicksOnTheSignInButton() {
        clickSignInButton();
    }

    @Then("an error message is displayed indicating the sign-in method is incorrect")
    public void anErrorMessageIsDisplayedIndicatingTheSignInMethodIsIncorrect() {
        verifyErrorMessageDisplayed();
    }

    @Then("the error message matches the design specifications")
    public void theErrorMessageMatchesTheDesignSpecifications() {
        verifyErrorMessageMatchesDesign();
    }

    @Then("additional guidance is provided for signing in with Apple")
    public void additionalGuidanceIsProvidedForSigningInWithApple() {
        verifyGuidanceForAppleSignIn();
    }

    @When("the user attempts to reset the password using the 'Forgot Password' link")
    public void theUserAttemptsToResetThePasswordUsingTheForgotPasswordLink() {
        initiatePasswordReset();
    }

    @Then("the password reset process is initiated")
    public void thePasswordResetProcessIsInitiated() {
        verifyPasswordResetInitiated();
    }

    @When("verifying if the system allows password reset for Apple sign-up accounts")
    public void verifyingIfTheSystemAllowsPasswordResetForAppleSignUpAccounts() {
        checkPasswordResetForAppleSignUp();
    }

    @Then("the system does not allow password reset for Apple sign-up accounts")
    public void theSystemDoesNotAllowPasswordResetForAppleSignUpAccounts() {
        verifyNoPasswordResetForAppleSignUp();
    }

    @When("checking server logs for any errors during the sign-in attempt")
    public void checkingServerLogsForAnyErrorsDuringTheSignInAttempt() {
        checkServerLogsForErrors();
    }

    @Then("no critical errors are logged in the server during sign-in attempt")
    public void noCriticalErrorsAreLoggedInTheServerDuringSignInAttempt() {
        verifyNoCriticalErrorsInLogs();
    }

    @When("ensuring the account is not locked after multiple failed attempts")
    public void ensuringTheAccountIsNotLockedAfterMultipleFailedAttempts() {
        checkAccountLockStatus();
    }

    @Then("the account remains accessible after failed attempts")
    public void theAccountRemainsAccessibleAfterFailedAttempts() {
        verifyAccountAccessibility();
    }

    @When("reviewing the user interface for any inconsistencies during the error display")
    public void reviewingTheUserInterfaceForAnyInconsistenciesDuringTheErrorDisplay() {
        reviewUIConsistency();
    }

    @Then("the user interface remains consistent and the error is displayed clearly")
    public void theUserInterfaceRemainsConsistentAndTheErrorIsDisplayedClearly() {
        verifyUIConsistencyAndErrorDisplay();
    }

    @When("testing the sign-in process with a correct Apple login")
    public void testingTheSignInProcessWithACorrectAppleLogin() {
        signInWithCorrectAppleLogin();
    }

    @Then("the user is successfully signed in using Apple")
    public void theUserIsSuccessfullySignedInUsingApple() {
        verifySuccessfulAppleSignIn();
    }

    @When("evaluating the user experience during the sign-in attempt")
    public void evaluatingTheUserExperienceDuringTheSignInAttempt() {
        evaluateUserExperience();
    }

    @Then("the user experience is intuitive and error handling is clear")
    public void theUserExperienceIsIntuitiveAndErrorHandlingIsClear() {
        verifyUserExperienceAndErrorHandling();
    }

    @When("documenting findings and suggesting improvements if needed")
    public void documentingFindingsAndSuggestingImprovementsIfNeeded() {
        documentFindingsAndSuggestions();
    }

    @Then("findings are documented and any improvements are noted")
    public void findingsAreDocumentedAndAnyImprovementsAreNoted() {
        verifyDocumentationAndImprovements();
    }
}