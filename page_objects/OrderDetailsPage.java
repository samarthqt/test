
package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class OrderDetailsPage extends WebReusableComponents {

    protected By dashboard = By.id("dashboard");
    protected By orderID = By.id("orderID");
    protected By orderDetailsSection = By.id("orderDetailsSection");
    protected By customerEmail = By.id("customerEmail");
    protected By orderDetails = By.id("orderDetails");
    protected By accessCode = By.id("accessCode");
    protected By initiateReturnButton = By.id("initiateReturnButton");
    protected By returnPeriodExpiredMessage = By.id("returnPeriodExpiredMessage");

    public OrderDetailsPage() {
        PageFactory.initElements(driver, this);
    }

    public void loginToStore(String username, String password) {
        // Logic to login to the store
        // Assuming login elements and methods are defined elsewhere
        enterText(By.id("username"), username);
        enterText(By.id("password"), password);
        clickElement(By.id("loginButton"));
    }

    public void verifyDashboardDisplayed() {
        waitUntilElementVisible(dashboard, 3);
        Assert.assertTrue(isElementDisplayed(dashboard), "Dashboard is not displayed.");
    }

    public void verifyOrderID(String expectedOrderID) {
        waitUntilElementVisible(orderID, 3);
        String actualOrderID = getTextFromElement(orderID);
        Assert.assertEquals(actualOrderID, expectedOrderID, "Order ID does not match.");
    }

    public void navigateToOrderDetails() {
        waitUntilElementVisible(orderDetailsSection, 3);
        clickElement(orderDetailsSection);
    }

    public void verifyOrderDetailsDisplayed() {
        waitUntilElementVisible(orderDetails, 3);
        Assert.assertTrue(isElementDisplayed(orderDetails), "Order details are not displayed.");
    }

    public void verifyCustomerEmail(String expectedEmail) {
        waitUntilElementVisible(customerEmail, 3);
        String actualEmail = getTextFromElement(customerEmail);
        Assert.assertEquals(actualEmail, expectedEmail, "Customer email does not match.");
    }

    public void selectOrderByID(String orderID) {
        // Logic to select order by ID
        WebElement orderElement = driver.findElement(By.xpath("//div[@data-order-id='" + orderID + "']"));
        orderElement.click();
    }

    public void verifyOrderDetailsForID(String expectedOrderID) {
        navigateToOrderDetails();
        verifyOrderID(expectedOrderID);
        verifyOrderDetailsDisplayed();
    }

    public void verifyAccessCode(String expectedAccessCode) {
        waitUntilElementVisible(accessCode, 3);
        String actualAccessCode = getTextFromElement(accessCode);
        Assert.assertEquals(actualAccessCode, expectedAccessCode, "Access code does not match.");
    }

    public void attemptToClickInitiateReturn() {
        waitUntilElementVisible(initiateReturnButton, 3);
        clickElement(initiateReturnButton);
    }

    public void verifyInitiateReturnButtonDisabled() {
        waitUntilElementVisible(initiateReturnButton, 3);
        Assert.assertFalse(isElementEnabled(initiateReturnButton), "Initiate Return button is enabled.");
    }

    public void verifyPurchaseDate(int daysAgo) {
        // Logic to verify purchase date
        // Assuming purchase date element and logic is defined elsewhere
        String purchaseDate = getTextFromElement(By.id("purchaseDate"));
        // Logic to compare purchaseDate with current date minus daysAgo
    }

    public void verifyReturnNotAllowed() {
        attemptToClickInitiateReturn();
        verifyReturnPeriodExpiredNotification();
    }

    public void verifyReturnPeriodExpiredNotification() {
        waitUntilElementVisible(returnPeriodExpiredMessage, 3);
        Assert.assertTrue(isElementDisplayed(returnPeriodExpiredMessage), "Return period expired message is not displayed.");
    }
}
