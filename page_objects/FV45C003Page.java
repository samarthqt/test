package page_objects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.List;
import org.openqa.selenium.WebElement;

public class FV45C003Page extends WebReusableComponents {

    // CheckoutPage.java elements and methods
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

    // PaymentMethodsPage.java elements and methods
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

    // FV45C003Page.java elements and methods
    protected By txtUsername = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By transactionField = By.id("transactionField");
    protected By billingDocumentField = By.id("billingDocumentField");
    protected By btnSave = By.id("saveButton");
    protected By logoutButton = By.id("logoutButton");

    public void navigateToLoginPage() {
        launchUrl("https://sap-s4hana-cloud-login.com");
        waitUntilElementVisible(txtUsername, 5);
    }

    public void enterLoginCredentials(String username, String password) {
        enterText(txtUsername, username);
        enterText(txtPassword, password);
        clickElement(btnLogin);
    }

    public void verifyLoginSuccess() {
        Assert.assertTrue(isElementVisible(transactionField), "Login was not successful.");
    }

    public void verifyUserLoggedIn() {
        Assert.assertTrue(isElementVisible(transactionField), "User is not logged in.");
    }

    public void navigateToTransaction(String transactionCode) {
        enterText(transactionField, transactionCode);
        pressEnter(transactionField);
    }

    public void verifyTransactionScreenDisplayed(String transactionCode) {
        Assert.assertTrue(getPageTitle().contains(transactionCode), "Transaction screen not displayed.");
    }

    public void enterBillingDocumentNumber(String billingDocumentNumber) {
        enterText(billingDocumentField, billingDocumentNumber);
        pressEnter(billingDocumentField);
    }

    public void verifyBillingDocumentDetailsRetrieved() {
        Assert.assertTrue(isElementVisible(By.id("billingDetails")), "Billing document details not retrieved.");
    }

    public void verifyPartnerDataMappings(String partnerMapping) {
        String actualMapping = getTextFromElement(By.id("partnerMapping"));
        Assert.assertEquals(actualMapping, partnerMapping, "Partner data mappings do not match.");
    }

    public void verifyHeaderPartnerData() {
        Assert.assertTrue(isElementVisible(By.id("headerPartnerData")), "Header partner data not found.");
    }

    public void verifyCompleteHeaderPartnerData() {
        Assert.assertTrue(isElementVisible(By.id("completeHeaderData")), "Complete header partner data not found.");
    }

    public void initiateSalesDocumentCreation() {
        clickElement(By.id("createSalesDocument"));
    }

    public void verifyProcessingStarted() {
        Assert.assertTrue(isElementVisible(By.id("processingIndicator")), "Processing did not start.");
    }

    public void verifyPartnerDataInTargetDocument() {
        Assert.assertTrue(isElementVisible(By.id("targetPartnerData")), "Partner data not found in target document.");
    }

    public void verifyPartnerDataCopiedAccurately() {
        Assert.assertTrue(isElementVisible(By.id("accuratePartnerData")), "Partner data not copied accurately.");
    }

    public void saveSalesDocument() {
        clickElement(btnSave);
    }

    public void verifySalesDocumentSaved() {
        Assert.assertTrue(isElementVisible(By.id("salesDocumentSaved")), "Sales document not saved successfully.");
    }

    public void navigateToDisplayBillingDetailReport() {
        clickElement(By.id("displayBillingDetailReport"));
    }

    public void verifyDisplayBillingDetailReportScreen() {
        Assert.assertTrue(isElementVisible(By.id("billingDetailReportScreen")), "Billing detail report screen not displayed.");
    }

    public void verifyReferencedSalesOrders() {
        Assert.assertTrue(isElementVisible(By.id("referencedSalesOrders")), "Referenced sales orders not found.");
    }

    public void verifyReferencedSalesOrdersDisplayed() {
        Assert.assertTrue(isElementVisible(By.id("salesOrdersDisplayed")), "Referenced sales orders not displayed correctly.");
    }

    public void verifyLinkageBetweenDocuments() {
        Assert.assertTrue(isElementVisible(By.id("documentLinkage")), "Linkage between documents not established.");
    }

    public void verifyLinkageEstablished() {
        Assert.assertTrue(isElementVisible(By.id("linkageEstablished")), "Linkage not established correctly.");
    }

    public void verifyFV45C003RoutineCompletion() {
        Assert.assertTrue(isElementVisible(By.id("routineCompletion")), "FV45C003 routine did not complete successfully.");
    }

    public void verifyRoutineCompletion() {
        Assert.assertTrue(isElementVisible(By.id("routineCompleted")), "Routine did not complete successfully.");
    }

    public void logout() {
        clickElement(logoutButton);
    }

    public void verifyLogoutSuccess() {
        Assert.assertTrue(isElementVisible(txtUsername), "Logout was not successful.");
    }

    // Additional methods from other FV45C003Page classes
    // (Continue adding all methods from the provided list without modification)
}
