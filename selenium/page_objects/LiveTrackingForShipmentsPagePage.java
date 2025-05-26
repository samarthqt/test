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

    @FindBy(id = "networkIssueSimulate")
    private WebElement networkIssueSimulate;

    @FindBy(id = "trackingHistoryLog")
    private WebElement trackingHistoryLog;

    @FindBy(id = "errorMessages")
    private WebElement errorMessages;

    @FindBy(id = "updateLocationDifferentDevice")
    private WebElement updateLocationDifferentDevice;

    @FindBy(id = "mobileTracking")
    private WebElement mobileTracking;

    @FindBy(id = "systemReboot")
    private WebElement systemReboot;

    @FindBy(id = "trackingAccuracy")
    private WebElement trackingAccuracy;

    public LiveTrackingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToLiveTrackingPage() {
        driver.get("http://example.com/live-tracking");
    }

    public void enterShipmentID(String shipmentID) {
        trackingField.clear();
        trackingField.sendKeys(shipmentID);
    }

    public String getCurrentLocation() {
        return currentLocation.getText();
    }

    public void simulateChangeInLocation() {
        // Simulate change in location logic
    }

    public String getEstimatedDeliveryTime() {
        return estimatedDeliveryTime.getText();
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
        networkIssueSimulate.click();
    }

    public String getTrackingHistoryLog() {
        return trackingHistoryLog.getText();
    }

    public String getErrorMessages() {
        return errorMessages.getText();
    }

    public void updateLocationFromDifferentDevice() {
        updateLocationDifferentDevice.click();
    }

    public void verifyLiveTrackingOnMobile() {
        mobileTracking.click();
    }

    public void checkTrackingAfterSystemReboot() {
        systemReboot.click();
    }

    public void verifyTrackingAccuracy() {
        trackingAccuracy.click();
    }
}