package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class DesignReviewPage extends WebReusableComponents {

    private final By designReviewSection = By.id("designReviewSection");
    private final By btnProceedToCheckout = By.id("proceedToCheckout");
    private final By txtFullName = By.id("fullName");
    private final By txtAddress = By.id("address");
    private final By txtCity = By.id("city");
    private final By txtPostalCode = By.id("postalCode");
    private final By txtPhone = By.id("phone");
    private final By paymentMethodDropdown = By.id("paymentMethod");
    private final By txtCardNumber = By.id("cardNumber");
    private final By txtExpiryDate = By.id("expiryDate");
    private final By txtCVV = By.id("cvv");
    private final By btnPlaceOrder = By.id("placeOrder");
    private final By orderConfirmationMessage = By.id("orderConfirmationMessage");
    private final By btnPayWithPayPal = By.id("payWithPayPal");
    private final By btnLoginToPayPal = By.id("paypalLogin");
    private final By btnConfirmPayPalPayment = By.id("confirmPaypalPayment");

    public DesignReviewPage() {
        PageFactory.initElements(driver, this);
    }

    public void reviewApplicationDesign() {
        waitUntilElementVisible(designReviewSection, 3);
        Assert.assertTrue(isElementDisplayed(designReviewSection), "Application design is not reviewed.");
    }

    public void compareDesignWithBrandingGuidelines() {
        waitUntilElementVisible(designReviewSection, 3);
        Assert.assertTrue(isElementDisplayed(designReviewSection), "Design is not compared with branding guidelines.");
    }

    public void verifyDesignAlignment() {
        waitUntilElementVisible(designReviewSection, 3);
        Assert.assertTrue(isElementDisplayed(designReviewSection), "Design does not align with branding guidelines.");
    }

    public void proceedToCheckout() {
        waitUntilElementVisible(btnProceedToCheckout, 3);
        clickElement(btnProceedToCheckout);
    }

    public void enterShippingDetails(String fullName, String address, String city, String postalCode, String phone) {
        waitUntilElementVisible(txtFullName, 3);
        enterText(txtFullName, fullName);
        enterText(txtAddress, address);
        enterText(txtCity, city);
        enterText(txtPostalCode, postalCode);
        enterText(txtPhone, phone);
    }

    public void selectPaymentMethod(String method) {
        waitUntilElementVisible(paymentMethodDropdown, 3);
        selectByValue(paymentMethodDropdown, method);
    }

    public void enterCreditCardDetails(String cardNumber, String expiryDate, String cvv) {
        waitUntilElementVisible(txtCardNumber, 3);
        enterText(txtCardNumber, cardNumber);
        enterText(txtExpiryDate, expiryDate);
        enterText(txtCVV, cvv);
    }

    public void placeOrder() {
        waitUntilElementVisible(btnPlaceOrder, 3);
        clickElement(btnPlaceOrder);
    }

    public void verifyOrderConfirmation(String expectedMessage) {
        waitUntilElementVisible(orderConfirmationMessage, 3);
        String actualMessage = getTextFromElement(orderConfirmationMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Order confirmation message does not match.");
    }

    private void waitUntilElementVisible(By locator, int timeout) {
        // Implementation for waiting until element is visible
    }

    private void clickElement(By locator) {
        // Implementation for clicking an element
    }

    private void enterText(By locator, String text) {
        // Implementation for entering text into a field
    }

    private void selectByValue(By locator, String value) {
        // Implementation for selecting a value from a dropdown
    }

    private String getTextFromElement(By locator) {
        // Implementation for getting text from an element
        return "";
    }

    private boolean isElementDisplayed(By locator) {
        // Implementation for checking if an element is displayed
        return true;
    }
}