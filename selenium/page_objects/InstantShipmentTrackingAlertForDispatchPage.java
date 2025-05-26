import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dynamics365Page {
    private WebDriver driver;

    public Dynamics365Page(WebDriver driver) {
        this.driver = driver;
    }

    // Login elements
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("loginButton");

    // Navigation elements
    private By ordersModuleLink = By.id("ordersModule");

    // Order elements
    private By orderSearchField = By.id("orderSearch");
    private By searchButton = By.id("searchButton");
    private By orderRow = By.xpath("//tr[@data-id='12345']");
    private By shipmentStatusDropdown = By.id("shipmentStatus");
    private By dispatchOption = By.xpath("//option[@value='Dispatched']");
    private By updateButton = By.id("updateButton");

    // Alert elements
    private By alertSystemLink = By.id("alertSystem");
    private By customerAlert = By.xpath("//div[@class='alert' and contains(text(), 'Customer Alert')]");

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
        driver.findElement(searchButton).click();
        driver.findElement(orderRow).click();
    }

    public void updateShipmentStatusToDispatched() {
        WebElement dropdown = driver.findElement(shipmentStatusDropdown);
        dropdown.click();
        dropdown.findElement(dispatchOption).click();
        driver.findElement(updateButton).click();
    }

    public void checkAlertSystem() {
        driver.findElement(alertSystemLink).click();
    }

    public boolean verifyCustomerAlert() {
        return driver.findElement(customerAlert).isDisplayed();
    }
}
// Update the orderRow locator to dynamically use the provided orderId
private By orderRow(String orderId) {
    return By.xpath("//tr[@data-id='" + orderId + "']");
}

// Modify the selectOrderById method to use the dynamic locator
public void selectOrderById(String orderId) {
    driver.findElement(orderSearchField).sendKeys(orderId);
    driver.findElement(searchButton).click();
    driver.findElement(orderRow(orderId)).click();
}