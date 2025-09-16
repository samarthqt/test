package selenium1.page_objects;

import com.framework.reusable.WebReusableComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ShipmentPage extends WebReusableComponents {

    protected final By trackingPage = By.id("trackingPage");
    protected final By shipmentIDField = By.id("shipmentID");
    protected final By currentStatus = By.id("currentStatus");
    protected final By timestamp = By.id("timestamp");
    protected final By notifications = By.id("notifications");
    protected final By errorMessages = By.id("errorMessages");
    protected final By loginField = By.id("loginField");
    protected final By loginButton = By.id("loginButton");
    protected final By trackingLink = By.id("trackingLink");
    protected final By shipmentDetails = By.id("shipmentDetails");
    protected final By statusUpdateField = By.id("statusUpdateField");
    protected final By updateButton = By.id("updateButton");
    protected final By logoutButton = By.id("logoutButton");
    protected final By networkIssueButton = By.id("networkIssueButton");
    protected final By networkError = By.id("networkError");
    protected final By historyLog = By.id("historyLog");

    public ShipmentPage() {
        PageFactory.initElements(getDriver(), this);
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
        getDriver().navigate().refresh();
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

    public WebElement waitUntilElementVisible(By locator) {
        return new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitUntilElementClickable(By locator) {
        return new WebDriverWait(getDriver(), 10).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebDriver getDriver() {
        // Implement method to return WebDriver instance
        return null;
    }
}