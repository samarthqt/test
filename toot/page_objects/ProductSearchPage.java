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
import .util.List;

public class ProductSearchPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By searchBar = By.id(search-bar);
    private final By categoryDropdown = By.id(category-dropdown);
    private final By searchButton = By.id(search-button);
    private final By productList = By.id(product-list);
    private final By noProductsMessage = By.id(no-products-message);
    private final By validationMessage = By.id(validation-message);
    private final By priceFilter = By.id(price_filter);
    private final By ratingFilter = By.id(rating_filter);
    private final By clearFiltersButton = By.id(clear_filters);
    private final By enterSearchTermPrompt = By.id(enter-search-term);

    public ProductSearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void enterSearchQuery(String query) {
        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar));
        searchField.clear();
        searchField.sendKeys(query);
    }

    public void selectCategory(String category) {
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(categoryDropdown));
        dropdown.click();
        WebElement categoryOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(//option[text()=' + category + '])));
        categoryOption.click();
    }

    public void clickSearchButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        button.click();
    }

    public boolean isProductListDisplayed(String productName) {
        WebElement list = wait.until(ExpectedConditions.visibilityOfElementLocated(productList));
        return list.getText().contains(productName);
    }

    public boolean isCategoryListDisplayed(String category) {
        WebElement list = wait.until(ExpectedConditions.visibilityOfElementLocated(productList));
        return list.getText().contains(category);
    }

    public String getNoProductsMessage() {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(noProductsMessage));
        return message.getText();
    }

    public String getValidationMessage() {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(validationMessage));
        return message.getText();
    }

    public void selectPriceRangeFilter(String priceRange) {
        WebElement priceFilterElement = wait.until(ExpectedConditions.elementToBeClickable(priceFilter));
        priceFilterElement.click();
        WebElement priceOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(//option[text()=' + priceRange + '])));
        priceOption.click();
    }

    public void selectRatingFilter(int rating) {
        WebElement ratingFilterElement = wait.until(ExpectedConditions.elementToBeClickable(ratingFilter));
        ratingFilterElement.click();
        WebElement ratingOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(//option[text()=' + rating +  stars'])));
        ratingOption.click();
    }

    public boolean areProductsWithinPriceRange(String priceRange) {
        List<WebElement> products = driver.findElements(By.cssSelector(div.product-item));
        for (WebElement product : products) {
            String price = product.findElement(By.cssSelector(span.price)).getText();
            if (!price.matches(priceRange)) {
                return false;
            }
        }
        return true;
    }

    public boolean areProductsWithRatingOrHigher(int rating) {
        List<WebElement> products = driver.findElements(By.cssSelector(div.product-item));
        for (WebElement product : products) {
            int productRating = Integer.parseInt(product.findElement(By.cssSelector(span.rating)).getText().substring(0, 1));
            if (productRating < rating) {
                return false;
            }
        }
        return true;
    }

    public boolean areProductsMeetingBothCriteria(String priceRange, int rating) {
        return areProductsWithinPriceRange(priceRange) && areProductsWithRatingOrHigher(rating);
    }

    public void clearAllFilters() {
        WebElement clearFiltersButtonElement = wait.until(ExpectedConditions.elementToBeClickable(clearFiltersButton));
        clearFiltersButtonElement.click();
    }

    public boolean areAllProductsDisplayed() {
        List<WebElement> products = driver.findElements(By.cssSelector(div.product-item));
        return !products.isEmpty();
    }

    public boolean isNoProductsFoundMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(noProductsMessage)).isDisplayed();
    }

    public boolean isEnterSearchTermPromptDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(enterSearchTermPrompt)).isDisplayed();
    }

    public void takeScreenshot(String fileName) throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(./screenshots/ + fileName));
    }
}