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
    protected By btnProceedToCheckout = By.id(proceedToCheckout);
    protected By txtFullName = By.id(fullName);
    protected By txtAddress = By.id(address);
    protected By txtCity = By.id(city);
    protected By txtPostalCode = By.id(postalCode);
    protected By txtPhone = By.id(phone);
    protected By paymentMethodDropdown = By.id(paymentMethod);
    protected By btnPlaceOrder = By.id(placeOrder);
    protected By orderConfirmationMessage = By.id(confirmationMessage);

    public PartnerPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void openNewBrowserWindow() {
        driver.switchTo().newWindow(WebDriver.WindowType.WINDOW);
        Assert.assertNotNull(driver.getWindowHandle(), Failed to open new browser window.);
    }

    public void enterPartnerPageUrl() {
        driver.navigate().to(http://www.qasymphony.com/partners.html);
        Assert.assertEquals(driver.getCurrentUrl(), http://www.qasymphony.com/partners.html, URL does not match the expected Partner Page URL.);
    }

    public void clickFindPartnerButton() {
        waitUntilElementVisible(btnFindPartner);
        WebElement findPartnerButton = driver.findElement(btnFindPartner);
        findPartnerButton.click();
        Assert.assertTrue(findPartnerButton.isDisplayed(), Find Partner button is not visible after click.);
    }

    public void enterUserName(String username) {
        waitUntilElementVisible(txtUserName);
        WebElement userNameField = driver.findElement(txtUserName);
        userNameField.sendKeys(username);
        Assert.assertEquals(userNameField.getAttribute(value), username, Username input does not match.);
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword);
        WebElement passwordField = driver.findElement(txtPassword);
        passwordField.sendKeys(password);
        Assert.assertEquals(passwordField.getAttribute(value), password, Password input does not match.);
    }

    public void clickLoginButton() {
        waitUntilElementVisible(btnLogin);
        WebElement loginButton = driver.findElement(btnLogin);
        loginButton.click();
        Assert.assertTrue(loginButton.isDisplayed(), Login button is not visible after click.);
    }

    public void proceedToCheckout() {
        waitUntilElementVisible(btnProceedToCheckout);
        WebElement proceedButton = driver.findElement(btnProceedToCheckout);
        proceedButton.click();
        Assert.assertTrue(proceedButton.isDisplayed(), Proceed to Checkout button is not visible after click.);
    }

    public void enterShippingDetails(String fullName, String address, String city, String postalCode, String phone) {
        waitUntilElementVisible(txtFullName);
        driver.findElement(txtFullName).sendKeys(fullName);
        driver.findElement(txtAddress).sendKeys(address);
        driver.findElement(txtCity).sendKeys(city);
        driver.findElement(txtPostalCode).sendKeys(postalCode);
        driver.findElement(txtPhone).sendKeys(phone);
        Assert.assertEquals(driver.findElement(txtFullName).getAttribute(value), fullName, Full Name input does not match.);
    }

    public void selectPaymentMethod(String paymentMethod) {
        waitUntilElementVisible(paymentMethodDropdown);
        WebElement paymentDropdown = driver.findElement(paymentMethodDropdown);
        paymentDropdown.sendKeys(paymentMethod);
        Assert.assertEquals(paymentDropdown.getAttribute(value), paymentMethod, Payment method selection does not match.);
    }

    public void placeOrder() {
        waitUntilElementVisible(btnPlaceOrder);
        WebElement placeOrderButton = driver.findElement(btnPlaceOrder);
        placeOrderButton.click();
        Assert.assertTrue(placeOrderButton.isDisplayed(), Place Order button is not visible after click.);
    }

    public void verifyOrderConfirmation(String expectedMessage) {
        waitUntilElementVisible(orderConfirmationMessage);
        String actualMessage = driver.findElement(orderConfirmationMessage).getText();
        Assert.assertEquals(actualMessage, expectedMessage, Order confirmation message does not match.);
    }

    private void waitUntilElementVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}