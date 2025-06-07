package bdd.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import .util.List;

public class ShipmentPage extends WebReusableComponents {

    protected By orderList = By.id("orderList");
    protected By orderDetails = By.id("orderDetails");
    protected By shipmentStatus = By.id("shipmentStatus");
    protected By alertSystem = By.id("alertSystem");
    protected By loginButton = By.id("loginButton");
    protected By dashboard = By.id("dashboard");
    protected By ordersModule = By.id("ordersModule");
    protected By alertMessage = By.id("alertMessage");

    public ShipmentPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyOrderExists(int orderId) {
        waitUntilElementVisible(orderList, 3);
        List<WebElement> orders = getWebElementList(orderList);
        boolean orderFound = orders.stream().anyMatch(order -> order.getText().contains(String.valueOf(orderId)));
        Assert.assertTrue(orderFound, "Order does not exist.");
    }

    public void verifyCustomerSubscription() {
        boolean isSubscribed = checkSubscriptionStatus();
        Assert.assertTrue(isSubscribed, "Customer is not subscribed.");
    }

    public void verifyCustomerEmail(String email) {
        String actualEmail = getCustomerEmail();
        Assert.assertEquals(actualEmail, email, "Customer email does not match.");
    }

    public void loginToSystem() {
        waitUntilElementVisible(loginButton, 3);
        clickElement(loginButton);
        Assert.assertTrue(isElementVisible(dashboard), "Login failed, dashboard not displayed.");
    }

    public void verifyDashboardDisplayed() {
        waitUntilElementVisible(dashboard, 3);
        Assert.assertTrue(isElementVisible(dashboard), "Dashboard is not displayed.");
    }

    public void navigateToOrdersModule() {
        waitUntilElementVisible(ordersModule, 3);
        clickElement(ordersModule);
    }

    public void verifyOrdersModuleDisplayed() {
        waitUntilElementVisible(ordersModule, 3);
        Assert.assertTrue(isElementVisible(ordersModule), "Orders module is not displayed.");
    }

    public void selectOrderById(int orderId) {
        waitUntilElementVisible(orderList, 3);
        List<WebElement> orders = getWebElementList(orderList);
        orders.stream().filter(order -> order.getText().contains(String.valueOf(orderId)))
              .findFirst().ifPresent(WebElement::click);
    }

    public void verifyOrderDetailsDisplayed(int orderId) {
        waitUntilElementVisible(orderDetails, 3);
        String detailsText = getTextFromElement(orderDetails);
        Assert.assertTrue(detailsText.contains(String.valueOf(orderId)), "Order details are not displayed.");
    }

    public void verifyShipmentStatus(String status) {
        waitUntilElementVisible(shipmentStatus, 3);
        String actualStatus = getTextFromElement(shipmentStatus);
        Assert.assertEquals(actualStatus, status, "Shipment status does not match.");
    }

    public void updateShipmentStatus(String status) {
        waitUntilElementVisible(shipmentStatus, 3);
        enterText(shipmentStatus, status);
        Assert.assertEquals(getTextFromElement(shipmentStatus), status, "Shipment status update failed.");
    }

    public void verifyShipmentStatusUpdated(String status) {
        waitUntilElementVisible(shipmentStatus, 3);
        String actualStatus = getTextFromElement(shipmentStatus);
        Assert.assertEquals(actualStatus, status, "Shipment status is not updated.");
    }

    public void checkAlertSystem() {
        waitUntilElementVisible(alertSystem, 3);
        Assert.assertTrue(isElementVisible(alertSystem), "Alert system is not active.");
    }

    public void verifyAlertSent(String email) {
        waitUntilElementVisible(alertMessage, 3);
        String message = getTextFromElement(alertMessage);
        Assert.assertTrue(message.contains(email), "Alert not sent to the specified email.");
    }

    public void verifyAlertMessage(String message) {
        waitUntilElementVisible(alertMessage, 3);
        String actualMessage = getTextFromElement(alertMessage);
        Assert.assertEquals(actualMessage, message, "Alert message does not match.");
    }
}