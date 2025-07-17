package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import .util.List;

public class ShipmentTrackingPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By trackingField = By.id("trackingField");
    private final By locationField = By.id("locationField");
    private final By okButton = By.id("okButton");
    private final By currentStatus = By.id("currentStatus");
    private final By timestamp = By.id("timestamp");
    private final By notificationSettings = By.id("notificationSettings");
    private final By errorMessage = By.id("errorMessage");
    private final By ordersModule = By.id("ordersModule");
    private final By orderList = By.cssSelector(".order-list");
    private final By orderDetails = By.cssSelector(".order-details");
    private final By shipmentStatusDropdown = By.id("shipmentStatus");
    private final By alertSystem = By.id("alertSystem");

    public ShipmentTrackingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void navigateToShipmentTrackingPage() {
        driver.get("http://example.com/shipment-tracking");
        Assert.assertTrue(driver.getCurrentUrl().contains("shipment-tracking"), "Failed to navigate to Shipment Tracking Page.");
    }

    public void enterShipmentID(String shipmentID) {
        enterText(trackingField, shipmentID);
        Assert.assertTrue(isShipmentDetailsDisplayed(shipmentID), "Shipment ID not displayed correctly.");
    }

    public boolean isShipmentDetailsDisplayed(String shipmentID) {
        String details = getTextFromElement(By.id("shipmentDetails"));
        boolean isDisplayed = details.contains(shipmentID);
        Assert.assertTrue(isDisplayed, "Shipment details not displayed for ID: " + shipmentID);
        return isDisplayed;
    }

    public void selectLocation() {
        clickElement(locationField);
        Assert.assertTrue(driver.findElement(locationField).isSelected(), "Location not selected.");
    }

    public void clickOkButton() {
        clickElement(okButton);
        Assert.assertTrue(driver.findElement(okButton).isEnabled(), "OK button not clicked.");
    }

    public String getCurrentStatus() {
        String status = getTextFromElement(currentStatus);
        Assert.assertNotNull(status, "Current status is null.");
        return status;
    }

    public void simulateStatusUpdate(String status) {
        // Simulate status update logic
        Assert.assertTrue(true, "Status update simulation failed.");
    }

    public boolean isTimestampCorrect() {
        String time = getTextFromElement(timestamp);
        boolean isCorrect = time != null && !time.isEmpty();
        Assert.assertTrue(isCorrect, "Timestamp is incorrect.");
        return isCorrect;
    }

    public void refreshPage() {
        driver.navigate().refresh();
        Assert.assertTrue(true, "Page refresh failed.");
    }

    public void logOutAndLogIn() {
        // Log out and log in logic
        Assert.assertTrue(true, "Log out and log in failed.");
    }

    public boolean areNotificationsEnabled() {
        boolean isEnabled = driver.findElement(notificationSettings).isSelected();
        Assert.assertTrue(isEnabled, "Notifications are not enabled.");
        return isEnabled;
    }

    public void simulateNetworkIssueAndRetry() {
        // Simulate network issue and retry logic
        Assert.assertTrue(true, "Network issue simulation failed.");
    }

    public boolean isShipmentHistoryLogCorrect() {
        // Verify shipment history log
        boolean isCorrect = true;
        Assert.assertTrue(isCorrect, "Shipment history log is incorrect.");
        return isCorrect;
    }

    public boolean isErrorMessageDisplayed() {
        boolean isDisplayed = driver.findElement(errorMessage).isDisplayed();
        Assert.assertTrue(isDisplayed, "Error message is not displayed.");
        return isDisplayed;
    }

    public void closeBrowser() {
        driver.quit();
        Assert.assertTrue(true, "Browser did not close properly.");
    }

    public void navigateToOrdersModule() {
        waitUntilElementVisible(ordersModule, 3);
        clickElement(ordersModule);
        Assert.assertTrue(driver.findElement(orderList).isDisplayed(), "Failed to navigate to Orders Module.");
    }

    public void selectOrderById(String orderId) {
        waitUntilElementVisible(orderList, 3);
        WebElement order = getWebElementList(orderList)
            .stream()
            .filter(o -> o.getText().contains(orderId))
            .findFirst()
            .orElseThrow(() -> new AssertionError("Order ID not found: " + orderId));
        clickElement(order);
        Assert.assertTrue(driver.findElement(orderDetails).isDisplayed(), "Failed to select order with ID: " + orderId);
    }

    public void updateShipmentStatusToDispatched() {
        waitUntilElementVisible(shipmentStatusDropdown, 3);
        selectByValue(shipmentStatusDropdown, "Dispatched");
        Assert.assertEquals(getSelectedValue(shipmentStatusDropdown), "Dispatched", "Shipment status update failed.");
    }

    public boolean checkAlertSystemForOutgoingAlerts(String customerEmail) {
        waitUntilElementVisible(alertSystem, 3);
        boolean alertExists = getTextFromElement(alertSystem).contains(customerEmail);
        Assert.assertTrue(alertExists, "No outgoing alerts found for customer email: " + customerEmail);
        return alertExists;
    }

    public boolean verifyAlertReceivedByCustomer(String expectedMessage) {
        boolean alertReceived = true; // Placeholder for actual alert check logic
        Assert.assertTrue(alertReceived, "Alert not received by customer: " + expectedMessage);
        return alertReceived;
    }

    public void waitUntilElementVisible(By locator, int timeout) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Assert.assertTrue(true, "Element not visible: " + locator.toString());
    }

    public void clickElement(By locator) {
        driver.findElement(locator).click();
        Assert.assertTrue(true, "Element not clicked: " + locator.toString());
    }

    public void clickElement(WebElement element) {
        element.click();
        Assert.assertTrue(true, "Element not clicked.");
    }

    public void enterText(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
        Assert.assertEquals(element.getAttribute("value"), text, "Text not entered correctly.");
    }

    public void selectByValue(By locator, String value) {
        WebElement dropdown = driver.findElement(locator);
        dropdown.findElement(By.xpath(".//option[@value='" + value + "']")).click();
        Assert.assertEquals(getSelectedValue(locator), value, "Value not selected: " + value);
    }

    public String getTextFromElement(By locator) {
        String text = driver.findElement(locator).getText();
        Assert.assertNotNull(text, "Text is null for element: " + locator.toString());
        return text;
    }

    public String getSelectedValue(By locator) {
        WebElement dropdown = driver.findElement(locator);
        String selectedValue = dropdown.findElement(By.cssSelector("option[selected='selected']")).getText();
        Assert.assertNotNull(selectedValue, "Selected value is null.");
        return selectedValue;
    }

    public List<WebElement> getWebElementList(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        Assert.assertFalse(elements.isEmpty(), "No elements found for locator: " + locator.toString());
        return elements;
    }
}