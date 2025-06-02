import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CartPage from "../pages/cartPage";

Given("a user account with items added to the cart", () => {
 CartPage.addItemsToCart();
});

When("the user logs in to the retail application", () => {
 CartPage.login();
});

Then("the user successfully logs in", () => {
 CartPage.verifyLoginSuccess();
});

Given("the user has logged in", () => {
 CartPage.verifyLoginSuccess();
});

When("the user navigates to the cart page", () => {
 CartPage.navigateToCart();
});

Then("the cart page is displayed with items", () => {
 CartPage.verifyCartPageDisplayed();
});

Given("the cart contains 3 out-of-stock items", () => {
 CartPage.addOutOfStockItemsToCart(3);
});

When("the user views the cart", () => {
 CartPage.viewCart();
});

Then("out-of-stock items are clearly marked", () => {
 CartPage.verifyOutOfStockItemsMarked();
});

Given("the cart contains mixed in-stock and out-of-stock items", () => {
 CartPage.addMixedStockItemsToCart();
});

When("the user clicks the 'Proceed to Checkout' button", () => {
 CartPage.clickProceedToCheckout();
});

Then("the system checks item availability", () => {
 CartPage.verifyItemAvailabilityCheck();
});

Given("the cart contains out-of-stock items", () => {
 CartPage.addOutOfStockItemsToCart();
});

When("the user attempts to proceed to checkout", () => {
 CartPage.attemptProceedToCheckout();
});

Then("the user receives a notification indicating out-of-stock items", () => {
 CartPage.verifyOutOfStockNotification();
});

Given("the cart contains out-of-stock items", () => {
 CartPage.addOutOfStockItemsToCart();
});

When("the user attempts to remove out-of-stock items from the cart", () => {
 CartPage.removeOutOfStockItems();
});

Then("the items are successfully removed", () => {
 CartPage.verifyItemsRemoved();
});

Given("the cart no longer contains out-of-stock items", () => {
 CartPage.verifyNoOutOfStockItems();
});

When("the user tries proceeding to checkout again", () => {
 CartPage.proceedToCheckoutAgain();
});

Then("the user is redirected to the checkout page without out-of-stock items", () => {
 CartPage.verifyCheckoutPageRedirection();
});

Given("various combinations of in-stock and out-of-stock items in the cart", () => {
 CartPage.addVariousStockItemsToCart();
});

When("the user repeats the checkout attempt", () => {
 CartPage.repeatCheckoutAttempt();
});

Then("the notification for out-of-stock items remains consistent", () => {
 CartPage.verifyConsistentNotification();
});

Given("the user has removed out-of-stock items", () => {
 CartPage.verifyOutOfStockItemsRemoved();
});

When("the user views the checkout page", () => {
 CartPage.viewCheckoutPage();
});

Then("out-of-stock items are not listed on the checkout page", () => {
 CartPage.verifyNoOutOfStockOnCheckout();
});

Given("the user attempts to checkout", () => {
 CartPage.attemptCheckout();
});

When("the system processes the checkout", () => {
 CartPage.processCheckout();
});

Then("no errors other than out-of-stock notification are displayed", () => {
 CartPage.verifyNoOtherErrors();
});

Given("the user is using a mobile device", () => {
 CartPage.useMobileDevice();
});

When("the notification is displayed", () => {
 CartPage.displayNotification();
});

Then("the notification is visible and readable on mobile devices", () => {
 CartPage.verifyNotificationVisibilityMobile();
});

Given("various browsers are used", () => {
 CartPage.useVariousBrowsers();
});

When("the notification is displayed", () => {
 CartPage.displayNotification();
});

Then("the notification is visible and readable on all tested browsers", () => {
 CartPage.verifyNotificationVisibilityBrowsers();
});

Given("the user has removed out-of-stock items", () => {
 CartPage.verifyOutOfStockItemsRemoved();
});

When("the user adds in-stock items", () => {
 CartPage.addInStockItems();
});

Then("in-stock items can be added and proceed to checkout", () => {
 CartPage.verifyInStockItemsAdded();
});

Given("the cart contains only in-stock items", () => {
 CartPage.addOnlyInStockItems();
});

When("the user initiates the checkout process", () => {
 CartPage.initiateCheckoutProcess();
});

Then("the checkout process initiates successfully", () => {
 CartPage.verifySuccessfulCheckoutInitiation();
});

Given("the stock status changes", () => {
 CartPage.changeStockStatus();
});

When("the user views the cart", () => {
 CartPage.viewCart();
});

Then("the cart reflects current stock status accurately", () => {
 CartPage.verifyStockStatusInCart();
});