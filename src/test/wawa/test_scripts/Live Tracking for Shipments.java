import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LiveTrackingAutomation {

    private WebDriver driver;

    public LiveTrackingAutomation() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    public void navigateToLiveTrackingPage() {
        driver.get("http://example.com/live-tracking");
    }

    public void enterShipmentID(String shipmentID) {
        WebElement trackingField = driver.findElement(By.id("trackingField"));
        trackingField.sendKeys(shipmentID);
    }

    public void checkCurrentLocation() {
        WebElement locationElement = driver.findElement(By.id("currentLocation"));
        String location = locationElement.getText();
        Assert.assertNotNull(location, "Current location is not displayed.");
    }

    public void simulateChangeInShipmentLocation() {
        WebElement changeLocationButton = driver.findElement(By.id("changeLocation"));
        changeLocationButton.click();
    }

    public void verifyEstimatedDeliveryTime() {
        WebElement deliveryTimeElement = driver.findElement(By.id("estimatedDeliveryTime"));
        String deliveryTime = deliveryTimeElement.getText();
        Assert.assertNotNull(deliveryTime, "Estimated delivery time is not displayed.");
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void logOutAndLogBackIn() {
        WebElement logoutButton = driver.findElement(By.id("logout"));
        logoutButton.click();
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
    }

    public void checkNotificationSettings() {
        WebElement notificationSettings = driver.findElement(By.id("notificationSettings"));
        Assert.assertTrue(notificationSettings.isDisplayed(), "Notification settings are not visible.");
    }

    public void simulateNetworkIssue() {
        WebElement networkIssueButton = driver.findElement(By.id("simulateNetworkIssue"));
        networkIssueButton.click();
    }

    public void verifyTrackingHistoryLog() {
        WebElement historyLog = driver.findElement(By.id("trackingHistoryLog"));
        Assert.assertTrue(historyLog.isDisplayed(), "Tracking history log is not visible.");
    }

    public void checkErrorMessages() {
        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed.");
    }

    public void updateLocationFromDifferentDevice() {
        WebElement updateLocationButton = driver.findElement(By.id("updateLocationDifferentDevice"));
        updateLocationButton.click();
    }

    public void verifyLiveTrackingOnMobile() {
        WebElement mobileTracking = driver.findElement(By.id("mobileLiveTracking"));
        Assert.assertTrue(mobileTracking.isDisplayed(), "Live tracking on mobile is not visible.");
    }

    public void checkLiveTrackingAfterReboot() {
        WebElement rebootTracking = driver.findElement(By.id("rebootLiveTracking"));
        Assert.assertTrue(rebootTracking.isDisplayed(), "Live tracking after reboot is not visible.");
    }

    public void verifyTrackingAccuracy() {
        WebElement trackingAccuracy = driver.findElement(By.id("trackingAccuracy"));
        Assert.assertTrue(trackingAccuracy.isDisplayed(), "Tracking accuracy is not verified.");
    }

    public void closeBrowser() {
        driver.quit();
    }

    public static void main(String[] args) {
        LiveTrackingAutomation automation = new LiveTrackingAutomation();
        automation.navigateToLiveTrackingPage();
        automation.enterShipmentID("54321");
        automation.checkCurrentLocation();
        automation.simulateChangeInShipmentLocation();
        automation.verifyEstimatedDeliveryTime();
        automation.refreshPage();
        automation.logOutAndLogBackIn();
        automation.checkNotificationSettings();
        automation.simulateNetworkIssue();
        automation.verifyTrackingHistoryLog();
        automation.checkErrorMessages();
        automation.updateLocationFromDifferentDevice();
        automation.verifyLiveTrackingOnMobile();
        automation.checkLiveTrackingAfterReboot();
        automation.verifyTrackingAccuracy();
        automation.closeBrowser();
    }
}