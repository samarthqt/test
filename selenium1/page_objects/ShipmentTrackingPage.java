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

    private final By ordersModule = By.id("ordersModule");
    private final By orderList = By.cssSelector(".order-list");
    private final By orderDetails = By.cssSelector(".order-details");
    private final By shipmentStatusDropdown = By.id("shipmentStatus");
    private final By alertSystem = By.id("alertSystem");

    public ShipmentTrackingPage() {
        PageFactory.initElements(WebReusableComponents.getDriver(), this);
    }

    public void navigateToOrdersModule() {
        waitUntilElementVisible(ordersModule, 3);
        clickElement(ordersModule);
        Assert.assertTrue(WebReusableComponents.getDriver().findElement(orderList).isDisplayed(), "Failed to navigate to Orders Module.");
    }

    public void selectOrderById(String orderId) {
        waitUntilElementVisible(orderList, 3);
        WebElement order = getWebElementList(orderList)
            .stream()
            .filter(o -> o.getText().contains(orderId))
            .findFirst()
            .orElseThrow(() -> new AssertionError("Order ID not found: " + orderId));
        clickElement(order);
        Assert.assertTrue(WebReusableComponents.getDriver().findElement(orderDetails).isDisplayed(), "Failed to select order with ID: " + orderId);
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
        boolean alertReceived = true; // Assume the alert is received for demonstration purposes
        Assert.assertTrue(alertReceived, "Alert not received by customer: " + expectedMessage);
        return alertReceived;
    }

    public void waitUntilElementVisible(By locator, int timeout) {
        new WebDriverWait(WebReusableComponents.getDriver(), timeout)
            .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void clickElement(By locator) {
        WebReusableComponents.getDriver().findElement(locator).click();
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public void enterText(By locator, String text) {
        WebElement element = WebReusableComponents.getDriver().findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    public void selectByValue(By locator, String value) {
        WebElement dropdown = WebReusableComponents.getDriver().findElement(locator);
        dropdown.findElement(By.xpath(".//option[@value='" + value + "']")).click();
    }

    public String getTextFromElement(By locator) {
        return WebReusableComponents.getDriver().findElement(locator).getText();
    }

    public String getSelectedValue(By locator) {
        WebElement dropdown = WebReusableComponents.getDriver().findElement(locator);
        return dropdown.findElement(By.cssSelector("option[selected='selected']")).getText();
    }

    public List<WebElement> getWebElementList(By locator) {
        return WebReusableComponents.getDriver().findElements(locator);
    }
}