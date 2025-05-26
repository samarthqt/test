package com.tests;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
}
```java

public class Dynamics365Page {
    private WebDriver driver;

    // Constructor
    public Dynamics365Page(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("loginButton");
    private By ordersModule = By.id("ordersModule");
    private By orderIdField = By.id("orderId");
    private By searchButton = By.id("searchButton");
    private By shipmentStatusDropdown = By.id("shipmentStatus");
    private By dispatchedOption = By.xpath("//option[text()='Dispatched']");
    private By saveButton = By.id("saveButton");
    private By alertSystem = By.id("alertSystem");
    private By customerAlert = By.id("customerAlert");

    // Methods
    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public void navigateToOrdersModule() {
        driver.findElement(ordersModule).click();
    }

    public void selectOrderById(String orderId) {
        driver.findElement(orderIdField).sendKeys(orderId);
        driver.findElement(searchButton).click();
    }

    public void updateShipmentStatusToDispatched() {
        WebElement dropdown = driver.findElement(shipmentStatusDropdown);
        dropdown.click();
        dropdown.findElement(dispatchedOption).click();
        driver.findElement(saveButton).click();
    }

    public boolean checkAlertSystemForOutgoingAlerts() {
        return driver.findElement(alertSystem).isDisplayed();
    }

    public boolean verifyCustomerAlertReceived() {
        return driver.findElement(customerAlert).isDisplayed();
    }
}

// Test class
public class InstantShipmentTrackingAlertTest {
    private WebDriver driver;
    private Dynamics365Page dynamics365Page;

    public InstantShipmentTrackingAlertTest(WebDriver driver) {
        this.driver = driver;
        this.dynamics365Page = new Dynamics365Page(driver);
    }

    public void testInstantShipmentTrackingAlert() {
        // Step 1: Log in to the Dynamics 365 system with valid credentials.
        dynamics365Page.login("validUsername", "validPassword");

        // Step 2: Navigate to the 'Orders' module.
        dynamics365Page.navigateToOrdersModule();

        // Step 3: Select the order with ID 12345.
        dynamics365Page.selectOrderById("12345");

        // Step 4: Update the shipment status to 'Dispatched'.
        dynamics365Page.updateShipmentStatusToDispatched();

        // Step 5: Check the alert system for outgoing alerts.
        boolean alertsDisplayed = dynamics365Page.checkAlertSystemForOutgoingAlerts();
        if (!alertsDisplayed) {
            System.out.println("No outgoing alerts found.");
        }

        // Step 6: Verify the alert received by the customer.
        boolean customerAlertReceived = dynamics365Page.verifyCustomerAlertReceived();
        if (!customerAlertReceived) {
            System.out.println("Customer alert not received.");
        }
    }
}
```
```java

public class ShipmentTrackingTest {

    public static void main(String[] args) {
        // Set up the WebDriver and navigate to the login page
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://dynamics365.example.com");

        // Log in to the Dynamics 365 system with valid credentials
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        
        username.sendKeys("validUsername");
        password.sendKeys("validPassword");
        loginButton.click();

        // Wait for login to complete and navigate to the 'Orders' module
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ordersModule")));
        WebElement ordersModule = driver.findElement(By.id("ordersModule"));
        ordersModule.click();

        // Select the order with ID 98765
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orderSearch")));
        WebElement orderSearch = driver.findElement(By.id("orderSearch"));
        orderSearch.sendKeys("98765");
        WebElement searchButton = driver.findElement(By.id("searchButton"));
        searchButton.click();

        // Update the shipment status to 'Dispatched'
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("order98765")));
        WebElement order98765 = driver.findElement(By.id("order98765"));
        order98765.click();
        
        WebElement statusDropdown = driver.findElement(By.id("statusDropdown"));
        statusDropdown.click();
        WebElement dispatchedOption = driver.findElement(By.xpath("//option[@value='Dispatched']"));
        dispatchedOption.click();
        
        WebElement updateButton = driver.findElement(By.id("updateButton"));
        updateButton.click();

        // Check the alert system for outgoing alerts
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alertSystem")));
        WebElement alertSystem = driver.findElement(By.id("alertSystem"));
        alertSystem.click();

        // Verify the alerts received by the customer
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customerAlerts")));
        WebElement customerAlerts = driver.findElement(By.id("customerAlerts"));
        String alertText = customerAlerts.getText();
        
        if (alertText.contains("Shipment dispatched")) {
            System.out.println("Alert received by the customer: " + alertText);
        } else {
            System.out.println("No alert received by the customer.");
        }

        // Clean up
        driver.quit();
    }
}
```