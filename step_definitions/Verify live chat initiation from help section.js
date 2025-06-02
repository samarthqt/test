import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import LiveChatPage from "../pages/liveChatPage";

Given("user account with valid credentials", () => {
 // Assume user credentials are already set in environment variables
});

Given("user ID is {int}", (userID) => {
 // Use userID as needed in tests
});

When("user logs into the system on web platform", () => {
 LiveChatPage.loginWeb();
});

Then("user successfully logs into the system", () => {
 LiveChatPage.verifyLogin();
});

When("user navigates to the 'Help' section", () => {
 LiveChatPage.navigateToHelp();
});

Then("help section is displayed with various support options", () => {
 LiveChatPage.verifyHelpSection();
});

When("user clicks on 'Live Chat' option", () => {
 LiveChatPage.clickLiveChat();
});

Then("live chat window opens with greeting message", () => {
 LiveChatPage.verifyLiveChatWindow();
});

Then("chat availability is 24/7", () => {
 LiveChatPage.verifyChatAvailability();
});

When("user initiates a chat by typing a message", () => {
 LiveChatPage.initiateChat();
});

Then("message is sent and received by support agent", () => {
 LiveChatPage.verifyMessageSent();
});

Then("user receives a response from the support agent within expected time frame", () => {
 LiveChatPage.verifyAgentResponse();
});

When("user logs out from the web platform", () => {
 LiveChatPage.logoutWeb();
});

Then("user successfully logs out from the web platform", () => {
 LiveChatPage.verifyLogout();
});

When("user logs into the system on mobile platform", () => {
 LiveChatPage.loginMobile();
});

Then("user navigates to the 'Contact Us' page", () => {
 LiveChatPage.navigateToContactUs();
});

Then("contact us page is displayed with support options", () => {
 LiveChatPage.verifyContactUsPage();
});

When("user selects 'Live Chat' option", () => {
 LiveChatPage.selectLiveChatMobile();
});

Then("live chat window opens on mobile with greeting message", () => {
 LiveChatPage.verifyLiveChatMobile();
});

Given("user has initiated and received responses from live chat on both web and mobile platforms", () => {
 // Assume chat history is already populated
});

When("user checks chat history for both platforms", () => {
 LiveChatPage.checkChatHistory();
});

Then("chat history is consistent across web and mobile", () => {
 LiveChatPage.verifyChatHistoryConsistency();
});

Given("user is in varying network conditions", () => {
 // Simulate network conditions if possible
});

When("user initiates a live chat", () => {
 LiveChatPage.initiateChat();
});

Then("chat remains functional under varying network conditions", () => {
 LiveChatPage.verifyChatFunctionalityUnderNetworkConditions();
});

Given("user has initiated a chat", () => {
 // Assume chat initiation is already done
});

When("user verifies system logs", () => {
 LiveChatPage.verifySystemLogs();
});

Then("logs contain entries for chat initiation and messages exchanged", () => {
 LiveChatPage.verifyLogEntries();
});

Given("user is on the live chat section", () => {
 LiveChatPage.navigateToLiveChatSection();
});

When("user checks UI for accessibility and ease of use", () => {
 LiveChatPage.checkUIAccessibility();
});

Then("UI is accessible and user-friendly for chat initiation", () => {
 LiveChatPage.verifyUIAccessibility();
});