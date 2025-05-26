```java
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

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
}

// OrdersPage.java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrdersPage {
    private WebDriver driver;
    private By ordersModuleLink = By.id("ordersModule");
    private By orderIdField = By.id("orderSearch");
    private By searchButton = By.id("searchOrderBtn");
    private By shipmentStatusDropdown = By.id("shipmentStatus");
    private By updateStatusButton = By.id("updateStatusBtn");
    private By alertsLink = By.id("alertsLink");

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

    public void updateShipmentStatus(String status) {
        driver.findElement(shipmentStatusDropdown).sendKeys(status);
        driver.findElement(updateStatusButton).click();
    }

    public void checkAlerts() {
        driver.findElement(alertsLink).click();
    }
}

// TestScript.java
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestScript {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://dynamics365.example.com");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("validUsername");
        loginPage.enterPassword("validPassword");
        loginPage.clickLogin();

        OrdersPage ordersPage = new OrdersPage(driver);
        ordersPage.navigateToOrdersModule();
        ordersPage.selectOrderById("98765");
        ordersPage.updateShipmentStatus("Dispatched");
        ordersPage.checkAlerts();

        // Add assertions or verification steps for alerts here

        driver.quit();
    }
}
```