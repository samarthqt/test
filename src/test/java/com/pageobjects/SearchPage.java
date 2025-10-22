package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class SearchPage extends WebReusableComponents {

    public SearchPage() {
        PageFactory.initElements(driver, this);
    }

    protected By searchBar = By.id("searchBar");
    protected By brandFilterDropdown = By.id("brandFilterDropdown");
    protected By searchResults = By.cssSelector(".search-results");
    private By searchButton = By.id("searchButton");
    private By noResultsMessage = By.id("noResultsMessage");

    public void enterSearchKeyword(String keyword) {
        waitUntilElementVisible(searchBar, 3);
        enterText(searchBar, keyword);
    }

    public void applyBrandFilter(String brand) {
        waitUntilElementVisible(brandFilterDropdown, 3);
        selectByVisibleText(brandFilterDropdown, brand);
    }

    public void verifySearchResultsUpdate(String expectedBrand) {
        waitUntilElementVisible(searchResults, 3);
        boolean resultsUpdated = getWebElementList(searchResults)
            .stream()
            .allMatch(result -> result.getText().contains(expectedBrand));
        Assert.assertTrue(resultsUpdated, "Search results did not update to show only " + expectedBrand + " products.");
    }

    public void clickSearchButton() {
        waitUntilElementVisible(searchButton, 3);
        clickElement(searchButton);
    }

    public void verifyNoResultsMessage() {
        waitUntilElementVisible(noResultsMessage, 3);
        String actualMessage = getTextFromElement(noResultsMessage);
        Assert.assertEquals(actualMessage, "No results found.", "No results message is not displayed correctly.");
    }

    public void loadLargeDataset() {
        // Dummy implementation for loading large dataset
        System.out.println("Large dataset loaded.");
    }

    public void initiateSearch() {
        waitUntilElementVisible(searchButton, 3);
        clickElement(searchButton);
    }

    public void verifySearchResultsDisplayedPromptly() {
        waitUntilElementVisible(searchResults, 3);
        boolean resultsDisplayed = isElementVisible(searchResults);
        Assert.assertTrue(resultsDisplayed, "Search results are not displayed promptly.");
    }
}
