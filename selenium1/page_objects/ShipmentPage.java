package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class ShipmentPage extends WebReusableComponents {

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
        PageFactory.initElements(getDriver(), this);
    }

    public void login(String userID) {
        WebElement loginFieldElement = waitUntilElementVisible(loginField, 10);
        loginFieldElement.clear();
        loginFieldElement.sendKeys(userID);
        WebElement loginButtonElement = waitUntilElementClickable(loginButton, 10);
        loginButtonElement.click();
        Assert.assertTrue(isTrackingPageDisplayed(), "Login failed, tracking page not displayed.");
    }

    public void navigateToShipmentTrackingPage() {
        WebElement trackingLinkElement = waitUntilElementClickable(trackingLink, 10);
        trackingLinkElement.click();
        Assert.assertTrue(isTrackingPageDisplayed(), "Failed to navigate to shipment tracking page.");
    }

    public boolean isTrackingPageDisplayed() {
        return waitUntilElementVisible(trackingPage, 10).isDisplayed();
    }

    public void enterShipmentID(String shipmentID) {
        WebElement shipmentIDElement = waitUntilElementVisible(shipmentIDField, 10);
        shipmentIDElement.clear();
        shipmentIDElement.sendKeys(shipmentID);
        Assert.assertTrue(isShipmentDetailsDisplayed(shipmentID), "Shipment details not displayed for ID: " + shipmentID);
    }

    public boolean isShipmentDetailsDisplayed(String shipmentID) {
        WebElement shipmentDetailsElement = waitUntilElementVisible(shipmentDetails, 10);
        return shipmentDetailsElement.getText().contains(shipmentID);
    }

    public String checkCurrentStatus() {
        String status = waitUntilElementVisible(currentStatus, 10).getText();
        Assert.assertNotNull(status, "Current status is null.");
        return status;
    }

    public void simulateStatusUpdate(String newStatus) {
        WebElement statusUpdateFieldElement = waitUntilElementVisible(statusUpdateField, 10);
        statusUpdateFieldElement.clear();
        statusUpdateFieldElement.sendKeys(newStatus);
        WebElement updateButtonElement = waitUntilElementClickable(updateButton, 10);
        updateButtonElement.click();
        Assert.assertEquals(checkCurrentStatus(), newStatus, "Status update failed.");
    }

    public String verifyLatestStatusTimestamp() {
        String latestTimestamp = waitUntilElementVisible(timestamp, 10).getText();
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
        getDriver().navigate().refresh();
        Assert.assertTrue(isTrackingPageDisplayed(), "Page refresh failed, tracking page not displayed.");
    }

    public void logout() {
        WebElement logoutButtonElement = waitUntilElementClickable(logoutButton, 10);
        logoutButtonElement.click();
        Assert.assertFalse(isTrackingPageDisplayed(), "Logout failed, tracking page still displayed.");
    }

    public boolean areNotificationsEnabled() {
        boolean notificationsEnabled = waitUntilElementVisible(notifications, 10).isDisplayed();
        Assert.assertTrue(notificationsEnabled, "Notifications are not enabled.");
        return notificationsEnabled;
    }

    public void simulateNetworkIssue() {
        WebElement networkIssueButtonElement = waitUntilElementClickable(networkIssueButton, 10);
        networkIssueButtonElement.click();
        Assert.assertTrue(isNetworkIssueHandledGracefully(), "Network issue not handled gracefully.");
    }

    public boolean isNetworkIssueHandledGracefully() {
        WebElement networkErrorElement = waitUntilElementVisible(networkError, 10);
        boolean isHandled = networkErrorElement.isDisplayed();
        Assert.assertTrue(isHandled, "Network issue not handled gracefully.");
        return isHandled;
    }

    public boolean verifyShipmentHistoryLog() {
        WebElement historyLogElement = waitUntilElementVisible(historyLog, 10);
        boolean isLogVerified = historyLogElement.isDisplayed();
        Assert.assertTrue(isLogVerified, "Shipment history log verification failed.");
        return isLogVerified;
    }

    public boolean areErrorMessagesDisplayed() {
        boolean errorsDisplayed = waitUntilElementVisible(errorMessages, 10).isDisplayed();
        Assert.assertTrue(errorsDisplayed, "Error messages are not displayed.");
        return errorsDisplayed;
    }

    public void updateStatusFromDifferentDevice() {
        WebElement updateDeviceButtonElement = waitUntilElementClickable(updateDeviceButton, 10);
        updateDeviceButtonElement.click();
        Assert.assertTrue(isStatusSynchronizedAcrossDevices(), "Status update from different device failed.");
    }

    public boolean isStatusSynchronizedAcrossDevices() {
        WebElement syncStatusElement = waitUntilElementVisible(syncStatus, 10);
        boolean isSynchronized = syncStatusElement.isDisplayed();
        Assert.assertTrue(isSynchronized, "Status is not synchronized across devices.");
        return isSynchronized;
    }

    public boolean verifyStatusOnMobileDevice() {
        WebElement mobileStatusElement = waitUntilElementVisible(mobileStatus, 10);
        boolean isVerified = mobileStatusElement.isDisplayed();
        Assert.assertTrue(isVerified, "Status verification on mobile device failed.");
        return isVerified;
    }

    public void rebootSystem() {
        WebElement rebootButtonElement = waitUntilElementClickable(rebootButton, 10);
        rebootButtonElement.click();
        Assert.assertTrue(isTrackingPageDisplayed(), "System reboot failed, tracking page not displayed.");
    }
}