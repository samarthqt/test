package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.List;
import org.openqa.selenium.WebElement;

public class OrderHistoryPage extends WebReusableComponents {

    protected By orderHistoryLink = By.id("orderHistory");
    protected By orderList = By.cssSelector(".order-item");
    protected By orderDetailsSection = By.id("orderDetails");
    protected By specificOrder(String orderID) {
        return By.xpath("//div[@data-order-id='" + orderID + "']");
    }

    public void navigateToOrderHistory() {
        waitUntilElementVisible(orderHistoryLink, 3);
        clickElement(orderHistoryLink);
    }

    public void verifyOrderHistoryDisplayed() {
        waitUntilElementVisible(orderList, 3);
        List<WebElement> orders = getWebElementList(orderList);
        Assert.assertFalse(orders.isEmpty(), "No past orders are displayed.");
    }

    public void selectOrder(String orderID) {
        By orderLocator = specificOrder(orderID);
        waitUntilElementVisible(orderLocator, 3);
        clickElement(orderLocator);
    }

    public void verifyOrderDetailsDisplayed() {
        waitUntilElementVisible(orderDetailsSection, 3);
        boolean isVisible = elementVisible(orderDetailsSection);
        Assert.assertTrue(isVisible, "Order details are not displayed.");
    }

    public void verifyOrderStatus(String orderID, String expectedStatus) {
        By orderStatusLocator = By.xpath("//div[@data-order-id='" + orderID + "']//span[@class='status']");
        waitUntilElementVisible(orderStatusLocator, 3);
        String actualStatus = getTextFromElement(orderStatusLocator);
        Assert.assertEquals(actualStatus, expectedStatus, "Order status does not match.");
    }

    public void selectTrackingLink(String orderID) {
        By trackingLinkLocator = By.xpath("//div[@data-order-id='" + orderID + "']//a[@class='tracking-link']");
        waitUntilElementVisible(trackingLinkLocator, 3);
        clickElement(trackingLinkLocator);
    }

    public void verifyTrackingPageOpened() {
        // Implement logic to verify tracking page is opened
    }

    public void verifySMSNotificationReceived(String notificationType) {
        // Implement logic to verify SMS notification is received
    }
}