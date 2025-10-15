package page_objects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.List;
import org.openqa.selenium.WebElement;

public class ZPB1FormPage extends WebReusableComponents {

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

    // ZPB1FormPage.java elements and methods
    protected By formManagementApp = By.id("formManagementApp");
    protected By searchField = By.id("searchField");
    protected By configurationDetails = By.id("configurationDetails");
    protected By saveButton = By.id("saveButton");
    protected By activateButton = By.id("activateButton");
    protected By printButton = By.id("printButton");
    protected By btnCreateNewTemplate = By.id("createNewTemplate");
    protected By dropdownBaseTemplate = By.id("baseTemplateDropdown");
    protected By txtFormTemplateName = By.id("formTemplateName");
    protected By dropdownDocumentType = By.id("documentTypeDropdown");
    protected By dropdownBillingDocumentType = By.id("billingDocumentTypeDropdown");
    protected By errorMessage = By.id("errorMessage");
    protected By btnSaveTemplate = By.id("saveTemplate");
    protected By btnActivateTemplate = By.id("activateTemplate");
    protected By btnGenerateBillingDocument = By.id("generateBillingDocument");
    protected By btnPrintForm = By.id("printForm");
    protected By billingApplicationLink = By.id("billingAppLink");
    protected By loginButton = By.id("loginButton");
    protected By createTemplateButton = By.id("createTemplate");
    protected By activateTemplateButton = By.id("activateTemplate");
    protected By documentTypeDropdown = By.id("documentType");
    protected By assignTemplateButton = By.id("assignTemplate");
    protected By errorMessageBox = By.id("errorMessage");
    protected By modifyDocumentTypeButton = By.id("modifyDocumentType");
    protected By generateOutputButton = By.id("generateOutput");
    protected By printFormButton = By.id("printForm");
    protected By saveDocumentButton = By.id("saveDocument");
    protected By confirmationMessage = By.id("confirmationMessage");

    public void loginToSAPSystem() { /* Implementation */ }
    public void navigateToFormManagement() { clickElement(formManagementApp); }
    public void verifyFormManagementDisplayed() { Assert.assertTrue(isElementVisible(formManagementApp), "Form Management application is not displayed."); }
    public void verifyFormBaseTemplateAvailable(String templateName) { Assert.assertTrue(isTextPresent(templateName), "Form base template is not available."); }
    public void verifyConfigurationCompleted() { /* Implementation */ }
    public void searchForFormTemplate(String templateName) { enterText(searchField, templateName); pressEnter(searchField); }
    public void verifyFormTemplateFound() { Assert.assertTrue(isElementVisible(configurationDetails), "Form template is not found."); }
    public void verifyDocumentTypesConfigured(String billingType, String docType) { /* Implementation */ }
    public void openConfigurationDetails() { clickElement(configurationDetails); }
    public void verifyConfigurationDetailsDisplayed() { Assert.assertTrue(isElementVisible(configurationDetails), "Configuration details are not displayed."); }
    public void verifyDocumentType(String docType) { Assert.assertEquals(getTextFromElement(configurationDetails), docType, "Document type does not match."); }
    public void verifyTemplateAssociation(String docType, String billingType) { /* Implementation */ }
    public void checkPeriodicBillingFieldsAlignment() { /* Implementation */ }
    public void verifyFieldsAlignmentWithZPDT() { /* Implementation */ }
    public void verifyFieldsIncluded(String field1, String field2, String field3) { /* Implementation */ }
    public void modifyField(String fieldName) { /* Implementation */ }
    public void verifyFieldModified(String fieldName) { /* Implementation */ }
    public void revertFieldModification(String fieldName) { /* Implementation */ }
    public void verifyFieldReverted(String fieldName) { /* Implementation */ }
    public void verifyFieldsModifiedAndReverted() { /* Implementation */ }
    public void saveConfigurationChanges() { clickElement(saveButton); }
    public void verifyConfigurationChangesSaved() { /* Implementation */ }
    public void verifyTemplateNotActivated() { /* Implementation */ }
    public void activateTemplate() { clickElement(activateButton); }
    public void verifyTemplateActivated() { /* Implementation */ }
    public void generateBillingDocument(String docType) { /* Implementation */ }
    public void verifyBillingDocumentGenerated(String docType) { /* Implementation */ }
    public void verifyFormAssignmentToBillingDocument() { /* Implementation */ }
    public void verifyFormCorrectlyAssigned() { /* Implementation */ }
    public void printForm() { clickElement(printButton); }
    public void verifyFormPrinted() { /* Implementation */ }
    public void verifyOutputFormatting() { /* Implementation */ }
    public void loginToSAP() { waitUntilElementVisible(loginButton, 5); clickElement(loginButton); }
    public void navigateToBillingApplication() { waitUntilElementVisible(billingApplicationLink, 5); clickElement(billingApplicationLink); }
    public void createAndActivateZPB1FormTemplate() { waitUntilElementVisible(createTemplateButton, 5); clickElement(createTemplateButton); waitUntilElementVisible(activateTemplateButton, 5); clickElement(activateTemplateButton); }
    public void createBillingDocument(String documentType) { waitUntilElementVisible(documentTypeDropdown, 5); selectByValue(documentTypeDropdown, documentType); }
    public void assignZPB1FormTemplate() { waitUntilElementVisible(assignTemplateButton, 5); clickElement(assignTemplateButton); }
    public void verifySystemBehavior(String expectedBehavior) { String actualBehavior = getTextFromElement(errorMessageBox); Assert.assertTrue(actualBehavior.contains(expectedBehavior), "System behavior does not match expected behavior."); }
    public void verifyErrorMessage(String expectedMessage) { String actualMessage = getTextFromElement(errorMessageBox); Assert.assertEquals(actualMessage, expectedMessage, "Error message does not match."); }
    public void modifyDocumentTypeToZPB() { waitUntilElementVisible(modifyDocumentTypeButton, 5); clickElement(modifyDocumentTypeButton); selectByValue(documentTypeDropdown, "ZPB"); }
    public void verifyTemplateAssignmentSuccess() { String successMessage = getTextFromElement(confirmationMessage); Assert.assertEquals(successMessage, "ZPB1 form template successfully assigned.", "Template assignment was not successful."); }
    public void verifyTemplateAssociationWithDocument() { String associationMessage = getTextFromElement(confirmationMessage); Assert.assertTrue(associationMessage.contains("ZPB1 form template associated with billing document"), "Template association verification failed."); }
    public void generateBillingDocumentOutput() { waitUntilElementVisible(generateOutputButton, 5); clickElement(generateOutputButton); }
    public void verifyBillingDocumentOutput() { String outputMessage = getTextFromElement(confirmationMessage); Assert.assertEquals(outputMessage, "Billing document output generated successfully.", "Billing document output generation failed."); }
    public void printZPB1Form() { waitUntilElementVisible(printFormButton, 5); clickElement(printFormButton); }
    public void verifyPrintedFormOutput() { String printMessage = getTextFromElement(confirmationMessage); Assert.assertEquals(printMessage, "ZPB1 form printed successfully.", "Printed form output verification failed."); }
    public void checkForErrorsOrWarnings() { boolean hasErrors = isElementPresent(errorMessageBox); Assert.assertFalse(hasErrors, "Errors or warnings were encountered during the process."); }
    public void verifyNoErrorsOrWarnings() { boolean hasErrors = isElementPresent(errorMessageBox); Assert.assertFalse(hasErrors, "Errors or warnings were encountered during the process."); }
    public void validatePrintedFormAlignment() { String alignmentMessage = getTextFromElement(confirmationMessage); Assert.assertTrue(alignmentMessage.contains("Alignment validated"), "Printed form alignment validation failed."); }
    public void saveGeneratedBillingDocument() { waitUntilElementVisible(saveDocumentButton, 5); clickElement(saveDocumentButton); }
    public void verifyBillingDocumentSaved() { String saveMessage = getTextFromElement(confirmationMessage); Assert.assertEquals(saveMessage, "Billing document saved successfully.", "Billing document save verification failed."); }
    public void verifyErrorLoggedForUnsupportedDocumentType() { String errorLogMessage = getTextFromElement(errorMessageBox); Assert.assertTrue(errorLogMessage.contains("unsupported document type assignment"), "Error log verification failed."); }
}
