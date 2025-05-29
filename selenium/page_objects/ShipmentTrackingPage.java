package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * ShipmentTrackingPage class provides methods to interact with the shipment tracking page.
 */
public class ShipmentTrackingPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By shipmentIdField = By.id(shipmentId);
    private final By statusField = By.id(status);
    private final By timestampField = By.id(timestamp);
    private final By notificationSettings = By.id(notificationSettings);
    private final By errorMessages = By.id(errorMessages);
    private final By historyLog = By.id(historyLog);
    private final By loginButton = By.id(loginButton);
    private final By logoutButton = By.id(logoutButton);
    private final By usernameField = By.id(username);
    private final By passwordField = By.id(password);

    /**
     * Constructor to initialize the ShipmentTrackingPage with WebDriver.
     *
     * @param driver WebDriver instance
     */
    public ShipmentTrackingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    /**
     * Logs in to the application using the provided username and password.
     *
     * @param username User's username
     * @param password User's password
     */
    public void login(String username, String password) {
        WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        usernameElement.sendKeys(username);
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passwordElement.sendKeys(password);
        WebElement loginElement = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginElement.click();
    }

    /**
     * Navigates to the shipment tracking page.
     */
    public void navigateToShipmentTrackingPage() {
        driver.get(http://example.com/shipmentTracking);
        Assert.assertEquals(getPageTitle(), Shipment Tracking, Page title does not match.);
    }

    /**
     * Retrieves the title of the current page.
     *
     * @return Page title
     */
    public String getPageTitle() {
        return driver.getTitle();
    }

    /**
     * Enters the shipment ID into the shipment ID field.
     *
     * @param shipmentId Shipment ID
     */
    public void enterShipmentId(String shipmentId) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(shipmentIdField));
        element.sendKeys(shipmentId);
    }

    /**
     * Retrieves the shipment status.
     *
     * @return Shipment status
     */
    public String getShipmentStatus() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(statusField));
        return element.getText();
    }

    /**
     * Simulates a status update for the shipment.
     *
     * @param status New status
     */
    public void simulateStatusUpdate(String status) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(statusField));
        element.clear();
        element.sendKeys(status);
        Assert.assertEquals(getShipmentStatus(), status, Shipment status update failed.);
    }

    /**
     * Retrieves the timestamp of the shipment status.
     *
     * @return Timestamp
     */
    public String getTimestamp() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(timestampField));
        return element.getText();
    }

    /**
     * Retrieves the current system time.
     *
     * @return Current time
     */
    public String getCurrentTime() {
        return .time.LocalTime.now().toString();
    }

    /**
     * Refreshes the current page.
     */
    public void refreshPage() {
        driver.navigate().refresh();
        Assert.assertTrue(driver.getTitle().contains(Shipment Tracking), Page refresh failed.);
    }

    /**
     * Logs out and then logs back in to the application.
     */
    public void logoutAndLogin() {
        logout();
        login(defaultUser, defaultPassword);
        Assert.assertTrue(driver.getTitle().contains(Shipment Tracking), Logout and login failed.);
    }

    /**
     * Retrieves the notification settings.
     *
     * @return Notification settings
     */
    public String getNotificationSettings() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(notificationSettings));
        return element.getText();
    }

    /**
     * Simulates a network issue.
     */
    public void simulateNetworkIssue() {
        driver.manage().timeouts().pageLoadTimeout(.time.Duration.ofSeconds(1));
        try {
            driver.navigate().refresh();
        } catch (Exception e) {
            Assert.assertTrue(e.getMessage().contains(timeout), Network issue simulation failed.);
        } finally {
            driver.manage().timeouts().pageLoadTimeout(.time.Duration.ofSeconds(10));
        }
    }

    /**
     * Retrieves error messages displayed on the page.
     *
     * @return Error messages
     */
    public String getErrorMessages() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessages));
        return element.getText();
    }

    /**
     * Retrieves the shipment history log.
     *
     * @return Shipment history log
     */
    public String getShipmentHistoryLog() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(historyLog));
        return element.getText();
    }

    /**
     * Logs out of the application.
     */
    public void logout() {
        WebElement logoutElement = wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logoutElement.click();
        Assert.assertTrue(driver.getTitle().contains(Login), Logout failed.);
    }
}