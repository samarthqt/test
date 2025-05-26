package com.dynamics365.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersPage {

    WebDriver driver;

    // Constructor
    public OrdersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Web Elements
    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    @FindBy(id = "ordersModule")
    private WebElement ordersModule;

    @FindBy(xpath = "//tr[td[text()='98765']]")
    private WebElement order98765;

    @FindBy(id = "shipmentStatus")
    private WebElement shipmentStatusDropdown;

    @FindBy(xpath = "//option[text()='Dispatched']")
    private WebElement dispatchedOption;

    @FindBy(id = "saveButton")
    private WebElement saveButton;

    @FindBy(id = "alertSystem")
    private WebElement alertSystem;

    @FindBy(id = "customerAlerts")
    private WebElement customerAlerts;

    // Actions
    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void navigateToOrdersModule() {
        ordersModule.click();
    }

    public void selectOrder98765() {
        order98765.click();
    }

    public void updateShipmentStatusToDispatched() {
        shipmentStatusDropdown.click();
        dispatchedOption.click();
        saveButton.click();
    }

    public boolean checkAlertSystem() {
        return alertSystem.isDisplayed();
    }

    public boolean verifyCustomerAlerts() {
        return customerAlerts.isDisplayed();
    }
}