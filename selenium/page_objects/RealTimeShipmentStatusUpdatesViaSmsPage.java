import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShipmentTrackingPage {

    WebDriver driver;

    @FindBy(id = "trackingField")
    private WebElement trackingField;

    @FindBy(id = "currentStatus")
    private WebElement currentStatus;

    @FindBy(id = "statusUpdateField")
    private WebElement statusUpdateField;

    @FindBy(id = "timestamp")
    private WebElement timestamp;

    @FindBy(id = "refreshButton")
    private WebElement refreshButton;

    @FindBy(id = "logoutButton")
    private WebElement logoutButton;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    @FindBy(id = "notificationSettings")
    private WebElement notificationSettings;

    @FindBy(id = "networkIssueSimulator")
    private WebElement networkIssueSimulator;

    @FindBy(id = "shipmentHistoryLog")
    private WebElement shipmentHistoryLog;

    @FindBy(id = "errorMessages")
    private WebElement errorMessages;

    @FindBy(id = "differentDeviceUpdate")
    private WebElement differentDeviceUpdate;

    @FindBy(id = "smsVerification")
    private WebElement smsVerification;

    @FindBy(id = "systemRebootCheck")
    private WebElement systemRebootCheck;

    public ShipmentTrackingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterShipmentID(String shipmentID) {
        trackingField.sendKeys(shipmentID);
    }

    public String getCurrentStatus() {
        return currentStatus.getText();
    }

    public void simulateStatusUpdate(String status) {
        statusUpdateField.sendKeys(status);
    }

    public String getTimestamp() {
        return timestamp.getText();
    }

    public void refreshPage() {
        refreshButton.click();
    }

    public void logoutAndLogin() {
        logoutButton.click();
        loginButton.click();
    }

    public String checkNotificationSettings() {
        return notificationSettings.getText();
    }

    public void simulateNetworkIssue() {
        networkIssueSimulator.click();
    }

    public String getShipmentHistoryLog() {
        return shipmentHistoryLog.getText();
    }

    public String checkErrorMessages() {
        return errorMessages.getText();
    }

    public void updateStatusFromDifferentDevice() {
        differentDeviceUpdate.click();
    }

    public String verifyShipmentStatusViaSMS() {
        return smsVerification.getText();
    }

    public String checkStatusAfterSystemReboot() {
        return systemRebootCheck.getText();
    }
}