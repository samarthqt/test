import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ShoppingPage from "../pages/shoppingPage";

Given("the application is deployed and accessible", () => {
 ShoppingPage.visit();
});

When("I open the application on a desktop browser", () => {
 ShoppingPage.openDesktopBrowser();
});

Then("the application loads successfully on the desktop browser", () => {
 ShoppingPage.verifyDesktopLoad();
});

Given("I have valid user credentials", () => {
 ShoppingPage.setUserCredentials();
});

When("I log in using valid user credentials", () => {
 ShoppingPage.login();
});

Then("I am redirected to the homepage", () => {
 ShoppingPage.verifyHomepageRedirect();
});

Given("I am on the homepage", () => {
 ShoppingPage.verifyOnHomepage();
});

When("I perform a product search using relevant keywords", () => {
 ShoppingPage.searchProduct();
});

Then("search results are displayed accurately based on the keywords", () => {
 ShoppingPage.verifySearchResults();
});

Given("search results are displayed", () => {
 ShoppingPage.verifySearchResultsDisplayed();
});

When("I add a product to the shopping cart", () => {
 ShoppingPage.addProductToCart();
});

Then("the product is added to the cart successfully", () => {
 ShoppingPage.verifyProductAddedToCart();
});

Given("a product is added to the cart", () => {
 ShoppingPage.verifyProductInCart();
});

When("I proceed to checkout and fill in the required details", () => {
 ShoppingPage.proceedToCheckout();
});

Then("checkout process is completed successfully with all details filled", () => {
 ShoppingPage.verifyCheckoutCompletion();
});

Given("the checkout process is completed", () => {
 ShoppingPage.verifyCheckoutCompleted();
});

When("I verify the order confirmation details", () => {
 ShoppingPage.verifyOrderConfirmation();
});

Then("order confirmation is displayed with correct details", () => {
 ShoppingPage.verifyOrderDetails();
});

Given("I am logged in", () => {
 ShoppingPage.verifyLoggedIn();
});

When("I log out from the desktop session", () => {
 ShoppingPage.logout();
});

Then("I log out successfully", () => {
 ShoppingPage.verifyLogout();
});

When("I open the application on a mobile browser", () => {
 ShoppingPage.openMobileBrowser();
});

Then("the application loads successfully on the mobile browser", () => {
 ShoppingPage.verifyMobileLoad();
});

When("I log in using the same user credentials on mobile", () => {
 ShoppingPage.loginMobile();
});

Then("I am redirected to the homepage on mobile", () => {
 ShoppingPage.verifyMobileHomepageRedirect();
});

Given("I am on the homepage on mobile", () => {
 ShoppingPage.verifyOnMobileHomepage();
});

When("I perform a product search using relevant keywords and add a different product to the cart", () => {
 ShoppingPage.searchAndAddProductMobile();
});

Then("search results are accurate, and the product is added to the cart successfully", () => {
 ShoppingPage.verifyMobileSearchAndCart();
});

When("I proceed to checkout on mobile and fill in the required details", () => {
 ShoppingPage.proceedToCheckoutMobile();
});

Then("checkout process is completed successfully on mobile", () => {
 ShoppingPage.verifyMobileCheckoutCompletion();
});

Given("the checkout process is completed on mobile", () => {
 ShoppingPage.verifyMobileCheckoutCompleted();
});

When("I verify the order confirmation details on mobile", () => {
 ShoppingPage.verifyMobileOrderConfirmation();
});

Then("order confirmation is displayed with correct details on mobile", () => {
 ShoppingPage.verifyMobileOrderDetails();
});

Given("I have access to both desktop and mobile platforms", () => {
 ShoppingPage.verifyPlatformAccess();
});

When("I check the application's responsiveness and UI consistency across desktop and mobile", () => {
 ShoppingPage.checkResponsivenessAndUI();
});

Then("the application is responsive and the UI is consistent across both platforms", () => {
 ShoppingPage.verifyResponsivenessAndUI();
});

When("I test the application's performance on both platforms", () => {
 ShoppingPage.testPerformance();
});

Then("the application performs efficiently without any lag or delay on both platforms", () => {
 ShoppingPage.verifyPerformance();
});

Given("I am logged in on mobile", () => {
 ShoppingPage.verifyLoggedInMobile();
});

When("I log out from the mobile session", () => {
 ShoppingPage.logoutMobile();
});

Then("I log out successfully on mobile", () => {
 ShoppingPage.verifyMobileLogout();
});