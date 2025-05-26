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

    @FindBy(id = "ordersModule")
    WebElement ordersModuleLink;

    @FindBy(xpath = "//tr[@data-order-id='12345']")
    WebElement orderRow;

    @FindBy(id = "shipmentStatus")
    WebElement shipmentStatusDropdown;

    @FindBy(xpath = "//option[@value='Dispatched']")
    WebElement dispatchedOption;

    @FindBy(id = "updateShipmentButton")
    WebElement updateShipmentButton;

    @FindBy(id = "alertSystem")
    WebElement alertSystemLink;

    @FindBy(id = "customerAlert")
    WebElement customerAlert;

    public Dynamics365Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void logIn(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void navigateToOrdersModule() {
        ordersModuleLink.click();
    }

    public void selectOrderById() {
        orderRow.click();
    }

    public void updateShipmentStatus() {
        shipmentStatusDropdown.click();
        dispatchedOption.click();
        updateShipmentButton.click();
    }

    public void checkAlertSystem() {
        alertSystemLink.click();
    }

    public boolean verifyCustomerAlert() {
        return customerAlert.isDisplayed();
    }
}
@FindBy(xpath = "//tr[@data-order-id='98765']")
WebElement order98765Row;

public void selectOrderById98765() {
    order98765Row.click();
}