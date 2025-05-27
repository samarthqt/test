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

    @FindBy(xpath = "//tr[@data-order-id='12345']")
    WebElement orderRow;

    @FindBy(xpath = "//button[@id='updateShipmentStatus']")
    WebElement updateShipmentStatusButton;

    @FindBy(xpath = "//select[@id='shipmentStatus']")
    WebElement shipmentStatusDropdown;

    @FindBy(xpath = "//option[@value='Dispatched']")
    WebElement dispatchedOption;

    @FindBy(id = "alertSystem")
    WebElement alertSystem;

    @FindBy(xpath = "//div[@id='customerAlert']")
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
        orderRow.click();
    }

    public void updateShipmentStatusToDispatched() {
        updateShipmentStatusButton.click();
        shipmentStatusDropdown.click();
        dispatchedOption.click();
    }

    public boolean checkAlertSystem() {
        return alertSystem.isDisplayed();
    }

    public boolean verifyCustomerAlert() {
        return customerAlert.isDisplayed();
    }
}
```java
@FindBy(xpath = "//tr[@data-order-id='98765']")
WebElement orderRow98765;

public void selectOrderById98765() {
    orderRow98765.click();
}
```