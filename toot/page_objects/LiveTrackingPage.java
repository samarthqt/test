package com.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import .time.Duration;

public class LiveTrackingPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public LiveTrackingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToLiveTrackingPage() {
        driver.get(http://example.com/live-tracking);
    }

    public boolean isLiveTrackingPageDisplayed() {
        WebElement liveTrackingElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(live_tracking)));
        return liveTrackingElement.isDisplayed();
    }

    public void enterShipmentID(String shipmentId) {
        WebElement trackingField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(tracking_field)));
        trackingField.sendKeys(shipmentId);
        WebElement trackButton = driver.findElement(By.id(track_button));
        trackButton.click();
    }

    public boolean areTrackingDetailsDisplayed(String shipmentId) {
        WebElement trackingDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(tracking_details)));
        return trackingDetails.getText().contains(shipmentId);
    }

    public void checkCurrentLocation() {
        WebElement locationButton = driver.findElement(By.id(location_button));
        locationButton.click();
    }

    public boolean isCurrentLocationDisplayed() {
        WebElement mapElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(map)));
        return mapElement.isDisplayed();
    }

    public void simulateChangeInLocation() {
        WebElement simulateButton = driver.findElement(By.id(simulate_button));
        simulateButton.click();
    }

    public boolean isLocationUpdatedInRealTime() {
        WebElement updatedLocation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(updated_location)));
        return updatedLocation.isDisplayed();
    }

    public void verifyEstimatedDeliveryTime() {
        WebElement deliveryTimeButton = driver.findElement(By.id(delivery_time_button));
        deliveryTimeButton.click();
    }

    public boolean isEstimatedDeliveryTimeDisplayed() {
        WebElement deliveryTime = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(delivery_time)));
        return deliveryTime.isDisplayed();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public boolean isLiveTrackingInformationConsistent() {
        WebElement trackingInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(tracking_info)));
        return trackingInfo.isDisplayed();
    }

    public void logoutAndLogin() {
        WebElement logoutButton = driver.findElement(By.id(logout_button));
        logoutButton.click();
        // Assume login method is implemented elsewhere
    }

    public boolean isLiveTrackingInformationAvailable() {
        WebElement trackingInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(tracking_info)));
        return trackingInfo.isDisplayed();
    }

    public void checkNotificationSettings() {
        WebElement notificationSettingsButton = driver.findElement(By.id(notification_settings_button));
        notificationSettingsButton.click();
    }

    public boolean areNotificationsEnabled() {
        WebElement notificationsEnabled = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(notifications_enabled)));
        return notificationsEnabled.isDisplayed();
    }

    public void simulateNetworkIssue() {
        WebElement simulateNetworkIssueButton = driver.findElement(By.id(simulate_network_issue_button));
        simulateNetworkIssueButton.click();
    }

    public boolean isSystemHandlingIssueGracefully() {
        WebElement retryMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(retry_message)));
        return retryMessage.isDisplayed();
    }

    public void verifyTrackingHistoryLog() {
        WebElement historyLogButton = driver.findElement(By.id(history_log_button));
        historyLogButton.click();
    }

    public boolean doesLogContainAllUpdates() {
        WebElement historyLog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(history_log)));
        return historyLog.isDisplayed();
    }

    public void checkForErrorMessages() {
        WebElement errorMessageButton = driver.findElement(By.id(error_message_button));
        errorMessageButton.click();
    }

    public boolean areNoErrorMessagesDisplayed() {
        WebElement errorMessage = driver.findElement(By.id(error_message));
        return !errorMessage.isDisplayed();
    }

    public void updateLocationFromDifferentDevice() {
        WebElement updateFromDifferentDeviceButton = driver.findElement(By.id(update_from_different_device_button));
        updateFromDifferentDeviceButton.click();
    }

    public boolean areLocationUpdatesSynchronized() {
        WebElement synchronizedUpdates = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(synchronized_updates)));
        return synchronizedUpdates.isDisplayed();
    }

    public void verifyLiveTrackingOnMobile() {
        WebElement mobileTrackingButton = driver.findElement(By.id(mobile_tracking_button));
        mobileTrackingButton.click();
    }

    public boolean isTrackingConsistentWithDesktop() {
        WebElement mobileTracking = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(mobile_tracking)));
        return mobileTracking.isDisplayed();
    }

    public void checkLiveTrackingAfterReboot() {
        WebElement rebootTrackingButton = driver.findElement(By.id(reboot_tracking_button));
        rebootTrackingButton.click();
    }

    public boolean isTrackingInformationRemainsAvailable() {
        WebElement trackingInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(tracking_info)));
        return trackingInfo.isDisplayed();
    }

    public void verifyAccuracyOfLiveTracking() {
        WebElement accuracyButton = driver.findElement(By.id(accuracy_button));
        accuracyButton.click();
    }

    public boolean isLiveTrackingInformationAccurate() {
        WebElement accuracyInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(accuracy_info)));
        return accuracyInfo.isDisplayed();
    }
}