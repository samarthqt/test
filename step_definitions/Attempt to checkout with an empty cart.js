import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CartPage from "../pages/cartPage";

Given("the user is logged into the shopping platform", () => {
 // Assume user is already logged in
});

When("the user navigates to the cart page", () => {
 CartPage.visit();
});

Then("the cart page is displayed showing no items", () => {
 CartPage.verifyCartIsEmpty();
});

Then("the cart must be empty", () => {
 CartPage.verifyCartIsEmpty();
});

Given("the cart is empty", () => {
 CartPage.verifyCartIsEmpty();
});

When("the user clicks on the 'Proceed to Checkout' button", () => {
 CartPage.clickProceedToCheckout();
});

Then("the system does not allow proceeding to checkout", () => {
 CartPage.verifyCannotProceedToCheckout();
});

Then("an error message is displayed", () => {
 CartPage.verifyErrorMessageDisplayed();
});

Given("an error message is displayed due to an empty cart", () => {
 CartPage.verifyErrorMessageDisplayed();
});

When("the user reads the error message", () => {
 // No specific action needed, assume reading
});

Then("the error message clearly states that the cart is empty and checkout cannot proceed", () => {
 CartPage.verifyErrorMessageContent();
});

Given("the user is on the cart page", () => {
 CartPage.visit();
});

When("the user adds a product to the cart", () => {
 CartPage.addProductToCart();
});

When("the user proceeds to checkout", () => {
 CartPage.clickProceedToCheckout();
});

Then("the product is added successfully", () => {
 CartPage.verifyProductAdded();
});

Then("checkout can proceed with a non-empty cart", () => {
 CartPage.verifyCheckoutPossible();
});

Given("the user has added items to the cart", () => {
 CartPage.addProductToCart();
});

When("the user removes all items from the cart", () => {
 CartPage.removeAllItemsFromCart();
});

When("attempts to checkout", () => {
 CartPage.clickProceedToCheckout();
});

Then("the same error message is displayed indicating the cart is empty", () => {
 CartPage.verifyErrorMessageDisplayed();
});

Given("the user attempts to checkout with an empty cart", () => {
 CartPage.verifyCartIsEmpty();
 CartPage.clickProceedToCheckout();
});

When("system logs or alerts are checked", () => {
 // Assume logs/alerts are checked
});

Then("they indicate a checkout attempt with an empty cart", () => {
 CartPage.verifyLogForEmptyCartCheckout();
});

When("the checkout attempt is made", () => {
 CartPage.clickProceedToCheckout();
});

Then("the system remains stable and responsive", () => {
 CartPage.verifySystemStability();
});

When("the user interface is reviewed", () => {
 // Assume UI is reviewed
});

Then("the error message is displayed correctly without any layout issues", () => {
 CartPage.verifyErrorMessageLayout();
});

When("the user logs out and logs back in", () => {
 CartPage.logoutAndLogin();
});

Then("the cart remains empty", () => {
 CartPage.verifyCartIsEmpty();
});

Then("no checkout is possible", () => {
 CartPage.verifyCannotProceedToCheckout();
});

When("the order history is checked", () => {
 CartPage.checkOrderHistory();
});

Then("no order is found due to the empty cart", () => {
 CartPage.verifyNoOrderInHistory();
});

Given("the user is on the cart page with an empty cart", () => {
 CartPage.visit();
 CartPage.verifyCartIsEmpty();
});

When("the user attempts to navigate away from the cart page", () => {
 CartPage.attemptNavigationAway();
});

Then("a warning message is displayed asking to confirm navigation without proceeding to checkout", () => {
 CartPage.verifyNavigationWarning();
});

When("the user reviews the system guidance", () => {
 // Assume guidance is reviewed
});

Then("the system suggests adding items to the cart before proceeding to checkout", () => {
 CartPage.verifySystemGuidance();
});

When("the URL is manipulated", () => {
 CartPage.manipulateCheckoutURL();
});

Then("access is denied", () => {
 CartPage.verifyAccessDenied();
});

Then("the user is redirected back to the cart page", () => {
 CartPage.verifyRedirectToCart();
});

When("the user interacts with the system", () => {
 // Assume interaction
});

Then("the system maintains a user-friendly experience with clear guidance and error messages", () => {
 CartPage.verifyUserFriendlyExperience();
});

Given("the user is on the product details page", () => {
 CartPage.visitProductDetailsPage();
});

When("the user adds items from the product details page", () => {
 CartPage.addItemsFromProductDetails();
});

Then("items are added successfully", () => {
 CartPage.verifyProductAdded();
});

Then("checkout proceeds smoothly", () => {
 CartPage.verifyCheckoutPossible();
});