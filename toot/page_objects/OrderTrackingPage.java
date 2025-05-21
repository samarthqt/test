
package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import .time.Duration;
import org.testng.Assert;

public class OrderTrackingPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public OrderTrackingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToOrderTrackingSection() {
        WebElement orderTrackingSection = driver.findElement(By.id(order_tracking_section));
        orderTrackingSection.click();
        Assert.assertTrue(orderTrackingSection.isDisplayed(), Order tracking section is not displayed);
    }

    public void selectOrderToTrack() {
        WebElement orderElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(order_list)));
        orderElement.click();
        Assert.assertTrue(orderElement.isDisplayed(), Order element is not displayed);
    }

    public boolean isOrderStatusDisplayed() {
        WebElement statusElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(order_status)));
        boolean isDisplayed = statusElement.isDisplayed();
        Assert.assertTrue(isDisplayed, Order status is not displayed);
        return isDisplayed;
    }

    public boolean isExpectedDeliveryDateDisplayed() {
        WebElement deliveryDateElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(delivery_date)));
        boolean isDisplayed = deliveryDateElement.isDisplayed();
        Assert.assertTrue(isDisplayed, Expected delivery date is not displayed);
        return isDisplayed;
    }

    public boolean isCurrentLocationDisplayed() {
        WebElement locationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(order_location)));
        boolean isDisplayed = locationElement.isDisplayed();
        Assert.assertTrue(isDisplayed, Current location is not displayed);
        return isDisplayed;
    }

    public boolean isTrackingInformationDisplayed() {
        WebElement trackingInfoElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(tracking_info)));
        boolean isDisplayed = trackingInfoElement.isDisplayed();
        Assert.assertTrue(isDisplayed, Tracking information is not displayed);
        return isDisplayed;
    }

    public void simulateOrderStatusChange() {
        WebElement statusChangeElement = driver.findElement(By.id(status_change));
        statusChangeElement.click();
        Assert.assertTrue(statusChangeElement.isDisplayed(), Status change element is not displayed);
    }

    public boolean isUpdatedOrderStatusDisplayed() {
        WebElement updatedStatusElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(updated_order_status)));
        boolean isDisplayed = updatedStatusElement.isDisplayed();
        Assert.assertTrue(isDisplayed, Updated order status is not displayed);
        return isDisplayed;
    }

    public boolean isStatusChangeNotificationDisplayed() {
        WebElement notificationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(status_change_notification)));
        boolean isDisplayed = notificationElement.isDisplayed();
        Assert.assertTrue(isDisplayed, Status change notification is not displayed);
        return isDisplayed;
    }

    public void simulateTrackingInformationUnavailable() {
        WebElement unavailableElement = driver.findElement(By.id(tracking_unavailable));
        unavailableElement.click();
        Assert.assertTrue(unavailableElement.isDisplayed(), Tracking information unavailable element is not displayed);
    }

    public boolean isErrorMessageDisplayed() {
        WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(error_message)));
        boolean isDisplayed = errorMessageElement.isDisplayed();
        Assert.assertTrue(isDisplayed, Error message is not displayed);
        return isDisplayed;
    }

    public boolean isRetryOptionDisplayed() {
        WebElement retryOptionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(retry_option)));
        boolean isDisplayed = retryOptionElement.isDisplayed();
        Assert.assertTrue(isDisplayed, Retry option is not displayed);
        return isDisplayed;
    }

    public boolean isUserLoggedIn() {
        WebElement loginStatusElement = driver.findElement(By.id(login_status));
        boolean isDisplayed = loginStatusElement.isDisplayed();
        Assert.assertTrue(isDisplayed, User login status is not displayed);
        return isDisplayed;
    }

    public void attemptToAccessOrderTrackingSection() {
        WebElement orderTrackingSection = driver.findElement(By.id(order_tracking_section));
        orderTrackingSection.click();
        Assert.assertTrue(orderTrackingSection.isDisplayed(), Order tracking section is not displayed);
    }

    public boolean isLoginPromptDisplayed() {
        WebElement loginPromptElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(login_prompt)));
        boolean isDisplayed = loginPromptElement.isDisplayed();
        Assert.assertTrue(isDisplayed, Login prompt is not displayed);
        return isDisplayed;
    }
}
