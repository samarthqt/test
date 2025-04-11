import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import ProductListingPage from '../page_objects/ProductListingPage';

const productListingPage = new ProductListingPage();

Given('I am on the product listing page', () => {
  productListingPage.visit();
});

When('I select {string} from the sort options', (option) => {
  productListingPage.selectSortOption(option);
});

When('I choose {string} order', (order) => {
  productListingPage.selectSortOrder(order);
});

Then('the products should be displayed sorted by {string} in {string} order', (criteria, order) => {
  productListingPage.verifyProductsSorted(criteria, order);
});