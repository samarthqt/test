package com.cucumber.steps;

import com.page_objects.ProductCatalogPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductCatalogSteps extends ProductCatalogPage {

    @Given("the user is logged into the application")
    public void theUserIsLoggedIntoTheApplication() {
        loginToApplication();
    }

    @Given("the user is on the product catalog page")
    public void theUserIsOnTheProductCatalogPage() {
        navigateToProductCatalog();
    }

    @When("the user navigates to the product catalog")
    public void theUserNavigatesToTheProductCatalog() {
        navigateToProductCatalog();
    }

    @Then("the product catalog is displayed with filter options")
    public void theProductCatalogIsDisplayedWithFilterOptions() {
        verifyFilterOptionsDisplayed();
    }

    @When("the user selects the 'Electronics' category filter")
    public void theUserSelectsTheElectronicsCategoryFilter() {
        applyCategoryFilter("Electronics");
    }

    @Then("products related to the 'Electronics' category are displayed")
    public void productsRelatedToTheElectronicsCategoryAreDisplayed() {
        verifyProductsDisplayedByCategory("Electronics");
    }

    @Then("all displayed products belong to the 'Electronics' category")
    public void allDisplayedProductsBelongToTheElectronicsCategory() {
        verifyAllProductsBelongToCategory("Electronics");
    }

    @When("the user applies a price filter of $100 - $500")
    public void theUserAppliesAPriceFilterOf100To500() {
        applyPriceFilter(100, 500);
    }

    @Then("products within the price range of $100 - $500 are displayed")
    public void productsWithinThePriceRangeOf100To500AreDisplayed() {
        verifyProductsDisplayedByPriceRange(100, 500);
    }

    @Then("all displayed products are within the specified price range")
    public void allDisplayedProductsAreWithinTheSpecifiedPriceRange() {
        verifyAllProductsWithinPriceRange(100, 500);
    }

    @When("the user applies a rating filter of 4 stars and above")
    public void theUserAppliesARatingFilterOf4StarsAndAbove() {
        applyRatingFilter(4);
    }

    @Then("products with a rating of 4 stars and above are displayed")
    public void productsWithARatingOf4StarsAndAboveAreDisplayed() {
        verifyProductsDisplayedByRating(4);
    }

    @Then("all displayed products have a rating of 4 stars and above")
    public void allDisplayedProductsHaveARatingOf4StarsAndAbove() {
        verifyAllProductsHaveRating(4);
    }

    @When("the user combines category, price, and rating filters")
    public void theUserCombinesCategoryPriceAndRatingFilters() {
        applyCombinedFilters("Electronics", 100, 500, 4);
    }

    @Then("products satisfying all selected filters are displayed")
    public void productsSatisfyingAllSelectedFiltersAreDisplayed() {
        verifyProductsDisplayedByCombinedFilters("Electronics", 100, 500, 4);
    }

    @When("the user applies filters and then resets them")
    public void theUserAppliesFiltersAndThenResetsThem() {
        applyFiltersAndReset();
    }

    @Then("the filter reset functionality is available and works correctly")
    public void theFilterResetFunctionalityIsAvailableAndWorksCorrectly() {
        verifyFilterResetFunctionality();
    }

    @When("the user applies filters with no products meeting the criteria")
    public void theUserAppliesFiltersWithNoProductsMeetingTheCriteria() {
        applyFiltersWithNoMatchingProducts();
    }

    @Then("an appropriate message is displayed when no products meet the filter criteria")
    public void anAppropriateMessageIsDisplayedWhenNoProductsMeetTheFilterCriteria() {
        verifyNoProductsMessageDisplayed();
    }

    @When("the user applies any filter")
    public void theUserAppliesAnyFilter() {
        applyAnyFilter();
    }

    @Then("filters are applied promptly without delay")
    public void filtersAreAppliedPromptlyWithoutDelay() {
        verifyFilterPerformance();
    }

    @Given("the user accesses the product catalog page on different devices")
    public void theUserAccessesTheProductCatalogPageOnDifferentDevices() {
        accessCatalogOnDifferentDevices();
    }

    @Then("filter functionality is consistent across various devices and screen sizes")
    public void filterFunctionalityIsConsistentAcrossVariousDevicesAndScreenSizes() {
        verifyFilterConsistencyAcrossDevices();
    }

    @Given("the user applies filters on the product catalog page")
    public void theUserAppliesFiltersOnTheProductCatalogPage() {
        applyFiltersOnCatalogPage();
    }

    @When("the user navigates away and returns to the catalog")
    public void theUserNavigatesAwayAndReturnsToTheCatalog() {
        navigateAwayAndReturnToCatalog();
    }

    @Then("selected filters persist after navigation")
    public void selectedFiltersPersistAfterNavigation() {
        verifyFilterPersistenceAfterNavigation();
    }

    @Then("the product count accurately reflects the number of filtered products")
    public void theProductCountAccuratelyReflectsTheNumberOfFilteredProducts() {
        verifyProductCountAccuracy();
    }

    @When("the user applies multiple filters simultaneously")
    public void theUserAppliesMultipleFiltersSimultaneously() {
        applyMultipleFiltersSimultaneously();
    }

    @Then("multiple filters can be applied simultaneously without issue")
    public void multipleFiltersCanBeAppliedSimultaneouslyWithoutIssue() {
        verifyMultipleFiltersFunctionality();
    }
}