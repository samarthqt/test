import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ShipmentTrackingAutomation {

    private WebDriver driver;

    public ShipmentTrackingAutomation() {
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

    public void selectLocation(String location) {
        WebElement locationField = driver.findElement(By.id("locationField"));
        locationField.sendKeys(location);
    }

    public void clickOkButton() {
        WebElement okButton = driver.findElement(By.id("okButton"));
        okButton.click();
    }

    public String checkCurrentStatus() {
        WebElement statusElement = driver.findElement(By.id("currentStatus"));
        return statusElement.getText();
    }

    public void simulateStatusUpdate(String newStatus) {
        WebElement statusUpdateField = driver.findElement(By.id("statusUpdateField"));
        statusUpdateField.sendKeys(newStatus);
        WebElement updateButton = driver.findElement(By.id("updateButton"));
        updateButton.click();
    }

    public String verifyTimestamp() {
        WebElement timestampElement = driver.findElement(By.id("timestamp"));
        return timestampElement.getText();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void logOutAndLogBackIn() {
        WebElement logoutButton = driver.findElement(By.id("logoutButton"));
        logoutButton.click();
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
    }

    public void checkNotificationSettings() {
        WebElement notificationSettings = driver.findElement(By.id("notificationSettings"));
        notificationSettings.click();
    }

    public void simulateNetworkIssue() {
        WebElement networkIssueButton = driver.findElement(By.id("networkIssueButton"));
        networkIssueButton.click();
    }

    public void verifyShipmentHistoryLog() {
        WebElement historyLog = driver.findElement(By.id("historyLog"));
        Assert.assertNotNull(historyLog.getText());
    }

    public void checkForErrorMessages() {
        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }

    public void closeBrowser() {
        driver.quit();
    }

    public static void main(String[] args) {
        ShipmentTrackingAutomation automation = new ShipmentTrackingAutomation();
        automation.navigateToShipmentTrackingPage();
        automation.enterShipmentID("12345");
        automation.selectLocation("LocationName");
        automation.clickOkButton();
        automation.checkCurrentStatus();
        automation.simulateStatusUpdate("To be delivered");
        automation.simulateStatusUpdate("Delivered");
        automation.verifyTimestamp();
        automation.refreshPage();
        automation.logOutAndLogBackIn();
        automation.checkNotificationSettings();
        automation.simulateNetworkIssue();
        automation.verifyShipmentHistoryLog();
        automation.checkForErrorMessages();
        automation.closeBrowser();
    }
}