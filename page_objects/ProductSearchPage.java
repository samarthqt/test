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
    protected By categoryFilter = By.id("categoryFilter");
    protected By priceFilterMin = By.id("priceMin");
    protected By priceFilterMax = By.id("priceMax");
    protected By ratingFilter = By.id("ratingFilter");
    protected By searchResults = By.cssSelector(".search-result-item");
    protected By addToCartButton = By.cssSelector(".add-to-cart");
    protected By cartIcon = By.id("cartIcon");
    protected By logoutButton = By.id("logoutButton");
    protected By noResultsMessage = By.id("noResultsMessage");

    public ProductSearchPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToProductSearchPage() {
        driver.get("/product-search");
    }

    public void verifyProductSearchPageDisplayed() {
        Assert.assertTrue(driver.getCurrentUrl().contains("product-search"), "Product search page is not displayed.");
    }

    public void enterKeywordInSearchBar(String keyword) {
        waitUntilElementVisible(searchBar, 3);
        enterText(searchBar, keyword);
    }

    public void verifyKeywordEntered(String keyword) {
        String enteredText = getTextFromElement(searchBar);
        Assert.assertEquals(enteredText, keyword, "Keyword is not entered correctly.");
    }

    public void clickSearchButton() {
        waitUntilElementVisible(searchButton, 3);
        clickElement(searchButton);
    }

    public void verifySearchInitiated() {
        Assert.assertTrue(isElementVisible(searchResults), "Search process is not initiated.");
    }

    public void verifySearchResultsDisplayed() {
        List<WebElement> results = getWebElementList(searchResults);
        Assert.assertFalse(results.isEmpty(), "Search results are not displayed.");
    }

    public void verifyNoSearchResultsDisplayed() {
        Assert.assertTrue(isElementVisible(noResultsMessage), "No results message is not displayed.");
    }

    public void applyCategoryFilter(String category) {
        selectByVisibleText(categoryFilter, category);
    }

    public void verifyCategoryFilterApplied(String category) {
        String selectedCategory = getSelectedOption(categoryFilter);
        Assert.assertEquals(selectedCategory, category, "Category filter is not applied correctly.");
    }

    public void applyPriceFilter(String min, String max) {
        waitUntilElementVisible(priceFilterMin, 3);
        enterText(priceFilterMin, min);
        enterText(priceFilterMax, max);
    }

    public void verifyPriceFilterApplied(String min, String max) {
        String minPrice = getTextFromElement(priceFilterMin);
        String maxPrice = getTextFromElement(priceFilterMax);
        Assert.assertEquals(minPrice, min, "Min price filter is not applied correctly.");
        Assert.assertEquals(maxPrice, max, "Max price filter is not applied correctly.");
    }

    public void applyRatingFilter(String rating) {
        selectByVisibleText(ratingFilter, rating);
    }

    public void verifyRatingFilterApplied(String rating) {
        String selectedRating = getSelectedOption(ratingFilter);
        Assert.assertEquals(selectedRating, rating, "Rating filter is not applied correctly.");
    }

    public void verifyResultsWithinPriceRange(String min, String max) {
        List<WebElement> results = getWebElementList(searchResults);
        for (WebElement result : results) {
            String priceText = result.findElement(By.cssSelector(".price")).getText();
            double price = Double.parseDouble(priceText.replace("$", ""));
            Assert.assertTrue(price >= Double.parseDouble(min) && price <= Double.parseDouble(max), "Result price is out of range.");
        }
    }

    public void verifyResultsRelevance(String keyword) {
        List<WebElement> results = getWebElementList(searchResults);
        for (WebElement result : results) {
            String productName = result.findElement(By.cssSelector(".product-name")).getText();
            Assert.assertTrue(productName.toLowerCase().contains(keyword.toLowerCase()), "Result is not relevant to the keyword: " + keyword);
        }
    }

    public void addProductToCartFromResults() {
        List<WebElement> results = getWebElementList(searchResults);
        if (!results.isEmpty()) {
            results.get(0).findElement(addToCartButton).click();
        }
    }

    public void verifyProductAddedToCart() {
        clickElement(cartIcon);
        Assert.assertTrue(isElementVisible(By.cssSelector(".cart-item")), "Product is not added to the cart.");
    }

    public void logOutFromApplication() {
        clickElement(logoutButton);
    }

    public void verifyUserLoggedOut() {
        Assert.assertTrue(driver.getCurrentUrl().contains("login"), "User is not logged out.");
    }
}