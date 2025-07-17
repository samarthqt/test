package com.qt.pshop.pageobjs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class PartnerPage extends WebReusableComponents {

    @FindBy(id = "findPartnerButton")
    private WebElement findPartnerButton;

    @FindBy(id = "partnerPage")
    private WebElement partnerPage;

    @FindBy(id = "fullName")
    private WebElement txtFullName;

    @FindBy(id = "address")
    private WebElement txtAddress;

    @FindBy(id = "city")
    private WebElement txtCity;

    @FindBy(id = "postalCode")
    private WebElement txtPostalCode;

    @FindBy(id = "phone")
    private WebElement txtPhone;

    @FindBy(id = "paymentMethod")
    private WebElement paymentMethodDropdown;

    @FindBy(id = "cardNumber")
    private WebElement txtCardNumber;

    @FindBy(id = "expiryDate")
    private WebElement txtExpiryDate;

    @FindBy(id = "cvv")
    private WebElement txtCVV;

    @FindBy(id = "placeOrder")
    private WebElement btnPlaceOrder;

    @FindBy(id = "confirmationMessage")
    private WebElement orderConfirmationMessage;

    @FindBy(id = "proceedToCheckout")
    private WebElement btnProceedToCheckout;

    public PartnerPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickFindPartnerButton() {
        waitUntilElementVisible(findPartnerButton, 3);
        findPartnerButton.click();
    }

    public boolean isPartnerPageDisplayed() {
        waitUntilElementVisible(partnerPage, 3);
        boolean isDisplayed = partnerPage.isDisplayed();
        Assert.assertTrue(isDisplayed, "Partner page is not displayed.");
        return isDisplayed;
    }

    public void proceedToCheckout() {
        waitUntilElementVisible(btnProceedToCheckout, 3);
        btnProceedToCheckout.click();
    }

    public void enterShippingDetails(String fullName, String address, String city, String postalCode, String phone) {
        waitUntilElementVisible(txtFullName, 3);
        txtFullName.sendKeys(fullName);
        txtAddress.sendKeys(address);
        txtCity.sendKeys(city);
        txtPostalCode.sendKeys(postalCode);
        txtPhone.sendKeys(phone);
    }

    public void selectPaymentMethod(String paymentMethod) {
        waitUntilElementVisible(paymentMethodDropdown, 3);
        selectByValue(paymentMethodDropdown, paymentMethod);
    }

    public void enterCreditCardDetails(String cardNumber, String expiryDate, String cvv) {
        waitUntilElementVisible(txtCardNumber, 3);
        txtCardNumber.sendKeys(cardNumber);
        txtExpiryDate.sendKeys(expiryDate);
        txtCVV.sendKeys(cvv);
    }

    public void placeOrder() {
        waitUntilElementVisible(btnPlaceOrder, 3);
        btnPlaceOrder.click();
    }

    public void verifyOrderConfirmation(String expectedMessage) {
        waitUntilElementVisible(orderConfirmationMessage, 3);
        String actualMessage = orderConfirmationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Order confirmation message does not match.");
    }
}