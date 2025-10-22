package com.cucumber.steps;

import com.pageobjects.LogoutPage;
import io.cucumber.java.en.When;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;

public class UserLogoutSteps extends LogoutPage {

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        verifyUserLoggedIn();
    }

    @When("the user selects the 'Logout' option")
    public void theUserSelectsTheLogoutOption() {
        clickLogoutOption();
    }

    @Then("the user is logged out")
    public void theUserIsLoggedOut() {
        verifyUserLoggedOut();
    }

    @Then("the user is redirected to the login page")
    public void theUserIsRedirectedToTheLoginPage() {
        verifyRedirectionToLoginPage();
    }

    @Given("the user is logged out")
    public void theUserIsLoggedOut() {
        ensureUserIsLoggedOut();
    }

    @When("the user attempts to access the dashboard")
    public void theUserAttemptsToAccessTheDashboard() {
        attemptAccessDashboard();
    }

    @Then("access is denied")
    public void accessIsDenied() {
        verifyAccessDenied();
    }

    @Then("the login page is prompted")
    public void theLoginPageIsPrompted() {
        verifyLoginPagePrompted();
    }
}