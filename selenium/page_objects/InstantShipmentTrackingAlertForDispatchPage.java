package com.dynamics365.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dynamics365Page {

    private WebDriver driver;

    public Dynamics365Page(WebDriver driver) {
        this.driver = driver;
    }

    // Login elements
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("loginButton");

    // Navigation elements
    private By ordersModuleLink = By.id("ordersModule");

    // Order elements
    private By orderIdField = By.id("orderId");
    private By searchOrderButton = By.id("searchOrder");
    private By shipmentStatusDropdown = By.id("shipmentStatus");
    private By updateShipmentButton = By.id("updateShipment");

    // Alert elements
    private By alertSystemLink = By.id("alertSystem");
    private By customerAlert = By.id("customerAlert");

    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public void navigateToOrdersModule() {
        driver.findElement(ordersModuleLink).click();
    }

    public void selectOrderById(String orderId) {
        driver.findElement(orderIdField).sendKeys(orderId);
        driver.findElement(searchOrderButton).click();
    }

    public void updateShipmentStatus(String status) {
        WebElement dropdown = driver.findElement(shipmentStatusDropdown);
        dropdown.findElement(By.xpath("//option[. = '" + status + "']")).click();
        driver.findElement(updateShipmentButton).click();
    }

    public void checkAlertSystem() {
        driver.findElement(alertSystemLink).click();
    }

    public boolean verifyCustomerAlert() {
        return driver.findElement(customerAlert).isDisplayed();
    }
}