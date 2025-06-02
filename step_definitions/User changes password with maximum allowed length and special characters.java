package com.cucumber.steps;

import com.page_objects.AccountSettingsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PasswordChangeSteps extends AccountSettingsPage {

    @Given("the user is logged into the account")
    public void theUserIsLoggedIntoTheAccount() {
        loginToAccount();
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

    @When("the user enters the current password {string} in the 'Current Password' field")
    public void theUserEntersTheCurrentPasswordInTheCurrentPasswordField(String currentPassword) {
        enterCurrentPassword(currentPassword);
    }

    @Then("the current password is entered successfully")
    public void theCurrentPasswordIsEnteredSuccessfully() {
        verifyCurrentPasswordEntered();
    }

    @When("the user enters the new password {string} in the 'New Password' field")
    public void theUserEntersTheNewPasswordInTheNewPasswordField(String newPassword) {
        enterNewPassword(newPassword);
    }

    @Then("the new password is entered successfully")
    public void theNewPasswordIsEnteredSuccessfully() {
        verifyNewPasswordEntered();
    }

    @When("the user re-enters the new password {string} in the 'Confirm New Password' field")
    public void theUserReEntersTheNewPasswordInTheConfirmNewPasswordField(String newPassword) {
        enterConfirmNewPassword(newPassword);
    }

    @Then("the new password is confirmed successfully")
    public void theNewPasswordIsConfirmedSuccessfully() {
        verifyNewPasswordConfirmed();
    }

    @When("the user clicks on the 'Submit' button")
    public void theUserClicksOnTheSubmitButton() {
        clickSubmitButton();
    }

    @Then("the password change request is submitted")
    public void thePasswordChangeRequestIsSubmitted() {
        verifyPasswordChangeRequestSubmitted();
    }

    @Then("a success message is displayed confirming the password change")
    public void aSuccessMessageIsDisplayedConfirmingThePasswordChange() {
        verifySuccessMessageDisplayed();
    }

    @When("the user logs out of the account")
    public void theUserLogsOutOfTheAccount() {
        logoutOfAccount();
    }

    @Then("the user is logged out successfully")
    public void theUserIsLoggedOutSuccessfully() {
        verifyUserLoggedOut();
    }

    @When("the user logs in using the new password {string}")
    public void theUserLogsInUsingTheNewPassword(String newPassword) {
        loginWithNewPassword(newPassword);
    }

    @Then("the user logs in successfully with the new password")
    public void theUserLogsInSuccessfullyWithTheNewPassword() {
        verifyLoginWithNewPassword();
    }

    @When("the user accesses account settings to verify password change")
    public void theUserAccessesAccountSettingsToVerifyPasswordChange() {
        accessAccountSettingsToVerifyPasswordChange();
    }

    @Then("account settings reflect the new password change")
    public void accountSettingsReflectTheNewPasswordChange() {
        verifyAccountSettingsReflectPasswordChange();
    }

    @Then("the new password meets maximum length and special character criteria")
    public void theNewPasswordMeetsMaximumLengthAndSpecialCharacterCriteria() {
        verifyPasswordCriteria();
    }

    @When("the user checks if the old password {string} is no longer valid")
    public void theUserChecksIfTheOldPasswordIsNoLongerValid(String oldPassword) {
        checkOldPasswordInvalid(oldPassword);
    }

    @Then("the old password does not allow login")
    public void theOldPasswordDoesNotAllowLogin() {
        verifyOldPasswordInvalid();
    }

    @When("the user attempts to change password again using the same steps")
    public void theUserAttemptsToChangePasswordAgainUsingTheSameSteps() {
        attemptPasswordChangeAgain();
    }

    @Then("the password change process repeats successfully")
    public void thePasswordChangeProcessRepeatsSuccessfully() {
        verifyPasswordChangeProcessRepeats();
    }

    @When("the user verifies the system logs for password change activity")
    public void theUserVerifiesTheSystemLogsForPasswordChangeActivity() {
        verifySystemLogsForPasswordChange();
    }

    @Then("the system logs show the password change activity")
    public void theSystemLogsShowThePasswordChangeActivity() {
        verifySystemLogsShowActivity();
    }

    @When("the user checks for any security alerts related to password change")
    public void theUserChecksForAnySecurityAlertsRelatedToPasswordChange() {
        checkSecurityAlertsForPasswordChange();
    }

    @Then("no security alerts are triggered")
    public void noSecurityAlertsAreTriggered() {
        verifyNoSecurityAlertsTriggered();
    }
}