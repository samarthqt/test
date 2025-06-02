package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.FiltersPage;

public class FiltersSteps extends FiltersPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into the application")
    public void theUserIsLoggedIntoTheApplication() {
        loginToApplication();
    }

    @When("the user navigates to the homepage of the application")
    public void theUserNavigatesToTheHomepageOfTheApplication() {
        navigateToHomepage();
    }

    @Then("the homepage is displayed with available filters")
    public void theHomepageIsDisplayedWithAvailableFilters() {
        verifyHomepageWithFilters();
    }

    @When("the user selects the 'Brand' filter and chooses 'Brand A'")
    public void theUserSelectsTheBrandFilterAndChoosesBrandA() {
        applyBrandFilter("Brand A");
    }

    @Then("the filter is applied and results are updated accordingly")
    public void theFilterIsAppliedAndResultsAreUpdatedAccordingly() {
        verifyFilterResults();
    }

    @When("the user selects the 'Price Range' filter and chooses '$100-$200'")
    public void theUserSelectsThePriceRangeFilterAndChooses100To200() {
        applyPriceRangeFilter("$100-$200");
    }

    @When("the user selects the 'Rating' filter and chooses '4 stars and above'")
    public void theUserSelectsTheRatingFilterAndChooses4StarsAndAbove() {
        applyRatingFilter("4 stars and above");
    }

    @When("the user selects the 'Availability' filter and chooses 'In stock'")
    public void theUserSelectsTheAvailabilityFilterAndChoosesInStock() {
        applyAvailabilityFilter("In stock");
    }

    @When("the user selects the 'Category' filter and chooses 'Electronics'")
    public void theUserSelectsTheCategoryFilterAndChoosesElectronics() {
        applyCategoryFilter("Electronics");
    }

    @Then("all selected filters are applied simultaneously")
    public void allSelectedFiltersAreAppliedSimultaneously() {
        verifyAllFiltersApplied();
    }

    @Then("results match the criteria")
    public void resultsMatchTheCriteria() {
        verifyResultsMatchCriteria();
    }

    @Then("filtered results are accurate and match the selected criteria")
    public void filteredResultsAreAccurateAndMatchTheSelectedCriteria() {
        verifyFilteredResultsAccuracy();
    }

    @Then("system performance remains optimal with filters applied")
    public void systemPerformanceRemainsOptimalWithFiltersApplied() {
        verifySystemPerformance();
    }

    @Then("filters display correctly across different devices")
    public void filtersDisplayCorrectlyAcrossDifferentDevices() {
        verifyFiltersDisplayOnDevices();
    }

    @When("the user removes filters individually")
    public void theUserRemovesFiltersIndividually() {
        removeFiltersIndividually();
    }

    @Then("results update accordingly")
    public void resultsUpdateAccordingly() {
        verifyResultsUpdate();
    }

    @When("all filters are removed")
    public void allFiltersAreRemoved() {
        removeAllFilters();
    }

    @Then("the system returns to default results")
    public void theSystemReturnsToDefaultResults() {
        verifyDefaultResults();
    }

    @When("the user resets all filters at once")
    public void theUserResetsAllFiltersAtOnce() {
        resetAllFilters();
    }

    @Then("all filters are reset simultaneously and results return to default")
    public void allFiltersAreResetSimultaneouslyAndResultsReturnToDefault() {
        verifyAllFiltersReset();
    }

    @When("filters are applied in any sequence")
    public void filtersAreAppliedInAnySequence() {
        applyFiltersInSequence();
    }

    @Then("results update correctly")
    public void resultsUpdateCorrectly() {
        verifyResultsUpdateCorrectly();
    }

    @When("the user applies invalid filter combinations")
    public void theUserAppliesInvalidFilterCombinations() {
        applyInvalidFilterCombinations();
    }

    @Then("the system provides feedback for invalid combinations and prevents application")
    public void theSystemProvidesFeedbackForInvalidCombinationsAndPreventsApplication() {
        verifyInvalidCombinationFeedback();
    }
}