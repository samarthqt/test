package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class ProductSearchPage extends WebReusableComponents {

    protected By searchBar = By.id("searchBar");
    protected By searchButton = By.id("searchButton");
    protected By searchResults = By.cssSelector(".search-result-item");

    public void navigateToSearchPage() {
        // Dummy implementation for navigation
        launchUrl("http://example.com/search");
    }

    public void enterSearchKeyword(String keyword) {
        waitUntilElementVisible(searchBar, 3);
        enterText(searchBar, keyword);
    }

    public void clickSearchButton() {
        waitUntilElementVisible(searchButton, 3);
        clickElement(searchButton);
    }

    public void verifySearchResults(String expectedKeyword) {
        waitUntilElementVisible(searchResults, 3);
        boolean resultsFound = getWebElementList(searchResults)
            .stream()
            .anyMatch(item -> item.getText().contains(expectedKeyword));
        Assert.assertTrue(resultsFound, "Relevant products are not displayed.");
    }
}