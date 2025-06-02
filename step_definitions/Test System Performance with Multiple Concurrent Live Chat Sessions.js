import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import LiveChatPage from "../pages/liveChatPage";

Given("the live chat feature is enabled", () => {
 LiveChatPage.checkChatFeatureEnabled();
});

When("the user logs in using valid credentials", () => {
 LiveChatPage.login();
});

Then("the user is successfully logged in", () => {
 LiveChatPage.verifyLoginSuccess();
});

Given("the user is logged in", () => {
 LiveChatPage.verifyUserLoggedIn();
});

When("the user navigates to the live chat section", () => {
 LiveChatPage.navigateToChatSection();
});

Then("the user is directed to the live chat page", () => {
 LiveChatPage.verifyOnChatPage();
});

Given("the user is on the live chat page", () => {
 LiveChatPage.verifyOnChatPage();
});

When("the user initiates a live chat session", () => {
 LiveChatPage.initiateChatSession();
});

Then("the live chat session is successfully initiated", () => {
 LiveChatPage.verifyChatInitiation();
});

Given("the session simulator is available", () => {
 LiveChatPage.checkSessionSimulator();
});

When("multiple concurrent live chat sessions are simulated", () => {
 LiveChatPage.simulateConcurrentSessions();
});

Then("the system handles multiple concurrent sessions without performance degradation", () => {
 LiveChatPage.verifyPerformance();
});

Given("multiple concurrent sessions are active", () => {
 LiveChatPage.verifyConcurrentSessionsActive();
});

When("the system response time is measured for each chat session", () => {
 LiveChatPage.measureResponseTime();
});

Then("the response time remains within acceptable limits for all sessions", () => {
 LiveChatPage.verifyResponseTimeLimits();
});

When("the system logs are checked", () => {
 LiveChatPage.checkSystemLogs();
});

Then("no errors related to chat session handling are logged", () => {
 LiveChatPage.verifyNoErrorsInLogs();
});

Given("the maximum number of concurrent sessions is reached", () => {
 LiveChatPage.verifyMaxSessionsReached();
});

When("the system behavior is observed", () => {
 LiveChatPage.observeSystemBehavior();
});

Then("the system gracefully handles the maximum session limit without crashing", () => {
 LiveChatPage.verifyGracefulHandling();
});

When("additional sessions are attempted", () => {
 LiveChatPage.attemptAdditionalSessions();
});

Then("the system prevents initiation of additional sessions beyond the limit", () => {
 LiveChatPage.verifySessionLimitEnforcement();
});

When("session prioritization is checked", () => {
 LiveChatPage.checkSessionPrioritization();
});

Then("sessions are prioritized correctly if applicable", () => {
 LiveChatPage.verifySessionPrioritization();
});

When("session limits are reached", () => {
 LiveChatPage.reachSessionLimits();
});

Then("users receive notifications if session limits are reached", () => {
 LiveChatPage.verifyUserNotifications();
});

When("system resource usage is monitored", () => {
 LiveChatPage.monitorResourceUsage();
});

Then("resource usage remains within acceptable limits", () => {
 LiveChatPage.verifyResourceUsageLimits();
});

When("all sessions are ended simultaneously", () => {
 LiveChatPage.endAllSessionsSimultaneously();
});

Then("the system handles simultaneous session termination gracefully", () => {
 LiveChatPage.verifyGracefulTermination();
});

When("the system recovery time is checked", () => {
 LiveChatPage.checkRecoveryTime();
});

Then("the system recovery time is within acceptable limits", () => {
 LiveChatPage.verifyRecoveryTimeLimits();
});

Given("the system is active during business and outside business hours", () => {
 LiveChatPage.verifySystemActive();
});

When("system performance is compared", () => {
 LiveChatPage.comparePerformance();
});

Then("system performance is consistent across different times", () => {
 LiveChatPage.verifyConsistentPerformance();
});

Given("different user roles are available", () => {
 LiveChatPage.verifyUserRolesAvailable();
});

When("sessions are initiated using different user roles", () => {
 LiveChatPage.initiateSessionsWithRoles();
});

Then("system response is consistent across different user roles", () => {
 LiveChatPage.verifyResponseConsistency();
});