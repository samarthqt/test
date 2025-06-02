import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import SupportPortalPage from "../pages/supportPortalPage";

Given("the user has a registered phone number {string}", (phoneNumber) => {
 cy.wrap(phoneNumber).as('registeredPhoneNumber');
});

When("the user submits a support request via the support portal", () => {
 SupportPortalPage.submitSupportRequest();
});

Then("the support request is successfully submitted and a ticket ID is generated", () => {
 SupportPortalPage.verifyTicketIdGenerated();
});

Given("the system configuration settings confirm SMS notifications are enabled", () => {
 SupportPortalPage.verifySmsNotificationsEnabled();
});

Given("the user has a support ticket ID {string}", (ticketId) => {
 cy.wrap(ticketId).as('supportTicketId');
});

When("a support response is sent to the user", () => {
 SupportPortalPage.sendSupportResponse();
});

Then("the user receives an SMS notification about the support response", () => {
 SupportPortalPage.verifySmsNotificationReceived();
});

Then("the SMS contains the correct details of the support response", () => {
 SupportPortalPage.verifySmsContent();
});

Then("the SMS is sent from the designated support number", () => {
 SupportPortalPage.verifySmsFromSupportNumber();
});

Then("the SMS is well-formatted and readable", () => {
 SupportPortalPage.verifySmsFormatting();
});

Then("the SMS is received within 5 minutes of the support response", () => {
 SupportPortalPage.verifySmsReceivedWithinTime();
});

Then("only one SMS notification is received per support response", () => {
 SupportPortalPage.verifyNoDuplicateSms();
});

Then("the SMS includes a link that redirects to the support request in the portal", () => {
 SupportPortalPage.verifySmsLinkToSupportRequest();
});

Then("the SMS is accessible and correctly displayed on various mobile networks", () => {
 SupportPortalPage.verifySmsOnDifferentNetworks();
});

Then("the SMS contains only the necessary information about the support response", () => {
 SupportPortalPage.verifySmsContainsNecessaryInfo();
});

Then("the user is not charged for receiving the SMS notification", () => {
 SupportPortalPage.verifyNoChargesForSms();
});

When("the user replies to the SMS", () => {
 SupportPortalPage.replyToSms();
});

Then("the reply is directed to the support team", () => {
 SupportPortalPage.verifyReplyDirectedToSupportTeam();
});

Then("the SMS is delivered to the inbox and not marked as spam", () => {
 SupportPortalPage.verifySmsNotMarkedAsSpam();
});