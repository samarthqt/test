import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
    private By ordersModuleLink = By.linkText("Orders");
    private By orderIdField = By.id("orderId");
    private By searchOrderButton = By.id("searchOrder");
    private By shipmentStatusDropdown = By.id("shipmentStatus");
    private By updateStatusButton = By.id("updateStatus");

    // Alert system elements
    private By alertSystemLink = By.linkText("Alert System");
    private By customerAlertsSection = By.id("customerAlerts");

    // Actions
    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public void navigateToOrdersModule() {
        driver.findElement(ordersModuleLink).click();
    }

    public void selectOrder(String orderId) {
        driver.findElement(orderIdField).sendKeys(orderId);
        driver.findElement(searchOrderButton).click();
    }

    public void updateShipmentStatus(String status) {
        WebElement dropdown = driver.findElement(shipmentStatusDropdown);
        dropdown.findElement(By.xpath("//option[. = '" + status + "']")).click();
        driver.findElement(updateStatusButton).click();
    }

    public void checkAlertSystem() {
        driver.findElement(alertSystemLink).click();
    }

    public boolean verifyCustomerAlerts(String expectedAlert) {
        WebElement alertsSection = driver.findElement(customerAlertsSection);
        return alertsSection.getText().contains(expectedAlert);
    }
}