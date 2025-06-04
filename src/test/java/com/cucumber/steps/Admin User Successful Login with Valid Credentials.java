package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.AdminLoginPage;

public class AdminLoginSteps extends AdminLoginPage {

    private TestHarness testHarness = new TestHarness();

    @Given("an admin user account is created and activated")
    public void anAdminUserAccountIsCreatedAndActivated() {
        // Assume account creation and activation is handled outside of this test
    }

    @When("the admin navigates to the login page of the application")
    public void theAdminNavigatesToTheLoginPageOfTheApplication() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    @Then("the login page is displayed with username and password fields")
    public void theLoginPageIsDisplayedWithUsernameAndPasswordFields() {
        verifyLoginPageElements();
    }

    @Then("the 'Login with SSO' button should be visible on the login screen")
    public void theLoginWithSSOButtonShouldBeVisibleOnTheLoginScreen() {
        verifySSOButtonVisibility();
    }

    @When("the admin enters \"admin_user\" in the username field")
    public void theAdminEntersAdminUserInTheUsernameField() {
        enterUserName("admin_user");
    }

    @Then("the username is entered in the username field")
    public void theUsernameIsEnteredInTheUsernameField() {
        verifyUserNameEntry("admin_user");
    }

    @When("the admin enters \"valid_password\" in the password field")
    public void theAdminEntersValidPasswordInThePasswordField() {
        enterPassword("valid_password");
    }

    @Then("the password is entered in the password field")
    public void thePasswordIsEnteredInThePasswordField() {
        verifyPasswordEntry("valid_password");
    }

    @Then("the password is masked with asterisks or dots")
    public void thePasswordIsMaskedWithAsterisksOrDots() {
        verifyPasswordMasking();
    }

    @When("the admin clicks on the \"Login\" button")
    public void theAdminClicksOnTheLoginButton() {
        clickLoginButton();
    }

    @Then("the system processes the login request")
    public void theSystemProcessesTheLoginRequest() {
        verifyLoginRequestProcessing();
    }

    @Then("the admin user is redirected to the home screen")
    public void theAdminUserIsRedirectedToTheHomeScreen() {
        verifyHomeScreenRedirection();
    }

    @Then("admin-specific menus and options are visible on the home screen")
    public void adminSpecificMenusAndOptionsAreVisibleOnTheHomeScreen() {
        verifyAdminMenusVisibility();
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