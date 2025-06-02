import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CheckoutPage from "../pages/checkoutPage";

Given("a user account is logged in", () => {
 cy.login();
});

When("the user navigates to the checkout page", () => {
 CheckoutPage.visit();
});

Then("the checkout page is displayed with options to enter shipping and billing addresses", () => {
 CheckoutPage.verifyPageDisplayed();
});

Given("the user is on the checkout page", () => {
 CheckoutPage.verifyPageDisplayed();
});

When("the user clicks on 'Add New Address' for shipping", () => {
 CheckoutPage.clickAddNewShippingAddress();
});

Then("a form to enter new shipping address is displayed", () => {
 CheckoutPage.verifyShippingFormDisplayed();
});

Given("the shipping address form is displayed", () => {
 CheckoutPage.verifyShippingFormDisplayed();
});

When("the user enters shipping address details {string}", (address) => {
 CheckoutPage.enterShippingAddress(address);
});

And("enters phone number {string}", (phone) => {
 CheckoutPage.enterShippingPhoneNumber(phone);
});

Then("the shipping address details are entered correctly", () => {
 CheckoutPage.verifyShippingAddressEntered();
});

Given("the user has entered shipping address details", () => {
 CheckoutPage.verifyShippingAddressEntered();
});

When("the user clicks on 'Add New Address' for billing", () => {
 CheckoutPage.clickAddNewBillingAddress();
});

Then("a form to enter new billing address is displayed", () => {
 CheckoutPage.verifyBillingFormDisplayed();
});

Given("the billing address form is displayed", () => {
 CheckoutPage.verifyBillingFormDisplayed();
});

When("the user enters billing address details {string}", (address) => {
 CheckoutPage.enterBillingAddress(address);
});

And("enters email {string}", (email) => {
 CheckoutPage.enterBillingEmail(email);
});

Then("billing address details are entered correctly", () => {
 CheckoutPage.verifyBillingAddressEntered();
});

Given("the user has entered shipping and billing address details", () => {
 CheckoutPage.verifyShippingAddressEntered();
 CheckoutPage.verifyBillingAddressEntered();
});

When("the user clicks 'Save' to store the new addresses", () => {
 CheckoutPage.clickSaveAddresses();
});

Then("addresses are saved successfully without errors", () => {
 CheckoutPage.verifyAddressesSavedSuccessfully();
});

Given("the addresses are saved successfully", () => {
 CheckoutPage.verifyAddressesSavedSuccessfully();
});

When("the user views the list of saved addresses", () => {
 CheckoutPage.viewSavedAddresses();
});

Then("newly entered addresses appear in the list of saved addresses", () => {
 CheckoutPage.verifyNewAddressesInList();
});

Given("the newly entered addresses are saved", () => {
 CheckoutPage.verifyAddressesSavedSuccessfully();
});

When("the user proceeds to checkout using the new addresses", () => {
 CheckoutPage.proceedToCheckoutWithNewAddresses();
});

Then("checkout process continues using the newly entered addresses", () => {
 CheckoutPage.verifyCheckoutProcessContinues();
});

Given("the checkout process continues using the new addresses", () => {
 CheckoutPage.verifyCheckoutProcessContinues();
});

When("the checkout is confirmed", () => {
 CheckoutPage.confirmCheckout();
});

Then("a confirmation message is displayed indicating the use of new addresses", () => {
 CheckoutPage.verifyConfirmationMessageDisplayed();
});

Given("the user is entering addresses", () => {
 CheckoutPage.startEnteringAddresses();
});

When("the addresses are entered", () => {
 CheckoutPage.enterAddresses();
});

Then("no error messages are displayed; addresses are accepted", () => {
 CheckoutPage.verifyNoErrorMessages();
});

Given("the user is entering addresses", () => {
 CheckoutPage.startEnteringAddresses();
});

When("the addresses are entered", () => {
 CheckoutPage.enterAddresses();
});

Then("address format is validated and correct", () => {
 CheckoutPage.verifyAddressFormatValidated();
});

Given("the user is entering addresses", () => {
 CheckoutPage.startEnteringAddresses();
});

When("the addresses are entered", () => {
 CheckoutPage.enterAddresses();
});

Then("all required fields are populated correctly", () => {
 CheckoutPage.verifyRequiredFieldsPopulated();
});

Given("the user is entering addresses", () => {
 CheckoutPage.startEnteringAddresses();
});

When("addresses in different valid formats are entered", () => {
 CheckoutPage.enterDifferentValidFormats();
});

Then("addresses in different valid formats are accepted", () => {
 CheckoutPage.verifyDifferentFormatsAccepted();
});

Given("the user is entering addresses", () => {
 CheckoutPage.startEnteringAddresses();
});

When("international addresses are entered", () => {
 CheckoutPage.enterInternationalAddresses();
});

Then("international addresses are entered and accepted correctly", () => {
 CheckoutPage.verifyInternationalAddressesAccepted();
});