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

    @Then("an error message indicating invalid email format is displayed")
    public void anErrorMessageIndicatingInvalidEmailFormatIsDisplayed() {
        verifyInvalidEmailFormatErrorMessage();
    }

    @Given("an error message is displayed for incorrect email format")
    public void anErrorMessageIsDisplayedForIncorrectEmailFormat() {
        verifyInvalidEmailFormatErrorMessage();
    }

    @Then("the error message is clear, concise, and meets design standards")
    public void theErrorMessageIsClearConciseAndMeetsDesignStandards() {
        verifyErrorMessageDesignStandards();
    }

    @Then("the email field is highlighted with a red border")
    public void theEmailFieldIsHighlightedWithARedBorder() {
        verifyEmailFieldHighlight();
    }

    @Then("the sign-in button is disabled")
    public void theSignInButtonIsDisabled() {
        verifySignInButtonDisabled();
    }

    @Then("the error message is logged in the system for auditing")
    public void theErrorMessageIsLoggedInTheSystemForAuditing() {
        verifyErrorMessageLogged();
    }

    @When("the user corrects the email format and clicks {string} again")
    public void theUserCorrectsTheEmailFormatAndClicksAgain(String buttonName) {
        if (buttonName.equals("Sign In")) {
            correctEmailFormat();
            clickSignInButton();
        }
    }

    @Then("the system accepts the correct email format and processes sign-in")
    public void theSystemAcceptsTheCorrectEmailFormatAndProcessesSignIn() {
        verifySignInSuccess();
    }

    @Then("the error message disappears")
    public void theErrorMessageDisappears() {
        verifyErrorMessageDisappears();
    }

    @Given("the user has corrected the email format")
    public void theUserHasCorrectedTheEmailFormat() {
        correctEmailFormat();
    }

    @Then("the email field retains the correct format")
    public void theEmailFieldRetainsTheCorrectFormat() {
        verifyEmailFieldCorrectFormat();
    }

    @When("the user enters another incorrect email format")
    public void theUserEntersAnotherIncorrectEmailFormat() {
        enterAnotherIncorrectEmailFormat();
    }

    @Then("a similar error message is displayed for different incorrect format")
    public void aSimilarErrorMessageIsDisplayedForDifferentIncorrectFormat() {
        verifySimilarErrorMessageForDifferentFormat();
    }

    @When("the user switches to another page and returns to sign-in")
    public void theUserSwitchesToAnotherPageAndReturnsToSignIn() {
        switchToAnotherPageAndReturn();
    }

    @Then("the error message remains consistent upon returning")
    public void theErrorMessageRemainsConsistentUponReturning() {
        verifyErrorMessageConsistency();
    }

    @Then("the system provides suggestions for correcting the email format")
    public void theSystemProvidesSuggestionsForCorrectingTheEmailFormat() {
        verifyEmailFormatSuggestions();
    }
}