import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dynamics365Page {

    private WebDriver driver;

    public Dynamics365Page(WebDriver driver) {
        this.driver = driver;
    }

    // Login Page Elements
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("loginBtn");

    // Orders Module Elements
    private By ordersModuleLink = By.id("ordersModule");
    private By orderRow = By.xpath("//tr[@data-id='12345']");
    private By shipmentStatusDropdown = By.id("shipmentStatus");
    private By updateButton = By.id("updateBtn");

    // Alert System Elements
    private By alertsLink = By.id("alertsLink");
    private By customerAlert = By.xpath("//div[@class='customerAlert']");

    // Login Method
    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    // Navigate to Orders Module
    public void navigateToOrdersModule() {
        driver.findElement(ordersModuleLink).click();
    }

    // Select Order by ID
    public void selectOrderById() {
        driver.findElement(orderRow).click();
    }

    // Update Shipment Status
    public void updateShipmentStatus(String status) {
        WebElement dropdown = driver.findElement(shipmentStatusDropdown);
        dropdown.click();
        dropdown.findElement(By.xpath("//option[text()='" + status + "']")).click();
        driver.findElement(updateButton).click();
    }

    // Check Alert System
    public void checkAlertSystem() {
        driver.findElement(alertsLink).click();
    }

    // Verify Customer Alert
    public boolean verifyCustomerAlert() {
        return driver.findElement(customerAlert).isDisplayed();
    }
}
```java
// Update the orderRow locator to select the correct order by ID
private By orderRow = By.xpath("//tr[@data-id='98765']");

// Method to verify the specific alert received by the customer
public boolean verifySpecificCustomerAlert(String expectedAlertText) {
    WebElement alert = driver.findElement(customerAlert);
    return alert.isDisplayed() && alert.getText().contains(expectedAlertText);
}
```