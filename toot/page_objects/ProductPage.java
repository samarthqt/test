package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProductPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By productItem = By.cssSelector(div.product-item);
    private By addToCartButton = By.id(add_to_cart);
    private By cartBadge = By.id(cart_badge);
    private By outOfStockMessage = By.id(out_of_stock_message);
    private By reviewsSection = By.id(reviews_section);
    private By writeReviewButton = By.id(write_review);
    private By reviewTitleField = By.id(review_title);
    private By reviewDescriptionField = By.id(review_description);
    private By ratingStars = By.cssSelector(.rating_star);
    private By submitReviewButton = By.id(submit_review);
    private By reviewSubmittedMessage = By.id(review_submitted);
    private By reviewList = By.id(review_list);
    private By loginPrompt = By.id(login_prompt);
    private By errorMessage = By.id(error_message);
    private By stockStatus = By.id(stock_status);
    private By cartStockStatus = By.id(cart_stock_status);
    private By outOfStockNotification = By.id(out_of_stock_notification);

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void selectProduct() {
        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(productItem));
        product.click();
    }

    public void clickAddToCart() {
        WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartBtn.click();
    }

    public void addProductToCart() {
        clickAddToCart();
        WebElement cartBadgeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge));
        Assert.assertTrue(cartBadgeElement.isDisplayed(), Item not added to cart);
    }

    public boolean isProductOutOfStock() {
        WebElement outOfStockElement = wait.until(ExpectedConditions.visibilityOfElementLocated(outOfStockMessage));
        return outOfStockElement.isDisplayed();
    }

    public void tryAddOutOfStockProduct() {
        clickAddToCart();
        Assert.assertTrue(isOutOfStockNotificationDisplayed(), Out of stock notification not displayed);
    }

    public boolean isOutOfStockNotificationDisplayed() {
        WebElement notificationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(outOfStockNotification));
        return notificationElement.isDisplayed();
    }

    public void navigateToReviewsSection() {
        WebElement reviewsSectionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(reviewsSection));
        reviewsSectionElement.click();
    }

    public void clickWriteReview() {
        WebElement writeReviewBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(writeReviewButton));
        writeReviewBtn.click();
    }

    public void enterReviewTitle(String title) {
        WebElement titleField = wait.until(ExpectedConditions.visibilityOfElementLocated(reviewTitleField));
        titleField.clear();
        titleField.sendKeys(title);
    }

    public void enterReviewDescription(String description) {
        WebElement descriptionField = wait.until(ExpectedConditions.visibilityOfElementLocated(reviewDescriptionField));
        descriptionField.clear();
        descriptionField.sendKeys(description);
    }

    public void selectRating(int stars) {
        WebElement star = driver.findElements(ratingStars).get(stars - 1);
        star.click();
    }

    public void submitReview() {
        WebElement submitReviewBtn = wait.until(ExpectedConditions.elementToBeClickable(submitReviewButton));
        submitReviewBtn.click();
        Assert.assertTrue(isReviewSubmitted(), Review not submitted);
    }

    public boolean isReviewSubmitted() {
        WebElement reviewSubmittedElement = wait.until(ExpectedConditions.visibilityOfElementLocated(reviewSubmittedMessage));
        return reviewSubmittedElement.isDisplayed();
    }

    public boolean isReviewVisible() {
        WebElement reviewListElement = wait.until(ExpectedConditions.visibilityOfElementLocated(reviewList));
        return reviewListElement.isDisplayed();
    }

    public boolean isErrorMessageVisible() {
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return errorElement.isDisplayed();
    }

    public String getStockStatus() {
        WebElement stockStatusElement = driver.findElement(stockStatus);
        return stockStatusElement.getText();
    }

    public String getCartStockStatus() {
        WebElement cartStockStatusElement = driver.findElement(cartStockStatus);
        return cartStockStatusElement.getText();
    }

    public String getOutOfStockNotification() {
        WebElement notificationElement = driver.findElement(outOfStockNotification);
        return notificationElement.getText();
    }

    public boolean isLoginPromptVisible() {
        WebElement loginPromptElement = wait.until(ExpectedConditions.visibilityOfElementLocated(loginPrompt));
        return loginPromptElement.isDisplayed();
    }
}