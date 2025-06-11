package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.*;

public class NachweisePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected By txtUserName = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
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

    public NachweisePage() {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    public void enterUserName(String username) {
        waitUntilElementVisible(txtUserName);
        driver.findElement(txtUserName).sendKeys(username);
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword);
        driver.findElement(txtPassword).sendKeys(password);
    }

    public void clickLoginButton() {
        waitUntilElementVisible(btnLogin);
        driver.findElement(btnLogin).click();
    }

    public void verifyHomePageRedirection(String expectedURL) {
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, expectedURL, "User is not redirected to the homepage.");
    }

    public void proceedToCheckout() {
        waitUntilElementVisible(btnProceedToCheckout);
        driver.findElement(btnProceedToCheckout).click();
    }

    public void enterShippingDetails(String fullName, String address, String city, String postalCode, String phone) {
        waitUntilElementVisible(txtFullName);
        driver.findElement(txtFullName).sendKeys(fullName);
        driver.findElement(txtAddress).sendKeys(address);
        driver.findElement(txtCity).sendKeys(city);
        driver.findElement(txtPostalCode).sendKeys(postalCode);
        driver.findElement(txtPhone).sendKeys(phone);
    }

    public void selectPaymentMethod(String method) {
        waitUntilElementVisible(paymentMethodDropdown);
        WebElement dropdown = driver.findElement(paymentMethodDropdown);
        dropdown.findElement(By.xpath("//option[. = '" + method + "']")).click();
    }

    public void enterCreditCardDetails(String cardNumber, String expiryDate, String cvv) {
        waitUntilElementVisible(txtCardNumber);
        driver.findElement(txtCardNumber).sendKeys(cardNumber);
        driver.findElement(txtExpiryDate).sendKeys(expiryDate);
        driver.findElement(txtCVV).sendKeys(cvv);
    }

    public void placeOrder() {
        waitUntilElementVisible(btnPlaceOrder);
        driver.findElement(btnPlaceOrder).click();
    }

    public void verifyOrderConfirmation(String expectedMessage) {
        waitUntilElementVisible(orderConfirmationMessage);
        String actualMessage = driver.findElement(orderConfirmationMessage).getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Order confirmation message does not match.");
    }

    private void waitUntilElementVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}