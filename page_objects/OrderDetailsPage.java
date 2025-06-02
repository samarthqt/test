package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class OrderDetailsPage extends WebReusableComponents {

    protected By orderDetailsSection = By.id("orderDetailsSection");
    protected By orderId = By.cssSelector(".order-id");
    protected By accessCode = By.cssSelector(".access-code");
    protected By btnInitiateReturn = By.id("initiateReturn");
    protected By returnPeriodExpiredMessage = By.id("returnPeriodExpiredMessage");

    public OrderDetailsPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyPurchaseExists(final String productType) {
        waitUntilElementVisible(orderDetailsSection, 3);
        WebElement productElement = findElementByText(orderDetailsSection, productType);
        Assert.assertTrue(productElement.isDisplayed(), "Purchase does not exist for the product type: " + productType);
    }

    public void verifyPurchaseDateExceedsLimit(final int days) {
        // Logic to verify purchase date exceeds limit
        // Assuming a method getPurchaseDate() that retrieves the purchase date
        // Date purchaseDate = getPurchaseDate();
        // Assert.assertTrue(isDateExceedsLimit(purchaseDate, days), "Purchase date does not exceed limit of " + days + " days.");
    }

    public void loginToBFWStore(final String username, final String password) {
        // Logic to login to BFW store
        // Assuming methods enterUsername(), enterPassword(), and clickLogin()
        // enterUsername(username);
        // enterPassword(password);
        // clickLogin();
    }

    public void navigateToOrderDetails() {
        waitUntilElementVisible(orderDetailsSection, 3);
        clickElement(orderDetailsSection);
    }

    public void selectOrderById(final String orderIdValue) {
        WebElement orderElement = findElementByText(orderId, orderIdValue);
        Assert.assertNotNull(orderElement, "Order with ID " + orderIdValue + " not found.");
        clickElement(orderElement);
    }

    public void verifyOrderDetailsDisplayed(final String orderIdValue) {
        WebElement orderElement = findElementByText(orderId, orderIdValue);
        Assert.assertTrue(orderElement.isDisplayed(), "Order details not displayed for order ID: " + orderIdValue);
    }

    public void verifyAccessCode(final String expectedAccessCode) {
        WebElement accessCodeElement = findElementByText(accessCode, expectedAccessCode);
        Assert.assertTrue(accessCodeElement.isDisplayed(), "Access code not displayed or incorrect.");
    }

    public void attemptInitiateReturn() {
        if (isElementPresent(btnInitiateReturn)) {
            clickElement(btnInitiateReturn);
        } else {
            Assert.fail("Initiate Return button is not present.");
        }
    }

    public void verifyInitiateReturnButtonDisabledOrNotPresent() {
        Assert.assertFalse(isElementEnabled(btnInitiateReturn), "Initiate Return button is enabled or present.");
    }

    public void verifyReturnPeriodExpiredNotification() {
        String actualMessage = getTextFromElement(returnPeriodExpiredMessage);
        Assert.assertEquals(actualMessage, "Return period has expired.", "Return period expired message not displayed.");
    }
}