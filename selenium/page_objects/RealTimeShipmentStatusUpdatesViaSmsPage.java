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

    @FindBy(id = "updateStatusButton")
    private WebElement updateStatusButton;

    @FindBy(id = "statusTimestamp")
    private WebElement statusTimestamp;

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

    @FindBy(id = "smsVerification")
    private WebElement smsVerification;

    @FindBy(id = "rebootCheck")
    private WebElement rebootCheck;

    public ShipmentTrackingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterShipmentID(String shipmentID) {
        trackingField.clear();
        trackingField.sendKeys(shipmentID);
    }

    public String getCurrentStatus() {
        return currentStatus.getText();
    }

    public void simulateStatusUpdate(String status) {
        updateStatusButton.click();
        // Additional logic to simulate status update
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
        networkIssueSimulator.click();
    }

    public String getShipmentHistoryLog() {
        return shipmentHistoryLog.getText();
    }

    public String getErrorMessages() {
        return errorMessages.getText();
    }

    public void verifyStatusUsingSMS() {
        smsVerification.click();
    }

    public void checkStatusAfterReboot() {
        rebootCheck.click();
    }
}