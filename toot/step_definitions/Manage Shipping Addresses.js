import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ManageShippingAddressesPage from "../pages/manageShippingAddressesPage";

Given("the user is logged into their account", () => {
 // Assume user is already logged in
});

Given("the user is on the \"Manage Shipping Addresses\" page", () => {
 ManageShippingAddressesPage.visit();
});

When("the user clicks on \"Add New Address\"", () => {
 ManageShippingAddressesPage.clickAddNewAddress();
});

When("the user enters a valid shipping address", () => {
 ManageShippingAddressesPage.enterValidShippingAddress();
});

When("the user saves the new address", () => {
 ManageShippingAddressesPage.saveNewAddress();
});

Then("the new address should be added to the list of stored addresses", () => {
 ManageShippingAddressesPage.verifyAddressAdded();
});

Given("the user has already stored one shipping address", () => {
 ManageShippingAddressesPage.storeOneAddress();
});

When("the user enters another valid shipping address", () => {
 ManageShippingAddressesPage.enterAnotherValidShippingAddress();
});

Then("both addresses should be visible in the list of stored addresses", () => {
 ManageShippingAddressesPage.verifyMultipleAddressesVisible();
});

Given("the user has multiple shipping addresses stored", () => {
 ManageShippingAddressesPage.storeMultipleAddresses();
});

When("the user proceeds to checkout", () => {
 ManageShippingAddressesPage.proceedToCheckout();
});

When("the user selects a stored shipping address", () => {
 ManageShippingAddressesPage.selectStoredAddress();
});

Then("the selected address should be used for the order", () => {
 ManageShippingAddressesPage.verifyAddressUsedForOrder();
});

Given("the user has a stored shipping address", () => {
 ManageShippingAddressesPage.storeOneAddress();
});

When("the user selects an address to edit", () => {
 ManageShippingAddressesPage.selectAddressToEdit();
});

When("the user updates the address details", () => {
 ManageShippingAddressesPage.updateAddressDetails();
});

When("the user saves the changes", () => {
 ManageShippingAddressesPage.saveChanges();
});

Then("the updated address should be reflected in the list of stored addresses", () => {
 ManageShippingAddressesPage.verifyUpdatedAddress();
});

Given("the user has multiple stored shipping addresses", () => {
 ManageShippingAddressesPage.storeMultipleAddresses();
});

When("the user selects an address to delete", () => {
 ManageShippingAddressesPage.selectAddressToDelete();
});

When("the user confirms the deletion", () => {
 ManageShippingAddressesPage.confirmDeletion();
});

Then("the address should be removed from the list of stored addresses", () => {
 ManageShippingAddressesPage.verifyAddressRemoved();
});

Then("the remaining addresses should still be visible", () => {
 ManageShippingAddressesPage.verifyRemainingAddressesVisible();
});

When("the user enters an invalid shipping address", () => {
 ManageShippingAddressesPage.enterInvalidShippingAddress();
});

When("the user attempts to save the new address", () => {
 ManageShippingAddressesPage.attemptToSaveInvalidAddress();
});

Then("an error message should be displayed", () => {
 ManageShippingAddressesPage.verifyErrorMessageDisplayed();
});

Then("the invalid address should not be added to the list of stored addresses", () => {
 ManageShippingAddressesPage.verifyInvalidAddressNotAdded();
});