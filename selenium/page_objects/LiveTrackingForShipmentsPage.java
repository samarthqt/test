import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LiveTrackingPage {
    WebDriver driver;

    @FindBy(id = "trackingField")
    WebElement trackingField;

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

    @FindBy(id = "trackingHistoryLog")
    WebElement trackingHistoryLog;

    @FindBy(id = "errorMessage")
    WebElement errorMessage;

    @FindBy(id = "updateLocationButton")
    WebElement updateLocationButton;

    @FindBy(id = "mobileTracking")
    WebElement mobileTracking;

    @FindBy(id = "systemRebootCheck")
    WebElement systemRebootCheck;

    @FindBy(id = "trackingAccuracy")
    WebElement trackingAccuracy;

    public LiveTrackingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterShipmentID(String shipmentID) {
        trackingField.sendKeys(shipmentID);
    }

    public String getCurrentLocation() {
        return currentLocation.getText();
    }

    public void simulateChangeInLocation() {
        updateLocationButton.click();
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

    public String getTrackingHistoryLog() {
        return trackingHistoryLog.getText();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public void updateLocationFromDifferentDevice() {
        updateLocationButton.click();
    }

    public void verifyMobileTracking() {
        mobileTracking.click();
    }

    public void checkAfterSystemReboot() {
        systemRebootCheck.click();
    }

    public void verifyTrackingAccuracy() {
        trackingAccuracy.click();
    }
}