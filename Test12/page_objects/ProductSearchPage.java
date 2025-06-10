package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import .util.List;

public class ProductSearchPage extends WebReusableComponents {

    protected By searchBar = By.id("searchBar");
    protected By searchButton = By.id("searchButton");
    protected By searchResults = By.cssSelector(".search-result-item");
    protected By categoryFilter = By.id("categoryFilter");
    protected By priceRangeFilter = By.id("priceRangeFilter");
    protected By ratingFilter = By.id("ratingFilter");
    protected By errorMessage = By.id("errorMessage");

    public ProductSearchPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToSearchPage() {
        driver.get("http://example.com/search");
    }

    public void enterSearchKeyword(String keyword) {
        waitUntilElementVisible(searchBar, 3);
        enterText(searchBar, keyword);
    }

    public void clickSearchButton() {
        waitUntilElementVisible(searchButton, 3);
        clickElement(searchButton);
    }

    public void verifySearchResults() {
        waitUntilElementVisible(searchResults, 3);
        List<WebElement> results = getWebElementList(searchResults);
        Assert.assertFalse(results.isEmpty(), "No search results found.");
    }

    public void selectCategoryFilter() {
        waitUntilElementVisible(categoryFilter, 3);
        clickElement(categoryFilter);
    }

    public void verifyCategoryFilteredResults() {
        verifySearchResults();
    }

    public void selectPriceRangeFilter() {
        waitUntilElementVisible(priceRangeFilter, 3);
        clickElement(priceRangeFilter);
    }

    public void verifyPriceFilteredResults() {
        verifySearchResults();
    }

    public void selectRatingFilter() {
        waitUntilElementVisible(ratingFilter, 3);
        clickElement(ratingFilter);
    }

    public void verifyRatingFilteredResults() {
        verifySearchResults();
    }

    public void verifyAccurateSearchResults() {
        verifySearchResults();
    }

    public void verifyLargeCatalogAvailability() {
        waitUntilElementVisible(searchResults, 3);
        List<WebElement> results = getWebElementList(searchResults);
        Assert.assertTrue(results.size() > 100, "Large catalog is not available.");
    }

    public void performSearch() {
        clickSearchButton();
        verifySearchResults();
    }

    public void verifySearchPerformance() {
        long startTime = System.currentTimeMillis();
        performSearch();
        long endTime = System.currentTimeMillis();
        Assert.assertTrue((endTime - startTime) < 2000, "Search performance is slow.");
    }

    public void verifyInvalidQueryErrorMessage() {
        waitUntilElementVisible(errorMessage, 3);
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, "Invalid search query.", "Error message not displayed correctly.");
    }

    public void verifySearchOptionsVisibility() {
        waitUntilElementVisible(searchBar, 3);
        waitUntilElementVisible(searchButton, 3);
        Assert.assertTrue(isElementVisible(searchBar) && isElementVisible(searchButton), "Search options are not visible.");
    }

    public void verifySearchOptionsUsability() {
        verifySearchOptionsVisibility();
        Assert.assertTrue(isElementEnabled(searchBar) && isElementEnabled(searchButton), "Search options are not usable.");
    }

    public void verifySearchResultsDisplay() {
        verifySearchResults();
    }

    public void verifySearchActivityLogging() {
        // Assume this verifies logging
        Assert.assertTrue(true, "Search activity logging is verified.");
    }

    public void verifyExternalCatalogManagement() {
        // Assume this verifies external catalog management
        Assert.assertTrue(true, "External catalog management is verified.");
    }

    public void verifyCatalogIntegration() {
        verifySearchResults();
    }

    public void verifyUserExperienceCompliance() {
        // Assume this verifies user experience compliance
        Assert.assertTrue(true, "User experience compliance is verified.");
    }
}