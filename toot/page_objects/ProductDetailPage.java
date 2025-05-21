package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
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

public class ProductDetailPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By scrollArea = By.id(scroll_area);
    private final By additionalRecommendations = By.id(additional_recommendations);
    private final By relatedTag = By.id(related_tag);
    private final By addToCartButton = By.id(add_to_cart);
    private final By cartBadge = By.id(cart_badge);

    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void navigateToProductDetailPage() {
        driver.get(http://example.com/product-detail);
        Assert.assertTrue(driver.getCurrentUrl().contains(product-detail), Navigation to product detail page failed);
    }

    public void scrollDown() {
        WebElement scrollElement = wait.until(ExpectedConditions.visibilityOfElementLocated(scrollArea));
        scrollElement.sendKeys(Keys.PAGE_DOWN);
        Assert.assertTrue(scrollElement.isDisplayed(), Scroll down action failed);
    }

    public boolean areAdditionalRecommendationsDisplayed() {
        WebElement recommendations = wait.until(ExpectedConditions.visibilityOfElementLocated(additionalRecommendations));
        boolean isDisplayed = recommendations.isDisplayed();
        Assert.assertTrue(isDisplayed, Additional recommendations are not displayed);
        return isDisplayed;
    }

    public boolean areRecommendationsRelated() {
        WebElement relatedElement = wait.until(ExpectedConditions.visibilityOfElementLocated(relatedTag));
        boolean isRelated = relatedElement.isDisplayed();
        Assert.assertTrue(isRelated, Recommendations are not related);
        return isRelated;
    }

    public void addToCart() {
        WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCart.click();
        WebElement badge = wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge));
        Assert.assertTrue(badge.isDisplayed(), Item not added to cart);
    }

    public void takeScreenshot(String fileName) throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(./screenshots/ + fileName));
    }
}