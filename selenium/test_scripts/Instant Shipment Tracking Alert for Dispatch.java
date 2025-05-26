import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.pageobjects.Dynamics365Page;
import com.framework.reusable.WebReusableComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

package com.tests;


public class ShipmentTrackingTest extends WebReusableComponents {

    private Dynamics365Page dynamics365Page;

    @BeforeMethod
    public void setUp() {
        initializeDriver();
        dynamics365Page = new Dynamics365Page(driver);
        dynamics365Page.logIn("validUsername", "validPassword");
    }

    @Test
    public void verifyInstantShipmentTrackingAlert() {
        dynamics365Page.navigateToOrdersModule();
        dynamics365Page.selectOrderById();
        dynamics365Page.updateShipmentStatusToDispatched();
        dynamics365Page.navigateToAlerts();
        boolean alertReceived = dynamics365Page.verifyDispatchedAlert();
        assert alertReceived : "Customer did not receive the expected alert.";
    }

    @AfterMethod
    public void tearDown() {
        closeDriver();
    }
}

class Dynamics365Page {

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

package com.tests;

public class ShipmentTrackingTest extends WebReusableComponents {

    private Dynamics365Page dynamics365Page;

    @BeforeMethod
    public void setUp() {
        initializeDriver();
        dynamics365Page = new Dynamics365Page(driver);
        dynamics365Page.logIn("validUsername", "validPassword");
    }

    @Test
    public void verifyInstantShipmentTrackingAlert() {
        dynamics365Page.navigateToOrdersModule();
        dynamics365Page.selectOrderById("98765");
        dynamics365Page.updateShipmentStatusToDispatched();
        dynamics365Page.checkAlertSystem();
        boolean alertReceived = dynamics365Page.verifyDispatchedAlert();
        assert alertReceived : "Customer did not receive the expected alert.";
    }

    @AfterMethod
    public void tearDown() {
        closeDriver();
    }
}

class Dynamics365Page {

    private WebDriver driver;

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    @FindBy(xpath = "//a[@href='/orders']")
    private WebElement ordersModuleLink;

    @FindBy(xpath = "//tr[@data-order-id='98765']")
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

    public void selectOrderById(String orderId) {
        orderRow.click();
    }

    public void updateShipmentStatusToDispatched() {
        editShipmentStatusButton.click();
        shipmentStatusDropdown.sendKeys("Dispatched");
        saveShipmentStatusButton.click();
    }

    public void checkAlertSystem() {
        alertsLink.click();
    }

    public boolean verifyDispatchedAlert() {
        return dispatchedAlert.isDisplayed();
    }
}