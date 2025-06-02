package com.cucumber.steps;

import com.page_objects.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends LoginPage {

    @Given("the user account {string} exists in the system")
    public void theUserAccountExistsInTheSystem(String username) {
        verifyUserAccountExists(username);
    }

    @Given("the maximum failed login attempts limit is configured to {int}")
    public void theMaximumFailedLoginAttemptsLimitIsConfiguredTo(int limit) {
        configureMaxFailedAttempts(limit);
    }

    @When("the user opens the login page")
    public void theUserOpensTheLoginPage() {
        openLoginPage();
    }

    @Then("the login page is displayed")
    public void theLoginPageIsDisplayed() {
        verifyLoginPageDisplayed();
    }

    @Given("the username {string}")
    public void theUsername(String username) {
        setUsername(username);
    }

    @Given("the password {string}")
    public void thePassword(String password) {
        setPassword(password);
    }

    @When("the user enters the username {string}")
    public void theUserEntersTheUsername(String username) {
        enterUserName(username);
    }

    @When("enters the password {string}")
    public void entersThePassword(String password) {
        enterPassword(password);
    }

    @When("clicks the {string} button")
    public void clicksTheButton(String buttonName) {
        clickLoginButton();
    }

    @Then("the system displays an error message indicating incorrect credentials")
    public void theSystemDisplaysAnErrorMessageIndicatingIncorrectCredentials() {
        verifyErrorMessageDisplayed();
    }

    @When("the user repeats the login attempt {int} times")
    public void theUserRepeatsTheLoginAttemptTimes(int attempts) {
        repeatLoginAttempts(attempts);
    }

    @Then("the system locks the user account after the fifth attempt")
    public void theSystemLocksTheUserAccountAfterTheFifthAttempt() {
        verifyAccountLocked();
    }

    @Given("the user account is locked")
    public void theUserAccountIsLocked() {
        verifyAccountLocked();
    }

    @When("the user attempts to login using correct credentials")
    public void theUserAttemptsToLoginUsingCorrectCredentials() {
        attemptLoginWithCorrectCredentials();
    }

    @Then("the system displays a message indicating the account is locked")
    public void theSystemDisplaysAMessageIndicatingTheAccountIsLocked() {
        verifyAccountLockedMessage();
    }

    @When("the admin checks the account status in the admin panel")
    public void theAdminChecksTheAccountStatusInTheAdminPanel() {
        checkAccountStatusInAdminPanel();
    }

    @Then("the account is marked as locked")
    public void theAccountIsMarkedAsLocked() {
        verifyAccountMarkedLocked();
    }

    @When("the user requests password recovery for the locked account")
    public void theUserRequestsPasswordRecoveryForTheLockedAccount() {
        requestPasswordRecovery();
    }

    @Then("the system sends a recovery email to the user")
    public void theSystemSendsARecoveryEmailToTheUser() {
        verifyRecoveryEmailSent();
    }

    @Given("the user has received a recovery email")
    public void theUserHasReceivedARecoveryEmail() {
        verifyRecoveryEmailReceived();
    }

    @When("the user attempts to unlock the account using recovery options")
    public void theUserAttemptsToUnlockTheAccountUsingRecoveryOptions() {
        unlockAccountUsingRecoveryOptions();
    }

    @Then("the account is unlocked and the user can log in successfully")
    public void theAccountIsUnlockedAndTheUserCanLogInSuccessfully() {
        verifyAccountUnlocked();
    }

    @Given("the user account was locked after {int} failed attempts")
    public void theUserAccountWasLockedAfterFailedAttempts(int attempts) {
        verifyAccountLockedAfterFailedAttempts(attempts);
    }

    @When("the admin verifies login attempt logs in the system")
    public void theAdminVerifiesLoginAttemptLogsInTheSystem() {
        verifyLoginAttemptLogs();
    }

    @Then("logs show {int} failed attempts followed by account lock")
    public void logsShowFailedAttemptsFollowedByAccountLock(int attempts) {
        verifyLogsShowFailedAttempts(attempts);
    }

    @When("the system sends notification of account lock to the user")
    public void theSystemSendsNotificationOfAccountLockToTheUser() {
        sendAccountLockNotification();
    }

    @Then("the user receives the account lock notification")
    public void theUserReceivesTheAccountLockNotification() {
        verifyAccountLockNotificationReceived();
    }

    @Given("the user has successfully recovered the account")
    public void theUserHasSuccessfullyRecoveredTheAccount() {
        verifyAccountRecoverySuccess();
    }

    @When("the admin verifies the account status change")
    public void theAdminVerifiesTheAccountStatusChange() {
        verifyAccountStatusChange();
    }

    @Then("the account status is updated to active")
    public void theAccountStatusIsUpdatedToActive() {
        verifyAccountStatusActive();
    }

    @Given("the user account is unlocked")
    public void theUserAccountIsUnlocked() {
        verifyAccountUnlocked();
    }

    @When("the user attempts login with incorrect credentials")
    public void theUserAttemptsLoginWithIncorrectCredentials() {
        attemptLoginWithIncorrectCredentials();
    }

    @Then("the system displays incorrect credentials message")
    public void theSystemDisplaysIncorrectCredentialsMessage() {
        verifyIncorrectCredentialsMessage();
    }

    @Given("multiple users attempt to login with incorrect credentials concurrently")
    public void multipleUsersAttemptToLoginWithIncorrectCredentialsConcurrently() {
        simulateConcurrentLoginAttempts();
    }

    @When("the system verifies login attempts")
    public void theSystemVerifiesLoginAttempts() {
        verifyConcurrentLoginAttempts();
    }

    @Then("the system locks account after reaching maximum attempts")
    public void theSystemLocksAccountAfterReachingMaximumAttempts() {
        verifyAccountLockAfterMaxAttempts();
    }

    @Given("multiple users attempted to login concurrently")
    public void multipleUsersAttemptedToLoginConcurrently() {
        verifyConcurrentLoginAttemptsOccurred();
    }

    @When("the admin checks system logs for concurrent login attempts")
    public void theAdminChecksSystemLogsForConcurrentLoginAttempts() {
        checkSystemLogsForConcurrentAttempts();
    }

    @Then("logs accurately reflect concurrent failed attempts")
    public void logsAccuratelyReflectConcurrentFailedAttempts() {
        verifyLogsReflectConcurrentAttempts();
    }
}