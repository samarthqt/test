import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import ProductSearchPage from '../pageObjects/ProductSearchPage';

const productSearchPage = new ProductSearchPage();

Given('the user is on the product search results page', () => {
  productSearchPage.visit();
});

When('the user selects a price range filter', () => {
  productSearchPage.selectPriceRangeFilter();
});

Then('the search results should only display products within the selected price range', () => {
  productSearchPage.verifyProductsWithinPriceRange();
});

When('the user selects a rating filter', () => {
  productSearchPage.selectRatingFilter();
});

Then('the search results should only display products with the selected rating or higher', () => {
  productSearchPage.verifyProductsWithSelectedRatingOrHigher();
});

When('the user selects both price and rating filters', () => {
  productSearchPage.selectPriceAndRatingFilters();
});

Then('the search results should only display products that meet both the selected price range and rating criteria', () => {
  productSearchPage.verifyProductsMeetingBothCriteria();
});

Given('the user has applied one or more filters', () => {
  productSearchPage.applyFilters();
});

When('the user clears all filters', () => {
  productSearchPage.clearAllFilters();
});

Then('the search results should display all products without any applied filters', () => {
  productSearchPage.verifyAllProductsDisplayed();
});

Given('the user has applied a price filter', () => {
  productSearchPage.applyPriceFilter();
});

When('the user modifies the price filter to a different range', () => {
  productSearchPage.modifyPriceFilter();
});

Then('the search results should update to display products within the new price range', () => {
  productSearchPage.verifyProductsWithinNewPriceRange();
});