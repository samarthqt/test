import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CartPage from "../pages/cartPage";

Given("a user is on the product page", () => {
 CartPage.visitProductPage();
});

When("the user adds a product to the cart", () => {
 CartPage.addProductToCart();
});

Then("the product should be added to the cart successfully", () => {
 CartPage.verifyProductAdded();
});

Given("a user has products in the cart", () => {
 CartPage.ensureProductsInCart();
});

When("the user removes a product from the cart", () => {
 CartPage.removeProductFromCart();
});

Then("the product should be removed from the cart without errors", () => {
 CartPage.verifyProductRemoved();
});

When("the user updates the quantity of a product", () => {
 CartPage.updateProductQuantity();
});

Then("the product quantity should be updated in the cart", () => {
 CartPage.verifyQuantityUpdated();
});

When("the user views the cart", () => {
 CartPage.viewCart();
});

Then("the cart should display product details including name, price, quantity, and subtotal", () => {
 CartPage.verifyCartDetails();
});

When("the user adds, removes, or updates a product", () => {
 CartPage.modifyCart();
});

Then("the changes should be reflected immediately in the cart", () => {
 CartPage.verifyImmediateChanges();
});

Given("a user attempts an invalid cart operation", () => {
 CartPage.performInvalidOperation();
});

When("the operation is performed", () => {
 CartPage.executeOperation();
});

Then("an error message should be displayed to the user", () => {
 CartPage.verifyErrorMessage();
});

Given("a logged-in user has products in the cart", () => {
 CartPage.ensureLoggedInWithProducts();
});

When("the user logs out and logs back in", () => {
 CartPage.logoutAndLogin();
});

Then("the cart should be saved across sessions", () => {
 CartPage.verifyCartSavedAcrossSessions();
});

Given("a user accesses the shopping cart", () => {
 CartPage.accessCart();
});

When("the user interacts with the cart interface", () => {
 CartPage.interactWithCartInterface();
});

Then("the interface should be user-friendly and intuitive", () => {
 CartPage.verifyUserFriendlyInterface();
});

Given("a user performs operations on the cart", () => {
 CartPage.performCartOperations();
});

When("the operations are completed", () => {
 CartPage.completeOperations();
});

Then("the cart operations should be logged for analytics", () => {
 CartPage.verifyOperationsLogged();
});

When("the user performs cart operations", () => {
 CartPage.performCartOperations();
});

Then("the cart should comply with data privacy and security standards", () => {
 CartPage.verifyComplianceWithStandards();
});