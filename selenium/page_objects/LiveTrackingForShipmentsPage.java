import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LiveTrackingPage {

    WebDriver driver;

    @FindBy(id = "shipmentIdField")
    WebElement shipmentIdField;

    @FindBy(id = "currentLocation")
    WebElement currentLocation;

    @FindBy(id = "simulateLocationChange")
    WebElement simulateLocationChangeButton;

    @FindBy(id = "estimatedDeliveryTime")
    WebElement estimatedDeliveryTime;

    @FindBy(id = "refreshPage")
    WebElement refreshPageButton;

    @FindBy(id = "logoutButton")
    WebElement logoutButton;

    @FindBy(id = "loginButton")
    WebElement loginButton;

    @FindBy(id = "notificationSettings")
    WebElement notificationSettings;

    @FindBy(id = "simulateNetworkIssue")
    WebElement simulateNetworkIssueButton;

    @FindBy(id = "trackingHistoryLog")
    WebElement trackingHistoryLog;

    @FindBy(id = "errorMessages")
    WebElement errorMessages;

    @FindBy(id = "updateLocationDifferentDevice")
    WebElement updateLocationDifferentDeviceButton;

    @FindBy(id = "liveTrackingMobileDevice")
    WebElement liveTrackingMobileDevice;

    @FindBy(id = "systemReboot")
    WebElement systemRebootButton;

    @FindBy(id = "verifyTrackingAccuracy")
    WebElement verifyTrackingAccuracyButton;

    public LiveTrackingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToLiveTrackingPage() {
        driver.get("http://example.com/live-tracking");
    }

    public void enterShipmentID(String shipmentId) {
        shipmentIdField.sendKeys(shipmentId);
    }

    public String checkCurrentLocation() {
        return currentLocation.getText();
    }

    public void simulateChangeInShipmentLocation() {
        simulateLocationChangeButton.click();
    }

    public String verifyEstimatedDeliveryTime() {
        return estimatedDeliveryTime.getText();
    }

    public void refreshPage() {
        refreshPageButton.click();
    }

    public void logoutAndLogin() {
        logoutButton.click();
        loginButton.click();
    }

    public void checkNotificationSettings() {
        notificationSettings.click();
    }

    public void simulateNetworkIssue() {
        simulateNetworkIssueButton.click();
    }

    public String verifyTrackingHistoryLog() {
        return trackingHistoryLog.getText();
    }

    public String checkErrorMessages() {
        return errorMessages.getText();
    }

    public void attemptUpdateLocationFromDifferentDevice() {
        updateLocationDifferentDeviceButton.click();
    }

    public void verifyLiveTrackingOnMobileDevice() {
        liveTrackingMobileDevice.click();
    }

    public void checkLiveTrackingAfterSystemReboot() {
        systemRebootButton.click();
    }

    public void verifyTrackingAccuracy() {
        verifyTrackingAccuracyButton.click();
    }
}