
package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class private {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locator declarations
    private final By txtUserName = By.id(username);
    private final By txtPassword = By.id(password);
    private final By btnLogin = By.id(loginButton);
    private final By btnProceedToCheckout = By.id(proceedToCheckout);
    private final By txtFullName = By.id(fullName);
    private final By txtAddress = By.id(address);
    private final By txtCity = By.id(city);
    private final By txtPostalCode = By.id(postalCode);
    private final By txtPhone = By.id(phone);
    private final By paymentMethodDropdown = By.id(paymentMethod);
    private final By btnPlaceOrder = By.id(placeOrder);
    private final By orderConfirmationMessage = By.id(confirmationMessage);

    // Constructor with PageFactory initialization
    public private(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    // Action methods
    public void enterUserName(final String username) {
        WebElement userNameField = waitUntilElementVisible(txtUserName);
        userNameField.clear();
        userNameField.sendKeys(username);
    }

    public void enterPassword(final String password) {
        WebElement passwordField = waitUntilElementVisible(txtPassword);
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButton = waitUntilElementVisible(btnLogin);
        loginButton.click();
    }

    public void proceedToCheckout() {
        WebElement checkoutButton = waitUntilElementVisible(btnProceedToCheckout);
        checkoutButton.click();
    }

    public void enterShippingDetails(final String fullName, final String address, final String city, final String postalCode, final String phone) {
        WebElement fullNameField = waitUntilElementVisible(txtFullName);
        fullNameField.clear();
        fullNameField.sendKeys(fullName);

        WebElement addressField = waitUntilElementVisible(txtAddress);
        addressField.clear();
        addressField.sendKeys(address);

        WebElement cityField = waitUntilElementVisible(txtCity);
        cityField.clear();
        cityField.sendKeys(city);

        WebElement postalCodeField = waitUntilElementVisible(txtPostalCode);
        postalCodeField.clear();
        postalCodeField.sendKeys(postalCode);

        WebElement phoneField = waitUntilElementVisible(txtPhone);
        phoneField.clear();
        phoneField.sendKeys(phone);
    }

    public void selectPaymentMethod(final String paymentMethod) {
        WebElement paymentDropdown = waitUntilElementVisible(paymentMethodDropdown);
        paymentDropdown.sendKeys(paymentMethod);
    }

    public void placeOrder() {
        WebElement placeOrderButton = waitUntilElementVisible(btnPlaceOrder);
        placeOrderButton.click();
    }

    public void verifyOrderConfirmation(final String expectedMessage) {
        WebElement confirmationMessage = waitUntilElementVisible(orderConfirmationMessage);
        String actualMessage = confirmationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, Order confirmation message does not match.);
    }

    // Helper methods
    private WebElement waitUntilElementVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
