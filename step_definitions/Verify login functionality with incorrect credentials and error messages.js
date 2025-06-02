import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import LoginPage from "../pages/loginPage";

Given("the user navigates to the login page", () => {
 LoginPage.visit();
});

When("the user enters an email {string} and password {string}", (email, password) => {
 LoginPage.enterEmail(email);
 LoginPage.enterPassword(password);
});

When("the user enters a valid email and incorrect password {string}", (password) => {
 LoginPage.enterValidEmail();
 LoginPage.enterPassword(password);
});

When("the user enters an incorrect email {string} and correct password", (email) => {
 LoginPage.enterEmail(email);
 LoginPage.enterCorrectPassword();
});

When("the user leaves the email field empty", () => {
 LoginPage.leaveEmailEmpty();
});

When("the user leaves the password field empty", () => {
 LoginPage.leavePasswordEmpty();
});

When("the user enters incorrect credentials multiple times", () => {
 LoginPage.enterIncorrectCredentialsMultipleTimes();
});

When("the user attempts login with incorrect credentials multiple times", () => {
 LoginPage.attemptLoginMultipleTimes();
});

When("the user attempts login with incorrect credentials", () => {
 LoginPage.attemptIncorrectLogin();
});

When("the user enters valid credentials", () => {
 LoginPage.enterValidCredentials();
});

When("the user navigates to the login page on a mobile device", () => {
 LoginPage.visitMobile();
});

When("the user attempts login without internet connection", () => {
 LoginPage.attemptLoginWithoutInternet();
});

Then("the system displays an error message indicating incorrect credentials", () => {
 LoginPage.verifyErrorMessage("Incorrect credentials");
});

Then("the error message clearly states the reason for login failure", () => {
 LoginPage.verifyDetailedErrorMessage();
});

Then("the system displays an error message indicating incorrect password", () => {
 LoginPage.verifyErrorMessage("Incorrect password");
});

Then("the system displays an error message indicating incorrect email", () => {
 LoginPage.verifyErrorMessage("Incorrect email");
});

Then("the system prompts to enter email", () => {
 LoginPage.verifyErrorMessage("Please enter email");
});

Then("the system prompts to enter password", () => {
 LoginPage.verifyErrorMessage("Please enter password");
});

Then("the system displays consistent error messages for each attempt", () => {
 LoginPage.verifyConsistentErrorMessages();
});

Then("the system triggers security measures after several failed attempts", () => {
 LoginPage.verifySecurityMeasures();
});

Then("error messages are accessible and clearly visible", () => {
 LoginPage.verifyAccessibilityOfErrorMessages();
});

Then("the user is able to log in successfully with correct credentials", () => {
 LoginPage.verifySuccessfulLogin();
});

Then("error messages are displayed correctly on mobile devices", () => {
 LoginPage.verifyMobileErrorMessages();
});

Then("the system displays an error message indicating network issue", () => {
 LoginPage.verifyErrorMessage("Network issue");
});

Then("system logs contain records of failed login attempts", () => {
 LoginPage.verifySystemLogs();
});