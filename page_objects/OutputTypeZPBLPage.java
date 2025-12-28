package page_objects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class OutputTypeZPBLPage extends WebReusableComponents {

    protected By txtUsername = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By txtTransactionCode = By.id("transactionCode");
    protected By transactionInput = By.id("transactionInput");
    protected By btnExecute = By.id("executeButton");
    protected By documentDetails = By.id("documentDetails");
    protected By menuOutputRendering = By.id("outputRenderingMenu");
    protected By dropdownOutputType = By.id("outputTypeDropdown");
    protected By optionOutputTypeZPBL = By.id("outputTypeZPBL");
    protected By renderingStatus = By.id("renderingStatus");
    protected By systemLogs = By.id("systemLogs");
    protected By errorMessageBox = By.id("errorMessageBox");
    protected By btnLogout = By.id("logoutButton");

    public void loginToSAP() {
        waitUntilElementVisible(txtUsername, 3);
        enterText(txtUsername, "authorizedUser");
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, "securePassword");
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    public void loginToSAPSystem(String username, String password) {
        waitUntilElementVisible(txtUsername, 3);
        enterText(txtUsername, username);
        enterText(txtPassword, password);
        clickElement(btnLogin);
    }

    public void navigateToTransactionVF03() {
        waitUntilElementVisible(txtTransactionCode, 3);
        enterText(txtTransactionCode, "VF03");
        waitUntilElementVisible(btnExecute, 3);
        clickElement(btnExecute);
    }

    public void enterCancellationBillingDocumentNumber(String cancellationBillingDocument) {
        waitUntilElementVisible(txtTransactionCode, 3);
        enterText(txtTransactionCode, cancellationBillingDocument);
    }

    public void executeTransaction() {
        waitUntilElementVisible(btnExecute, 3);
        clickElement(btnExecute);
    }

    public void verifyCancellationBillingDocumentDetails() {
        waitUntilElementVisible(documentDetails, 3);
        Assert.assertTrue(isElementDisplayed(documentDetails), "Document details are not displayed.");
    }

    public void selectOutputRenderingOption() {
        waitUntilElementVisible(menuOutputRendering, 3);
        clickElement(menuOutputRendering);
    }

    public void chooseOutputType(String outputType) {
        waitUntilElementVisible(dropdownOutputType, 3);
        selectByValue(dropdownOutputType, outputType);
    }

    public void chooseOutputTypeZPBL() {
        waitUntilElementVisible(optionOutputTypeZPBL, 3);
        clickElement(optionOutputTypeZPBL);
    }

    public void verifyOutputRenderingProcess() {
        waitUntilElementVisible(renderingStatus, 3);
        String status = getTextFromElement(renderingStatus);
        Assert.assertEquals(status, "Processing", "Output rendering process did not start correctly.");
    }

    public void verifySystemAdaptationToConfiguration() {
        String status = getTextFromElement(renderingStatus);
        Assert.assertEquals(status, "Configuration Updated", "System did not adapt to updated configuration.");
    }

    public void verifyOutputDocumentGeneration() {
        String status = getTextFromElement(renderingStatus);
        Assert.assertEquals(status, "Document Generated", "Output document was not generated successfully.");
    }

    public void verifySystemLogsForRendering() {
        waitUntilElementVisible(systemLogs, 3);
        String logs = getTextFromElement(systemLogs);
        Assert.assertTrue(logs.contains("ZPBL rendering successful"), "System logs do not confirm successful rendering.");
    }

    public void verifyErrorMessage(String expectedMessage, String outputType) {
        waitUntilElementVisible(errorMessageBox, 3);
        String actualMessage = getTextFromElement(errorMessageBox);
        Assert.assertEquals(actualMessage, expectedMessage, "Error message for Output Type " + outputType + " does not match.");
    }

    public void verifyRenderingProcessNotProceeded() {
        boolean isRenderingProceeded = isElementPresent(By.id("renderingSuccess"));
        Assert.assertFalse(isRenderingProceeded, "Rendering process should not proceed.");
    }

    public void verifyErrorLogs(String outputType) {
        String logs = getSystemLogs();
        Assert.assertTrue(logs.contains("Error related to Output Type " + outputType), "Error logs do not contain expected message for Output Type " + outputType);
    }

    public void verifyNoOutputDocumentsCreated() {
        boolean isDocumentCreated = isElementPresent(By.id("outputDocument"));
        Assert.assertFalse(isDocumentCreated, "No output documents should be created.");
    }

    public void reconfigureOutputTypeZPBL() {
        waitUntilElementVisible(By.id("reconfigureButton"), 3);
        clickElement(By.id("reconfigureButton"));
    }

    public void verifyRenderingAllowed() {
        boolean isRenderingAllowed = isElementPresent(By.id("renderingSuccess"));
        Assert.assertTrue(isRenderingAllowed, "Rendering process should be allowed after reconfiguration.");
    }

    public void revertOutputTypeZPBLConfiguration() {
        System.out.println("Reverting Output Type ZPBL configuration.");
    }

    public void verifySystemAdaptationToRevertedConfiguration() {
        String status = getTextFromElement(renderingStatus);
        Assert.assertEquals(status, "Configuration Reverted", "System did not adapt to reverted configuration.");
    }

    public void documentErrorMessageAndResolutionSteps() {
        waitUntilElementVisible(By.id("documentationArea"), 3);
        enterText(By.id("documentationArea"), "Error message and resolution steps documented.");
        clickElement(By.id("saveDocumentationButton"));
    }

    public void documentConfigurationChangesAndRenderingProcess() {
        System.out.println("Documenting configuration changes and rendering process.");
    }

    public void verifyDocumentationSuccess() {
        boolean isDocumentationSaved = isElementPresent(By.id("documentationSuccess"));
        Assert.assertTrue(isDocumentationSaved, "Documentation should be saved successfully.");
    }

    public void logoutFromSAP() {
        waitUntilElementVisible(btnLogout, 3);
        clickElement(btnLogout);
    }

    public void logoutFromSAPSystem() {
        waitUntilElementVisible(btnLogout, 3);
        clickElement(btnLogout);
    }

    public void verifyLogoutSuccess() {
        boolean isLoggedOut = isElementPresent(By.id("loginPage"));
        Assert.assertTrue(isLoggedOut, "User should be logged out successfully.");
    }
}
