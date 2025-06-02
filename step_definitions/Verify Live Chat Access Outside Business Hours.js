import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import LoginPage from "../pages/loginPage";
import LiveChatPage from "../pages/liveChatPage";
import SystemSettingsPage from "../pages/systemSettingsPage";

Given("the user has valid account credentials", () => {
 LoginPage.visit();
});

When("the user logs in to the application", () => {
 LoginPage.enterCredentials('validUsername', 'validPassword');
 LoginPage.submit();
});

Then("the user should be successfully logged in", () => {
 cy.url().should("include", "/dashboard");
});

Given("the user is logged in", () => {
 cy.login('validUsername', 'validPassword');
});

When("the user navigates to the live chat section of the application", () => {
 LiveChatPage.navigateToLiveChat();
});

Then("the user should be directed to the live chat page", () => {
 cy.url().should("include", "/live-chat");
});

Given("the user is on the live chat page", () => {
 LiveChatPage.visit();
});

When("the user attempts to start a live chat session outside business hours", () => {
 LiveChatPage.startChatSession();
});

Then("the system should display a message indicating live chat is unavailable outside business hours", () => {
 LiveChatPage.verifyUnavailableMessage();
});

Given("the system displays a message for unavailable live chat", () => {
 LiveChatPage.displayUnavailableMessage();
});

When("the user reads the message", () => {
 LiveChatPage.readMessage();
});

Then("the message should clearly state the business hours and alternative contact options", () => {
 LiveChatPage.verifyMessageContent();
});

Given("the live chat is unavailable outside business hours", () => {
 LiveChatPage.verifyChatUnavailable();
});

When("the user checks for alternative support options", () => {
 LiveChatPage.checkAlternativeSupportOptions();
});

Then("the system should offer alternative support options such as email or phone support", () => {
 LiveChatPage.verifyAlternativeSupportOptions();
});

Given("the user has the live chat URL", () => {
 cy.wrap('liveChatURL').as('liveChatURL');
});

When("the user attempts to access the live chat URL directly via browser", () => {
 cy.visit(this.liveChatURL);
});

Then("access should be restricted and the unavailable message should be displayed", () => {
 LiveChatPage.verifyAccessRestriction();
});

Given("the user is on the live chat page outside business hours", () => {
 LiveChatPage.visitOutsideBusinessHours();
});

When("the user checks the chat button", () => {
 LiveChatPage.checkChatButtonStatus();
});

Then("the chat button should be disabled and not clickable", () => {
 LiveChatPage.verifyChatButtonDisabled();
});

Given("the user attempts to access live chat outside business hours", () => {
 LiveChatPage.attemptAccessOutsideHours();
});

When("the system logs are checked", () => {
 SystemSettingsPage.checkSystemLogs();
});

Then("no errors should be logged and access attempts should be recorded as expected", () => {
 SystemSettingsPage.verifyLogs();
});

Given("the user is on the live chat page during business hours", () => {
 LiveChatPage.visitDuringBusinessHours();
});

When("the user attempts to access live chat", () => {
 LiveChatPage.startChatSession();
});

Then("live chat should be accessed successfully", () => {
 LiveChatPage.verifyChatAccess();
});

Given("the user accesses application settings", () => {
 SystemSettingsPage.visit();
});

When("the user checks the business hours display", () => {
 SystemSettingsPage.checkBusinessHours();
});

Then("business hours should be displayed accurately and can be updated if necessary", () => {
 SystemSettingsPage.verifyBusinessHoursDisplay();
});

Given("the business hours have changed", () => {
 SystemSettingsPage.changeBusinessHours();
});

When("the user checks notifications", () => {
 SystemSettingsPage.checkNotifications();
});

Then("users should receive notifications if business hours change", () => {
 SystemSettingsPage.verifyNotifications();
});

Given("different user roles exist", () => {
 cy.fixture('userRoles').as('userRoles');
});

When("users attempt to access live chat outside business hours", () => {
 LiveChatPage.attemptAccessByRoles(this.userRoles);
});

Then("the system response should be consistent across different user roles", () => {
 LiveChatPage.verifyRoleConsistency();
});

When("the system performance is compared during business hours and outside business hours", () => {
 SystemSettingsPage.comparePerformance();
});

Then("system performance should be unaffected by changes in business hours", () => {
 SystemSettingsPage.verifyPerformance();
});