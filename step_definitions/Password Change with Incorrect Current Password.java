package com.cucumber.steps;

import com.page_objects.AccountSettingsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PasswordChangeSteps extends AccountSettingsPage {

    @Given("the user is logged into the account")
    public void theUserIsLoggedIntoTheAccount() {
        loginWithValidCredentials();
    }

    @When("the user navigates to the account settings page")
    public void theUserNavigatesToTheAccountSettingsPage() {
        navigateToAccountSettings();
    }

    @Then("the account settings page is displayed")
    public void theAccountSettingsPageIsDisplayed() {
        verifyAccountSettingsPageDisplayed();
    }

    @When("the user clicks on the 'Change Password' option")
    public void theUserClicksOnTheChangePasswordOption() {
        clickChangePasswordOption();
    }

    @Then("the change password form is displayed")
    public void theChangePasswordFormIsDisplayed() {
        verifyChangePasswordFormDisplayed();
    }

    @When("the user enters {string} in the 'Current Password' field")
    public void theUserEntersInTheCurrentPasswordField(String currentPassword) {
        enterCurrentPassword(currentPassword);
    }

    @When("the user enters {string} in the 'New Password' field")
    public void theUserEntersInTheNewPasswordField(String newPassword) {
        enterNewPassword(newPassword);
    }

    @When("the user re-enters {string} in the 'Confirm New Password' field")
    public void theUserReEntersInTheConfirmNewPasswordField(String confirmPassword) {
        enterConfirmPassword(confirmPassword);
    }

    @When("the user clicks on the 'Submit' button")
    public void theUserClicksOnTheSubmitButton() {
        clickSubmitButton();
    }

    @Then("an error message is displayed indicating incorrect current password")
    public void anErrorMessageIsDisplayedIndicatingIncorrectCurrentPassword() {
        verifyIncorrectPasswordErrorMessage();
    }

    @When("the user attempts to log out of the account")
    public void theUserAttemptsToLogOutOfTheAccount() {
        logout();
    }

    @Then("the user is logged out successfully")
    public void theUserIsLoggedOutSuccessfully() {
        verifyLogoutSuccess();
    }

    @When("the user attempts to log in using the new password")
    public void theUserAttemptsToLogInUsingTheNewPassword() {
        loginWithNewPassword();
    }

    @Then("login fails with the new password")
    public void loginFailsWithTheNewPassword() {
        verifyLoginFailureWithNewPassword();
    }

    @When("the user attempts to log in using the old password")
    public void theUserAttemptsToLogInUsingTheOldPassword() {
        loginWithOldPassword();
    }

    @Then("the user logs in successfully with the old password")
    public void theUserLogsInSuccessfullyWithTheOldPassword() {
        verifyLoginSuccessWithOldPassword();
    }

    @When("the user accesses account settings to verify password change attempt")
    public void theUserAccessesAccountSettingsToVerifyPasswordChangeAttempt() {
        navigateToAccountSettings();
    }

    @Then("account settings do not reflect any password change")
    public void accountSettingsDoNotReflectAnyPasswordChange() {
        verifyNoPasswordChangeInAccountSettings();
    }

    @When("the system logs are checked for the failed password change attempt")
    public void theSystemLogsAreCheckedForTheFailedPasswordChangeAttempt() {
        checkSystemLogsForFailedPasswordChange();
    }

    @Then("system logs show the failed password change attempt")
    public void systemLogsShowTheFailedPasswordChangeAttempt() {
        verifyFailedPasswordChangeInLogs();
    }

    @When("ensuring no security alerts are triggered by the failed attempt")
    public void ensuringNoSecurityAlertsAreTriggeredByTheFailedAttempt() {
        checkForSecurityAlerts();
    }

    @Then("no security alerts are triggered")
    public void noSecurityAlertsAreTriggered() {
        verifyNoSecurityAlertsTriggered();
    }

    @When("the user attempts to change password using the correct current password")
    public void theUserAttemptsToChangePasswordUsingTheCorrectCurrentPassword() {
        changePasswordWithCorrectCurrentPassword();
    }

    @Then("the password change process succeeds with correct current password")
    public void thePasswordChangeProcessSucceedsWithCorrectCurrentPassword() {
        verifyPasswordChangeSuccess();
    }

    @When("verifying system behavior after multiple incorrect attempts")
    public void verifyingSystemBehaviorAfterMultipleIncorrectAttempts() {
        attemptMultipleIncorrectPasswordChanges();
    }

    @Then("the system locks the account or prompts security questions after multiple failed attempts")
    public void theSystemLocksTheAccountOrPromptsSecurityQuestionsAfterMultipleFailedAttempts() {
        verifyAccountLockOrSecurityPrompt();
    }
}