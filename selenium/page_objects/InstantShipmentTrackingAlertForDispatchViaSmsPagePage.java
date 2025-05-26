import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class Dynamics365Page {

    private WebDriver driver;

    // Constructor
    public Dynamics365Page(WebDriver driver) {
        this.driver = driver;
    }

    // Login elements
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("loginButton");

    // Orders module elements
    private By ordersModuleLink = By.id("ordersModule");

    // Order elements
    private By orderIdField = By.id("orderId");
    private By searchOrderButton = By.id("searchOrder");
    private By shipmentStatusDropdown = By.id("shipmentStatus");
    private By updateShipmentStatusButton = By.id("updateShipmentStatus");

    // Alert system elements
    private By alertSystemLink = By.id("alertSystem");
    private By customerAlerts = By.id("customerAlerts");

    // Methods
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
        driver.findElement(updateShipmentStatusButton).click();
    }

    public void checkAlertSystem() {
        driver.findElement(alertSystemLink).click();
    }

    public String verifyCustomerAlerts() {
        return driver.findElement(customerAlerts).getText();
    }
}