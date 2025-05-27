import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShipmentTrackingPage {

    WebDriver driver;

    @FindBy(id = "shipmentIdField")
    WebElement shipmentIdField;

    @FindBy(id = "locationField")
    WebElement locationField;

    @FindBy(id = "okButton")
    WebElement okButton;

    @FindBy(id = "currentStatus")
    WebElement currentStatus;

    @FindBy(id = "statusUpdateButton")
    WebElement statusUpdateButton;

    @FindBy(id = "timestamp")
    WebElement timestamp;

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

    public ShipmentTrackingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterShipmentId(String shipmentId) {
        shipmentIdField.sendKeys(shipmentId);
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
        statusUpdateButton.click();
        // Assume there's a way to input the status
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

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}