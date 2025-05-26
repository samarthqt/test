public class LiveTrackingPage {

    private WebDriver driver;

    @FindBy(id = "trackingField")
    private WebElement trackingField;

    @FindBy(id = "currentLocation")
    private WebElement currentLocation;

    @FindBy(id = "simulateLocationChange")
    private WebElement simulateLocationChangeButton;

    @FindBy(id = "estimatedDeliveryTime")
    private WebElement estimatedDeliveryTime;

    @FindBy(id = "refreshPage")
    private WebElement refreshPageButton;

    @FindBy(id = "logout")
    private WebElement logoutButton;

    @FindBy(id = "login")
    private WebElement loginButton;

    @FindBy(id = "notificationSettings")
    private WebElement notificationSettings;

    @FindBy(id = "simulateNetworkIssue")
    private WebElement simulateNetworkIssueButton;

    @FindBy(id = "trackingHistoryLog")
    private WebElement trackingHistoryLog;

    @FindBy(id = "errorMessages")
    private WebElement errorMessages;

    @FindBy(id = "updateLocationDifferentDevice")
    private WebElement updateLocationDifferentDeviceButton;

    @FindBy(id = "liveTrackingMobile")
    private WebElement liveTrackingMobile;

    @FindBy(id = "systemReboot")
    private WebElement systemRebootButton;

    @FindBy(id = "trackingAccuracy")
    private WebElement trackingAccuracy;

    public LiveTrackingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToLiveTrackingPage(String url) {
        driver.get(url);
    }

    public void enterShipmentID(String shipmentID) {
        trackingField.clear();
        trackingField.sendKeys(shipmentID);
    }

    public String getCurrentLocation() {
        return currentLocation.getText();
    }

    public void simulateChangeInShipmentLocation() {
        simulateLocationChangeButton.click();
    }

    public String getEstimatedDeliveryTime() {
        return estimatedDeliveryTime.getText();
    }

    public void refreshPage() {
        refreshPageButton.click();
    }

    public void logoutAndLogin() {
        logoutButton.click();
        loginButton.click();
    }

    public String checkNotificationSettings() {
        return notificationSettings.getText();
    }

    public void simulateNetworkIssue() {
        simulateNetworkIssueButton.click();
    }

    public String getTrackingHistoryLog() {
        return trackingHistoryLog.getText();
    }

    public String checkErrorMessages() {
        return errorMessages.getText();
    }

    public void updateLocationFromDifferentDevice() {
        updateLocationDifferentDeviceButton.click();
    }

    public String verifyLiveTrackingOnMobileDevice() {
        return liveTrackingMobile.getText();
    }

    public void checkLiveTrackingAfterSystemReboot() {
        systemRebootButton.click();
    }

    public String verifyTrackingAccuracy() {
        return trackingAccuracy.getText();
    }
}