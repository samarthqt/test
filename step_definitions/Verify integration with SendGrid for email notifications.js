import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import SendGridPage from "../pages/sendGridPage";

Given("a SendGrid account is configured", () => {
 SendGridPage.verifyAccountConfiguration();
});

Given("the SendGrid API key is set up in the application", () => {
 SendGridPage.verifyApiKeySetup();
});

When("the user logs in to the application with email {string}", (email) => {
 SendGridPage.login(email);
});

Then("the user is successfully logged in", () => {
 SendGridPage.verifyLoginSuccess();
});

Given("the SendGrid API key is configured in the application settings", () => {
 SendGridPage.verifyApiKeyInSettings();
});

Then("the SendGrid API key is correctly configured", () => {
 SendGridPage.verifyApiKeyCorrectness();
});

Given("the user has logged in", () => {
 SendGridPage.ensureUserLoggedIn();
});

When("the user submits a support request via the support portal", () => {
 SendGridPage.submitSupportRequest();
});

Then("the support request is successfully submitted", () => {
 SendGridPage.verifySupportRequestSubmission();
});

Then("a ticket ID is generated", () => {
 SendGridPage.verifyTicketIdGenerated();
});

Given("the support request is submitted", () => {
 SendGridPage.ensureSupportRequestSubmitted();
});

When("the support team responds to the support request from the support team dashboard", () => {
 SendGridPage.respondToSupportRequest();
});

Then("the support team can successfully respond to the support request", () => {
 SendGridPage.verifySupportTeamResponse();
});

Given("the support team has responded to the support request", () => {
 SendGridPage.ensureSupportTeamResponse();
});

When("checking the SendGrid dashboard", () => {
 SendGridPage.checkSendGridDashboard();
});

Then("the email delivery status is marked as successful", () => {
 SendGridPage.verifyEmailDeliveryStatus();
});

Given("the email delivery status is successful", () => {
 SendGridPage.ensureEmailDeliverySuccess();
});

When("checking the user's inbox", () => {
 SendGridPage.checkUserInbox();
});

Then("the user receives an email notification about the support response", () => {
 SendGridPage.verifyEmailNotificationReceived();
});

Given("the user receives the email notification", () => {
 SendGridPage.ensureEmailNotificationReceived();
});

When("checking the email content", () => {
 SendGridPage.checkEmailContent();
});

Then("the email contains the correct details of the support response", () => {
 SendGridPage.verifyEmailContentDetails();
});

Given("the email is received", () => {
 SendGridPage.ensureEmailReceived();
});

When("checking the sender address", () => {
 SendGridPage.checkSenderAddress();
});

Then("the email is sent from the designated support email address", () => {
 SendGridPage.verifySenderAddress();
});

When("checking the email subject line", () => {
 SendGridPage.checkEmailSubjectLine();
});

Then("the email subject line clearly indicates a response to the support request", () => {
 SendGridPage.verifyEmailSubjectLine();
});

When("checking for formatting issues", () => {
 SendGridPage.checkEmailFormatting();
});

Then("the email is well-formatted and readable", () => {
 SendGridPage.verifyEmailFormatting();
});

Given("the email is sent", () => {
 SendGridPage.ensureEmailSent();
});

When("checking the time of reception", () => {
 SendGridPage.checkEmailReceptionTime();
});

Then("the email is received within 5 minutes of the support response", () => {
 SendGridPage.verifyEmailReceptionTime();
});

When("verifying the number of emails", () => {
 SendGridPage.verifyNumberOfEmails();
});

Then("only one email notification is received per support response", () => {
 SendGridPage.verifySingleEmailNotification();
});

When("checking for attachments", () => {
 SendGridPage.checkEmailAttachments();
});

Then("the email does not contain any unnecessary attachments unless specified", () => {
 SendGridPage.verifyEmailAttachments();
});

When("opening the email on various email clients", () => {
 SendGridPage.openEmailOnClients();
});

Then("the email is accessible and correctly displayed on various email clients", () => {
 SendGridPage.verifyEmailCompatibility();
});

When("the user replies to the email", () => {
 SendGridPage.userRepliesToEmail();
});

Then("the reply is directed to the support team", () => {
 SendGridPage.verifyReplyDirection();
});