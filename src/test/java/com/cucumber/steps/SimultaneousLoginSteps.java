package com.cucumber.steps;
import io.cucumber.java.en.When;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import com.framework.cucumber.TestHarness;

import com.pageobjects.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;

public class SimultaneousLoginSteps extends LoginPage {

    @Given("the user is logged in on one device with username {string} and password {string}")
    public void theUserIsLoggedInOnOneDevice(String username, String password) {
        launchUrl("http://mockurl.com/login");
        maximizeWindow();
        enterUserName(username);
        enterPassword(password);
        clickLoginButton();
        verifyHomePageRedirection("http://mockurl.com/home");
    }

    @When("the user attempts to log in from a second device using the same credentials")
    public void theUserAttemptsToLogInFromASecondDevice() {
        launchUrl("http://mockurl.com/login");
        maximizeWindow();
        enterUserName("validUser");
        enterPassword("validPassword123");
        clickLoginButton();
    }

    @Then("the system should prevent login and display an error message about simultaneous sessions")
    public void theSystemShouldPreventLoginAndDisplayAnErrorMessage() {
        verifySimultaneousLoginErrorMessage("Simultaneous login detected. Please log out from other devices.");
    }
}