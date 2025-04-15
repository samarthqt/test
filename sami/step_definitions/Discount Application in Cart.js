import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import CartPage from '../pageObjects/CartPage';

const cartPage = new CartPage();

Given('a user has items in their cart', () => {
  cartPage.addItemToCart();
});

And('the cart value qualifies for a percentage discount', () => {
  cartPage.setCartValueForPercentageDiscount();
});

And('the cart value qualifies for a fixed amount discount', () => {
  cartPage.setCartValueForFixedDiscount();
});

And('the cart value does not qualify for any discount', () => {
  cartPage.setCartValueWithoutDiscount();
});

And('the cart value qualifies for multiple discounts', () => {
  cartPage.setCartValueForMultipleDiscounts();
});

And('the user has a valid discount coupon code', () => {
  cartPage.setValidCouponCode();
});

And('the user has an expired discount coupon code', () => {
  cartPage.setExpiredCouponCode();
});

When('the user proceeds to checkout', () => {
  cartPage.proceedToCheckout();
});

When('the user enters the coupon code at checkout', () => {
  cartPage.enterCouponCode();
});

Then('a percentage discount should be automatically applied to the total cart value', () => {
  cartPage.verifyPercentageDiscountApplied();
});

Then('a fixed amount discount should be automatically applied to the total cart value', () => {
  cartPage.verifyFixedDiscountApplied();
});

Then('no discount should be applied to the total cart value', () => {
  cartPage.verifyNoDiscountApplied();
});

Then('only the highest discount should be automatically applied to the total cart value', () => {
  cartPage.verifyHighestDiscountApplied();
});

Then('the discount associated with the coupon should be applied to the total cart value', () => {
  cartPage.verifyCouponDiscountApplied();
});

Then('an error message should be displayed indicating the coupon is invalid', () => {
  cartPage.verifyInvalidCouponMessage();
});

And('the discount amount should be displayed in the cart summary', () => {
  cartPage.verifyDiscountAmountInSummary();
});

And('the cart summary should display the full price without any discount', () => {
  cartPage.verifyFullPriceInSummary();
});