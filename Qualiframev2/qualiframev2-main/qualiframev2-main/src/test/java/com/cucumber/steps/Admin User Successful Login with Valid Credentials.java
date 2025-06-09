package com.cucumber.steps;

import com.pageobjects.AdminLoginPage;
import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminLoginSteps extends AdminLoginPage {

    private TestHarness testHarness = new TestHarness();

    @Given("an admin user account is created and activated")
    public void anAdminUserAccountIsCreatedAndActivated() {
        // Assume account creation and activation is handled outside of this step
    }

    @When("the admin navigates to the login page of the application")
    public void theAdminNavigatesToTheLoginPageOfTheApplication() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    @Then("the login page is displayed with username and password fields")
    public void theLoginPageIsDisplayedWithUsernameAndPasswordFields() {
        verifyLoginPageDisplayed();
    }

    @When("the admin enters {string} in the username field")
    public void theAdminEntersInTheUsernameField(String username) {
        enterUserName(username);
    }

    @Then("the username is entered in the username field")
    public void theUsernameIsEnteredInTheUsernameField() {
        verifyUserNameEntered();
    }

    @When("the admin enters {string} in the password field")
    public void theAdminEntersInThePasswordField(String password) {
        enterPassword(password);
    }

    @Then("the password is entered in the password field")
    public void thePasswordIsEnteredInThePasswordField() {
        verifyPasswordEntered();
    }

    @Then("the password is masked with asterisks or dots")
    public void thePasswordIsMaskedWithAsterisksOrDots() {
        verifyPasswordMasked();
    }

    @When("the admin clicks on the {string} button")
    public void theAdminClicksOnTheButton(String buttonName) {
        clickLoginButton();
    }

    @Then("the system processes the login request")
    public void theSystemProcessesTheLoginRequest() {
        verifyLoginProcessing();
    }

    @Then("the admin user is redirected to the home screen")
    public void theAdminUserIsRedirectedToTheHomeScreen() {
        verifyHomePageRedirection();
    }

    @Then("admin-specific menus and options are visible on the home screen")
    public void adminSpecificMenusAndOptionsAreVisibleOnTheHomeScreen() {
        verifyAdminMenusVisible();
    }

    @When("the admin logs out from the admin account")
    public void theAdminLogsOutFromTheAdminAccount() {
        clickLogoutButton();
    }

    @Then("the user is logged out and redirected to the login page")
    public void theUserIsLoggedOutAndRedirectedToTheLoginPage() {
        verifyLogoutRedirection();
    }
}