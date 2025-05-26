public class Dynamics365Page {
    private WebDriver driver;

    private By googleLoginButton = By.id("google-login");
    private By ordersModuleLink = By.linkText("Orders");
    private By orderIdField = By.id("order-id");
    private By shipmentStatusDropdown = By.id("shipment-status");
    private By alertSystemButton = By.id("alert-system");
    private By customerAlertsSection = By.id("customer-alerts");

    public Dynamics365Page(WebDriver driver) {
        this.driver = driver;
    }

    public void logInWithGoogle() {
        driver.findElement(googleLoginButton).click();
    }

    public void navigateToOrdersModule() {
        driver.findElement(ordersModuleLink).click();
    }

    public void selectOrderById(String orderId) {
        driver.findElement(orderIdField).sendKeys(orderId);
        driver.findElement(orderIdField).sendKeys(Keys.RETURN);
    }

    public void updateShipmentStatus(String status) {
        WebElement dropdown = driver.findElement(shipmentStatusDropdown);
        Select select = new Select(dropdown);
        select.selectByVisibleText(status);
    }

    public void checkAlertSystem() {
        driver.findElement(alertSystemButton).click();
    }

    public boolean verifyCustomerAlerts(String expectedAlert) {
        String alerts = driver.findElement(customerAlertsSection).getText();
        return alerts.contains(expectedAlert);
    }
}