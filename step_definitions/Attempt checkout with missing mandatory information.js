import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CheckoutPage from "../pages/checkoutPage";

Given("the user has items in the shopping cart", () => {
  CheckoutPage.ensureItemsInCart();
});

Given("the user is on the checkout page", () => {
  CheckoutPage.visit();
});

When("the user proceeds to checkout without entering the shipping address", () => {
  CheckoutPage.proceedWithoutShippingAddress();
});

When("the user enters an incorrect billing address format", () => {
  CheckoutPage.enterIncorrectBillingAddress();
});

When("the user leaves the payment method field empty and attempts checkout", () => {
  CheckoutPage.leavePaymentMethodEmpty();
});

When("the user enters an invalid credit card number and attempts checkout", () => {
  CheckoutPage.enterInvalidCreditCardNumber();
});

When("the user enters expired credit card details and attempts checkout", () => {
  CheckoutPage.enterExpiredCreditCardDetails();
});

When("the user attempts checkout without agreeing to terms and conditions", () => {
  CheckoutPage.attemptWithoutAgreeingToTerms();
});

When("the user attempts to use a promo code that is expired", () => {
  CheckoutPage.useExpiredPromoCode();
});

When("the user attempts checkout with an invalid CVV number", () => {
  CheckoutPage.enterInvalidCVV();
});

When("the user attempts checkout with incorrect zip code for billing address", () => {
  CheckoutPage.enterIncorrectBillingZipCode();
});

When("the user attempts checkout with incorrect cardholder name", () => {
  CheckoutPage.enterIncorrectCardholderName();
});

When("the user attempts checkout with incorrect expiration date", () => {
  CheckoutPage.enterIncorrectExpirationDate();
});

When("the user attempts checkout with incorrect shipping address format", () => {
  CheckoutPage.enterIncorrectShippingAddressFormat();
});

When("the user attempts checkout with missing phone number for shipping address", () => {
  CheckoutPage.missingPhoneNumberForShipping();
});

Then("an error message is displayed indicating missing shipping information", () => {
  CheckoutPage.verifyMissingShippingInfoError();
});

Then("an error message is displayed indicating incorrect billing address format", () => {
  CheckoutPage.verifyIncorrectBillingAddressError();
});

Then("an error message is displayed indicating missing payment information", () => {
  CheckoutPage.verifyMissingPaymentInfoError();
});

Then("an error message is displayed indicating invalid credit card number", () => {
  CheckoutPage.verifyInvalidCreditCardError();
});

Then("an error message is displayed indicating expired credit card details", () => {
  CheckoutPage.verifyExpiredCreditCardError();
});

Then("an error message is displayed indicating agreement to terms is required", () => {
  CheckoutPage.verifyAgreementToTermsError();
});

Then("an error message is displayed indicating promo code is expired", () => {
  CheckoutPage.verifyExpiredPromoCodeError();
});

Then("an error message is displayed indicating invalid CVV number", () => {
  CheckoutPage.verifyInvalidCVVError();
});

Then("an error message is displayed indicating incorrect zip code", () => {
  CheckoutPage.verifyIncorrectZipCodeError();
});

Then("an error message is displayed indicating incorrect cardholder name", () => {
  CheckoutPage.verifyIncorrectCardholderNameError();
});

Then("an error message is displayed indicating incorrect expiration date", () => {
  CheckoutPage.verifyIncorrectExpirationDateError();
});

Then("an error message is displayed indicating incorrect shipping address format", () => {
  CheckoutPage.verifyIncorrectShippingAddressError();
});

Then("an error message is displayed indicating missing phone number", () => {
  CheckoutPage.verifyMissingPhoneNumberError();
});