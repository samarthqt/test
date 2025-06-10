import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import LiveChatPage from "../pages/liveChatPage";

Given("the user is on the {string} platform", (platform) => {
 LiveChatPage.visitPlatform(platform);
});

When("the user navigates to the customer support section", () => {
 LiveChatPage.navigateToSupportSection();
});

Then("the user should see the live chat option", () => {
 LiveChatPage.verifyLiveChatOption();
});

Given("the current time is within specified support hours", () => {
 LiveChatPage.verifySupportHours();
});

When("the user accesses the live chat feature", () => {
 LiveChatPage.accessLiveChat();
});

Then("the live chat should be available", () => {
 LiveChatPage.verifyLiveChatAvailability();
});

Given("the user has initiated a live chat", () => {
 LiveChatPage.initiateLiveChat();
});

When("the communication is ongoing", () => {
 LiveChatPage.ongoingCommunication();
});

Then("the system should ensure secure and private communication", () => {
 LiveChatPage.verifySecureCommunication();
});

Given("the user sends a chat request", () => {
 LiveChatPage.sendChatRequest();
});

When("the request is received by the system", () => {
 LiveChatPage.receiveChatRequest();
});

Then("the user should receive immediate acknowledgment", () => {
 LiveChatPage.verifyImmediateAcknowledgment();
});

Given("the user has previously engaged in live chat", () => {
 LiveChatPage.previousChatEngagement();
});

When("the user navigates to the chat history section", () => {
 LiveChatPage.navigateToChatHistory();
});

Then("the user should be able to access past chat history", () => {
 LiveChatPage.verifyChatHistoryAccess();
});

Given("the user is engaged in a live chat session", () => {
 LiveChatPage.engagedInChatSession();
});

When("a connection error occurs", () => {
 LiveChatPage.simulateConnectionError();
});

Then("the system should handle the error gracefully", () => {
 LiveChatPage.handleConnectionError();
});

Given("the user asks a common query in live chat", () => {
 LiveChatPage.askCommonQuery();
});

When("the query is recognized by the system", () => {
 LiveChatPage.recognizeQuery();
});

Then("the system should provide an automated response", () => {
 LiveChatPage.provideAutomatedResponse();
});

Given("the live chat requires escalation", () => {
 LiveChatPage.requireEscalation();
});

When("the escalation is initiated", () => {
 LiveChatPage.initiateEscalation();
});

Then("the integration with the support ticketing system should be seamless", () => {
 LiveChatPage.verifySeamlessIntegration();
});