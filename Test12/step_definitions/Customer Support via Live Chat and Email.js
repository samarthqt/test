import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import SupportPage from "../pages/supportPage";

Given("the user is on the support page", () => {
 SupportPage.visit();
});

When("the user selects the live chat option", () => {
 SupportPage.selectLiveChat();
});

Then("the user should be able to access live chat support easily", () => {
 SupportPage.verifyLiveChatAccess();
});

When("the user selects the email support option", () => {
 SupportPage.selectEmailSupport();
});

Then("the user should be able to send detailed inquiries via email", () => {
 SupportPage.verifyEmailSupportAccess();
});

Given("a user interaction occurs through live chat or email", () => {
 SupportPage.initiateInteraction();
});

When("the interaction is completed", () => {
 SupportPage.completeInteraction();
});

Then("the interaction should be logged for quality assurance", () => {
 SupportPage.logInteraction();
});

Given("the user has submitted a support inquiry", () => {
 SupportPage.submitInquiry();
});

When("a support response is sent", () => {
 SupportPage.sendResponse();
});

Then("the user should receive a notification for the support response", () => {
 SupportPage.verifyNotification();
});

Given("a support interaction fails", () => {
 SupportPage.failInteraction();
});

When("the failure occurs", () => {
 SupportPage.triggerFailure();
});

Then("an error message should be displayed to the user", () => {
 SupportPage.displayErrorMessage();
});

When("the user interacts with the support interface", () => {
 SupportPage.interactWithInterface();
});

Then("the interface should be user-friendly and guide the user through the support process", () => {
 SupportPage.verifyUserFriendlyInterface();
});

Given("the application provides customer support", () => {
 SupportPage.provideSupport();
});

When("support interactions occur", () => {
 SupportPage.occurSupportInteractions();
});

Then("support should comply with data privacy and security standards", () => {
 SupportPage.verifyCompliance();
});

When("the user selects a language preference", () => {
 SupportPage.selectLanguagePreference();
});

Then("the application should support multi-language communication", () => {
 SupportPage.verifyMultiLanguageSupport();
});

Given("the user needs support", () => {
 SupportPage.needSupport();
});

When("the user attempts to access support", () => {
 SupportPage.attemptAccessSupport();
});

Then("support should be available during specified hours", () => {
 SupportPage.verifyAvailabilityHours();
});

Given("the user is interacting with support", () => {
 SupportPage.interactingWithSupport();
});

When("the user sends a request or inquiry", () => {
 SupportPage.sendRequestOrInquiry();
});

Then("support should be optimized for performance and responsiveness", () => {
 SupportPage.verifyPerformanceAndResponsiveness();
});