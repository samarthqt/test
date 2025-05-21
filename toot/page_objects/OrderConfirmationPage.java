
package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import .time.Duration;

public class OrderConfirmationPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void completePurchase() {
        WebElement completePurchaseButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(complete_purchase)));
        completePurchaseButton.click();
    }

    public boolean isPurchaseSuccessful() {
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(purchase_success)));
        return successMessage.isDisplayed();
    }

    public boolean isEmailSent() {
        WebElement emailSentMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(email_sent)));
        return emailSentMessage.isDisplayed();
    }

    public boolean doesEmailContainOrderDetails() {
        WebElement emailContent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(email_content)));
        String content = emailContent.getText();
        return content.contains(Order ID) && content.contains(Items Purchased) &&
               content.contains(Total Amount) && content.contains(Delivery Address);
    }

    public boolean isEmailFromCorrectSender() {
        WebElement senderEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(sender_email)));
        return orders@example.com.equals(senderEmail.getText());
    }

    public void attemptPurchase() {
        WebElement attemptPurchaseButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(attempt_purchase)));
        attemptPurchaseButton.click();
    }

    public boolean isPurchaseFailed() {
        WebElement failureMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(purchase_failure)));
        return failureMessage.isDisplayed();
    }

    public boolean isEmailNotSent() {
        WebElement emailNotSentMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(email_not_sent)));
        return emailNotSentMessage.isDisplayed();
    }

    public boolean isInitialEmailAttemptFailed() {
        WebElement initialFailureMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(initial_email_failure)));
        return initialFailureMessage.isDisplayed();
    }

    public void retrySendingEmail() {
        WebElement retryButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(retry_email)));
        retryButton.click();
    }

    public boolean isRetryEmailSuccessful() {
        WebElement retrySuccessMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(retry_email_success)));
        return retrySuccessMessage.isDisplayed();
    }

    public boolean isLogStatusDisplayed() {
        WebElement logStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(log_status)));
        return logStatus.isDisplayed();
    }

    public boolean doesLogIncludeEmailStatus() {
        WebElement logContent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(log_content)));
        String logText = logContent.getText();
        return logText.contains(Email Sent Successfully) && logText.contains(Errors);
    }
}
