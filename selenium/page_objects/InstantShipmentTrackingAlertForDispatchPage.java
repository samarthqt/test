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

    @FindBy(xpath = "//a[text()='Orders']")
    WebElement ordersModuleLink;

    @FindBy(xpath = "//tr[td[text()='12345']]/td/a[text()='Select']")
    WebElement orderSelectLink;

    @FindBy(id = "shipmentStatusDropdown")
    WebElement shipmentStatusDropdown;

    @FindBy(xpath = "//option[text()='Dispatched']")
    WebElement dispatchedOption;

    @FindBy(id = "saveButton")
    WebElement saveButton;

    @FindBy(id = "alertSystemButton")
    WebElement alertSystemButton;

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
        ordersModuleLink.click();
    }

    public void selectOrderById() {
        orderSelectLink.click();
    }

    public void updateShipmentStatusToDispatched() {
        shipmentStatusDropdown.click();
        dispatchedOption.click();
        saveButton.click();
    }

    public void checkAlertSystem() {
        alertSystemButton.click();
    }

    public boolean verifyCustomerAlertReceived() {
        return customerAlert.isDisplayed();
    }
}
@FindBy(xpath = "//tr[td[text()='98765']]/td/a[text()='Select']")
WebElement specificOrderSelectLink;

public void selectOrderById(String orderId) {
    WebElement orderSelectLink = driver.findElement(By.xpath("//tr[td[text()='" + orderId + "']]/td/a[text()='Select']"));
    orderSelectLink.click();
}