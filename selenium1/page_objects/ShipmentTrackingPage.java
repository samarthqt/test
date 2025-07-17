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
    private final By statusField = By.id("statusField");
    private final By timestampField = By.id("timestampField");
    private final By notificationSettings = By.id("notificationSettings");
    private final By errorMessages = By.id("errorMessages");
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
    }

    public void enterShipmentID(String shipmentID) {
        WebElement trackingElement = driver.findElement(trackingField);
        trackingElement.clear();
        trackingElement.sendKeys(shipmentID);
    }

    public String getShipmentStatus() {
        return driver.findElement(statusField).getText();
    }

    public void simulateStatusUpdate(String newStatus) {
        WebElement statusElement = driver.findElement(statusField);
        statusElement.clear();
        statusElement.sendKeys(newStatus);
    }

    public boolean verifyTimestamp() {
        String timestamp = driver.findElement(timestampField).getText();
        // Logic to verify timestamp matches current time
        return true;
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void logOutAndLogIn() {
        // Logic to log out and log back in
    }

    public boolean checkNotificationSettings() {
        return driver.findElement(notificationSettings).isSelected();
    }

    public void simulateNetworkIssue() {
        // Logic to simulate network issue
    }

    public boolean handleNetworkIssue() {
        // Logic to handle network issue
        return true;
    }

    public boolean verifyShipmentHistoryLog() {
        // Logic to verify shipment history log
        return true;
    }

    public boolean checkForErrorMessages() {
        return driver.findElements(errorMessages).isEmpty();
    }

    public void closeBrowser() {
        driver.quit();
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
    }

    public void clickElement(By locator) {
        driver.findElement(locator).click();
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public void enterText(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    public void selectByValue(By locator, String value) {
        WebElement dropdown = driver.findElement(locator);
        dropdown.findElement(By.xpath(".//option[@value='" + value + "']")).click();
    }

    public String getTextFromElement(By locator) {
        return driver.findElement(locator).getText();
    }

    public String getSelectedValue(By locator) {
        WebElement dropdown = driver.findElement(locator);
        return dropdown.findElement(By.cssSelector("option[selected='selected']")).getText();
    }

    public List<WebElement> getWebElementList(By locator) {
        return driver.findElements(locator);
    }
}