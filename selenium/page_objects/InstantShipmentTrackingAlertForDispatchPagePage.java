public class Dynamics365Page {

    private WebDriver driver;

    // Constructor
    public Dynamics365Page(WebDriver driver) {
        this.driver = driver;
    }

    // Locators for login
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login");

    // Locators for Orders module
    private By ordersModuleLink = By.linkText("Orders");

    // Locators for specific order
    private By orderRow = By.xpath("//tr[td[text()='12345']]");
    private By shipmentStatusDropdown = By.id("shipmentStatus");

    // Locators for alert system
    private By alertSystemLink = By.linkText("Alerts");
    private By customerAlert = By.xpath("//div[contains(text(), 'Customer Alert')]");

    // Methods
    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public void navigateToOrdersModule() {
        driver.findElement(ordersModuleLink).click();
    }

    public void selectOrder(String orderId) {
        driver.findElement(orderRow).click();
    }

    public void updateShipmentStatus(String status) {
        Select dropdown = new Select(driver.findElement(shipmentStatusDropdown));
        dropdown.selectByVisibleText(status);
    }

    public void checkAlertSystem() {
        driver.findElement(alertSystemLink).click();
    }

    public boolean isCustomerAlertReceived() {
        return driver.findElement(customerAlert).isDisplayed();
    }
}