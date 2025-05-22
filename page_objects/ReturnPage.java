package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

import .time.LocalDate;
import .time.format.DateTimeFormatter;
import .time.temporal.ChronoUnit;

public class ReturnPage extends WebReusableComponents {

    private WebDriver driver;
    private WebDriverWait wait;

    protected By accessCodeElement = By.id(accessCode);
    protected By purchaseDateElement = By.id(purchaseDate);
    protected By loginEmailField = By.id(loginEmail);
    protected By loginPasswordField = By.id(loginPassword);
    protected By loginButton = By.id(loginButton);
    protected By dashboardElement = By.id(dashboard);
    protected By orderIdElement = By.id(orderId);
    protected By orderDetailsSection = By.id(orderDetails);
    protected By customerEmailElement = By.id(customerEmail);
    protected By orderDetailsElement = By.id(orderDetails87654);
    protected By initiateReturnButton = By.id(initiateReturn);
    protected By returnPeriodExpiredMessage = By.id(returnPeriodExpired);

    public ReturnPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void verifyAccessCodePurchased(String expectedAccessCode) {
        waitUntilElementVisible(accessCodeElement);
        String actualAccessCode = getTextFromElement(accessCodeElement);
        Assert.assertEquals(actualAccessCode, expectedAccessCode, Access code does not match.);
    }

    public void verifyPurchaseDate(String expectedDate) {
        waitUntilElementVisible(purchaseDateElement);
        String actualDate = getTextFromElement(purchaseDateElement);
        Assert.assertTrue(isDateOlderThan(actualDate, 14), Purchase date is not older than 14 days.);
    }

    public void loginToStore(String email, String password) {
        waitUntilElementVisible(loginEmailField);
        enterText(loginEmailField, email);
        enterText(loginPasswordField, password);
        clickElement(loginButton);
    }

    public void verifyDashboardDisplayed() {
        waitUntilElementVisible(dashboardElement);
        Assert.assertTrue(isElementVisible(dashboardElement), Dashboard is not displayed.);
    }

    public void verifyOrderID(String expectedOrderId) {
        waitUntilElementVisible(orderIdElement);
        String actualOrderId = getTextFromElement(orderIdElement);
        Assert.assertEquals(actualOrderId, expectedOrderId, Order ID does not match.);
    }

    public void navigateToOrderDetails() {
        waitUntilElementVisible(orderDetailsSection);
        clickElement(orderDetailsSection);
    }

    public void verifyOrderDetailsDisplayed() {
        waitUntilElementVisible(orderDetailsSection);
        Assert.assertTrue(isElementVisible(orderDetailsSection), Order details are not displayed.);
    }

    public void verifyCustomerEmail(String expectedEmail) {
        waitUntilElementVisible(customerEmailElement);
        String actualEmail = getTextFromElement(customerEmailElement);
        Assert.assertEquals(actualEmail, expectedEmail, Customer email does not match.);
    }

    public void selectOrderById(String orderId) {
        waitUntilElementVisible(orderDetailsElement);
        clickElement(orderDetailsElement);
    }

    public void verifyOrderDetailsForId(String orderId) {
        waitUntilElementVisible(orderDetailsElement);
        Assert.assertTrue(isElementVisible(orderDetailsElement), Order details for ID  + orderId +  are not displayed.);
    }

    public void verifyAccessCode(String expectedAccessCode) {
        waitUntilElementVisible(accessCodeElement);
        String actualAccessCode = getTextFromElement(accessCodeElement);
        Assert.assertEquals(actualAccessCode, expectedAccessCode, Access code does not match.);
    }

    public void attemptToInitiateReturn() {
        waitUntilElementVisible(initiateReturnButton);
        clickElement(initiateReturnButton);
    }

    public void verifyReturnButtonDisabled() {
        waitUntilElementVisible(initiateReturnButton);
        Assert.assertFalse(isElementEnabled(initiateReturnButton), Initiate Return button is enabled.);
    }

    public void verifyReturnNotAllowed() {
        Assert.assertFalse(isElementEnabled(initiateReturnButton), Return initiation is allowed.);
    }

    public void verifyReturnPeriodExpiredNotification() {
        waitUntilElementVisible(returnPeriodExpiredMessage);
        String actualMessage = getTextFromElement(returnPeriodExpiredMessage);
        Assert.assertEquals(actualMessage, Return period has expired., Return period expired message does not match.);
    }

    private boolean isDateOlderThan(String date, int days) {
        LocalDate purchaseDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(yyyy-MM-dd));
        LocalDate currentDate = LocalDate.now();
        long daysBetween = ChronoUnit.DAYS.between(purchaseDate, currentDate);
        return daysBetween > days;
    }

    private void waitUntilElementVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private String getTextFromElement(By locator) {
        return driver.findElement(locator).getText();
    }

    private void enterText(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    private void clickElement(By locator) {
        driver.findElement(locator).click();
    }

    private boolean isElementVisible(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

    private boolean isElementEnabled(By locator) {
        return driver.findElement(locator).isEnabled();
    }
}