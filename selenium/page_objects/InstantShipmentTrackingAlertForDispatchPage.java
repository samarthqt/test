import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class Dynamics365Page {

    private WebDriver driver;

    public Dynamics365Page(WebDriver driver) {
        this.driver = driver;
    }

    // Login elements
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("loginBtn");

    // Orders module elements
    private By ordersModuleLink = By.id("ordersModule");

    // Order elements
    private By orderSearchField = By.id("orderSearch");
    private By orderSearchButton = By.id("searchBtn");
    private By orderShipmentStatusDropdown = By.id("shipmentStatus");
    private By orderUpdateButton = By.id("updateBtn");

    // Alert elements
    private By alertSystemLink = By.id("alertSystem");
    private By customerAlert = By.id("customerAlert");

    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public void navigateToOrdersModule() {
        driver.findElement(ordersModuleLink).click();
    }

    public void selectOrderById(String orderId) {
        driver.findElement(orderSearchField).sendKeys(orderId);
        driver.findElement(orderSearchButton).click();
    }

    public void updateShipmentStatus(String status) {
        WebElement dropdown = driver.findElement(orderShipmentStatusDropdown);
        dropdown.findElement(By.xpath("//option[. = '" + status + "']")).click();
        driver.findElement(orderUpdateButton).click();
    }

    public void checkAlertSystem() {
        driver.findElement(alertSystemLink).click();
    }

    public boolean verifyCustomerAlert(String expectedAlert) {
        String actualAlert = driver.findElement(customerAlert).getText();
        return actualAlert.contains(expectedAlert);
    }
}