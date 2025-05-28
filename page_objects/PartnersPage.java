
package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PartnersPage {

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

    public PartnersPage(final WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void openPage() {
        driver.get(http://www.qasymphony.com/partners.html);
        Assert.assertEquals(driver.getTitle(), Partners - QASymphony, Page title does not match);
    }

    public void clickFindPartnerButton() {
        waitUntilElementVisible(findPartnerButton);
        findPartnerButton.click();
        Assert.assertTrue(driver.getCurrentUrl().contains(partners), URL does not contain 'partners');
    }

    public void enterUserName(final String username) {
        waitUntilElementVisible(txtUserName);
        txtUserName.sendKeys(username);
    }

    public void enterPassword(final String password) {
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

    public void enterShippingDetails(final String fullName, final String address, final String city, final String postalCode, final String phone) {
        waitUntilElementVisible(txtFullName);
        txtFullName.sendKeys(fullName);
        txtAddress.sendKeys(address);
        txtCity.sendKeys(city);
        txtPostalCode.sendKeys(postalCode);
        txtPhone.sendKeys(phone);
    }

    public void selectPaymentMethod(final String paymentMethod) {
        waitUntilElementVisible(paymentMethodDropdown);
        paymentMethodDropdown.sendKeys(paymentMethod);
    }

    public void placeOrder() {
        waitUntilElementVisible(btnPlaceOrder);
        btnPlaceOrder.click();
    }

    public void verifyOrderConfirmation(final String expectedMessage) {
        waitUntilElementVisible(orderConfirmationMessage);
        String actualMessage = orderConfirmationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, Order confirmation message does not match);
    }

    private void waitUntilElementVisible(final WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
