package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmailVerificationSteps extends CheckYourEmailPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user is registered with Brand Two and has initiated an email verification process")
    public void userRegisteredWithBrandTwo() {
        initiateEmailVerificationForBrandTwo();
    }

    @When("the user initiates the email verification process for Brand Two")
    public void userInitiatesEmailVerification() {
        initiateEmailVerificationForBrandTwo();
    }

    @Then("the user is directed to the 'Check your Email' screen")
    public void userDirectedToCheckYourEmailScreen() {
        verifyUserIsOnCheckYourEmailScreen();
    }

    @Given("the user is on the 'Check your Email' screen")
    public void userOnCheckYourEmailScreen() {
        verifyUserIsOnCheckYourEmailScreen();
    }

    @When("the system displays a message")
    public void systemDisplaysMessage() {
        displayMessageOnScreen();
    }

    @Then("the correct message \"Please check your email for the verification link.\" should be displayed")
    public void verifyCorrectMessageDisplayed() {
        verifyMessageDisplayed("Please check your email for the verification link.");
    }

    @Then("identify and report any incorrect messaging")
    public void identifyIncorrectMessaging() {
        reportIncorrectMessaging();
    }

    @Then("the incorrect message \"Check your inbox for the email.\" should be noted")
    public void noteIncorrectMessage() {
        noteIncorrectMessage("Check your inbox for the email.");
    }

    @Then("no additional instructions or links are present")
    public void verifyNoAdditionalInstructionsOrLinks() {
        verifyNoAdditionalInstructionsOrLinks();
    }

    @Given("the user sees an incorrect message on the 'Check your Email' screen")
    public void userSeesIncorrectMessage() {
        verifyIncorrectMessageOnScreen();
    }

    @Then("the user is not misled by the incorrect message")
    public void verifyUserNotMisled() {
        verifyUserNotMisledByIncorrectMessage();
    }
}