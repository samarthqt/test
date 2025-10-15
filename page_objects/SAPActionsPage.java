package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class SAPActionsPage extends WebReusableComponents {

    protected By txtUsername = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By mainMenu = By.id("mainMenu");
    protected By invoiceCorrectionRequestScreen = By.id("invoiceCorrectionRequestScreen");
    protected By requestTypeDropdown = By.id("requestType");
    protected By customerDetailsField = By.id("customerDetails");
    protected By billingAmountField = By.id("billingAmount");
    protected By btnSaveRequest = By.id("saveRequest");
    protected By documentNumberField = By.id("documentNumber");
    protected By outputGenerationButton = By.id("outputGeneration");
    protected By zpdtTemplateVerification = By.id("zpdtTemplate");
    protected By printProgramVerification = By.id("printProgram");
    protected By printButton = By.id("printButton");
    protected By printedOutputVerification = By.id("printedOutput");
    protected By outputReadyForDelivery = By.id("outputReady");
    protected By logoutButton = By.id("logoutButton");

    public void enterCredentials(String username, String password) {
        waitUntilElementVisible(txtUsername, 3);
        enterText(txtUsername, username);
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, password);
    }

    public void loginToSAP() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    public void verifyNavigationToMainMenu() {
        waitUntilElementVisible(mainMenu, 3);
        Assert.assertTrue(isElementDisplayed(mainMenu), "Main menu is not displayed.");
    }

    public void verifyMainMenuDisplayed() {
        Assert.assertTrue(isElementDisplayed(mainMenu), "Main menu is not displayed.");
    }

    public void navigateToInvoiceCorrectionRequestScreen() {
        waitUntilElementVisible(invoiceCorrectionRequestScreen, 3);
        clickElement(invoiceCorrectionRequestScreen);
    }

    public void verifyInvoiceCorrectionRequestScreenDisplayed() {
        Assert.assertTrue(isElementDisplayed(invoiceCorrectionRequestScreen), "Invoice Correction Request screen is not displayed.");
    }

    public void selectInvoiceCorrectionRequestType(String requestType) {
        waitUntilElementVisible(requestTypeDropdown, 3);
        selectByValue(requestTypeDropdown, requestType);
    }

    public void enterCustomerAndBillingDetails(String customerDetails, String billingAmount) {
        waitUntilElementVisible(customerDetailsField, 3);
        enterText(customerDetailsField, customerDetails);
        waitUntilElementVisible(billingAmountField, 3);
        enterText(billingAmountField, billingAmount);
    }

    public void verifyRequestTypeSelected(String requestType) {
        String selectedType = getSelectedValue(requestTypeDropdown);
        Assert.assertEquals(selectedType, requestType, "Request type does not match.");
    }

    public void verifyCustomerAndBillingDetailsEntered() {
        Assert.assertTrue(isElementDisplayed(customerDetailsField), "Customer details are not entered.");
        Assert.assertTrue(isElementDisplayed(billingAmountField), "Billing details are not entered.");
    }

    public void verifyRequiredDetailsEntered() {
        Assert.assertTrue(isElementDisplayed(customerDetailsField), "Required details are not entered.");
    }

    public void saveInvoiceCorrectionRequest() {
        waitUntilElementVisible(btnSaveRequest, 3);
        clickElement(btnSaveRequest);
    }

    public void verifyRequestSavedSuccessfully() {
        waitUntilElementVisible(documentNumberField, 3);
        Assert.assertTrue(isElementDisplayed(documentNumberField), "Request is not saved successfully.");
    }

    public void verifyDocumentNumberGenerated() {
        String documentNumber = getTextFromElement(documentNumberField);
        Assert.assertNotNull(documentNumber, "Document number is not generated.");
    }

    public void triggerOutputGenerationProcess() {
        waitUntilElementVisible(outputGenerationButton, 3);
        clickElement(outputGenerationButton);
    }

    public void verifyOutputGenerationProcessInitiated() {
        Assert.assertTrue(isElementDisplayed(outputGenerationButton), "Output generation process is not initiated.");
    }

    public void verifyTemplateUsedForZGL1Form() {
        Assert.assertTrue(isElementDisplayed(zpdtTemplateVerification), "ZPDT template is not used.");
    }

    public void verifyZGL1FormGeneratedUsingZPDTTemplate() {
        Assert.assertTrue(isElementDisplayed(zpdtTemplateVerification), "ZGL1 form is not generated using ZPDT template.");
    }

    public void ensurePrintProgramInvoked() {
        Assert.assertTrue(isElementDisplayed(printProgramVerification), "Print Program SD_INVOICE_PRINT01 is not invoked.");
    }

    public void verifyPrintProgramInvokedSuccessfully() {
        Assert.assertTrue(isElementDisplayed(printProgramVerification), "Print Program SD_INVOICE_PRINT01 is not invoked successfully.");
    }

    public void verifyZGL1FormGeneratedSuccessfully() {
        Assert.assertTrue(isElementDisplayed(zpdtTemplateVerification), "ZGL1 form is not generated successfully.");
    }

    public void printZGL1Output() {
        waitUntilElementVisible(printButton, 3);
        clickElement(printButton);
    }

    public void verifyZGL1OutputPrintedSuccessfully() {
        Assert.assertTrue(isElementDisplayed(printedOutputVerification), "ZGL1 output is not printed successfully.");
    }

    public void verifyPrintedZGL1Output() {
        Assert.assertTrue(isElementDisplayed(printedOutputVerification), "Printed ZGL1 output is not verified.");
    }

    public void verifyPrintedOutputFormat() {
        Assert.assertTrue(isElementDisplayed(printedOutputVerification), "Printed output format does not match.");
    }

    public void verifyPrintedOutputDetails() {
        Assert.assertTrue(isElementDisplayed(printedOutputVerification), "Printed output details are not complete.");
    }

    public void validateOutputReadinessForDelivery() {
        waitUntilElementVisible(outputReadyForDelivery, 3);
        clickElement(outputReadyForDelivery);
    }

    public void confirmOutputReadyForDelivery() {
        Assert.assertTrue(isElementDisplayed(outputReadyForDelivery), "Output is not ready for customer delivery.");
    }

    public void verifyAllActionsCompleted() {
        Assert.assertTrue(isElementDisplayed(mainMenu), "All actions are not completed.");
    }

    public void logoutFromSAP() {
        waitUntilElementVisible(logoutButton, 3);
        clickElement(logoutButton);
    }

    public void verifyLogoutSuccessful() {
        Assert.assertTrue(isElementDisplayed(logoutButton), "Logout is not successful.");
    }
}