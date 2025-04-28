package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmailVerificationSteps extends CheckYourEmailPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user is registered with Brand Two and has initiated an email verification process")
    public void aUserIsRegisteredWithBrandTwoAndHasInitiatedAnEmailVerificationProcess() {
        initiateEmailVerificationForBrandTwo();
    }

    @When("the user initiates the email verification process for a Brand Two user")
    public void theUserInitiatesTheEmailVerificationProcessForABrandTwoUser() {
        initiateEmailVerificationForBrandTwo();
    }

    @Then("the user is directed to the 'Check your Email' screen")
    public void theUserIsDirectedToTheCheckYourEmailScreen() {
        verifyCheckYourEmailScreenDisplayed();
    }

    @When("the user views the 'Check your Email' screen")
    public void theUserViewsTheCheckYourEmailScreen() {
        navigateToCheckYourEmailScreen();
    }

    @Then("the message \"Please check your email for the verification link.\" is displayed")
    public void theMessageIsDisplayed() {
        verifyEmailVerificationMessageDisplayed();
    }

    @Then("no additional instructions or links are present")
    public void noAdditionalInstructionsOrLinksArePresent() {
        verifyNoAdditionalInstructionsOrLinks();
    }

    @Then("the branding and design elements conform to Brand Two's guidelines")
    public void theBrandingAndDesignElementsConformToBrandTwosGuidelines() {
        verifyBrandingAndDesignElements();
    }

    @Then("the message is grammatically correct and clear")
    public void theMessageIsGrammaticallyCorrectAndClear() {
        verifyMessageGrammarAndClarity();
    }
}