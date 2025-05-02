package com.pageobjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class ProductSearchPage extends WebReusableComponents {

    protected By searchBar = By.id("searchBar");
    protected By searchButton = By.id("searchButton");
    protected By categoryDropdown = By.id("categoryDropdown");
    protected By productList = By.cssSelector(".product-list");
    protected By searchMessage = By.id("searchMessage");

    public void navigateToHomePage() {
        navigateToPage("homePageURL");
    }

    public void enterProductNameInSearchBar(String productName) {
        waitUntilElementVisible(searchBar, 3);
        enterText(searchBar, productName);
    }

    public void selectCategoryFromDropdown(String category) {
        waitUntilElementVisible(categoryDropdown, 3);
        selectByVisibleText(categoryDropdown, category);
    }

    public void clearSearchBar() {
        waitUntilElementVisible(searchBar, 3);
        clearText(searchBar);
    }

    public void clickSearchButton() {
        waitUntilElementVisible(searchButton, 3);
        clickElement(searchButton);
    }

    public void verifyProductsListContains(String productName) {
        waitUntilElementVisible(productList, 3);
        boolean productFound = getWebElementList(productList)
            .stream()
            .anyMatch(item -> item.getText().contains(productName));
        Assert.assertTrue(productFound, "Product list does not contain expected product.");
    }

    public void verifyProductsListUnderCategory(String category) {
        waitUntilElementVisible(productList, 3);
        boolean categoryFound = getWebElementList(productList)
            .stream()
            .anyMatch(item -> item.getText().contains(category));
        Assert.assertTrue(categoryFound, "Product list does not contain expected category.");
    }

    public void verifySearchMessage(String expectedMessage) {
        waitUntilElementVisible(searchMessage, 3);
        String actualMessage = getTextFromElement(searchMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Search message does not match.");
    }
}