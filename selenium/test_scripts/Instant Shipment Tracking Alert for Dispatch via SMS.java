// Dynamics365LoginPage.java
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dynamics365LoginPage {
    private WebDriver driver;

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("loginButton");

    public Dynamics365LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}

// OrdersPage.java
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrdersPage {
    private WebDriver driver;

    private By ordersModuleLink = By.linkText("Orders");
    private By orderIdField = By.id("orderId");
    private By updateShipmentStatusButton = By.id("updateShipmentStatus");
    private By shipmentStatusDropdown = By.id("shipmentStatus");
    private By dispatchedOption = By.xpath("//option[text()='Dispatched']");
    private By alertsSystemLink = By.linkText("Alerts System");
    private By customerAlertsSection = By.id("customerAlerts");

    public OrdersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToOrdersModule() {
        driver.findElement(ordersModuleLink).click();
    }

    public void selectOrderById(String orderId) {
        driver.findElement(orderIdField).sendKeys(orderId);
    }

    public void updateShipmentStatusToDispatched() {
        driver.findElement(shipmentStatusDropdown).click();
        driver.findElement(dispatchedOption).click();
        driver.findElement(updateShipmentStatusButton).click();
    }

    public void checkAlertsSystem() {
        driver.findElement(alertsSystemLink).click();
    }

    public boolean verifyCustomerAlerts(String expectedAlert) {
        String actualAlert = driver.findElement(customerAlertsSection).getText();
        return actualAlert.contains(expectedAlert);
    }
}

// TestDynamics365.java
package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Dynamics365LoginPage;
import pages.OrdersPage;

public class TestDynamics365 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://dynamics365.example.com");

        Dynamics365LoginPage loginPage = new Dynamics365LoginPage(driver);
        loginPage.login("validUsername", "validPassword");

        OrdersPage ordersPage = new OrdersPage(driver);
        ordersPage.navigateToOrdersModule();
        ordersPage.selectOrderById("98765");
        ordersPage.updateShipmentStatusToDispatched();
        ordersPage.checkAlertsSystem();

        boolean alertVerified = ordersPage.verifyCustomerAlerts("Order 98765 has been dispatched");
        if (alertVerified) {
            System.out.println("Customer alerts verified successfully.");
        } else {
            System.out.println("Customer alerts verification failed.");
        }

        driver.quit();
    }
}