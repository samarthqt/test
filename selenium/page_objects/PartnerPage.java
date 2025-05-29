package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class PartnerPage extends WebReusableComponents {

    private WebDriver driver;
    private WebDriverWait wait;

    protected By btnFindPartner = By.id(findPartnerButton);
    protected By txtUserName = By.id(username);
    protected By txtPassword = By.id(password);
    protected By btnLogin = By.id(loginButton);
    protected By txtFullName = By.id(fullName);
    protected By txtAddress = By.id(address);
    protected By txtCity = By.id(city);
    protected By txtPostalCode = By.id(postalCode);
    protected By txtPhone = By.id(phone);
    protected By paymentMethodDropdown = By.id(paymentMethod);
    protected By txtCardNumber = By.id(cardNumber);
    protected By txtExpiryDate = By.id(expiryDate);
    protected By txtCVV = By.id(cvv);
    protected By btnPlaceOrder = By.id(placeOrder);
    protected By orderConfirmationMessage = By.id(orderConfirmationMessage);

    public PartnerPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void openNewBrowserWindow() {
        driver.switchTo().newWindow(WebDriver.WindowType.WINDOW);
        Assert.assertNotNull(driver.getWindowHandle(), Failed to open a new browser window.);
    }

    public void enterUrl(String url) {
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url, URL navigation failed.);
    }

    public void clickFindPartnerButton() {
        waitUntilElementVisible(btnFindPartner, 3);
        WebElement findPartnerButton = driver.findElement(btnFindPartner);
        findPartnerButton.click();
        Assert.assertTrue(findPartnerButton.isDisplayed(), Find Partner button is not visible after click.);
    }

    public void enterUserName(String username) {
        waitUntilElementVisible(txtUserName, 3);
        WebElement userNameField = driver.findElement(txtUserName);
        userNameField.sendKeys(username);
        Assert.assertEquals(userNameField.getAttribute(value), username, Username entry failed.);
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword, 3);
        WebElement passwordField = driver.findElement(txtPassword);
        passwordField.sendKeys(password);
        Assert.assertEquals(passwordField.getAttribute(value), password, Password entry failed.);
    }

    public void clickLoginButton() {
        waitUntilElementVisible(btnLogin, 3);
        WebElement loginButton = driver.findElement(btnLogin);
        loginButton.click();
        Assert.assertTrue(loginButton.isDisplayed(), Login button is not visible after click.);
    }

    public void enterShippingDetails(String fullName, String address, String city, String postalCode, String phone) {
        waitUntilElementVisible(txtFullName, 3);
        driver.findElement(txtFullName).sendKeys(fullName);
        driver.findElement(txtAddress).sendKeys(address);
        driver.findElement(txtCity).sendKeys(city);
        driver.findElement(txtPostalCode).sendKeys(postalCode);
        driver.findElement(txtPhone).sendKeys(phone);
        Assert.assertTrue(driver.findElement(txtFullName).getAttribute(value).equals(fullName), Full name entry failed.);
    }

    public void selectPaymentMethod(String method) {
        waitUntilElementVisible(paymentMethodDropdown, 3);
        WebElement paymentDropdown = driver.findElement(paymentMethodDropdown);
        paymentDropdown.sendKeys(method);
        Assert.assertEquals(paymentDropdown.getAttribute(value), method, Payment method selection failed.);
    }

    public void enterCreditCardDetails(String cardNumber, String expiryDate, String cvv) {
        waitUntilElementVisible(txtCardNumber, 3);
        driver.findElement(txtCardNumber).sendKeys(cardNumber);
        driver.findElement(txtExpiryDate).sendKeys(expiryDate);
        driver.findElement(txtCVV).sendKeys(cvv);
        Assert.assertTrue(driver.findElement(txtCardNumber).getAttribute(value).equals(cardNumber), Card number entry failed.);
    }

    public void placeOrder() {
        waitUntilElementVisible(btnPlaceOrder, 3);
        WebElement placeOrderButton = driver.findElement(btnPlaceOrder);
        placeOrderButton.click();
        Assert.assertTrue(placeOrderButton.isDisplayed(), Place Order button is not visible after click.);
    }

    public void verifyOrderConfirmation(String expectedMessage) {
        waitUntilElementVisible(orderConfirmationMessage, 3);
        String actualMessage = driver.findElement(orderConfirmationMessage).getText();
        Assert.assertEquals(actualMessage, expectedMessage, Order confirmation message does not match.);
    }

    private void waitUntilElementVisible(By locator, int timeout) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}