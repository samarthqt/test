package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmailVerificationSteps extends CheckYourEmailPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user is registered with Brand Three and has initiated an email verification process")
    public void userInitiatedEmailVerification() {
        initiateEmailVerification();
    }

    @When("the user initiates the email verification process")
    public void userInitiatesEmailVerification() {
        initiateEmailVerification();
    }

    @Then("the user is directed to the 'Check your Email' screen")
    public void userDirectedToCheckYourEmailScreen() {
        verifyOnCheckYourEmailScreen();
    }

    @Given("the user is on the 'Check your Email' screen")
    public void userOnCheckYourEmailScreen() {
        verifyOnCheckYourEmailScreen();
    }

    @When("the messaging is displayed on the screen")
    public void messagingDisplayedOnScreen() {
        displayMessaging();
    }

    @Then("the message \"Please check your email for the verification link.\" should be displayed")
    public void verifyCorrectMessageDisplayed() {
        verifyMessageDisplayed("Please check your email for the verification link.");
    }

    @Then("identify and report any incorrect messaging")
    public void identifyAndReportIncorrectMessaging() {
        reportIncorrectMessaging();
    }

    @Then("the incorrect message \"Check your inbox for the email.\" is reported")
    public void incorrectMessageReported() {
        verifyIncorrectMessageReported("Check your inbox for the email.");
    }

    @When("checking for additional instructions or links")
    public void checkForAdditionalInstructionsOrLinks() {
        checkAdditionalInstructionsOrLinks();
    }

    @Then("no additional instructions or links are present")
    public void verifyNoAdditionalInstructionsOrLinks() {
        verifyNoAdditionalInstructionsOrLinks();
    }

    @Given("the incorrect message is displayed on the screen")
    public void incorrectMessageDisplayed() {
        displayIncorrectMessage();
    }

    @When("the user reads the message")
    public void userReadsMessage() {
        readMessage();
    }

    @Then("the user is not misled by the incorrect message")
    public void verifyUserNotMisled() {
        verifyUserNotMisledByMessage();
    }
}