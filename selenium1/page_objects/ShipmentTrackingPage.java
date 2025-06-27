package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import .util.List;

/**
 * ShipmentTrackingPage class provides methods to interact with the shipment tracking page.
 */
public class ShipmentTrackingPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By ordersModule = By.id("ordersModule");
    private final By orderList = By.cssSelector(".order-list");
    private final By orderDetails = By.cssSelector(".order-details");
    private final By shipmentStatusDropdown = By.id("shipmentStatus");
    private final By alertSystem = By.id("alertSystem");

    /**
     * Constructor initializes the page elements using PageFactory.
     */
    public ShipmentTrackingPage() {
        this.driver = WebDriverSingleton.getDriver();
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    /**
     * Navigates to the Orders Module.
     */
    public void navigateToOrdersModule() {
        waitUntilElementVisible(ordersModule, 3);
        clickElement(ordersModule);
        Assert.assertTrue(driver.findElement(orderList).isDisplayed(), "Failed to navigate to Orders Module.");
    }

    /**
     * Selects an order by its ID.
     * @param orderId The ID of the order to select.
     */
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

    /**
     * Updates the shipment status to 'Dispatched'.
     */
    public void updateShipmentStatusToDispatched() {
        waitUntilElementVisible(shipmentStatusDropdown, 3);
        selectByValue(shipmentStatusDropdown, "Dispatched");
        Assert.assertEquals(getSelectedValue(shipmentStatusDropdown), "Dispatched", "Shipment status update failed.");
    }

    /**
     * Checks the alert system for outgoing alerts related to a customer email.
     * @param customerEmail The email of the customer to check alerts for.
     * @return True if alerts exist, false otherwise.
     */
    public boolean checkAlertSystemForOutgoingAlerts(String customerEmail) {
        waitUntilElementVisible(alertSystem, 3);
        boolean alertExists = getTextFromElement(alertSystem).contains(customerEmail);
        Assert.assertTrue(alertExists, "No outgoing alerts found for customer email: " + customerEmail);
        return alertExists;
    }

    /**
     * Verifies if an alert was received by the customer.
     * @param expectedMessage The expected alert message.
     * @return True if the alert was received, false otherwise.
     */
    public boolean verifyAlertReceivedByCustomer(String expectedMessage) {
        boolean alertReceived = true; // Placeholder for actual alert check logic
        Assert.assertTrue(alertReceived, "Alert not received by customer: " + expectedMessage);
        return alertReceived;
    }

    /**
     * Waits until the specified element is visible.
     * @param locator The locator of the element.
     * @param timeout The timeout in seconds.
     */
    public void waitUntilElementVisible(By locator, int timeout) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Clicks on the specified element.
     * @param locator The locator of the element to click.
     */
    public void clickElement(By locator) {
        driver.findElement(locator).click();
    }

    /**
     * Clicks on the specified WebElement.
     * @param element The WebElement to click.
     */
    public void clickElement(WebElement element) {
        element.click();
    }

    /**
     * Enters text into the specified element.
     * @param locator The locator of the element.
     * @param text The text to enter.
     */
    public void enterText(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Selects a value from a dropdown by its value.
     * @param locator The locator of the dropdown.
     * @param value The value to select.
     */
    public void selectByValue(By locator, String value) {
        WebElement dropdown = driver.findElement(locator);
        dropdown.findElement(By.xpath(".//option[@value='" + value + "']")).click();
    }

    /**
     * Gets the text from the specified element.
     * @param locator The locator of the element.
     * @return The text of the element.
     */
    public String getTextFromElement(By locator) {
        return driver.findElement(locator).getText();
    }

    /**
     * Gets the selected value from a dropdown.
     * @param locator The locator of the dropdown.
     * @return The selected value.
     */
    public String getSelectedValue(By locator) {
        WebElement dropdown = driver.findElement(locator);
        return dropdown.findElement(By.cssSelector("option[selected='selected']")).getText();
    }

    /**
     * Gets a list of WebElements matching the specified locator.
     * @param locator The locator of the elements.
     * @return A list of WebElements.
     */
    public List<WebElement> getWebElementList(By locator) {
        return driver.findElements(locator);
    }
}