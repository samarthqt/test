package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ShipmentPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By trackingPage = By.id("trackingPage");
    private By shipmentIDField = By.id("shipmentID");
    private By currentStatus = By.id("currentStatus");
    private By timestamp = By.id("timestamp");
    private By notifications = By.id("notifications");
    private By errorMessages = By.id("errorMessages");
    private By loginField = By.id("loginField");
    private By loginButton = By.id("loginButton");
    private By trackingLink = By.id("trackingLink");
    private By shipmentDetails = By.id("shipmentDetails");
    private By statusUpdateField = By.id("statusUpdateField");
    private By updateButton = By.id("updateButton");
    private By logoutButton = By.id("logoutButton");
    private By networkIssueButton = By.id("networkIssueButton");
    private By networkError = By.id("networkError");
    private By historyLog = By.id("historyLog");
    private By updateDeviceButton = By.id("updateDeviceButton");
    private By syncStatus = By.id("syncStatus");
    private By mobileStatus = By.id("mobileStatus");
    private By rebootButton = By.id("rebootButton");

    public ShipmentPage() {
        this.driver = getDriver();
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void login(String userID) {
        WebElement loginFieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(loginField));
        loginFieldElement.clear();
        loginFieldElement.sendKeys(userID);
        WebElement loginButtonElement = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButtonElement.click();
        Assert.assertTrue(isTrackingPageDisplayed(), "Login failed, tracking page not displayed.");
    }

    public void navigateToShipmentTrackingPage() {
        WebElement trackingLinkElement = wait.until(ExpectedConditions.elementToBeClickable(trackingLink));
        trackingLinkElement.click();
        Assert.assertTrue(isTrackingPageDisplayed(), "Failed to navigate to shipment tracking page.");
    }

    public boolean isTrackingPageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(trackingPage)).isDisplayed();
    }

    public void enterShipmentID(String shipmentID) {
        WebElement shipmentIDElement = wait.until(ExpectedConditions.visibilityOfElementLocated(shipmentIDField));
        shipmentIDElement.clear();
        shipmentIDElement.sendKeys(shipmentID);
        Assert.assertTrue(isShipmentDetailsDisplayed(shipmentID), "Shipment details not displayed for ID: " + shipmentID);
    }

    public boolean isShipmentDetailsDisplayed(String shipmentID) {
        WebElement shipmentDetailsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(shipmentDetails));
        return shipmentDetailsElement.getText().contains(shipmentID);
    }

    public String checkCurrentStatus() {
        String status = wait.until(ExpectedConditions.visibilityOfElementLocated(currentStatus)).getText();
        Assert.assertNotNull(status, "Current status is null.");
        return status;
    }

    public void simulateStatusUpdate(String newStatus) {
        WebElement statusUpdateFieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(statusUpdateField));
        statusUpdateFieldElement.clear();
        statusUpdateFieldElement.sendKeys(newStatus);
        WebElement updateButtonElement = wait.until(ExpectedConditions.elementToBeClickable(updateButton));
        updateButtonElement.click();
        Assert.assertEquals(checkCurrentStatus(), newStatus, "Status update failed.");
    }

    public String verifyLatestStatusTimestamp() {
        String latestTimestamp = wait.until(ExpectedConditions.visibilityOfElementLocated(timestamp)).getText();
        Assert.assertNotNull(latestTimestamp, "Timestamp is null.");
        return latestTimestamp;
    }

    public boolean isTimestampCurrent(String timestamp) {
        String currentTimestamp = verifyLatestStatusTimestamp();
        boolean isCurrent = currentTimestamp.equals(timestamp);
        Assert.assertTrue(isCurrent, "Timestamp is not current.");
        return isCurrent;
    }

    public void refreshPage() {
        driver.navigate().refresh();
        Assert.assertTrue(isTrackingPageDisplayed(), "Page refresh failed, tracking page not displayed.");
    }

    public void logout() {
        WebElement logoutButtonElement = wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logoutButtonElement.click();
        Assert.assertFalse(isTrackingPageDisplayed(), "Logout failed, tracking page still displayed.");
    }

    public boolean areNotificationsEnabled() {
        boolean notificationsEnabled = wait.until(ExpectedConditions.visibilityOfElementLocated(notifications)).isDisplayed();
        Assert.assertTrue(notificationsEnabled, "Notifications are not enabled.");
        return notificationsEnabled;
    }

    public void simulateNetworkIssue() {
        WebElement networkIssueButtonElement = wait.until(ExpectedConditions.elementToBeClickable(networkIssueButton));
        networkIssueButtonElement.click();
        Assert.assertTrue(isNetworkIssueHandledGracefully(), "Network issue not handled gracefully.");
    }

    public boolean isNetworkIssueHandledGracefully() {
        WebElement networkErrorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(networkError));
        boolean isHandled = networkErrorElement.isDisplayed();
        Assert.assertTrue(isHandled, "Network issue not handled gracefully.");
        return isHandled;
    }

    public boolean verifyShipmentHistoryLog() {
        WebElement historyLogElement = wait.until(ExpectedConditions.visibilityOfElementLocated(historyLog));
        boolean isLogVerified = historyLogElement.isDisplayed();
        Assert.assertTrue(isLogVerified, "Shipment history log verification failed.");
        return isLogVerified;
    }

    public boolean areErrorMessagesDisplayed() {
        boolean errorsDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessages)).isDisplayed();
        Assert.assertTrue(errorsDisplayed, "Error messages are not displayed.");
        return errorsDisplayed;
    }

    public void updateStatusFromDifferentDevice() {
        WebElement updateDeviceButtonElement = wait.until(ExpectedConditions.elementToBeClickable(updateDeviceButton));
        updateDeviceButtonElement.click();
        Assert.assertTrue(isStatusSynchronizedAcrossDevices(), "Status update from different device failed.");
    }

    public boolean isStatusSynchronizedAcrossDevices() {
        WebElement syncStatusElement = wait.until(ExpectedConditions.visibilityOfElementLocated(syncStatus));
        boolean isSynchronized = syncStatusElement.isDisplayed();
        Assert.assertTrue(isSynchronized, "Status is not synchronized across devices.");
        return isSynchronized;
    }

    public boolean verifyStatusOnMobileDevice() {
        WebElement mobileStatusElement = wait.until(ExpectedConditions.visibilityOfElementLocated(mobileStatus));
        boolean isVerified = mobileStatusElement.isDisplayed();
        Assert.assertTrue(isVerified, "Status verification on mobile device failed.");
        return isVerified;
    }

    public void rebootSystem() {
        WebElement rebootButtonElement = wait.until(ExpectedConditions.elementToBeClickable(rebootButton));
        rebootButtonElement.click();
        Assert.assertTrue(isTrackingPageDisplayed(), "System reboot failed, tracking page not displayed.");
    }

    private WebDriver getDriver() {
        // This method should return the WebDriver instance used in the test framework
        return null; // Placeholder for actual WebDriver retrieval logic
    }
}