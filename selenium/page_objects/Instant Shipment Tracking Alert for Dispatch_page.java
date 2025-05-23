public class Dynamics365Page {

    private WebDriver driver;

    // Constructor
    public Dynamics365Page(WebDriver driver) {
        this.driver = driver;
    }

    // Login elements
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login");

    // Orders module elements
    private By ordersModuleLink = By.linkText("Orders");

    // Order elements
    private By orderIdField = By.id("orderSearch");
    private By searchOrderButton = By.id("searchOrder");
    private By orderRow = By.xpath("//tr[td[text()='12345']]");
    private By shipmentStatusDropdown = By.id("shipmentStatus");
    private By updateStatusButton = By.id("updateStatus");

    // Alert elements
    private By alertsLink = By.linkText("Alerts");
    private By customerAlert = By.xpath("//tr[td[contains(text(),'Customer Alert')]]");

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
        driver.findElement(orderIdField).sendKeys(orderId);
        driver.findElement(searchOrderButton).click();
        driver.findElement(orderRow).click();
    }

    public void updateShipmentStatus(String status) {
        WebElement dropdown = driver.findElement(shipmentStatusDropdown);
        Select select = new Select(dropdown);
        select.selectByVisibleText(status);
        driver.findElement(updateStatusButton).click();
    }

    public void checkAlerts() {
        driver.findElement(alertsLink).click();
    }

    public boolean verifyCustomerAlert() {
        return driver.findElement(customerAlert).isDisplayed();
    }
}