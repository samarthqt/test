import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import LoginPage from "../pages/loginPage";

Given("the user is on the login page", () => {
 LoginPage.visit();
});

When("the user enters a valid email {string} and password {string}", (email, password) => {
 LoginPage.enterEmail(email);
 LoginPage.enterPassword(password);
});

When("the user enters an invalid email {string} and a valid password {string}", (email, password) => {
 LoginPage.enterEmail(email);
 LoginPage.enterPassword(password);
});

When("the user enters a valid email {string} and an invalid password {string}", (email, password) => {
 LoginPage.enterEmail(email);
 LoginPage.enterPassword(password);
});

When("the user leaves the email and password fields empty", () => {
 LoginPage.clearEmail();
 LoginPage.clearPassword();
});

When("the user leaves the email field empty and enters a valid password {string}", (password) => {
 LoginPage.clearEmail();
 LoginPage.enterPassword(password);
});

When("the user enters a valid email {string} and leaves the password field empty", (email) => {
 LoginPage.enterEmail(email);
 LoginPage.clearPassword();
});

When("the user enters a password {string}", (password) => {
 LoginPage.enterPassword(password);
});

When("the user clicks the password visibility toggle", () => {
 LoginPage.togglePasswordVisibility();
});

When("the user clicks the password visibility toggle again", () => {
 LoginPage.togglePasswordVisibility();
});

When("the user selects the {string} checkbox", (checkbox) => {
 LoginPage.selectCheckbox(checkbox);
});

When("the user clicks on the {string} link", (link) => {
 LoginPage.clickLink(link);
});

When("clicks the login button", () => {
 LoginPage.submit();
});

Then("the user should be redirected to the account dashboard", () => {
 cy.url().should("include", "/dashboard");
});

Then("an error message should be displayed indicating invalid email or password", () => {
 LoginPage.verifyErrorMessage("Invalid email or password");
});

Then("an error message should be displayed indicating that email and password are required", () => {
 LoginPage.verifyErrorMessage("Email and password are required");
});

Then("an error message should be displayed indicating that email is required", () => {
 LoginPage.verifyErrorMessage("Email is required");
});

Then("an error message should be displayed indicating that password is required", () => {
 LoginPage.verifyErrorMessage("Password is required");
});

Then("the password should be visible in plain text", () => {
 LoginPage.verifyPasswordVisibility(true);
});

Then("the password should be hidden", () => {
 LoginPage.verifyPasswordVisibility(false);
});

Then("the user's email should be remembered on the login page upon logout", () => {
 LoginPage.verifyRememberedEmail();
});

Then("the user should be redirected to the password reset page", () => {
 cy.url().should("include", "/password-reset");
});