package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.LoginPage;

public class LoginSteps extends LoginPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user account is created and activated")
    public void theUserAccountIsCreatedAndActivated() {
        // Assume account creation and activation is handled outside of this step
    }

    @When("the user navigates to the login page of the application")
    public void theUserNavigatesToTheLoginPageOfTheApplication() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    @Then("the login page is displayed with username and password fields")
    public void theLoginPageIsDisplayedWithUsernameAndPasswordFields() {
        verifyLoginPageDisplayed();
    }

    @When("the user enters \"incorrect_user\" in the username field")
    public void theUserEntersIncorrectUserInTheUsernameField() {
        enterUserName("incorrect_user");
    }

    @When("the user enters \"valid_password\" in the password field")
    public void theUserEntersValidPasswordInThePasswordField() {
        enterPassword("valid_password");
    }

    @When("the user clicks on the \"Login\" button")
    public void theUserClicksOnTheLoginButton() {
        clickLoginButton();
    }

    @Then("the system processes the login request")
    public void theSystemProcessesTheLoginRequest() {
        // Assume processing is handled by the application
    }

    @Then("the login attempt is unsuccessful")
    public void theLoginAttemptIsUnsuccessful() {
        verifyLoginUnsuccessful();
    }

    @Then("an error message is displayed")
    public void anErrorMessageIsDisplayed() {
        verifyErrorMessageDisplayed();
    }

    @Then("the error message is clear and informative")
    public void theErrorMessageIsClearAndInformative() {
        verifyErrorMessageContent();
    }

    @Then("the error message states that the username/password is incorrect")
    public void theErrorMessageStatesThatTheUsernamePasswordIsIncorrect() {
        verifyErrorMessageIncorrectCredentials();
    }
}