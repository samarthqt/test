package com.cucumber.steps;

import com.page_objects.TwoFactorAuthPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TwoFactorAuthSteps extends TwoFactorAuthPage {

    @Given("the user is logged into their account")
    public void theUserIsLoggedIntoTheirAccount() {
        verifyUserLoggedIn();
    }

    @When("the user navigates to the security settings")
    public void theUserNavigatesToTheSecuritySettings() {
        navigateToSecuritySettings();
    }

    @When("the user selects the option to enable two-factor authentication")
    public void theUserSelectsTheOptionToEnableTwoFactorAuthentication() {
        enableTwoFactorAuthentication();
    }

    @Then("the user should be presented with multiple 2FA methods")
    public void theUserShouldBePresentedWithMultiple2FAMethods() {
        verifyMultiple2FAMethodsPresented();
    }

    @Then("the user should be able to choose a preferred 2FA method")
    public void theUserShouldBeAbleToChooseAPreferred2FAMethod() {
        choosePreferred2FAMethod();
    }

    @Given("the user has enabled two-factor authentication")
    public void theUserHasEnabledTwoFactorAuthentication() {
        verifyTwoFactorAuthenticationEnabled();
    }

    @When("a 2FA-related activity occurs")
    public void a2FARelatedActivityOccurs() {
        trigger2FAActivity();
    }

    @Then("the user should receive a notification about the activity")
    public void theUserShouldReceiveANotificationAboutTheActivity() {
        verifyNotificationReceived();
    }

    @When("the user attempts to log in")
    public void theUserAttemptsToLogIn() {
        attemptLogin();
    }

    @Then("the application should prompt for the 2FA method")
    public void theApplicationShouldPromptForThe2FAMethod() {
        verify2FAPrompt();
    }

    @Then("the application should verify the 2FA method is functioning correctly")
    public void theApplicationShouldVerifyThe2FAMethodIsFunctioningCorrectly() {
        verify2FAFunctionality();
    }

    @Given("the user is on the two-factor authentication setup page")
    public void theUserIsOnTheTwoFactorAuthenticationSetupPage() {
        navigateTo2FASetupPage();
    }

    @When("the user selects {string}")
    public void theUserSelects(String method) {
        select2FAMethod(method);
    }

    @Then("the user should be able to configure {string} successfully")
    public void theUserShouldBeAbleToConfigureSuccessfully(String method) {
        configure2FAMethod(method);
    }
}