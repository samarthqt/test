package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CodeVerificationSteps extends VerificationPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has received a valid 6-digit code via SMS")
    public void theUserHasReceivedAValid6DigitCodeViaSMS() {
        // Simulate receiving a valid code
    }

    @When("the user navigates to the login page")
    public void theUserNavigatesToTheLoginPage() {
        navigateToLoginPage();
    }

    @Then("the login page is displayed")
    public void theLoginPageIsDisplayed() {
        verifyLoginPageDisplayed();
    }

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        navigateToLoginPage();
    }

    @When("the user enters email {string} in the email field")
    public void theUserEntersEmailInTheEmailField(String email) {
        enterEmail(email);
    }

    @Then("the email is entered correctly")
    public void theEmailIsEnteredCorrectly() {
        verifyEmailEnteredCorrectly();
    }

    @When("the user enters password {string} in the password field")
    public void theUserEntersPasswordInThePasswordField(String password) {
        enterPassword(password);
    }

    @Then("the password is entered correctly")
    public void thePasswordIsEnteredCorrectly() {
        verifyPasswordEnteredCorrectly();
    }

    @Given("the user has entered correct email and password")
    public void theUserHasEnteredCorrectEmailAndPassword() {
        enterEmail(testHarness.getData("LoginData", "Email"));
        enterPassword(testHarness.getData("LoginData", "Password"));
    }

    @When("the user clicks on the {string} button")
    public void theUserClicksOnTheButton(String buttonName) {
        if (buttonName.equals("Login")) {
            clickLoginButton();
        } else if (buttonName.equals("Verify")) {
            clickVerifyButton();
        }
    }

    @Then("the user is authenticated and redirected to the verification page")
    public void theUserIsAuthenticatedAndRedirectedToTheVerificationPage() {
        verifyRedirectionToVerificationPage();
    }

    @When("the user enters incorrect 6-digit code {string} in the verification field")
    public void theUserEntersIncorrect6DigitCodeInTheVerificationField(String code) {
        enterVerificationCode(code);
    }

    @Then("the incorrect code is entered")
    public void theIncorrectCodeIsEntered() {
        verifyIncorrectCodeEntered();
    }

    @Then("an error message is displayed indicating incorrect code entry")
    public void anErrorMessageIsDisplayedIndicatingIncorrectCodeEntry() {
        verifyErrorMessageDisplayed();
    }

    @Given("the user has entered an incorrect code")
    public void theUserHasEnteredAnIncorrectCode() {
        enterVerificationCode("123456");
    }

    @When("the user checks for any additional guidance or options provided")
    public void theUserChecksForAnyAdditionalGuidanceOrOptionsProvided() {
        checkForGuidanceOrOptions();
    }

    @Then("the system provides guidance or options for code re-entry")
    public void theSystemProvidesGuidanceOrOptionsForCodeReEntry() {
        verifyGuidanceOrOptionsProvided();
    }

    @When("the user attempts to enter the correct code received via SMS")
    public void theUserAttemptsToEnterTheCorrectCodeReceivedViaSMS() {
        enterVerificationCode(testHarness.getData("VerificationData", "CorrectCode"));
    }

    @Then("verification is successful with the correct code")
    public void verificationIsSuccessfulWithTheCorrectCode() {
        verifySuccessfulVerification();
    }

    @Given("the user repeatedly enters incorrect codes")
    public void theUserRepeatedlyEntersIncorrectCodes() {
        enterVerificationCode("111111");
        enterVerificationCode("222222");
    }

    @When("the user verifies the system's response to repeated incorrect code entries")
    public void theUserVerifiesTheSystemResponseToRepeatedIncorrectCodeEntries() {
        verifySystemResponseToRepeatedIncorrectEntries();
    }

    @Then("the system handles repeated incorrect entries appropriately")
    public void theSystemHandlesRepeatedIncorrectEntriesAppropriately() {
        verifyAppropriateHandlingOfRepeatedIncorrectEntries();
    }

    @When("the user checks system logs for errors related to code verification")
    public void theUserChecksSystemLogsForErrorsRelatedToCodeVerification() {
        checkSystemLogsForVerificationErrors();
    }

    @Then("the logs show errors related to incorrect code entry")
    public void theLogsShowErrorsRelatedToIncorrectCodeEntry() {
        verifyLogsShowErrors();
    }

    @When("the user verifies the system's handling of incorrect code entries")
    public void theUserVerifiesTheSystemHandlingOfIncorrectCodeEntries() {
        verifySystemHandlingOfIncorrectEntries();
    }

    @Then("the system handles incorrect code entries gracefully and provides user guidance")
    public void theSystemHandlesIncorrectCodeEntriesGracefullyAndProvidesUserGuidance() {
        verifyGracefulHandlingAndGuidance();
    }

    @Given("the user attempts login from a different device")
    public void theUserAttemptsLoginFromADifferentDevice() {
        simulateLoginFromDifferentDevice();
    }

    @When("the user verifies behavior")
    public void theUserVerifiesBehavior() {
        verifyBehaviorOnDifferentDevice();
    }

    @Then("code verification works correctly on a different device")
    public void codeVerificationWorksCorrectlyOnADifferentDevice() {
        verifyCodeVerificationOnDifferentDevice();
    }

    @When("the user checks for any updates or changes in code verification protocols")
    public void theUserChecksForAnyUpdatesOrChangesInCodeVerificationProtocols() {
        checkForUpdatesInVerificationProtocols();
    }

    @Then("code verification protocols are up-to-date and correct")
    public void codeVerificationProtocolsAreUpToDateAndCorrect() {
        verifyProtocolsAreUpToDate();
    }

    @When("the user verifies the system's compliance with code verification standards")
    public void theUserVerifiesTheSystemComplianceWithCodeVerificationStandards() {
        verifyComplianceWithStandards();
    }

    @Then("the system complies with code verification standards")
    public void theSystemCompliesWithCodeVerificationStandards() {
        verifySystemCompliance();
    }

    @When("the user ensures the system provides user guidance for incorrect code entries")
    public void theUserEnsuresTheSystemProvidesUserGuidanceForIncorrectCodeEntries() {
        ensureGuidanceForIncorrectEntries();
    }

    @Then("the system provides clear guidance for handling incorrect code entries")
    public void theSystemProvidesClearGuidanceForHandlingIncorrectCodeEntries() {
        verifyClearGuidanceProvided();
    }
}