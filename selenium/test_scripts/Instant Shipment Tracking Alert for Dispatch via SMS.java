LoginPage.java
package pages;

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

OrdersPage.java
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersPage {
    WebDriver driver;

    @FindBy(id = "ordersModule")
    WebElement ordersModule;

    @FindBy(xpath = "//tr[td[text()='98765']]/td/button[@class='edit']")
    WebElement editOrderButton;

    @FindBy(id = "shipmentStatus")
    WebElement shipmentStatusDropdown;

    @FindBy(id = "saveButton")
    WebElement saveButton;

    public OrdersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToOrders() {
        ordersModule.click();
    }

    public void selectOrderById(String orderId) {
        editOrderButton.click();
    }

    public void updateShipmentStatus(String status) {
        shipmentStatusDropdown.sendKeys(status);
        saveButton.click();
    }
}

AlertsPage.java
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsPage {
    WebDriver driver;

    @FindBy(id = "alertsModule")
    WebElement alertsModule;

    @FindBy(id = "customerAlerts")
    WebElement customerAlerts;

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkAlerts() {
        alertsModule.click();
    }

    public boolean verifyCustomerAlerts(String expectedAlert) {
        return customerAlerts.getText().contains(expectedAlert);
    }
}

TestScript.java
package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.OrdersPage;
import pages.AlertsPage;

public class TestScript {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://dynamics365.example.com");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("validUsername", "validPassword");

        OrdersPage ordersPage = new OrdersPage(driver);
        ordersPage.navigateToOrders();
        ordersPage.selectOrderById("98765");
        ordersPage.updateShipmentStatus("Dispatched");

        AlertsPage alertsPage = new AlertsPage(driver);
        alertsPage.checkAlerts();
        boolean alertVerified = alertsPage.verifyCustomerAlerts("Your order has been dispatched");

        System.out.println("Alert Verification: " + alertVerified);

        driver.quit();
    }
}