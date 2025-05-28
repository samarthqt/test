import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


public class LiveTrackingShipmentTest {
    private WebDriver driver;

    public LiveTrackingShipmentTest() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void navigateToLiveTrackingPage() {
        driver.get("http://example.com/live-tracking");
        assert driver.getTitle().contains("Live Tracking");
    }

    public void enterShipmentID() {
        WebElement trackingField = driver.findElement(By.id("trackingField"));
        trackingField.sendKeys("54321");
        WebElement trackButton = driver.findElement(By.id("trackButton"));
        trackButton.click();
        assert driver.findElement(By.id("shipmentDetails")).getText().contains("54321");
    }

    public void checkCurrentLocation() {
        WebElement locationElement = driver.findElement(By.id("currentLocation"));
        assert locationElement.getText().equals("Warehouse");
    }

    public void simulateLocationChange(String location) {
        WebElement updateButton = driver.findElement(By.id("updateButton"));
        updateButton.click();
        WebElement locationElement = driver.findElement(By.id("currentLocation"));
        assert locationElement.getText().equals(location);
    }

    public void verifyEstimatedDeliveryTime() {
        WebElement deliveryTimeElement = driver.findElement(By.id("estimatedDeliveryTime"));
        String deliveryTime = deliveryTimeElement.getText();
        assert !deliveryTime.isEmpty();
    }

    public void refreshPage() {
        driver.navigate().refresh();
        WebElement locationElement = driver.findElement(By.id("currentLocation"));
        assert locationElement.getText().equals("Warehouse");
    }

    public void logoutAndLogin() {
        WebElement logoutButton = driver.findElement(By.id("logoutButton"));
        logoutButton.click();
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
        WebElement locationElement = driver.findElement(By.id("currentLocation"));
        assert locationElement.getText().equals("Warehouse");
    }

    public void checkNotificationSettings() {
        WebElement notificationSettings = driver.findElement(By.id("notificationSettings"));
        assert notificationSettings.getText().contains("Live Tracking Enabled");
    }

    public void simulateNetworkIssue() {
        WebElement updateButton = driver.findElement(By.id("updateButton"));
        updateButton.click();
        WebElement locationElement = driver.findElement(By.id("currentLocation"));
        assert locationElement.getText().equals("Warehouse");
    }

    public void verifyTrackingHistoryLog() {
        WebElement historyLog = driver.findElement(By.id("historyLog"));
        assert historyLog.getText().contains("54321");
    }

    public void checkForErrorMessages() {
        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        assert errorMessage.getText().isEmpty();
    }

    public void updateLocationFromDifferentDevice() {
        WebElement updateButton = driver.findElement(By.id("updateButton"));
        updateButton.click();
        WebElement locationElement = driver.findElement(By.id("currentLocation"));
        assert locationElement.getText().equals("Warehouse");
    }

    public void verifyMobileDeviceTracking() {
        WebElement mobileLocationElement = driver.findElement(By.id("mobileLocation"));
        assert mobileLocationElement.getText().equals("Warehouse");
    }

    public void checkTrackingAfterReboot() {
        driver.quit();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://example.com/live-tracking");
        WebElement locationElement = driver.findElement(By.id("currentLocation"));
        assert locationElement.getText().equals("Warehouse");
    }

    public void verifyTrackingAccuracy() {
        WebElement accuracyElement = driver.findElement(By.id("trackingAccuracy"));
        assert accuracyElement.getText().equals("High");
    }

    public static void main(String[] args) {
        LiveTrackingShipmentTest test = new LiveTrackingShipmentTest();
        test.navigateToLiveTrackingPage();
        test.enterShipmentID();
        test.checkCurrentLocation();
        test.simulateLocationChange("In Transit");
        test.simulateLocationChange("Warehouse");
        test.verifyEstimatedDeliveryTime();
        test.refreshPage();
        test.logoutAndLogin();
        test.checkNotificationSettings();
        test.simulateNetworkIssue();
        test.verifyTrackingHistoryLog();
        test.checkForErrorMessages();
        test.updateLocationFromDifferentDevice();
        test.verifyMobileDeviceTracking();
        test.checkTrackingAfterReboot();
        test.verifyTrackingAccuracy();
        test.driver.quit();
    }
}