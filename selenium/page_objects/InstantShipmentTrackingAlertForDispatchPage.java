import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dynamics365Page {

    WebDriver driver;

    // Login Elements
    @FindBy(id = "username")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "loginButton")
    WebElement loginButton;

    // Navigation Elements
    @FindBy(id = "ordersModule")
    WebElement ordersModule;

    // Order Elements
    @FindBy(xpath = "//tr[td[text()='12345']]")
    WebElement orderRow;

    @FindBy(id = "shipmentStatus")
    WebElement shipmentStatusDropdown;

    @FindBy(xpath = "//option[text()='Dispatched']")
    WebElement dispatchedOption;

    @FindBy(id = "saveButton")
    WebElement saveButton;

    // Alert Elements
    @FindBy(id = "alertSystem")
    WebElement alertSystem;

    @FindBy(id = "customerAlert")
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
        orderRow.click();
    }

    public void updateShipmentStatusToDispatched() {
        shipmentStatusDropdown.click();
        dispatchedOption.click();
        saveButton.click();
    }

    public boolean checkAlertSystem() {
        return alertSystem.isDisplayed();
    }

    public boolean verifyCustomerAlert() {
        return customerAlert.isDisplayed();
    }
}
@FindBy(xpath = "//tr[td[text()='98765']]")
WebElement order98765Row;

public void selectOrderById(String orderId) {
    WebElement orderRow = driver.findElement(By.xpath("//tr[td[text()='" + orderId + "']]"));
    orderRow.click();
}