package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.FilterPage;

public class FilterSteps extends FilterPage {

    private TestHarness testHarness = new TestHarness();

    @Given("User is logged into the application")
    public void userIsLoggedIntoTheApplication() {
        loginToApplication();
    }

    @When("User navigates to the product listing page")
    public void userNavigatesToTheProductListingPage() {
        navigateToProductListingPage();
    }

    @Then("The product listing page is displayed with all available products")
    public void theProductListingPageIsDisplayedWithAllAvailableProducts() {
        verifyProductListingPageDisplayed();
    }

    @Given("User is on the product listing page")
    public void userIsOnTheProductListingPage() {
        verifyProductListingPageDisplayed();
    }

    @When("User selects the 'Category' filter and chooses 'Electronics'")
    public void userSelectsTheCategoryFilterAndChoosesElectronics() {
        applyCategoryFilter("Electronics");
    }

    @Then("The product list is updated to show only electronics")
    public void theProductListIsUpdatedToShowOnlyElectronics() {
        verifyCategoryFilterApplied("Electronics");
    }

    @Given("User has applied the 'Category' filter as 'Electronics'")
    public void userHasAppliedTheCategoryFilterAsElectronics() {
        verifyCategoryFilterApplied("Electronics");
    }

    @When("User selects the 'Price Range' filter and sets it to $100 to $500")
    public void userSelectsThePriceRangeFilterAndSetsItTo100To500() {
        applyPriceRangeFilter(100, 500);
    }

    @Then("The product list is further refined to show electronics within the $100 to $500 price range")
    public void theProductListIsFurtherRefinedToShowElectronicsWithinThe100To500PriceRange() {
        verifyPriceRangeFilterApplied(100, 500);
    }

    @Given("User has applied the 'Price Range' filter as $100 to $500")
    public void userHasAppliedThePriceRangeFilterAs100To500() {
        verifyPriceRangeFilterApplied(100, 500);
    }

    @When("User selects the 'Brand' filter and chooses 'BrandX'")
    public void userSelectsTheBrandFilterAndChoosesBrandX() {
        applyBrandFilter("BrandX");
    }

    @Then("The product list is further refined to show BrandX electronics within the specified price range")
    public void theProductListIsFurtherRefinedToShowBrandXElectronicsWithinTheSpecifiedPriceRange() {
        verifyBrandFilterApplied("BrandX");
    }

    @Given("User has applied the 'Brand' filter as 'BrandX'")
    public void userHasAppliedTheBrandFilterAsBrandX() {
        verifyBrandFilterApplied("BrandX");
    }

    @When("User selects the 'Rating' filter and sets it to 4 stars & up")
    public void userSelectsTheRatingFilterAndSetsItTo4StarsAndUp() {
        applyRatingFilter(4);
    }

    @Then("The product list is further refined to show BrandX electronics with a rating of 4 stars and above, within the specified price range")
    public void theProductListIsFurtherRefinedToShowBrandXElectronicsWithARatingOf4StarsAndAboveWithinTheSpecifiedPriceRange() {
        verifyRatingFilterApplied(4);
    }

    @Given("User has applied the 'Rating' filter as 4 stars & up")
    public void userHasAppliedTheRatingFilterAs4StarsAndUp() {
        verifyRatingFilterApplied(4);
    }

    @When("User selects the 'Availability' filter and chooses 'In Stock'")
    public void userSelectsTheAvailabilityFilterAndChoosesInStock() {
        applyAvailabilityFilter("In Stock");
    }

    @Then("The product list is further refined to show BrandX electronics that are in stock, with a rating of 4 stars and above, within the specified price range")
    public void theProductListIsFurtherRefinedToShowBrandXElectronicsThatAreInStockWithARatingOf4StarsAndAboveWithinTheSpecifiedPriceRange() {
        verifyAvailabilityFilterApplied("In Stock");
    }

    @Given("User has applied multiple filters")
    public void userHasAppliedMultipleFilters() {
        verifyMultipleFiltersApplied();
    }

    @Then("All applied filters are correctly displayed in the filter summary section")
    public void allAppliedFiltersAreCorrectlyDisplayedInTheFilterSummarySection() {
        verifyFilterSummary();
    }

    @Then("The number of products displayed matches the expected count based on the applied filters")
    public void theNumberOfProductsDisplayedMatchesTheExpectedCountBasedOnTheAppliedFilters() {
        verifyProductCountMatches();
    }

    @When("User removes one of the filters")
    public void userRemovesOneOfTheFilters() {
        removeFilter();
    }

    @Then("The product list updates to reflect the removal of the selected filter")
    public void theProductListUpdatesToReflectTheRemovalOfTheSelectedFilter() {
        verifyProductListUpdatesAfterFilterRemoval();
    }

    @Given("User has removed a filter")
    public void userHasRemovedAFilter() {
        verifyFilterRemoved();
    }

    @When("User reapplies the removed filter")
    public void userReappliesTheRemovedFilter() {
        reapplyFilter();
    }

    @Then("The product list updates to reflect the reapplication of the filter")
    public void theProductListUpdatesToReflectTheReapplicationOfTheFilter() {
        verifyProductListUpdatesAfterFilterReapplication();
    }

    @Given("User has applied the maximum number of filters")
    public void userHasAppliedTheMaximumNumberOfFilters() {
        verifyMaximumFiltersApplied();
    }

    @When("User attempts to apply an additional filter")
    public void userAttemptsToApplyAnAdditionalFilter() {
        attemptToApplyAdditionalFilter();
    }

    @Then("The system does not allow the application of more filters beyond the maximum limit")
    public void theSystemDoesNotAllowTheApplicationOfMoreFiltersBeyondTheMaximumLimit() {
        verifyAdditionalFilterNotAllowed();
    }

    @When("User uses the filter reset option")
    public void userUsesTheFilterResetOption() {
        resetFilters();
    }

    @Then("All applied filters are cleared, and the full product list is displayed")
    public void allAppliedFiltersAreClearedAndTheFullProductListIsDisplayed() {
        verifyFiltersCleared();
    }

    @Given("User applies multiple filters simultaneously")
    public void userAppliesMultipleFiltersSimultaneously() {
        applyMultipleFilters();
    }

    @Then("The system performance remains optimal with no noticeable lag")
    public void theSystemPerformanceRemainsOptimalWithNoNoticeableLag() {
        verifySystemPerformance();
    }

    @Given("User accesses the filter section on different screen sizes")
    public void userAccessesTheFilterSectionOnDifferentScreenSizes() {
        accessFilterSectionOnDifferentScreenSizes();
    }

    @Then("The filter section is responsive and user-friendly on different screen sizes")
    public void theFilterSectionIsResponsiveAndUserFriendlyOnDifferentScreenSizes() {
        verifyFilterSectionResponsiveness();
    }

    @Given("User has applied specific filter criteria")
    public void userHasAppliedSpecificFilterCriteria() {
        verifySpecificFilterCriteriaApplied();
    }

    @Then("The product list accurately reflects the filter criteria applied")
    public void theProductListAccuratelyReflectsTheFilterCriteriaApplied() {
        verifyProductListAccuracy();
    }
}