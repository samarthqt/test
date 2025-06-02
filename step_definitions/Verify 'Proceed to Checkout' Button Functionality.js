import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CartPage from "../pages/cartPage";
import CheckoutPage from "../pages/checkoutPage";

Given("a user account with items added to the cart", () => {
 CartPage.addItemsToCart();
});

Given("a user account with {int} items added to the cart", (number_of_items) => {
 CartPage.addSpecificItemsToCart(number_of_items);
});

Given("a user account with no items in the cart", () => {
 CartPage.ensureCartIsEmpty();
});

Given("a user is on the cart page", () => {
 CartPage.visit();
});

Given("a user is on the cart page using a mobile device", () => {
 cy.viewport('iphone-x');
 CartPage.visit();
});

Given("a user is on the cart page using {string}", (browser) => {
 CartPage.visitWithBrowser(browser);
});

Given("a user clicks the 'Proceed to Checkout' button", () => {
 CartPage.clickProceedToCheckout();
});

Given("a user is on the checkout page", () => {
 CheckoutPage.visit();
});

When("the user logs in to the retail application", () => {
 CartPage.login();
});

When("the user navigates to the cart page", () => {
 CartPage.visit();
});

When("the user clicks the 'Proceed to Checkout' button", () => {
 CartPage.clickProceedToCheckout();
});

Then("the user is redirected to the checkout page", () => {
 cy.url().should("include", "/checkout");
});

Then("the user is redirected to the checkout page on the mobile device", () => {
 cy.url().should("include", "/checkout");
});

Then("the user is redirected to the checkout page on {string}", (browser) => {
 cy.url().should("include", "/checkout");
});

Then("the checkout page displays the correct items in the cart", () => {
 CheckoutPage.verifyItemsInCart();
});

Then("the checkout page displays all {int} items correctly", (number_of_items) => {
 CheckoutPage.verifySpecificNumberOfItemsInCart(number_of_items);
});

Then("the checkout page displays a message indicating no items are present", () => {
 CheckoutPage.verifyEmptyCartMessage();
});

Then("the 'Proceed to Checkout' button is visible and functional", () => {
 CartPage.verifyProceedToCheckoutButton();
});

Then("the checkout page loads successfully without any error messages", () => {
 CheckoutPage.verifyPageLoadsWithoutErrors();
});

Then("the page layout adjusts correctly to screen size", () => {
 CheckoutPage.verifyResponsiveLayout();
});

Then("payment options are visible and selectable", () => {
 CheckoutPage.verifyPaymentOptions();
});

Then("address fields are editable and save inputs correctly", () => {
 CheckoutPage.verifyAddressInputFields();
});