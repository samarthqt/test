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

public class WishlistPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By addToWishlistButtonLocator = By.id(add_to_wishlist);
    private final By productInWishlistLocator = By.cssSelector(.wishlist-item);
    private final By confirmationMessageLocator = By.id(confirmation_message);
    private final By removeButtonLocator = By.cssSelector(.remove-from-wishlist);
    private final By loginPromptLocator = By.id(login_prompt);
    private final By duplicateMessageLocator = By.id(duplicate_message);

    public WishlistPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void clickAddToWishlist() {
        WebElement addToWishlistButton = wait.until(ExpectedConditions.elementToBeClickable(addToWishlistButtonLocator));
        addToWishlistButton.click();
        Assert.assertTrue(isConfirmationMessageDisplayed(), Confirmation message not displayed after adding to wishlist.);
    }

    public boolean isProductInWishlist() {
        List<WebElement> products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productInWishlistLocator));
        return !products.isEmpty();
    }

    public boolean isConfirmationMessageDisplayed() {
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessageLocator));
        return confirmationMessage.isDisplayed();
    }

    public void navigateToWishlistPage() {
        driver.get(http://example.com/wishlist);
        Assert.assertTrue(isWishlistNotEmpty(), Wishlist is empty after navigation.);
    }

    public boolean isWishlistNotEmpty() {
        List<WebElement> wishlistItems = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productInWishlistLocator));
        return !wishlistItems.isEmpty();
    }

    public void ensureProductInWishlist() {
        navigateToWishlistPage();
        if (!isProductInWishlist()) {
            driver.get(http://example.com/product);
            clickAddToWishlist();
            navigateToWishlistPage();
            Assert.assertTrue(isProductInWishlist(), Product not found in wishlist after adding.);
        }
    }

    public void clickRemoveFromWishlist() {
        WebElement removeButton = wait.until(ExpectedConditions.elementToBeClickable(removeButtonLocator));
        removeButton.click();
        Assert.assertFalse(isProductInWishlist(), Product still in wishlist after removal.);
    }

    public boolean isLoginPromptDisplayed() {
        WebElement loginPrompt = wait.until(ExpectedConditions.visibilityOfElementLocated(loginPromptLocator));
        return loginPrompt.isDisplayed();
    }

    public boolean hasDuplicateEntries() {
        List<WebElement> products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productInWishlistLocator));
        return products.size() > 1; // Assuming duplicate entries mean more than one of the same product
    }

    public boolean isDuplicateMessageDisplayed() {
        WebElement duplicateMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(duplicateMessageLocator));
        return duplicateMessage.isDisplayed();
    }

    private void takeScreenshot(String fileName) throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(./screenshots/ + fileName));
    }
}