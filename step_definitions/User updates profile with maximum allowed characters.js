import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProfilePage from "../pages/profilePage";

Given("a user account with valid login credentials", () => {
 ProfilePage.visitLoginPage();
});

When("the user logs in to the user account", () => {
 ProfilePage.login();
});

Then("the user is logged in successfully and redirected to the dashboard", () => {
 cy.url().should("include", "/dashboard");
});

When("the user navigates to the profile settings page", () => {
 ProfilePage.navigateToProfileSettings();
});

Then("the profile settings page is displayed with current user details", () => {
 ProfilePage.verifyProfileSettingsPage();
});

When("the user updates the name field with maximum allowed characters", () => {
 ProfilePage.updateNameField();
});

Then("the name field is updated with maximum allowed characters", () => {
 ProfilePage.verifyNameFieldUpdate();
});

When("the user updates the email field with maximum allowed characters", () => {
 ProfilePage.updateEmailField();
});

Then("the email field is updated with maximum allowed characters", () => {
 ProfilePage.verifyEmailFieldUpdate();
});

When("the user updates the shipping address field with maximum allowed characters", () => {
 ProfilePage.updateShippingAddressField();
});

Then("the shipping address field is updated with maximum allowed characters", () => {
 ProfilePage.verifyShippingAddressFieldUpdate();
});

When("the user updates the billing address field with maximum allowed characters", () => {
 ProfilePage.updateBillingAddressField();
});

Then("the billing address field is updated with maximum allowed characters", () => {
 ProfilePage.verifyBillingAddressFieldUpdate();
});

When("the user updates the phone number field with maximum allowed characters", () => {
 ProfilePage.updatePhoneNumberField();
});

Then("the phone number field is updated with maximum allowed characters", () => {
 ProfilePage.verifyPhoneNumberFieldUpdate();
});

When("the user saves the changes made to the profile", () => {
 ProfilePage.saveChanges();
});

Then("the changes are saved successfully and a confirmation message is displayed", () => {
 ProfilePage.verifyChangesSaved();
});

When("the user logs out and logs back in to verify updates", () => {
 ProfilePage.logoutAndLogin();
});

Then("updated details are displayed correctly on the profile settings page", () => {
 ProfilePage.verifyUpdatedDetails();
});

When("the user checks email for confirmation of changes", () => {
 ProfilePage.checkEmailConfirmation();
});

Then("email confirmation for each updated detail is received", () => {
 ProfilePage.verifyEmailConfirmation();
});