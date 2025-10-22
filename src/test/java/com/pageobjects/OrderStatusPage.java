package com.pageobjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import org.openqa.selenium.WebElement;
import java.util.List;

public class OrderStatusPage extends WebReusableComponents {

    protected By accountDashboardLink = By.id("accountDashboard");
    protected By orderHistorySection = By.id("orderHistory");
    protected By orderDetailsSection = By.id("orderDetails");
    protected By trackingLink = By.id("trackingLink");

    protected By specificOrder(String orderID) {
        return By.xpath("//div[@data-order-id='" + orderID + "']");
    }

    protected By orderStatus(String orderID) {
        return By.xpath("//div[@data-order-id='" + orderID + "']//span[@class='status']");
    }

    public void loginToAccount() {
        // Dummy implementation for login
    }

    public void navigateToAccountDashboard() {
        waitUntilElementVisible(accountDashboardLink, 3);
        clickElement(accountDashboardLink);
    }

    public void verifyAccountDashboardDisplayed() {
        waitUntilElementVisible(orderHistorySection, 3);
        boolean isVisible = elementVisible(orderHistorySection);
        Assert.assertTrue(isVisible, "Account dashboard is not displayed.");
    }

    public void locateOrderInHistory(String orderID) {
        By orderLocator = specificOrder(orderID);
        waitUntilElementVisible(orderLocator, 3);
    }

    public void verifyOrderStatus(String orderID, String expectedStatus) {
        By statusLocator = orderStatus(orderID);
        waitUntilElementVisible(statusLocator, 3);
        String actualStatus = getTextFromElement(statusLocator);
        Assert.assertEquals(actualStatus, expectedStatus, "Order status does not match.");
    }

    public void selectOrderToViewDetails(String orderID) {
        By orderLocator = specificOrder(orderID);
        waitUntilElementVisible(orderLocator, 3);
        clickElement(orderLocator);
    }

    public void verifyOrderDetailsDisplayed() {
        waitUntilElementVisible(orderDetailsSection, 3);
        boolean isVisible = elementVisible(orderDetailsSection);
        Assert.assertTrue(isVisible, "Order details are not displayed.");
    }

    public void selectTrackingLink() {
        waitUntilElementVisible(trackingLink, 3);
        clickElement(trackingLink);
    }

    public void verifyTrackingPageDisplayed() {
        // Dummy implementation for verifying tracking page
    }
}
