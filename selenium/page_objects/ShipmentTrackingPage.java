package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ShipmentTrackingPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public ShipmentTrackingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    // Page URL
    private final String pageUrl = http://example.com/shipment-tracking;

    // Locators
    private final By txtFullName = By.id(fullName);
    private final By txtAddress = By.id(address);
    private final By txtCity = By.id(city);
    private final By txtPostalCode = By.id(postalCode);
    private final By txtPhone = By.id(phone);
    private final By paymentMethodDropdown = By.id(paymentMethod);
    private final By txtCardNumber = By.id(cardNumber);
    private final By txtExpiryDate = By.id(expiryDate);
    private final By txtCVV = By.id(cvv);
    private final By btnPlaceOrder = By.id(placeOrder);
    private final By orderConfirmationMessage = By.id(orderConfirmationMessage);
    private final By btnProceedToCheckout = By.id(proceedToCheckout);

    // Navigate to Shipment Tracking Page
    public void navigateToPage() {
        driver.get(pageUrl);
        Assert.assertEquals(driver.getCurrentUrl(), pageUrl, Failed to navigate to Shipment Tracking Page);
    }

    // Proceed to Checkout
    public void proceedToCheckout() {
        waitUntilElementVisible(btnProceedToCheckout);
        driver.findElement(btnProceedToCheckout).click();
    }

    // Enter Shipping Details
    public void enterShippingDetails(String fullName, String address, String city, String postalCode, String phone) {
        waitUntilElementVisible(txtFullName);
        driver.findElement(txtFullName).sendKeys(fullName);
        driver.findElement(txtAddress).sendKeys(address);
        driver.findElement(txtCity).sendKeys(city);
        driver.findElement(txtPostalCode).sendKeys(postalCode);
        driver.findElement(txtPhone).sendKeys(phone);
    }

    // Select Payment Method
    public void selectPaymentMethod(String method) {
        waitUntilElementVisible(paymentMethodDropdown);
        WebElement dropdown = driver.findElement(paymentMethodDropdown);
        dropdown.click();
        dropdown.findElement(By.xpath(//option[@value=' + method + '])).click();
    }

    // Enter Credit Card Details
    public void enterCreditCardDetails(String cardNumber, String expiryDate, String cvv) {
        waitUntilElementVisible(txtCardNumber);
        driver.findElement(txtCardNumber).sendKeys(cardNumber);
        driver.findElement(txtExpiryDate).sendKeys(expiryDate);
        driver.findElement(txtCVV).sendKeys(cvv);
    }

    // Place Order
    public void placeOrder() {
        waitUntilElementVisible(btnPlaceOrder);
        driver.findElement(btnPlaceOrder).click();
    }

    // Verify Order Confirmation
    public void verifyOrderConfirmation(String expectedMessage) {
        waitUntilElementVisible(orderConfirmationMessage);
        String actualMessage = driver.findElement(orderConfirmationMessage).getText();
        Assert.assertEquals(actualMessage, expectedMessage, Order confirmation message does not match);
    }

    // Helper method to wait until an element is visible
    private void waitUntilElementVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}