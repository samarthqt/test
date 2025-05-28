package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShipmentTrackingPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(id = shipmentTrackingField)
    private WebElement trackingField;

    @FindBy(id = currentStatus)
    private WebElement currentStatus;

    @FindBy(id = statusUpdateButton)
    private WebElement statusUpdateButton;

    @FindBy(id = timestamp)
    private WebElement timestamp;

    @FindBy(id = refreshButton)
    private WebElement refreshButton;

    @FindBy(id = logoutButton)
    private WebElement logoutButton;

    @FindBy(id = loginButton)
    private WebElement loginButton;

    @FindBy(id = notificationSettings)
    private WebElement notificationSettings;

    @FindBy(id = networkIssueSimulation)
    private WebElement networkIssueSimulation;

    @FindBy(id = shipmentHistoryLog)
    private WebElement shipmentHistoryLog;

    @FindBy(id = errorMessages)
    private WebElement errorMessages;

    @FindBy(id = deviceStatusUpdate)
    private WebElement deviceStatusUpdate;

    @FindBy(id = mobileViewCheck)
    private WebElement mobileViewCheck;

    @FindBy(id = systemRebootCheck)
    private WebElement systemRebootCheck;

    public ShipmentTrackingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void navigateToShipmentTrackingPage() {
        driver.get(URL_OF_SHIPMENT_TRACKING_PAGE);
        wait.until(ExpectedConditions.visibilityOf(trackingField));
        Assert.assertTrue(trackingField.isDisplayed(), Shipment Tracking Page did not load correctly.);
    }

    public void enterShipmentID(String shipmentID) {
        wait.until(ExpectedConditions.visibilityOf(trackingField));
        trackingField.clear();
        trackingField.sendKeys(shipmentID);
        Assert.assertEquals(trackingField.getAttribute(value), shipmentID, Shipment ID entry failed.);
    }

    public String getCurrentStatus() {
        wait.until(ExpectedConditions.visibilityOf(currentStatus));
        String status = currentStatus.getText();
        Assert.assertNotNull(status, Current status is not available.);
        return status;
    }

    public void simulateStatusUpdate(String status) {
        wait.until(ExpectedConditions.elementToBeClickable(statusUpdateButton));
        statusUpdateButton.click();
        wait.until(ExpectedConditions.textToBePresentInElement(currentStatus, status));
        Assert.assertEquals(currentStatus.getText(), status, Status update simulation failed.);
    }

    public String getTimestamp() {
        wait.until(ExpectedConditions.visibilityOf(timestamp));
        String time = timestamp.getText();
        Assert.assertNotNull(time, Timestamp is not available.);
        return time;
    }

    public void refreshPage() {
        wait.until(ExpectedConditions.elementToBeClickable(refreshButton));
        refreshButton.click();
        wait.until(ExpectedConditions.visibilityOf(trackingField));
        Assert.assertTrue(trackingField.isDisplayed(), Page refresh failed.);
    }

    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logoutButton.click();
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        Assert.assertTrue(loginButton.isDisplayed(), Logout failed.);
    }

    public void login() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        wait.until(ExpectedConditions.visibilityOf(trackingField));
        Assert.assertTrue(trackingField.isDisplayed(), Login failed.);
    }

    public boolean areNotificationsEnabled() {
        wait.until(ExpectedConditions.visibilityOf(notificationSettings));
        boolean enabled = notificationSettings.isSelected();
        Assert.assertTrue(enabled, Notifications are not enabled.);
        return enabled;
    }

    public void simulateNetworkIssue() {
        wait.until(ExpectedConditions.elementToBeClickable(networkIssueSimulation));
        networkIssueSimulation.click();
        Assert.assertTrue(isErrorMessageDisplayed(), Network issue simulation failed.);
    }

    public String getShipmentHistoryLog() {
        wait.until(ExpectedConditions.visibilityOf(shipmentHistoryLog));
        String log = shipmentHistoryLog.getText();
        Assert.assertNotNull(log, Shipment history log is not available.);
        return log;
    }

    public boolean isErrorMessageDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(errorMessages));
        boolean displayed = errorMessages.isDisplayed();
        Assert.assertTrue(displayed, Error message is not displayed.);
        return displayed;
    }

    public void updateStatusFromDifferentDevice() {
        wait.until(ExpectedConditions.elementToBeClickable(deviceStatusUpdate));
        deviceStatusUpdate.click();
        Assert.assertTrue(isStatusConsistentAfterReboot(), Status update from different device failed.);
    }

    public boolean isMobileViewConsistent() {
        wait.until(ExpectedConditions.visibilityOf(mobileViewCheck));
        boolean consistent = mobileViewCheck.isDisplayed();
        Assert.assertTrue(consistent, Mobile view is not consistent.);
        return consistent;
    }

    public boolean isStatusConsistentAfterReboot() {
        wait.until(ExpectedConditions.visibilityOf(systemRebootCheck));
        boolean consistent = systemRebootCheck.isDisplayed();
        Assert.assertTrue(consistent, Status is not consistent after reboot.);
        return consistent;
    }
}