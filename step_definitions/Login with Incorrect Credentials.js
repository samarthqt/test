import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import LoginPage from "../pages/loginPage";

Given("the user navigates to the login page", () => {
 LoginPage.visit();
});

When("the user enters a valid username {string} and an invalid password {string}", (username, password) => {
 LoginPage.enterUsername(username);
 LoginPage.enterPassword(password);
});

When("the user enters an invalid username and password", () => {
 LoginPage.enterUsername("invalid@example.com");
 LoginPage.enterPassword("invalidPassword");
});

When("the user leaves the username and password fields empty", () => {
 LoginPage.enterUsername("");
 LoginPage.enterPassword("");
});

When("the user enters a username with special characters", () => {
 LoginPage.enterUsername("user!@#$");
 LoginPage.enterPassword("password");
});

When("the user enters a valid username {string} and leaves the password field empty", (username) => {
 LoginPage.enterUsername(username);
 LoginPage.enterPassword("");
});

When("the user enters a valid username {string} and incorrect password multiple times", (username) => {
 for(let i = 0; i < 3; i++) {
 LoginPage.enterUsername(username);
 LoginPage.enterPassword("wrongPassword");
 LoginPage.submit();
 }
});

When("the user fails to login multiple times", () => {
 for(let i = 0; i < 3; i++) {
 LoginPage.enterUsername("user@example.com");
 LoginPage.enterPassword("wrongPassword");
 LoginPage.submit();
 }
});

When("the user enters a valid username {string} and a password exceeding maximum length", (username) => {
 LoginPage.enterUsername(username);
 LoginPage.enterPassword("aVeryLongPasswordExceedingTheMaxLength");
});

When("the user enters incorrect credentials from a different IP address", () => {
 LoginPage.enterUsername("wrongUser@example.com");
 LoginPage.enterPassword("wrongPassword");
});

When("the user enters credentials for an expired account", () => {
 LoginPage.enterUsername("expired@example.com");
 LoginPage.enterPassword("validPassword");
});

When("the user enters credentials for a deactivated account", () => {
 LoginPage.enterUsername("deactivated@example.com");
 LoginPage.enterPassword("validPassword");
});

When("the user enters incorrect credentials during system maintenance", () => {
 LoginPage.enterUsername("user@example.com");
 LoginPage.enterPassword("wrongPassword");
});

And("clicks on the 'Login' button", () => {
 LoginPage.submit();
});

Then("the system displays an error message indicating incorrect password", () => {
 LoginPage.verifyErrorMessage("Incorrect password");
});

Then("the system displays an error message indicating invalid credentials", () => {
 LoginPage.verifyErrorMessage("Invalid credentials");
});

Then("the system prompts to enter valid credentials", () => {
 LoginPage.verifyErrorMessage("Please enter valid credentials");
});

Then("the system displays an error message indicating invalid username format", () => {
 LoginPage.verifyErrorMessage("Invalid username format");
});

Then("the system prompts to enter a password", () => {
 LoginPage.verifyErrorMessage("Please enter a password");
});

Then("the system locks the account after several failed attempts", () => {
 LoginPage.verifyAccountLocked();
});

Then("the password recovery option is available", () => {
 LoginPage.verifyPasswordRecoveryOption();
});

Then("the system displays an error message indicating password length exceeded", () => {
 LoginPage.verifyErrorMessage("Password length exceeded");
});

Then("CAPTCHA is required after several failed login attempts", () => {
 LoginPage.verifyCaptchaRequired();
});

Then("the system displays an error message and logs the attempt", () => {
 LoginPage.verifyErrorMessage("Login attempt logged");
});

Then("the system displays an error message indicating account expiration", () => {
 LoginPage.verifyErrorMessage("Account expired");
});

Then("the system displays an error message indicating account deactivation", () => {
 LoginPage.verifyErrorMessage("Account deactivated");
});

Then("the system displays a maintenance notification and login is not possible", () => {
 LoginPage.verifyMaintenanceNotification();
});