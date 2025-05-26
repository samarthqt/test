import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dynamics365Page {

    WebDriver driver;

    // Login elements
    @FindBy(id = "username")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "loginButton")
    WebElement loginButton;

    // Navigation elements
    @FindBy(xpath = "//a[@href='/orders']")
    WebElement ordersModuleLink;

    // Order selection elements
    @FindBy(xpath = "//tr[td[text()='12345']]//input[@type='checkbox']")
    WebElement orderCheckbox;

    @FindBy(id = "editOrderButton")
    WebElement editOrderButton;

    // Shipment status update elements
    @FindBy(id = "shipmentStatusDropdown")
    WebElement shipmentStatusDropdown;

    @FindBy(xpath = "//option[@value='Dispatched']")
    WebElement dispatchedOption;

    @FindBy(id = "saveButton")
    WebElement saveButton;

    // Alert system elements
    @FindBy(id = "alertSystemLink")
    WebElement alertSystemLink;

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
        ordersModuleLink.click();
    }

    public void selectOrderById() {
        orderCheckbox.click();
        editOrderButton.click();
    }

    public void updateShipmentStatusToDispatched() {
        shipmentStatusDropdown.click();
        dispatchedOption.click();
        saveButton.click();
    }

    public void checkAlertSystem() {
        alertSystemLink.click();
    }

    public boolean verifyCustomerAlert() {
        return customerAlert.isDisplayed();
    }
}
// Update the order selection to use the correct order ID
@FindBy(xpath = "//tr[td[text()='98765']]//input[@type='checkbox']")
WebElement orderCheckbox98765;

public void selectOrderById98765() {
    orderCheckbox98765.click();
    editOrderButton.click();
}