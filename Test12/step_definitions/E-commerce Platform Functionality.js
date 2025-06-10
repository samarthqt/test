import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import EcommercePage from "../pages/ecommercePage";

Given("a user is on the e-commerce platform", () => {
 EcommercePage.visit();
});

When("the user navigates through the product categories", () => {
 EcommercePage.navigateCategories();
});

Then("the user should be able to browse products easily on both desktop and mobile platforms", () => {
 EcommercePage.verifyResponsiveDesign();
});

Given("a user has selected products to purchase", () => {
 EcommercePage.selectProducts();
});

When("the user adds a product to the shopping cart", () => {
 EcommercePage.addToCart();
});

Then("the product should be added to the shopping cart", () => {
 EcommercePage.verifyProductInCart();
});

When("the user removes a product from the shopping cart", () => {
 EcommercePage.removeFromCart();
});

Then("the product should be removed from the shopping cart", () => {
 EcommercePage.verifyProductNotInCart();
});

When("the user adjusts the quantity of a product in the shopping cart", () => {
 EcommercePage.adjustProductQuantity();
});

Then("the quantity of the product should be updated in the shopping cart", () => {
 EcommercePage.verifyUpdatedQuantity();
});

Given("a user is ready to checkout", () => {
 EcommercePage.readyToCheckout();
});

When("the user selects a payment method", () => {
 EcommercePage.selectPaymentMethod();
});

Then("secure payment integration should be implemented", () => {
 EcommercePage.verifySecurePayment();
});

Given("a user has placed an order", () => {
 EcommercePage.placeOrder();
});

When("the user views their order details", () => {
 EcommercePage.viewOrderDetails();
});

Then("order tracking features should be available", () => {
 EcommercePage.verifyOrderTracking();
});

Given("a user is on the payment page", () => {
 EcommercePage.visitPaymentPage();
});

When("the user chooses a payment method", () => {
 EcommercePage.choosePaymentMethod();
});

Then("the platform should support multiple payment methods", () => {
 EcommercePage.verifyMultiplePaymentMethods();
});

Given("a user wants to log in", () => {
 EcommercePage.navigateToLogin();
});

When("the user enters their credentials", () => {
 EcommercePage.enterCredentials();
});

Then("user authentication must be secure and reliable", () => {
 EcommercePage.verifyAuthentication();
});

Given("a user is browsing the platform", () => {
 EcommercePage.browsePlatform();
});

When("the user navigates through the website", () => {
 EcommercePage.navigateWebsite();
});

Then("navigation must be intuitive, reducing cart abandonment", () => {
 EcommercePage.verifyIntuitiveNavigation();
});

Given("a user has placed an order", () => {
 EcommercePage.placeOrder();
});

When("there is a change in the order status", () => {
 EcommercePage.changeOrderStatus();
});

Then("the system should provide notifications for order status changes", () => {
 EcommercePage.verifyOrderNotifications();
});

Given("a user is performing shopping activities", () => {
 EcommercePage.performShoppingActivities();
});

When("an error occurs in the process", () => {
 EcommercePage.simulateError();
});

Then("error handling must be implemented for shopping processes", () => {
 EcommercePage.verifyErrorHandling();
});

Given("the e-commerce platform is ready for testing", () => {
 EcommercePage.readyForTesting();
});

When("testing is conducted", () => {
 EcommercePage.conductTesting();
});

Then("testing must confirm seamless functionality across all e-commerce features", () => {
 EcommercePage.verifySeamlessFunctionality();
});