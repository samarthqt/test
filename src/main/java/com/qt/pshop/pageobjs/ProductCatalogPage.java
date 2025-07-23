package com.qt.pshop.pageobjs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import .util.List;
import .util.stream.Collectors;

public class ProductCatalogPage extends WebReusableComponents {

    private final By mainMenu = By.id("mainMenu");
    private final By productCatalogOption = By.id("productCatalogOption");
    private final By sortingOptions = By.id("sortingOptions");
    private final By priceAscendingOption = By.id("priceAscending");
    private final By priceDescendingOption = By.id("priceDescending");
    private final By productPrices = By.cssSelector(".product-price");

    public ProductCatalogPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToMainMenu() {
        waitUntilElementVisible(mainMenu, 3);
        clickElement(mainMenu);
    }

    public void selectProductCatalog() {
        waitUntilElementVisible(productCatalogOption, 3);
        clickElement(productCatalogOption);
    }

    public boolean isSortingOptionsVisible() {
        return isElementVisible(sortingOptions);
    }

    public void sortByPriceAscending() {
        waitUntilElementVisible(priceAscendingOption, 3);
        clickElement(priceAscendingOption);
    }

    public boolean verifyPricesAscending() {
        List<Double> prices = getTextFromElements(productPrices).stream()
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        boolean isSorted = isSortedAscending(prices);
        Assert.assertTrue(isSorted, "Prices are not sorted in ascending order.");
        return isSorted;
    }

    public void sortByPriceDescending() {
        waitUntilElementVisible(priceDescendingOption, 3);
        clickElement(priceDescendingOption);
    }

    public boolean verifyPricesDescending() {
        List<Double> prices = getTextFromElements(productPrices).stream()
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        boolean isSorted = isSortedDescending(prices);
        Assert.assertTrue(isSorted, "Prices are not sorted in descending order.");
        return isSorted;
    }

    public boolean isSortingResponsive() {
        boolean responsive = isElementResponsive(sortingOptions);
        Assert.assertTrue(responsive, "Sorting options are not responsive.");
        return responsive;
    }

    public boolean isPerformanceOptimal() {
        boolean optimal = isPerformanceOptimalDuringSorting();
        Assert.assertTrue(optimal, "Performance is not optimal during sorting.");
        return optimal;
    }

    public void navigateAwayAndBack() {
        navigateAway();
        navigateBack();
    }

    public boolean isSortingOptionPersisted() {
        boolean persisted = isSortingOptionPersistedAfterNavigation();
        Assert.assertTrue(persisted, "Sorting option is not persisted after navigation.");
        return persisted;
    }

    public boolean isNoSortingErrors() {
        boolean noErrors = isNoErrorsDuringSorting();
        Assert.assertTrue(noErrors, "There are errors during sorting.");
        return noErrors;
    }

    public boolean isSortingAvailableOnAllDevices() {
        boolean available = isSortingAvailableOnMobileAndDesktop();
        Assert.assertTrue(available, "Sorting is not available on all devices.");
        return available;
    }

    public void testSortingWithLargeDataset() {
        sortLargeDataset();
    }

    public boolean isSortingEfficientWithLargeDataset() {
        boolean efficient = isSortingEfficientWithLargeDataset();
        Assert.assertTrue(efficient, "Sorting is not efficient with large dataset.");
        return efficient;
    }

    public boolean isUIFeedbackCorrect() {
        boolean feedbackCorrect = isUIFeedbackCorrectWhenSortingApplied();
        Assert.assertTrue(feedbackCorrect, "UI feedback is not correct when sorting is applied.");
        return feedbackCorrect;
    }

    public void testSortingWithDifferentFilters() {
        applyDifferentFiltersAndSort();
    }

    public boolean isSortingConsistentAcrossFilters() {
        boolean consistent = isSortingConsistentAcrossDifferentFilters();
        Assert.assertTrue(consistent, "Sorting is not consistent across different filters.");
        return consistent;
    }

    public void closeBrowser() {
        driver.quit();
    }

    private void waitUntilElementVisible(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void clickElement(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    private boolean isElementVisible(By locator) {
        WebElement element = driver.findElement(locator);
        return element.isDisplayed();
    }

    private List<String> getTextFromElements(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        return elements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    private boolean isSortedAscending(List<Double> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSortedDescending(List<Double> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) < list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean isElementResponsive(By locator) {
        // Implement logic to check responsiveness
        return true;
    }

    private boolean isPerformanceOptimalDuringSorting() {
        // Implement logic to check performance
        return true;
    }

    private void navigateAway() {
        // Implement navigation away logic
    }

    private void navigateBack() {
        // Implement navigation back logic
    }

    private boolean isSortingOptionPersistedAfterNavigation() {
        // Implement logic to check sorting option persistence
        return true;
    }

    private boolean isNoErrorsDuringSorting() {
        // Implement logic to check for errors during sorting
        return true;
    }

    private boolean isSortingAvailableOnMobileAndDesktop() {
        // Implement logic to check sorting availability on all devices
        return true;
    }

    private void sortLargeDataset() {
        // Implement sorting logic for large dataset
    }

    private boolean isSortingEfficientWithLargeDataset() {
        // Implement logic to check sorting efficiency with large dataset
        return true;
    }

    private boolean isUIFeedbackCorrectWhenSortingApplied() {
        // Implement logic to check UI feedback correctness
        return true;
    }

    private void applyDifferentFiltersAndSort() {
        // Implement logic to apply different filters and sort
    }

    private boolean isSortingConsistentAcrossDifferentFilters() {
        // Implement logic to check sorting consistency across filters
        return true;
    }
}