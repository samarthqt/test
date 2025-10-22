package com.cucumber.steps;
import io.cucumber.java.en.When;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import com.framework.cucumber.TestHarness;

import com.pageobjects.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;

public class UserLoginValidationSteps extends LoginPage {

    @Given("the user navigates to the login page")
    public void theUserNavigatesToTheLoginPage() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    @When("the user enters {string} and {string}")
    public void theUserEntersUsernameAndPassword(String username, String password) {
        enterUserName(username);
        enterPassword(password);
    }

    @When("the user selects the 'Login' option")
    public void theUserSelectsTheLoginOption() {
        clickLoginButton();
    }

    @Then("an error message is displayed indicating incorrect credentials")
    public void anErrorMessageIsDisplayedIndicatingIncorrectCredentials() {
        verifyErrorMessage("Incorrect username or password.");
    }
}