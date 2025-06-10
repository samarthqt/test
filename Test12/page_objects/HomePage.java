package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import .util.List;

public class HomePage extends WebReusableComponents {

    private final By productCategories = By.id("productCategories");
    private final By searchBox = By.id("searchBox");
    private final By searchResults = By.id("searchResults");

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Views the product categories on the homepage.
     */
    public void viewProductCategories() {
        waitUntilElementVisible(productCategories, 3);
        Assert.assertTrue(isElementDisplayed(productCategories), "Product categories are not visible.");
    }

    /**
     * Verifies that product categories are labeled correctly.
     */
    public void verifyCategoriesLabeled() {
        String categoriesText = getTextFromElement(productCategories);
        Assert.assertFalse(categoriesText.isEmpty(), "Categories are not labeled.");
    }

    /**
     * Enters a search query into the search box.
     */
    public void enterSearchQuery() {
        waitUntilElementVisible(searchBox, 3);
        enterText(searchBox, "Sample Query");
        clickElement(searchBox);
    }

    /**
     * Verifies that the search results are relevant to the query.
     */
    public void verifyRelevantSearchResults() {
        waitUntilElementVisible(searchResults, 3);
        String resultsText = getTextFromElement(searchResults);
        Assert.assertTrue(resultsText.contains("Sample Query"), "Search results are not relevant.");
    }

    /**
     * Verifies that the search results are displayed quickly.
     */
    public void verifyQuickSearchResults() {
        long startTime = System.currentTimeMillis();
        waitUntilElementVisible(searchResults, 3);
        long endTime = System.currentTimeMillis();
        Assert.assertTrue((endTime - startTime) < 2000, "Search results are not quick.");
    }

    /**
     * Waits until the specified element is visible.
     * @param locator The locator of the element.
     * @param timeout The timeout in seconds.
     */
    public void waitUntilElementVisible(By locator, int timeout) {
        waitUntilElementVisible(locator, timeout);
    }

    /**
     * Checks if the specified element is displayed.
     * @param locator The locator of the element.
     * @return True if the element is displayed, false otherwise.
     */
    public boolean isElementDisplayed(By locator) {
        WebElement element = driver.findElement(locator);
        return element.isDisplayed();
    }

    /**
     * Gets the text from the specified element.
     * @param locator The locator of the element.
     * @return The text of the element.
     */
    public String getTextFromElement(By locator) {
        WebElement element = driver.findElement(locator);
        return element.getText();
    }

    /**
     * Enters text into the specified element.
     * @param locator The locator of the element.
     * @param text The text to enter.
     */
    public void enterText(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Clicks the specified element.
     * @param locator The locator of the element.
     */
    public void clickElement(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }
}