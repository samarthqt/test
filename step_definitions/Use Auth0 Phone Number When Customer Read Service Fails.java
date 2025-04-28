package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Auth0PhoneNumberSteps extends Auth0PhoneNumberPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user account exists in the system")
    public void aUserAccountExistsInTheSystem() {
        // Code to verify user account existence
    }

    @Given("the phone number is stored in Auth0")
    public void thePhoneNumberIsStoredInAuth0() {
        // Code to verify phone number in Auth0
    }

    @When("the user navigates to the sign-in page of the application")
    public void theUserNavigatesToTheSignInPageOfTheApplication() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    @Then("the sign-in page is displayed")
    public void theSignInPageIsDisplayed() {
        verifySignInPageDisplayed();
    }

    @When("the user enters the email {string} in the email field")
    public void theUserEntersTheEmailInTheEmailField(String email) {
        enterEmail(email);
    }

    @Then("the email is entered correctly")
    public void theEmailIsEnteredCorrectly() {
        verifyEmailEnteredCorrectly();
    }

    @When("the user simulates an error in Customer Read service")
    public void theUserSimulatesAnErrorInCustomerReadService() {
        simulateCustomerReadServiceError();
    }

    @When("enters the password {string} in the password field")
    public void entersThePasswordInThePasswordField(String password) {
        enterPassword(password);
    }

    @Then("the password is entered correctly")
    public void thePasswordIsEnteredCorrectly() {
        verifyPasswordEnteredCorrectly();
    }

    @When("the user clicks on the 'Sign In' button")
    public void theUserClicksOnTheSignInButton() {
        clickSignInButton();
    }

    @Then("the system processes the sign-in request")
    public void theSystemProcessesTheSignInRequest() {
        verifySignInRequestProcessed();
    }

    @When("an error in the Customer Read service is simulated")
    public void anErrorInTheCustomerReadServiceIsSimulated() {
        simulateCustomerReadServiceError();
    }

    @Then("the system falls back to using the Auth0 phone number")
    public void theSystemFallsBackToUsingTheAuth0PhoneNumber() {
        verifyFallbackToAuth0PhoneNumber();
    }

    @Then("an OTP is sent to the phone number +1234567890")
    public void anOtpIsSentToThePhoneNumber() {
        verifyOtpSentToPhoneNumber("+1234567890");
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
    public void theUserEntersTheOtpInTheOtpVerificationFieldOnTheApplication() {
        enterOtpInVerificationField();
    }

    @Then("the OTP is entered correctly")
    public void theOtpIsEnteredCorrectly() {
        verifyOtpEnteredCorrectly();
    }

    @When("the user submits the OTP for verification")
    public void theUserSubmitsTheOtpForVerification() {
        submitOtpForVerification();
    }

    @Then("the system verifies the OTP")
    public void theSystemVerifiesTheOtp() {
        verifyOtpVerification();
    }

    @Then("the user is redirected to the homepage upon successful OTP verification")
    public void theUserIsRedirectedToTheHomepageUponSuccessfulOtpVerification() {
        verifyRedirectionToHomepage();
    }

    @When("the user logs out from the application")
    public void theUserLogsOutFromTheApplication() {
        logoutFromApplication();
    }

    @Then("the user is logged out successfully")
    public void theUserIsLoggedOutSuccessfully() {
        verifyLogoutSuccessful();
    }

    @When("the user repeats the sign-in process")
    public void theUserRepeatsTheSignInProcess() {
        repeatSignInProcess();
    }

    @Then("Auth0 phone number is consistently used when Customer Read service fails")
    public void auth0PhoneNumberIsConsistentlyUsedWhenCustomerReadServiceFails() {
        verifyConsistentUseOfAuth0PhoneNumber();
    }

    @When("the user checks the SMS logs")
    public void theUserChecksTheSmsLogs() {
        checkSmsLogs();
    }

    @Then("SMS logs show OTP dispatch to +1234567890")
    public void smsLogsShowOtpDispatchToPhoneNumber() {
        verifySmsLogsForOtpDispatch("+1234567890");
    }

    @When("the user verifies that no duplicate OTPs are sent for a single sign-in attempt")
    public void theUserVerifiesThatNoDuplicateOtpsAreSentForASingleSignInAttempt() {
        verifyNoDuplicateOtpsSent();
    }

    @Then("only one OTP is sent per sign-in attempt")
    public void onlyOneOtpIsSentPerSignInAttempt() {
        verifySingleOtpSentPerSignInAttempt();
    }
}