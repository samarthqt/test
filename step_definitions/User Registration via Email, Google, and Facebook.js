import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import RegistrationPage from "../pages/registrationPage";
import HomePage from "../pages/homePage";
import LoginPage from "../pages/loginPage";

Given("I navigate to the registration page", () => {
  RegistrationPage.visit();
});

When("I enter email {string} and password {string} in the registration form", (email, password) => {
  RegistrationPage.enterEmail(email);
  RegistrationPage.enterPassword(password);
});

When("I submit the registration form", () => {
  RegistrationPage.submitForm();
});

Then("the user is registered successfully and redirected to the home page", () => {
  HomePage.verifyHomePage();
});

Given("I am logged in", () => {
  HomePage.verifyUserLoggedIn();
});

When("I log out", () => {
  HomePage.logout();
});

When("I navigate back to the registration page", () => {
  RegistrationPage.visit();
});

Then("the registration page is displayed again", () => {
  RegistrationPage.verifyPage();
});

When("I select {string}", (method) => {
  RegistrationPage.selectRegistrationMethod(method);
});

When("I enter Google account credentials and submit", () => {
  RegistrationPage.enterGoogleCredentials();
  RegistrationPage.submitForm();
});

Given("I am logged in with Google account", () => {
  HomePage.verifyUserLoggedInWithGoogle();
});

When("I enter Facebook account credentials and submit", () => {
  RegistrationPage.enterFacebookCredentials();
  RegistrationPage.submitForm();
});

Given("I have registered with email {string}", (email) => {
  RegistrationPage.verifyEmailRegistered(email);
});

When("I log in with email {string} and password {string}", (email, password) => {
  LoginPage.loginWithEmail(email, password);
});

Then("the user logs in successfully and is redirected to the home page", () => {
  HomePage.verifyHomePage();
});

Given("I have registered with Google account", () => {
  RegistrationPage.verifyGoogleRegistered();
});

When("I log in with Google credentials", () => {
  LoginPage.loginWithGoogle();
});

Given("I have registered with Facebook account", () => {
  RegistrationPage.verifyFacebookRegistered();
});

When("I log in with Facebook credentials", () => {
  LoginPage.loginWithFacebook();
});

Given("registration has occurred", () => {
  RegistrationPage.verifyRegistrationOccurred();
});

When("I check the system logs", () => {
  RegistrationPage.checkSystemLogs();
});

Then("no errors should be present in the logs", () => {
  RegistrationPage.verifyNoErrorsInLogs();
});

Given("I am registering a user", () => {
  RegistrationPage.startRegistration();
});

When("I complete the registration process", () => {
  RegistrationPage.completeRegistration();
});

Then("user receives clear feedback messages about registration status", () => {
  RegistrationPage.verifyFeedbackMessages();
});

When("I perform regular system operations", () => {
  RegistrationPage.performSystemOperations();
});

Then("the system should be stable and responsive", () => {
  RegistrationPage.verifySystemStability();
});