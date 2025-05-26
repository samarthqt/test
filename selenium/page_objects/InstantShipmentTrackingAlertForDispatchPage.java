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
    private By ordersModuleLink = By.linkText("Orders");
    private By orderSearchField = By.id("orderSearch");
    private By orderSearchButton = By.id("orderSearchButton");
    private By orderRow = By.xpath("//tr[td[text()='12345']]");
    private By shipmentStatusDropdown = By.id("shipmentStatus");
    private By updateStatusButton = By.id("updateStatusButton");
    private By alertSystemLink = By.linkText("Alert System");
    private By customerAlert = By.xpath("//div[contains(text(), 'Customer Alert')]");

    // Actions
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
        driver.findElement(orderRow).click();
    }

    public void updateShipmentStatus(String status) {
        WebElement dropdown = driver.findElement(shipmentStatusDropdown);
        dropdown.findElement(By.xpath("//option[. = '" + status + "']")).click();
        driver.findElement(updateStatusButton).click();
    }

    public void checkAlertSystem() {
        driver.findElement(alertSystemLink).click();
    }

    public boolean verifyCustomerAlert() {
        return driver.findElement(customerAlert).isDisplayed();
    }
}
// Update the orderRow locator to dynamically select the order with the given ID
private By orderRow(String orderId) {
    return By.xpath("//tr[td[text()='" + orderId + "']]");
}

// Modify the selectOrderById method to use the dynamic orderRow locator
public void selectOrderById(String orderId) {
    driver.findElement(orderSearchField).sendKeys(orderId);
    driver.findElement(orderSearchButton).click();
    driver.findElement(orderRow(orderId)).click();
}