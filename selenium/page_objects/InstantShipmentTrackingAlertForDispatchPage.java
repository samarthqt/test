public class Dynamics365Page {
    private WebDriver driver;
    
    // Locators
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("loginButton");
    private By ordersModuleLink = By.linkText("Orders");
    private By orderIdField = By.xpath("//input[@placeholder='Search Order ID']");
    private By searchButton = By.id("searchButton");
    private By shipmentStatusDropdown = By.id("shipmentStatus");
    private By updateButton = By.id("updateButton");
    private By alertSystemLink = By.linkText("Alert System");
    private By customerAlert = By.xpath("//div[@class='alert' and contains(text(), 'Customer Alert')]");

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
        driver.findElement(ordersModuleLink).click();
    }
    
    public void selectOrderById(String orderId) {
        driver.findElement(orderIdField).sendKeys(orderId);
        driver.findElement(searchButton).click();
    }
    
    public void updateShipmentStatus(String status) {
        Select shipmentStatus = new Select(driver.findElement(shipmentStatusDropdown));
        shipmentStatus.selectByVisibleText(status);
        driver.findElement(updateButton).click();
    }
    
    public void checkAlertSystem() {
        driver.findElement(alertSystemLink).click();
    }
    
    public boolean verifyCustomerAlert() {
        return driver.findElement(customerAlert).isDisplayed();
    }
}