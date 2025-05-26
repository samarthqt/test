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

    // Order selection elements
    private By orderSearchField = By.id("orderSearch");
    private By orderSelectButton = By.id("selectOrder");

    // Update shipment status elements
    private By shipmentStatusDropdown = By.id("shipmentStatus");
    private By updateStatusButton = By.id("updateStatus");

    // Alert system elements
    private By alertSystemLink = By.id("alertSystem");
    private By customerAlert = By.id("customerAlert");

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
        driver.findElement(orderSearchField).sendKeys(orderId);
        driver.findElement(orderSelectButton).click();
    }

    public void updateShipmentStatus(String status) {
        Select dropdown = new Select(driver.findElement(shipmentStatusDropdown));
        dropdown.selectByVisibleText(status);
        driver.findElement(updateStatusButton).click();
    }

    public void checkAlertSystem() {
        driver.findElement(alertSystemLink).click();
    }

    public String getCustomerAlert() {
        return driver.findElement(customerAlert).getText();
    }
}