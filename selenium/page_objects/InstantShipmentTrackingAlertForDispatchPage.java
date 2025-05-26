import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
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
    private By orderIdField = By.id("orderId");
    private By searchButton = By.id("searchButton");
    private By shipmentStatusDropdown = By.id("shipmentStatus");
    private By dispatchedOption = By.xpath("//option[text()='Dispatched']");
    private By saveButton = By.id("saveButton");
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

    public void selectOrderById(String orderId) {
        driver.findElement(orderIdField).sendKeys(orderId);
        driver.findElement(searchButton).click();
    }

    public void updateShipmentStatusToDispatched() {
        WebElement dropdown = driver.findElement(shipmentStatusDropdown);
        dropdown.click();
        dropdown.findElement(dispatchedOption).click();
        driver.findElement(saveButton).click();
    }

    public boolean checkAlertSystemForOutgoingAlerts() {
        return driver.findElement(alertSystem).isDisplayed();
    }

    public boolean verifyCustomerAlertReceived() {
        return driver.findElement(customerAlert).isDisplayed();
    }
}

public class Dynamics365Page {
    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public Dynamics365Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize WebDriverWait
    }

    // Existing methods...

    public void updateShipmentStatusToDispatched() {
        WebElement dropdown = driver.findElement(shipmentStatusDropdown);
        dropdown.click();
        dropdown.findElement(dispatchedOption).click();
        driver.findElement(saveButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(alertSystem)); // Wait for alert system to be visible
    }

    public boolean verifyCustomerAlertReceived() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(customerAlert)); // Wait for customer alert to be visible
        return driver.findElement(customerAlert).isDisplayed();
    }
}