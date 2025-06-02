import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CheckoutPage from "../pages/checkoutPage";

Given("the user account is logged in", () => {
 // Assume user is logged in
});

When("the user navigates to the checkout page", () => {
 CheckoutPage.visit();
});

Then("the checkout page is displayed with options to enter shipping and billing addresses", () => {
 CheckoutPage.verifyPageLoaded();
});

Given("the user is on the checkout page", () => {
 CheckoutPage.visit();
});

When("the user enters invalid shipping address {string}", (address) => {
 CheckoutPage.enterShippingAddress(address);
});

When("the user enters invalid billing address {string}", (address) => {
 CheckoutPage.enterBillingAddress(address);
});

Then("the system displays error messages indicating invalid address format", () => {
 CheckoutPage.verifyInvalidAddressError();
});

When("the user enters invalid phone number {string}", (phoneNumber) => {
 CheckoutPage.enterPhoneNumber(phoneNumber);
});

When("the user enters invalid email {string}", (email) => {
 CheckoutPage.enterEmail(email);
});

Then("the system displays error messages indicating invalid phone number and email format", () => {
 CheckoutPage.verifyInvalidContactError();
});

Given("the user has entered invalid information on the checkout page", () => {
 // Assume invalid information is entered
});

When("the user attempts to save the invalid information", () => {
 CheckoutPage.saveInformation();
});

Then("the system prevents saving and displays error feedback", () => {
 CheckoutPage.verifySavePrevention();
});

Given("the system has displayed error messages for invalid information", () => {
 // Assume error messages are displayed
});

Then("the error messages are clear and informative, guiding users to correct the information", () => {
 CheckoutPage.verifyErrorMessageClarity();
});

Given("the user has corrected the invalid information", () => {
 // Assume information is corrected
});

When("the user attempts to save the corrected information", () => {
 CheckoutPage.saveInformation();
});

Then("the system accepts corrected information and saves successfully", () => {
 CheckoutPage.verifySuccessfulSave();
});

When("the user enters incomplete address information", () => {
 CheckoutPage.enterIncompleteAddress();
});

Then("the system prompts the user to complete the address entry before proceeding", () => {
 CheckoutPage.verifyIncompleteAddressPrompt();
});

When("the user enters invalid international address formats", () => {
 CheckoutPage.enterInvalidInternationalAddress();
});

Then("the system provides feedback and error messages for invalid international address formats", () => {
 CheckoutPage.verifyInternationalAddressError();
});

When("the user attempts to checkout", () => {
 CheckoutPage.attemptCheckout();
});

Then("the system prevents checkout and displays error messages for invalid information", () => {
 CheckoutPage.verifyCheckoutPrevention();
});

When("the user enters invalid characters in address fields", () => {
 CheckoutPage.enterInvalidCharactersInAddress();
});

Then("the system flags invalid characters and prevents saving", () => {
 CheckoutPage.verifyInvalidCharacterError();
});

When("the user enters invalid email formats", () => {
 CheckoutPage.enterInvalidEmailFormat();
});

Then("the system displays error messages for invalid email formats", () => {
 CheckoutPage.verifyInvalidEmailFormatError();
});

When("the user enters invalid phone number formats", () => {
 CheckoutPage.enterInvalidPhoneNumberFormat();
});

Then("the system displays error messages for invalid phone number formats", () => {
 CheckoutPage.verifyInvalidPhoneNumberFormatError();
});

When("the user leaves required fields empty", () => {
 CheckoutPage.leaveRequiredFieldsEmpty();
});

Then("the system prompts the user to fill in missing required fields", () => {
 CheckoutPage.verifyMissingFieldsPrompt();
});

When("the user enters invalid postal codes", () => {
 CheckoutPage.enterInvalidPostalCode();
});

Then("the system displays error messages for invalid postal codes", () => {
 CheckoutPage.verifyInvalidPostalCodeError();
});

Then("the system prevents saving and prompts the user to correct invalid information", () => {
 CheckoutPage.verifySavePrevention();
});