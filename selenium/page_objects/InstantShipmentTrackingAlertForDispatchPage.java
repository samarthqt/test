import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dynamics365Page {

    private WebDriver driver;

    public Dynamics365Page(WebDriver driver) {
        this.driver = driver;
    }

    // Login Elements
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("loginButton");

    // Navigation Elements
    private By ordersModuleLink = By.id("ordersModule");

    // Order Elements
    private By orderIdField = By.id("orderId");
    private By searchOrderButton = By.id("searchOrder");
    private By shipmentStatusDropdown = By.id("shipmentStatus");
    private By updateShipmentButton = By.id("updateShipment");

    // Alert Elements
    private By alertSystemLink = By.id("alertSystem");
    private By customerAlertField = By.id("customerAlert");

    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public void navigateToOrdersModule() {
        driver.findElement(ordersModuleLink).click();
    }

    public void selectOrderById(String orderId) {
        driver.findElement(orderIdField).sendKeys(orderId);
        driver.findElement(searchOrderButton).click();
    }

    public void updateShipmentStatus(String status) {
        WebElement dropdown = driver.findElement(shipmentStatusDropdown);
        dropdown.findElement(By.xpath("//option[. = '" + status + "']")).click();
        driver.findElement(updateShipmentButton).click();
    }

    public void checkAlertSystem() {
        driver.findElement(alertSystemLink).click();
    }

    public String getCustomerAlert() {
        return driver.findElement(customerAlertField).getText();
    }
}