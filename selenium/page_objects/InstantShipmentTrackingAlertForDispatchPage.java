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

    @FindBy(linkText = "Orders")
    WebElement ordersModuleLink;

    @FindBy(xpath = "//tr[td[text()='12345']]//a")
    WebElement order12345Link;

    @FindBy(id = "shipmentStatusDropdown")
    WebElement shipmentStatusDropdown;

    @FindBy(xpath = "//option[text()='Dispatched']")
    WebElement dispatchedOption;

    @FindBy(id = "saveButton")
    WebElement saveButton;

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
        ordersModuleLink.click();
    }

    public void selectOrder12345() {
        order12345Link.click();
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

@FindBy(xpath = "//tr[td[text()='98765']]//a")
WebElement order98765Link;

public void selectOrder98765() {
    order98765Link.click();
}