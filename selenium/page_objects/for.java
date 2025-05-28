package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UnifiedPageObjects {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locator declarations
    private final By txtUserName = By.id(username);
    private final By txtPassword = By.id(password);
    private final By btnLogin = By.id(loginButton);
    private final By btnProceedToCheckout = By.id(proceedToCheckout);
    private final By txtFullName = By.id(fullName);
    private final By txtAddress = By.id(address);
    private final By txtCity = By.id(city);
    private final By txtPostalCode = By.id(postalCode);
    private final By txtPhone = By.id(phone);
    private final By paymentMethodDropdown = By.id(paymentMethod);
    private final By btnPlaceOrder = By.id(placeOrder);
    private final By orderConfirmationMessage = By.id(confirmationMessage);

    // Constructor with PageFactory initialization
    public UnifiedPageObjects(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    // Action methods
    public void enterUserName(String username) {
        waitUntilElementVisible(txtUserName);
        driver.findElement(txtUserName).sendKeys(username);
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword);
        driver.findElement(txtPassword).sendKeys(password);
    }

    public void clickLoginButton() {
        waitUntilElementVisible(btnLogin);
        driver.findElement(btnLogin).click();
    }

    public void proceedToCheckout() {
        waitUntilElementVisible(btnProceedToCheckout);
        driver.findElement(btnProceedToCheckout).click();
    }

    public void enterShippingDetails(String fullName, String address, String city, String postalCode, String phone) {
        waitUntilElementVisible(txtFullName);
        driver.findElement(txtFullName).sendKeys(fullName);
        driver.findElement(txtAddress).sendKeys(address);
        driver.findElement(txtCity).sendKeys(city);
        driver.findElement(txtPostalCode).sendKeys(postalCode);
        driver.findElement(txtPhone).sendKeys(phone);
    }

    public void selectPaymentMethod(String paymentMethod) {
        waitUntilElementVisible(paymentMethodDropdown);
        WebElement dropdown = driver.findElement(paymentMethodDropdown);
        dropdown.findElement(By.xpath(//option[@value=' + paymentMethod + '])).click();
    }

    public void placeOrder() {
        waitUntilElementVisible(btnPlaceOrder);
        driver.findElement(btnPlaceOrder).click();
    }

    public void verifyOrderConfirmation(String expectedMessage) {
        waitUntilElementVisible(orderConfirmationMessage);
        String actualMessage = driver.findElement(orderConfirmationMessage).getText();
        Assert.assertEquals(actualMessage, expectedMessage, Order confirmation message does not match.);
    }

    // Helper methods
    private void waitUntilElementVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public void verifyHomePageRedirection(String expectedURL) {
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, expectedURL, User is not redirected to the homepage.);
    }
}