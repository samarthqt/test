import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CheckoutPage from "../pages/checkoutPage";

Given("the user account is logged in", () => {
 cy.login();
});

When("the user navigates to the checkout page", () => {
 CheckoutPage.visit();
});

Then("the checkout page is displayed with options to enter shipping and billing addresses", () => {
 CheckoutPage.verifyPageLoaded();
});

Given("the user is on the checkout page", () => {
 CheckoutPage.verifyPageLoaded();
});

When("the user enters new shipping address {string}", (address) => {
 CheckoutPage.enterShippingAddress(address);
});

When("the user enters billing address {string}", (address) => {
 CheckoutPage.enterBillingAddress(address);
});

Then("the shipping and billing address details are entered correctly", () => {
 CheckoutPage.verifyAddressDetailsEntered();
});

Given("the user has entered shipping and billing addresses", () => {
 CheckoutPage.verifyAddressDetailsEntered();
});

When("the user enters phone number {string}", (phone) => {
 CheckoutPage.enterPhoneNumber(phone);
});

When("the user enters email address {string}", (email) => {
 CheckoutPage.enterEmailAddress(email);
});

Then("the phone number and email are entered correctly", () => {
 CheckoutPage.verifyContactDetailsEntered();
});

Given("the user has entered contact details", () => {
 CheckoutPage.verifyContactDetailsEntered();
});

When("the user clicks 'Save for Future' to store the information", () => {
 CheckoutPage.saveForFuture();
});

Then("the information is saved successfully without errors", () => {
 CheckoutPage.verifyInformationSaved();
});

Given("the user has saved information for future use", () => {
 CheckoutPage.verifyInformationSaved();
});

When("the user navigates to account settings", () => {
 cy.visit("/account-settings");
});

Then("the newly entered information appears in the list of saved addresses and contact details", () => {
 cy.get("#savedAddresses").should("contain", "789 Future Lane, Future City, FC High 33");
 cy.get("#savedContacts").should("contain", "987-654-3210");
});

Given("the user has saved information", () => {
 CheckoutPage.verifyInformationSaved();
});

When("the user logs out and logs back in", () => {
 cy.logout();
 cy.login();
});

Then("the saved information persists across sessions", () => {
 cy.visit("/account-settings");
 cy.get("#savedAddresses").should("contain", "789 Future Lane, Future City, FC High 33");
});

Given("the user has saved information", () => {
 CheckoutPage.verifyInformationSaved();
});

When("the user attempts a new purchase", () => {
 cy.visit("/new-purchase");
});

Then("the checkout process uses saved information without requiring re-entry", () => {
 cy.get("#checkoutShippingAddress").should("contain", "789 Future Lane, Future City, FC High 33");
});

Given("the user has used saved information for a purchase", () => {
 cy.visit("/new-purchase");
 cy.get("#checkoutShippingAddress").should("contain", "789 Future Lane, Future City, FC High 33");
});

When("the user completes the checkout process", () => {
 cy.completeCheckout();
});

Then("a confirmation message is displayed indicating the use of saved information", () => {
 cy.get("#confirmationMessage").should("contain", "Saved information used");
});

Given("the user attempts to save information", () => {
 CheckoutPage.verifyPageLoaded();
});

When("the user clicks 'Save for Future'", () => {
 CheckoutPage.saveForFuture();
});

Then("no error messages are displayed and information is saved successfully", () => {
 cy.get("#errorMessages").should("not.exist");
 CheckoutPage.verifyInformationSaved();
});

Given("the user has saved information", () => {
 CheckoutPage.verifyInformationSaved();
});

When("the user edits the saved information", () => {
 cy.editSavedInformation("123 Updated Lane");
});

Then("the saved information can be edited and updated correctly", () => {
 cy.get("#savedAddresses").should("contain", "123 Updated Lane");
});

Given("the user is on the checkout page", () => {
 CheckoutPage.verifyPageLoaded();
});

When("the user enters international address details", () => {
 CheckoutPage.enterInternationalAddress("123 International St, Global City, GC");
});

Then("international addresses are entered, saved, and accepted correctly", () => {
 CheckoutPage.verifyInternationalAddressSaved();
});

Given("the user is on the checkout page", () => {
 CheckoutPage.verifyPageLoaded();
});

When("the user enters information in different valid formats", () => {
 CheckoutPage.enterInformationInDifferentFormats();
});

Then("information in different valid formats is saved correctly", () => {
 CheckoutPage.verifyInformationFormatsSaved();
});

Given("the user has saved information", () => {
 CheckoutPage.verifyInformationSaved();
});

When("the user deletes the saved information", () => {
 cy.deleteSavedInformation();
});

Then("the saved information can be deleted successfully", () => {
 cy.get("#savedAddresses").should("not.exist");
});

Given("the user has saved information", () => {
 CheckoutPage.verifyInformationSaved();
});

When("the user makes a future transaction", () => {
 cy.makeFutureTransaction();
});

Then("the saved information is automatically used in future transactions", () => {
 cy.get("#transactionShippingAddress").should("contain", "789 Future Lane, Future City, FC High 33");
});

Given("the user is on the checkout page", () => {
 CheckoutPage.verifyPageLoaded();
});

When("the user saves multiple addresses", () => {
 CheckoutPage.saveMultipleAddresses();
});

Then("multiple addresses can be saved and selected for future transactions", () => {
 cy.get("#savedAddresses").should("contain", "789 Future Lane");
 cy.get("#savedAddresses").should("contain", "321 Past Lane");
});