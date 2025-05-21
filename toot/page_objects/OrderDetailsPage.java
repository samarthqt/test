package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import .time.Duration;

public class OrderDetailsPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public OrderDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isOrderListDisplayed() {
        WebElement orderListElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(order_list)));
        return orderListElement.isDisplayed();
    }

    public void selectOrderById(String orderId) {
        WebElement orderElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(//div[@data-order-id=' + orderId + '])));
        orderElement.click();
    }

    public boolean isOrderDetailsDisplayed(String orderId) {
        WebElement orderDetailsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(//div[@data-order-id=' + orderId + '])));
        return orderDetailsElement.isDisplayed();
    }

    public boolean isAccessCodeDisplayed(String accessCode) {
        WebElement accessCodeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(//span[text()=' + accessCode + '])));
        return accessCodeElement.isDisplayed();
    }

    public void attemptInitiateReturn(String accessCode) {
        WebElement initiateReturnButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(//button[@data-access-code=' + accessCode + '])));
        initiateReturnButton.click();
    }

    public boolean isInitiateReturnDisabledOrNotPresent(String accessCode) {
        try {
            WebElement initiateReturnButton = driver.findElement(By.xpath(//button[@data-access-code=' + accessCode + ']));
            return !initiateReturnButton.isEnabled() || !initiateReturnButton.isDisplayed();
        } catch (Exception e) {
            return true;
        }
    }

    public boolean isReturnPeriodExpiredNotificationDisplayed() {
        WebElement notificationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(return_period_expired_notification)));
        return notificationElement.isDisplayed();
    }
}