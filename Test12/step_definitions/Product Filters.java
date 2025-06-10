package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.ProductFiltersPage;

public class ProductFiltersSteps extends ProductFiltersPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is on the product listing page")
    public void theUserIsOnTheProductListingPage() {
        String productListingURL = testHarness.getData("ProductData", "ProductListingPageURL");
        navigateToPage(productListingURL);
    }

    @When("the user applies filters for categories, price range, rating, and other attributes")
    public void theUserAppliesFiltersForCategoriesPriceRangeRatingAndOtherAttributes() {
        applyFilters();
    }

    @Then("the product list should update dynamically to reflect the applied filters")
    public void theProductListShouldUpdateDynamicallyToReflectTheAppliedFilters() {
        verifyProductListUpdated();
    }

    @When("the user applies multiple filters at the same time")
    public void theUserAppliesMultipleFiltersAtTheSameTime() {
        applyMultipleFilters();
    }

    @Then("the product list should update dynamically to reflect all applied filters")
    public void theProductListShouldUpdateDynamicallyToReflectAllAppliedFilters() {
        verifyProductListUpdated();
    }

    @When("the user attempts to exploit filter functionality")
    public void theUserAttemptsToExploitFilterFunctionality() {
        attemptFilterExploitation();
    }

    @Then("security measures should prevent exploitation of filters")
    public void securityMeasuresShouldPreventExploitationOfFilters() {
        verifySecurityMeasures();
    }

    @When("the user enters invalid filter criteria")
    public void theUserEntersInvalidFilterCriteria() {
        enterInvalidFilterCriteria();
    }

    @Then("an error message should be displayed to the user")
    public void anErrorMessageShouldBeDisplayedToTheUser() {
        verifyErrorMessageDisplayed();
    }

    @When("the user accesses the page from both desktop and mobile platforms")
    public void theUserAccessesThePageFromBothDesktopAndMobilePlatforms() {
        verifyFilterAvailabilityOnPlatforms();
    }

    @Then("filter options should be available on both platforms")
    public void filterOptionsShouldBeAvailableOnBothPlatforms() {
        verifyFilterAvailabilityOnPlatforms();
    }

    @When("the user applies filters")
    public void theUserAppliesFilters() {
        applyFilters();
    }

    @Then("the system should log filter usage for analytics purposes")
    public void theSystemShouldLogFilterUsageForAnalyticsPurposes() {
        verifyFilterUsageLogged();
    }

    @Then("the integration with the product database should ensure accurate filtering of products")
    public void theIntegrationWithTheProductDatabaseShouldEnsureAccurateFilteringOfProducts() {
        verifyDatabaseIntegration();
    }

    @Then("the product list should update within 3 seconds")
    public void theProductListShouldUpdateWithin3Seconds() {
        verifyPerformance();
    }

    @When("the user applies filters that result in no matching products")
    public void theUserAppliesFiltersThatResultInNoMatchingProducts() {
        applyFiltersWithNoResults();
    }

    @Then("a notification should alert the user that no products match the filters")
    public void aNotificationShouldAlertTheUserThatNoProductsMatchTheFilters() {
        verifyNoProductsNotification();
    }
}