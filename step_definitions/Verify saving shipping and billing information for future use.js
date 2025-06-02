import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import AccountSettingsPage from "../pages/accountSettingsPage";

Given("the user is logged into their account", () => {
 // Implement login logic here
});

When("the user navigates to the user account settings", () => {
 AccountSettingsPage.navigateToSettings();
});

Then("the user account settings page is displayed", () => {
 AccountSettingsPage.verifySettingsPageDisplayed();
});

When("the user clicks on the 'Addresses' section", () => {
 AccountSettingsPage.clickAddressesSection();
});

Then("the addresses section is opened", () => {
 AccountSettingsPage.verifyAddressesSectionOpened();
});

When("the user enters shipping address details as {string}", (shippingAddress) => {
 AccountSettingsPage.enterShippingAddress(shippingAddress);
});

When("the user enters billing address details as {string}", (billingAddress) => {
 AccountSettingsPage.enterBillingAddress(billingAddress);
});

When("the user clicks the 'Save' button", () => {
 AccountSettingsPage.clickSaveButton();
});

Then("the shipping and billing information is saved successfully", () => {
 AccountSettingsPage.verifyInformationSaved();
});

When("the user logs out and logs back into the user account", () => {
 // Implement logout and login logic here
});

Then("the saved shipping and billing information is displayed correctly", () => {
 AccountSettingsPage.verifySavedInformationDisplayed();
});

When("the user attempts to make a purchase using the saved billing information", () => {
 AccountSettingsPage.makePurchaseWithSavedBillingInfo();
});

Then("the purchase is completed successfully using saved billing information", () => {
 AccountSettingsPage.verifyPurchaseSuccess();
});

When("the user checks if there is an option to edit saved information", () => {
 AccountSettingsPage.checkEditOptionAvailable();
});

Then("the option to edit saved information is available", () => {
 AccountSettingsPage.verifyEditOptionAvailable();
});

When("the user edits the saved shipping information and saves changes", () => {
 AccountSettingsPage.editShippingInformation();
});

Then("the edited shipping information is saved successfully", () => {
 AccountSettingsPage.verifyEditedInformationSaved();
});

Then("the changes to shipping information are reflected correctly", () => {
 AccountSettingsPage.verifyChangesReflected();
});

When("the user attempts a purchase using the edited shipping information", () => {
 AccountSettingsPage.makePurchaseWithEditedShippingInfo();
});

Then("the purchase is completed successfully using edited shipping information", () => {
 AccountSettingsPage.verifyPurchaseWithEditedInfoSuccess();
});

When("the user checks if there is an option to delete the saved information", () => {
 AccountSettingsPage.checkDeleteOptionAvailable();
});

Then("the option to delete saved information is available", () => {
 AccountSettingsPage.verifyDeleteOptionAvailable();
});

When("the user deletes the saved shipping information and confirms deletion", () => {
 AccountSettingsPage.deleteShippingInformation();
});

Then("the shipping information is deleted successfully", () => {
 AccountSettingsPage.verifyInformationDeleted();
});