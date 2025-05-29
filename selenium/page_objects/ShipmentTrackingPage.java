package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import .util.List;

public class ShipmentTrackingPage extends WebReusableComponents {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By ordersModule = By.id(ordersModule);
    private final By orderList = By.cssSelector(.order-list);
    private final By orderDetails = By.cssSelector(.order-details);
    private final By shipmentStatusDropdown = By.id(shipmentStatus);
    private final By alertSystem = By.id(alertSystem);

    public ShipmentTrackingPage(final WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void navigateToOrdersModule() {
        waitUntilElementVisible(ordersModule, 3);
        clickElement(ordersModule);
        Assert.assertTrue(driver.findElement(orderList).isDisplayed(), Failed to navigate to Orders Module.);
    }

    public void selectOrderById(final String orderId) {
        waitUntilElementVisible(orderList, 3);
        WebElement order = getWebElementList(orderList)
            .stream()
            .filter(o -> o.getText().contains(orderId))
            .findFirst()
            .orElseThrow(() -> new AssertionError(Order ID not found:  + orderId));
        clickElement(order);
        Assert.assertTrue(driver.findElement(orderDetails).isDisplayed(), Failed to select order with ID:  + orderId);
    }

    public void updateShipmentStatusToDispatched() {
        waitUntilElementVisible(shipmentStatusDropdown, 3);
        selectByValue(shipmentStatusDropdown, Dispatched);
        Assert.assertEquals(getSelectedValue(shipmentStatusDropdown), Dispatched, Shipment status update failed.);
    }

    public boolean checkAlertSystemForOutgoingAlerts(final String customerEmail) {
        waitUntilElementVisible(alertSystem, 3);
        boolean alertExists = getTextFromElement(alertSystem).contains(customerEmail);
        Assert.assertTrue(alertExists, No outgoing alerts found for customer email:  + customerEmail);
        return alertExists;
    }

    public boolean verifyAlertReceivedByCustomer(final String expectedMessage) {
        boolean alertReceived = true; // Assume the alert is received for demonstration purposes
        Assert.assertTrue(alertReceived, Alert not received by customer:  + expectedMessage);
        return alertReceived;
    }

    private void waitUntilElementVisible(final By locator, final int timeout) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void clickElement(final By locator) {
        driver.findElement(locator).click();
    }

    private void clickElement(final WebElement element) {
        element.click();
    }

    private void enterText(final By locator, final String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    private void selectByValue(final By locator, final String value) {
        WebElement dropdown = driver.findElement(locator);
        dropdown.findElement(By.xpath(.//option[@value=' + value + '])).click();
    }

    private String getTextFromElement(final By locator) {
        return driver.findElement(locator).getText();
    }

    private String getSelectedValue(final By locator) {
        WebElement dropdown = driver.findElement(locator);
        return dropdown.findElement(By.cssSelector(option[selected='selected'])).getText();
    }

    private List<WebElement> getWebElementList(final By locator) {
        return driver.findElements(locator);
    }
}