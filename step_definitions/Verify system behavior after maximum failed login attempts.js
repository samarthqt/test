import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import LoginPage from "../pages/loginPage";
import AdminPage from "../pages/adminPage";

Given("the user account {string} exists in the system", (username) => {
 // Assume a function that verifies user existence in the system
 cy.verifyUserExists(username);
});

Given("the maximum failed login attempts limit is configured to {int}", (limit) => {
 // Assume a function that sets maximum login attempts
 cy.setMaxLoginAttempts(limit);
});

When("the user opens the login page", () => {
 LoginPage.visit();
});

Then("the login page is displayed", () => {
 LoginPage.verifyPageDisplayed();
});

Given("the username {string}", (username) => {
 LoginPage.setUsername(username);
});

Given("the password {string}", (password) => {
 LoginPage.setPassword(password);
});

When("the user enters the username {string}", (username) => {
 LoginPage.enterUsername(username);
});

When("enters the password {string}", (password) => {
 LoginPage.enterPassword(password);
});

When("clicks the {string} button", (buttonName) => {
 LoginPage.clickButton(buttonName);
});

Then("the system displays an error message indicating incorrect credentials", () => {
 LoginPage.verifyErrorMessage("Incorrect credentials");
});

When("the user repeats the login attempt {int} times", (times) => {
 for (let i = 0; i < times; i++) {
 LoginPage.enterUsername("test_user");
 LoginPage.enterPassword("incorrect_password");
 LoginPage.submit();
 }
});

Then("the system locks the user account after the fifth attempt", () => {
 LoginPage.verifyAccountLocked();
});

Given("the user account is locked", () => {
 LoginPage.verifyAccountLocked();
});

When("the user attempts to login using correct credentials", () => {
 LoginPage.enterUsername("test_user");
 LoginPage.enterPassword("correct_password");
 LoginPage.submit();
});

Then("the system displays a message indicating the account is locked", () => {
 LoginPage.verifyAccountLockedMessage();
});

When("the admin checks the account status in the admin panel", () => {
 AdminPage.checkAccountStatus("test_user");
});

Then("the account is marked as locked", () => {
 AdminPage.verifyAccountMarkedLocked("test_user");
});

When("the user requests password recovery for the locked account", () => {
 LoginPage.requestPasswordRecovery("test_user");
});

Then("the system sends a recovery email to the user", () => {
 LoginPage.verifyRecoveryEmailSent();
});

Given("the user has received a recovery email", () => {
 LoginPage.verifyRecoveryEmailReceived();
});

When("the user attempts to unlock the account using recovery options", () => {
 LoginPage.useRecoveryOptionsToUnlock();
});

Then("the account is unlocked and the user can log in successfully", () => {
 LoginPage.verifyAccountUnlocked();
});

Given("the user account was locked after 5 failed attempts", () => {
 LoginPage.verifyAccountLockedAfterAttempts(5);
});

When("the admin verifies login attempt logs in the system", () => {
 AdminPage.verifyLoginAttemptLogs("test_user");
});

Then("logs show 5 failed attempts followed by account lock", () => {
 AdminPage.verifyLogsShowFailedAttemptsAndLock(5);
});

When("the system sends notification of account lock to the user", () => {
 LoginPage.sendAccountLockNotification("test_user");
});

Then("the user receives the account lock notification", () => {
 LoginPage.verifyAccountLockNotificationReceived();
});

Given("the user has successfully recovered the account", () => {
 LoginPage.verifyAccountRecovered();
});

When("the admin verifies the account status change", () => {
 AdminPage.verifyAccountStatusChange("test_user");
});

Then("the account status is updated to active", () => {
 AdminPage.verifyAccountStatusUpdatedToActive("test_user");
});

Given("the user account is unlocked", () => {
 LoginPage.verifyAccountUnlocked();
});

When("the user attempts login with incorrect credentials", () => {
 LoginPage.enterUsername("test_user");
 LoginPage.enterPassword("wrong_password");
 LoginPage.submit();
});

Then("the system displays incorrect credentials message", () => {
 LoginPage.verifyErrorMessage("Incorrect credentials");
});

Given("multiple users attempt to login with incorrect credentials concurrently", () => {
 LoginPage.simulateConcurrentLoginAttempts();
});

When("the system verifies login attempts", () => {
 LoginPage.verifyConcurrentLoginAttempts();
});

Then("the system locks account after reaching maximum attempts", () => {
 LoginPage.verifyAccountLockAfterMaxAttempts();
});

Given("multiple users attempted to login concurrently", () => {
 LoginPage.simulateConcurrentLoginAttempts();
});

When("the admin checks system logs for concurrent login attempts", () => {
 AdminPage.checkConcurrentLoginLogs();
});

Then("logs accurately reflect concurrent failed attempts", () => {
 AdminPage.verifyConcurrentLoginLogs();
});