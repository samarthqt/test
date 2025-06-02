import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import OrderPage from "../pages/orderPage";

Given("the user is logged into the application", () => {
 OrderPage.ensureUserIsLoggedIn();
});

When("the user completes a purchase transaction", () => {
 OrderPage.completePurchaseTransaction();
});

Then("the purchase transaction is completed successfully", () => {
 OrderPage.verifyTransactionSuccess();
});

Then("the user has completed a purchase", () => {
 OrderPage.verifyPurchaseCompletion();
});

Given("the user's email is {string}", (email) => {
 OrderPage.setUserEmail(email);
});

When("the purchase transaction is completed", () => {
 OrderPage.completePurchaseTransaction();
});

Then("the user receives an order confirmation email with correct order details", () => {
 OrderPage.verifyEmailReceiptWithDetails();
});

Given("the user's phone number is {string}", (phoneNumber) => {
 OrderPage.setUserPhoneNumber(phoneNumber);
});

Then("the user receives an order confirmation SMS with correct order details", () => {
 OrderPage.verifySmsReceiptWithDetails();
});

Given("the user has received an order confirmation email", () => {
 OrderPage.ensureEmailReceived();
});

Then("the email contains order ID, product details, and total amount", () => {
 OrderPage.verifyEmailContent();
});

Given("the user has received an order confirmation SMS", () => {
 OrderPage.ensureSmsReceived();
});

Then("the SMS contains order ID and total amount", () => {
 OrderPage.verifySmsContent();
});

Given("the user has completed a purchase", () => {
 OrderPage.ensurePurchaseIsCompleted();
});

Then("notifications are received immediately after purchase", () => {
 OrderPage.verifyTimelinessOfNotifications();
});

When("the user logs out from the account", () => {
 OrderPage.logout();
});

Then("the user is logged out successfully", () => {
 OrderPage.verifyLogoutSuccess();
});