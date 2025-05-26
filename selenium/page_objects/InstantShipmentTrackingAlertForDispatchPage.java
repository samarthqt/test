public class Dynamics365Page {
    private WebDriver driver;
    
    // Locators
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("loginButton");
    private By ordersModule = By.xpath("//a[@title='Orders']");
    private By orderById = By.xpath("//tr[td[text()='12345']]");
    private By shipmentStatusDropdown = By.id("shipmentStatus");
    private By dispatchOption = By.xpath("//option[text()='Dispatched']");
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

    public void selectOrderById() {
        driver.findElement(orderById).click();
    }

    public void updateShipmentStatusToDispatched() {
        WebElement dropdown = driver.findElement(shipmentStatusDropdown);
        dropdown.click();
        dropdown.findElement(dispatchOption).click();
    }

    public boolean checkAlertSystemForOutgoingAlerts() {
        return driver.findElement(alertSystem).isDisplayed();
    }

    public boolean verifyAlertReceivedByCustomer() {
        return driver.findElement(customerAlert).isDisplayed();
    }
}
// Updated Locator for selecting the correct order by ID
private By orderById = By.xpath("//tr[td[text()='98765']]");

// Method to select the correct order by ID 98765
public void selectOrderById(String orderId) {
    By orderById = By.xpath("//tr[td[text()='" + orderId + "']]");
    driver.findElement(orderById).click();
}