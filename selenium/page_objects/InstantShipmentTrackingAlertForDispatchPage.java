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

    @FindBy(linkText = "Orders")
    WebElement ordersModuleLink;

    @FindBy(xpath = "//tr[td[contains(text(),'12345')]]")
    WebElement orderRow;

    @FindBy(id = "shipmentStatusDropdown")
    WebElement shipmentStatusDropdown;

    @FindBy(xpath = "//option[text()='Dispatched']")
    WebElement dispatchedOption;

    @FindBy(id = "alertSystem")
    WebElement alertSystemLink;

    @FindBy(id = "customerAlert")
    WebElement customerAlert;

    public void login(String username, String password) {
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

    public void updateShipmentStatusToDispatched() {
        shipmentStatusDropdown.click();
        dispatchedOption.click();
    }

    public void checkAlertSystem() {
        alertSystemLink.click();
    }

    public boolean verifyCustomerAlert() {
        return customerAlert.isDisplayed();
    }
}
@FindBy(xpath = "//tr[td[contains(text(),'98765')]]")
WebElement order98765Row;

public void selectOrderById98765() {
    order98765Row.click();
}