public class Dynamics365Page {

    private WebDriver driver;

    public Dynamics365Page(WebDriver driver) {
        this.driver = driver;
    }

    // Login elements
    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    // Navigation elements
    @FindBy(linkText = "Orders")
    private WebElement ordersModuleLink;

    // Order elements
    @FindBy(xpath = "//tr[td[contains(text(),'12345')]]")
    private WebElement orderRow;

    @FindBy(id = "shipmentStatus")
    private WebElement shipmentStatusDropdown;

    @FindBy(id = "updateShipmentButton")
    private WebElement updateShipmentButton;

    // Alert system elements
    @FindBy(id = "alertSystem")
    private WebElement alertSystem;

    @FindBy(id = "customerAlert")
    private WebElement customerAlert;

    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void navigateToOrdersModule() {
        ordersModuleLink.click();
    }

    public void selectOrderById(String orderId) {
        orderRow.click();
    }

    public void updateShipmentStatus(String status) {
        Select shipmentDropdown = new Select(shipmentStatusDropdown);
        shipmentDropdown.selectByVisibleText(status);
        updateShipmentButton.click();
    }

    public boolean checkAlertSystem() {
        return alertSystem.isDisplayed();
    }

    public boolean verifyCustomerAlert() {
        return customerAlert.isDisplayed();
    }
}