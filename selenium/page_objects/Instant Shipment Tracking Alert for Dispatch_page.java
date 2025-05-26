public class Dynamics365Page {
    private WebDriver driver;

    // Locators
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("loginButton");
    private By ordersModule = By.id("ordersModule");
    private By orderIdField = By.xpath("//input[@name='orderId']");
    private By searchButton = By.id("searchOrder");
    private By shipmentStatusDropdown = By.id("shipmentStatus");
    private By dispatchedOption = By.xpath("//option[@value='Dispatched']");
    private By saveButton = By.id("saveButton");
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