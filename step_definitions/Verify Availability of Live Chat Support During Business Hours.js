import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import LiveChatPage from "../pages/liveChatPage";

Given("the user is logged into the application using valid credentials", () => {
 LiveChatPage.login();
});

Given("the live chat feature is enabled", () => {
 LiveChatPage.verifyLiveChatEnabled();
});

When("the user navigates to the support or help section of the application", () => {
 LiveChatPage.navigateToSupportSection();
});

Then("the support section is displayed with all available options", () => {
 LiveChatPage.verifySupportSectionDisplayed();
});

Then("business hours information is visible", () => {
 LiveChatPage.verifyBusinessHoursVisible();
});

Then("the live chat support option is visible and accessible", () => {
 LiveChatPage.verifyLiveChatOptionVisible();
});

Given("the user locates the live chat support option", () => {
 LiveChatPage.locateLiveChatOption();
});

When("the user initiates a live chat session during business hours", () => {
 LiveChatPage.initiateLiveChatSession();
});

Then("the live chat session is initiated successfully with an available agent", () => {
 LiveChatPage.verifyLiveChatSessionInitiated();
});

Given("a live chat session is initiated", () => {
 LiveChatPage.verifyLiveChatSessionInitiated();
});

When("the user sends a message to the live chat agent", () => {
 LiveChatPage.sendMessageToAgent();
});

Then("the message is sent successfully", () => {
 LiveChatPage.verifyMessageSent();
});

Then("the agent responds in a timely manner", () => {
 LiveChatPage.verifyAgentResponseTimely();
});

Given("a message is sent to the live chat agent", () => {
 LiveChatPage.verifyMessageSent();
});

When("the agent responds", () => {
 LiveChatPage.agentResponds();
});

Then("the response time is within acceptable limits as per business standards", () => {
 LiveChatPage.verifyResponseTime();
});

Given("a live chat session is active", () => {
 LiveChatPage.verifyLiveChatSessionActive();
});

When("the user receives messages", () => {
 LiveChatPage.receiveMessages();
});

Then("automated messages or acknowledgments are appropriate and informative", () => {
 LiveChatPage.verifyAutomatedMessages();
});

When("the user sends different types of inquiries", () => {
 LiveChatPage.sendDifferentInquiries();
});

Then("all types of inquiries are handled appropriately by the live chat agent", () => {
 LiveChatPage.verifyInquiryHandling();
});

When("the user attempts to end the live chat session", () => {
 LiveChatPage.endLiveChatSession();
});

Then("the live chat session ends successfully with a confirmation message", () => {
 LiveChatPage.verifySessionEnd();
});

Given("the user has ended a live chat session", () => {
 LiveChatPage.verifySessionEnd();
});

When("the user re-initiates the live chat session during business hours", () => {
 LiveChatPage.reInitiateLiveChatSession();
});

Then("live chat can be re-initiated without issues", () => {
 LiveChatPage.verifyReInitiation();
});

Given("the user navigates to the support section outside business hours", () => {
 LiveChatPage.navigateToSupportOutsideBusinessHours();
});

When("the user attempts to initiate a live chat session", () => {
 LiveChatPage.attemptLiveChatOutsideHours();
});

Then("live chat support is unavailable or provides an appropriate message", () => {
 LiveChatPage.verifyUnavailabilityOutsideHours();
});

Given("the user has access to different devices/browsers", () => {
 LiveChatPage.accessDifferentDevicesBrowsers();
});

When("the user tests the live chat feature on these devices/browsers", () => {
 LiveChatPage.testLiveChatOnDevicesBrowsers();
});

Then("live chat is accessible and functional across different devices/browsers", () => {
 LiveChatPage.verifyAccessibilityAcrossDevicesBrowsers();
});

Given("the user has a slow internet connection", () => {
 LiveChatPage.slowInternetConnection();
});

When("the user initiates a live chat session", () => {
 LiveChatPage.initiateLiveChatSession();
});

Then("live chat remains functional, albeit with possible delays", () => {
 LiveChatPage.verifyFunctionalityWithDelays();
});

Given("the user has completed a live chat session", () => {
 LiveChatPage.verifySessionEnd();
});

When("the user checks the session history", () => {
 LiveChatPage.checkSessionHistory();
});

Then("chat history is saved and accessible for future reference", () => {
 LiveChatPage.verifyHistorySaved();
});

When("the user monitors for errors", () => {
 LiveChatPage.monitorErrors();
});

Then("no error messages or logs indicate issues during live chat sessions", () => {
 LiveChatPage.verifyNoErrors();
});