public class LiveTrackingPage {

    private WebDriver driver;

    // WebElements
    @FindBy(id = "trackingField")
    private WebElement trackingField;

    @FindBy(id = "currentLocation")
    private WebElement currentLocation;

    @FindBy(id = "estimatedDeliveryTime")
    private WebElement estimatedDeliveryTime;

    @FindBy(id = "refreshButton")
    private WebElement refreshButton;

    @FindBy(id = "logoutButton")
    private WebElement logoutButton;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    @FindBy(id = "notificationSettings")
    private WebElement notificationSettings;

    @FindBy(id = "networkIssueSimulation")
    private WebElement networkIssueSimulation;

    @FindBy(id = "trackingHistoryLog")
    private WebElement trackingHistoryLog;

    @FindBy(id = "errorMessage")
    private WebElement errorMessage;

    @FindBy(id = "updateLocationDifferentDevice")
    private WebElement updateLocationDifferentDevice;

    @FindBy(id = "liveTrackingMobile")
    private WebElement liveTrackingMobile;

    @FindBy(id = "systemRebootSimulation")
    private WebElement systemRebootSimulation;

    @FindBy(id = "trackingAccuracy")
    private WebElement trackingAccuracy;

    // Constructor
    public LiveTrackingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Methods
    public void enterShipmentId(String shipmentId) {
        trackingField.clear();
        trackingField.sendKeys(shipmentId);
    }

    public String getCurrentLocation() {
        return currentLocation.getText();
    }

    public void simulateChangeInShipmentLocation() {
        // Code to simulate change
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
        networkIssueSimulation.click();
    }

    public String getTrackingHistoryLog() {
        return trackingHistoryLog.getText();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public void updateLocationFromDifferentDevice() {
        updateLocationDifferentDevice.click();
    }

    public void verifyLiveTrackingOnMobile() {
        liveTrackingMobile.click();
    }

    public void simulateSystemReboot() {
        systemRebootSimulation.click();
    }

    public String verifyTrackingAccuracy() {
        return trackingAccuracy.getText();
    }
}