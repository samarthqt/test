import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import LoginPage from "../pages/loginPage";

Given("the user is on the login page", () => {
 LoginPage.visit();
});

When("the user enters valid email {string} and password {string}", (email, password) => {
 LoginPage.enterEmail(email);
 LoginPage.enterPassword(password);
});

When("clicks on the 'Login' button", () => {
 LoginPage.submit();
});

Then("the user is successfully logged in and redirected to the homepage", () => {
 cy.url().should("include", "/homepage");
});

Given("the user is logged in", () => {
 LoginPage.ensureLoggedIn();
});

When("the user logs out from the application", () => {
 LoginPage.logout();
});

Then("the user is logged out and redirected to the login page", () => {
 cy.url().should("include", "/login");
});

When("the user clicks on the 'Login with Facebook' button", () => {
 LoginPage.clickLoginWithFacebook();
});

When("enters valid Facebook credentials", () => {
 LoginPage.enterFacebookCredentials();
});

When("authorizes the application", () => {
 LoginPage.authorizeFacebookApp();
});

Then("the user is logged in via Facebook and redirected to the homepage", () => {
 cy.url().should("include", "/homepage");
});

Given("the user is logged in via Facebook", () => {
 LoginPage.ensureLoggedInViaFacebook();
});

Then("the user profile information matches the data from the linked social media account", () => {
 LoginPage.verifyFacebookProfileInformation();
});

When("the user attempts to log in using Google account", () => {
 LoginPage.clickLoginWithGoogle();
});

Then("the user is redirected to Google login page and can log in successfully", () => {
 cy.url().should("include", "accounts.google.com");
});

When("the user enters incorrect email or password", () => {
 LoginPage.enterInvalidCredentials();
});

Then("an appropriate error message is displayed for incorrect login credentials", () => {
 LoginPage.verifyErrorMessage();
});

When("the user attempts to log in without entering any credentials", () => {
 LoginPage.submitWithoutCredentials();
});

Then("the system prompts the user to enter credentials", () => {
 LoginPage.verifyPromptForCredentials();
});

Given("the user is accessing the login page on a mobile device", () => {
 cy.viewport('iphone-6');
 LoginPage.visit();
});

Then("the login page is responsive and functions correctly on mobile devices", () => {
 LoginPage.verifyResponsiveDesign();
});

Given("multiple users attempt to log in concurrently", () => {
 LoginPage.simulateConcurrentLogins();
});

Then("the system handles multiple login attempts efficiently without downtime", () => {
 LoginPage.verifyConcurrentLoginHandling();
});

Given("the user is logged out", () => {
 LoginPage.ensureLoggedOut();
});

When("the user attempts to log in with Twitter account", () => {
 LoginPage.clickLoginWithTwitter();
});

Then("the user can log in successfully using Twitter credentials", () => {
 LoginPage.verifyTwitterLogin();
});

When("the user remains inactive for a defined period", () => {
 LoginPage.simulateInactivity();
});

Then("the user session expires", () => {
 LoginPage.verifySessionTimeout();
});

Then("the login page meets accessibility standards", () => {
 LoginPage.verifyAccessibilityCompliance();
});