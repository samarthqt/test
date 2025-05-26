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

    @FindBy(linkText = "Orders")
    WebElement ordersModule;

    @FindBy(xpath = "//tr[td[text()='12345']]//a")
    WebElement order12345Link;

    @FindBy(id = "shipmentStatusDropdown")
    WebElement shipmentStatusDropdown;

    @FindBy(xpath = "//option[text()='Dispatched']")
    WebElement dispatchedOption;

    @FindBy(id = "alertSystem")
    WebElement alertSystem;

    @FindBy(xpath = "//div[@class='alert' and contains(text(), 'customer')]")
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

    public void selectOrder12345() {
        order12345Link.click();
    }

    public void updateShipmentStatusToDispatched() {
        shipmentStatusDropdown.click();
        dispatchedOption.click();
    }

    public boolean checkAlertSystemForOutgoingAlerts() {
        return alertSystem.isDisplayed();
    }

    public boolean verifyAlertReceivedByCustomer() {
        return customerAlert.isDisplayed();
    }
}