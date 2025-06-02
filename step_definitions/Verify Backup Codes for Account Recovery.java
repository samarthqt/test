package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.BackupCodePage;

public class BackupCodeSteps extends BackupCodePage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user account exists")
    public void theUserAccountExists() {
        verifyUserAccountExists();
    }

    @Given("2FA is enabled for the account")
    public void twoFAIsEnabledForTheAccount() {
        verifyTwoFAEnabled();
    }

    @When("the user navigates to the login page")
    public void theUserNavigatesToTheLoginPage() {
        navigateToLoginPage();
    }

    @Then("the user is directed to the login page")
    public void theUserIsDirectedToTheLoginPage() {
        verifyLoginPageRedirection();
    }

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        verifyUserOnLoginPage();
    }

    @When("the user enters valid username and password")
    public void theUserEntersValidUsernameAndPassword() {
        enterValidCredentials();
    }

    @Then("the credentials are accepted")
    public void theCredentialsAreAccepted() {
        verifyCredentialsAccepted();
    }

    @Given("the user has entered valid credentials")
    public void theUserHasEnteredValidCredentials() {
        verifyValidCredentialsEntered();
    }

    @When("the user attempts to login without 2FA code")
    public void theUserAttemptsToLoginWithout2FACode() {
        attemptLoginWithout2FACode();
    }

    @Then("the system prompts for 2FA code")
    public void theSystemPromptsFor2FACode() {
        verify2FACodePrompt();
    }

    @Given("the system prompts for 2FA code")
    public void theSystemPromptsFor2FACodeAgain() {
        verify2FACodePrompt();
    }

    @When("the user selects 'Use backup code' option")
    public void theUserSelectsUseBackupCodeOption() {
        selectUseBackupCodeOption();
    }

    @Then("the backup code entry field is displayed")
    public void theBackupCodeEntryFieldIsDisplayed() {
        verifyBackupCodeEntryFieldDisplayed();
    }

    @Given("the backup code entry field is displayed")
    public void theBackupCodeEntryFieldIsDisplayedAgain() {
        verifyBackupCodeEntryFieldDisplayed();
    }

    @When("the user enters a valid backup code")
    public void theUserEntersAValidBackupCode() {
        enterValidBackupCode();
    }

    @Then("the backup code is accepted")
    public void theBackupCodeIsAccepted() {
        verifyBackupCodeAccepted();
    }

    @Given("the backup code is accepted")
    public void theBackupCodeIsAcceptedAgain() {
        verifyBackupCodeAccepted();
    }

    @When("the user logs in using the backup code")
    public void theUserLogsInUsingTheBackupCode() {
        loginUsingBackupCode();
    }

    @Then("the user is logged in successfully")
    public void theUserIsLoggedInSuccessfully() {
        verifySuccessfulLogin();
    }

    @Given("the user has logged in successfully")
    public void theUserHasLoggedInSuccessfully() {
        verifySuccessfulLogin();
    }

    @When("the backup code is checked for usage")
    public void theBackupCodeIsCheckedForUsage() {
        checkBackupCodeUsage();
    }

    @Then("the backup code is marked as used")
    public void theBackupCodeIsMarkedAsUsed() {
        verifyBackupCodeMarkedAsUsed();
    }

    @Given("the backup code is marked as used")
    public void theBackupCodeIsMarkedAsUsedAgain() {
        verifyBackupCodeMarkedAsUsed();
    }

    @When("the user attempts login with an already used backup code")
    public void theUserAttemptsLoginWithAnAlreadyUsedBackupCode() {
        attemptLoginWithUsedBackupCode();
    }

    @Then("an error message is displayed for used code")
    public void anErrorMessageIsDisplayedForUsedCode() {
        verifyErrorMessageForUsedCode();
    }

    @Given("there are unused backup codes")
    public void thereAreUnusedBackupCodes() {
        verifyUnusedBackupCodesExist();
    }

    @When("the user attempts login with an unused backup code")
    public void theUserAttemptsLoginWithAnUnusedBackupCode() {
        attemptLoginWithUnusedBackupCode();
    }

    @Then("the unused codes are valid for login")
    public void theUnusedCodesAreValidForLogin() {
        verifyUnusedCodesValidForLogin();
    }

    @Given("the user has used a backup code for login")
    public void theUserHasUsedABackupCodeForLogin() {
        verifyBackupCodeUsedForLogin();
    }

    @When("the system logs are checked")
    public void theSystemLogsAreChecked() {
        checkSystemLogs();
    }

    @Then("backup code usage events are logged")
    public void backupCodeUsageEventsAreLogged() {
        verifyBackupCodeUsageLogged();
    }

    @Given("the user has valid backup codes")
    public void theUserHasValidBackupCodes() {
        verifyValidBackupCodesExist();
    }

    @When("the user attempts login on mobile and desktop devices")
    public void theUserAttemptsLoginOnMobileAndDesktopDevices() {
        attemptLoginOnMultipleDevices();
    }

    @Then("login behavior is consistent across devices")
    public void loginBehaviorIsConsistentAcrossDevices() {
        verifyConsistentLoginBehavior();
    }

    @Given("all backup codes are used")
    public void allBackupCodesAreUsed() {
        verifyAllBackupCodesUsed();
    }

    @When("the user attempts to generate a new backup code")
    public void theUserAttemptsToGenerateANewBackupCode() {
        attemptNewBackupCodeGeneration();
    }

    @Then("the system prompts for new code generation")
    public void theSystemPromptsForNewCodeGeneration() {
        verifyNewCodeGenerationPrompt();
    }

    @Given("the user has attempted login with an invalid backup code")
    public void theUserHasAttemptedLoginWithAnInvalidBackupCode() {
        verifyInvalidBackupCodeAttempt();
    }

    @When("the system prompts the user")
    public void theSystemPromptsTheUser() {
        verifySystemPrompt();
    }

    @Then("the user is directed to retry login with a valid backup code")
    public void theUserIsDirectedToRetryLoginWithAValidBackupCode() {
        verifyRetryLoginWithValidBackupCode();
    }

    @Given("the user is attempting login")
    public void theUserIsAttemptingLogin() {
        verifyUserAttemptingLogin();
    }

    @When("the network conditions are stable")
    public void theNetworkConditionsAreStable() {
        verifyStableNetworkConditions();
    }

    @Then("the system handles network conditions gracefully")
    public void theSystemHandlesNetworkConditionsGracefully() {
        verifyGracefulNetworkHandling();
    }

    @Given("the user is logged into their account")
    public void theUserIsLoggedIntoTheirAccount() {
        verifyUserLoggedIntoAccount();
    }

    @When("the user navigates to account settings")
    public void theUserNavigatesToAccountSettings() {
        navigateToAccountSettings();
    }

    @Then("the user can view remaining backup codes")
    public void theUserCanViewRemainingBackupCodes() {
        verifyRemainingBackupCodesVisible();
    }
}