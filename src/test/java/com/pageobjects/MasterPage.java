package com.pageobjects;

import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.framework.cucumber.TestHarness;
import com.framework.reusable.WebReusableComponents;

public class MasterPage extends WebReusableComponents {

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
    protected By btnPlaceOrder = By.id("placeOrder");
    protected By orderConfirmationMessage = By.id("confirmationMessage");

    public MasterPage() {
        PageFactory.initElements(driver, this);
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

    public void selectPaymentMethod(String paymentMethod) {
        waitUntilElementVisible(paymentMethodDropdown, 3);
        selectByValue(paymentMethodDropdown, paymentMethod);
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

    public void enterCommonTextBox(By locator, String text) {
        waitUntilElementVisible(locator, 3);
        enterText(locator, text);
    }

    public void selectDropdownById(By locator, String value) {
        waitUntilElementVisible(locator, 3);
        selectByValue(locator, value);
    }

    public void clickCommonButton(By locator) {
        waitUntilElementVisible(locator, 3);
        clickElement(locator);
    }

    public void selectCommonDropdown(By locator, String value) {
        waitUntilElementVisible(locator, 3);
        selectByValue(locator, value);
    }

    public void sendKeysToWindow(String keys) {
        driver.switchTo().activeElement().sendKeys(keys);
    }

    public void skip_popup_multilanguages() {
        // Implementation for skipping popup
    }

    public void uploadFileInNachweise(By locator, String filePath) {
        waitUntilElementVisible(locator, 3);
        driver.findElement(locator).sendKeys(filePath);
    }

    public void clickTextBoxById(By locator) {
        waitUntilElementVisible(locator, 3);
        clickElement(locator);
    }

    public void clickCommonButton_Index(By locator) {
        waitUntilElementVisible(locator, 3);
        clickElement(locator);
    }

    public void moveToElementByXpath(By locator) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(locator)).perform();
    }

    public void setCheckBoxById(By locator, boolean value) {
        WebElement checkbox = driver.findElement(locator);
        if (checkbox.isSelected() != value) {
            checkbox.click();
        }
    }

    public void enterCommonTextBox_2(By locator, String text) {
        waitUntilElementVisible(locator, 3);
        enterText(locator, text);
    }

    public void clickElementByXpath(By locator) {
        waitUntilElementVisible(locator, 3);
        clickElement(locator);
    }

    public boolean isLabelManageAttachments(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

    public void downloadXML(By locator) {
        waitUntilElementVisible(locator, 3);
        clickElement(locator);
    }

    public void setValueByXpath(By locator, String value) {
        waitUntilElementVisible(locator, 3);
        enterText(locator, value);
    }

    public void clickeWeiter(By locator) {
        waitUntilElementVisible(locator, 3);
        clickElement(locator);
    }

    public void updatePrefix(String prefix) {
        // Implementation for updating prefix
    }

    public void handlePageLoading() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));
    }

    public void clickAttachmentClose(By locator) {
        waitUntilElementVisible(locator, 3);
        clickElement(locator);
    }

    public void selectCommonDropdown_2(By locator, String value) {
        waitUntilElementVisible(locator, 3);
        selectByValue(locator, value);
    }

    public void clickButtonById(By locator) {
        waitUntilElementVisible(locator, 3);
        clickElement(locator);
    }

    public void clickeWeiterDemoR(By locator) {
        waitUntilElementVisible(locator, 3);
        clickElement(locator);
    }

    public void downloadPDF(By locator) {
        waitUntilElementVisible(locator, 3);
        clickElement(locator);
    }

    public void clickCommonRadioButton_2(By locator) {
        waitUntilElementVisible(locator, 3);
        clickElement(locator);
    }

    public void clickCommonRadioButton(By locator) {
        waitUntilElementVisible(locator, 3);
        clickElement(locator);
    }

    public void uploadFile(By locator, String filePath) {
        waitUntilElementVisible(locator, 3);
        driver.findElement(locator).sendKeys(filePath);
    }

    public void setCommonCheckBoxOnOff(By locator, boolean value) {
        WebElement checkbox = driver.findElement(locator);
        if (checkbox.isSelected() != value) {
            checkbox.click();
        }
    }

    public void disablePrefix() {
        // Implementation for disabling prefix
    }

    public void assertElementWithTextLocated(By locator, String text) {
        String elementText = driver.findElement(locator).getText();
        Assert.assertEquals(elementText, text, "Text does not match.");
    }

    public void clickRadioButtonById(By locator) {
        waitUntilElementVisible(locator, 3);
        clickElement(locator);
    }

    public void enterTextBoxById(By locator, String text) {
        waitUntilElementVisible(locator, 3);
        enterText(locator, text);
    }
}