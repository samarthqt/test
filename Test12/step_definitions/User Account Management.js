import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import SignUpPage from "../pages/signUpPage";
import PasswordRecoveryPage from "../pages/passwordRecoveryPage";
import PersonalInfoPage from "../pages/personalInfoPage";
import OrderHistoryPage from "../pages/orderHistoryPage";
import OrderTrackingPage from "../pages/orderTrackingPage";
import WishlistPage from "../pages/wishlistPage";
import AccountSecurityPage from "../pages/accountSecurityPage";
import NotificationsPage from "../pages/notificationsPage";
import ErrorHandlingPage from "../pages/errorHandlingPage";

Given("a user navigates to the sign-up page", () => {
  SignUpPage.visit();
});

When("the user enters valid email and password", () => {
  SignUpPage.enterEmailAndPassword();
});

When("the user selects the option to sign up with Google", () => {
  SignUpPage.signUpWithGoogle();
});

When("the user selects the option to sign up with Facebook", () => {
  SignUpPage.signUpWithFacebook();
});

Then("the user account should be created successfully", () => {
  SignUpPage.verifyAccountCreation();
});

Given("a user navigates to the password recovery page", () => {
  PasswordRecoveryPage.visit();
});

When("the user enters their registered email address", () => {
  PasswordRecoveryPage.enterEmail();
});

When("clicks on the recover password button", () => {
  PasswordRecoveryPage.clickRecoverPassword();
});

Then("a password recovery email should be sent to the user", () => {
  PasswordRecoveryPage.verifyRecoveryEmailSent();
});

Given("a user is logged in", () => {
  // Assume user is logged in
});

When("the user navigates to the personal information page", () => {
  PersonalInfoPage.visit();
});

When("updates their personal information", () => {
  PersonalInfoPage.updateInfo();
});

When("clicks on the save button", () => {
  PersonalInfoPage.saveInfo();
});

Then("the user's personal information should be updated successfully", () => {
  PersonalInfoPage.verifyInfoUpdated();
});

When("the user navigates to the order history page", () => {
  OrderHistoryPage.visit();
});

Then("the user should be able to see a detailed view of past orders", () => {
  OrderHistoryPage.verifyOrderHistory();
});

When("the user navigates to the order tracking page", () => {
  OrderTrackingPage.visit();
});

Then("the user should receive real-time updates on their order status", () => {
  OrderTrackingPage.verifyRealTimeUpdates();
});

When("the user navigates to the wishlist page", () => {
  WishlistPage.visit();
});

When("adds, removes, or organizes products", () => {
  WishlistPage.manageWishlist();
});

Then("the wishlist should be updated accordingly", () => {
  WishlistPage.verifyWishlistUpdated();
});

Given("a user account exists", () => {
  // Assume user account exists
});

When("a user performs account-related actions", () => {
  AccountSecurityPage.performAccountActions();
});

Then("security measures should protect user data", () => {
  AccountSecurityPage.verifySecurityMeasures();
});

When("the user updates account information", () => {
  NotificationsPage.updateAccountInfo();
});

Then("a notification should be sent to the user", () => {
  NotificationsPage.verifyNotificationSent();
});

Given("a user performs an invalid action", () => {
  ErrorHandlingPage.performInvalidAction();
});

When("the system detects the error", () => {
  ErrorHandlingPage.detectError();
});

Then("appropriate error messages should be displayed to the user", () => {
  ErrorHandlingPage.verifyErrorMessage();
});

Given("a user has access to the account management features", () => {
  // Assume user has access
});

When("the user interacts with each feature", () => {
  // Interact with each feature
});

Then("each feature should function as expected without errors", () => {
  // Verify each feature functions correctly
});