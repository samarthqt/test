
package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import .time.Duration;

public class ShipmentTrackingPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public ShipmentTrackingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToShipmentTrackingPage() {
        driver.get(http://example.com/shipment-tracking);
    }

    public boolean isShipmentTrackingPageDisplayed() {
        WebElement trackingPageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(tracking_page)));
        return trackingPageElement.isDisplayed();
    }

    public void enterShipmentID(String shipmentID) {
        WebElement trackingField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(tracking_field)));
        trackingField.sendKeys(shipmentID);
    }

    public boolean isShipmentDetailsDisplayed(String shipmentID) {
        WebElement shipmentDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(shipment_details)));
        return shipmentDetails.getText().contains(shipmentID);
    }

    public void selectLocation() {
        WebElement locationField = driver.findElement(By.id(location_field));
        locationField.click();
    }

    public void clickOkButton() {
        WebElement okButton = driver.findElement(By.id(ok_button));
        okButton.click();
    }

    public String getCurrentShipmentStatus() {
        WebElement statusElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(current_status)));
        return statusElement.getText();
    }

    public void simulateStatusUpdate(String newStatus) {
        WebElement statusElement = driver.findElement(By.id(status_update));
        statusElement.clear();
        statusElement.sendKeys(newStatus);
    }

    public boolean isTimestampCorrect() {
        WebElement timestampElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(timestamp)));
        return timestampElement.getText().equals(current time);
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void logoutAndLogin() {
        WebElement logoutButton = driver.findElement(By.id(logout_button));
        logoutButton.click();
        driver.get(http://example.com/login);
    }

    public boolean areNotificationsEnabled() {
        WebElement notificationsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(notifications)));
        return notificationsElement.isDisplayed();
    }

    public void simulateNetworkIssue() {
        WebElement networkIssueElement = driver.findElement(By.id(network_issue));
        networkIssueElement.click();
    }

    public boolean isNetworkIssueHandledGracefully() {
        WebElement networkIssueHandledElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(network_issue_handled)));
        return networkIssueHandledElement.isDisplayed();
    }

    public boolean isShipmentHistoryLogCorrect() {
        WebElement historyLogElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(history_log)));
        return historyLogElement.getText().contains(all status updates with timestamps);
    }

    public boolean areErrorMessagesDisplayed() {
        WebElement errorMessagesElement = driver.findElement(By.id(error_messages));
        return errorMessagesElement.isDisplayed();
    }

    public void navigateToLiveTrackingPage() {
        driver.get(http://example.com/live-tracking);
    }

    public boolean isLiveTrackingPageDisplayed() {
        WebElement liveTrackingPageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(live_tracking_page)));
        return liveTrackingPageElement.isDisplayed();
    }

    public boolean isLiveTrackingDetailsDisplayed(String shipmentID) {
        WebElement liveTrackingDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(live_tracking_details)));
        return liveTrackingDetails.getText().contains(shipmentID);
    }

    public boolean isCurrentLocationDisplayedOnMap() {
        WebElement locationMapElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(location_map)));
        return locationMapElement.isDisplayed();
    }
}
