package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ShipmentTrackingPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By txtShipmentId = By.id("shipmentId");
    private By locationDropdown = By.id("location");
    private By btnOk = By.id("okButton");
    private By lblCurrentStatus = By.id("currentStatus");
    private By btnRefresh = By.id("refreshButton");
    private By btnLogout = By.id("logoutButton");
    private By notificationSettings = By.id("notificationSettings");
    private By errorMessage = By.id("errorMessage");
    private By shipmentHistoryLog = By.id("shipmentHistoryLog");

    public ShipmentTrackingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void navigateToShipmentTrackingPage(String url) {
        driver.get(url);
    }

    public void enterShipmentId(String shipmentId) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtShipmentId));
        driver.findElement(txtShipmentId).sendKeys(shipmentId);
    }

    public void selectLocation(String location) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locationDropdown));
        WebElement dropdown = driver.findElement(locationDropdown);
        dropdown.findElement(By.xpath("//option[. = '" + location + "']")).click();
    }

    public void clickOkButton() {
        wait.until(ExpectedConditions.elementToBeClickable(btnOk));
        driver.findElement(btnOk).click();
    }

    public String checkCurrentStatus() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lblCurrentStatus));
        return driver.findElement(lblCurrentStatus).getText();
    }

    public void simulateStatusUpdate(String status) {
        // Simulate status update logic here
    }

    public void verifyTimestampOfLatestStatusUpdate(String expectedTimestamp) {
        // Verify timestamp logic here
    }

    public void refreshPage() {
        driver.findElement(btnRefresh).click();
    }

    public void logoutAndLogin(String username, String password) {
        driver.findElement(btnLogout).click();
        // Logic to log back in
    }

    public void checkNotificationSettings() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(notificationSettings));
        // Check notification settings logic here
    }

    public void simulateNetworkIssueAndAttemptUpdate() {
        // Simulate network issue logic here
    }

    public void verifyShipmentHistoryLog() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(shipmentHistoryLog));
        // Verify shipment history log logic here
    }

    public void checkForErrorMessages() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        // Check for error messages logic here
    }
}