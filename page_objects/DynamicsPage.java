package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class DynamicsPage extends WebReusableComponents {

    private WebDriver driver;
    private WebDriverWait wait;

    protected By ordersModule = By.id(ordersModule);
    protected By orderIDField = By.id(orderID);
    protected By shipmentStatusDropdown = By.id(shipmentStatus);
    protected By usernameField = By.id(username);
    protected By passwordField = By.id(password);
    protected By loginButton = By.id(loginButton);
    protected By selectOrderButton = By.id(selectOrderButton);
    protected By updateStatusButton = By.id(updateStatusButton);
    protected By orderExists = By.id(orderExists);

    public DynamicsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void loginToDynamics(String username, String password) {
        enterText(usernameField, username);
        enterText(passwordField, password);
        clickElement(loginButton);
        Assert.assertTrue(isElementPresent(ordersModule), Login failed, Orders module not visible.);
    }

    public void navigateToOrdersModule() {
        waitUntilElementVisible(ordersModule, 3);
        clickElement(ordersModule);
        Assert.assertTrue(isElementPresent(orderIDField), Navigation to Orders module failed.);
    }

    public void selectOrder(String orderID) {
        navigateToOrdersModule();
        waitUntilElementVisible(orderIDField, 3);
        enterText(orderIDField, orderID);
        clickElement(selectOrderButton);
        Assert.assertTrue(isElementPresent(orderExists), Order selection failed, Order does not exist.);
    }

    public void updateShipmentStatus(String orderID, String status) {
        selectOrder(orderID);
        waitUntilElementVisible(shipmentStatusDropdown, 3);
        selectByValue(shipmentStatusDropdown, status);
        clickElement(updateStatusButton);
        Assert.assertTrue(isElementPresent(By.xpath(//div[text()=' + status + '])), Shipment status update failed.);
    }

    public boolean checkOrderExists(String orderID) {
        navigateToOrdersModule();
        enterText(orderIDField, orderID);
        return isElementPresent(orderExists);
    }

    public boolean checkCustomerSubscription(String email) {
        return isElementPresent(By.xpath(//div[text()=' + email + ']/following-sibling::div[@class='subscriptionStatus']));
    }

    public boolean checkAlertSent(String email) {
        return isElementPresent(By.xpath(//div[text()=' + email + ']/following-sibling::div[@class='alertStatus']));
    }

    public boolean checkEmailInbox(String email) {
        return isElementPresent(By.xpath(//div[text()=' + email + ']/following-sibling::div[@class='inboxStatus']));
    }

    private void waitUntilElementVisible(By locator, int timeout) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void enterText(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    private void clickElement(By locator) {
        driver.findElement(locator).click();
    }

    private boolean isElementPresent(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    private void selectByValue(By locator, String value) {
        WebElement dropdown = driver.findElement(locator);
        dropdown.findElement(By.xpath(//option[@value=' + value + '])).click();
    }
}