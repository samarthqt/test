public class Dynamics365Page {
    
    private WebDriver driver;

    // Locators
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("loginButton");
    private By ordersModule = By.id("ordersModule");
    private By orderSearchField = By.id("orderSearch");
    private By orderSelectButton = By.id("selectOrder12345");
    private By shipmentStatusDropdown = By.id("shipmentStatus");
    private By dispatchedOption = By.xpath("//option[@value='Dispatched']");
    private By alertSystem = By.id("alertSystem");
    private By customerAlert = By.id("customerAlert");

    // Constructor
    public Dynamics365Page(WebDriver driver) {
        this.driver = driver;
    }

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
        driver.findElement(orderSearchField).sendKeys(orderId);
        driver.findElement(orderSelectButton).click();
    }

    public void updateShipmentStatusToDispatched() {
        driver.findElement(shipmentStatusDropdown).click();
        driver.findElement(dispatchedOption).click();
    }

    public boolean checkAlertSystem() {
        return driver.findElement(alertSystem).isDisplayed();
    }

    public boolean verifyCustomerAlert() {
        return driver.findElement(customerAlert).isDisplayed();
    }
}
// Updated locator for dynamic order selection
private By getOrderSelectButton(String orderId) {
    return By.id("selectOrder" + orderId);
}

// Updated method to select order by dynamic ID
public void selectOrderById(String orderId) {
    driver.findElement(orderSearchField).sendKeys(orderId);
    driver.findElement(getOrderSelectButton(orderId)).click();
}