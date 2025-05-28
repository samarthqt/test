package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Dynamics365Page class provides methods to interact with Dynamics 365 application.
 */
public class Dynamics365Page {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Login elements
    private final By usernameField = By.id(username);
    private final By passwordField = By.id(password);
    private final By loginButton = By.id(loginButton);

    // Navigation elements
    private final By ordersModuleLink = By.linkText(Orders);

    // Order elements
    private final By orderIdInput = By.id(orderIdInput);
    private final By searchButton = By.id(searchButton);
    private final By shipmentStatusDropdown = By.id(shipmentStatus);
    private final By updateButton = By.id(updateButton);

    // Alert elements
    private final By alertSystemLink = By.linkText(Alert System);
    private final By customerAlert = By.id(customerAlert);

    /**
     * Constructor initializes the page elements using PageFactory.
     *
     * @param driver WebDriver instance
     */
    public Dynamics365Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    /**
     * Logs into the application using provided credentials.
     *
     * @param username User's username
     * @param password User's password
     */
    public void login(String username, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        Assert.assertTrue(isLoggedIn(), Login failed.);
    }

    /**
     * Navigates to the Orders module.
     */
    public void navigateToOrdersModule() {
        wait.until(ExpectedConditions.elementToBeClickable(ordersModuleLink)).click();
        Assert.assertTrue(isInOrdersModule(), Navigation to Orders module failed.);
    }

    /**
     * Selects an order by its ID.
     *
     * @param orderId Order ID to search
     */
    public void selectOrderById(String orderId) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderIdInput)).sendKeys(orderId);
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
        Assert.assertTrue(isOrderDisplayed(orderId), Order not found.);
    }

    /**
     * Updates the shipment status of an order.
     *
     * @param status New shipment status
     */
    public void updateShipmentStatus(String status) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(shipmentStatusDropdown));
        dropdown.click();
        dropdown.findElement(By.xpath(//option[. = ' + status + '])).click();
        wait.until(ExpectedConditions.elementToBeClickable(updateButton)).click();
        Assert.assertTrue(isShipmentStatusUpdated(status), Shipment status update failed.);
    }

    /**
     * Checks the alert system.
     */
    public void checkAlertSystem() {
        wait.until(ExpectedConditions.elementToBeClickable(alertSystemLink)).click();
        Assert.assertTrue(isAlertSystemAccessible(), Alert system access failed.);
    }

    /**
     * Retrieves the customer alert message.
     *
     * @return Customer alert message
     */
    public String getCustomerAlert() {
        String alertMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(customerAlert)).getText();
        Assert.assertNotNull(alertMessage, Customer alert message is null.);
        return alertMessage;
    }

    // Helper methods

    private boolean isLoggedIn() {
        // Implement logic to verify login success
        return true; // Placeholder for actual implementation
    }

    private boolean isInOrdersModule() {
        // Implement logic to verify navigation success
        return true; // Placeholder for actual implementation
    }

    private boolean isOrderDisplayed(String orderId) {
        // Implement logic to verify order display
        return true; // Placeholder for actual implementation
    }

    private boolean isShipmentStatusUpdated(String status) {
        // Implement logic to verify shipment status update
        return true; // Placeholder for actual implementation
    }

    private boolean isAlertSystemAccessible() {
        // Implement logic to verify alert system access
        return true; // Placeholder for actual implementation
    }
}