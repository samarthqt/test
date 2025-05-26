LoginPage.java

```java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("loginButton");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}
```

OrdersPage.java

```java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrdersPage {
    private WebDriver driver;
    private By ordersModuleLink = By.id("ordersModule");
    private By orderIdField = By.id("orderId98765");
    private By shipmentStatusDropdown = By.id("shipmentStatus");
    private By dispatchedOption = By.xpath("//option[text()='Dispatched']");
    private By alertSystemLink = By.id("alertSystem");

    public OrdersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToOrdersModule() {
        driver.findElement(ordersModuleLink).click();
    }

    public void selectOrderById() {
        driver.findElement(orderIdField).click();
    }

    public void updateShipmentStatusToDispatched() {
        driver.findElement(shipmentStatusDropdown).click();
        driver.findElement(dispatchedOption).click();
    }

    public void checkAlertSystem() {
        driver.findElement(alertSystemLink).click();
    }
}
```

AlertPage.java

```java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPage {
    private WebDriver driver;
    private By customerAlerts = By.id("customerAlerts");

    public AlertPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyCustomerAlerts() {
        return driver.findElement(customerAlerts).isDisplayed();
    }
}
```

TestScript.java

```java
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
            ordersPage.selectOrderById();
            ordersPage.updateShipmentStatusToDispatched();
            ordersPage.checkAlertSystem();
            
            AlertPage alertPage = new AlertPage(driver);
            boolean alertsVerified = alertPage.verifyCustomerAlerts();
            
            if (alertsVerified) {
                System.out.println("Alerts verified successfully.");
            } else {
                System.out.println("Failed to verify alerts.");
            }
        } finally {
            driver.quit();
        }
    }
}
```