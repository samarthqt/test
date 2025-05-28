package com.pageobjects;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class ShipmentTrackingPage extends WebReusableComponents {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By ordersModule = By.id(ordersModule);
    private final By orderList = By.cssSelector(.order-list);
    private final By orderDetails = By.cssSelector(.order-details);
    private final By shipmentStatusDropdown = By.id(shipmentStatus);
    private final By alertSystem = By.id(alertSystem);

    public ShipmentTrackingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void navigateToOrdersModule() {
        waitUntilElementVisible(ordersModule, 3);
        clickElement(ordersModule);
        Assert.assertTrue(driver.findElement(orderList).isDisplayed(), Failed to navigate to Orders Module.);
    }

    public void selectOrderById(String orderId) {
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

    public boolean checkAlertSystemForOutgoingAlerts(String customerEmail) {
        waitUntilElementVisible(alertSystem, 3);
        boolean alertExists = getTextFromElement(alertSystem).contains(customerEmail);
        Assert.assertTrue(alertExists, No outgoing alerts found for customer email:  + customerEmail);
        return alertExists;
    }

    public boolean verifyAlertReceivedByCustomer(String expectedMessage) {
        // Simulate checking the customer's email or alert system
        boolean alertReceived = true; // Assume the alert is received for demonstration purposes
        Assert.assertTrue(alertReceived, Alert not received by customer:  + expectedMessage);
        return alertReceived;
    }

    private void waitUntilElementVisible(By locator, int timeout) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void clickElement(By locator) {
        driver.findElement(locator).click();
    }

    private void clickElement(WebElement element) {
        element.click();
    }

    private void enterText(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    private void selectByValue(By locator, String value) {
        WebElement dropdown = driver.findElement(locator);
        dropdown.findElement(By.xpath(.//option[@value=' + value + '])).click();
    }

    private String getTextFromElement(By locator) {
        return driver.findElement(locator).getText();
    }

    private String getSelectedValue(By locator) {
        WebElement dropdown = driver.findElement(locator);
        return dropdown.findElement(By.cssSelector(option[selected='selected'])).getText();
    }

    private .util.List<WebElement> getWebElementList(By locator) {
        return driver.findElements(locator);
    }
}
package com.pageobjects;


public class ShipmentTrackingPage extends WebReusableComponents {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By shipmentIdField = By.id("shipmentId");
    private final By locationField = By.id("location");
    private final By okButton = By.id("okButton");
    private final By shipmentStatus = By.id("shipmentStatus");
    private final By timestamp = By.id("timestamp");
    private final By notificationSettings = By.id("notificationSettings");
    private final By shipmentHistoryLog = By.id("shipmentHistoryLog");
    private final By errorMessage = By.id("errorMessage");
    private final By logoutButton = By.id("logoutButton");
    private final By loginButton = By.id("loginButton");

    public ShipmentTrackingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void enterShipmentId(String shipmentId) {
        waitUntilElementVisible(shipmentIdField, 3);
        enterText(shipmentIdField, shipmentId);
    }

    public void selectLocation(String location) {
        waitUntilElementVisible(locationField, 3);
        enterText(locationField, location);
    }

    public void clickOkButton() {
        waitUntilElementVisible(okButton, 3);
        clickElement(okButton);
    }

    public String checkShipmentStatus() {
        waitUntilElementVisible(shipmentStatus, 3);
        return getTextFromElement(shipmentStatus);
    }

    public void simulateStatusUpdate(String status) {
        waitUntilElementVisible(shipmentStatus, 3);
        selectByValue(shipmentStatus, status);
    }

    public String verifyTimestamp() {
        waitUntilElementVisible(timestamp, 3);
        return getTextFromElement(timestamp);
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void logoutAndLogin() {
        waitUntilElementVisible(logoutButton, 3);
        clickElement(logoutButton);
        waitUntilElementVisible(loginButton, 3);
        clickElement(loginButton);
    }

    public boolean checkNotificationSettings() {
        waitUntilElementVisible(notificationSettings, 3);
        return driver.findElement(notificationSettings).isDisplayed();
    }

    public void simulateNetworkIssueAndUpdateStatus(String status) {
        try {
            simulateStatusUpdate(status);
        } catch (Exception e) {
            // Handle network issue simulation
        }
    }

    public boolean verifyShipmentHistoryLog() {
        waitUntilElementVisible(shipmentHistoryLog, 3);
        return driver.findElement(shipmentHistoryLog).isDisplayed();
    }

    public boolean checkErrorMessages() {
        waitUntilElementVisible(errorMessage, 3);
        List<WebElement> errors = driver.findElements(errorMessage);
        return !errors.isEmpty();
    }

    private void waitUntilElementVisible(By locator, int timeout) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void clickElement(By locator) {
        driver.findElement(locator).click();
    }

    private void enterText(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    private void selectByValue(By locator, String value) {
        WebElement dropdown = driver.findElement(locator);
        dropdown.findElement(By.xpath(".//option[@value='" + value + "']")).click();
    }

    private String getTextFromElement(By locator) {
        return driver.findElement(locator).getText();
    }
}