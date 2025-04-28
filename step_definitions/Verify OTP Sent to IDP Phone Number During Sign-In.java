package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OtpVerificationSteps extends SignInPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user account exists in the system with email {string} and phone number {string}")
    public void aUserAccountExistsInTheSystem(String email, String phoneNumber) {
        // Assume user account setup is done externally
    }

    @Given("the phone number is stored in the IDP")
    public void thePhoneNumberIsStoredInTheIDP() {
        // Assume phone number is stored in IDP
    }

    @When("the user navigates to the sign-in page of the application")
    public void theUserNavigatesToTheSignInPage() {
        navigateToSignInPage();
    }

    @Then("the sign-in page is displayed")
    public void theSignInPageIsDisplayed() {
        verifySignInPageDisplayed();
    }

    @Given("the user is on the sign-in page")
    public void theUserIsOnTheSignInPage() {
        verifySignInPageDisplayed();
    }

    @When("the user enters the email {string} in the email field")
    public void theUserEntersTheEmail(String email) {
        enterEmail(email);
    }

    @Then("the email is entered correctly")
    public void theEmailIsEnteredCorrectly() {
        verifyEmailEntered();
    }

    @When("the user enters the password {string} in the password field")
    public void theUserEntersThePassword(String password) {
        enterPassword(password);
    }

    @Then("the password is entered correctly")
    public void thePasswordIsEnteredCorrectly() {
        verifyPasswordEntered();
    }

    @Given("the user has entered valid credentials")
    public void theUserHasEnteredValidCredentials() {
        // Assume credentials are valid
    }

    @When("the user clicks on the {string} button")
    public void theUserClicksOnTheButton(String buttonName) {
        clickSignInButton();
    }

    @Then("the system processes the sign-in request")
    public void theSystemProcessesTheSignInRequest() {
        verifySignInRequestProcessed();
    }

    @Then("an OTP is sent to the phone number {string}")
    public void anOtpIsSentToThePhoneNumber(String phoneNumber) {
        verifyOtpSent(phoneNumber);
    }

    @Given("an OTP is sent to the phone number")
    public void anOtpIsSentToThePhoneNumber() {
        // Assume OTP is sent
    }

    @When("the user verifies the OTP received on the phone")
    public void theUserVerifiesTheOtpReceivedOnThePhone() {
        verifyOtpReceived();
    }

    @Then("the OTP matches the one sent by the system")
    public void theOtpMatchesTheOneSentByTheSystem() {
        verifyOtpMatches();
    }

    @When("the user enters the OTP in the OTP verification field on the application")
    public void theUserEntersTheOtpInTheOtpVerificationField() {
        enterOtp();
    }

    @Then("the OTP is entered correctly")
    public void theOtpIsEnteredCorrectly() {
        verifyOtpEntered();
    }

    @When("the user submits the OTP for verification")
    public void theUserSubmitsTheOtpForVerification() {
        submitOtp();
    }

    @Then("the system verifies the OTP")
    public void theSystemVerifiesTheOtp() {
        verifyOtpVerification();
    }

    @Then("the user is redirected to the homepage upon successful OTP verification")
    public void theUserIsRedirectedToTheHomepage() {
        verifyRedirectionToHomepage();
    }

    @Given("the user is on the homepage")
    public void theUserIsOnTheHomepage() {
        verifyUserOnHomepage();
    }

    @When("the user logs out from the application")
    public void theUserLogsOutFromTheApplication() {
        logout();
    }

    @Then("the user is logged out successfully")
    public void theUserIsLoggedOutSuccessfully() {
        verifyLogoutSuccess();
    }

    @When("the user repeats the sign-in process")
    public void theUserRepeatsTheSignInProcess() {
        repeatSignInProcess();
    }

    @Then("OTP is consistently sent to the phone number stored in IDP")
    public void otpIsConsistentlySentToThePhoneNumberStoredInIDP() {
        verifyOtpConsistency();
    }

    @Given("the user is checking the SMS logs")
    public void theUserIsCheckingTheSmsLogs() {
        checkSmsLogs();
    }

    @When("the user verifies the OTP dispatch")
    public void theUserVerifiesTheOtpDispatch() {
        verifyOtpDispatch();
    }

    @Then("SMS logs show OTP dispatch to {string}")
    public void smsLogsShowOtpDispatchTo(String phoneNumber) {
        verifySmsLogs(phoneNumber);
    }

    @Then("no duplicate OTPs are sent for a single sign-in attempt")
    public void noDuplicateOtpsAreSentForASingleSignInAttempt() {
        verifyNoDuplicateOtps();
    }

    @Then("the OTP is valid for a specific period \(e.g., 5 minutes\)")
    public void theOtpIsValidForASpecificPeriod() {
        verifyOtpValidityPeriod();
    }

    @Given("an OTP is expired")
    public void anOtpIsExpired() {
        expireOtp();
    }

    @When("the user attempts to use the expired OTP for sign-in")
    public void theUserAttemptsToUseTheExpiredOtpForSignIn() {
        attemptSignInWithExpiredOtp();
    }

    @Then("the system rejects the expired OTP")
    public void theSystemRejectsTheExpiredOtp() {
        verifyExpiredOtpRejection();
    }
}