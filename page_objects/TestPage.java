
package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class TestPage extends WebReusableComponents {

    private final WebDriver driver;
    private final WebDriverWait wait;

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

    public TestPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void performTestStep(String testStep) {
        switch (testStep) {
            case login:
                enterUserName(testUser);
                enterPassword(testPass);
                clickLoginButton();
                break;
            case checkout:
                proceedToCheckout();
                enterShippingDetails(John Doe, 123 Main St, Anytown, 12345, 555-5555);
                selectPaymentMethod(CreditCard);
                placeOrder();
                break;
            default:
                throw new IllegalArgumentException(Unknown test step:  + testStep);
        }
    }

    public boolean verifyExpectedResult(String expectedResult) {
        switch (expectedResult) {
            case homepage:
                String currentURL = driver.getCurrentUrl();
                Assert.assertEquals(currentURL, http://expectedhomepage.com, User is not redirected to the homepage.);
                return true;
            case orderConfirmation:
                waitUntilElementVisible(orderConfirmationMessage);
                String actualMessage = driver.findElement(orderConfirmationMessage).getText();
                Assert.assertEquals(actualMessage, Order confirmed!, Order confirmation message does not match.);
                return true;
            default:
                throw new IllegalArgumentException(Unknown expected result:  + expectedResult);
        }
    }

    private void enterUserName(String username) {
        waitUntilElementVisible(txtUserName);
        driver.findElement(txtUserName).sendKeys(username);
    }

    private void enterPassword(String password) {
        waitUntilElementVisible(txtPassword);
        driver.findElement(txtPassword).sendKeys(password);
    }

    private void clickLoginButton() {
        waitUntilElementVisible(btnLogin);
        driver.findElement(btnLogin).click();
    }

    private void proceedToCheckout() {
        waitUntilElementVisible(btnProceedToCheckout);
        driver.findElement(btnProceedToCheckout).click();
    }

    private void enterShippingDetails(String fullName, String address, String city, String postalCode, String phone) {
        waitUntilElementVisible(txtFullName);
        driver.findElement(txtFullName).sendKeys(fullName);
        driver.findElement(txtAddress).sendKeys(address);
        driver.findElement(txtCity).sendKeys(city);
        driver.findElement(txtPostalCode).sendKeys(postalCode);
        driver.findElement(txtPhone).sendKeys(phone);
    }

    private void selectPaymentMethod(String paymentMethod) {
        waitUntilElementVisible(paymentMethodDropdown);
        WebElement dropdown = driver.findElement(paymentMethodDropdown);
        dropdown.findElement(By.xpath(//option[@value=' + paymentMethod + '])).click();
    }

    private void placeOrder() {
        waitUntilElementVisible(btnPlaceOrder);
        driver.findElement(btnPlaceOrder).click();
    }

    private void waitUntilElementVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
