package com.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import .io.File;
import .io.IOException;
import .time.Duration;

public class ProductFiltersPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By priceRangeFilter = By.id(price_range);
    private final By ratingFilter = By.id(rating_filter);
    private final By filteredResults = By.id(filtered_results);
    private final By clearFiltersButton = By.id(clear_filters);
    private final By allResults = By.id(all_results);
    private final By noProductsMessage = By.id(no_products_message);
    private final By persistedFilters = By.id(persisted_filters);

    public ProductFiltersPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void selectPriceRange(String priceRange) {
        WebElement priceRangeElement = wait.until(ExpectedConditions.elementToBeClickable(priceRangeFilter));
        priceRangeElement.click();
        WebElement priceOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(//option[@value=' + priceRange + '])));
        priceOption.click();
    }

    public boolean verifyPriceRangeFilter(String priceRange) {
        WebElement results = wait.until(ExpectedConditions.visibilityOfElementLocated(filteredResults));
        boolean isPriceFiltered = results.getText().contains(Price:  + priceRange);
        Assert.assertTrue(isPriceFiltered, Price range filter verification failed);
        return isPriceFiltered;
    }

    public void selectRatingFilter(String rating) {
        WebElement ratingElement = wait.until(ExpectedConditions.elementToBeClickable(ratingFilter));
        ratingElement.click();
        WebElement ratingOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(//option[@value=' + rating + '])));
        ratingOption.click();
    }

    public boolean verifyRatingFilter(String rating) {
        WebElement results = wait.until(ExpectedConditions.visibilityOfElementLocated(filteredResults));
        boolean isRatingFiltered = results.getText().contains(Rating:  + rating);
        Assert.assertTrue(isRatingFiltered, Rating filter verification failed);
        return isRatingFiltered;
    }

    public boolean verifyCombinedFilters(String priceRange, String rating) {
        WebElement results = wait.until(ExpectedConditions.visibilityOfElementLocated(filteredResults));
        boolean areFiltersCombined = results.getText().contains(Price:  + priceRange) && results.getText().contains(Rating:  + rating);
        Assert.assertTrue(areFiltersCombined, Combined filters verification failed);
        return areFiltersCombined;
    }

    public void applyMultipleFilters(String priceRange, String rating) {
        selectPriceRange(priceRange);
        selectRatingFilter(rating);
    }

    public void clearAllFilters() {
        WebElement clearButton = wait.until(ExpectedConditions.elementToBeClickable(clearFiltersButton));
        clearButton.click();
    }

    public boolean verifyNoFiltersApplied() {
        WebElement results = wait.until(ExpectedConditions.visibilityOfElementLocated(allResults));
        boolean noFiltersApplied = results.isDisplayed();
        Assert.assertTrue(noFiltersApplied, No filters applied verification failed);
        return noFiltersApplied;
    }

    public void applyNoMatchingFilters(String priceRange, String rating) {
        selectPriceRange(priceRange);
        selectRatingFilter(rating);
    }

    public boolean verifyNoProductsFoundMessage() {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(noProductsMessage));
        boolean noProductsFound = message.isDisplayed();
        Assert.assertTrue(noProductsFound, No products found message verification failed);
        return noProductsFound;
    }

    public void applyFilters(String priceRange, String rating) {
        selectPriceRange(priceRange);
        selectRatingFilter(rating);
    }

    public boolean verifyFiltersPersisted(String priceRange, String rating) {
        WebElement filters = wait.until(ExpectedConditions.visibilityOfElementLocated(persistedFilters));
        boolean filtersPersisted = filters.getText().contains(Price:  + priceRange) && filters.getText().contains(Rating:  + rating);
        Assert.assertTrue(filtersPersisted, Filters persisted verification failed);
        return filtersPersisted;
    }

    public void takeScreenshot(String fileName) throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(./screenshots/ + fileName));
    }
}