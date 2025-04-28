package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignInSteps extends SignInPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user account exists in the system")
    public void theUserAccountExistsInTheSystem() {
        // Code to verify user account existence
    }

    @Given("the phone number is stored in IDP")
    public void thePhoneNumberIsStoredInIDP() {
        // Code to verify phone number in IDP
    }

    @When("the user navigates to the sign-in page of the application")
    public void theUserNavigatesToTheSignInPageOfTheApplication() {
        navigateToSignInPage();
    }

    @Then("the sign-in page is displayed")
    public void theSignInPageIsDisplayed() {
        verifySignInPageDisplayed();
    }

    @When("the user enters the email \"user@example.com\" in the email field")
    public void theUserEntersTheEmailInTheEmailField() {
        enterEmail("user@example.com");
    }

    @Then("the email is entered correctly")
    public void theEmailIsEnteredCorrectly() {
        verifyEmailEntered("user@example.com");
    }

    @When("the user enters the password \"Password123\" in the password field")
    public void theUserEntersThePasswordInThePasswordField() {
        enterPassword("Password123");
    }

    @Then("the password is entered correctly")
    public void thePasswordIsEnteredCorrectly() {
        verifyPasswordEntered("Password123");
    }

    @When("the user clicks on the \"Sign In\" button")
    public void theUserClicksOnTheSignInButton() {
        clickSignInButton();
    }

    @Then("the system processes the sign-in request")
    public void theSystemProcessesTheSignInRequest() {
        verifySignInRequestProcessed();
    }

    @When("the OTP is sent to the phone number stored in IDP")
    public void theOTPSentToPhoneNumberStoredInIDP() {
        verifyOTPSentToPhoneNumber();
    }

    @Then("an OTP is sent to the phone number \"+1234567890\"")
    public void anOTPSentToPhoneNumber() {
        verifyOTPSentToSpecificNumber("+1234567890");
    }

    @When("the user verifies the OTP received on the phone")
    public void theUserVerifiesTheOTPReceivedOnThePhone() {
        verifyOTPReceived();
    }

    @Then("the OTP matches the one sent by the system")
    public void theOTPMatchesTheOneSentByTheSystem() {
        verifyOTPMatches();
    }

    @When("the user enters the OTP in the OTP verification field on the application")
    public void theUserEntersTheOTPInTheOTPVerificationFieldOnTheApplication() {
        enterOTP();
    }

    @Then("the OTP is entered correctly")
    public void theOTPIsEnteredCorrectly() {
        verifyOTPEntered();
    }

    @When("the user submits the OTP for verification")
    public void theUserSubmitsTheOTPForVerification() {
        submitOTP();
    }

    @Then("the system verifies the OTP")
    public void theSystemVerifiesTheOTP() {
        verifyOTPVerification();
    }

    @When("the OTP is successfully verified")
    public void theOTPSuccessfullyVerified() {
        verifyOTPSuccessfullyVerified();
    }

    @Then("the user is redirected to the homepage")
    public void theUserIsRedirectedToTheHomepage() {
        verifyUserRedirectedToHomepage();
    }

    @When("the user logs out from the application")
    public void theUserLogsOutFromTheApplication() {
        logout();
    }

    @Then("the user is logged out successfully")
    public void theUserIsLoggedOutSuccessfully() {
        verifyUserLoggedOut();
    }

    @Given("the sign-in process is repeated")
    public void theSignInProcessIsRepeated() {
        repeatSignInProcess();
    }

    @Then("OTP is consistently sent to the phone number stored in IDP")
    public void otpIsConsistentlySentToPhoneNumberStoredInIDP() {
        verifyOTPSentConsistently();
    }

    @When("checking the SMS logs")
    public void checkingTheSMSLogs() {
        checkSMSLogs();
    }

    @Then("SMS logs show OTP dispatch to \"+1234567890\"")
    public void smsLogsShowOTPDispatchTo() {
        verifySMSLogsForOTPDispatch("+1234567890");
    }

    @When("a single sign-in attempt is made")
    public void aSingleSignInAttemptIsMade() {
        makeSingleSignInAttempt();
    }

    @Then("only one OTP is sent per sign-in attempt")
    public void onlyOneOTPSentPerSignInAttempt() {
        verifySingleOTPSent();
    }

    @When("checking if the OTP is valid for a specific period \(e.g., 5 minutes\)")
    public void checkingIfTheOTPIsValidForASpecificPeriod() {
        checkOTPValidityPeriod();
    }

    @Then("the OTP is valid for the specified period")
    public void theOTPIsValidForTheSpecifiedPeriod() {
        verifyOTPValidity();
    }

    @When("an expired OTP is used for sign-in")
    public void anExpiredOTPIsUsedForSignIn() {
        useExpiredOTP();
    }

    @Then("the system rejects the expired OTP")
    public void theSystemRejectsTheExpiredOTP() {
        verifyExpiredOTPRejected();
    }
}