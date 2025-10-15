package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class PrintOutputPage extends WebReusableComponents {

    protected By txtUsername = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By outputManagementScreen = By.id("outputManagementScreen");
    protected By dropdownOutputType = By.id("outputTypeDropdown");
    protected By dropdownTemplate = By.id("templateDropdown");
    protected By btnInitiatePrint = By.id("initiatePrintButton");
    protected By lblPrintSuccessMessage = By.id("printSuccessMessage");
    protected By lblOutputAccuracyMessage = By.id("outputAccuracyMessage");
    protected By systemLogs = By.id("systemLogs");
    protected By complianceStatus = By.id("complianceStatus");

    public void loginToSAP() {
        launchUrl("https://sap-system-url.com");
        waitUntilElementVisible(txtUsername, 5);
        enterText(txtUsername, "validUsername");
        enterText(txtPassword, "validPassword");
        clickElement(btnLogin);
    }

    public void navigateToOutputManagementScreen() {
        waitUntilElementVisible(outputManagementScreen, 5);
        clickElement(outputManagementScreen);
    }

    public void selectOutputForPrinting(String outputType, String template) {
        waitUntilElementVisible(dropdownOutputType, 3);
        selectByValue(dropdownOutputType, outputType);
        waitUntilElementVisible(dropdownTemplate, 3);
        selectByValue(dropdownTemplate, template);
    }

    public void initiatePrintingProcess(String outputType, String maximumFields) {
        waitUntilElementVisible(btnInitiatePrint, 3);
        clickElement(btnInitiatePrint);
    }

    public void verifyOutputPrintedSuccessfully(String outputType) {
        waitUntilElementVisible(lblPrintSuccessMessage, 3);
        String actualMessage = getTextFromElement(lblPrintSuccessMessage);
        Assert.assertEquals(actualMessage, outputType + " output printed successfully", "Print success message does not match.");
    }

    public void verifyOutputAccuracyAndFormatting(String outputType) {
        waitUntilElementVisible(lblOutputAccuracyMessage, 3);
        String actualMessage = getTextFromElement(lblOutputAccuracyMessage);
        Assert.assertTrue(actualMessage.contains(outputType + " output is accurate and well-formatted"), "Output accuracy and formatting message does not match.");
    }

    public void verifySystemLogsForErrorsOrWarnings() {
        waitUntilElementVisible(systemLogs, 3);
        String logs = getTextFromElement(systemLogs);
        Assert.assertFalse(logs.contains("error") || logs.contains("warning"), "System logs contain errors or warnings.");
    }

    public void verifyComplianceWithStandards() {
        waitUntilElementVisible(complianceStatus, 3);
        String complianceMessage = getTextFromElement(complianceStatus);
        Assert.assertEquals(complianceMessage, "System complies with operational and billing standards", "Compliance status does not match.");
    }
}