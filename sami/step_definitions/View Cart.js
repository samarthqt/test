import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import ShoppingCartPage from '../page_objects/ShoppingCartPage';

const shoppingCartPage = new ShoppingCartPage();

Given('the user is logged into their account', () => {
  // Implement login functionality
});

Given('the user has added products to the shopping cart', () => {
  // Implement adding products to cart functionality
});

When('the user navigates to the shopping cart page', () => {
  shoppingCartPage.navigateToShoppingCart();
});

Then('the user should see all the products they have added to the cart', () => {
  shoppingCartPage.verifyProductsInCart();
});

Then('each product should display its name, quantity, price, and total price', () => {
  shoppingCartPage.verifyProductDetails();
});

Given('the shopping cart is empty', () => {
  shoppingCartPage.emptyCart();
});

Then('the user should see a message indicating that the cart is empty', () => {
  shoppingCartPage.verifyEmptyCartMessage();
});

Given('the user is on the shopping cart page', () => {
  shoppingCartPage.navigateToShoppingCart();
});

Given('the cart contains products', () => {
  shoppingCartPage.verifyCartContainsProducts();
});

When('the user updates the quantity of a product', () => {
  shoppingCartPage.updateProductQuantity();
});

Then('the cart should reflect the updated quantity', () => {
  shoppingCartPage.verifyUpdatedQuantity();
});

Then('the total price should be recalculated accordingly', () => {
  shoppingCartPage.verifyUpdatedTotalPrice();
});

When('the user removes a product from the cart', () => {
  shoppingCartPage.removeProductFromCart();
});

Then('the product should no longer appear in the cart', () => {
  shoppingCartPage.verifyProductRemoved();
});

Then('the total price should be updated accordingly', () => {
  shoppingCartPage.verifyTotalPriceAfterRemoval();
});

When('the user proceeds to checkout', () => {
  shoppingCartPage.proceedToCheckout();
});

Then('the user should be directed to the checkout process', () => {
  shoppingCartPage.verifyCheckoutProcess();
});