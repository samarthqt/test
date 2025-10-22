package com.cucumber.steps;
import io.cucumber.java.en.When;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import com.framework.cucumber.TestHarness;

import com.pageobjects.LoginLoggingPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;

public class LoginAttemptLoggingSteps extends LoginLoggingPage {

    @Given("the user has access to system logs")
    public void theUserHasAccessToSystemLogs() {
        verifySystemLogAccess();
    }

    @When("the user logs in with username {string} and password {string}")
    public void theUserLogsInWithUsernameAndPassword(String username, String password) {
        enterUserName(username);
        enterPassword(password);
        clickLoginButton();
    }

    @Then("the user should be logged in successfully")
    public void theUserShouldBeLoggedInSuccessfully() {
        verifyLoginSuccess();
    }

    @Then("the login attempt should be logged with a timestamp and user details in the system logs")
    public void theLoginAttemptShouldBeLoggedWithATimestampAndUserDetailsInTheSystemLogs() {
        verifyLoginAttemptLogged();
    }
}