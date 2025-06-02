import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ShoppingCartPage from "../pages/shoppingCartPage";

Given("the user is logged in", () => {
 ShoppingCartPage.login();
});

When("the user adds products to the shopping cart", () => {
 ShoppingCartPage.addProducts();
});

Then("the products are successfully added to the cart", () => {
 ShoppingCartPage.verifyProductsAdded();
});

Given("the user is logged out successfully", () => {
 ShoppingCartPage.logout();
});

When("the user logs back into the session", () => {
 ShoppingCartPage.login();
});

Then("the shopping cart displays previously added products", () => {
 ShoppingCartPage.verifyCartPersistence();
});

Given("the user navigates to the shopping cart", () => {
 ShoppingCartPage.navigateToCart();
});

Then("the product details and quantities match the previous session", () => {
 ShoppingCartPage.verifyProductDetailsAndQuantities();
});

Given("the user is logged out", () => {
 ShoppingCartPage.logout();
});

When("the user logs in from a different device", () => {
 ShoppingCartPage.loginDifferentDevice();
});

Then("the cart contents remain consistent across devices", () => {
 ShoppingCartPage.verifyCartConsistencyAcrossDevices();
});

Given("the user adds more products to the cart", () => {
 ShoppingCartPage.addMoreProducts();
});

When("the user logs out", () => {
 ShoppingCartPage.logout();
});

Then("the new products are added successfully", () => {
 ShoppingCartPage.verifyNewProductsAdded();
});

Given("the user logs back in", () => {
 ShoppingCartPage.login();
});

Then("the cart should reflect new additions accurately", () => {
 ShoppingCartPage.verifyCartReflectsNewAdditions();
});

Given("the user clears browser cache", () => {
 ShoppingCartPage.clearBrowserCache();
});

When("the user logs in again", () => {
 ShoppingCartPage.login();
});

Then("the cart contents should remain intact despite cache clearing", () => {
 ShoppingCartPage.verifyCartIntactAfterCacheClearing();
});

Given("the user switches network", () => {
 ShoppingCartPage.switchNetwork();
});

When("the user logs in", () => {
 ShoppingCartPage.login();
});

Then("the cart persistence should be unaffected by network changes", () => {
 ShoppingCartPage.verifyCartPersistenceAfterNetworkChange();
});

Given("the user repeats the test on a mobile browser", () => {
 ShoppingCartPage.repeatTestOnMobileBrowser();
});

Then("the cart contents should persist on mobile browsers too", () => {
 ShoppingCartPage.verifyCartPersistenceOnMobileBrowser();
});

Given("the user navigates to the shopping cart", () => {
 ShoppingCartPage.navigateToCart();
});

Then("the cart total should be accurate and consistent", () => {
 ShoppingCartPage.verifyCartTotalAccuracy();
});

Given("the user attempts to remove a product", () => {
 ShoppingCartPage.removeProduct();
});

When("the user logs out", () => {
 ShoppingCartPage.logout();
});

Then("the product removal should be successful and reflect in the next session", () => {
 ShoppingCartPage.verifyProductRemovalPersistence();
});

Given("the user logs in using a guest account", () => {
 ShoppingCartPage.loginGuestAccount();
});

Then("the guest cart should not persist across sessions", () => {
 ShoppingCartPage.verifyGuestCartNonPersistence();
});

Given("the user performs session transitions", () => {
 ShoppingCartPage.performSessionTransitions();
});

Then("no console errors should appear during the test execution", () => {
 ShoppingCartPage.verifyNoConsoleErrors();
});