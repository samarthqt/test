package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerificationCodeSteps extends VerificationCodePage {

    private TestHarness testHarness = new TestHarness();

    @Given("User has a verification code prompt active")
    public void userHasVerificationCodePromptActive() {
        activateVerificationCodePrompt();
    }

    @When("User enters an incorrect verification code {string} into the system")
    public void userEntersIncorrectVerificationCode(String code) {
        enterVerificationCode(code);
    }

    @Then("System displays an error message indicating incorrect code entry")
    public void systemDisplaysErrorMessage() {
        verifyErrorMessageDisplayed();
    }

    @Given("User sees an error message for incorrect code entry")
    public void userSeesErrorMessageForIncorrectCodeEntry() {
        verifyErrorMessageDisplayed();
    }

    @When("User retries entering the correct verification code {string}")
    public void userRetriesEnteringCorrectVerificationCode(String code) {
        enterVerificationCode(code);
    }

    @Then("System accepts the correct code and grants access")
    public void systemAcceptsCorrectCodeAndGrantsAccess() {
        verifyAccessGranted();
    }

    @Then("Error message clearly states the issue and next steps")
    public void errorMessageClarity() {
        verifyErrorMessageClarity();
    }

    @Given("User enters an incorrect verification code")
    public void userEntersIncorrectVerificationCode() {
        enterVerificationCode(testHarness.getData("VerificationData", "IncorrectCode"));
    }

    @Then("System logs the incorrect attempt with timestamp and user ID")
    public void systemLogsIncorrectAttempt() {
        verifyIncorrectAttemptLogged();
    }

    @Given("User enters multiple incorrect verification codes")
    public void userEntersMultipleIncorrectCodes() {
        enterMultipleIncorrectCodes();
    }

    @Then("System allows retries without locking the user out")
    public void systemAllowsRetries() {
        verifyRetriesAllowed();
    }

    @Given("User enters an incorrect verification code on different devices")
    public void userEntersIncorrectCodeOnDifferentDevices() {
        enterIncorrectCodeOnDifferentDevices();
    }

    @Then("Error message displays correctly on all devices")
    public void errorMessageDisplaysCorrectlyOnAllDevices() {
        verifyErrorMessageConsistencyAcrossDevices();
    }

    @Given("High traffic condition occurs")
    public void highTrafficConditionOccurs() {
        simulateHighTrafficCondition();
    }

    @When("User enters an incorrect verification code")
    public void userEntersIncorrectVerificationCodeDuringHighTraffic() {
        enterVerificationCode(testHarness.getData("VerificationData", "IncorrectCode"));
    }

    @Then("Error messages are displayed promptly without delay")
    public void errorMessagesDisplayedPromptly() {
        verifyPromptErrorMessageDisplay();
    }

    @Given("User has made multiple incorrect verification code attempts")
    public void userHasMadeMultipleIncorrectAttempts() {
        simulateMultipleIncorrectAttempts();
    }

    @Then("System prompts for alternative verification method after multiple failures")
    public void systemPromptsForAlternativeVerificationMethod() {
        verifyAlternativeVerificationPrompt();
    }

    @Given("User enters a verification code with special characters")
    public void userEntersCodeWithSpecialCharacters() {
        enterVerificationCodeWithSpecialCharacters();
    }

    @Then("System rejects entries with special characters and displays a relevant error message")
    public void systemRejectsSpecialCharacterEntries() {
        verifySpecialCharacterErrorMessage();
    }

    @Given("User has customized error message settings")
    public void userHasCustomizedErrorMessageSettings() {
        applyCustomizedErrorMessageSettings();
    }

    @Then("Error messages reflect user preferences where applicable")
    public void errorMessagesReflectUserPreferences() {
        verifyCustomizedErrorMessages();
    }

    @Given("User enters an incorrect verification code from different geographic locations")
    public void userEntersIncorrectCodeFromDifferentLocations() {
        enterIncorrectCodeFromDifferentLocations();
    }

    @Then("Error message displays consistently regardless of location")
    public void errorMessageDisplaysConsistentlyRegardlessOfLocation() {
        verifyErrorMessageConsistencyAcrossLocations();
    }

    @Given("Network delay occurs")
    public void networkDelayOccurs() {
        simulateNetworkDelay();
    }

    @When("User enters an incorrect verification code")
    public void userEntersIncorrectVerificationCodeDuringNetworkDelay() {
        enterVerificationCode(testHarness.getData("VerificationData", "IncorrectCode"));
    }

    @Then("Error message is displayed without network-induced delays")
    public void errorMessageDisplayedWithoutNetworkDelays() {
        verifyErrorMessageDisplayWithoutNetworkDelays();
    }

    @Given("User enters a verification code with incorrect length")
    public void userEntersCodeWithIncorrectLength() {
        enterVerificationCodeWithIncorrectLength();
    }

    @Then("System rejects codes of incorrect length and displays a relevant error message")
    public void systemRejectsIncorrectLengthCodes() {
        verifyIncorrectLengthErrorMessage();
    }

    @Given("Multiple users enter incorrect verification codes concurrently")
    public void multipleUsersEnterIncorrectCodesConcurrently() {
        simulateConcurrentIncorrectCodeEntries();
    }

    @Then("Each user's incorrect attempt is handled separately and accurately")
    public void eachUsersIncorrectAttemptHandledSeparately() {
        verifySeparateHandlingOfIncorrectAttempts();
    }
}