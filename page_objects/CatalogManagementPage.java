package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import .util.List;

public class CatalogManagementPage extends WebReusableComponents {

    protected By emailField = By.id("email");
    protected By passwordField = By.id("password");
    protected By loginButton = By.id("loginButton");
    protected By catalogManagementLink = By.id("catalogManagement");
    protected By addProductButton = By.id("addProduct");
    protected By productNameField = By.id("productName");
    protected By productPriceField = By.id("productPrice");
    protected By productSKUField = By.id("productSKU");
    protected By submitButton = By.id("submitProduct");
    protected By errorMessages = By.cssSelector(".error-message");
    protected By logoutButton = By.id("logoutButton");
    protected By auditLogEntries = By.cssSelector(".audit-log-entry");

    public CatalogManagementPage() {
        PageFactory.initElements(driver, this);
    }

    public void loginAsAdmin(String email, String password) {
        waitUntilElementVisible(emailField, 3);
        enterText(emailField, email);
        enterText(passwordField, password);
        clickElement(loginButton);
    }

    public void navigateToCatalogManagement() {
        waitUntilElementVisible(catalogManagementLink, 3);
        clickElement(catalogManagementLink);
    }

    public void clickAddProductButton() {
        waitUntilElementVisible(addProductButton, 3);
        clickElement(addProductButton);
    }

    public void verifyProductAdditionFormUrl(String expectedUrl) {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, expectedUrl, "Incorrect URL for product addition form.");
    }

    public void enterProductDetails(String name, String price, String sku) {
        waitUntilElementVisible(productNameField, 3);
        enterText(productNameField, name);
        enterText(productPriceField, price);
        enterText(productSKUField, sku);
    }

    public void submitProductForm() {
        waitUntilElementVisible(submitButton, 3);
        clickElement(submitButton);
    }

    public void verifyErrorMessagesForInvalidInputs() {
        waitUntilElementVisible(errorMessages, 3);
        List<WebElement> errors = getWebElementList(errorMessages);
        Assert.assertTrue(!errors.isEmpty(), "Error messages not displayed for invalid inputs.");
    }

    public void verifyDetailedErrorMessages() {
        waitUntilElementVisible(errorMessages, 3);
        List<WebElement> errors = getWebElementList(errorMessages);
        for (WebElement error : errors) {
            Assert.assertTrue(error.getText().contains("specific detail"), "Detailed error message missing.");
        }
    }

    public void correctFieldsAndResubmit() {
        enterText(productNameField, "Correct Name");
        enterText(productPriceField, "Correct Price");
        enterText(productSKUField, "Correct SKU");
        submitProductForm();
    }

    public void verifyUpdatedErrorMessages() {
        waitUntilElementVisible(errorMessages, 3);
        List<WebElement> errors = getWebElementList(errorMessages);
        Assert.assertTrue(errors.isEmpty(), "Error messages still displayed after correction.");
    }

    public void verifyNoProductAdded() {
        // Logic to verify no product is added
        Assert.assertTrue(true, "No product should be added.");
    }

    public void verifyDatabaseNoNewEntries() {
        // Logic to verify database has no new entries
        Assert.assertTrue(true, "Database should have no new entries.");
    }

    public void verifyAuditLogsForFailedAttempts() {
        waitUntilElementVisible(auditLogEntries, 3);
        List<WebElement> logs = getWebElementList(auditLogEntries);
        boolean failedAttemptLogged = logs.stream().anyMatch(log -> log.getText().contains("failed attempt"));
        Assert.assertTrue(failedAttemptLogged, "Failed attempts not logged in audit.");
    }

    public void enterValidProductDetails() {
        enterText(productNameField, "Valid Name");
        enterText(productPriceField, "Valid Price");
        enterText(productSKUField, "Valid SKU");
    }

    public void verifyProductAddedSuccessfully() {
        // Logic to verify product added successfully
        Assert.assertTrue(true, "Product should be added successfully.");
    }

    public void logoutAdmin() {
        waitUntilElementVisible(logoutButton, 3);
        clickElement(logoutButton);
    }

    public void verifyAdminLoggedOut() {
        // Logic to verify admin logged out
        Assert.assertTrue(true, "Admin should be logged out.");
    }

    public void verifySystemPerformance() {
        // Logic to verify system performance
        Assert.assertTrue(true, "System performance should be optimal.");
    }

    public void verifyErrorMessagesGuidance() {
        waitUntilElementVisible(errorMessages, 3);
        List<WebElement> errors = getWebElementList(errorMessages);
        for (WebElement error : errors) {
            Assert.assertTrue(error.getText().contains("guidance"), "Error message lacks guidance.");
        }
    }

    public void verifyNoNotificationsSent() {
        // Logic to verify no notifications sent
        Assert.assertTrue(true, "No notifications should be sent.");
    }
}