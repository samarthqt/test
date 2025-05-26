public class LiveTrackingPage {
    private WebDriver driver;

    // WebElements
    @FindBy(id = "trackingField")
    private WebElement trackingField;

    @FindBy(id = "currentLocation")
    private WebElement currentLocation;

    @FindBy(id = "simulateChangeLocation")
    private WebElement simulateChangeLocationButton;

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

    @FindBy(id = "simulateNetworkIssue")
    private WebElement simulateNetworkIssueButton;

    @FindBy(id = "trackingHistoryLog")
    private WebElement trackingHistoryLog;

    @FindBy(id = "errorMessage")
    private WebElement errorMessage;

    @FindBy(id = "updateFromDifferentDevice")
    private WebElement updateFromDifferentDeviceButton;

    @FindBy(id = "mobileDeviceTracking")
    private WebElement mobileDeviceTracking;

    @FindBy(id = "systemRebootCheck")
    private WebElement systemRebootCheck;

    @FindBy(id = "trackingAccuracy")
    private WebElement trackingAccuracy;

    // Constructor
    public LiveTrackingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Methods
    public void navigateToLiveTrackingPage(String url) {
        driver.get(url);
    }

    public void enterShipmentId(String shipmentId) {
        trackingField.clear();
        trackingField.sendKeys(shipmentId);
    }

    public String getCurrentLocation() {
        return currentLocation.getText();
    }

    public void simulateChangeInLocation() {
        simulateChangeLocationButton.click();
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

    public boolean checkNotificationSettings() {
        return notificationSettings.isDisplayed();
    }

    public void simulateNetworkIssue() {
        simulateNetworkIssueButton.click();
    }

    public String getTrackingHistoryLog() {
        return trackingHistoryLog.getText();
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }

    public void updateLocationFromDifferentDevice() {
        updateFromDifferentDeviceButton.click();
    }

    public boolean verifyMobileDeviceTracking() {
        return mobileDeviceTracking.isDisplayed();
    }

    public void checkLiveTrackingAfterSystemReboot() {
        systemRebootCheck.click();
    }

    public boolean verifyTrackingAccuracy() {
        return trackingAccuracy.isDisplayed();
    }
}