import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import WishlistPage from '../page_objects/WishlistPage';

const wishlistPage = new WishlistPage();

Given('I am logged into my user account', () => {
    // Implement login functionality
    cy.login();
});

Given('I am on a product page', () => {
    wishlistPage.navigateToProductPage();
});

When('I click on the "Add to Wishlist" button', () => {
    wishlistPage.clickAddToWishlistButton();
});

Then('the product should be added to my wishlist', () => {
    wishlistPage.verifyProductAddedToWishlist();
});

Then('I should see a confirmation message', () => {
    wishlistPage.verifyConfirmationMessage();
});

When('I navigate to the wishlist page', () => {
    wishlistPage.navigateToWishlistPage();
});

Then('I should see a list of all products I have added to my wishlist', () => {
    wishlistPage.verifyProductsInWishlist();
});

Given('I have products in my wishlist', () => {
    wishlistPage.ensureProductsInWishlist();
});

When('I click on the "Remove" button next to a product', () => {
    wishlistPage.clickRemoveButton();
});

Then('the product should be removed from my wishlist', () => {
    wishlistPage.verifyProductRemovedFromWishlist();
});

Given('I am not logged into my user account', () => {
    cy.logout();
});

When('I attempt to add a product to the wishlist', () => {
    wishlistPage.attemptAddToWishlistWithoutLogin();
});

Then('I should be prompted to log in or create an account', () => {
    wishlistPage.verifyLoginOrCreateAccountPrompt();
});

When('I log out and then log back into my account', () => {
    cy.logout();
    cy.login();
});

Then('I should see all previously added products still in my wishlist', () => {
    wishlistPage.verifyProductsPersistInWishlist();
});

Given('I have a product already in my wishlist', () => {
    wishlistPage.ensureProductInWishlist();
});

When('I attempt to add the same product to my wishlist again', () => {
    wishlistPage.attemptAddSameProductAgain();
});

Then('I should not see duplicate entries in my wishlist', () => {
    wishlistPage.verifyNoDuplicateEntries();
});

Then('I should see a message indicating the product is already in the wishlist', () => {
    wishlistPage.verifyAlreadyInWishlistMessage();
});