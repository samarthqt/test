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
    private By orderIdLink = By.linkText("12345");
    private By shipmentStatusDropdown = By.id("shipmentStatus");
    private By dispatchedOption = By.xpath("//option[@value='Dispatched']");
    private By alertSystemLink = By.linkText("Alert System");
    private By customerAlert = By.id("customerAlert");

    // Methods
    public void logIn(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public void navigateToOrdersModule() {
        driver.findElement(ordersModuleLink).click();
    }

    public void selectOrderById() {
        driver.findElement(orderIdLink).click();
    }

    public void updateShipmentStatusToDispatched() {
        WebElement dropdown = driver.findElement(shipmentStatusDropdown);
        dropdown.click();
        dropdown.findElement(dispatchedOption).click();
    }

    public void checkAlertSystem() {
        driver.findElement(alertSystemLink).click();
    }

    public boolean verifyCustomerAlertReceived() {
        return driver.findElement(customerAlert).isDisplayed();
    }
}
private By orderIdLink = By.linkText("98765");

public void selectOrderById(String orderId) {
    driver.findElement(By.linkText(orderId)).click();
}