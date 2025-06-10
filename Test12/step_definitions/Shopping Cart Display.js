import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ShoppingCartPage from "../pages/shoppingCartPage";

Given("a user has added products to the shopping cart", () => {
 ShoppingCartPage.addProductsToCart();
});

Given("a user has updated product quantities in the shopping cart", () => {
 ShoppingCartPage.updateProductQuantities();
});

Given("a user has multiple items in the shopping cart", () => {
 ShoppingCartPage.addMultipleItemsToCart();
});

Given("a user views the shopping cart on different devices", () => {
 ShoppingCartPage.viewCartOnDifferentDevices();
});

Given("a user has products in the shopping cart", () => {
 ShoppingCartPage.addProductsToCart();
});

Given("a product is out-of-stock", () => {
 ShoppingCartPage.markProductOutOfStock();
});

Given("a user views the shopping cart on different browsers", () => {
 ShoppingCartPage.viewCartOnDifferentBrowsers();
});

Given("a user is viewing the shopping cart", () => {
 ShoppingCartPage.viewCart();
});

When("the shopping cart is viewed", () => {
 ShoppingCartPage.viewCart();
});

When("the user clicks on a product in the cart", () => {
 ShoppingCartPage.clickOnProduct();
});

When("the user decides to checkout", () => {
 ShoppingCartPage.proceedToCheckout();
});

Then("the cart should display product name, price, quantity, and subtotal", () => {
 ShoppingCartPage.verifyProductDetails();
});

Then("the product details should be updated in real-time", () => {
 ShoppingCartPage.verifyRealTimeUpdates();
});

Then("the total price of all items should be displayed", () => {
 ShoppingCartPage.verifyTotalPrice();
});

Then("the system should ensure data integrity and accuracy in product details", () => {
 ShoppingCartPage.verifyDataIntegrity();
});

Then("the cart display should adjust to various screen sizes", () => {
 ShoppingCartPage.verifyResponsiveDisplay();
});

Then("detailed product information should be accessible", () => {
 ShoppingCartPage.verifyProductInformationAccess();
});

Then("the system should prevent display of the out-of-stock product", () => {
 ShoppingCartPage.verifyOutOfStockPrevention();
});

Then("the cart display should be consistent across browsers", () => {
 ShoppingCartPage.verifyConsistentDisplay();
});

Then("the system should provide a clear user interface for easy navigation", () => {
 ShoppingCartPage.verifyClearUserInterface();
});

Then("the user should be able to proceed to checkout directly from the cart display", () => {
 ShoppingCartPage.verifyCheckoutProcess();
});