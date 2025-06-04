package com.cucumber.steps;

import com.page_objects.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SSOButtonVisibilitySteps extends LoginPage {

    @Given("an admin user account exists in the system")
    public void anAdminUserAccountExistsInTheSystem() {
        // Logic to ensure admin user account exists
    }

    @Given("SSO integration is configured and active")
    public void ssoIntegrationIsConfiguredAndActive() {
        // Logic to verify SSO integration is active
    }

    @When("the user navigates to the COCO login screen")
    public void theUserNavigatesToTheCOCOLoginScreen() {
        navigateToLoginScreen();
    }

    @Then("the login screen should be displayed with all expected fields and buttons")
    public void theLoginScreenShouldBeDisplayedWithAllExpectedFieldsAndButtons() {
        verifyLoginScreenElements();
    }

    @Then("the 'Login with SSO' button should be visible on the login screen")
    public void theLoginWithSSOButtonShouldBeVisibleOnTheLoginScreen() {
        verifySSOButtonVisibility();
    }
}