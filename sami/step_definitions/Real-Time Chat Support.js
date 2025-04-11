import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import ChatPage from '../pageObjects/ChatPage';

const chatPage = new ChatPage();

Given('the chat support system is operational', () => {
  chatPage.verifyChatSystemOperational();
});

Given('the customer service representative is logged into the system', () => {
  chatPage.verifyRepresentativeLoggedIn();
});

Given('a customer navigates to the chat support page', () => {
  chatPage.navigateToChatSupportPage();
});

When('the customer clicks on the "Start Chat" button', () => {
  chatPage.clickStartChatButton();
});

Then('a new chat session should be initiated', () => {
  chatPage.verifyChatSessionInitiated();
});

Then('the customer should see a welcome message', () => {
  chatPage.verifyWelcomeMessage();
});

Given('a customer has initiated a chat session', () => {
  chatPage.initiateChatSession();
});

When('the chat request is sent to the customer service representative', () => {
  chatPage.sendChatRequestToRepresentative();
});

Then('the representative should receive a notification of a new chat request', () => {
  chatPage.verifyRepresentativeNotification();
});

Then('the chat session should be displayed in the representative's chat interface', () => {
  chatPage.verifyChatDisplayedInInterface();
});

Given('a chat session is active', () => {
  chatPage.verifyChatSessionActive();
});

When('the customer types a message and clicks "Send"', () => {
  chatPage.customerSendMessage();
});

Then('the message should appear in the chat window for both the customer and the representative', () => {
  chatPage.verifyMessageInChatWindow();
});

Given('the customer has sent a message', () => {
  chatPage.verifyCustomerSentMessage();
});

When('the representative types a response and clicks "Send"', () => {
  chatPage.representativeSendMessage();
});

Then('the response should appear in the chat window for both the representative and the customer', () => {
  chatPage.verifyResponseInChatWindow();
});

When('the customer clicks on the "End Chat" button', () => {
  chatPage.clickEndChatButton();
});

Then('the chat session should be terminated', () => {
  chatPage.verifyChatSessionTerminated();
});

Then('the customer should see a feedback form', () => {
  chatPage.verifyFeedbackFormDisplayed();
});

When('the representative clicks on the "End Chat" button', () => {
  chatPage.representativeEndChat();
});

Then('the representative should see a summary of the chat session', () => {
  chatPage.verifyChatSummaryDisplayed();
});

When('there is no activity from either the customer or representative for a predefined period', () => {
  chatPage.waitForInactivityTimeout();
});

Then('the chat session should automatically end', () => {
  chatPage.verifyChatSessionAutoEnded();
});

Then('both parties should receive a notification of the session timeout', () => {
  chatPage.verifySessionTimeoutNotification();
});