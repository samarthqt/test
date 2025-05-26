public class ShipmentTrackingPage {

    private WebDriver driver;

    // Locators
    private By trackingField = By.id("trackingField");
    private By currentStatus = By.id("currentStatus");
    private By updateStatusButton = By.id("updateStatusButton");
    private By timestamp = By.id("timestamp");
    private By refreshButton = By.id("refreshButton");
    private By logoutButton = By.id("logoutButton");
    private By loginButton = By.id("loginButton");
    private By notificationSettings = By.id("notificationSettings");
    private By errorMessages = By.id("errorMessages");
    private By shipmentHistoryLog = By.id("shipmentHistoryLog");
    private By smsVerificationButton = By.id("smsVerificationButton");
    private By systemRebootCheck = By.id("systemRebootCheck");

    public ShipmentTrackingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToShipmentTrackingPage(String url) {
        driver.get(url);
    }

    public void enterShipmentID(String shipmentID) {
        driver.findElement(trackingField).sendKeys(shipmentID);
    }

    public String getCurrentStatus() {
        return driver.findElement(currentStatus).getText();
    }

    public void simulateStatusUpdate(String status) {
        driver.findElement(updateStatusButton).click();
        driver.findElement(By.id(status)).click();
    }

    public String getTimestampOfLatestStatusUpdate() {
        return driver.findElement(timestamp).getText();
    }

    public void refreshPage() {
        driver.findElement(refreshButton).click();
    }

    public void logoutAndLogin(String username, String password) {
        driver.findElement(logoutButton).click();
        driver.findElement(loginButton).click();
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("submitLogin")).click();
    }

    public boolean checkNotificationSettings() {
        return driver.findElement(notificationSettings).isDisplayed();
    }

    public void simulateNetworkIssueAndAttemptUpdate(String status) {
        driver.findElement(updateStatusButton).click();
        // Simulate network issue here.
        driver.findElement(By.id(status)).click();
    }

    public String verifyShipmentHistoryLog() {
        return driver.findElement(shipmentHistoryLog).getText();
    }

    public boolean checkForErrorMessages() {
        return driver.findElement(errorMessages).isDisplayed();
    }

    public void attemptStatusUpdateFromDifferentDevice(String status) {
        driver.findElement(updateStatusButton).click();
        driver.findElement(By.id(status)).click();
    }

    public boolean verifyShipmentStatusUsingSMS() {
        driver.findElement(smsVerificationButton).click();
        return driver.findElement(By.id("smsStatus")).isDisplayed();
    }

    public boolean checkShipmentStatusAfterSystemReboot() {
        driver.findElement(systemRebootCheck).click();
        return driver.findElement(By.id("rebootStatus")).isDisplayed();
    }
}