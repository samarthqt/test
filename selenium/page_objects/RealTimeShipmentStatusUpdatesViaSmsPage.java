import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShipmentTrackingPage {

    WebDriver driver;

    @FindBy(id = "trackingField")
    private WebElement trackingField;

    @FindBy(id = "locationField")
    private WebElement locationField;

    @FindBy(id = "okButton")
    private WebElement okButton;

    @FindBy(id = "currentStatus")
    private WebElement currentStatus;

    @FindBy(id = "statusUpdate")
    private WebElement statusUpdate;

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

    @FindBy(id = "networkIssueButton")
    private WebElement networkIssueButton;

    @FindBy(id = "shipmentHistoryLog")
    private WebElement shipmentHistoryLog;

    @FindBy(id = "errorMessages")
    private WebElement errorMessages;

    public ShipmentTrackingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterShipmentID(String shipmentID) {
        trackingField.sendKeys(shipmentID);
    }

    public void selectLocation(String location) {
        locationField.sendKeys(location);
    }

    public void clickOkButton() {
        okButton.click();
    }

    public String getCurrentStatus() {
        return currentStatus.getText();
    }

    public void simulateStatusUpdate(String status) {
        statusUpdate.sendKeys(status);
    }

    public String getTimestamp() {
        return timestamp.getText();
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
        networkIssueButton.click();
    }

    public String getShipmentHistoryLog() {
        return shipmentHistoryLog.getText();
    }

    public String getErrorMessages() {
        return errorMessages.getText();
    }
}