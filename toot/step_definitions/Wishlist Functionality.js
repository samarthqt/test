import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import WishlistPage from "../pages/wishlistPage";

Given("I am logged into my user account", () => {
 WishlistPage.login();
});

Given("I am on a product page", () => {
 WishlistPage.visitProductPage();
});

When("I click on the \"Add to Wishlist\" button", () => {
 WishlistPage.addToWishlist();
});

Then("the product should be added to my wishlist", () => {
 WishlistPage.verifyProductAdded();
});

Then("I should see a confirmation message", () => {
 WishlistPage.verifyConfirmationMessage();
});

Given("I have products in my wishlist", () => {
 WishlistPage.verifyProductsInWishlist();
});

When("I navigate to the wishlist page", () => {
 WishlistPage.visitWishlistPage();
});

Then("I should see a list of all products I have added to my wishlist", () => {
 WishlistPage.verifyWishlistProducts();
});

When("I click on the \"Remove\" button next to a product", () => {
 WishlistPage.removeProduct();
});

Then("the product should be removed from my wishlist", () => {
 WishlistPage.verifyProductRemoved();
});

Given("I am not logged into my user account", () => {
 WishlistPage.logout();
});

When("I attempt to add a product to the wishlist", () => {
 WishlistPage.attemptAddToWishlist();
});

Then("I should be prompted to log in or create an account", () => {
 WishlistPage.verifyLoginPrompt();
});

When("I log out and then log back into my account", () => {
 WishlistPage.logout();
 WishlistPage.login();
});

Then("I should see all previously added products still in my wishlist", () => {
 WishlistPage.verifyWishlistPersistence();
});

Given("I have a product already in my wishlist", () => {
 WishlistPage.verifyProductAlreadyInWishlist();
});

When("I attempt to add the same product to my wishlist again", () => {
 WishlistPage.attemptAddDuplicateProduct();
});

Then("I should not see duplicate entries in my wishlist", () => {
 WishlistPage.verifyNoDuplicateEntries();
});

Then("I should see a message indicating the product is already in the wishlist", () => {
 WishlistPage.verifyDuplicateMessage();
});