package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.*;

public class HybridWebPage extends WebReusableComponents {

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

    public HybridWebPage() {
        PageFactory.initElements(driver, this);
    }

    public void launchApp(String url) {
        launchUrl(url);
        maximizeWindow();
    }

    public void clickAcceptCookies() {
        clickElement(btnAcceptCookies);
    }

    public void verifyHomeScreen() {
        Assert.assertTrue(elementVisible(lblHeader, 20), "Home screen is not visible.");
    }

    public void clickOkButton() {
        if (elementVisible(btnOk)) {
            clickElement(btnOk);
        }
    }

    public void enterFistName(String firstname) {
        waitUntilElementVisible(txtFirstName, 3);
        enterText(txtFirstName, firstname);
    }

    public void enterLastName(String lastname) {
        waitUntilElementVisible(txtLastName, 3);
        enterText(txtLastName, lastname);
    }

    public void clickGender() {
        waitUntilElementVisible(btnGender, 3);
        clickElement(btnGender);
    }

    public void clickExperience() {
        waitUntilElementVisible(btnExp, 3);
        clickElement(btnExp);
    }

    public void clickProfession() {
        waitUntilElementVisible(btnProf, 3);
        clickElement(btnProf);
    }

    public void clickToolUFT() {
        waitUntilElementVisible(btnToolUFT, 3);
        clickElement(btnToolUFT);
    }

    public void clickToolProtractor() {
        waitUntilElementVisible(btnToolProtractor, 3);
        clickElement(btnToolProtractor);
    }

    public void clickToolSelenium() {
        waitUntilElementVisible(btnToolSelenium, 3);
        clickElement(btnToolSelenium);
    }

    public void selectCountry(String value) {
        waitUntilElementVisible(selectContinents, 3);
        selectByValue(selectContinents, value);
    }

    public void clickSubmit() {
        waitUntilElementVisible(btnSubmit, 3);
        clickElement(btnSubmit);
    }

    public void enterUserName(String username) {
        waitUntilElementVisible(txtUserName, 3);
        enterText(txtUserName, username);
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, password);
    }

    public void clickLoginButton() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    public void verifyHomePageRedirection(String expectedURL) {
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, expectedURL, "User is not redirected to the homepage.");
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
}