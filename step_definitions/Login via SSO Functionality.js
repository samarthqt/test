import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import LoginPage from "../pages/loginPage";

Given("I have access to the COCO application login screen", () => {
 LoginPage.visit();
});

When("I navigate to the COCO login screen", () => {
 LoginPage.verifyLoginScreenDisplayed();
});

Then("the login screen should be displayed", () => {
 LoginPage.checkLoginScreenVisibility();
});

And("SSO integration should be configured", () => {
 LoginPage.checkSSOConfiguration();
});

When("I click on the 'Login with SSO' button", () => {
 LoginPage.clickLoginWithSSO();
});

Then("I should be redirected to the SSO login page", () => {
 LoginPage.verifySSORedirection();
});

And("I enter valid SSO credentials", () => {
 LoginPage.enterSSOCredentials();
});

Then("the credentials should be accepted", () => {
 LoginPage.verifyCredentialsAccepted();
});

When("I submit the SSO login form", () => {
 LoginPage.submitSSOLoginForm();
});

Then("I should be logged into the COCO application successfully", () => {
 LoginPage.verifySuccessfulLogin();
});