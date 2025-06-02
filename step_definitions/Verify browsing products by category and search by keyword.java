package com.cucumber.steps;

import com.page_objects.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductBrowsingSteps extends HomePage {

    @Given("the user is logged into the application")
    public void theUserIsLoggedIntoTheApplication() {
        loginToApplication();
    }

    @When("the user navigates to the homepage of the retail application")
    public void theUserNavigatesToTheHomepageOfTheRetailApplication() {
        navigateToHomepage();
    }

    @Then("the homepage is displayed with navigation options")
    public void theHomepageIsDisplayedWithNavigationOptions() {
        verifyHomepageNavigationOptions();
    }

    @Then("product categories are defined")
    public void productCategoriesAreDefined() {
        verifyProductCategoriesDefined();
    }

    @When("the user clicks on the 'Categories' dropdown menu")
    public void theUserClicksOnTheCategoriesDropdownMenu() {
        clickCategoriesDropdown();
    }

    @Then("the dropdown menu expands showing available product categories")
    public void theDropdownMenuExpandsShowingAvailableProductCategories() {
        verifyDropdownMenuExpansion();
    }

    @When("the user selects the 'Electronics' category from the dropdown")
    public void theUserSelectsTheElectronicsCategoryFromTheDropdown() {
        selectElectronicsCategory();
    }

    @Then("the product listing page displays products under the 'Electronics' category")
    public void theProductListingPageDisplaysProductsUnderTheElectronicsCategory() {
        verifyElectronicsCategoryProducts();
    }

    @Given("the user is on the homepage of the retail application")
    public void theUserIsOnTheHomepageOfTheRetailApplication() {
        navigateToHomepage();
    }

    @When("the user enters {string} in the search bar and presses enter")
    public void theUserEntersKeywordInTheSearchBarAndPressesEnter(String keyword) {
        enterKeywordInSearchBar(keyword);
    }

    @Then("search results display products related to {string}")
    public void searchResultsDisplayProductsRelatedToKeyword(String keyword) {
        verifySearchResults(keyword);
    }

    @Then("all displayed products are relevant to the search keyword")
    public void allDisplayedProductsAreRelevantToTheSearchKeyword() {
        verifyRelevanceOfDisplayedProducts();
    }

    @Given("the user has searched for a keyword resulting in multiple pages of results")
    public void theUserHasSearchedForAKeywordResultingInMultiplePagesOfResults() {
        searchForKeywordWithMultiplePages();
    }

    @Then("pagination controls allow navigation between pages of search results")
    public void paginationControlsAllowNavigationBetweenPagesOfSearchResults() {
        verifyPaginationControls();
    }

    @Given("the user is on the search results page")
    public void theUserIsOnTheSearchResultsPage() {
        navigateToSearchResultsPage();
    }

    @Then("filtering options are visible")
    public void filteringOptionsAreVisible() {
        verifyFilteringOptionsVisibility();
    }

    @Then("the user can apply filtering options to narrow down search results")
    public void theUserCanApplyFilteringOptionsToNarrowDownSearchResults() {
        applyFilteringOptions();
    }

    @Then("sorting options are visible")
    public void sortingOptionsAreVisible() {
        verifySortingOptionsVisibility();
    }

    @Then("the user can apply sorting options to reorder search results")
    public void theUserCanApplySortingOptionsToReorderSearchResults() {
        applySortingOptions();
    }

    @Then("product details such as name, price, and rating are correctly displayed for each item")
    public void productDetailsSuchAsNamePriceAndRatingAreCorrectlyDisplayedForEachItem() {
        verifyProductDetailsDisplay();
    }

    @When("the user clicks on a product")
    public void theUserClicksOnAProduct() {
        clickOnProduct();
    }

    @Then("the user is redirected to the product detail page with full product information")
    public void theUserIsRedirectedToTheProductDetailPageWithFullProductInformation() {
        verifyProductDetailPageRedirection();
    }

    @Given("the user is on any page within the application")
    public void theUserIsOnAnyPageWithinTheApplication() {
        navigateToAnyPage();
    }

    @Then("the search bar is visible")
    public void theSearchBarIsVisible() {
        verifySearchBarVisibility();
    }

    @Then("the search bar can be used from any page within the application")
    public void theSearchBarCanBeUsedFromAnyPageWithinTheApplication() {
        verifySearchBarAccessibility();
    }

    @Given("the user is on the search results page")
    public void theUserIsOnTheSearchResultsPageAgain() {
        navigateToSearchResultsPage();
    }

    @When("the user uses the home button or logo")
    public void theUserUsesTheHomeButtonOrLogo() {
        useHomeButtonOrLogo();
    }

    @Then("the user can navigate back to the homepage")
    public void theUserCanNavigateBackToTheHomepage() {
        verifyHomepageNavigation();
    }
}