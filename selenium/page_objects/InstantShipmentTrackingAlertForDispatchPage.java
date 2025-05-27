import org.openqa.selenium.By;
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
    WebElement ordersModule;

    @FindBy(xpath = "//tr[@data-id='12345']")
    WebElement order12345;

    @FindBy(id = "shipmentStatus")
    WebElement shipmentStatusDropdown;

    @FindBy(xpath = "//option[@value='Dispatched']")
    WebElement dispatchedOption;

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

    public void selectOrder12345() {
        order12345.click();
    }

    public void updateShipmentStatus() {
        shipmentStatusDropdown.click();
        dispatchedOption.click();
    }

    public void checkAlertSystem() {
        alertSystem.click();
    }

    public boolean verifyCustomerAlert() {
        return customerAlert.isDisplayed();
    }
}

@FindBy(xpath = "//tr[@data-id='98765']")
WebElement order98765;

public void selectOrder98765() {
    order98765.click();
}