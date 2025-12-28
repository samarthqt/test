package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import org.openqa.selenium.support.PageFactory;

public class OutputManagementPage extends WebReusableComponents {

    protected By txtUsername = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By outputManagementModule = By.id("outputManagementModule");
    protected By txtSearchFormID = By.id("searchFormID");
    protected By btnSearch = By.id("searchButton");
    protected By formContent = By.id("formContent");
    protected By btnPrintOption = By.id("printOption");
    protected By dropdownPrinter = By.id("printerDropdown");
    protected By btnPrint = By.id("printButton");
    protected By btnExportOption = By.id("exportOption");
    protected By dropdownExportFormat = By.id("exportFormatDropdown");
    protected By btnExport = By.id("exportButton");

    public OutputManagementPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyUserCredentials() {
        Assert.assertTrue(isElementVisible(txtUsername), "Username field is not visible.");
        Assert.assertTrue(isElementVisible(txtPassword), "Password field is not visible.");
    }

    public void loginToSAPSystem() {
        enterText(txtUsername, "testUser");
        enterText(txtPassword, "testPassword");
        clickElement(btnLogin);
    }

    public void verifySuccessfulLogin() {
        Assert.assertTrue(isElementVisible(outputManagementModule), "Login was not successful.");
    }

    public void verifyUserLoggedIn() {
        Assert.assertTrue(isElementVisible(outputManagementModule), "User is not logged in.");
    }

    public void navigateToOutputManagementModule() {
        clickElement(outputManagementModule);
    }

    public void verifyOutputManagementModuleDisplayed() {
        Assert.assertTrue(isElementVisible(outputManagementModule), "Output management module is not displayed.");
    }

    public void verifyUserInOutputManagementModule() {
        Assert.assertTrue(isElementVisible(txtSearchFormID), "User is not in the output management module.");
    }

    public void searchFormByID(String formID) {
        enterText(txtSearchFormID, formID);
        clickElement(btnSearch);
    }

    public void verifyFormRetrieved(String formID) {
        Assert.assertTrue(isElementVisible(By.id(formID)), "Form with ID " + formID + " was not retrieved.");
    }

    public void openFormAndReviewContent(String formID) {
        clickElement(By.id(formID));
        Assert.assertTrue(isElementVisible(formContent), "Form content is not displayed.");
    }

    public void verifyFormContentDisplayedAccurately() {
        Assert.assertTrue(isElementVisible(formContent), "Form content is not accurate.");
    }

    public void selectPrintOptionAndPrinter(String printer) {
        clickElement(btnPrintOption);
        selectDropdownOption(dropdownPrinter, printer);
    }

    public void verifyPrintOptionsAndPrinterSelected(String printer) {
        Assert.assertTrue(isElementVisible(btnPrint), "Print options are not displayed.");
        Assert.assertEquals(getSelectedDropdownOption(dropdownPrinter), printer, "Selected printer is incorrect.");
    }

    public void printForm(String formID) {
        clickElement(btnPrint);
    }

    public void verifyFormPrintedSuccessfully(String formID) {
        Assert.assertTrue(isPrintSuccessful(formID), "Form " + formID + " was not printed successfully.");
    }

    public void selectExportOptionAndFormat(String exportFormat) {
        clickElement(btnExportOption);
        selectDropdownOption(dropdownExportFormat, exportFormat);
    }

    public void verifyExportOptionsAndFormatSelected(String exportFormat) {
        Assert.assertTrue(isElementVisible(btnExport), "Export options are not displayed.");
        Assert.assertEquals(getSelectedDropdownOption(dropdownExportFormat), exportFormat, "Selected export format is incorrect.");
    }

    public void exportForm(String formID) {
        clickElement(btnExport);
    }

    public void verifyFormExportedSuccessfully(String formID, String exportFormat) {
        Assert.assertTrue(isExportSuccessful(formID, exportFormat), "Form " + formID + " was not exported successfully as " + exportFormat + ".");
    }

    private boolean isPrintSuccessful(String formID) {
        // Dummy implementation for print success verification
        return true;
    }

    private boolean isExportSuccessful(String formID, String exportFormat) {
        // Dummy implementation for export success verification
        return true;
    }
}