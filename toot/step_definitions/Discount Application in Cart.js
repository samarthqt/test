import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CartPage from "../pages/cartPage";

Given("a user has items in their cart", () => {
 CartPage.verifyItemsInCart();
});

And("the cart value qualifies for a percentage discount", () => {
 CartPage.verifyPercentageDiscountEligibility();
});

And("the cart value qualifies for a fixed amount discount", () => {
 CartPage.verifyFixedDiscountEligibility();
});

And("the cart value does not qualify for any discount", () => {
 CartPage.verifyNoDiscountEligibility();
});

And("the cart value qualifies for multiple discounts", () => {
 CartPage.verifyMultipleDiscountEligibility();
});

And("the user has a valid discount coupon code", () => {
 CartPage.verifyValidCouponCode();
});

And("the user has an expired discount coupon code", () => {
 CartPage.verifyExpiredCouponCode();
});

When("the user proceeds to checkout", () => {
 CartPage.proceedToCheckout();
});

When("the user enters the coupon code at checkout", () => {
 CartPage.enterCouponCode();
});

Then("a percentage discount should be automatically applied to the total cart value", () => {
 CartPage.verifyPercentageDiscountApplied();
});

Then("a fixed amount discount should be automatically applied to the total cart value", () => {
 CartPage.verifyFixedDiscountApplied();
});

Then("no discount should be applied to the total cart value", () => {
 CartPage.verifyNoDiscountApplied();
});

Then("only the highest discount should be automatically applied to the total cart value", () => {
 CartPage.verifyHighestDiscountApplied();
});

Then("the discount associated with the coupon should be applied to the total cart value", () => {
 CartPage.verifyCouponDiscountApplied();
});

Then("an error message should be displayed indicating the coupon is invalid", () => {
 CartPage.verifyInvalidCouponError();
});

And("the discount amount should be displayed in the cart summary", () => {
 CartPage.verifyDiscountAmountDisplayed();
});

And("the cart summary should display the full price without any discount", () => {
 CartPage.verifyFullPriceDisplayed();
});