import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dynamics365Page {

    WebDriver driver;

    @FindBy(id = "username")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "loginButton")
    WebElement loginButton;

    @FindBy(xpath = "//nav//a[text()='Orders']")
    WebElement ordersModule;

    @FindBy(xpath = "//tr[td[text()='12345']]//button[text()='Select']")
    WebElement selectOrderButton;

    @FindBy(id = "shipmentStatusDropdown")
    WebElement shipmentStatusDropdown;

    @FindBy(xpath = "//option[text()='Dispatched']")
    WebElement dispatchedOption;

    @FindBy(id = "saveButton")
    WebElement saveButton;

    @FindBy(id = "alertSystem")
    WebElement alertSystem;

    @FindBy(xpath = "//div[@class='alert' and contains(text(), 'Customer Alert')]")
    WebElement customerAlert;

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
        ordersModule.click();
    }

    public void selectOrderById() {
        selectOrderButton.click();
    }

    public void updateShipmentStatusToDispatched() {
        shipmentStatusDropdown.click();
        dispatchedOption.click();
        saveButton.click();
    }

    public boolean checkAlertSystemForOutgoingAlerts() {
        return alertSystem.isDisplayed();
    }

    public boolean verifyCustomerAlertReceived() {
        return customerAlert.isDisplayed();
    }
}
@FindBy(xpath = "//tr[td[text()='98765']]//button[text()='Select']")
WebElement selectOrder98765Button;

public void selectOrderById(String orderId) {
    if (orderId.equals("98765")) {
        selectOrder98765Button.click();
    } else {
        selectOrderButton.click(); // Assuming this is for order ID 12345
    }
}