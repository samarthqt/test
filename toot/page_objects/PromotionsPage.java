package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import .io.File;
import .io.IOException;
import .time.Duration;

public class PromotionsPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By personalizedPromotionLocator = By.id(personalized_promotion);
    private final By addToCartButtonLocator = By.id(add_to_cart);
    private final By cartBadgeLocator = By.id(cart_badge);
    private final By searchFieldLocator = By.name(q);
    private final By searchButtonLocator = By.name(btnK);
    private final By resultStatsLocator = By.id(result-stats);

    public PromotionsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void navigateToPromotionsPage() {
        driver.get(http://example.com/promotions);
        Assert.assertTrue(driver.getCurrentUrl().contains(promotions), Failed to navigate to promotions page);
    }

    public boolean arePersonalizedPromotionsDisplayed() {
        WebElement personalizedPromotion = wait.until(ExpectedConditions.visibilityOfElementLocated(personalizedPromotionLocator));
        boolean isDisplayed = personalizedPromotion.isDisplayed();
        Assert.assertTrue(isDisplayed, Personalized promotions are not displayed);
        return isDisplayed;
    }

    public void addToCart() {
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(addToCartButtonLocator));
        addToCartButton.click();
        WebElement cartBadge = wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadgeLocator));
        Assert.assertTrue(cartBadge.isDisplayed(), Item not added to cart);
        captureScreenshot(add_to_cart_success.png);
    }

    public void performSearch(String query) {
        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(searchFieldLocator));
        searchField.sendKeys(query);
        WebElement searchButton = driver.findElement(searchButtonLocator);
        searchButton.click();
        WebElement resultStats = wait.until(ExpectedConditions.visibilityOfElementLocated(resultStatsLocator));
        Assert.assertTrue(resultStats.isDisplayed(), Search results not found);
        captureScreenshot(search_success.png);
    }

    private void captureScreenshot(String fileName) {
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File(./screenshots/ + fileName));
        } catch (IOException e) {
            Assert.fail(Failed to capture screenshot:  + e.getMessage());
        }
    }
}