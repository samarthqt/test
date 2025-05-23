package com.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.pageobjects.ShipmentTrackingPage;
import com.framework.reusable.WebReusableComponents;

public class ShipmentTrackingTest extends WebReusableComponents {

    private ShipmentTrackingPage shipmentTrackingPage;

    @BeforeMethod
    public void setUp() {
        initializeDriver();
        shipmentTrackingPage = new ShipmentTrackingPage(driver);
        loginToSystem("validUsername", "validPassword");
    }

    @Test
    public void verifyInstantShipmentTrackingAlert() {
        shipmentTrackingPage.navigateToOrdersModule();
        shipmentTrackingPage.selectOrderById("12345");
        shipmentTrackingPage.updateShipmentStatusToDispatched();
        boolean alertSent = shipmentTrackingPage.checkAlertSystemForOutgoingAlerts("customer@example.com");
        assert alertSent : "Alert was not sent to the customer.";
        boolean alertReceived = shipmentTrackingPage.verifyAlertReceivedByCustomer("Your shipment has been dispatched.");
        assert alertReceived : "Customer did not receive the expected alert.";
    }

    @AfterMethod
    public void tearDown() {
        closeDriver();
    }
}```java
// LoginPage.java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("loginBtn");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}

// OrdersPage.java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrdersPage {
    private WebDriver driver;
    private By orderModule = By.id("ordersModule");
    private By orderIdField = By.id("orderIdField");
    private By searchButton = By.id("searchBtn");
    private By shipmentStatusDropdown = By.id("shipmentStatusDropdown");
    private By updateButton = By.id("updateBtn");

    public OrdersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToOrdersModule() {
        driver.findElement(orderModule).click();
    }

    public void selectOrder(String orderId) {
        driver.findElement(orderIdField).sendKeys(orderId);
        driver.findElement(searchButton).click();
    }

    public void updateShipmentStatus(String status) {
        driver.findElement(shipmentStatusDropdown).sendKeys(status);
        driver.findElement(updateButton).click();
    }
}

// AlertPage.java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPage {
    private WebDriver driver;
    private By alertSystemButton = By.id("alertSystemBtn");
    private By customerAlert = By.id("customerAlert");

    public AlertPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkAlertSystem() {
        driver.findElement(alertSystemButton).click();
    }

    public boolean verifyCustomerAlert() {
        return driver.findElement(customerAlert).isDisplayed();
    }
}

// TestScript.java
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestScript {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://dynamics365.example.com");

            LoginPage loginPage = new LoginPage(driver);
            loginPage.login("validUsername", "validPassword");

            OrdersPage ordersPage = new OrdersPage(driver);
            ordersPage.navigateToOrdersModule();
            ordersPage.selectOrder("12345");
            ordersPage.updateShipmentStatus("Dispatched");

            AlertPage alertPage = new AlertPage(driver);
            alertPage.checkAlertSystem();
            boolean alertVerified = alertPage.verifyCustomerAlert();

            System.out.println("Alert verified: " + alertVerified);
        } finally {
            driver.quit();
        }
    }
}
```