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

    protected By trackingPage = By.id("trackingPage");
    protected By shipmentIDField = By.id("shipmentID");
    protected By currentStatus = By.id("currentStatus");
    protected By timestamp = By.id("timestamp");
    protected By notifications = By.id("notifications");
    protected By errorMessages = By.id("errorMessages");
    protected By loginField = By.id("loginField");
    protected By loginButton = By.id("loginButton");
    protected By trackingLink = By.id("trackingLink");
    protected By shipmentDetails = By.id("shipmentDetails");
    protected By statusUpdateField = By.id("statusUpdateField");
    protected By updateButton = By.id("updateButton");
    protected By logoutButton = By.id("logoutButton");
    protected By networkIssueButton = By.id("networkIssueButton");
    protected By networkError = By.id("networkError");
    protected By historyLog = By.id("historyLog");
    protected By updateDeviceButton = By.id("updateDeviceButton");
    protected By syncStatus = By.id("syncStatus");
    protected By mobileStatus = By.id("mobileStatus");
    protected By rebootButton = By.id("rebootButton");

    public ShipmentPage() {
        this.driver = getDriver();
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {
        // Implement logic to return WebDriver instance
        return driver;
    }

    public WebElement waitUntilElementVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitUntilElementClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void login(String userID) {
        WebElement loginFieldElement = waitUntilElementVisible(loginField);
        loginFieldElement.clear();
        loginFieldElement.sendKeys(userID);
        WebElement loginButtonElement = waitUntilElementClickable(loginButton);
        loginButtonElement.click();
        Assert.assertTrue(isTrackingPageDisplayed(), "Login failed, tracking page not displayed.");
    }

    public void navigateToShipmentTrackingPage() {
        WebElement trackingLinkElement = waitUntilElementClickable(trackingLink);
        trackingLinkElement.click();
        Assert.assertTrue(isTrackingPageDisplayed(), "Failed to navigate to shipment tracking page.");
    }

    public boolean isTrackingPageDisplayed() {
        return waitUntilElementVisible(trackingPage).isDisplayed();
    }

    public void enterShipmentID(String shipmentID) {
        WebElement shipmentIDElement = waitUntilElementVisible(shipmentIDField);
        shipmentIDElement.clear();
        shipmentIDElement.sendKeys(shipmentID);
        Assert.assertTrue(isShipmentDetailsDisplayed(shipmentID), "Shipment details not displayed for ID: " + shipmentID);
    }

    public boolean isShipmentDetailsDisplayed(String shipmentID) {
        WebElement shipmentDetailsElement = waitUntilElementVisible(shipmentDetails);
        return shipmentDetailsElement.getText().contains(shipmentID);
    }

    public String checkCurrentStatus() {
        String status = waitUntilElementVisible(currentStatus).getText();
        Assert.assertNotNull(status, "Current status is null.");
        return status;
    }

    public void simulateStatusUpdate(String newStatus) {
        WebElement statusUpdateFieldElement = waitUntilElementVisible(statusUpdateField);
        statusUpdateFieldElement.clear();
        statusUpdateFieldElement.sendKeys(newStatus);
        WebElement updateButtonElement = waitUntilElementClickable(updateButton);
        updateButtonElement.click();
        Assert.assertEquals(checkCurrentStatus(), newStatus, "Status update failed.");
    }

    public String verifyLatestStatusTimestamp() {
        String latestTimestamp = waitUntilElementVisible(timestamp).getText();
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
        WebElement logoutButtonElement = waitUntilElementClickable(logoutButton);
        logoutButtonElement.click();
        Assert.assertFalse(isTrackingPageDisplayed(), "Logout failed, tracking page still displayed.");
    }

    public boolean areNotificationsEnabled() {
        boolean notificationsEnabled = waitUntilElementVisible(notifications).isDisplayed();
        Assert.assertTrue(notificationsEnabled, "Notifications are not enabled.");
        return notificationsEnabled;
    }

    public void simulateNetworkIssue() {
        WebElement networkIssueButtonElement = waitUntilElementClickable(networkIssueButton);
        networkIssueButtonElement.click();
        Assert.assertTrue(isNetworkIssueHandledGracefully(), "Network issue not handled gracefully.");
    }

    public boolean isNetworkIssueHandledGracefully() {
        WebElement networkErrorElement = waitUntilElementVisible(networkError);
        boolean isHandled = networkErrorElement.isDisplayed();
        Assert.assertTrue(isHandled, "Network issue not handled gracefully.");
        return isHandled;
    }

    public boolean verifyShipmentHistoryLog() {
        WebElement historyLogElement = waitUntilElementVisible(historyLog);
        boolean isLogVerified = historyLogElement.isDisplayed();
        Assert.assertTrue(isLogVerified, "Shipment history log verification failed.");
        return isLogVerified;
    }

    public boolean areErrorMessagesDisplayed() {
        boolean errorsDisplayed = waitUntilElementVisible(errorMessages).isDisplayed();
        Assert.assertTrue(errorsDisplayed, "Error messages are not displayed.");
        return errorsDisplayed;
    }

    public void updateStatusFromDifferentDevice() {
        WebElement updateDeviceButtonElement = waitUntilElementClickable(updateDeviceButton);
        updateDeviceButtonElement.click();
        Assert.assertTrue(isStatusSynchronizedAcrossDevices(), "Status update from different device failed.");
    }

    public boolean isStatusSynchronizedAcrossDevices() {
        WebElement syncStatusElement = waitUntilElementVisible(syncStatus);
        boolean isSynchronized = syncStatusElement.isDisplayed();
        Assert.assertTrue(isSynchronized, "Status is not synchronized across devices.");
        return isSynchronized;
    }

    public boolean verifyStatusOnMobileDevice() {
        WebElement mobileStatusElement = waitUntilElementVisible(mobileStatus);
        boolean isVerified = mobileStatusElement.isDisplayed();
        Assert.assertTrue(isVerified, "Status verification on mobile device failed.");
        return isVerified;
    }

    public void rebootSystem() {
        WebElement rebootButtonElement = waitUntilElementClickable(rebootButton);
        rebootButtonElement.click();
        Assert.assertTrue(isTrackingPageDisplayed(), "System reboot failed, tracking page not displayed.");
    }

    public void checkNotificationSettingsForShipmentUpdates() {
        Assert.assertTrue(areNotificationsEnabled(), "Notification settings for shipment updates are not enabled.");
    }

    public void simulateNetworkIssueAndAttemptStatusUpdate() {
        simulateNetworkIssue();
        simulateStatusUpdate("Delayed");
        Assert.assertTrue(isNetworkIssueHandledGracefully(), "Network issue not handled during status update.");
    }

    public void attemptStatusUpdateFromDifferentDevice() {
        updateStatusFromDifferentDevice();
        Assert.assertTrue(isStatusSynchronizedAcrossDevices(), "Status update from different device not synchronized.");
    }

    public void checkForErrorMessagesDuringStatusUpdates() {
        simulateStatusUpdate("Invalid");
        Assert.assertTrue(areErrorMessagesDisplayed(), "Error messages not displayed during status update.");
    }

    public void checkShipmentStatusAfterSystemReboot() {
        rebootSystem();
        Assert.assertTrue(isTrackingPageDisplayed(), "Shipment status not verified after system reboot.");
    }

    public void verifyShipmentStatusUsingSMSOnMobileDevice() {
        Assert.assertTrue(verifyStatusOnMobileDevice(), "Shipment status verification using SMS on mobile device failed.");
    }
}