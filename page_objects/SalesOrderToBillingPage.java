package page_objects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class SalesOrderToBillingPage extends WebReusableComponents {

    protected By txtUsername = By.id("usernameField");
    protected By txtPassword = By.id("passwordField");
    protected By btnLogin = By.id("loginButton");
    protected By salesOrderScreen = By.id("salesOrderScreen");
    protected By katr1Field = By.id("katr1Field");
    protected By katr2Field = By.id("katr2Field");
    protected By btnCopyProcess = By.id("copyProcessButton");
    protected By errorMessage = By.id("errorMessage");
    protected By warningMessage = By.id("warningMessage");
    protected By btnLogout = By.id("logoutButton");

    protected By txtUsernameAlt = By.id("username");
    protected By txtPasswordAlt = By.id("password");
    protected By salesOrderToBillingScreen = By.id("salesOrderToBillingScreen");
    protected By txtKATR1 = By.id("katr1Field");
    protected By txtKATR2 = By.id("katr2Field");
    protected By btnCopyProcessAlt = By.id("copyProcessButton");
    protected By errorMessageAlt = By.id("errorMessage");

    public void loginToSAPSystem(String username, String password) {
        waitUntilElementVisible(txtUsername, 3);
        enterText(txtUsername, username);
        enterText(txtPassword, password);
        clickElement(btnLogin);
        waitUntilElementVisible(salesOrderScreen, 5);
    }

    public void navigateToSalesOrderToBillingScreen() {
        waitUntilElementVisible(salesOrderScreen, 3);
        clickElement(salesOrderScreen);
    }

    public void selectSalesOrderWithKATRValues(String katr1Value, String katr2Value) {
        waitUntilElementVisible(katr1Field, 3);
        enterText(katr1Field, katr1Value);
        waitUntilElementVisible(katr2Field, 3);
        enterText(katr2Field, katr2Value);
    }

    public void initiateCopyProcess() {
        waitUntilElementVisible(btnCopyProcess, 3);
        clickElement(btnCopyProcess);
    }

    public void verifyNoErrorsOrWarnings() {
        boolean isErrorVisible = isElementVisible(errorMessage, 3);
        boolean isWarningVisible = isElementVisible(warningMessage, 3);
        Assert.assertFalse(isErrorVisible, "Error message is displayed during the process.");
        Assert.assertFalse(isWarningVisible, "Warning message is displayed during the process.");
    }

    public void documentResultsForReview() {
        // Logic to document results (e.g., saving logs or screenshots)
        saveLogs("SalesOrderToBillingProcessLogs");
    }

    public void logoutFromSAPSystem() {
        waitUntilElementVisible(btnLogout, 3);
        clickElement(btnLogout);
    }

    public void loginToSAPSystem() {
        launchUrl("https://sap-cloud-system.com");
        waitUntilElementVisible(txtUsernameAlt, 5);
        enterText(txtUsernameAlt, "testUser");
        enterText(txtPasswordAlt, "testPassword");
        clickElement(btnLogin);
        waitUntilElementVisible(salesOrderToBillingScreen, 5);
    }

    public void navigateToSalesOrderToBillingScreen() {
        waitUntilElementVisible(salesOrderToBillingScreen, 5);
        clickElement(salesOrderToBillingScreen);
    }

    public void selectSalesOrderWithKATRValues(String katr1, String katr2) {
        waitUntilElementVisible(txtKATR1, 3);
        enterText(txtKATR1, katr1);
        waitUntilElementVisible(txtKATR2, 3);
        enterText(txtKATR2, katr2);
    }

    public void initiateCopyProcess() {
        waitUntilElementVisible(btnCopyProcessAlt, 3);
        clickElement(btnCopyProcessAlt);
    }

    public void verifyNoErrorsOrWarnings() {
        waitUntilElementNotVisible(errorMessageAlt, 5);
        Assert.assertFalse(isElementDisplayed(errorMessageAlt), "Error or warning message displayed during the process.");
    }

    public void documentResults() {
        // Implementation for documenting results (e.g., saving logs or screenshots)
        saveScreenshot("SalesOrderToBillingResults.png");
    }

    public void logoutFromSAPSystem() {
        waitUntilElementVisible(btnLogout, 3);
        clickElement(btnLogout);
    }
}
