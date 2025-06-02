import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductListingPage from "../pages/productListingPage";

Given("User is logged into the application", () => {
  // Implement login functionality
});

When("User navigates to the product listing page", () => {
  ProductListingPage.visit();
});

Then("The product listing page is displayed with all available products", () => {
  ProductListingPage.verifyAllProductsDisplayed();
});

Given("User is on the product listing page", () => {
  ProductListingPage.verifyOnProductListingPage();
});

When("User selects the 'Category' filter and chooses 'Electronics'", () => {
  ProductListingPage.applyCategoryFilter('Electronics');
});

Then("The product list is updated to show only electronics", () => {
  ProductListingPage.verifyCategoryFilterApplied('Electronics');
});

Given("User has applied the 'Category' filter as 'Electronics'", () => {
  ProductListingPage.verifyCategoryFilterApplied('Electronics');
});

When("User selects the 'Price Range' filter and sets it to $100 to $500", () => {
  ProductListingPage.applyPriceRangeFilter(100, 500);
});

Then("The product list is further refined to show electronics within the $100 to $500 price range", () => {
  ProductListingPage.verifyPriceRangeFilterApplied(100, 500);
});

Given("User has applied the 'Price Range' filter as $100 to $500", () => {
  ProductListingPage.verifyPriceRangeFilterApplied(100, 500);
});

When("User selects the 'Brand' filter and chooses 'BrandX'", () => {
  ProductListingPage.applyBrandFilter('BrandX');
});

Then("The product list is further refined to show BrandX electronics within the specified price range", () => {
  ProductListingPage.verifyBrandFilterApplied('BrandX');
});

Given("User has applied the 'Brand' filter as 'BrandX'", () => {
  ProductListingPage.verifyBrandFilterApplied('BrandX');
});

When("User selects the 'Rating' filter and sets it to 4 stars & up", () => {
  ProductListingPage.applyRatingFilter(4);
});

Then("The product list is further refined to show BrandX electronics with a rating of 4 stars and above, within the specified price range", () => {
  ProductListingPage.verifyRatingFilterApplied(4);
});

Given("User has applied the 'Rating' filter as 4 stars & up", () => {
  ProductListingPage.verifyRatingFilterApplied(4);
});

When("User selects the 'Availability' filter and chooses 'In Stock'", () => {
  ProductListingPage.applyAvailabilityFilter('In Stock');
});

Then("The product list is further refined to show BrandX electronics that are in stock, with a rating of 4 stars and above, within the specified price range", () => {
  ProductListingPage.verifyAvailabilityFilterApplied('In Stock');
});

Given("User has applied multiple filters", () => {
  ProductListingPage.verifyMultipleFiltersApplied();
});

Then("All applied filters are correctly displayed in the filter summary section", () => {
  ProductListingPage.verifyFilterSummary();
});

Then("The number of products displayed matches the expected count based on the applied filters", () => {
  ProductListingPage.verifyProductCountMatches();
});

When("User removes one of the filters", () => {
  ProductListingPage.removeOneFilter();
});

Then("The product list updates to reflect the removal of the selected filter", () => {
  ProductListingPage.verifyProductListAfterFilterRemoval();
});

Given("User has removed a filter", () => {
  ProductListingPage.verifyFilterRemoved();
});

When("User reapplies the removed filter", () => {
  ProductListingPage.reapplyRemovedFilter();
});

Then("The product list updates to reflect the reapplication of the filter", () => {
  ProductListingPage.verifyProductListAfterFilterReapplication();
});

Given("User has applied the maximum number of filters", () => {
  ProductListingPage.verifyMaxFiltersApplied();
});

When("User attempts to apply an additional filter", () => {
  ProductListingPage.attemptToApplyAdditionalFilter();
});

Then("The system does not allow the application of more filters beyond the maximum limit", () => {
  ProductListingPage.verifyMaxFilterLimitEnforced();
});

When("User uses the filter reset option", () => {
  ProductListingPage.resetFilters();
});

Then("All applied filters are cleared, and the full product list is displayed", () => {
  ProductListingPage.verifyAllFiltersCleared();
});

Given("User applies multiple filters simultaneously", () => {
  ProductListingPage.applyMultipleFilters();
});

Then("The system performance remains optimal with no noticeable lag", () => {
  ProductListingPage.verifySystemPerformance();
});

Given("User accesses the filter section on different screen sizes", () => {
  ProductListingPage.accessFilterSectionOnDifferentScreenSizes();
});

Then("The filter section is responsive and user-friendly on different screen sizes", () => {
  ProductListingPage.verifyFilterSectionResponsiveness();
});

Given("User has applied specific filter criteria", () => {
  ProductListingPage.verifySpecificFilterCriteriaApplied();
});

Then("The product list accurately reflects the filter criteria applied", () => {
  ProductListingPage.verifyProductListAccuracy();
});