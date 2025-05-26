public class LiveTrackingPage {

    private WebDriver driver;

    @FindBy(id = "shipmentIdField")
    private WebElement shipmentIdField;

    @FindBy(id = "currentLocation")
    private WebElement currentLocation;

    @FindBy(id = "estimatedDeliveryTime")
    private WebElement estimatedDeliveryTime;

    @FindBy(id = "refreshButton")
    private WebElement refreshButton;

    @FindBy(id = "logoutButton")
    private WebElement logoutButton;

    @FindBy(id = "notificationSettings")
    private WebElement notificationSettings;

    @FindBy(id = "trackingHistoryLog")
    private WebElement trackingHistoryLog;

    @FindBy(id = "errorMessages")
    private WebElement errorMessages;

    @FindBy(id = "updateLocationButton")
    private WebElement updateLocationButton;

    @FindBy(id = "mobileTracking")
    private WebElement mobileTracking;

    @FindBy(id = "systemRebootCheck")
    private WebElement systemRebootCheck;

    @FindBy(id = "trackingAccuracy")
    private WebElement trackingAccuracy;

    public LiveTrackingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToLiveTrackingPage() {
        driver.get("https://example.com/live-tracking");
    }

    public void enterShipmentId(String shipmentId) {
        shipmentIdField.sendKeys(shipmentId);
    }

    public String getCurrentLocation() {
        return currentLocation.getText();
    }

    public void simulateChangeInShipmentLocation() {
        updateLocationButton.click();
    }

    public String getEstimatedDeliveryTime() {
        return estimatedDeliveryTime.getText();
    }

    public void refreshPage() {
        refreshButton.click();
    }

    public void logoutAndLogin() {
        logoutButton.click();
        // Logic to log back in
    }

    public void checkNotificationSettings() {
        notificationSettings.click();
    }

    public void simulateNetworkIssueAndUpdateLocation() {
        // Logic to simulate network issue
        updateLocationButton.click();
    }

    public String getTrackingHistoryLog() {
        return trackingHistoryLog.getText();
    }

    public String getErrorMessages() {
        return errorMessages.getText();
    }

    public void updateLocationFromDifferentDevice() {
        // Logic to update location from a different device
    }

    public void verifyLiveTrackingOnMobile() {
        mobileTracking.click();
    }

    public void checkLiveTrackingAfterSystemReboot() {
        systemRebootCheck.click();
    }

    public String verifyTrackingAccuracy() {
        return trackingAccuracy.getText();
    }
}