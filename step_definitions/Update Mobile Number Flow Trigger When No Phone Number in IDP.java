package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UpdateMobileNumberSteps extends UpdateMobileNumberPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user account exists in the system")
    public void theUserAccountExistsInTheSystem() {
        // Implementation to verify user account exists
    }

    @Given("no phone number is stored in the IDP")
    public void noPhoneNumberIsStoredInTheIDP() {
        // Implementation to verify no phone number in IDP
    }

    @When("the user navigates to the sign-in page of the application")
    public void theUserNavigatesToTheSignInPageOfTheApplication() {
        navigateToSignInPage();
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

    @When("the user enters the password {string} in the password field")
    public void theUserEntersThePasswordInThePasswordField(String password) {
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

    @When("the system checks for the presence of a phone number in IDP")
    public void theSystemChecksForThePresenceOfAPhoneNumberInIDP() {
        checkPhoneNumberInIDP();
    }

    @Then("the system detects no phone number in IDP")
    public void theSystemDetectsNoPhoneNumberInIDP() {
        verifyNoPhoneNumberDetectedInIDP();
    }

    @When("the system triggers the 'Update Mobile Number' flow")
    public void theSystemTriggersTheUpdateMobileNumberFlow() {
        triggerUpdateMobileNumberFlow();
    }

    @Then("the 'Update Mobile Number' flow is initiated")
    public void theUpdateMobileNumberFlowIsInitiated() {
        verifyUpdateMobileNumberFlowInitiated();
    }

    @When("the user enters a new phone number in the 'Update Mobile Number' screen")
    public void theUserEntersANewPhoneNumberInTheUpdateMobileNumberScreen() {
        enterNewPhoneNumber();
    }

    @Then("the new phone number is entered correctly")
    public void theNewPhoneNumberIsEnteredCorrectly() {
        verifyNewPhoneNumberEnteredCorrectly();
    }

    @When("the user submits the new phone number for verification")
    public void theUserSubmitsTheNewPhoneNumberForVerification() {
        submitNewPhoneNumberForVerification();
    }

    @Then("the system processes the new phone number")
    public void theSystemProcessesTheNewPhoneNumber() {
        verifyNewPhoneNumberProcessed();
    }

    @When("the system sends an OTP to the new phone number")
    public void theSystemSendsAnOTPToTheNewPhoneNumber() {
        sendOTPToNewPhoneNumber();
    }

    @Then("an OTP is sent to the new phone number")
    public void anOTPIsSentToTheNewPhoneNumber() {
        verifyOTPSentToNewPhoneNumber();
    }

    @When("the user verifies the OTP received on the new phone number")
    public void theUserVerifiesTheOTPReceivedOnTheNewPhoneNumber() {
        verifyOTPReceived();
    }

    @Then("the OTP matches the one sent by the system")
    public void theOTPMatchesTheOneSentByTheSystem() {
        verifyOTPMatches();
    }

    @When("the user enters the OTP in the OTP verification field on the application")
    public void theUserEntersTheOTPInTheOTPVerificationFieldOnTheApplication() {
        enterOTPInVerificationField();
    }

    @Then("the OTP is entered correctly")
    public void theOTPIsEnteredCorrectly() {
        verifyOTPEnteredCorrectly();
    }

    @When("the user submits the OTP for verification")
    public void theUserSubmitsTheOTPForVerification() {
        submitOTPForVerification();
    }

    @Then("the system verifies the OTP")
    public void theSystemVerifiesTheOTP() {
        verifyOTPVerification();
    }

    @When("the OTP verification is successful")
    public void theOTPVerificationIsSuccessful() {
        verifyOTPVerificationSuccessful();
    }

    @Then("the user is redirected to the homepage")
    public void theUserIsRedirectedToTheHomepage() {
        verifyUserRedirectedToHomepage();
    }

    @When("the user logs out from the application")
    public void theUserLogsOutFromTheApplication() {
        logoutFromApplication();
    }

    @Then("the user is logged out successfully")
    public void theUserIsLoggedOutSuccessfully() {
        verifyUserLoggedOutSuccessfully();
    }

    @When("the user repeats the sign-in process")
    public void theUserRepeatsTheSignInProcess() {
        repeatSignInProcess();
    }

    @Then("the updated phone number is used for OTP dispatch")
    public void theUpdatedPhoneNumberIsUsedForOTPDispatch() {
        verifyUpdatedPhoneNumberUsedForOTPDispatch();
    }
}