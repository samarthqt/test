import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import ProductSearchPage from '../page_objects/ProductSearchPage';

const productSearchPage = new ProductSearchPage();

Given('I am on the product search page', () => {
  productSearchPage.visit();
});

When('I enter {string} in the search bar', (productName) => {
  productSearchPage.enterProductName(productName);
});

When('I select {string} from the category dropdown', (category) => {
  productSearchPage.selectCategory(category);
});

When('I leave the search bar empty', () => {
  productSearchPage.clearSearchBar();
});

When('I click on the search button', () => {
  productSearchPage.clickSearchButton();
});

Then('I should see a list of products with names containing {string}', (productName) => {
  productSearchPage.verifyProductListContains(productName);
});

Then('I should see a list of products under the {string} category', (category) => {
  productSearchPage.verifyProductListUnderCategory(category);
});

Then('I should see a message {string}', (message) => {
  productSearchPage.verifyNoProductsFoundMessage(message);
});

Then('I should see a validation message {string}', (validationMessage) => {
  productSearchPage.verifyValidationMessage(validationMessage);
});