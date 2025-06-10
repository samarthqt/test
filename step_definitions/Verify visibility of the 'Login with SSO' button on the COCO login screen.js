import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CocoLoginPage from "../pages/cocoLoginPage";

Given("I have access to the COCO application login screen", () => {
 // Assume access is granted
});

When("I navigate to the COCO login screen", () => {
 CocoLoginPage.visit();
});

Then("the login screen is displayed", () => {
 CocoLoginPage.verifyLoginScreenDisplayed();
});

Then("'Login with SSO' button is visible on the login screen", () => {
 CocoLoginPage.verifySSOButtonVisible();
});