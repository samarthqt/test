import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import TwilioIntegrationPage from "../pages/twilioIntegrationPage";

Given("the user has a Twilio account configured", () => {
 TwilioIntegrationPage.ensureTwilioAccountConfigured();
});

When("the user logs into the application", () => {
 TwilioIntegrationPage.loginToApplication();
});

Then("the user is successfully logged in", () => {
 TwilioIntegrationPage.verifySuccessfulLogin();
});

Given("the Twilio API key is set up in the application", () => {
 TwilioIntegrationPage.ensureTwilioApiKeyConfigured();
});

When("the user checks the application settings", () => {
 TwilioIntegrationPage.checkApplicationSettings();
});

Then("the Twilio API key is correctly configured", () => {
 TwilioIntegrationPage.verifyTwilioApiKeyConfiguration();
});

Given("the user is logged into the application", () => {
 TwilioIntegrationPage.userLoggedIn();
});

When("the user submits a support request", () => {
 TwilioIntegrationPage.submitSupportRequest();
});

Then("the support request is successfully submitted and a ticket ID is generated", () => {
 TwilioIntegrationPage.verifySupportRequestSubmission();
});

Given("the support request is submitted", () => {
 TwilioIntegrationPage.supportRequestSubmitted();
});

When("the support team responds to the request", () => {
 TwilioIntegrationPage.supportTeamResponds();
});

Then("the support team can successfully respond to the support request", () => {
 TwilioIntegrationPage.verifySupportTeamResponse();
});

Given("the support response is sent", () => {
 TwilioIntegrationPage.supportResponseSent();
});

When("the user checks the Twilio dashboard", () => {
 TwilioIntegrationPage.checkTwilioDashboard();
});

Then("the SMS delivery status is marked as successful", () => {
 TwilioIntegrationPage.verifySmsDeliveryStatus();
});

Given("the SMS delivery status is successful", () => {
 TwilioIntegrationPage.smsDeliveryStatusSuccessful();
});

When("the user checks their phone", () => {
 TwilioIntegrationPage.checkUserPhone();
});

Then("the user receives an SMS notification about the support response", () => {
 TwilioIntegrationPage.verifySmsNotificationReceived();
});

Given("the user receives an SMS notification", () => {
 TwilioIntegrationPage.smsNotificationReceived();
});

When("the user reviews the SMS content", () => {
 TwilioIntegrationPage.reviewSmsContent();
});

Then("the SMS contains the correct details of the support response", () => {
 TwilioIntegrationPage.verifySmsContentDetails();
});

When("the user checks the sender number", () => {
 TwilioIntegrationPage.checkSenderNumber();
});

Then("the SMS is sent from the designated support number", () => {
 TwilioIntegrationPage.verifySmsSenderNumber();
});

When("the user reviews the SMS format", () => {
 TwilioIntegrationPage.reviewSmsFormat();
});

Then("the SMS is well-formatted and readable", () => {
 TwilioIntegrationPage.verifySmsFormat();
});

When("the user checks the SMS delivery time", () => {
 TwilioIntegrationPage.checkSmsDeliveryTime();
});

Then("the SMS is received within 5 minutes of the support response", () => {
 TwilioIntegrationPage.verifySmsDeliveryTime();
});

When("the user checks the SMS notifications", () => {
 TwilioIntegrationPage.checkSmsNotifications();
});

Then("only one SMS notification is received per support response", () => {
 TwilioIntegrationPage.verifySingleSmsNotification();
});

When("the user checks the SMS content", () => {
 TwilioIntegrationPage.checkSmsContent();
});

Then("the SMS includes a link that redirects to the support request in the portal", () => {
 TwilioIntegrationPage.verifySmsLinkToSupportRequest();
});

When("the user checks the SMS on various mobile networks", () => {
 TwilioIntegrationPage.checkSmsOnVariousNetworks();
});

Then("the SMS is accessible and correctly displayed on various mobile networks", () => {
 TwilioIntegrationPage.verifySmsDisplayOnNetworks();
});

Then("the SMS contains only the necessary information about the support response", () => {
 TwilioIntegrationPage.verifySmsNecessaryInformation();
});

When("the user checks for any charges", () => {
 TwilioIntegrationPage.checkForCharges();
});

Then("the user is not charged for receiving the SMS notification", () => {
 TwilioIntegrationPage.verifyNoChargesForSms();
});