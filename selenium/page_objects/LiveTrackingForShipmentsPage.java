import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LiveTrackingPage {

    WebDriver driver;

    @FindBy(id = "trackingField")
    private WebElement trackingField;

    @FindBy(id = "currentLocation")
    private WebElement currentLocation;

    @FindBy(id = "estimatedDeliveryTime")
    private WebElement estimatedDeliveryTime;

    @FindBy(id = "refreshButton")
    private WebElement refreshButton;

    @FindBy(id = "logOutButton")
    private WebElement logOutButton;

    @FindBy(id = "logInButton")
    private WebElement logInButton;

    @FindBy(id = "notificationSettings")
    private WebElement notificationSettings;

    @FindBy(id = "networkIssueSimulation")
    private WebElement networkIssueSimulation;

    @FindBy(id = "trackingHistoryLog")
    private WebElement trackingHistoryLog;

    @FindBy(id = "errorMessages")
    private WebElement errorMessages;

    @FindBy(id = "updateFromDifferentDevice")
    private WebElement updateFromDifferentDevice;

    @FindBy(id = "mobileDeviceTracking")
    private WebElement mobileDeviceTracking;

    @FindBy(id = "systemRebootCheck")
    private WebElement systemRebootCheck;

    @FindBy(id = "trackingAccuracy")
    private WebElement trackingAccuracy;

    public LiveTrackingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterShipmentID(String shipmentID) {
        trackingField.clear();
        trackingField.sendKeys(shipmentID);
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

    public void logOut() {
        logOutButton.click();
    }

    public void logIn() {
        logInButton.click();
    }

    public void checkNotificationSettings() {
        notificationSettings.click();
    }

    public void simulateNetworkIssue() {
        networkIssueSimulation.click();
    }

    public String getTrackingHistoryLog() {
        return trackingHistoryLog.getText();
    }

    public String getErrorMessages() {
        return errorMessages.getText();
    }

    public void updateFromDifferentDevice() {
        updateFromDifferentDevice.click();
    }

    public void verifyMobileDeviceTracking() {
        mobileDeviceTracking.click();
    }

    public void checkSystemRebootTracking() {
        systemRebootCheck.click();
    }

    public String verifyTrackingAccuracy() {
        return trackingAccuracy.getText();
    }
}