package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.ProductPage;
import com.page_objects.SearchPage;

public class ProductDetailsAndSearchSteps extends ProductPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is on the product page")
    public void theUserIsOnTheProductPage() {
        String productPageURL = testHarness.getData("ProductData", "ProductPageURL");
        navigateToPage(productPageURL);
    }

    @When("the product details are displayed")
    public void theProductDetailsAreDisplayed() {
        verifyProductDetails();
    }

    @Then("the details should include name, description, price, image, stock, and category")
    public void theDetailsShouldIncludeNameDescriptionPriceImageStockAndCategory() {
        verifyProductDetailsContent();
    }

    @Given("the user is on the search page")
    public void theUserIsOnTheSearchPage() {
        String searchPageURL = testHarness.getData("SearchData", "SearchPageURL");
        navigateToPage(searchPageURL);
    }

    @When("the user enters a keyword in the search bar")
    public void theUserEntersAKeywordInTheSearchBar() {
        String keyword = testHarness.getData("SearchData", "Keyword");
        enterSearchKeyword(keyword);
    }

    @Then("the system should return relevant products matching the keyword")
    public void theSystemShouldReturnRelevantProductsMatchingTheKeyword() {
        verifySearchResults();
    }

    @When("the user selects a category filter")
    public void theUserSelectsACategoryFilter() {
        String category = testHarness.getData("SearchData", "Category");
        selectCategoryFilter(category);
    }

    @Then("the system should display products belonging to the selected category")
    public void theSystemShouldDisplayProductsBelongingToTheSelectedCategory() {
        verifyCategoryFilterResults();
    }

    @When("the user sets a price range filter")
    public void theUserSetsAPriceRangeFilter() {
        String priceRange = testHarness.getData("SearchData", "PriceRange");
        setPriceRangeFilter(priceRange);
    }

    @Then("the system should display products within the specified price range")
    public void theSystemShouldDisplayProductsWithinTheSpecifiedPriceRange() {
        verifyPriceRangeFilterResults();
    }

    @When("the user selects a rating filter")
    public void theUserSelectsARatingFilter() {
        String rating = testHarness.getData("SearchData", "Rating");
        selectRatingFilter(rating);
    }

    @Then("the system should display products with the selected rating or higher")
    public void theSystemShouldDisplayProductsWithTheSelectedRatingOrHigher() {
        verifyRatingFilterResults();
    }

    @When("the product details are accessed")
    public void theProductDetailsAreAccessed() {
        accessProductDetails();
    }

    @Then("security measures should protect product data")
    public void securityMeasuresShouldProtectProductData() {
        verifyProductDataSecurity();
    }

    @When("an error occurs during the search process")
    public void anErrorOccursDuringTheSearchProcess() {
        simulateSearchError();
    }

    @Then("appropriate error messages should be displayed to the user")
    public void appropriateErrorMessagesShouldBeDisplayedToTheUser() {
        verifyErrorMessages();
    }

    @Given("the user performs a search")
    public void theUserPerformsASearch() {
        performSearch();
    }

    @When("the search is completed")
    public void theSearchIsCompleted() {
        completeSearch();
    }

    @Then("the system should log the search activity")
    public void theSystemShouldLogTheSearchActivity() {
        verifySearchActivityLog();
    }

    @When("product details are retrieved")
    public void productDetailsAreRetrieved() {
        retrieveProductDetails();
    }

    @Then("the integration with product databases should be seamless")
    public void theIntegrationWithProductDatabasesShouldBeSeamless() {
        verifyDatabaseIntegration();
    }

    @When("there are changes in search results or filters")
    public void thereAreChangesInSearchResultsOrFilters() {
        detectSearchChanges();
    }

    @Then("notifications should alert users to these changes")
    public void notificationsShouldAlertUsersToTheseChanges() {
        verifyUserNotifications();
    }

    @Given("the user is testing the search functionality")
    public void theUserIsTestingTheSearchFunctionality() {
        testSearchFunctionality();
    }

    @When("various search features are used")
    public void variousSearchFeaturesAreUsed() {
        useSearchFeatures();
    }

    @Then("testing should confirm functionality across all product search features")
    public void testingShouldConfirmFunctionalityAcrossAllProductSearchFeatures() {
        confirmSearchFunctionality();
    }

    @Given("the user needs information on product search and display functionalities")
    public void theUserNeedsInformationOnProductSearchAndDisplayFunctionalities() {
        accessDocumentation();
    }

    @When("documentation is accessed")
    public void documentationIsAccessed() {
        viewDocumentation();
    }

    @Then("comprehensive documentation should be provided")
    public void comprehensiveDocumentationShouldBeProvided() {
        verifyDocumentationContent();
    }
}