package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Dynamics365Page {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Login elements
    @FindBy(id = username)
    private WebElement usernameField;

    @FindBy(id = password)
    private WebElement passwordField;

    @FindBy(id = loginButton)
    private WebElement loginButton;

    // Navigation elements
    @FindBy(xpath = //a[@href='/orders'])
    private WebElement ordersModuleLink;

    // Order elements
    @FindBy(xpath = //tr[td[text()='12345']]//input[@type='checkbox'])
    private WebElement orderCheckbox;

    @FindBy(id = updateShipmentStatusButton)
    private WebElement updateShipmentStatusButton;

    @FindBy(id = shipmentStatusDropdown)
    private WebElement shipmentStatusDropdown;

    @FindBy(xpath = //option[@value='Dispatched'])
    private WebElement dispatchedOption;

    // Alert system elements
    @FindBy(id = alertSystemLink)
    private WebElement alertSystemLink;

    @FindBy(xpath = //div[@id='alerts']//div[contains(text(), 'Customer Alert')])
    private WebElement customerAlert;

    public Dynamics365Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    /**
     * Logs in to the application using the provided username and password.
     *
     * @param username the username to log in with
     * @param password the password to log in with
     */
    public void login(String username, String password) {
        wait.until(ExpectedConditions.visibilityOf(usernameField)).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        Assert.assertTrue(driver.getCurrentUrl().contains(dashboard), Login failed, dashboard not reached.);
    }

    /**
     * Navigates to the Orders module.
     */
    public void navigateToOrdersModule() {
        wait.until(ExpectedConditions.elementToBeClickable(ordersModuleLink)).click();
        Assert.assertTrue(driver.getCurrentUrl().contains(orders), Navigation to Orders module failed.);
    }

    /**
     * Selects the order with ID 12345.
     */
    public void selectOrderWithId12345() {
        wait.until(ExpectedConditions.elementToBeClickable(orderCheckbox)).click();
        Assert.assertTrue(orderCheckbox.isSelected(), Order with ID 12345 was not selected.);
    }

    /**
     * Updates the shipment status to 'Dispatched'.
     */
    public void updateShipmentStatusToDispatched() {
        wait.until(ExpectedConditions.elementToBeClickable(updateShipmentStatusButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(shipmentStatusDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(dispatchedOption)).click();
        Assert.assertTrue(dispatchedOption.isSelected(), Shipment status was not updated to Dispatched.);
    }

    /**
     * Checks the alert system for outgoing alerts.
     */
    public void checkAlertSystemForOutgoingAlerts() {
        wait.until(ExpectedConditions.elementToBeClickable(alertSystemLink)).click();
        Assert.assertTrue(driver.getCurrentUrl().contains(alerts), Navigation to Alert System failed.);
    }

    /**
     * Verifies if an alert has been received by the customer.
     *
     * @return true if the customer alert is displayed, false otherwise
     */
    public boolean verifyAlertReceivedByCustomer() {
        boolean isAlertDisplayed = wait.until(ExpectedConditions.visibilityOf(customerAlert)).isDisplayed();
        Assert.assertTrue(isAlertDisplayed, Customer alert was not received.);
        return isAlertDisplayed;
    }
}