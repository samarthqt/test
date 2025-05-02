package com.pageobjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class SearchResultsPage extends WebReusableComponents {

    protected By priceFilter = By.id("priceFilter");
    protected By ratingFilter = By.id("ratingFilter");
    protected By clearFiltersButton = By.id("clearFilters");
    protected By filterOptions = By.cssSelector(".filter-options");
    protected By productItems = By.cssSelector(".product-item");

    public void applyPriceFilter(String priceRange) {
        waitUntilElementVisible(priceFilter, 3);
        selectByValue(priceFilter, priceRange);
    }

    public void applyRatingFilter(String rating) {
        waitUntilElementVisible(ratingFilter, 3);
        selectByValue(ratingFilter, rating);
    }

    public void applyMultipleFilters(String priceRange, String rating) {
        applyPriceFilter(priceRange);
        applyRatingFilter(rating);
    }

    public void clearAllFilters() {
        waitUntilElementVisible(clearFiltersButton, 3);
        clickElement(clearFiltersButton);
    }

    public void verifyProductsWithinPriceRange(String expectedPriceRange) {
        waitUntilElementVisible(productItems, 3);
        boolean allProductsMatch = getWebElementList(productItems)
            .stream()
            .allMatch(item -> item.getText().contains(expectedPriceRange));
        Assert.assertTrue(allProductsMatch, "Not all products are within the selected price range.");
    }

    public void verifyProductsWithRatingOrHigher(String expectedRating) {
        waitUntilElementVisible(productItems, 3);
        boolean allProductsMatch = getWebElementList(productItems)
            .stream()
            .allMatch(item -> item.getText().contains(expectedRating));
        Assert.assertTrue(allProductsMatch, "Not all products have the selected rating or higher.");
    }

    public void verifyProductsMatchAllCriteria(String expectedPriceRange, String expectedRating) {
        waitUntilElementVisible(productItems, 3);
        boolean allProductsMatch = getWebElementList(productItems)
            .stream()
            .allMatch(item -> item.getText().contains(expectedPriceRange) && item.getText().contains(expectedRating));
        Assert.assertTrue(allProductsMatch, "Not all products match the selected criteria.");
    }

    public void verifyAllProductsDisplayed() {
        waitUntilElementVisible(productItems, 3);
        boolean allProductsDisplayed = !getWebElementList(productItems).isEmpty();
        Assert.assertTrue(allProductsDisplayed, "Not all products are displayed.");
    }

    public void verifyFilterOptionsVisible() {
        waitUntilElementVisible(filterOptions, 3);
        boolean optionsVisible = elementVisible(filterOptions);
        Assert.assertTrue(optionsVisible, "Filter options are not visible.");
    }

    public void applySpecificCriterionFilter(String criterion) {
        By criterionFilter = By.id(criterion + "Filter");
        waitUntilElementVisible(criterionFilter, 3);
        clickElement(criterionFilter);
    }

    public void verifyProductsMatchCriterion(String expectedCriterion) {
        waitUntilElementVisible(productItems, 3);
        boolean allProductsMatch = getWebElementList(productItems)
            .stream()
            .allMatch(item -> item.getText().contains(expectedCriterion));
        Assert.assertTrue(allProductsMatch, "Not all products match the selected criterion.");
    }
}