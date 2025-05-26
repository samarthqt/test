import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dynamics365Page {

    private WebDriver driver;

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    @FindBy(xpath = "//a[@href='/orders']")
    private WebElement ordersModuleLink;

    @FindBy(xpath = "//tr[@data-order-id='12345']")
    private WebElement orderRow;

    @FindBy(xpath = "//button[@id='editShipmentStatus']")
    private WebElement editShipmentStatusButton;

    @FindBy(xpath = "//select[@id='shipmentStatus']")
    private WebElement shipmentStatusDropdown;

    @FindBy(xpath = "//button[@id='saveShipmentStatus']")
    private WebElement saveShipmentStatusButton;

    @FindBy(xpath = "//a[@href='/alerts']")
    private WebElement alertsLink;

    @FindBy(xpath = "//div[@class='alert' and contains(text(), 'Dispatched')]")
    private WebElement dispatchedAlert;

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

    public void updateShipmentStatusToDispatched() {
        editShipmentStatusButton.click();
        shipmentStatusDropdown.sendKeys("Dispatched");
        saveShipmentStatusButton.click();
    }

    public void navigateToAlerts() {
        alertsLink.click();
    }

    public boolean verifyDispatchedAlert() {
        return dispatchedAlert.isDisplayed();
    }
}
@FindBy(xpath = "//tr[@data-order-id='98765']")
private WebElement orderRow98765;

public void selectOrderById98765() {
    orderRow98765.click();
}