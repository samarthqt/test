import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import ProductSearchPage from '../pageObjects/ProductSearchPage';

const productSearchPage = new ProductSearchPage();

Given('a user is on the product search page', () => {
  productSearchPage.visit();
});

When('the user enters a keyword in the search bar', () => {
  productSearchPage.enterSearchKeyword('example keyword');
});

When('the user clicks the search button', () => {
  productSearchPage.clickSearchButton();
});

Then('the user should see a list of products matching the keyword', () => {
  productSearchPage.verifySearchResults();
});

Then('the search results should be accurate and relevant', () => {
  productSearchPage.verifySearchResultsRelevance();
});

When('the user selects a category from the filter options', () => {
  productSearchPage.selectCategoryFilter('Electronics');
});

Then('the user should see products filtered by the selected category', () => {
  productSearchPage.verifyCategoryFilterResults();
});

When('the user selects a price range from the filter options', () => {
  productSearchPage.selectPriceRangeFilter('$50 - $100');
});

Then('the user should see products filtered by the selected price range', () => {
  productSearchPage.verifyPriceRangeFilterResults();
});

When('the user selects a rating from the filter options', () => {
  productSearchPage.selectRatingFilter('4 stars & up');
});

Then('the user should see products filtered by the selected rating', () => {
  productSearchPage.verifyRatingFilterResults();
});

When('the user selects multiple filters such as category, price range, and rating', () => {
  productSearchPage.selectMultipleFilters({ category: 'Electronics', price: '$50 - $100', rating: '4 stars & up' });
});

Then('the user should see products filtered by all selected criteria', () => {
  productSearchPage.verifyMultipleFiltersResults();
});

Then('the filters should be applied instantly', () => {
  productSearchPage.verifyInstantFilterApplication();
});

When('the user performs a search or applies filters', () => {
  productSearchPage.performSearchOrFilter();
});

Then('the user should receive a notification about the search or filter operation', () => {
  productSearchPage.verifyNotification();
});

When('the user enters an invalid search query', () => {
  productSearchPage.enterInvalidSearchQuery('invalid!@#');
});

Then('an error message should be displayed to the user', () => {
  productSearchPage.verifyErrorMessage();
});

Then('the operation should be logged for analytics purposes', () => {
  productSearchPage.verifyAnalyticsLogging();
});