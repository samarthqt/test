package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import .io.File;
import .io.IOException;
import .time.Duration;

public class ShipmentTrackingPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public ShipmentTrackingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void login(String username, String password) {
        driver.get(http://dynamics365.example.com/login);
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(username)));
        usernameField.sendKeys(username);
        WebElement passwordField = driver.findElement(By.id(password));
        passwordField.sendKeys(password);
        WebElement loginButton = driver.findElement(By.id(login_button));
        loginButton.click();
        Assert.assertTrue(isDashboardDisplayed(), Dashboard is not displayed after login.);
    }

    public boolean isDashboardDisplayed() {
        WebElement dashboardElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(dashboard)));
        return dashboardElement.isDisplayed();
    }

    public void navigateToShipmentTrackingPage() {
        driver.get(http://example.com/shipment-tracking);
        Assert.assertTrue(isTrackingPageDisplayed(), Shipment tracking page is not displayed.);
    }

    public boolean isTrackingPageDisplayed() {
        WebElement trackingPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(tracking-page)));
        return trackingPage.isDisplayed();
    }

    public void navigateToOrdersModule() {
        WebElement ordersModule = wait.until(ExpectedConditions.elementToBeClickable(By.id(orders_module)));
        ordersModule.click();
        Assert.assertTrue(isOrdersListDisplayed(), Orders list is not displayed.);
    }

    public boolean isOrdersListDisplayed() {
        WebElement ordersList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(orders_list)));
        return ordersList.isDisplayed();
    }

    public void selectOrder(int orderId) {
        WebElement orderElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(div.order-item[data-id=' + orderId + '])));
        orderElement.click();
        Assert.assertTrue(isOrderDetailsDisplayed(), Order details are not displayed.);
    }

    public boolean isOrderDetailsDisplayed() {
        WebElement orderDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(order_details)));
        return orderDetails.isDisplayed();
    }

    public void enterShipmentID(String shipmentID) {
        WebElement trackingField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(tracking-field)));
        trackingField.sendKeys(shipmentID);
        clickSearchButton();
        Assert.assertTrue(areShipmentDetailsDisplayed(shipmentID), Shipment details are not displayed.);
    }

    public void clickSearchButton() {
        WebElement searchButton = driver.findElement(By.id(search-button));
        searchButton.click();
    }

    public boolean areShipmentDetailsDisplayed(String shipmentID) {
        WebElement shipmentDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(shipment-details)));
        return shipmentDetails.getText().contains(shipmentID);
    }

    public boolean isShipmentDataAvailable() {
        WebElement shipmentData = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(shipment-data)));
        return shipmentData.isDisplayed();
    }

    public void updateStatus(String newStatus) {
        WebElement updateButton = driver.findElement(By.id(update-status));
        updateButton.click();
        WebElement statusField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(status-field)));
        statusField.sendKeys(newStatus);
        WebElement confirmButton = driver.findElement(By.id(confirm-update));
        confirmButton.click();
        Assert.assertTrue(isShipmentStatusUpdated(), Shipment status is not updated.);
    }

    public boolean isShipmentStatusUpdated() {
        WebElement shipmentStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(shipment_status)));
        return Delivered.equals(shipmentStatus.getText());
    }

    public String getCurrentStatus() {
        WebElement currentStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(current-status)));
        return currentStatus.getText();
    }

    public String getUpdatedStatus() {
        WebElement updatedStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(updated-status)));
        return updatedStatus.getText();
    }

    public String getTimestamp() {
        WebElement timestamp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(timestamp)));
        return timestamp.getText();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void logout() {
        WebElement logoutButton = driver.findElement(By.id(logout));
        logoutButton.click();
    }

    public boolean areNotificationsEnabled() {
        WebElement notificationsEnabled = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(notifications-enabled)));
        return notificationsEnabled.isDisplayed();
    }

    public boolean isRetryMessageDisplayed() {
        WebElement retryMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(retry-message)));
        return retryMessage.isDisplayed();
    }

    public boolean isHistoryLogDisplayed() {
        WebElement historyLog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(history-log)));
        return historyLog.isDisplayed();
    }

    public boolean isErrorMessagesEmpty() {
        WebElement errorMessages = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(error-messages)));
        return errorMessages.getText().isEmpty();
    }

    public boolean isSyncMessageDisplayed() {
        WebElement syncMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(sync-message)));
        return syncMessage.isDisplayed();
    }

    public boolean isMobileStatusConsistentWithDesktop() {
        WebElement mobileStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(mobile-status)));
        WebElement desktopStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(desktop-status)));
        return mobileStatus.getText().equals(desktopStatus.getText());
    }

    public void checkAlertSystem() {
        WebElement alertSystem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(alert_system)));
        alertSystem.click();
    }

    public boolean isAlertSent(String email) {
        WebElement alertMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(div.alert-message[data-email=' + email + '])));
        return alertMessage.isDisplayed();
    }

    public boolean isCustomerAlertReceived() {
        WebElement alertMessage = driver.findElement(By.id(alert_message));
        return Your shipment has been delivered..equals(alertMessage.getText());
    }

    public void takeScreenshot(String fileName) throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(./screenshots/ + fileName));
    }
}