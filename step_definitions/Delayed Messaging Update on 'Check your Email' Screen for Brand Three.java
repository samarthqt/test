package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DelayedMessagingSteps extends CheckYourEmailPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user is registered with Brand Three and has initiated an email verification process")
    public void userRegisteredWithBrandThree() {
        initiateEmailVerificationForBrandThree();
    }

    @When("the user initiates the email verification process for Brand Three")
    public void userInitiatesEmailVerification() {
        initiateEmailVerificationForBrandThree();
    }

    @Then("the user is directed to the 'Check your Email' screen")
    public void userDirectedToCheckYourEmailScreen() {
        verifyOnCheckYourEmailScreen();
    }

    @Then("the message \"Please check your email for the verification link.\" is displayed")
    public void messageDisplayed() {
        verifyMessageDisplayed("Please check your email for the verification link.");
    }

    @Given("the user is on the 'Check your Email' screen for Brand Three")
    public void userOnCheckYourEmailScreen() {
        verifyOnCheckYourEmailScreen();
    }

    @When("a delay in the messaging update is simulated")
    public void simulateDelayInMessagingUpdate() {
        simulateMessagingDelay();
    }

    @Then("the message updates after a delay")
    public void messageUpdatesAfterDelay() {
        verifyMessageUpdatesAfterDelay();
    }

    @Then("the expected message is \"Please check your email for the verification link.\"")
    public void expectedMessageAfterDelay() {
        verifyMessageDisplayed("Please check your email for the verification link.");
    }

    @Given("the message updates after a delay")
    public void messageUpdatesAfterDelayGiven() {
        verifyMessageUpdatesAfterDelay();
    }

    @When("the final message is displayed")
    public void finalMessageDisplayed() {
        verifyFinalMessageDisplayed();
    }

    @Then("the final message is correct and matches the expected message")
    public void finalMessageCorrect() {
        verifyFinalMessageCorrect();
    }

    @Given("the user experiences a delayed messaging update")
    public void userExperiencesDelayedMessagingUpdate() {
        simulateMessagingDelay();
    }

    @When("the user reads the final message")
    public void userReadsFinalMessage() {
        verifyFinalMessageDisplayed();
    }

    @Then("the user is not confused by the delayed messaging update")
    public void userNotConfusedByDelay() {
        verifyUserNotConfused();
    }
}