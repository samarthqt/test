package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PartnerPage {

    @FindBy(id = "username")
    private WebElement txtUserName;

    @FindBy(id = "password")
    private WebElement txtPassword;

    @FindBy(id = "loginButton")
    private WebElement btnLogin;

    @FindBy(id = "proceedToCheckout")
    private WebElement btnProceedToCheckout;

    @FindBy(id = "fullName")
    private WebElement txtFullName;

    @FindBy(id = "address")
    private WebElement txtAddress;

    @FindBy(id = "city")
    private WebElement txtCity;

    @FindBy(id = "postalCode")
    private WebElement txtPostalCode;

    @FindBy(id = "phone")
    private WebElement txtPhone;

    @FindBy(id = "paymentMethod")
    private WebElement paymentMethodDropdown;

    @FindBy(id = "placeOrder")
    private WebElement btnPlaceOrder;

    @FindBy(id = "confirmationMessage")
    private WebElement orderConfirmationMessage;

    @FindBy(id = "findPartnerButton")
    private WebElement findPartnerButton;

    @FindBy(id = "partnerPageHeader")
    private WebElement partnerPageHeader;

    public PartnerPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void enterUserName(String username) {
        waitUntilElementVisible(txtUserName, 3);
        txtUserName.sendKeys(username);
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword, 3);
        txtPassword.sendKeys(password);
    }

    public void clickLoginButton() {
        waitUntilElementVisible(btnLogin, 3);
        btnLogin.click();
    }

    public void proceedToCheckout() {
        waitUntilElementVisible(btnProceedToCheckout, 3);
        btnProceedToCheckout.click();
    }

    public void enterShippingDetails(String fullName, String address, String city, String postalCode, String phone) {
        waitUntilElementVisible(txtFullName, 3);
        txtFullName.sendKeys(fullName);
        txtAddress.sendKeys(address);
        txtCity.sendKeys(city);
        txtPostalCode.sendKeys(postalCode);
        txtPhone.sendKeys(phone);
    }

    public void selectPaymentMethod(String paymentMethod) {
        waitUntilElementVisible(paymentMethodDropdown, 3);
        paymentMethodDropdown.sendKeys(paymentMethod);
    }

    public void placeOrder() {
        waitUntilElementVisible(btnPlaceOrder, 3);
        btnPlaceOrder.click();
    }

    public void verifyOrderConfirmation(String expectedMessage) {
        waitUntilElementVisible(orderConfirmationMessage, 3);
        String actualMessage = orderConfirmationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Order confirmation message does not match.");
    }

    public void clickFindPartnerButton() {
        waitUntilElementVisible(findPartnerButton, 3);
        findPartnerButton.click();
    }

    public boolean isPartnerPageDisplayed() {
        waitUntilElementVisible(partnerPageHeader, 3);
        return partnerPageHeader.isDisplayed();
    }

    private void waitUntilElementVisible(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}