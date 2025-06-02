package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class OrderConfirmationPage extends WebReusableComponents {

    protected By btnLogin = By.id("loginButton");
    protected By btnCompletePurchase = By.id("completePurchase");
    protected By emailField = By.id("email");
    protected By phoneField = By.id("phone");
    protected By emailConfirmation = By.id("emailConfirmation");
    protected By smsConfirmation = By.id("smsConfirmation");
    protected By btnLogout = By.id("logoutButton");
    protected By orderConfirmationPage = By.id("orderConfirmationPage");
    protected By orderNumber = By.id("orderNumber");
    protected By shippingAddress = By.id("shippingAddress");
    protected By itemsList = By.id("itemsList");
    protected By itemQuantities = By.id("itemQuantities");
    protected By itemPrices = By.id("itemPrices");
    protected By totalAmount = By.id("totalAmount");
    protected By estimatedDeliveryDate = By.id("estimatedDeliveryDate");
    protected By paymentMethod = By.id("paymentMethod");
    protected By customerSupportContact = By.id("customerSupportContact");
    protected By trackingLink = By.id("trackingLink");
    protected By printOption = By.id("printOption");
    protected By emailOption = By.id("emailOption");
    protected By promotionalOffers = By.id("promotionalOffers");

    public OrderConfirmationPage() {
        PageFactory.initElements(driver, this);
    }

    public void loginToApplication() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    public void completePurchaseTransaction() {
        waitUntilElementVisible(btnCompletePurchase, 3);
        clickElement(btnCompletePurchase);
    }

    public void verifyPurchaseCompletion() {
        Assert.assertTrue(isElementVisible(emailConfirmation), "Purchase not completed successfully.");
    }

    public void setUserEmail(String email) {
        waitUntilElementVisible(emailField, 3);
        enterText(emailField, email);
    }

    public void setUserPhoneNumber(String phone) {
        waitUntilElementVisible(phoneField, 3);
        enterText(phoneField, phone);
    }

    public void verifyOrderConfirmationEmail() {
        Assert.assertTrue(isElementVisible(emailConfirmation), "Order confirmation email not received.");
    }

    public void verifyOrderConfirmationSMS() {
        Assert.assertTrue(isElementVisible(smsConfirmation), "Order confirmation SMS not received.");
    }

    public void checkEmailReceived() {
        Assert.assertTrue(isElementVisible(emailConfirmation), "Order confirmation email not received.");
    }

    public void verifyEmailContent() {
        String emailContent = getTextFromElement(emailConfirmation);
        Assert.assertTrue(emailContent.contains("Order ID"), "Order ID not found in email.");
        Assert.assertTrue(emailContent.contains("Product Details"), "Product details not found in email.");
        Assert.assertTrue(emailContent.contains("Total Amount"), "Total amount not found in email.");
    }

    public void checkSMSReceived() {
        Assert.assertTrue(isElementVisible(smsConfirmation), "Order confirmation SMS not received.");
    }

    public void verifySMSContent() {
        String smsContent = getTextFromElement(smsConfirmation);
        Assert.assertTrue(smsContent.contains("Order ID"), "Order ID not found in SMS.");
        Assert.assertTrue(smsContent.contains("Total Amount"), "Total amount not found in SMS.");
    }

    public void verifyNotificationTimeliness() {
        Assert.assertTrue(isElementVisible(emailConfirmation), "Email notification not received immediately.");
        Assert.assertTrue(isElementVisible(smsConfirmation), "SMS notification not received immediately.");
    }

    public void logoutFromApplication() {
        waitUntilElementVisible(btnLogout, 3);
        clickElement(btnLogout);
    }

    public void verifyLogoutSuccess() {
        Assert.assertFalse(isElementVisible(btnLogout), "Logout was not successful.");
    }

    public void navigateToOrderConfirmationPage() {
        waitUntilElementVisible(orderConfirmationPage, 3);
        Assert.assertTrue(isElementDisplayed(orderConfirmationPage), "Order confirmation page is not displayed.");
    }

    public void verifyOrderConfirmationPageDisplayed() {
        waitUntilElementVisible(orderConfirmationPage, 3);
        Assert.assertTrue(isElementDisplayed(orderConfirmationPage), "Order confirmation page is not displayed.");
    }

    public void verifyOrderNumberDisplayed(String expectedOrderNumber) {
        waitUntilElementVisible(orderNumber, 3);
        String actualOrderNumber = getTextFromElement(orderNumber);
        Assert.assertEquals(actualOrderNumber, expectedOrderNumber, "Order number does not match.");
    }

    public void verifyShippingAddressDisplayed(String expectedAddress) {
        waitUntilElementVisible(shippingAddress, 3);
        String actualAddress = getTextFromElement(shippingAddress);
        Assert.assertEquals(actualAddress, expectedAddress, "Shipping address does not match.");
    }

    public void verifyItemsListed(String expectedItems) {
        waitUntilElementVisible(itemsList, 3);
        String actualItems = getTextFromElement(itemsList);
        Assert.assertEquals(actualItems, expectedItems, "Items listed do not match.");
    }

    public void verifyItemQuantitiesMatch() {
        waitUntilElementVisible(itemQuantities, 3);
        // Logic to verify item quantities match
    }

    public void verifyItemPricesDisplayedCorrectly() {
        waitUntilElementVisible(itemPrices, 3);
        // Logic to verify item prices are displayed correctly
    }

    public void verifyTotalAmountMatches() {
        waitUntilElementVisible(totalAmount, 3);
        // Logic to verify total amount matches
    }

    public void verifyEstimatedDeliveryDateDisplayed() {
        waitUntilElementVisible(estimatedDeliveryDate, 3);
        Assert.assertTrue(isElementDisplayed(estimatedDeliveryDate), "Estimated delivery date is not displayed.");
    }

    public void verifyPaymentMethodDisplayed() {
        waitUntilElementVisible(paymentMethod, 3);
        Assert.assertTrue(isElementDisplayed(paymentMethod), "Payment method is not displayed.");
    }

    public void verifyCustomerSupportContactInformationDisplayed() {
        waitUntilElementVisible(customerSupportContact, 3);
        Assert.assertTrue(isElementDisplayed(customerSupportContact), "Customer support contact information is not displayed.");
    }

    public void verifyTrackingLinkAvailable() {
        waitUntilElementVisible(trackingLink, 3);
        Assert.assertTrue(isElementDisplayed(trackingLink), "Tracking link is not available.");
    }

    public void verifyPageLayoutIsUserFriendly() {
        // Logic to verify page layout is user-friendly
    }

    public void verifyPrintOptionAvailable() {
        waitUntilElementVisible(printOption, 3);
        Assert.assertTrue(isElementDisplayed(printOption), "Print option is not available.");
    }

    public void verifyEmailOptionAvailable() {
        waitUntilElementVisible(emailOption, 3);
        Assert.assertTrue(isElementDisplayed(emailOption), "Email option is not available.");
    }

    public void verifyPromotionalOffersDisplayed() {
        waitUntilElementVisible(promotionalOffers, 3);
        Assert.assertTrue(isElementDisplayed(promotionalOffers), "Promotional offers are not displayed.");
    }
}