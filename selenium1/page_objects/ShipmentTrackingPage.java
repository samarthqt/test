package selenium1.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import .util.List;

public class ShipmentTrackingPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By ordersModule = By.id("ordersModule");
    private final By orderList = By.cssSelector(".order-list");
    private final By orderDetails = By.cssSelector(".order-details");
    private final By shipmentStatusDropdown = By.id("shipmentStatus");
    private final By alertSystem = By.id("alertSystem");
    private final By orderHistory = By.id("orderHistory");
    private final By auditTrailLogs = By.id("auditTrailLogs");
    private final By customerPortalStatus = By.id("customerPortalStatus");

    public ShipmentTrackingPage() {
        this.driver = WebReusableComponents.getDriver();
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
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
        waitUntilElementVisible(alertSystem, 3);
        boolean alertReceived = getTextFromElement(alertSystem).contains(expectedMessage);
        Assert.assertTrue(alertReceived, "Alert not received by customer: " + expectedMessage);
        return alertReceived;
    }

    public void verifyOrderHistory(String orderId, String expectedEntry) {
        waitUntilElementVisible(orderHistory, 3);
        String historyText = getTextFromElement(orderHistory);
        Assert.assertTrue(historyText.contains(expectedEntry), "Order history does not contain expected entry for order ID: " + orderId);
    }

    public void checkAuditTrailLogs(String orderId) {
        waitUntilElementVisible(auditTrailLogs, 3);
        String logsText = getTextFromElement(auditTrailLogs);
        Assert.assertTrue(logsText.contains(orderId), "Audit logs do not contain expected entry for order ID: " + orderId);
    }

    public void confirmStatusInCustomerPortal(String orderId, String expectedStatus) {
        waitUntilElementVisible(customerPortalStatus, 3);
        String statusText = getTextFromElement(customerPortalStatus);
        Assert.assertTrue(statusText.contains(expectedStatus), "Customer portal does not display expected status for order ID: " + orderId);
    }

    public void waitUntilElementVisible(By locator, int timeout) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(locator));
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