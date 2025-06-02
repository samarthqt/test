import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import AccountPage from "../pages/accountPage";
import LoginPage from "../pages/loginPage";

Given("I navigate to the account creation page", () => {
 AccountPage.visit();
});

Then("the account creation page is displayed with SSL/TLS encryption active", () => {
 cy.url().should("include", "https");
 cy.get('body').should('contain', 'Secure Connection');
});

Given("I am on the account creation page", () => {
 AccountPage.visit();
});

When("I enter a valid email {string} and password {string}", (email, password) => {
 AccountPage.enterEmail(email);
 AccountPage.enterPassword(password);
});

Then("the email and password fields are populated securely", () => {
 AccountPage.verifySecureFields();
});

Given("I have entered valid account creation details", () => {
 AccountPage.enterValidDetails();
});

When("I complete the account creation process", () => {
 AccountPage.submitAccountCreation();
});

Then("the account is created successfully with encrypted data", () => {
 AccountPage.verifyAccountCreationSuccess();
});

Given("I navigate to the login page", () => {
 LoginPage.visit();
});

Then("the login page is displayed with SSL/TLS encryption active", () => {
 cy.url().should("include", "https");
 cy.get('body').should('contain', 'Secure Connection');
});

Given("I am on the login page", () => {
 LoginPage.visit();
});

When("I enter valid login credentials", () => {
 LoginPage.enterLoginCredentials();
});

Then("the credentials are entered securely", () => {
 LoginPage.verifySecureCredentialsEntry();
});

Given("I have entered valid login credentials", () => {
 LoginPage.enterLoginCredentials();
});

When("I log in to the application", () => {
 LoginPage.submitLogin();
});

Then("the user is logged in successfully with encrypted data transmission", () => {
 LoginPage.verifySuccessfulLogin();
});

Given("I am logged into the application", () => {
 LoginPage.login();
});

When("I verify the encryption of data during login", () => {
 LoginPage.checkDataEncryption();
});

Then("the data is transmitted securely with encryption", () => {
 LoginPage.verifyDataTransmissionEncryption();
});

When("I attempt to login with an incorrect password", () => {
 LoginPage.enterIncorrectPassword();
});

Then("an error message is displayed with secure data handling", () => {
 LoginPage.verifyErrorMessage();
});

When("I check server logs for encrypted data transmission", () => {
 LoginPage.checkServerLogs();
});

Then("the server logs show encrypted data transmission during login", () => {
 LoginPage.verifyServerLogsEncryption();
});

When("I attempt account creation with a weak password", () => {
 AccountPage.enterWeakPassword();
});

Then("the system prompts for a stronger password", () => {
 AccountPage.verifyPasswordStrengthPrompt();
});

When("I verify encryption compliance with industry standards", () => {
 LoginPage.checkEncryptionCompliance();
});

Then("encryption meets industry standards for security", () => {
 LoginPage.verifyEncryptionStandards();
});

When("I check for security vulnerabilities in the login process", () => {
 LoginPage.checkSecurityVulnerabilities();
});

Then("no security vulnerabilities are detected in the login process", () => {
 LoginPage.verifyNoSecurityVulnerabilities();
});

When("I log out of the application", () => {
 LoginPage.logout();
});

Then("the logout process securely terminates the user session", () => {
 LoginPage.verifySecureLogout();
});

Given("I am on the login page on a different device", () => {
 LoginPage.visit();
});

When("I enter valid login credentials", () => {
 LoginPage.enterLoginCredentials();
});

Then("login is successful with secure data transmission", () => {
 LoginPage.verifySuccessfulLogin();
});

When("I check for security alerts during login attempts", () => {
 LoginPage.checkSecurityAlerts();
});

Then("security alerts are triggered for suspicious login attempts", () => {
 LoginPage.verifySecurityAlerts();
});