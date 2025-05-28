import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ChatSupportPage from "../pages/chatSupportPage";

Given("the chat support system is operational", () => {
 ChatSupportPage.verifySystemOperational();
});

Given("the customer service representative is logged into the system", () => {
 ChatSupportPage.verifyRepresentativeLoggedIn();
});

Given("a customer navigates to the chat support page", () => {
 ChatSupportPage.visit();
});

When("the customer clicks on the \"Start Chat\" button", () => {
 ChatSupportPage.startChat();
});

Then("a new chat session should be initiated", () => {
 ChatSupportPage.verifyChatSessionInitiated();
});

Then("the customer should see a welcome message", () => {
 ChatSupportPage.verifyWelcomeMessage();
});

Given("a customer has initiated a chat session", () => {
 ChatSupportPage.verifyChatSessionInitiated();
});

When("the chat request is sent to the customer service representative", () => {
 ChatSupportPage.sendChatRequestToRepresentative();
});

Then("the representative should receive a notification of a new chat request", () => {
 ChatSupportPage.verifyNotificationReceived();
});

Then("the chat session should be displayed in the representative's chat interface", () => {
 ChatSupportPage.verifyChatSessionDisplayed();
});

Given("a chat session is active", () => {
 ChatSupportPage.verifyChatSessionActive();
});

When("the customer types a message and clicks \"Send\"", () => {
 ChatSupportPage.customerSendMessage();
});

Then("the message should appear in the chat window for both the customer and the representative", () => {
 ChatSupportPage.verifyMessageInChatWindow();
});

Given("the customer has sent a message", () => {
 ChatSupportPage.verifyCustomerMessageSent();
});

When("the representative types a response and clicks \"Send\"", () => {
 ChatSupportPage.representativeSendResponse();
});

Then("the response should appear in the chat window for both the representative and the customer", () => {
 ChatSupportPage.verifyResponseInChatWindow();
});

When("the customer clicks on the \"End Chat\" button", () => {
 ChatSupportPage.customerEndChat();
});

Then("the chat session should be terminated", () => {
 ChatSupportPage.verifyChatSessionTerminated();
});

Then("the customer should see a feedback form", () => {
 ChatSupportPage.verifyFeedbackFormDisplayed();
});

When("the representative clicks on the \"End Chat\" button", () => {
 ChatSupportPage.representativeEndChat();
});

Then("the representative should see a summary of the chat session", () => {
 ChatSupportPage.verifyChatSummaryDisplayed();
});

When("there is no activity from either the customer or representative for a predefined period", () => {
 ChatSupportPage.simulateInactivityTimeout();
});

Then("the chat session should automatically end", () => {
 ChatSupportPage.verifyChatSessionAutoEnded();
});

Then("both parties should receive a notification of the session timeout", () => {
 ChatSupportPage.verifyTimeoutNotification();
});