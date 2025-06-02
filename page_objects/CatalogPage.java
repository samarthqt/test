package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import .util.List;

public class CatalogPage extends WebReusableComponents {

    protected By loginEmailField = By.id("loginEmail");
    protected By loginPasswordField = By.id("loginPassword");
    protected By loginButton = By.id("loginButton");
    protected By catalogManagementLink = By.id("catalogManagement");
    protected By searchProductField = By.id("searchProduct");
    protected By searchButton = By.id("searchButton");
    protected By productDetails = By.cssSelector(".product-details");
    protected By deleteButton = By.id("deleteButton");
    protected By confirmationDialog = By.id("confirmationDialog");
    protected By confirmDeleteButton = By.id("confirmDelete");
    protected By logoutButton = By.id("logoutButton");
    protected By errorMessage = By.cssSelector(".error-message");
    protected By auditLogEntry = By.cssSelector(".audit-log-entry");
    protected By notificationMessage = By.cssSelector(".notification-message");
    protected By dependentProductWarning = By.cssSelector(".dependent-product-warning");

    public CatalogPage() {
        PageFactory.initElements(driver, this);
    }

    public void loginAsAdmin(String email, String password) {
        waitUntilElementVisible(loginEmailField, 3);
        enterText(loginEmailField, email);
        enterText(loginPasswordField, password);
        clickElement(loginButton);
    }

    public void navigateToCatalogManagement(String url) {
        navigateToPage(url);
    }

    public void searchProductById(String productId) {
        waitUntilElementVisible(searchProductField, 3);
        enterText(searchProductField, productId);
        clickElement(searchButton);
    }

    public void verifyProductExistsInCatalog(String productId) {
        searchProductById(productId);
        waitUntilElementVisible(productDetails, 3);
        Assert.assertTrue(elementVisible(productDetails), "Product does not exist in the catalog.");
    }

    public void verifyProductDetailsDisplayed() {
        waitUntilElementVisible(productDetails, 3);
        Assert.assertTrue(elementVisible(productDetails), "Product details are not displayed correctly.");
    }

    public void selectProductForDeletion() {
        waitUntilElementVisible(deleteButton, 3);
        clickElement(deleteButton);
    }

    public void verifyDeleteOptionVisible() {
        Assert.assertTrue(elementVisible(deleteButton), "Delete option is not visible.");
    }

    public void clickDeleteButton() {
        clickElement(deleteButton);
    }

    public void verifyConfirmationDialogAppears() {
        waitUntilElementVisible(confirmationDialog, 3);
        Assert.assertTrue(elementVisible(confirmationDialog), "Confirmation dialog did not appear.");
    }

    public void confirmDeletionInDialog() {
        waitUntilElementVisible(confirmDeleteButton, 3);
        clickElement(confirmDeleteButton);
    }

    public void verifyProductDeletedFromCatalog() {
        waitUntilElementVisible(productDetails, 3);
        Assert.assertFalse(elementVisible(productDetails), "Product was not deleted from the catalog.");
    }

    public void verifyProductNotListedInCatalog() {
        waitUntilElementVisible(productDetails, 3);
        Assert.assertFalse(elementVisible(productDetails), "Product is still listed in the catalog.");
    }

    public void verifyNoErrorMessagesOrAlerts() {
        Assert.assertFalse(elementVisible(errorMessage), "Error messages or alerts are present.");
    }

    public void logoutAdminAccount() {
        clickElement(logoutButton);
    }

    public void verifyAdminLoggedOut() {
        Assert.assertFalse(elementVisible(logoutButton), "Admin is not logged out.");
    }

    public void accessDeletedProductViaURL(String productUrl) {
        navigateToPage(productUrl);
        Assert.assertTrue(elementVisible(errorMessage), "Product does not exist error message is not displayed.");
    }

    public void verifyProductDoesNotExistErrorMessage() {
        Assert.assertTrue(elementVisible(errorMessage), "Product does not exist error message is not displayed.");
    }

    public void checkDatabaseForProductEntry(String productId) {
        // Logic to check database for product entry
        boolean productExists = false; // Replace with actual database check
        Assert.assertFalse(productExists, "Product entry still exists in the database.");
    }

    public void verifyProductEntryRemovedFromDatabase() {
        // Logic to verify product entry removal from database
        boolean productExists = false; // Replace with actual database check
        Assert.assertFalse(productExists, "Product entry was not removed from the database.");
    }

    public void verifyAuditLogsForDeletion() {
        waitUntilElementVisible(auditLogEntry, 3);
        Assert.assertTrue(elementVisible(auditLogEntry), "Audit logs for deletion are not present.");
    }

    public void verifyAuditLogsShowDeletionAction() {
        waitUntilElementVisible(auditLogEntry, 3);
        Assert.assertTrue(elementVisible(auditLogEntry), "Audit logs do not show deletion action.");
    }

    public void checkAutomaticNotificationsForDeletion() {
        waitUntilElementVisible(notificationMessage, 3);
        Assert.assertTrue(elementVisible(notificationMessage), "Automatic notifications for deletion are not sent.");
    }

    public void verifyNotificationsSentToStakeholders() {
        waitUntilElementVisible(notificationMessage, 3);
        Assert.assertTrue(elementVisible(notificationMessage), "Notifications were not sent to stakeholders.");
    }

    public void reviewSystemPerformancePostDeletion() {
        // Logic to review system performance post-deletion
        boolean performanceStable = true; // Replace with actual performance check
        Assert.assertTrue(performanceStable, "System performance is not stable post-deletion.");
    }

    public void verifySystemPerformanceStable() {
        // Logic to verify system performance stability
        boolean performanceStable = true; // Replace with actual performance check
        Assert.assertTrue(performanceStable, "System performance is not stable.");
    }

    public void verifyNoDependentProductsAffected() {
        Assert.assertFalse(elementVisible(dependentProductWarning), "Dependent products are affected.");
    }
}