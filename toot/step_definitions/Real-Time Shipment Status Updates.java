import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class ShipmentStatusStepDefinitions {

    WebDriver driver;
    WebDriverWait wait;

    @Given("the user is logged into the system")
    public void userLoggedIn() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://example.com/login");
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        username.sendKeys("user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("pass");
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
    }

    @When("the user navigates to the shipment tracking page")
    public void navigateToShipmentTracking() {
        driver.get("http://example.com/shipment-tracking");
    }

    @Then("the shipment tracking page is displayed")
    public void verifyShipmentTrackingPage() {
        WebElement trackingPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tracking-page")));
        Assert.assertTrue(trackingPage.isDisplayed());
    }

    @And("shipment data is available in the system")
    public void verifyShipmentDataAvailability() {
        WebElement shipmentData = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shipment-data")));
        Assert.assertTrue(shipmentData.isDisplayed());
    }

    @Given("the user is on the shipment tracking page")
    public void userOnShipmentTrackingPage() {
        navigateToShipmentTracking();
        verifyShipmentTrackingPage();
    }

    @When("the user enters the Shipment ID {string} in the tracking field")
    public void enterShipmentID(String shipmentID) {
        WebElement trackingField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tracking-field")));
        trackingField.sendKeys(shipmentID);
        WebElement searchButton = driver.findElement(By.id("search-button"));
        searchButton.click();
    }

    @Then("shipment details for ID {string} are displayed")
    public void verifyShipmentDetails(String shipmentID) {
        WebElement shipmentDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shipment-details")));
        Assert.assertTrue(shipmentDetails.getText().contains(shipmentID));
    }

    @Given("shipment details for ID {string} are displayed")
    public void shipmentDetailsDisplayed(String shipmentID) {
        enterShipmentID(shipmentID);
        verifyShipmentDetails(shipmentID);
    }

    @When("the user checks the current status of the shipment")
    public void checkCurrentStatus() {
        WebElement currentStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("current-status")));
        Assert.assertTrue(currentStatus.isDisplayed());
    }

    @Then("the current status is displayed as {string}")
    public void verifyCurrentStatus(String status) {
        WebElement currentStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("current-status")));
        Assert.assertEquals(status, currentStatus.getText());
    }

    @Given("the current status is {string}")
    public void currentStatusIs(String status) {
        verifyCurrentStatus(status);
    }

    @When("the status is updated to {string}")
    public void updateStatus(String newStatus) {
        WebElement updateButton = driver.findElement(By.id("update-status"));
        updateButton.click();
        WebElement statusField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("status-field")));
        statusField.sendKeys(newStatus);
        WebElement confirmButton = driver.findElement(By.id("confirm-update"));
        confirmButton.click();
    }

    @Then("the status updates to {string} in real-time")
    public void verifyStatusUpdate(String newStatus) {
        WebElement updatedStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("updated-status")));
        Assert.assertEquals(newStatus, updatedStatus.getText());
    }

    @Given("the status is {string}")
    public void statusIs(String status) {
        verifyCurrentStatus(status);
    }

    @When("the user verifies the timestamp of the latest status update")
    public void verifyTimestamp() {
        WebElement timestamp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("timestamp")));
        Assert.assertTrue(timestamp.isDisplayed());
    }

    @Then("the timestamp matches the current time")
    public void verifyTimestampMatches() {
        WebElement timestamp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("timestamp")));
        String currentTime = java.time.LocalDateTime.now().toString();
        Assert.assertTrue(timestamp.getText().contains(currentTime));
    }

    @When("the user refreshes the page")
    public void refreshPage() {
        driver.navigate().refresh();
    }

    @Then("the status remains {string} with the same timestamp")
    public void verifyStatusAfterRefresh(String status) {
        verifyCurrentStatus(status);
        verifyTimestampMatches();
    }

    @When("the user logs out and logs back in")
    public void logoutAndLogin() {
        WebElement logoutButton = driver.findElement(By.id("logout"));
        logoutButton.click();
        userLoggedIn();
    }

    @Then("the shipment status remains {string}")
    public void verifyStatusAfterLogin(String status) {
        verifyCurrentStatus(status);
    }

    @When("the user checks the notification settings for shipment updates")
    public void checkNotificationSettings() {
        WebElement notificationSettings = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("notification-settings")));
        Assert.assertTrue(notificationSettings.isDisplayed());
    }

    @Then("notifications are enabled for real-time updates")
    public void verifyNotificationsEnabled() {
        WebElement notificationsEnabled = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("notifications-enabled")));
        Assert.assertTrue(notificationsEnabled.isDisplayed());
    }

    @Given("there is a network issue")
    public void networkIssue() {
        // Simulate network issue
    }

    @When("the user attempts to update the status")
    public void attemptStatusUpdate() {
        updateStatus("Out for Delivery");
    }

    @Then("the system handles the issue gracefully and retries the update")
    public void verifyRetryOnNetworkIssue() {
        WebElement retryMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retry-message")));
        Assert.assertTrue(retryMessage.isDisplayed());
    }

    @Given("the status has been updated multiple times")
    public void statusUpdatedMultipleTimes() {
        updateStatus("In Transit");
        updateStatus("Out for Delivery");
        updateStatus("Delivered");
    }

    @When("the user verifies the shipment history log")
    public void verifyShipmentHistoryLog() {
        WebElement historyLog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("history-log")));
        Assert.assertTrue(historyLog.isDisplayed());
    }

    @Then("the log contains all status updates with timestamps")
    public void verifyLogContainsUpdates() {
        WebElement historyLog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("history-log")));
        Assert.assertTrue(historyLog.getText().contains("In Transit"));
        Assert.assertTrue(historyLog.getText().contains("Out for Delivery"));
        Assert.assertTrue(historyLog.getText().contains("Delivered"));
    }

    @Given("the status has been updated")
    public void statusUpdated() {
        updateStatus("Delivered");
    }

    @When("the user checks for error messages")
    public void checkErrorMessages() {
        WebElement errorMessages = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error-messages")));
        Assert.assertTrue(errorMessages.isDisplayed());
    }

    @Then("no error messages are displayed")
    public void verifyNoErrorMessages() {
        WebElement errorMessages = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error-messages")));
        Assert.assertTrue(errorMessages.getText().isEmpty());
    }

    @Given("the status is {string}")
    public void statusIsDelivered(String status) {
        verifyCurrentStatus(status);
    }

    @When("the user attempts to update the status from a different device")
    public void updateStatusFromDifferentDevice() {
        // Simulate update from different device
    }

    @Then("the status updates are synchronized across devices")
    public void verifySynchronizationAcrossDevices() {
        WebElement syncMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sync-message")));
        Assert.assertTrue(syncMessage.isDisplayed());
    }

    @Given("the user is on a mobile device")
    public void userOnMobileDevice() {
        // Simulate mobile device
    }

    @When("the user verifies the shipment status")
    public void verifyShipmentStatusOnMobile() {
        WebElement mobileStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mobile-status")));
        Assert.assertTrue(mobileStatus.isDisplayed());
    }

    @Then("the status is consistent with the desktop view")
    public void verifyConsistencyWithDesktop() {
        WebElement mobileStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mobile-status")));
        WebElement desktopStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("desktop-status")));
        Assert.assertEquals(mobileStatus.getText(), desktopStatus.getText());
    }

    @Given("the system has been rebooted")
    public void systemRebooted() {
        // Simulate system reboot
    }

    @When("the user checks the shipment status")
    public void checkShipmentStatusAfterReboot() {
        verifyCurrentStatus("Delivered");
    }

    @Then("the status remains {string}")
    public void verifyStatusAfterReboot(String status) {
        verifyCurrentStatus(status);
    }
}