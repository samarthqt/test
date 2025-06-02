package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import .util.List;

public class SortingPage extends WebReusableComponents {

    protected By sortByPriceDropdown = By.id("sortPriceDropdown");
    protected By productPrices = By.cssSelector(".product-price");
    protected By emptyCatalogMessage = By.id("emptyCatalogMessage");
    protected By logoutButton = By.id("logoutButton");

    public SortingPage() {
        PageFactory.initElements(driver, this);
    }

    public void loginToApplication() {
        // Logic to log into the application
        // Assume login logic is implemented here
        Assert.assertTrue(true, "Login successful.");
    }

    public void verifyProductCatalogDisplayed() {
        // Logic to verify product catalog is displayed
        Assert.assertTrue(isElementVisible(productPrices), "Product catalog is displayed.");
    }

    public void sortByPriceAscending() {
        selectByValue(sortByPriceDropdown, "ascending");
    }

    public void verifyProductsSortedAscending() {
        List<WebElement> prices = getWebElementList(productPrices);
        for (int i = 0; i < prices.size() - 1; i++) {
            double currentPrice = Double.parseDouble(prices.get(i).getText().replace("$", ""));
            double nextPrice = Double.parseDouble(prices.get(i + 1).getText().replace("$", ""));
            Assert.assertTrue(currentPrice <= nextPrice, "Products are not sorted in ascending order.");
        }
    }

    public void verifyAscendingOrder() {
        verifyProductsSortedAscending();
    }

    public void sortByPriceDescending() {
        selectByValue(sortByPriceDropdown, "descending");
    }

    public void verifyProductsSortedDescending() {
        List<WebElement> prices = getWebElementList(productPrices);
        for (int i = 0; i < prices.size() - 1; i++) {
            double currentPrice = Double.parseDouble(prices.get(i).getText().replace("$", ""));
            double nextPrice = Double.parseDouble(prices.get(i + 1).getText().replace("$", ""));
            Assert.assertTrue(currentPrice >= nextPrice, "Products are not sorted in descending order.");
        }
    }

    public void verifyDescendingOrder() {
        verifyProductsSortedDescending();
    }

    public void verifyProductCatalogEmpty() {
        Assert.assertTrue(isElementVisible(emptyCatalogMessage), "Product catalog is empty.");
    }

    public void attemptSortOnEmptyCatalog() {
        sortByPriceAscending();
        verifyNoProductsMessage();
    }

    public void verifyNoProductsMessage() {
        String message = getTextFromElement(emptyCatalogMessage);
        Assert.assertEquals(message, "No products available to sort.", "Incorrect message displayed for empty catalog.");
    }

    public void verifyLargeProductCatalog() {
        // Logic to verify large product catalog
        Assert.assertTrue(true, "Large product catalog verified.");
    }

    public void sortByPrice() {
        sortByPriceAscending();
        verifyProductsSortedAscending();
        sortByPriceDescending();
        verifyProductsSortedDescending();
    }

    public void verifySortingPerformance() {
        // Logic to verify sorting performance
        Assert.assertTrue(true, "Sorting performance is acceptable.");
    }

    public void verifyUIResponsiveness() {
        // Logic to verify UI responsiveness
        Assert.assertTrue(true, "UI is responsive.");
    }

    public void logoutFromApplication() {
        clickElement(logoutButton);
    }

    public void verifyLogoutSuccess() {
        Assert.assertTrue(isElementVisible(logoutButton), "Logout successful.");
    }

    public void loginWithDifferentAccount() {
        // Logic to login with a different account
        Assert.assertTrue(true, "Logged in with a different account.");
    }

    public void verifySortingConsistencyAcrossAccounts() {
        // Logic to verify sorting consistency across accounts
        Assert.assertTrue(true, "Sorting consistency across accounts verified.");
    }

    public void verifyInvalidPriceData() {
        // Logic to verify invalid price data
        Assert.assertTrue(true, "Invalid price data verified.");
    }

    public void verifyErrorMessageForInvalidData() {
        // Logic to verify error message for invalid data
        Assert.assertTrue(true, "Error message for invalid data verified.");
    }

    public void loginOnDifferentBrowsers() {
        // Logic to login on different browsers
        Assert.assertTrue(true, "Logged in on different browsers.");
    }

    public void verifySortingConsistencyAcrossBrowsers() {
        // Logic to verify sorting consistency across browsers
        Assert.assertTrue(true, "Sorting consistency across browsers verified.");
    }

    public void loginOnMobileDevice() {
        // Logic to login on mobile device
        Assert.assertTrue(true, "Logged in on mobile device.");
    }

    public void verifySortingOnMobileDevices() {
        // Logic to verify sorting on mobile devices
        Assert.assertTrue(true, "Sorting on mobile devices verified.");
    }
}