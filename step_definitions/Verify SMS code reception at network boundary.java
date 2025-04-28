package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SmsCodeReceptionSteps extends SmsCodeReceptionPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user is registered and attempting to log in from a location at the network boundary")
    public void userAtNetworkBoundary() {
        // Implement logic to simulate user at network boundary
    }

    @When("the user initiates the login process on the mobile application")
    public void initiateLoginProcess() {
        navigateToLoginPage();
    }

    @Then("the user is prompted to enter their phone number")
    public void promptForPhoneNumber() {
        verifyPhoneNumberPrompt();
    }

    @When("the user enters the registered phone number \"{string}\" and submits")
    public void enterPhoneNumber(String phoneNumber) {
        enterPhoneNumber(phoneNumber);
        submitPhoneNumber();
    }

    @Then("the system sends an SMS code to the provided phone number")
    public void sendSmsCode() {
        verifySmsCodeSent();
    }

    @When("the user checks the phone for the SMS code")
    public void checkSmsCode() {
        // Implement logic to check SMS code
    }

    @Then("the SMS code \"{string}\" is received on the user's phone within expected time")
    public void verifySmsCodeReceived(String smsCode) {
        verifySmsCodeReceived(smsCode);
    }

    @When("the user enters the received SMS code in the application")
    public void enterReceivedSmsCode() {
        enterSmsCode(testHarness.getData("SmsCodeData", "ReceivedSmsCode"));
    }

    @Then("the system validates the code and allows the user to proceed")
    public void validateSmsCode() {
        verifySmsCodeValidation();
    }

    @When("the user verifies that the SMS code is correct and matches the expected format")
    public void verifySmsCodeFormat() {
        verifySmsCodeFormat(testHarness.getData("SmsCodeData", "ExpectedSmsCodeFormat"));
    }

    @Then("the SMS code matches the expected format and is accepted by the system")
    public void smsCodeAccepted() {
        verifySmsCodeAccepted();
    }
}