import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import ManageShippingAddressesPage from '../pages/ManageShippingAddressesPage';

const manageShippingAddressesPage = new ManageShippingAddressesPage();

Given('the user is logged into their account', () => {
    // Implement login functionality
});

Given('the user is on the {string} page', (page) => {
    manageShippingAddressesPage.navigateTo(page);
});

When('the user clicks on {string}', (button) => {
    manageShippingAddressesPage.clickButton(button);
});

When('the user enters a valid shipping address', () => {
    manageShippingAddressesPage.enterValidShippingAddress();
});

When('the user enters another valid shipping address', () => {
    manageShippingAddressesPage.enterAnotherValidShippingAddress();
});

When('the user enters an invalid shipping address', () => {
    manageShippingAddressesPage.enterInvalidShippingAddress();
});

When('the user saves the new address', () => {
    manageShippingAddressesPage.saveAddress();
});

When('the user saves the changes', () => {
    manageShippingAddressesPage.saveChanges();
});

When('the user proceeds to checkout', () => {
    manageShippingAddressesPage.proceedToCheckout();
});

When('the user selects a stored shipping address', () => {
    manageShippingAddressesPage.selectStoredAddress();
});

When('the user selects an address to edit', () => {
    manageShippingAddressesPage.selectAddressToEdit();
});

When('the user updates the address details', () => {
    manageShippingAddressesPage.updateAddressDetails();
});

When('the user selects an address to delete', () => {
    manageShippingAddressesPage.selectAddressToDelete();
});

When('the user confirms the deletion', () => {
    manageShippingAddressesPage.confirmDeletion();
});

Then('the new address should be added to the list of stored addresses', () => {
    manageShippingAddressesPage.verifyNewAddressAdded();
});

Then('both addresses should be visible in the list of stored addresses', () => {
    manageShippingAddressesPage.verifyMultipleAddressesVisible();
});

Then('the selected address should be used for the order', () => {
    manageShippingAddressesPage.verifySelectedAddressUsed();
});

Then('the updated address should be reflected in the list of stored addresses', () => {
    manageShippingAddressesPage.verifyUpdatedAddress();
});

Then('the address should be removed from the list of stored addresses', () => {
    manageShippingAddressesPage.verifyAddressRemoved();
});

Then('the remaining addresses should still be visible', () => {
    manageShippingAddressesPage.verifyRemainingAddressesVisible();
});

Then('an error message should be displayed', () => {
    manageShippingAddressesPage.verifyErrorMessageDisplayed();
});

Then('the invalid address should not be added to the list of stored addresses', () => {
    manageShippingAddressesPage.verifyInvalidAddressNotAdded();
});