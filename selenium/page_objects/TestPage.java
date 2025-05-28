package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TestPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Constructor
    public TestPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    // WebElements
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

    // Actions
    public void enterUserName(String username) {
        waitUntilElementVisible(txtUserName);
        txtUserName.sendKeys(username);
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword);
        txtPassword.sendKeys(password);
    }

    public void clickLoginButton() {
        waitUntilElementVisible(btnLogin);
        btnLogin.click();
    }

    public void proceedToCheckout() {
        waitUntilElementVisible(btnProceedToCheckout);
        btnProceedToCheckout.click();
    }

    public void enterShippingDetails(String fullName, String address, String city, String postalCode, String phone) {
        waitUntilElementVisible(txtFullName);
        txtFullName.sendKeys(fullName);
        txtAddress.sendKeys(address);
        txtCity.sendKeys(city);
        txtPostalCode.sendKeys(postalCode);
        txtPhone.sendKeys(phone);
    }

    public void selectPaymentMethod(String paymentMethod) {
        waitUntilElementVisible(paymentMethodDropdown);
        paymentMethodDropdown.sendKeys(paymentMethod);
    }

    public void placeOrder() {
        waitUntilElementVisible(btnPlaceOrder);
        btnPlaceOrder.click();
    }

    // Validations
    public boolean isElementDisplayed(WebElement element) {
        waitUntilElementVisible(element);
        return element.isDisplayed();
    }

    public void verifyHomePageRedirection(String expectedURL) {
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, expectedURL, User is not redirected to the homepage.);
    }

    public void verifyOrderConfirmation(String expectedMessage) {
        waitUntilElementVisible(orderConfirmationMessage);
        String actualMessage = orderConfirmationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, Order confirmation message does not match.);
    }

    // Helper methods
    private void waitUntilElementVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}