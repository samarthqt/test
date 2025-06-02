import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ChatPage from "../pages/chatPage";

Given("the user is logged into the application using valid credentials", () => {
 ChatPage.login();
});

Given("the live chat feature is enabled and functional", () => {
 ChatPage.enableLiveChat();
});

When("the user navigates to the support or help section of the application", () => {
 ChatPage.goToSupportSection();
});

Then("the support section is displayed with all available options", () => {
 ChatPage.verifySupportSection();
});

Given("the user initiates a live chat session", () => {
 ChatPage.initiateLiveChat();
});

Then("the live chat session is initiated successfully with an available agent", () => {
 ChatPage.verifyLiveChatInitiation();
});

When("the user engages in a conversation with the live chat agent", () => {
 ChatPage.engageInConversation();
});

Then("the conversation is carried out successfully", () => {
 ChatPage.verifyConversation();
});

When("the user ends the live chat session", () => {
 ChatPage.endLiveChat();
});

Then("the live chat session ends successfully with a confirmation message", () => {
 ChatPage.verifyLiveChatEnd();
});

Given("the user navigates to the chat history or transcripts section", () => {
 ChatPage.goToChatHistory();
});

Then("the chat history section is displayed with all past chat sessions listed", () => {
 ChatPage.verifyChatHistory();
});

When("the user selects the most recent chat session to view the transcript", () => {
 ChatPage.selectRecentChat();
});

Then("the transcript of the selected chat session is displayed accurately", () => {
 ChatPage.verifyTranscriptDisplay();
});

Given("the user views the chat transcript", () => {
 ChatPage.viewChatTranscript();
});

Then("the chat transcript is accurate and complete, reflecting the entire conversation", () => {
 ChatPage.verifyTranscriptAccuracy();
});

Given("the user checks for options to download or print the chat transcript", () => {
 ChatPage.checkDownloadPrintOptions();
});

Then("options to download or print the chat transcript are available and functional", () => {
 ChatPage.verifyDownloadPrintOptions();
});

Given("the user attempts to access chat transcripts on a different device/browser", () => {
 ChatPage.accessTranscriptsOnDifferentDevice();
});

Then("chat transcripts are accessible across different devices/browsers", () => {
 ChatPage.verifyTranscriptsAccessibility();
});

Given("the user verifies the security and privacy of chat transcripts", () => {
 ChatPage.verifySecurityPrivacy();
});

Then("chat transcripts are secured and accessible only to authorized users", () => {
 ChatPage.verifySecurity();
});

Given("the user checks the retention period for chat transcripts", () => {
 ChatPage.checkRetentionPeriod();
});

Then("chat transcripts are retained for the specified period as per the policy", () => {
 ChatPage.verifyRetentionPolicy();
});

Given("the user tests the chat transcript feature with a slow internet connection", () => {
 ChatPage.testWithSlowInternet();
});

Then("chat transcripts are accessible, albeit with possible delays", () => {
 ChatPage.verifyTranscriptAccessWithDelay();
});

Given("the user verifies the chat transcript feature with different types of chat sessions (e.g., resolved, unresolved)", () => {
 ChatPage.verifyDifferentChatTypes();
});

Then("all types of chat sessions have transcripts saved and accessible", () => {
 ChatPage.verifyAllChatTypesTranscripts();
});

Given("the user checks for any error messages or logs during chat transcript retrieval", () => {
 ChatPage.checkForErrorMessages();
});

Then("no error messages or logs indicate issues during chat transcript retrieval", () => {
 ChatPage.verifyNoErrorMessages();
});