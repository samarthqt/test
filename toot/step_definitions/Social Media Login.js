import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import SocialMediaLoginPage from "../pages/socialMediaLoginPage";

Given("the user is on the login page", () => {
 SocialMediaLoginPage.visit();
});

When("the user selects {string} login option", (platform) => {
 SocialMediaLoginPage.selectSocialMediaLogin(platform);
});

When("the user is redirected to {string} login page", (platform) => {
 SocialMediaLoginPage.verifyRedirection(platform);
});

When("the user enters valid {string} credentials", (platform) => {
 SocialMediaLoginPage.enterValidCredentials(platform);
});

When("the user enters invalid {string} credentials", (platform) => {
 SocialMediaLoginPage.enterInvalidCredentials(platform);
});

When("the user authorizes the application", () => {
 SocialMediaLoginPage.authorizeApplication();
});

When("the user denies the application authorization", () => {
 SocialMediaLoginPage.denyAuthorization();
});

Then("the user should be redirected to the home page", () => {
 SocialMediaLoginPage.verifyHomePageRedirection();
});

Then("the user should be logged in successfully", () => {
 SocialMediaLoginPage.verifySuccessfulLogin();
});

Then("the user should see an error message indicating invalid credentials", () => {
 SocialMediaLoginPage.verifyInvalidCredentialsError();
});

Then("the user should not be logged in", () => {
 SocialMediaLoginPage.verifyNotLoggedIn();
});

Then("the user should be redirected back to the login page", () => {
 SocialMediaLoginPage.verifyLoginPageRedirection();
});

When("the user looks for social media login options", () => {
 SocialMediaLoginPage.checkSocialMediaOptions();
});

Then("the user should see options for Facebook, Google, Twitter, and LinkedIn", () => {
 SocialMediaLoginPage.verifySocialMediaOptions();
});