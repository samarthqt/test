package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductComparisonPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By productCheckbox = By.cssSelector(input[type='checkbox']);
    private final By comparisonTable = By.id(comparison-table);
    private final By priceDifference = By.id(price-difference);
    private final By priceDifferences = By.id(price-differences);
    private final By noSelectionMessage = By.id(no-selection-message);
    private final By nonComparableAttributes = By.id(non-comparable-attributes);
    private final By similarPriceMessage = By.id(similar-price-message);
    private final By productLink = By.cssSelector(a[data-product-index]);
    private final By productDetail = By.id(product-detail);
    private final By resetButton = By.id(reset-button);
    private final By initialState = By.id(initial-state);

    public ProductComparisonPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void selectProduct(int productIndex) {
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(input[type='checkbox'][data-product-index=' + productIndex + '])));
        checkbox.click();
        Assert.assertTrue(checkbox.isSelected(), Product checkbox is not selected);
    }

    public boolean isComparisonDisplayed() {
        WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(comparisonTable));
        boolean isDisplayed = table.isDisplayed();
        Assert.assertTrue(isDisplayed, Comparison table is not displayed);
        return isDisplayed;
    }

    public boolean isPriceDifferenceDisplayed() {
        WebElement difference = wait.until(ExpectedConditions.visibilityOfElementLocated(priceDifference));
        boolean isDisplayed = difference.isDisplayed();
        Assert.assertTrue(isDisplayed, Price difference is not displayed);
        return isDisplayed;
    }

    public boolean arePriceDifferencesDisplayed() {
        WebElement differences = wait.until(ExpectedConditions.visibilityOfElementLocated(priceDifferences));
        boolean isDisplayed = differences.isDisplayed();
        Assert.assertTrue(isDisplayed, Price differences are not displayed);
        return isDisplayed;
    }

    public boolean isNoSelectionMessageDisplayed() {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(noSelectionMessage));
        boolean isDisplayed = message.isDisplayed();
        Assert.assertTrue(isDisplayed, No selection message is not displayed);
        return isDisplayed;
    }

    public boolean areNonComparableAttributesHighlighted() {
        WebElement attributes = wait.until(ExpectedConditions.visibilityOfElementLocated(nonComparableAttributes));
        boolean isDisplayed = attributes.isDisplayed();
        Assert.assertTrue(isDisplayed, Non-comparable attributes are not highlighted);
        return isDisplayed;
    }

    public boolean isSimilarPriceMessageDisplayed() {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(similarPriceMessage));
        boolean isDisplayed = message.isDisplayed();
        Assert.assertTrue(isDisplayed, Similar price message is not displayed);
        return isDisplayed;
    }

    public void selectProductForDetails(int productIndex) {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(a[data-product-index=' + productIndex + '])));
        link.click();
        Assert.assertTrue(link.isDisplayed(), Product link is not displayed);
    }

    public boolean isProductDetailDisplayed() {
        WebElement detail = wait.until(ExpectedConditions.visibilityOfElementLocated(productDetail));
        boolean isDisplayed = detail.isDisplayed();
        Assert.assertTrue(isDisplayed, Product detail is not displayed);
        return isDisplayed;
    }

    public void resetSelection() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(resetButton));
        button.click();
        Assert.assertTrue(button.isDisplayed(), Reset button is not displayed);
    }

    public boolean areAllProductsDeselected() {
        boolean areDeselected = driver.findElements(By.cssSelector(input[type='checkbox']:checked)).isEmpty();
        Assert.assertTrue(areDeselected, Not all products are deselected);
        return areDeselected;
    }

    public boolean isPageReset() {
        WebElement state = wait.until(ExpectedConditions.visibilityOfElementLocated(initialState));
        boolean isDisplayed = state.isDisplayed();
        Assert.assertTrue(isDisplayed, Page is not reset to initial state);
        return isDisplayed;
    }
}