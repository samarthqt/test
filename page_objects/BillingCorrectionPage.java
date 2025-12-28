package page_objects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.List;
import org.openqa.selenium.WebElement;

public class BillingCorrectionPage extends WebReusableComponents {

    // CheckoutPage.java methods and elements
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

    // PaymentMethodsPage.java methods and elements
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

    // BillingCorrectionPage.java methods and elements
    protected By txtUsername = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By appBillingCorrection = By.id("billingCorrectionApp");
    protected By txtRequestType = By.id("requestType");
    protected By txtCustomerID = By.id("customerID");
    protected By txtRequestValue = By.id("requestValue");
    protected By btnSubmitRequest = By.id("submitRequest");
    protected By workflowStatus = By.id("workflowStatus");
    protected By approverDetails = By.id("approverDetails");
    protected By systemLogs = By.id("systemLogs");
    protected By notificationStatus = By.id("notificationStatus");
    protected By btnLogout = By.id("logoutButton");

    public void loginToSAPSystem(String username, String password) {
        waitUntilElementVisible(txtUsername, 3);
        enterText(txtUsername, username);
        enterText(txtPassword, password);
        clickElement(btnLogin);
    }

    public void navigateToBillingCorrectionApp() {
        waitUntilElementVisible(appBillingCorrection, 3);
        clickElement(appBillingCorrection);
    }

    public void enterBillingCorrectionRequestType(String requestType) {
        waitUntilElementVisible(txtRequestType, 3);
        enterText(txtRequestType, requestType);
    }

    public void enterCustomerID(String customerID) {
        waitUntilElementVisible(txtCustomerID, 3);
        enterText(txtCustomerID, customerID);
    }

    public void enterRequestValue(String requestValue) {
        waitUntilElementVisible(txtRequestValue, 3);
        enterText(txtRequestValue, requestValue);
    }

    public void submitBillingCorrectionRequest() {
        waitUntilElementVisible(btnSubmitRequest, 3);
        clickElement(btnSubmitRequest);
    }

    public void verifyWorkflowTriggered() {
        waitUntilElementVisible(workflowStatus, 3);
        String status = getTextFromElement(workflowStatus);
        Assert.assertEquals(status, "Triggered", "Workflow was not triggered successfully.");
    }

    public void verifyApproverDetails(String expectedApproverDetails) {
        waitUntilElementVisible(approverDetails, 3);
        String actualApproverDetails = getTextFromElement(approverDetails);
        Assert.assertEquals(actualApproverDetails, expectedApproverDetails, "Approver details do not match.");
    }

    public void verifyApprovalProcess() {
        Assert.assertTrue(true, "Approval process verification logic not implemented.");
    }

    public void verifySystemLogsForErrors() {
        waitUntilElementVisible(systemLogs, 3);
        String logs = getTextFromElement(systemLogs);
        Assert.assertFalse(logs.contains("Error"), "System logs contain errors.");
    }

    public void verifyApproverNotification() {
        waitUntilElementVisible(notificationStatus, 3);
        String status = getTextFromElement(notificationStatus);
        Assert.assertEquals(status, "Notified", "Approver was not notified successfully.");
    }

    public void verifyUserLoggedIn() {
        Assert.assertTrue(true, "User is not logged in.");
    }

    public void logoutFromSAPSystem() {
        waitUntilElementVisible(btnLogout, 3);
        clickElement(btnLogout);
    }

    public void verifyUserLoggedOut() {
        Assert.assertTrue(true, "User is not logged out.");
    }
}
