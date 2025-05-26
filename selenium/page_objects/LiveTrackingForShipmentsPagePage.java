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

    @FindBy(id = "estimatedDeliveryTime")
    WebElement estimatedDeliveryTime;

    @FindBy(id = "refreshButton")
    WebElement refreshButton;

    @FindBy(id = "logoutButton")
    WebElement logoutButton;

    @FindBy(id = "loginButton")
    WebElement loginButton;

    @FindBy(id = "notificationSettings")
    WebElement notificationSettings;

    @FindBy(id = "networkIssueSimulateButton")
    WebElement networkIssueSimulateButton;

    @FindBy(id = "trackingHistoryLog")
    WebElement trackingHistoryLog;

    @FindBy(id = "errorMessages")
    WebElement errorMessages;

    @FindBy(id = "updateFromDifferentDeviceButton")
    WebElement updateFromDifferentDeviceButton;

    @FindBy(id = "mobileDeviceTracking")
    WebElement mobileDeviceTracking;

    @FindBy(id = "systemRebootCheckButton")
    WebElement systemRebootCheckButton;

    @FindBy(id = "trackingAccuracyCheckButton")
    WebElement trackingAccuracyCheckButton;

    public LiveTrackingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterShipmentId(String shipmentId) {
        shipmentIdField.sendKeys(shipmentId);
    }

    public String getCurrentLocation() {
        return currentLocation.getText();
    }

    public String getEstimatedDeliveryTime() {
        return estimatedDeliveryTime.getText();
    }

    public void refreshPage() {
        refreshButton.click();
    }

    public void logout() {
        logoutButton.click();
    }

    public void login() {
        loginButton.click();
    }

    public void checkNotificationSettings() {
        notificationSettings.click();
    }

    public void simulateNetworkIssue() {
        networkIssueSimulateButton.click();
    }

    public String getTrackingHistoryLog() {
        return trackingHistoryLog.getText();
    }

    public String getErrorMessages() {
        return errorMessages.getText();
    }

    public void updateLocationFromDifferentDevice() {
        updateFromDifferentDeviceButton.click();
    }

    public void verifyMobileDeviceTracking() {
        mobileDeviceTracking.click();
    }

    public void checkLiveTrackingAfterReboot() {
        systemRebootCheckButton.click();
    }

    public void verifyTrackingAccuracy() {
        trackingAccuracyCheckButton.click();
    }
}