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
// Page Object Model files

// LoginPage.java
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(id = "username")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "loginButton")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}

// OrdersPage.java
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersPage {
    WebDriver driver;

    @FindBy(id = "orderSearchField")
    WebElement orderSearchField;

    @FindBy(id = "searchButton")
    WebElement searchButton;

    @FindBy(xpath = "//tr[td[text()='12345']]/td/button[text()='Select']")
    WebElement selectOrderButton;

    @FindBy(id = "shipmentStatusDropdown")
    WebElement shipmentStatusDropdown;

    @FindBy(xpath = "//option[text()='Dispatched']")
    WebElement dispatchedOption;

    @FindBy(id = "updateStatusButton")
    WebElement updateStatusButton;

    public OrdersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToOrder(String orderId) {
        orderSearchField.sendKeys(orderId);
        searchButton.click();
        selectOrderButton.click();
    }

    public void updateShipmentStatusToDispatched() {
        shipmentStatusDropdown.click();
        dispatchedOption.click();
        updateStatusButton.click();
    }
}

// AlertsPage.java
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsPage {
    WebDriver driver;

    @FindBy(id = "checkAlertsButton")
    WebElement checkAlertsButton;

    @FindBy(xpath = "//div[contains(text(), 'Customer Alert:')]")
    WebElement customerAlert;

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkAlerts() {
        checkAlertsButton.click();
    }

    public boolean isCustomerAlertReceived() {
        return customerAlert.isDisplayed();
    }
}

// Test Script

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Dynamics365Test {
    WebDriver driver;
    LoginPage loginPage;
    OrdersPage ordersPage;
    AlertsPage alertsPage;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://dynamics365.example.com");
        loginPage = new LoginPage(driver);
        ordersPage = new OrdersPage(driver);
        alertsPage = new AlertsPage(driver);
    }

    @Test
    public void testUpdateOrderShipmentStatus() {
        loginPage.login("validUsername", "validPassword");
        ordersPage.navigateToOrder("12345");
        ordersPage.updateShipmentStatusToDispatched();
        alertsPage.checkAlerts();
        Assert.assertTrue(alertsPage.isCustomerAlertReceived(), "Customer alert was not received.");
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
```