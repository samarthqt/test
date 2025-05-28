package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PartnersPage extends WebReusableComponents {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(linkText = Find a Partner)
    private WebElement findPartnerButton;

    @FindBy(id = username)
    private WebElement txtUserName;

    @FindBy(id = password)
    private WebElement txtPassword;

    @FindBy(id = loginButton)
    private WebElement btnLogin;

    @FindBy(id = proceedToCheckout)
    private WebElement btnProceedToCheckout;

    @FindBy(id = fullName)
    private WebElement txtFullName;

    @FindBy(id = address)
    private WebElement txtAddress;

    @FindBy(id = city)
    private WebElement txtCity;

    @FindBy(id = postalCode)
    private WebElement txtPostalCode;

    @FindBy(id = phone)
    private WebElement txtPhone;

    @FindBy(id = paymentMethod)
    private WebElement paymentMethodDropdown;

    @FindBy(id = placeOrder)
    private WebElement btnPlaceOrder;

    @FindBy(id = confirmationMessage)
    private WebElement orderConfirmationMessage;

    public PartnersPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void openPage() {
        driver.get(http://www.qasymphony.com/partners.html);
        Assert.assertEquals(driver.getTitle(), Partners - QASymphony, Page title does not match.);
    }

    public void clickFindPartnerButton() {
        waitUntilElementVisible(findPartnerButton);
        findPartnerButton.click();
        Assert.assertTrue(driver.getCurrentUrl().contains(partners), URL does not contain 'partners'.);
    }

    public void enterUserName(String username) {
        waitUntilElementVisible(txtUserName);
        txtUserName.sendKeys(username);
        Assert.assertEquals(txtUserName.getAttribute(value), username, Username input does not match.);
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword);
        txtPassword.sendKeys(password);
        Assert.assertEquals(txtPassword.getAttribute(value), password, Password input does not match.);
    }

    public void clickLoginButton() {
        waitUntilElementVisible(btnLogin);
        btnLogin.click();
        Assert.assertTrue(driver.getCurrentUrl().contains(homepage), User is not redirected to the homepage.);
    }

    public void proceedToCheckout() {
        waitUntilElementVisible(btnProceedToCheckout);
        btnProceedToCheckout.click();
        Assert.assertTrue(driver.getCurrentUrl().contains(checkout), User is not redirected to checkout.);
    }

    public void enterShippingDetails(String fullName, String address, String city, String postalCode, String phone) {
        waitUntilElementVisible(txtFullName);
        txtFullName.sendKeys(fullName);
        txtAddress.sendKeys(address);
        txtCity.sendKeys(city);
        txtPostalCode.sendKeys(postalCode);
        txtPhone.sendKeys(phone);
        Assert.assertTrue(txtFullName.getAttribute(value).equals(fullName) &&
                          txtAddress.getAttribute(value).equals(address) &&
                          txtCity.getAttribute(value).equals(city) &&
                          txtPostalCode.getAttribute(value).equals(postalCode) &&
                          txtPhone.getAttribute(value).equals(phone), Shipping details do not match.);
    }

    public void selectPaymentMethod(String paymentMethod) {
        waitUntilElementVisible(paymentMethodDropdown);
        paymentMethodDropdown.sendKeys(paymentMethod);
        Assert.assertEquals(paymentMethodDropdown.getAttribute(value), paymentMethod, Payment method does not match.);
    }

    public void placeOrder() {
        waitUntilElementVisible(btnPlaceOrder);
        btnPlaceOrder.click();
        Assert.assertTrue(driver.getCurrentUrl().contains(orderConfirmation), User is not redirected to order confirmation.);
    }

    public void verifyOrderConfirmation(String expectedMessage) {
        waitUntilElementVisible(orderConfirmationMessage);
        String actualMessage = orderConfirmationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, Order confirmation message does not match.);
    }

    private void waitUntilElementVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}