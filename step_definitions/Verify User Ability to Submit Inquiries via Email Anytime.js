import { Given, When, Then, And } from "cypress-cucumber-preprocessor/steps";
import EmailClientPage from "../pages/emailClientPage";

Given("the user has access to an email client", () => {
 EmailClientPage.verifyAccess();
});

When("the user opens the email client application", () => {
 EmailClientPage.openClient();
});

Then("the email client opens successfully", () => {
 EmailClientPage.verifyClientOpened();
});

And("the user composes a new email", () => {
 EmailClientPage.composeEmail();
});

Then("the email composition window is displayed", () => {
 EmailClientPage.verifyCompositionWindow();
});

When("the user enters the support email address in the 'To' field", () => {
 EmailClientPage.enterToAddress();
});

Then("the support email address is entered correctly", () => {
 EmailClientPage.verifyToAddress();
});

When("the user enters a subject for the inquiry", () => {
 EmailClientPage.enterSubject();
});

Then("the subject is entered correctly", () => {
 EmailClientPage.verifySubject();
});

When("the user composes the body of the inquiry email with relevant details", () => {
 EmailClientPage.composeBody();
});

Then("the email body is composed with all necessary details", () => {
 EmailClientPage.verifyBody();
});

When("the user sends the email", () => {
 EmailClientPage.sendEmail();
});

Then("the email is sent successfully without any errors", () => {
 EmailClientPage.verifyEmailSent();
});

And("no delivery failure notifications are received", () => {
 EmailClientPage.verifyNoFailureNotifications();
});

And("an automated acknowledgment email is received confirming receipt of the inquiry", () => {
 EmailClientPage.verifyAcknowledgmentReceived();
});

And("any response from the support team is logged for reference", () => {
 EmailClientPage.logSupportResponse();
});

Given("the user tests submitting an inquiry email at different times of the day", () => {
 EmailClientPage.testDifferentTimes();
});

Then("inquiry emails can be submitted successfully at any time of the day", () => {
 EmailClientPage.verifySubmissionAnyTime();
});

Given("the user attempts to submit an inquiry with a large attachment", () => {
 EmailClientPage.attemptLargeAttachment();
});

Then("the inquiry email with attachment is sent successfully, or appropriate error is displayed if size limit is exceeded", () => {
 EmailClientPage.verifyLargeAttachment();
});

Given("the user verifies the support email address is correctly displayed in the application's support section", () => {
 EmailClientPage.verifySupportEmailDisplay();
});

Then("the support email address is displayed correctly and is clickable", () => {
 EmailClientPage.verifySupportEmailClickable();
});

Given("the user checks the email submission feature on different email clients", () => {
 EmailClientPage.checkDifferentClients();
});

Then("inquiry emails can be submitted successfully using different email clients", () => {
 EmailClientPage.verifySubmissionDifferentClients();
});

Given("the user tests submitting an inquiry with special characters in the subject or body", () => {
 EmailClientPage.testSpecialCharacters();
});

Then("the inquiry email with special characters is sent successfully without issues", () => {
 EmailClientPage.verifySpecialCharacters();
});

Given("the user verifies the email submission feature with a slow internet connection", () => {
 EmailClientPage.verifySlowInternet();
});

Then("inquiry emails can be submitted successfully, albeit with possible delays", () => {
 EmailClientPage.verifySubmissionSlowInternet();
});