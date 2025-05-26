import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
    private By orderIdField = By.xpath("//input[@value='12345']");
    private By shipmentStatusDropdown = By.id("shipmentStatus");
    private By dispatchOption = By.xpath("//option[@value='Dispatched']");
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

    public void selectOrderById() {
        driver.findElement(orderIdField).click();
    }

    public void updateShipmentStatusToDispatched() {
        WebElement dropdown = driver.findElement(shipmentStatusDropdown);
        dropdown.click();
        dropdown.findElement(dispatchOption).click();
    }

    public boolean checkAlertSystem() {
        return driver.findElement(alertSystem).isDisplayed();
    }

    public boolean verifyCustomerAlert() {
        return driver.findElement(customerAlert).isDisplayed();
    }
}
// Update locator for selecting order with ID 98765
private By orderIdField = By.xpath("//input[@value='98765']");

// Method to select order by specific ID
public void selectOrderById(String orderId) {
    WebElement orderField = driver.findElement(By.xpath("//input[@value='" + orderId + "']"));
    orderField.click();
}