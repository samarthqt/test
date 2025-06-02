package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;

public class PartnerPage extends WebReusableComponents {

    private final By btnFindPartner = By.id("findPartnerButton");
    private final By txtUserName = By.id("username");
    private final By txtPassword = By.id("password");
    private final By btnLogin = By.id("loginButton");
    private final By btnProceedToCheckout = By.id("proceedToCheckout");
    private final By txtFullName = By.id("fullName");
    private final By txtAddress = By.id("address");
    private final By txtCity = By.id("city");
    private final By txtPostalCode = By.id("postalCode");
    private final By txtPhone = By.id("phone");
    private final By paymentMethodDropdown = By.id("paymentMethod");
    private final By btnPlaceOrder = By.id("placeOrder");
    private final By orderConfirmationMessage = By.id("confirmationMessage");

    public PartnerPage() {
        PageFactory.initElements(driver, this);
    }

    public void openNewBrowserWindow() {
        openNewWindow();
        Assert.assertTrue(isNewWindowOpened(), "New browser window was not opened successfully.");
    }

    public void enterPartnerPageUrl() {
        navigateToUrl("http://www.qasymphony.com/partners.html");
        Assert.assertEquals(getCurrentURL(), "http://www.qasymphony.com/partners.html", "URL does not match the expected Partner Page URL.");
    }

    public void clickFindPartnerButton() {
        waitUntilElementVisible(btnFindPartner, 3);
        clickElement(btnFindPartner);
        Assert.assertTrue(isElementVisible(btnFindPartner), "Find Partner button was not clicked successfully.");
    }

    public void enterUserName(String username) {
        waitUntilElementVisible(txtUserName, 3);
        enterText(txtUserName, username);
        Assert.assertEquals(getTextFromElement(txtUserName), username, "Username was not entered correctly.");
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, password);
        Assert.assertEquals(getTextFromElement(txtPassword), password, "Password was not entered correctly.");
    }

    public void clickLoginButton() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
        Assert.assertTrue(isElementVisible(btnLogin), "Login button was not clicked successfully.");
    }

    public void proceedToCheckout() {
        waitUntilElementVisible(btnProceedToCheckout, 3);
        clickElement(btnProceedToCheckout);
        Assert.assertTrue(isElementVisible(btnProceedToCheckout), "Proceed to Checkout button was not clicked successfully.");
    }

    public void enterShippingDetails(String fullName, String address, String city, String postalCode, String phone) {
        waitUntilElementVisible(txtFullName, 3);
        enterText(txtFullName, fullName);
        enterText(txtAddress, address);
        enterText(txtCity, city);
        enterText(txtPostalCode, postalCode);
        enterText(txtPhone, phone);
        Assert.assertTrue(isElementVisible(txtFullName), "Shipping details were not entered correctly.");
    }

    public void selectPaymentMethod(String paymentMethod) {
        waitUntilElementVisible(paymentMethodDropdown, 3);
        selectByValue(paymentMethodDropdown, paymentMethod);
        Assert.assertTrue(isElementVisible(paymentMethodDropdown), "Payment method was not selected correctly.");
    }

    public void placeOrder() {
        waitUntilElementVisible(btnPlaceOrder, 3);
        clickElement(btnPlaceOrder);
        Assert.assertTrue(isElementVisible(btnPlaceOrder), "Place Order button was not clicked successfully.");
    }

    public void verifyOrderConfirmation(String expectedMessage) {
        waitUntilElementVisible(orderConfirmationMessage, 3);
        String actualMessage = getTextFromElement(orderConfirmationMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Order confirmation message does not match.");
    }
}