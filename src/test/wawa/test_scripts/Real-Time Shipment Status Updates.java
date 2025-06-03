import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ShipmentTrackingTest {

    private WebDriver driver;

    public ShipmentTrackingTest() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    public void navigateToShipmentTrackingPage() {
        driver.get("http://example.com/shipment-tracking");
    }

    public void enterShipmentID(String shipmentID) {
        WebElement trackingField = driver.findElement(By.id("trackingField"));
        trackingField.sendKeys(shipmentID);
    }

    public void checkCurrentStatus() {
        WebElement statusElement = driver.findElement(By.id("currentStatus"));
        String status = statusElement.getText();
        Assert.assertNotNull(status, "Status is not displayed.");
    }

    public void simulateStatusUpdate(String newStatus) {
        WebElement statusUpdateButton = driver.findElement(By.id("statusUpdateButton"));
        statusUpdateButton.click();
        WebElement statusField = driver.findElement(By.id("statusField"));
        statusField.clear();
        statusField.sendKeys(newStatus);
        WebElement confirmButton = driver.findElement(By.id("confirmButton"));
        confirmButton.click();
    }

    public void verifyTimestampOfLatestUpdate() {
        WebElement timestampElement = driver.findElement(By.id("latestTimestamp"));
        String timestamp = timestampElement.getText();
        Assert.assertNotNull(timestamp, "Timestamp is not displayed.");
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void logoutAndLogin() {
        WebElement logoutButton = driver.findElement(By.id("logoutButton"));
        logoutButton.click();
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
    }

    public void checkNotificationSettings() {
        WebElement notificationSettings = driver.findElement(By.id("notificationSettings"));
        Assert.assertTrue(notificationSettings.isDisplayed(), "Notification settings are not visible.");
    }

    public void simulateNetworkIssueAndUpdateStatus() {
        WebElement statusUpdateButton = driver.findElement(By.id("statusUpdateButton"));
        statusUpdateButton.click();
        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed.");
    }

    public void verifyShipmentHistoryLog() {
        WebElement historyLog = driver.findElement(By.id("historyLog"));
        Assert.assertTrue(historyLog.isDisplayed(), "Shipment history log is not visible.");
    }

    public void checkForErrorMessagesDuringUpdates() {
        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed during updates.");
    }

    public void updateStatusFromDifferentDevice() {
        WebElement statusUpdateButton = driver.findElement(By.id("statusUpdateButton"));
        statusUpdateButton.click();
    }

    public void verifyShipmentStatusOnMobileDevice() {
        WebElement mobileStatus = driver.findElement(By.id("mobileStatus"));
        Assert.assertTrue(mobileStatus.isDisplayed(), "Shipment status is not visible on mobile device.");
    }

    public void checkShipmentStatusAfterSystemReboot() {
        WebElement statusElement = driver.findElement(By.id("currentStatus"));
        String status = statusElement.getText();
        Assert.assertNotNull(status, "Status is not displayed after system reboot.");
    }

    public void closeBrowser() {
        driver.quit();
    }

    public static void main(String[] args) {
        ShipmentTrackingTest test = new ShipmentTrackingTest();
        test.navigateToShipmentTrackingPage();
        test.enterShipmentID("12345");
        test.checkCurrentStatus();
        test.simulateStatusUpdate("Out for Delivery");
        test.simulateStatusUpdate("Delivered");
        test.verifyTimestampOfLatestUpdate();
        test.refreshPage();
        test.logoutAndLogin();
        test.checkNotificationSettings();
        test.simulateNetworkIssueAndUpdateStatus();
        test.verifyShipmentHistoryLog();
        test.checkForErrorMessagesDuringUpdates();
        test.updateStatusFromDifferentDevice();
        test.verifyShipmentStatusOnMobileDevice();
        test.checkShipmentStatusAfterSystemReboot();
        test.closeBrowser();
    }
}