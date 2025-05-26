```java
// LoginPage.java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    By usernameField = By.id("username");
    By passwordField = By.id("password");
    By loginButton = By.id("loginBtn");

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
    WebDriver driver;

    By ordersModuleLink = By.id("ordersModule");
    By orderIdField = By.id("orderIdField");
    By searchButton = By.id("searchButton");
    By shipmentStatusDropdown = By.id("shipmentStatus");
    By dispatchedOption = By.xpath("//option[@value='Dispatched']");
    By updateButton = By.id("updateButton");
    By alertsLink = By.id("alertsLink");
    By customerAlerts = By.id("customerAlerts");

    public OrdersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToOrdersModule() {
        driver.findElement(ordersModuleLink).click();
    }

    public void selectOrderById(String orderId) {
        driver.findElement(orderIdField).sendKeys(orderId);
        driver.findElement(searchButton).click();
    }

    public void updateShipmentStatusToDispatched() {
        driver.findElement(shipmentStatusDropdown).click();
        driver.findElement(dispatchedOption).click();
        driver.findElement(updateButton).click();
    }

    public void checkAlerts() {
        driver.findElement(alertsLink).click();
    }

    public boolean verifyCustomerAlerts() {
        return driver.findElement(customerAlerts).isDisplayed();
    }
}

// TestScript.java
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestScript {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://dynamics365.example.com");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("validUsername", "validPassword");

        OrdersPage ordersPage = new OrdersPage(driver);
        ordersPage.navigateToOrdersModule();
        ordersPage.selectOrderById("98765");
        ordersPage.updateShipmentStatusToDispatched();
        ordersPage.checkAlerts();

        boolean alertsVerified = ordersPage.verifyCustomerAlerts();
        if (alertsVerified) {
            System.out.println("Customer alerts verified successfully.");
        } else {
            System.out.println("Customer alerts verification failed.");
        }

        driver.quit();
    }
}
```