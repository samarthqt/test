import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShipmentTrackingPage {

    WebDriver driver;

    @FindBy(id = "trackingField")
    WebElement trackingField;

    @FindBy(id = "currentStatus")
    WebElement currentStatus;

    @FindBy(id = "updateStatusButton")
    WebElement updateStatusButton;

    @FindBy(id = "statusTimestamp")
    WebElement statusTimestamp;

    @FindBy(id = "refreshButton")
    WebElement refreshButton;

    @FindBy(id = "logoutButton")
    WebElement logoutButton;

    @FindBy(id = "loginButton")
    WebElement loginButton;

    @FindBy(id = "notificationSettings")
    WebElement notificationSettings;

    @FindBy(id = "networkIssueButton")
    WebElement networkIssueButton;

    @FindBy(id = "shipmentHistoryLog")
    WebElement shipmentHistoryLog;

    @FindBy(id = "errorMessage")
    WebElement errorMessage;

    @FindBy(id = "differentDeviceButton")
    WebElement differentDeviceButton;

    @FindBy(id = "smsVerificationButton")
    WebElement smsVerificationButton;

    @FindBy(id = "systemRebootCheckButton")
    WebElement systemRebootCheckButton;

    public ShipmentTrackingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToShipmentTrackingPage(String url) {
        driver.get(url);
    }

    public void enterShipmentID(String shipmentID) {
        trackingField.sendKeys(shipmentID);
    }

    public String getCurrentStatus() {
        return currentStatus.getText();
    }

    public void simulateStatusUpdate(String newStatus) {
        updateStatusButton.click();
    }

    public String getStatusTimestamp() {
        return statusTimestamp.getText();
    }

    public void refreshPage() {
        refreshButton.click();
    }

    public void logoutAndLogin() {
        logoutButton.click();
        loginButton.click();
    }

    public void checkNotificationSettings() {
        notificationSettings.click();
    }

    public void simulateNetworkIssue() {
        networkIssueButton.click();
    }

    public String getShipmentHistoryLog() {
        return shipmentHistoryLog.getText();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public void attemptUpdateFromDifferentDevice() {
        differentDeviceButton.click();
    }

    public void verifyShipmentStatusViaSMS() {
        smsVerificationButton.click();
    }

    public void checkStatusAfterSystemReboot() {
        systemRebootCheckButton.click();
    }
}