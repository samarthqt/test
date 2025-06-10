import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import AccountPage from "../pages/accountPage";

Given("a user wants to recover their password", () => {
  AccountPage.visitRecoveryPage();
});

When("the user selects the \"Recover Password\" option", () => {
  AccountPage.selectRecoverPassword();
});

When("the user chooses to receive recovery details via email", () => {
  AccountPage.chooseRecoveryViaEmail();
});

Then("the system sends a recovery email to the user's registered email address", () => {
  AccountPage.verifyRecoveryEmailSent();
});

Then("the user can reset their password using the link in the email", () => {
  AccountPage.verifyPasswordResetLink();
});

When("the user chooses to receive recovery details via SMS", () => {
  AccountPage.chooseRecoveryViaSMS();
});

Then("the system sends a recovery SMS to the user's registered phone number", () => {
  AccountPage.verifyRecoverySMSSent();
});

Then("the user can reset their password using the code in the SMS", () => {
  AccountPage.verifyPasswordResetCode();
});

Given("a user wants to update their personal information", () => {
  AccountPage.visitAccountSettings();
});

When("the user navigates to the account settings", () => {
  AccountPage.navigateToAccountSettings();
});

When("the user updates their name, address, or phone number", () => {
  AccountPage.updatePersonalInformation();
});

Then("the system saves the updated information successfully", () => {
  AccountPage.verifyInformationSaved();
});

Then("the changes are reflected in the user's account details", () => {
  AccountPage.verifyAccountDetailsUpdated();
});

Given("a user wants to change their password", () => {
  AccountPage.visitChangePasswordSection();
});

When("the user navigates to the change password section", () => {
  AccountPage.navigateToChangePassword();
});

When("the user enters their current password and a new password", () => {
  AccountPage.enterCurrentAndNewPassword();
});

Then("the system validates the new password for security", () => {
  AccountPage.validateNewPassword();
});

Then("the system updates the password if validation passes", () => {
  AccountPage.updatePasswordIfValid();
});

Then("the user receives a confirmation of the password change", () => {
  AccountPage.verifyPasswordChangeConfirmation();
});

Given("a user wants to view their past orders", () => {
  AccountPage.visitOrderHistory();
});

When("the user navigates to the order history section", () => {
  AccountPage.navigateToOrderHistory();
});

Then("the system displays a list of past orders with details", () => {
  AccountPage.verifyOrderHistoryDisplayed();
});

Then("each order shows the order date, items, and status", () => {
  AccountPage.verifyOrderDetails();
});

Given("a user wants to track their order delivery", () => {
  AccountPage.visitOrderTracking();
});

When("the user navigates to the order tracking section", () => {
  AccountPage.navigateToOrderTracking();
});

When("the user enters their tracking number", () => {
  AccountPage.enterTrackingNumber();
});

Then("the system displays the current delivery status of the order", () => {
  AccountPage.verifyDeliveryStatusDisplayed();
});

Given("a user wants to manage their wishlist", () => {
  AccountPage.visitWishlist();
});

When("the user navigates to the wishlist section", () => {
  AccountPage.navigateToWishlist();
});

When("the user adds an item to the wishlist", () => {
  AccountPage.addItemToWishlist();
});

Then("the system adds the item to the user's wishlist", () => {
  AccountPage.verifyItemAddedToWishlist();
});

When("the user removes an item from the wishlist", () => {
  AccountPage.removeItemFromWishlist();
});

Then("the system removes the item from the user's wishlist", () => {
  AccountPage.verifyItemRemovedFromWishlist();
});

Given("a user performs any account management action", () => {
  AccountPage.performAccountAction();
});

Then("the system logs the action for auditing purposes", () => {
  AccountPage.verifyActionLogged();
});

Then("the log includes details of the action performed", () => {
  AccountPage.verifyLogDetails();
});

Given("a user encounters an error while managing their account", () => {
  AccountPage.simulateError();
});

Then("the system handles the error gracefully", () => {
  AccountPage.verifyErrorHandledGracefully();
});

Then("the system provides a user-friendly error message", () => {
  AccountPage.verifyUserFriendlyErrorMessage();
});

Given("a user manages their account", () => {
  AccountPage.manageAccount();
});

Then("the system ensures compliance with GDPR", () => {
  AccountPage.verifyGDPRCompliance();
});

Then("the user's data is protected according to GDPR standards", () => {
  AccountPage.verifyDataProtection();
});