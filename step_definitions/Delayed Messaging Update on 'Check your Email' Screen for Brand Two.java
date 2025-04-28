package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DelayedMessagingSteps extends CheckYourEmailPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user is registered with Brand Two and has initiated an email verification process")
    public void userRegisteredAndInitiatedEmailVerification() {
        initiateEmailVerificationForBrandTwo();
    }

    @When("the user initiates the email verification process")
    public void userInitiatesEmailVerification() {
        initiateEmailVerification();
    }

    @Then("the user should be directed to the 'Check your Email' screen")
    public void userDirectedToCheckYourEmailScreen() {
        verifyOnCheckYourEmailScreen();
    }

    @Then("the message \"Please check your email for the verification link.\" should be displayed")
    public void verifyInitialMessageDisplayed() {
        verifyMessageDisplayed("Please check your email for the verification link.");
    }

    @Given("the user is on the 'Check your Email' screen")
    public void userOnCheckYourEmailScreen() {
        verifyOnCheckYourEmailScreen();
    }

    @When("a delay in the messaging update is simulated")
    public void simulateDelayInMessagingUpdate() {
        simulateMessagingDelay();
    }

    @Then("the message should update after a delay")
    public void messageUpdatesAfterDelay() {
        verifyMessageUpdatesAfterDelay();
    }

    @Then("the expected message \"Please check your email for the verification link.\" should be displayed")
    public void verifyExpectedMessageAfterDelay() {
        verifyMessageDisplayed("Please check your email for the verification link.");
    }

    @Given("there is a delay in the messaging update")
    public void delayInMessagingUpdate() {
        simulateMessagingDelay();
    }

    @When("the final message is displayed after the delay")
    public void finalMessageDisplayedAfterDelay() {
        verifyFinalMessageAfterDelay();
    }

    @Then("the final message should be correct and match the expected message")
    public void verifyFinalMessageCorrect() {
        verifyFinalMessageCorrectness();
    }

    @When("the user views the delayed message")
    public void userViewsDelayedMessage() {
        viewDelayedMessage();
    }

    @Then("the user should not be confused by the delayed messaging update")
    public void userNotConfusedByDelayedMessage() {
        verifyUserNotConfused();
    }
}