package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ShipmentTrackingPage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected By trackingField = By.id("trackingField");
    protected By locationField = By.id("locationField");
    protected By okButton = By.id("okButton");
    protected By statusField = By.id("statusField");
    protected By timestampField = By.id("timestampField");
    protected By notificationSettings = By.id("notificationSettings");
    protected By errorMessage = By.id("errorMessage");

    public ShipmentTrackingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void login(String userId) {
        WebElement loginField = driver.findElement(By.id("loginField"));
        loginField.sendKeys(userId);
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
        Assert.assertTrue(isTrackingPageDisplayed(), "Login failed, tracking page not displayed.");
    }

    public void navigateToShipmentTrackingPage() {
        WebElement trackingPageLink = driver.findElement(By.id("trackingPageLink"));
        trackingPageLink.click();
        Assert.assertTrue(isTrackingPageDisplayed(), "Failed to navigate to shipment tracking page.");
    }

    public boolean isTrackingPageDisplayed() {
        return driver.findElement(trackingField).isDisplayed();
    }

    public void enterShipmentID(String shipmentId) {
        WebElement shipmentIdField = driver.findElement(trackingField);
        shipmentIdField.sendKeys(shipmentId);
        Assert.assertTrue(isShipmentDetailsDisplayed(shipmentId), "Shipment details not displayed.");
    }

    public boolean isShipmentDetailsDisplayed(String shipmentId) {
        WebElement shipmentDetails = driver.findElement(By.id("shipmentDetails"));
        return shipmentDetails.getText().contains(shipmentId);
    }

    public void selectLocation() {
        WebElement locationDropdown = driver.findElement(locationField);
        locationDropdown.click();
        WebElement locationOption = driver.findElement(By.id("locationOption"));
        locationOption.click();
        Assert.assertTrue(locationOption.isSelected(), "Location selection failed.");
    }

    public void clickOkButton() {
        WebElement okBtn = driver.findElement(okButton);
        okBtn.click();
        Assert.assertTrue(isTrackingPageDisplayed(), "Failed to confirm action with OK button.");
    }

    public String getCurrentStatus() {
        WebElement statusElement = driver.findElement(statusField);
        String status = statusElement.getText();
        Assert.assertNotNull(status, "Current status is null.");
        return status;
    }

    public void simulateStatusUpdate(String newStatus) {
        WebElement statusElement = driver.findElement(statusField);
        statusElement.clear();
        statusElement.sendKeys(newStatus);
        Assert.assertEquals(getCurrentStatus(), newStatus, "Status update simulation failed.");
    }

    public String getLatestTimestamp() {
        WebElement timestampElement = driver.findElement(timestampField);
        String timestamp = timestampElement.getText();
        Assert.assertNotNull(timestamp, "Latest timestamp is null.");
        return timestamp;
    }

    public String getCurrentTime() {
        WebElement timeElement = driver.findElement(By.id("currentTime"));
        String currentTime = timeElement.getText();
        Assert.assertNotNull(currentTime, "Current time is null.");
        return currentTime;
    }

    public void refreshPage() {
        driver.navigate().refresh();
        Assert.assertTrue(isTrackingPageDisplayed(), "Page refresh failed.");
    }

    public void logout() {
        WebElement logoutButton = driver.findElement(By.id("logoutButton"));
        logoutButton.click();
        Assert.assertFalse(isTrackingPageDisplayed(), "Logout failed, tracking page still displayed.");
    }

    public boolean areNotificationsEnabled() {
        WebElement notificationsToggle = driver.findElement(notificationSettings);
        return notificationsToggle.isSelected();
    }

    public void simulateNetworkIssue() {
        WebElement networkIssueButton = driver.findElement(By.id("networkIssueButton"));
        networkIssueButton.click();
        Assert.assertTrue(isErrorMessageDisplayed(), "Network issue simulation failed.");
    }

    public boolean handleNetworkIssueGracefully() {
        WebElement retryButton = driver.findElement(By.id("retryButton"));
        retryButton.click();
        return !isErrorMessageDisplayed();
    }

    public boolean verifyShipmentHistoryLog() {
        WebElement historyLog = driver.findElement(By.id("historyLog"));
        return historyLog.isDisplayed();
    }

    public boolean isErrorMessageDisplayed() {
        WebElement errorElement = driver.findElement(errorMessage);
        return errorElement.isDisplayed();
    }
}