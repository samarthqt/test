package com.cucumber.steps;
import io.cucumber.java.en.When;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import com.framework.cucumber.TestHarness;

import com.pageobjects.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;

public class UserLoginSteps extends LoginPage {

    @Given("the user navigates to the login page")
    public void theUserNavigatesToTheLoginPage() {
        navigateToLoginPage();
    }

    @When("the user enters a username {string} and password {string}")
    public void theUserEntersAUsernameAndPassword(String username, String password) {
        enterUserName(username);
        enterPassword(password);
    }

    @When("the user selects the 'Login' option")
    public void theUserSelectsTheLoginOption() {
        clickLoginButton();
    }

    @Then("the user is redirected to the dashboard")
    public void theUserIsRedirectedToTheDashboard() {
        verifyDashboardRedirection("http://example.com/dashboard");
    }

    @Then("the user dashboard is displayed with user-specific content")
    public void theUserDashboardIsDisplayedWithUserSpecificContent() {
        verifyUserSpecificContent();
    }
}