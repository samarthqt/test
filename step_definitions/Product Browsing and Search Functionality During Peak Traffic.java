package com.cucumber.steps;

import com.page_objects.ProductBrowsingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductBrowsingSteps extends ProductBrowsingPage {

    @Given("the system is under peak traffic load")
    public void theSystemIsUnderPeakTrafficLoad() {
        simulatePeakTrafficLoad();
    }

    @When("I navigate to the homepage of the retail application")
    public void iNavigateToTheHomepageOfTheRetailApplication() {
        navigateToHomepage();
    }

    @Then("the homepage is displayed with navigation options")
    public void theHomepageIsDisplayedWithNavigationOptions() {
        verifyHomepageDisplayed();
    }

    @Given("the homepage is displayed")
    public void theHomepageIsDisplayed() {
        verifyHomepageDisplayed();
    }

    @When("I click on the 'Categories' dropdown menu")
    public void iClickOnTheCategoriesDropdownMenu() {
        clickCategoriesDropdown();
    }

    @Then("the dropdown menu expands showing available product categories")
    public void theDropdownMenuExpandsShowingAvailableProductCategories() {
        verifyCategoriesDropdownExpanded();
    }

    @When("I select the 'Fashion' category from the dropdown")
    public void iSelectTheFashionCategoryFromTheDropdown() {
        selectFashionCategory();
    }

    @Then("the product listing page displays products under the 'Fashion' category")
    public void theProductListingPageDisplaysProductsUnderTheFashionCategory() {
        verifyFashionCategoryProductsDisplayed();
    }

    @Given("the product listing page is displayed")
    public void theProductListingPageIsDisplayed() {
        verifyProductListingPageDisplayed();
    }

    @When("I enter {string} in the search bar and press enter")
    public void iEnterKeywordInTheSearchBarAndPressEnter(String keyword) {
        enterKeywordInSearchBar(keyword);
    }

    @Then("search results display products related to {string}")
    public void searchResultsDisplayProductsRelatedToKeyword(String keyword) {
        verifySearchResults(keyword);
    }

    @When("I browse and search for products")
    public void iBrowseAndSearchForProducts() {
        browseAndSearchProducts();
    }

    @Then("the system maintains acceptable response times for browsing and searching")
    public void theSystemMaintainsAcceptableResponseTimesForBrowsingAndSearching() {
        verifyResponseTimes();
    }

    @When("I perform various operations")
    public void iPerformVariousOperations() {
        performVariousOperations();
    }

    @Then("the system remains stable and does not crash or slow down excessively")
    public void theSystemRemainsStableAndDoesNotCrashOrSlowDownExcessively() {
        verifySystemStability();
    }

    @When("I use pagination and filtering options")
    public void iUsePaginationAndFilteringOptions() {
        usePaginationAndFiltering();
    }

    @Then("pagination and filtering options work correctly without delays")
    public void paginationAndFilteringOptionsWorkCorrectlyWithoutDelays() {
        verifyPaginationAndFiltering();
    }

    @Given("the search results are displayed")
    public void theSearchResultsAreDisplayed() {
        verifySearchResultsDisplayed();
    }

    @Then("product details such as name, price, and rating are correctly displayed for each item")
    public void productDetailsSuchAsNamePriceAndRatingAreCorrectlyDisplayedForEachItem() {
        verifyProductDetails();
    }

    @When("I click on a product")
    public void iClickOnAProduct() {
        clickOnProduct();
    }

    @Then("I am redirected to the product detail page promptly")
    public void iAmRedirectedToTheProductDetailPagePromptly() {
        verifyProductDetailPageRedirection();
    }

    @Then("the search bar is visible and can be used from any page within the application")
    public void theSearchBarIsVisibleAndCanBeUsedFromAnyPageWithinTheApplication() {
        verifySearchBarVisibility();
    }

    @Given("the search results page is displayed")
    public void theSearchResultsPageIsDisplayed() {
        verifySearchResultsPageDisplayed();
    }

    @When("I choose to return to the homepage")
    public void iChooseToReturnToTheHomepage() {
        returnToHomepage();
    }

    @Then("I can navigate back to the homepage promptly")
    public void iCanNavigateBackToTheHomepagePromptly() {
        verifyHomepageNavigation();
    }
}