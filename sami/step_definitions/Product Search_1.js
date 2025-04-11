import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import ProductSearchPage from '../pageObjects/ProductSearchPage';

const productSearchPage = new ProductSearchPage();

Given('the user is on the product search page', () => {
  productSearchPage.visit();
});

When('the user enters a product name in the search bar', () => {
  productSearchPage.enterProductName('Sample Product');
});

When('the user selects a category from the category dropdown', () => {
  productSearchPage.selectCategory('Sample Category');
});

When('the user enters a non-existent product name in the search bar', () => {
  productSearchPage.enterProductName('NonExistentProduct');
});

When('the user enters special characters in the search bar', () => {
  productSearchPage.enterProductName('!@#$%^&*');
});

When('the user leaves the search bar empty', () => {
  productSearchPage.enterProductName('');
});

When('the user enters a partial product name in the search bar', () => {
  productSearchPage.enterProductName('Partial');
});

When('the user enters a product name in the search bar with different case', () => {
  productSearchPage.enterProductName('sAmPlE pRoDuCt');
});

When('clicks the search button', () => {
  productSearchPage.clickSearchButton();
});

Then('the system should display a list of products that match the entered name', () => {
  productSearchPage.verifyProductListDisplayed();
});

Then('the system should display a list of products that belong to the selected category', () => {
  productSearchPage.verifyProductListDisplayed();
});

Then('the system should display a message indicating no products were found', () => {
  productSearchPage.verifyNoProductsFoundMessage();
});

Then('the system should handle the input gracefully and display a message if no products are found', () => {
  productSearchPage.verifyNoProductsFoundMessage();
});

Then('the system should prompt the user to enter a search term', () => {
  productSearchPage.verifyPromptForSearchTerm();
});

Then('the system should display a list of products that match the partial name', () => {
  productSearchPage.verifyProductListDisplayed();
});

Then('the system should display a list of products that match the entered name regardless of case', () => {
  productSearchPage.verifyProductListDisplayed();
});