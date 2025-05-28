import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductBundlesPage from "../pages/productBundlesPage";

Given("I am a registered customer", () => {
 // Assume user is registered
});

Given("I am logged into the e-commerce platform", () => {
 // Assume user is logged in
});

Given("I navigate to the \"Product Bundles\" section", () => {
 ProductBundlesPage.visit();
});

When("I select multiple products to create a bundle", () => {
 ProductBundlesPage.selectProductsForBundle();
});

When("I apply a discount to the bundle", () => {
 ProductBundlesPage.applyDiscount();
});

Then("I should see the total price of the bundle reflecting the discount", () => {
 ProductBundlesPage.verifyDiscountedPrice();
});

Then("the bundle should be added to my cart", () => {
 ProductBundlesPage.verifyBundleInCart();
});

When("I browse through the available bundles", () => {
 ProductBundlesPage.browseAvailableBundles();
});

Then("I should see a list of product bundles with their respective discounts", () => {
 ProductBundlesPage.verifyBundleListWithDiscounts();
});

Given("I have a product bundle in my cart", () => {
 ProductBundlesPage.verifyBundleInCart();
});

When("I choose to edit the bundle", () => {
 ProductBundlesPage.editBundle();
});

When("I add or remove products from the bundle", () => {
 ProductBundlesPage.modifyBundleProducts();
});

When("I update the discount if necessary", () => {
 ProductBundlesPage.updateDiscount();
});

Then("the updated product bundle should reflect the changes", () => {
 ProductBundlesPage.verifyUpdatedBundle();
});

Then("the new total price should be displayed", () => {
 ProductBundlesPage.verifyNewTotalPrice();
});

When("I choose to remove the bundle from my cart", () => {
 ProductBundlesPage.removeBundleFromCart();
});

Then("the product bundle should no longer appear in my cart", () => {
 ProductBundlesPage.verifyBundleNotInCart();
});

Given("I have a discounted product bundle in my cart", () => {
 ProductBundlesPage.verifyBundleInCart();
});

When("I proceed to checkout", () => {
 ProductBundlesPage.proceedToCheckout();
});

When("I complete the payment process", () => {
 ProductBundlesPage.completePaymentProcess();
});

Then("I should receive a confirmation of my purchase", () => {
 ProductBundlesPage.verifyPurchaseConfirmation();
});

Then("the product bundle should be marked as purchased", () => {
 ProductBundlesPage.verifyBundleMarkedAsPurchased();
});