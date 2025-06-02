import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import LoginPage from "../pages/loginPage";
import BackupCodePage from "../pages/backupCodePage";

Given("the user account exists", () => {
 // Implement account existence check
});

Given("2FA is enabled for the account", () => {
 // Implement 2FA enabled check
});

When("the user navigates to the login page", () => {
 LoginPage.visit();
});

Then("the user is directed to the login page", () => {
 cy.url().should("include", "/login");
});

Given("the user is on the login page", () => {
 LoginPage.visit();
});

When("the user enters valid username and password", () => {
 LoginPage.enterCredentials('username', 'password');
});

Then("the credentials are accepted", () => {
 cy.url().should("include", "/dashboard");
});

Given("the user has entered valid credentials", () => {
 LoginPage.enterCredentials('username', 'password');
});

When("the user attempts to login without 2FA code", () => {
 LoginPage.submitWithout2FA();
});

Then("the system prompts for 2FA code", () => {
 BackupCodePage.verify2FAPrompt();
});

Given("the system prompts for 2FA code", () => {
 BackupCodePage.verify2FAPrompt();
});

When("the user selects 'Use backup code' option", () => {
 BackupCodePage.selectUseBackupCode();
});

Then("the backup code entry field is displayed", () => {
 BackupCodePage.verifyBackupCodeField();
});

Given("the backup code entry field is displayed", () => {
 BackupCodePage.verifyBackupCodeField();
});

When("the user enters a valid backup code", () => {
 BackupCodePage.enterBackupCode('validBackupCode');
});

Then("the backup code is accepted", () => {
 BackupCodePage.verifyBackupCodeAccepted();
});

Given("the backup code is accepted", () => {
 BackupCodePage.verifyBackupCodeAccepted();
});

When("the user logs in using the backup code", () => {
 BackupCodePage.loginWithBackupCode();
});

Then("the user is logged in successfully", () => {
 cy.url().should("include", "/dashboard");
});

Given("the user has logged in successfully", () => {
 cy.url().should("include", "/dashboard");
});

When("the backup code is checked for usage", () => {
 BackupCodePage.checkBackupCodeUsage();
});

Then("the backup code is marked as used", () => {
 BackupCodePage.verifyBackupCodeUsed();
});

Given("the backup code is marked as used", () => {
 BackupCodePage.verifyBackupCodeUsed();
});

When("the user attempts login with an already used backup code", () => {
 BackupCodePage.enterBackupCode('usedBackupCode');
});

Then("an error message is displayed for used code", () => {
 BackupCodePage.verifyErrorMessageForUsedCode();
});

Given("there are unused backup codes", () => {
 BackupCodePage.verifyUnusedBackupCodes();
});

When("the user attempts login with an unused backup code", () => {
 BackupCodePage.enterBackupCode('unusedBackupCode');
});

Then("the unused codes are valid for login", () => {
 cy.url().should("include", "/dashboard");
});

Given("the user has used a backup code for login", () => {
 BackupCodePage.verifyBackupCodeUsed();
});

When("the system logs are checked", () => {
 BackupCodePage.checkSystemLogs();
});

Then("backup code usage events are logged", () => {
 BackupCodePage.verifyBackupCodeUsageLogged();
});

Given("the user has valid backup codes", () => {
 BackupCodePage.verifyUnusedBackupCodes();
});

When("the user attempts login on mobile and desktop devices", () => {
 BackupCodePage.loginOnMultipleDevices();
});

Then("login behavior is consistent across devices", () => {
 BackupCodePage.verifyConsistentLoginBehavior();
});

Given("all backup codes are used", () => {
 BackupCodePage.verifyAllBackupCodesUsed();
});

When("the user attempts to generate a new backup code", () => {
 BackupCodePage.generateNewBackupCode();
});

Then("the system prompts for new code generation", () => {
 BackupCodePage.verifyNewCodeGenerationPrompt();
});

Given("the user has attempted login with an invalid backup code", () => {
 BackupCodePage.enterBackupCode('invalidBackupCode');
});

When("the system prompts the user", () => {
 BackupCodePage.verifySystemPrompt();
});

Then("the user is directed to retry login with a valid backup code", () => {
 BackupCodePage.verifyRetryLoginPrompt();
});

Given("the user is attempting login", () => {
 LoginPage.visit();
});

When("the network conditions are stable", () => {
 BackupCodePage.verifyStableNetworkConditions();
});

Then("the system handles network conditions gracefully", () => {
 BackupCodePage.verifyNetworkHandling();
});

Given("the user is logged into their account", () => {
 cy.url().should("include", "/dashboard");
});

When("the user navigates to account settings", () => {
 BackupCodePage.navigateToAccountSettings();
});

Then("the user can view remaining backup codes", () => {
 BackupCodePage.verifyRemainingBackupCodes();
});