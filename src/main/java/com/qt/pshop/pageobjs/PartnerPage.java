package com.qt.pshop.pageobjs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class PartnerPage extends WebReusableComponents {

    private final By btnFindPartner = By.id("findPartnerButton");
    private final By partnerPageContent = By.id("partnerPageContent");
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

    public void clickFindPartnerButton() {
        waitUntilElementVisible(btnFindPartner, 3);
        clickElement(btnFindPartner);
    }

    public boolean isPartnerPageDisplayed() {
        waitUntilElementVisible(partnerPageContent, 3);
        return isElementDisplayed(partnerPageContent);
    }

    public void proceedToCheckout() {
        waitUntilElementVisible(btnPlaceOrder, 3);
        clickElement(btnPlaceOrder);
    }

    public void enterShippingDetails(String fullName, String address, String city, String postalCode, String phone) {
        waitUntilElementVisible(txtFullName, 3);
        enterText(txtFullName, fullName);
        enterText(txtAddress, address);
        enterText(txtCity, city);
        enterText(txtPostalCode, postalCode);
        enterText(txtPhone, phone);
    }

    public void selectPaymentMethod(String paymentMethod) {
        waitUntilElementVisible(paymentMethodDropdown, 3);
        selectByValue(paymentMethodDropdown, paymentMethod);
    }

    public void verifyOrderConfirmation(String expectedMessage) {
        waitUntilElementVisible(orderConfirmationMessage, 3);
        String actualMessage = getTextFromElement(orderConfirmationMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Order confirmation message does not match.");
    }

    private void waitUntilElementVisible(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void clickElement(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    private void enterText(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    private void selectByValue(By locator, String value) {
        WebElement element = driver.findElement(locator);
        element.sendKeys(value);
    }

    private boolean isElementDisplayed(By locator) {
        WebElement element = driver.findElement(locator);
        return element.isDisplayed();
    }

    private String getTextFromElement(By locator) {
        WebElement element = driver.findElement(locator);
        return element.getText();
    }
}