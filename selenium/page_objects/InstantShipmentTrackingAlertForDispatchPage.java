public class Dynamics365Page {
    private WebDriver driver;

    // Constructor
    public Dynamics365Page(WebDriver driver) {
        this.driver = driver;
    }

    // Login Elements
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("loginButton");

    // Orders Module Elements
    private By ordersModuleLink = By.linkText("Orders");

    // Order Elements
    private By orderRow = By.xpath("//tr[td[text()='12345']]");
    private By shipmentStatusDropdown = By.id("shipmentStatus");
    private By updateButton = By.id("updateButton");

    // Alert Elements
    private By alertSystemLink = By.linkText("Alert System");
    private By customerAlert = By.xpath("//div[@class='customer-alert']");

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
        driver.findElement(orderRow).click();
    }

    public void updateShipmentStatus(String status) {
        WebElement dropdown = driver.findElement(shipmentStatusDropdown);
        Select select = new Select(dropdown);
        select.selectByVisibleText(status);
        driver.findElement(updateButton).click();
    }

    public void checkAlertSystem() {
        driver.findElement(alertSystemLink).click();
    }

    public boolean verifyCustomerAlert() {
        return driver.findElement(customerAlert).isDisplayed();
    }
}
// Updated Order Elements
private By orderRow = By.xpath("//tr[td[text()='98765']]");

// Method to select order by ID
public void selectOrderById(String orderId) {
    By dynamicOrderRow = By.xpath("//tr[td[text()='" + orderId + "']]");
    driver.findElement(dynamicOrderRow).click();
}