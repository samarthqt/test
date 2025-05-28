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

    @FindBy(id = username)
    private WebElement usernameField;

    @FindBy(id = password)
    private WebElement passwordField;

    @FindBy(id = loginButton)
    private WebElement loginButton;

    @FindBy(linkText = Orders)
    private WebElement ordersModuleLink;

    @FindBy(xpath = //tr[td[text()='12345']])
    private WebElement orderRow;

    @FindBy(id = shipmentStatusDropdown)
    private WebElement shipmentStatusDropdown;

    @FindBy(xpath = //option[text()='Dispatched'])
    private WebElement dispatchedOption;

    @FindBy(id = saveButton)
    private WebElement saveButton;

    @FindBy(id = alertSystemLink)
    private WebElement alertSystemLink;

    @FindBy(id = customerAlert)
    private WebElement customerAlert;

    public Dynamics365Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    /**
     * Logs in to the Dynamics 365 application.
     *
     * @param username the username to enter
     * @param password the password to enter
     */
    public void login(String username, String password) {
        waitUntilVisible(usernameField).sendKeys(username);
        waitUntilVisible(passwordField).sendKeys(password);
        waitUntilClickable(loginButton).click();
    }

    /**
     * Navigates to the Orders module.
     */
    public void navigateToOrdersModule() {
        waitUntilClickable(ordersModuleLink).click();
    }

    /**
     * Selects an order with a specific ID.
     */
    public void selectOrderWithID() {
        waitUntilClickable(orderRow).click();
    }

    /**
     * Updates the shipment status to 'Dispatched'.
     */
    public void updateShipmentStatusToDispatched() {
        waitUntilClickable(shipmentStatusDropdown).click();
        waitUntilClickable(dispatchedOption).click();
        waitUntilClickable(saveButton).click();
    }

    /**
     * Checks the alert system.
     */
    public void checkAlertSystem() {
        waitUntilClickable(alertSystemLink).click();
    }

    /**
     * Verifies the customer alert message.
     *
     * @param expectedAlert the expected alert message
     * @return true if the alert message matches the expected message, false otherwise
     */
    public boolean verifyCustomerAlert(String expectedAlert) {
        String actualAlert = waitUntilVisible(customerAlert).getText();
        Assert.assertEquals(actualAlert, expectedAlert, Customer alert message does not match.);
        return actualAlert.equals(expectedAlert);
    }

    /**
     * Waits until the specified element is visible.
     *
     * @param element the WebElement to wait for
     * @return the visible WebElement
     */
    private WebElement waitUntilVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits until the specified element is clickable.
     *
     * @param element the WebElement to wait for
     * @return the clickable WebElement
     */
    private WebElement waitUntilClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}