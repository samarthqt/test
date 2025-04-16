import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import CustomerServicePage from '../page_objects/CustomerServicePage';

const customerServicePage = new CustomerServicePage();

Given('the customer service contact page is displayed', () => {
  customerServicePage.visit();
});

When('a contact channel is selected', () => {
  customerServicePage.selectContactChannel();
});

Then('the selected contact channel should be highlighted or marked as active', () => {
  customerServicePage.verifyChannelIsActive();
});

Given('the customer's contact information is entered correctly', () => {
  customerServicePage.enterContactInformation();
});

When('the {string} button is clicked', (buttonName) => {
  customerServicePage.clickButton(buttonName);
});

Then('the system should connect the customer with an available customer service representative', () => {
  customerServicePage.verifyConnectionWithRepresentative();
});

Given('the customer is connected with a customer service representative', () => {
  customerServicePage.verifyConnectedWithRepresentative();
});

Then('the customer should be able to initiate a conversation with the representative', () => {
  customerServicePage.initiateConversation();
});

Given('the customer service representative is responsive', () => {
  customerServicePage.verifyRepresentativeIsResponsive();
});

When('the customer makes inquiries or requests', () => {
  customerServicePage.makeInquiriesOrRequests();
});

Then('the representative should respond to the customer', () => {
  customerServicePage.verifyRepresentativeResponse();
});

Given('the customer is in a conversation with the representative', () => {
  customerServicePage.verifyInConversation();
});

When('the customer wants to end the conversation', () => {
  customerServicePage.endConversation();
});

Then('the conversation should be ended', () => {
  customerServicePage.verifyConversationEnded();
});

Given('the customer wants to connect with a representative through different contact channels', () => {
  customerServicePage.prepareForMultipleChannels();
});

When('the process is repeated for each contact channel', () => {
  customerServicePage.repeatProcessForEachChannel();
});

Then('the customer should be able to connect with an available representative through different contact channels', () => {
  customerServicePage.verifyConnectionThroughDifferentChannels();
});

Given('there is at least one representative available for each contact channel', () => {
  customerServicePage.verifyRepresentativeAvailability();
});

Then('the customer service representative should be available for each contact channel', () => {
  customerServicePage.verifyAvailabilityForEachChannel();
});

Then('the page should accurately display information about the availability of representatives for each contact channel', () => {
  customerServicePage.verifyAvailabilityInformation();
});

Then('the page should provide clear instructions on how to connect with a representative for each contact channel', () => {
  customerServicePage.verifyConnectionInstructions();
});

Then('the page should provide alternative contact methods {string} in case all representatives are busy', (methods) => {
  customerServicePage.verifyAlternativeContactMethods(methods);
});

Then('the page should accurately display contact information {string} for each contact channel', (info) => {
  customerServicePage.verifyContactInformation(info);
});