import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import GuestCheckoutPage from "../pages/guestCheckoutPage";

Given("a user has items in their shopping cart", () => {
 GuestCheckoutPage.ensureItemsInCart();
});

Given("a user has an empty shopping cart", () => {
 GuestCheckoutPage.ensureCartIsEmpty();
});

Given("a user has items eligible for a special promotion in their shopping cart", () => {
 GuestCheckoutPage.ensureItemsWithPromotion();
});

When("the user opts to checkout as a guest", () => {
 GuestCheckoutPage.checkoutAsGuest();
});

When("the user attempts to checkout as a guest", () => {
 GuestCheckoutPage.attemptGuestCheckout();
});

When("the user provides valid shipping and payment information", () => {
 GuestCheckoutPage.enterValidShippingAndPaymentInfo();
});

When("the user provides incomplete shipping information", () => {
 GuestCheckoutPage.enterIncompleteShippingInfo();
});

When("the user provides invalid payment information", () => {
 GuestCheckoutPage.enterInvalidPaymentInfo();
});

When("the user completes the purchase", () => {
 GuestCheckoutPage.completePurchase();
});

Then("the purchase should be completed successfully", () => {
 GuestCheckoutPage.verifyPurchaseCompletion();
});

Then("the purchase should not be completed", () => {
 GuestCheckoutPage.verifyPurchaseNotCompleted();
});

Then("the user should receive a confirmation message", () => {
 GuestCheckoutPage.verifyConfirmationMessage();
});

Then("the user should be prompted to provide the missing shipping information", () => {
 GuestCheckoutPage.promptForMissingShippingInfo();
});

Then("the user should be notified of the payment error", () => {
 GuestCheckoutPage.notifyPaymentError();
});

Then("the user should not be able to proceed with the checkout", () => {
 GuestCheckoutPage.verifyCannotProceedToCheckout();
});

Then("the user should be prompted to add items to the cart", () => {
 GuestCheckoutPage.promptToAddItems();
});

Then("the special promotion should be applied to the purchase", () => {
 GuestCheckoutPage.verifyPromotionApplied();
});

Then("the user should be offered an option to create an account for future convenience", () => {
 GuestCheckoutPage.offerAccountCreationOption();
});

Then("the user can choose to create an account or continue as a guest", () => {
 GuestCheckoutPage.chooseAccountCreationOrGuest();
});