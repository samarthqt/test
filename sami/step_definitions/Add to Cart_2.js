import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import ProductPage from '../pageObjects/ProductPage';
import CartPage from '../pageObjects/CartPage';

const productPage = new ProductPage();
const cartPage = new CartPage();

Given('the user is on the product listing page', () => {
  cy.visit('/products');
});

When('the user selects a product', () => {
  productPage.selectProduct();
});

When('the user clicks on the "Add to Cart" button', () => {
  productPage.clickAddToCart();
});

Then('the product should be added to the shopping cart', () => {
  cartPage.verifyProductAdded();
});

Then('the cart should display the added product', () => {
  cartPage.verifyCartDisplay();
});

When('the user selects multiple products', () => {
  productPage.selectMultipleProducts();
});

When('the user clicks on the "Add to Cart" button for each product', () => {
  productPage.clickAddToCartForEach();
});

Then('all selected products should be added to the shopping cart', () => {
  cartPage.verifyMultipleProductsAdded();
});

Then('the cart should display all the added products', () => {
  cartPage.verifyCartDisplayMultiple();
});

When('the user clicks on the "Add to Cart" button multiple times', () => {
  productPage.clickAddToCartMultipleTimes();
});

Then('the cart should reflect the correct quantity of the product', () => {
  cartPage.verifyCorrectQuantity();
});

When('the user adds a product to the cart', () => {
  productPage.addProductToCart();
});

When('the user navigates to the shopping cart page', () => {
  cartPage.navigateToCart();
});

Then('the cart should list all products added', () => {
  cartPage.verifyAllProductsListed();
});

Then('the total cost should be correctly calculated', () => {
  cartPage.verifyTotalCost();
});

Given('the user is not logged in', () => {
  cy.logout();
});

Then('the user should be prompted to log in or register', () => {
  cartPage.verifyLoginPrompt();
});

Given('the product is out of stock', () => {
  productPage.selectOutOfStockProduct();
});

Then('the user should be notified that the product is out of stock', () => {
  cartPage.verifyOutOfStockNotification();
});

Then('the product should not be added to the cart', () => {
  cartPage.verifyProductNotAdded();
});