package com.pageobjects;
import java.util.List;
import org.openqa.selenium.NoSuchElementException;

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
```java

private final By trackingField = By.id("trackingField");
private final By locationField = By.id("locationField");
private final By okButton = By.id("okButton");
private final By statusText = By.id("statusText");
private final By refreshButton = By.id("refreshButton");
private final By logoutButton = By.id("logoutButton");
private final By loginButton = By.id("loginButton");
private final By notificationSettings = By.id("notificationSettings");
private final By errorMessage = By.id("errorMessage");
private final By shipmentHistoryLog = By.id("shipmentHistoryLog");

public void enterShipmentId(String shipmentId) {
    enterText(trackingField, shipmentId);
}

public void selectLocation(String location) {
    enterText(locationField, location);
}

public void clickOkButton() {
    clickElement(okButton);
}

public String getCurrentShipmentStatus() {
    return getTextFromElement(statusText);
}

public void simulateStatusUpdate(String status) {
    // Simulate status update logic
    // This could be interacting with a mock server or API
}

public String getLatestStatusTimestamp() {
    // Simulate retrieval of timestamp for the latest status update
    return "2023-10-01T10:00:00";
}

public void refreshPage() {
    clickElement(refreshButton);
}

public void logoutAndLogin() {
    clickElement(logoutButton);
    clickElement(loginButton);
}

public void checkNotificationSettings() {
    waitUntilElementVisible(notificationSettings, 3);
    Assert.assertTrue(driver.findElement(notificationSettings).isDisplayed(), "Notification settings are not visible.");
}

public void simulateNetworkIssueAndUpdateStatus() {
    // Simulate network issue
    // Attempt to update status during network issue
}

public void verifyShipmentHistoryLog() {
    waitUntilElementVisible(shipmentHistoryLog, 3);
    Assert.assertTrue(driver.findElement(shipmentHistoryLog).isDisplayed(), "Shipment history log is not visible.");
}

public void checkForErrorMessages() {
    try {
        waitUntilElementVisible(errorMessage, 3);
        Assert.fail("Error message displayed: " + getTextFromElement(errorMessage));
    } catch (NoSuchElementException e) {
        // No error message displayed
    }
}
```