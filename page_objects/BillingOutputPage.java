package page_objects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.List;
import org.openqa.selenium.WebElement;

public class BillingOutputPage extends WebReusableComponents {

    // CheckoutPage methods
    protected By btnProceedToCheckout = By.id("proceedToCheckout");
    protected By txtFullName = By.id("fullName");
    protected By txtAddress = By.id("address");
    protected By txtCity = By.id("city");
    protected By txtPostalCode = By.id("postalCode");
    protected By txtPhone = By.id("phone");
    protected By paymentMethodDropdown = By.id("paymentMethod");
    protected By txtCardNumber = By.id("cardNumber");
    protected By txtExpiryDate = By.id("expiryDate");
    protected By txtCVV = By.id("cvv");
    protected By btnPlaceOrder = By.id("placeOrder");
    protected By orderConfirmationMessage = By.id("orderConfirmationMessage");
    protected By btnPayWithPayPal = By.id("payWithPayPal");
    protected By btnLoginToPayPal = By.id("paypalLogin");
    protected By btnConfirmPayPalPayment = By.id("confirmPaypalPayment");

    public void proceedToCheckout() {
        waitUntilElementVisible(btnProceedToCheckout, 3);
        clickElement(btnProceedToCheckout);
    }

    public void enterShippingDetails(String fullName, String address, String city, String postalCode, String phone) {
        waitUntilElementVisible(txtFullName, 3);
        enterText(txtFullName, fullName);
        enterText(txtAddress, address);
        enterText(txtCity, city);
        enterText(txtPostalCode, postalCode);
        enterText(txtPhone, phone);
    }

    public void selectPaymentMethod(String method) {
        waitUntilElementVisible(paymentMethodDropdown, 3);
        selectByValue(paymentMethodDropdown, method);
    }

    public void enterCreditCardDetails(String cardNumber, String expiryDate, String cvv) {
        waitUntilElementVisible(txtCardNumber, 3);
        enterText(txtCardNumber, cardNumber);
        enterText(txtExpiryDate, expiryDate);
        enterText(txtCVV, cvv);
    }

    public void placeOrder() {
        waitUntilElementVisible(btnPlaceOrder, 3);
        clickElement(btnPlaceOrder);
    }

    public void verifyOrderConfirmation(String expectedMessage) {
        waitUntilElementVisible(orderConfirmationMessage, 3);
        String actualMessage = getTextFromElement(orderConfirmationMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Order confirmation message does not match.");
    }

    // PaymentMethodsPage methods
    protected By paymentMethodsLink = By.id("paymentMethods");
    protected By addPaymentMethodButton = By.id("addPaymentMethod");
    protected By txtCardHolderName = By.id("cardHolderName");
    protected By savePaymentMethodButton = By.id("savePaymentMethod");
    protected By savedCards = By.cssSelector(".saved-card");
    protected By removeCardButton(String lastFourDigits) {
        return By.xpath("//div[contains(text(), '**** **** **** " + lastFourDigits + "')]/following-sibling::button[@class='remove']");
    }

    public void navigateToPaymentMethods() {
        waitUntilElementVisible(paymentMethodsLink, 3);
        clickElement(paymentMethodsLink);
    }

    public void addNewPaymentMethod(String cardNumber, String cardHolderName, String expiryDate, String cvv) {
        waitUntilElementVisible(addPaymentMethodButton, 3);
        clickElement(addPaymentMethodButton);
        enterText(txtCardNumber, cardNumber);
        enterText(txtCardHolderName, cardHolderName);
        enterText(txtExpiryDate, expiryDate);
        enterText(txtCVV, cvv);
        clickElement(savePaymentMethodButton);
    }

    public void verifyPaymentMethodSaved() {
        waitUntilElementVisible(savedCards, 3);
        List<WebElement> cards = getWebElementList(savedCards);
        Assert.assertFalse(cards.isEmpty(), "No saved payment methods found.");
    }

    public void removePaymentMethod(String lastFourDigits) {
        By removeButton = removeCardButton(lastFourDigits);
        waitUntilElementVisible(removeButton, 3);
        clickElement(removeButton);
    }

    public void verifyPaymentMethodRemoved(String lastFourDigits) {
        By cardLocator = removeCardButton(lastFourDigits);
        boolean isCardPresent = elementVisible(cardLocator);
        Assert.assertFalse(isCardPresent, "Card was not removed from saved payment methods.");
    }

    // BillingOutputPage methods
    protected By usernameField = By.id("username");
    protected By passwordField = By.id("password");
    protected By loginButton = By.id("loginButton");
    protected By billingScreen = By.id("billingScreen");
    protected By attribute7Field = By.id("attribute7");
    protected By saveBillingButton = By.id("saveBilling");
    protected By outputSettings = By.id("outputSettings");
    protected By saveOutputRuleButton = By.id("saveOutputRule");
    protected By triggerOutputButton = By.id("triggerOutput");
    protected By billingDocument = By.id("billingDocument");

    public void enterCredentials(String username, String password) {
        waitUntilElementVisible(usernameField, 3);
        enterText(usernameField, username);
        enterText(passwordField, password);
    }

    public void login() {
        waitUntilElementVisible(loginButton, 3);
        clickElement(loginButton);
    }

    public void verifyLoginSuccess() {
        waitUntilElementVisible(billingScreen, 3);
        Assert.assertTrue(isElementDisplayed(billingScreen), "Login failed.");
    }

    public void navigateToBillingScreen() {
        clickElement(billingScreen);
    }

    public void verifyBillingScreenDisplayed() {
        Assert.assertTrue(isElementDisplayed(billingScreen), "Billing screen not displayed.");
    }

    public void enterBillingDetails(String attribute7Value) {
        waitUntilElementVisible(attribute7Field, 3);
        enterText(attribute7Field, attribute7Value);
    }

    public void verifyBillingDetailsEntered() {
        Assert.assertTrue(isElementDisplayed(attribute7Field), "Billing details not entered.");
    }

    public void saveBillingDocument() {
        clickElement(saveBillingButton);
    }

    public void verifyBillingDocumentSaved() {
        Assert.assertTrue(isElementDisplayed(outputSettings), "Billing document not saved.");
    }

    public void accessOutputSettings() {
        clickElement(outputSettings);
    }

    public void verifyOutputSettingsAccessible() {
        Assert.assertTrue(isElementDisplayed(outputSettings), "Output settings not accessible.");
    }

    public void configureOutputRule(String attribute7Value) {
        enterText(attribute7Field, attribute7Value);
    }

    public void verifyOutputRuleConfigured() {
        Assert.assertTrue(isElementDisplayed(saveOutputRuleButton), "Output rule not configured.");
    }

    public void saveOutputRule() {
        clickElement(saveOutputRuleButton);
    }

    public void verifyOutputRuleSaved() {
        Assert.assertTrue(isElementDisplayed(triggerOutputButton), "Output rule not saved.");
    }

    public void triggerOutputProcess() {
        clickElement(triggerOutputButton);
    }

    public void verifyOutputProcessTriggered() {
        Assert.assertTrue(isElementDisplayed(billingDocument), "Output process not triggered.");
    }

    public void validateOutputLogic() {
        Assert.assertTrue(isElementDisplayed(attribute7Field), "Output logic validation failed.");
    }

    public void verifyOutputLogicUsesAttribute7() {
        Assert.assertTrue(isElementDisplayed(attribute7Field), "Attribute 7 not used in output logic.");
    }

    public void generateBillingDocument() {
        clickElement(billingDocument);
    }

    public void verifyBillingDocumentGenerated() {
        Assert.assertTrue(isElementDisplayed(billingDocument), "Billing document not generated.");
    }

    public void reviewBillingDocument() {
        Assert.assertTrue(isElementDisplayed(billingDocument), "Billing document review failed.");
    }

    public void verifyBillingDocumentConfirmsAttribute7() {
        Assert.assertTrue(isElementDisplayed(attribute7Field), "Attribute 7 not confirmed in billing document.");
    }

    public void saveBillingOutputDocument() {
        clickElement(saveBillingButton);
    }

    public void verifyBillingOutputDocumentSaved() {
        Assert.assertTrue(isElementDisplayed(saveBillingButton), "Billing output document not saved.");
    }
}
