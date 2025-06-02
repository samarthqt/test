package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.ProductListingPage;

public class ProductFilteringSteps extends ProductListingPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the product listing page is displayed")
    public void theProductListingPageIsDisplayed() {
        navigateToProductListingPage();
    }

    @When("I select the category {string} from the filter options")
    public void iSelectTheCategoryFromTheFilterOptions(String category) {
        selectCategoryFilter(category);
    }

    @When("I apply the filter")
    public void iApplyTheFilter() {
        applyFilter();
    }

    @Then("the system displays products under {string} category")
    public void theSystemDisplaysProductsUnderCategory(String category) {
        verifyProductsUnderCategory(category);
    }

    @Then("the filtered results include only {string} products")
    public void theFilteredResultsIncludeOnlyProducts(String category) {
        verifyFilteredResultsIncludeOnlyCategory(category);
    }

    @When("I apply any category filter")
    public void iApplyAnyCategoryFilter() {
        applyAnyCategoryFilter();
    }

    @Then("the filtered results are displayed within acceptable time")
    public void theFilteredResultsAreDisplayedWithinAcceptableTime() {
        verifyFilterPerformance();
    }

    @Then("logs reflect all filtering actions and outcomes")
    public void logsReflectAllFilteringActionsAndOutcomes() {
        verifyFilteringLogs();
    }

    @When("I attempt to filter by a non-existent category")
    public void iAttemptToFilterByANonExistentCategory() {
        attemptFilterByNonExistentCategory();
    }

    @Then("the system displays no results found message")
    public void theSystemDisplaysNoResultsFoundMessage() {
        verifyNoResultsFoundMessage();
    }

    @When("I apply category and price filters")
    public void iApplyCategoryAndPriceFilters() {
        applyCategoryAndPriceFilters();
    }

    @Then("the system allows combination of filters and displays accurate results")
    public void theSystemAllowsCombinationOfFiltersAndDisplaysAccurateResults() {
        verifyCombinationOfFilters();
    }

    @Given("the product listing page is displayed on different devices")
    public void theProductListingPageIsDisplayedOnDifferentDevices() {
        navigateToProductListingPageOnDifferentDevices();
    }

    @Then("filtering works consistently across devices")
    public void filteringWorksConsistentlyAcrossDevices() {
        verifyFilteringConsistencyAcrossDevices();
    }

    @When("I reset the filters")
    public void iResetTheFilters() {
        resetFilters();
    }

    @Then("the system resets filters and displays all products")
    public void theSystemResetsFiltersAndDisplaysAllProducts() {
        verifyAllProductsDisplayedAfterReset();
    }

    @When("I navigate to filter options")
    public void iNavigateToFilterOptions() {
        navigateToFilterOptions();
    }

    @Then("filter options are accessible and easy to navigate")
    public void filterOptionsAreAccessibleAndEasyToNavigate() {
        verifyFilterOptionsAccessibility();
    }
}