package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import .util.List;

public class OrderDetailsPage extends WebReusableComponents {

    protected By orderDetailsSection = By.id("orderDetails");
    protected By expectedDeliveryDate = By.id("expectedDeliveryDate");
    protected By actualDeliveryDate = By.id("actualDeliveryDate");
    protected By notificationSection = By.id("notificationSection");
    protected By compensationOptions = By.id("compensationOptions");
    protected By customerSupportSection = By.id("customerSupportSection");
    protected By emailNotification = By.id("emailNotification");
    protected By orderStatus = By.id("orderStatus");
    protected By systemLogs = By.id("systemLogs");
    protected By accountDetails = By.id("accountDetails");
    protected By refundProcess = By.id("refundProcess");
    protected By trackingInformation = By.id("trackingInformation");
    protected By systemResponseTime = By.id("systemResponseTime");
    protected By orderHistoryLink = By.id("orderHistory");
    protected By orderList = By.cssSelector(".order-list");
    protected By productNames = By.cssSelector(".product-name");
    protected By productQuantities = By.cssSelector(".product-quantity");
    protected By productPrices = By.cssSelector(".product-price");
    protected By totalCost = By.id("totalCost");
    protected By discounts = By.id("discounts");
    protected By taxInformation = By.id("taxInfo");
    protected By downloadOption = By.id("downloadOrder");
    protected By productImages = By.cssSelector(".product-image");
    protected By loginPrompt = By.id("loginPrompt");
    protected By loginPage = By.id("loginPage");

    public OrderDetailsPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyOrderDetailsDisplayed() {
        waitUntilElementVisible(orderDetailsSection, 3);
        boolean isVisible = elementVisible(orderDetailsSection);
        Assert.assertTrue(isVisible, "Order details are not displayed.");
    }

    public void checkDeliveryDates(String expectedDate, String actualDate) {
        waitUntilElementVisible(expectedDeliveryDate, 3);
        String expDate = getTextFromElement(expectedDeliveryDate);
        String actDate = getTextFromElement(actualDeliveryDate);
        Assert.assertEquals(expDate, expectedDate, "Expected delivery date does not match.");
        Assert.assertEquals(actDate, actualDate, "Actual delivery date does not match.");
    }

    public void verifyNotification() {
        waitUntilElementVisible(notificationSection, 3);
        boolean isVisible = elementVisible(notificationSection);
        Assert.assertTrue(isVisible, "Notification is not displayed.");
    }

    public void checkCompensationOptions() {
        waitUntilElementVisible(compensationOptions, 3);
        boolean isVisible = elementVisible(compensationOptions);
        Assert.assertTrue(isVisible, "Compensation options are not displayed.");
    }

    public void navigateToCustomerSupport() {
        waitUntilElementVisible(customerSupportSection, 3);
        clickElement(customerSupportSection);
    }

    public void verifyEmailNotification() {
        waitUntilElementVisible(emailNotification, 3);
        boolean isVisible = elementVisible(emailNotification);
        Assert.assertTrue(isVisible, "Email notification is not displayed.");
    }

    public void checkOrderStatus(String expectedStatus) {
        waitUntilElementVisible(orderStatus, 3);
        String status = getTextFromElement(orderStatus);
        Assert.assertEquals(status, expectedStatus, "Order status does not match.");
    }

    public void reviewSystemLogs() {
        waitUntilElementVisible(systemLogs, 3);
        boolean isVisible = elementVisible(systemLogs);
        Assert.assertTrue(isVisible, "System logs are not displayed.");
    }

    public void verifyAccountDetails() {
        waitUntilElementVisible(accountDetails, 3);
        boolean isVisible = elementVisible(accountDetails);
        Assert.assertTrue(isVisible, "Account details are not displayed.");
    }

    public void checkRefundProcess() {
        waitUntilElementVisible(refundProcess, 3);
        boolean isVisible = elementVisible(refundProcess);
        Assert.assertFalse(isVisible, "Refund process is initiated.");
    }

    public void trackOrderDelivery() {
        waitUntilElementVisible(trackingInformation, 3);
        boolean isVisible = elementVisible(trackingInformation);
        Assert.assertTrue(isVisible, "Tracking information is not updated.");
    }

    public void checkSystemResponseTime() {
        waitUntilElementVisible(systemResponseTime, 3);
        boolean isVisible = elementVisible(systemResponseTime);
        Assert.assertTrue(isVisible, "System response time is not appropriate.");
    }

    public void navigateToOrderHistory() {
        waitUntilElementVisible(orderHistoryLink, 3);
        clickElement(orderHistoryLink);
    }

    public void selectOrder() {
        waitUntilElementVisible(orderList, 3);
        clickElement(orderList);
    }

    public void verifyProductNames() {
        waitUntilElementVisible(productNames, 3);
        List<WebElement> names = getWebElementList(productNames);
        Assert.assertTrue(names.size() > 0, "Product names are not listed.");
    }

    public void verifyProductQuantities() {
        waitUntilElementVisible(productQuantities, 3);
        List<WebElement> quantities = getWebElementList(productQuantities);
        Assert.assertTrue(quantities.size() > 0, "Product quantities are not displayed.");
    }

    public void verifyProductPrices() {
        waitUntilElementVisible(productPrices, 3);
        List<WebElement> prices = getWebElementList(productPrices);
        Assert.assertTrue(prices.size() > 0, "Product prices are not displayed.");
    }

    public void verifyTotalCost() {
        waitUntilElementVisible(totalCost, 3);
        String cost = getTextFromElement(totalCost);
        Assert.assertNotNull(cost, "Total cost is not displayed.");
    }

    public void verifyDiscountsAndPromotions() {
        waitUntilElementVisible(discounts, 3);
        String discount = getTextFromElement(discounts);
        Assert.assertNotNull(discount, "Discounts or promotions are not displayed.");
    }

    public void verifyTaxInformation() {
        waitUntilElementVisible(taxInformation, 3);
        String taxInfo = getTextFromElement(taxInformation);
        Assert.assertNotNull(taxInfo, "Tax information is not displayed.");
    }

    public void verifyDownloadOrPrintOption() {
        waitUntilElementVisible(downloadOption, 3);
        boolean isVisible = elementVisible(downloadOption);
        Assert.assertTrue(isVisible, "Download or print option is not available.");
    }

    public void verifyProductImages() {
        waitUntilElementVisible(productImages, 3);
        List<WebElement> images = getWebElementList(productImages);
        Assert.assertTrue(images.size() > 0, "Product images are not displayed.");
    }

    public void verifyLoginPrompt() {
        waitUntilElementVisible(loginPrompt, 3);
        boolean isVisible = elementVisible(loginPrompt);
        Assert.assertTrue(isVisible, "Login prompt is not displayed.");
    }

    public void loginToAccount() {
        waitUntilElementVisible(loginPage, 3);
        clickElement(loginPage);
    }

    public void ensureUserIsLoggedOut() {
        waitUntilElementVisible(loginPrompt, 3);
        boolean isVisible = elementVisible(loginPrompt);
        Assert.assertTrue(isVisible, "User is not logged out.");
    }

    public void attemptToViewOrderDetails() {
        navigateToOrderHistory();
        selectOrder();
        verifyOrderDetailsDisplayed();
    }
}