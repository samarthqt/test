import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import ProductPage from '../page_objects/ProductPage';
import CartPage from '../page_objects/CartPage';

const productPage = new ProductPage();
const cartPage = new CartPage();

Given('I am a registered user', () => {
  // Code to ensure user is registered
});

Given('I am logged into the e-commerce platform', () => {
  // Code to log into the platform
});

Given('I have navigated to the product listing page', () => {
  // Code to navigate to product listing
});

Given('I am viewing a product on the product details page', () => {
  productPage.visitProductDetails();
});

When('I click on the {string} button', (button) => {
  if (button === 'Add to Cart') {
    productPage.clickAddToCart();
  }
});

When('I select a quantity of {string}', (quantity) => {
  productPage.selectQuantity(quantity);
});

When('I navigate to another product details page', () => {
  productPage.visitAnotherProductDetails();
});

When('I click on the cart icon', () => {
  cartPage.clickCartIcon();
});

When('I try to add a product to the cart', () => {
  productPage.clickAddToCart();
});

When('I view my cart', () => {
  cartPage.viewCart();
});

When('I choose to remove a product', () => {
  cartPage.removeProduct();
});

Then('the product should be added to the shopping cart', () => {
  cartPage.verifyProductAdded();
});

Then('the cart icon should display the correct number of items', () => {
  cartPage.verifyCartItemCount();
});

Then('three units of the product should be added to the shopping cart', () => {
  cartPage.verifyMultipleProductsAdded(3);
});

Then('both products should be added to the shopping cart', () => {
  cartPage.verifyMultipleProductsAdded(2);
});

Then('I should be taken to the cart page', () => {
  cartPage.verifyCartPage();
});

Then('I should see all the products I have added', () => {
  cartPage.verifyAllProductsInCart();
});

Then('the total price should be correctly calculated', () => {
  cartPage.verifyTotalPrice();
});

Then('I should be prompted to log in or register', () => {
  cartPage.verifyLoginPrompt();
});

Then('I should see the correct product name, price, and quantity', () => {
  cartPage.verifyProductDetails();
});

Then('the product should no longer appear in my cart', () => {
  cartPage.verifyProductRemoved();
});