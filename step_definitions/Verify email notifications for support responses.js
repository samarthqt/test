import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import SupportPortalPage from "../pages/supportPortalPage";
import EmailNotificationPage from "../pages/emailNotificationPage";
import SupportTeamDashboardPage from "../pages/supportTeamDashboardPage";

Given("the user has a registered email address {string}", (email) => {
 SupportPortalPage.verifyRegisteredEmail(email);
});

When("the user submits a support request via the support portal", () => {
 SupportPortalPage.submitSupportRequest();
});

Then("the support request is successfully submitted", () => {
 SupportPortalPage.verifyRequestSubmission();
});

Then("a ticket ID is generated", () => {
 SupportPortalPage.verifyTicketIDGeneration();
});

Given("the system configuration settings confirm email notifications are enabled", () => {
 EmailNotificationPage.verifyEmailNotificationSettings();
});

Given("the support ticket ID is {string}", (ticketID) => {
 EmailNotificationPage.verifyTicketID(ticketID);
});

Then("email notifications should be sent for support responses", () => {
 EmailNotificationPage.verifyEmailNotificationSent();
});

Given("the support team dashboard is accessible", () => {
 SupportTeamDashboardPage.verifyDashboardAccess();
});

When("the support team responds to the support request", () => {
 SupportTeamDashboardPage.respondToSupportRequest();
});

Then("the response should be successful", () => {
 SupportTeamDashboardPage.verifyResponseSuccess();
});

Given("the support team has responded to the support request", () => {
 EmailNotificationPage.verifySupportTeamResponse();
});

When("the user checks their email inbox", () => {
 EmailNotificationPage.checkEmailInbox();
});

Then("the user should receive an email notification about the support response", () => {
 EmailNotificationPage.verifyEmailNotificationReceived();
});

Given("the user has received an email notification", () => {
 EmailNotificationPage.verifyEmailReceived();
});

When("the user opens the email", () => {
 EmailNotificationPage.openEmail();
});

Then("the email should contain the correct details of the support response", () => {
 EmailNotificationPage.verifyEmailContentDetails();
});

When("the user checks the sender's email address", () => {
 EmailNotificationPage.checkSenderEmailAddress();
});

Then("the email should be sent from the designated support email address", () => {
 EmailNotificationPage.verifySenderEmailAddress();
});

When("the user checks the email subject line", () => {
 EmailNotificationPage.checkEmailSubjectLine();
});

Then("the subject line should clearly indicate a response to the support request", () => {
 EmailNotificationPage.verifyEmailSubjectLineRelevance();
});

When("the user checks the email content", () => {
 EmailNotificationPage.checkEmailContent();
});

Then("the email should include a link that redirects to the support request in the portal", () => {
 EmailNotificationPage.verifyEmailLinkToSupportRequest();
});

Then("the email should be received within 5 minutes of the support response", () => {
 EmailNotificationPage.verifyEmailDeliveryTime();
});

Then("the email should be well-formatted and readable", () => {
 EmailNotificationPage.verifyEmailFormatting();
});

When("the user checks their spam/junk folder", () => {
 EmailNotificationPage.checkSpamFolder();
});

Then("the email should be delivered to the inbox and not the spam/junk folder", () => {
 EmailNotificationPage.verifyEmailNotSpam();
});

Then("only one email notification should be received per support response", () => {
 EmailNotificationPage.verifyNoDuplicateEmails();
});

Then("the email should not contain any unnecessary attachments unless specified", () => {
 EmailNotificationPage.verifyEmailAttachments();
});

When("the user opens the email on various email clients", () => {
 EmailNotificationPage.openEmailOnDifferentClients();
});

Then("the email should be accessible and correctly displayed", () => {
 EmailNotificationPage.verifyEmailAccessibilityOnClients();
});

When("the user replies to the email", () => {
 EmailNotificationPage.replyToEmail();
});

Then("the reply should be directed to the support team", () => {
 EmailNotificationPage.verifyReplyDirectedToSupportTeam();
});