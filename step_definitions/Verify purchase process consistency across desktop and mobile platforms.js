import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import PurchasePage from "../pages/purchasePage";

Given("the application is opened on a desktop browser", () => {
 PurchasePage.openDesktopApp();
});

Given("the application is opened on a mobile browser", () => {
 PurchasePage.openMobileApp();
});

When("the user logs into the application using valid credentials", () => {
 PurchasePage.login();
});

When("navigates to the product page and selects a product to purchase", () => {
 PurchasePage.selectProduct();
});

When("adds the product to the shopping cart", () => {
 PurchasePage.addToCart();
});

When("proceeds to checkout and selects payment method", () => {
 PurchasePage.checkout();
});

Then("the purchase process is completed successfully on the desktop without errors", () => {
 PurchasePage.verifyPurchaseSuccess();
});

Then("the purchase process is completed successfully on the mobile without errors", () => {
 PurchasePage.verifyPurchaseSuccess();
});

Given("the purchase process is completed on both desktop and mobile", () => {
 PurchasePage.completePurchaseOnBothPlatforms();
});

Then("purchase confirmation is received consistently across both platforms", () => {
 PurchasePage.verifyPurchaseConfirmationConsistency();
});

Then("no discrepancies are found; purchase details match across platforms", () => {
 PurchasePage.verifyNoDiscrepancies();
});

Then("no issues are documented; purchase process is consistent across platforms", () => {
 PurchasePage.verifyNoIssuesDocumented();
});