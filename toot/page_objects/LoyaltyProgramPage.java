
package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoyaltyProgramPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By joinLoyaltyProgramButton = By.id(join_loyalty_program);
    private final By confirmationMessage = By.id(confirmation_message);
    private final By purchaseButton = By.id(purchase_button);
    private final By pointsEarnedMessage = By.id(points_earned);
    private final By pointsBalance = By.id(points_balance);
    private final By redeemPointsButton = By.id(redeem_points);
    private final By discountAppliedMessage = By.id(discount_applied);
    private final By notificationMessage = By.id(notification_message);
    private final By leaveLoyaltyProgramButton = By.id(leave_loyalty_program);

    public LoyaltyProgramPage(final WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void clickJoinLoyaltyProgram() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(joinLoyaltyProgramButton));
        button.click();
        Assert.assertTrue(isEnrolled(), Failed to join loyalty program.);
    }

    public boolean isEnrolled() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessage)).isDisplayed();
    }

    public boolean isConfirmationMessageDisplayed() {
        return driver.findElement(confirmationMessage).isDisplayed();
    }

    public void makePurchase() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(purchaseButton));
        button.click();
        Assert.assertTrue(arePointsEarned(), Points were not earned after purchase.);
    }

    public boolean arePointsEarned() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pointsEarnedMessage)).isDisplayed();
    }

    public boolean arePointsReflected() {
        return driver.findElement(pointsBalance).isDisplayed();
    }

    public boolean hasAccumulatedPoints() {
        return driver.findElement(pointsBalance).isDisplayed();
    }

    public void redeemPoints() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(redeemPointsButton));
        button.click();
        Assert.assertTrue(isDiscountApplied(), Discount was not applied after redeeming points.);
    }

    public boolean isDiscountApplied() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(discountAppliedMessage)).isDisplayed();
    }

    public boolean arePointsDeducted() {
        return driver.findElement(pointsBalance).isDisplayed();
    }

    public void navigateToLoyaltySection() {
        driver.get(http://example.com/account/loyalty);
        Assert.assertTrue(isPointsBalanceDisplayed(), Failed to navigate to loyalty section.);
    }

    public boolean isPointsBalanceDisplayed() {
        return driver.findElement(pointsBalance).isDisplayed();
    }

    public void checkForNewRewards() {
        // Logic to check for new rewards
        Assert.assertTrue(isNotificationReceived(), No new rewards notification received.);
    }

    public boolean isNotificationReceived() {
        return driver.findElement(notificationMessage).isDisplayed();
    }

    public void leaveLoyaltyProgram() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(leaveLoyaltyProgramButton));
        button.click();
        Assert.assertTrue(isUnenrolled(), Failed to leave loyalty program.);
    }

    public boolean isUnenrolled() {
        return !driver.findElement(joinLoyaltyProgramButton).isDisplayed();
    }
}
