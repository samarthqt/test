package com.pageobjects;

import com.framework.reusable.WebReusableComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.*;

public class DragAndDrop extends WebReusableComponents {

    protected By btnProceedToCheckout = By.id("proceedToCheckout");
    protected By txtFullName = By.id("fullName");
    protected By txtAddress = By.id("address");
    protected By txtCity = By.id("city");
    protected By txtPostalCode = By.id("postalCode");
    protected By txtPhone = By.id("phone");
    protected By paymentMethodDropdown = By.id("paymentMethod");
    protected By txtCardNumber = By.id("cardNumber");
    protected By txtExpiryDate = By.id("expiryDate");
    protected By txtCVV = By.id("cvv");
    protected By btnPlaceOrder = By.id("placeOrder");
    protected By orderConfirmationMessage = By.id("orderConfirmationMessage");
    protected By btnPayWithPayPal = By.id("payWithPayPal");
    protected By btnLoginToPayPal = By.id("paypalLogin");
    protected By btnConfirmPayPalPayment = By.id("confirmPaypalPayment");
    protected By txtUserName = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");

    public DragAndDrop() {
        PageFactory.initElements(driver, this);
    }

    public void launchApp(String url) {
        launchUrl(url);
        maximizeWindow();
        Assert.assertTrue(getCurrentURL().contains(url), "Failed to launch the application.");
    }

    public void performDragAndDrop() {
        WebElement sourceElement = driver.findElement(By.id("credit2"));
        WebElement targetElement = driver.findElement(By.id("bank"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(sourceElement));
        wait.until(ExpectedConditions.visibilityOf(targetElement));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(sourceElement, targetElement).perform();
        Assert.assertTrue(targetElement.getText().contains("Bank"), "Drag and drop failed.");
    }

    public void proceedToCheckout() {
        waitUntilElementVisible(btnProceedToCheckout, 3);
        clickElement(btnProceedToCheckout);
        Assert.assertTrue(isElementVisible(txtFullName), "Failed to proceed to checkout.");
    }

    public void enterShippingDetails(String fullName, String address, String city, String postalCode, String phone) {
        waitUntilElementVisible(txtFullName, 3);
        enterText(txtFullName, fullName);
        enterText(txtAddress, address);
        enterText(txtCity, city);
        enterText(txtPostalCode, postalCode);
        enterText(txtPhone, phone);
        Assert.assertTrue(getTextFromElement(txtFullName).equals(fullName), "Shipping details entry failed.");
    }

    public void selectPaymentMethod(String method) {
        waitUntilElementVisible(paymentMethodDropdown, 3);
        selectByValue(paymentMethodDropdown, method);
        Assert.assertTrue(getSelectedValue(paymentMethodDropdown).equals(method), "Payment method selection failed.");
    }

    public void enterCreditCardDetails(String cardNumber, String expiryDate, String cvv) {
        waitUntilElementVisible(txtCardNumber, 3);
        enterText(txtCardNumber, cardNumber);
        enterText(txtExpiryDate, expiryDate);
        enterText(txtCVV, cvv);
        Assert.assertTrue(getTextFromElement(txtCardNumber).equals(cardNumber), "Credit card details entry failed.");
    }

    public void placeOrder() {
        waitUntilElementVisible(btnPlaceOrder, 3);
        clickElement(btnPlaceOrder);
        Assert.assertTrue(isElementVisible(orderConfirmationMessage), "Order placement failed.");
    }

    public void verifyOrderConfirmation(String expectedMessage) {
        waitUntilElementVisible(orderConfirmationMessage, 3);
        String actualMessage = getTextFromElement(orderConfirmationMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Order confirmation message does not match.");
    }

    public void enterUserName(String username) {
        waitUntilElementVisible(txtUserName, 3);
        enterText(txtUserName, username);
        Assert.assertTrue(getTextFromElement(txtUserName).equals(username), "Username entry failed.");
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, password);
        Assert.assertTrue(getTextFromElement(txtPassword).equals(password), "Password entry failed.");
    }

    public void clickLoginButton() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
        Assert.assertTrue(getCurrentURL().contains("homepage"), "Login failed.");
    }
}