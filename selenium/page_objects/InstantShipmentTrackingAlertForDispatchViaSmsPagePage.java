public class Dynamics365Page {

    private WebDriver driver;

    // Locators
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("loginButton");
    private By ordersModuleLink = By.linkText("Orders");
    private By orderIdLink = By.xpath("//a[text()='98765']");
    private By shipmentStatusDropdown = By.id("shipmentStatus");
    private By dispatchedOption = By.xpath("//option[text()='Dispatched']");
    private By alertSystemLink = By.linkText("Alert System");
    private By customerAlerts = By.id("customerAlerts");

    public Dynamics365Page(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
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

    public boolean verifyCustomerAlerts() {
        return driver.findElement(customerAlerts).isDisplayed();
    }
}