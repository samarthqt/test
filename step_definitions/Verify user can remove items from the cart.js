import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ShoppingCartPage from "../pages/shoppingCartPage";

Given("the user is logged into the application", () => {
 // Implement login logic here
});

Given("the user navigates to the shopping cart page", () => {
 ShoppingCartPage.visit();
});

Given("the shopping cart page is displayed with current products", () => {
 ShoppingCartPage.verifyCartPageDisplayed();
});

Given("at least one product is added to the cart", () => {
 ShoppingCartPage.verifyProductInCart();
});

When("the user locates the product to be removed from the cart", () => {
 ShoppingCartPage.locateProductToRemove();
});

When("clicks the 'Remove' button next to the product", () => {
 ShoppingCartPage.clickRemoveButton();
});

Then("the product is removed from the cart", () => {
 ShoppingCartPage.verifyProductRemoved();
});

Then("a confirmation message is displayed", () => {
 ShoppingCartPage.verifyConfirmationMessage();
});

Then("the total price is recalculated after product removal", () => {
 ShoppingCartPage.verifyTotalPriceRecalculated();
});

Then("the cart updates immediately and accurately reflects current items", () => {
 ShoppingCartPage.verifyCartUpdates();
});

When("the user attempts to remove a product multiple times", () => {
 ShoppingCartPage.attemptMultipleRemovals();
});

Then("the system prevents multiple removals", () => {
 ShoppingCartPage.verifyPreventsMultipleRemovals();
});

Then("maintains cart integrity", () => {
 ShoppingCartPage.verifyCartIntegrity();
});

When("the user removes all products from the cart", () => {
 ShoppingCartPage.removeAllProducts();
});

Then("the cart is empty", () => {
 ShoppingCartPage.verifyCartIsEmpty();
});

Then("a message indicates no items in the cart", () => {
 ShoppingCartPage.verifyNoItemsMessage();
});

When("the user removes products from the cart", () => {
 ShoppingCartPage.removeProducts();
});

When("logs out and logs back in", () => {
 // Implement logout and re-login logic here
});

Then("the cart remains empty after re-login", () => {
 ShoppingCartPage.verifyCartEmptyAfterRelogin();
});

When("the user removes one product from the cart", () => {
 ShoppingCartPage.removeOneProduct();
});

Then("only the selected product is removed", () => {
 ShoppingCartPage.verifyOnlySelectedProductRemoved();
});

Then("others remain in the cart", () => {
 ShoppingCartPage.verifyOthersRemainInCart();
});

Then("the cart icon displays the correct number of items", () => {
 ShoppingCartPage.verifyCartIconItemCount();
});

Given("the user is not logged into the application", () => {
 // Implement logic to ensure user is not logged in
});

When("the user tries to remove a product from the cart", () => {
 ShoppingCartPage.attemptRemoveWithoutLogin();
});

Then("the user is prompted to log in before removing products from the cart", () => {
 ShoppingCartPage.verifyLoginPrompt();
});

Given("a product with a special promotion is added to the cart", () => {
 ShoppingCartPage.addPromotionalProduct();
});

When("the user removes the promotional product from the cart", () => {
 ShoppingCartPage.removePromotionalProduct();
});

Then("the promotional product is removed successfully", () => {
 ShoppingCartPage.verifyPromotionalProductRemoved();
});

Then("promotions are recalculated", () => {
 ShoppingCartPage.verifyPromotionsRecalculated();
});

Given("bundled products are added to the cart", () => {
 ShoppingCartPage.addBundledProducts();
});

When("the user removes a bundled product from the cart", () => {
 ShoppingCartPage.removeBundledProduct();
});

Then("the system permits removal of bundled products", () => {
 ShoppingCartPage.verifyBundledProductRemoval();
});

When("the user removes a product from the cart", () => {
 ShoppingCartPage.removeProduct();
});

When("undoes the removal", () => {
 ShoppingCartPage.undoRemoval();
});

Then("the product is restored to the cart", () => {
 ShoppingCartPage.verifyProductRestored();
});

Then("the system logs the removal action for auditing purposes", () => {
 ShoppingCartPage.verifyRemovalLogged();
});