public class Dynamics365Page {

    private WebDriver driver;

    // Login Page Elements
    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    // Orders Module Elements
    @FindBy(linkText = "Orders")
    private WebElement ordersModuleLink;

    @FindBy(xpath = "//tr[td[text()='98765']]/td/button[@class='selectOrder']")
    private WebElement selectOrderButton;

    // Order Details Elements
    @FindBy(id = "shipmentStatus")
    private WebElement shipmentStatusDropdown;

    @FindBy(id = "updateStatusButton")
    private WebElement updateStatusButton;

    // Alert System Elements
    @FindBy(linkText = "Alerts")
    private WebElement alertsLink;

    @FindBy(id = "customerAlerts")
    private WebElement customerAlertsSection;

    public Dynamics365Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void navigateToOrdersModule() {
        ordersModuleLink.click();
    }

    public void selectOrderById() {
        selectOrderButton.click();
    }

    public void updateShipmentStatus(String status) {
        Select dropdown = new Select(shipmentStatusDropdown);
        dropdown.selectByVisibleText(status);
        updateStatusButton.click();
    }

    public void checkAlerts() {
        alertsLink.click();
    }

    public boolean verifyCustomerAlerts(String expectedAlert) {
        return customerAlertsSection.getText().contains(expectedAlert);
    }
}