import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import SupportTicketPage from "../pages/supportTicketPage";

Given("a user is on the support ticket submission page on the web platform", () => {
  SupportTicketPage.visitWebPlatform();
});

Given("a user is on the support ticket submission page on the mobile platform", () => {
  SupportTicketPage.visitMobilePlatform();
});

Given("a user is submitting a support ticket", () => {
  SupportTicketPage.visitSubmissionPage();
});

Given("a user encounters an issue while submitting a support ticket", () => {
  SupportTicketPage.visitSubmissionPageWithError();
});

Given("a user has submitted a support ticket", () => {
  SupportTicketPage.submitTicket();
});

When("the user provides necessary details for ticket creation", () => {
  SupportTicketPage.enterTicketDetails();
});

When("the user submits the ticket", () => {
  SupportTicketPage.submitTicket();
});

When("an error occurs during submission", () => {
  SupportTicketPage.triggerSubmissionError();
});

When("the ticket is being managed by the support system", () => {
  SupportTicketPage.manageTicket();
});

When("there is an update on the ticket status or responses", () => {
  SupportTicketPage.updateTicketStatus();
});

Then("the system should acknowledge ticket receipt immediately", () => {
  SupportTicketPage.verifyAcknowledgement();
});

Then("the user should be able to track ticket status and responses", () => {
  SupportTicketPage.verifyTrackingAbility();
});

Then("the system should ensure secure and private communication", () => {
  SupportTicketPage.verifySecureCommunication();
});

Then("the system must display user-friendly messages for submission issues", () => {
  SupportTicketPage.verifyErrorMessage();
});

Then("the integration with support systems for ticket management must be reliable", () => {
  SupportTicketPage.verifyIntegrationReliability();
});

Then("the user should receive notifications for ticket updates", () => {
  SupportTicketPage.verifyNotifications();
});