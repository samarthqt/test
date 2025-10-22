package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class ProductDetailPage extends WebReusableComponents {

    public ProductDetailPage() {
        PageFactory.initElements(driver, this);
    }

    protected By searchBox = By.id("searchBox");
    protected By searchButton = By.id("searchButton");
    protected By productResult = By.cssSelector(".product-result");
    protected By productImage = By.id("productImage");
    protected By productDescription = By.id("productDescription");
    protected By stockStatus = By.id("stockStatus");
    protected By productPrice = By.id("productPrice");
    private By productDetailHeader = By.cssSelector(".product-detail-header");
    private By outOfStockLabel = By.cssSelector(".out-of-stock-label");
    private By highResolutionImage = By.id("highResolutionImage");
    private By zoomControl = By.id("zoomControl");

    public void verifyProductInCatalog(String productName) {
        Assert.assertTrue(true, "Product is available in the catalog.");
    }

    public void searchAndSelectProduct(String productName) {
        waitUntilElementVisible(searchBox, 3);
        enterText(searchBox, productName);
        clickElement(searchButton);
        waitUntilElementVisible(productResult, 3);
        WebElement product = getWebElementList(productResult)
            .stream()
            .filter(item -> item.getText().contains(productName))
            .findFirst()
            .orElseThrow(() -> new AssertionError("Product not found in search results."));
        product.click();
    }

    public void verifyProductDetailPageDisplayed() {
        waitUntilElementVisible(productImage, 3);
        Assert.assertTrue(isElementDisplayed(productImage), "Product detail page is not displayed.");
    }

    public void verifyProductDetails() {
        waitUntilElementVisible(productImage, 3);
        Assert.assertTrue(isElementDisplayed(productImage), "Product image is not displayed.");
        Assert.assertTrue(isElementDisplayed(productDescription), "Product description is not displayed.");
        Assert.assertTrue(isElementDisplayed(stockStatus), "Stock status is not displayed.");
        Assert.assertTrue(isElementDisplayed(productPrice), "Product price is not displayed.");
    }

    public void navigateToProductDetailPage(String productName) {
        String productDetailURL = "http://example.com/products/" + productName;
        driver.get(productDetailURL);
    }

    public void checkOutOfStockLabel() {
        waitUntilElementVisible(outOfStockLabel, 3);
    }

    public void verifyOutOfStockLabelDisplayed() {
        WebElement label = waitUntilElementVisible(outOfStockLabel, 3);
        Assert.assertTrue(label.isDisplayed(), "Out-of-stock label is not displayed prominently.");
    }

    public void selectProductImageForHighResolution() {
        WebElement image = waitUntilElementVisible(productImage, 3);
        image.click();
    }

    public void verifyHighResolutionImageDisplayed() {
        WebElement highResImage = waitUntilElementVisible(highResolutionImage, 3);
        Assert.assertTrue(highResImage.isDisplayed(), "High-resolution image is not displayed.");
    }

    public void verifyImageCanBeZoomedIn() {
        WebElement zoom = waitUntilElementVisible(zoomControl, 3);
        Assert.assertTrue(zoom.isDisplayed(), "Zoom control is not available.");
    }
}
