import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dynamics365Page {

    WebDriver driver;

    public Dynamics365Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "loginButton")
    WebElement loginButton;

    @FindBy(id = "ordersModule")
    WebElement ordersModule;

    @FindBy(xpath = "//table//tr[td[text()='12345']]")
    WebElement orderRow;

    @FindBy(id = "shipmentStatusDropdown")
    WebElement shipmentStatusDropdown;

    @FindBy(xpath = "//option[text()='Dispatched']")
    WebElement dispatchedOption;

    @FindBy(id = "alertSystemButton")
    WebElement alertSystemButton;

    @FindBy(id = "customerAlert")
    WebElement customerAlert;

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
    }

    public void checkAlertSystem() {
        alertSystemButton.click();
    }

    public String getCustomerAlert() {
        return customerAlert.getText();
    }
}
@FindBy(xpath = "//table//tr[td[text()='98765']]")
WebElement orderRow98765;

public void selectOrderById98765() {
    orderRow98765.click();
}