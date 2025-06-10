import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import SupportPage from "../pages/supportPage";

Given("a user is on the website or app", () => {
 SupportPage.visit();
});

When("the user accesses the live chat support feature", () => {
 SupportPage.accessLiveChat();
});

Then("the live chat support should be available for the user", () => {
 SupportPage.verifyLiveChatAvailability();
});

Given("a user has an inquiry or issue", () => {
 SupportPage.prepareInquiry();
});

When("the user sends a support inquiry via email", () => {
 SupportPage.sendEmailInquiry();
});

Then("the inquiry should be successfully sent to the support team", () => {
 SupportPage.verifyEmailSent();
});

Given("a chat or email inquiry is received by the system", () => {
 SupportPage.receiveInquiry();
});

When("the system processes the inquiry", () => {
 SupportPage.processInquiry();
});

Then("the inquiry should be routed to the appropriate support agent", () => {
 SupportPage.routeInquiry();
});

Given("a user has initiated a support interaction", () => {
 SupportPage.initiateSupportInteraction();
});

When("the system acknowledges the inquiry", () => {
 SupportPage.acknowledgeInquiry();
});

Then("the system should provide an estimated response time to the user", () => {
 SupportPage.provideResponseTimeEstimate();
});

Given("a support interaction has occurred", () => {
 SupportPage.supportInteractionOccurred();
});

When("the interaction is completed", () => {
 SupportPage.completeInteraction();
});

Then("the system should log the interaction for future reference", () => {
 SupportPage.logInteraction();
});

Given("an error occurs during a chat or email support interaction", () => {
 SupportPage.errorOccurs();
});

When("the system detects the error", () => {
 SupportPage.detectError();
});

Then("the system should handle the error gracefully and notify the user", () => {
 SupportPage.handleErrorGracefully();
});

Given("a user is using a desktop or mobile device", () => {
 SupportPage.userOnDevice();
});

When("the user accesses support features", () => {
 SupportPage.accessSupportFeatures();
});

Then("the support features should be accessible on both devices", () => {
 SupportPage.verifySupportFeaturesAccessibility();
});

Given("a user is engaged in a support interaction", () => {
 SupportPage.userEngagedInInteraction();
});

When("the interaction involves user data", () => {
 SupportPage.interactionInvolvesUserData();
});

Then("the system must ensure the privacy and security of the user's data", () => {
 SupportPage.ensureDataPrivacy();
});