package com.cucumber.steps;

import com.page_objects.AccountSettingsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ChangePasswordSteps extends AccountSettingsPage {

    @Given("the user is logged into their account")
    public void theUserIsLoggedIntoTheirAccount() {
        verifyUserLoggedIn();
    }

    @When("the user navigates to the account settings")
    public void theUserNavigatesToTheAccountSettings() {
        navigateToAccountSettings();
    }

    @When("the user enters the correct current password")
    public void theUserEntersTheCorrectCurrentPassword() {
        enterCurrentPassword(getCurrentPassword());
    }

    @When("the user enters a new password that meets complexity requirements")
    public void theUserEntersANewPasswordThatMeetsComplexityRequirements() {
        enterNewPassword(getNewPassword());
    }

    @When("the user confirms the new password")
    public void theUserConfirmsTheNewPassword() {
        confirmNewPassword(getNewPassword());
    }

    @Then("the system changes the password")
    public void theSystemChangesThePassword() {
        verifyPasswordChanged();
    }

    @Then("the user receives a confirmation message")
    public void theUserReceivesAConfirmationMessage() {
        verifyConfirmationMessage();
    }

    @Then("the password change request is logged for security auditing")
    public void thePasswordChangeRequestIsLoggedForSecurityAuditing() {
        verifyAuditLogEntry();
    }

    @When("the user enters an incorrect current password")
    public void theUserEntersAnIncorrectCurrentPassword() {
        enterCurrentPassword(getIncorrectPassword());
    }

    @Then("the system displays an error message")
    public void theSystemDisplaysAnErrorMessage() {
        verifyErrorMessage();
    }

    @Then("the password change request is not processed")
    public void thePasswordChangeRequestIsNotProcessed() {
        verifyNoPasswordChange();
    }

    @Given("the user has forgotten their password")
    public void theUserHasForgottenTheirPassword() {
        verifyForgottenPassword();
    }

    @When("the user navigates to the password reset page")
    public void theUserNavigatesToThePasswordResetPage() {
        navigateToPasswordResetPage();
    }

    @When("the user enters their email address")
    public void theUserEntersTheirEmailAddress() {
        enterEmailAddress(getEmailAddress());
    }

    @Then("the system sends a password reset link to the user's email")
    public void theSystemSendsAPasswordResetLinkToTheUsersEmail() {
        verifyPasswordResetLinkSent();
    }

    @Then("the user can set a new password using the reset link")
    public void theUserCanSetANewPasswordUsingTheResetLink() {
        verifyPasswordResetLinkUsage();
    }

    @Given("the user is changing their password")
    public void theUserIsChangingTheirPassword() {
        verifyPasswordChangeInitiated();
    }

    @Then("the system ensures the password change process complies with GDPR and other data protection regulations")
    public void theSystemEnsuresThePasswordChangeProcessCompliesWithGDPRAndOtherDataProtectionRegulations() {
        verifyGDPRCompliance();
    }
}