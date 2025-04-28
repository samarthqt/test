package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignInSteps extends SignInPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has access to the sign-in page")
    public void theUserHasAccessToTheSignInPage() {
        navigateToSignInPage();
    }

    @When("the user navigates to the sign-in page")
    public void theUserNavigatesToTheSignInPage() {
        verifySignInPageDisplayed();
    }

    @Then("the sign-in page is displayed")
    public void theSignInPageIsDisplayed() {
        verifySignInPageDisplayed();
    }

    @Given("the user is on the sign-in page")
    public void theUserIsOnTheSignInPage() {
        navigateToSignInPage();
    }

    @When("the user enters {string} in the email field")
    public void theUserEntersInTheEmailField(String email) {
        enterEmail(email);
    }

    @When("the user enters {string} in the password field")
    public void theUserEntersInThePasswordField(String password) {
        enterPassword(password);
    }

    @When("the user clicks on the {string} button")
    public void theUserClicksOnTheButton(String buttonName) {
        if (buttonName.equals("Sign In")) {
            clickSignInButton();
        }
    }

    @Then("an error message indicating invalid password format is displayed")
    public void anErrorMessageIndicatingInvalidPasswordFormatIsDisplayed() {
        verifyInvalidPasswordFormatErrorMessage();
    }

    @Then("the error message is clear, concise, and meets design standards")
    public void theErrorMessageIsClearConciseAndMeetsDesignStandards() {
        verifyErrorMessageDesignStandards();
    }

    @Then("the password field is highlighted with a red border")
    public void thePasswordFieldIsHighlightedWithARedBorder() {
        verifyPasswordFieldHighlight();
    }

    @Then("the sign-in button is disabled")
    public void theSignInButtonIsDisabled() {
        verifySignInButtonDisabled();
    }

    @Then("the error message is logged in the system for auditing")
    public void theErrorMessageIsLoggedInTheSystemForAuditing() {
        verifyErrorMessageLogged();
    }

    @Given("the user has entered an incorrect password format")
    public void theUserHasEnteredAnIncorrectPasswordFormat() {
        enterIncorrectPasswordFormat();
    }

    @When("the user corrects the password format and clicks {string} again")
    public void theUserCorrectsThePasswordFormatAndClicksAgain(String buttonName) {
        if (buttonName.equals("Sign In")) {
            correctPasswordFormat();
            clickSignInButton();
        }
    }

    @Then("the system accepts the correct password format and processes sign-in")
    public void theSystemAcceptsTheCorrectPasswordFormatAndProcessesSignIn() {
        verifySignInProcessed();
    }

    @Then("the error message disappears")
    public void theErrorMessageDisappears() {
        verifyErrorMessageDisappeared();
    }

    @Then("the password field retains the correct format")
    public void thePasswordFieldRetainsTheCorrectFormat() {
        verifyPasswordFieldCorrectFormat();
    }

    @Given("the user has corrected the password format once")
    public void theUserHasCorrectedThePasswordFormatOnce() {
        correctPasswordFormatOnce();
    }

    @When("the user enters another incorrect password format")
    public void theUserEntersAnotherIncorrectPasswordFormat() {
        enterAnotherIncorrectPasswordFormat();
    }

    @Then("a similar error message is displayed for different incorrect format")
    public void aSimilarErrorMessageIsDisplayedForDifferentIncorrectFormat() {
        verifySimilarErrorMessageForDifferentFormat();
    }

    @Given("the user has received an error message for incorrect password format")
    public void theUserHasReceivedAnErrorMessageForIncorrectPasswordFormat() {
        receiveErrorMessageForIncorrectFormat();
    }

    @When("the user switches to another page and returns to the sign-in page")
    public void theUserSwitchesToAnotherPageAndReturnsToTheSignInPage() {
        switchPagesAndReturnToSignIn();
    }

    @Then("the error message remains consistent upon returning")
    public void theErrorMessageRemainsConsistentUponReturning() {
        verifyErrorMessageConsistency();
    }

    @Given("the user has entered an incorrect password format")
    public void theUserHasEnteredAnIncorrectPasswordFormatAgain() {
        enterIncorrectPasswordFormat();
    }

    @When("the error message is displayed")
    public void theErrorMessageIsDisplayed() {
        verifyErrorMessageDisplayed();
    }

    @Then("the system provides suggestions for correcting the password format")
    public void theSystemProvidesSuggestionsForCorrectingThePasswordFormat() {
        verifyPasswordFormatSuggestions();
    }
}