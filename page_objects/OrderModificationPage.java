package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class OrderModificationPage extends WebReusableComponents {

    protected By usernameField = By.id("username");
    protected By passwordField = By.id("password");
    protected By loginButton = By.id("loginButton");
    protected By salesOrderScreenLink = By.id("salesOrderScreen");
    protected By searchField = By.id("searchOrder");
    protected By searchButton = By.id("searchButton");
    protected By errorMessage = By.id("errorMessage");
    protected By modifyOrderButton = By.id("modifyOrder");
    protected By modificationErrorMessage = By.id("modificationErrorMessage");
    protected By systemLogs = By.id("systemLogs");
    protected By saveButton = By.id("saveButton");
    protected By saveErrorMessage = By.id("saveErrorMessage");
    protected By logoutButton = By.id("logoutButton");
    protected By logoutSuccessMessage = By.id("logoutSuccessMessage");

    public void loginToSystem(String username, String password) {
        waitUntilElementVisible(usernameField, 3);
        enterText(usernameField, username);
        enterText(passwordField, password);
        clickElement(loginButton);
    }

    public void navigateToSalesOrderScreen() {
        waitUntilElementVisible(salesOrderScreenLink, 3);
        clickElement(salesOrderScreenLink);
    }

    public void searchOrder(String uniqueOrderID) {
        waitUntilElementVisible(searchField, 3);
        enterText(searchField, uniqueOrderID);
        clickElement(searchButton);
    }

    public void verifyErrorMessage(String expectedMessage) {
        waitUntilElementVisible(errorMessage, 3);
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Error message does not match.");
    }

    public void modifyOrderDetails(String updatedOrderDetails) {
        waitUntilElementVisible(modifyOrderButton, 3);
        clickElement(modifyOrderButton);
        enterText(By.id("orderDetails"), updatedOrderDetails);
    }

    public void verifyModificationErrorMessage(String expectedMessage) {
        waitUntilElementVisible(modificationErrorMessage, 3);
        String actualMessage = getTextFromElement(modificationErrorMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Modification error message does not match.");
    }

    public void checkSystemLogs(String uniqueOrderID) {
        waitUntilElementVisible(systemLogs, 3);
        String logs = getTextFromElement(systemLogs);
        Assert.assertTrue(logs.contains(uniqueOrderID), "System logs do not contain the expected error.");
    }

    public void verifyLogError(String expectedLogError) {
        waitUntilElementVisible(systemLogs, 3);
        String logs = getTextFromElement(systemLogs);
        Assert.assertTrue(logs.contains(expectedLogError), "Log error does not match.");
    }

    public void attemptToSaveChanges() {
        waitUntilElementVisible(saveButton, 3);
        clickElement(saveButton);
    }

    public void verifySaveErrorMessage(String expectedMessage) {
        waitUntilElementVisible(saveErrorMessage, 3);
        String actualMessage = getTextFromElement(saveErrorMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Save error message does not match.");
    }

    public void logoutFromSystem() {
        waitUntilElementVisible(logoutButton, 3);
        clickElement(logoutButton);
    }

    public void verifyLogoutSuccess() {
        waitUntilElementVisible(logoutSuccessMessage, 3);
        String actualMessage = getTextFromElement(logoutSuccessMessage);
        Assert.assertEquals(actualMessage, "User logged out successfully", "Logout success message does not match.");
    }
}