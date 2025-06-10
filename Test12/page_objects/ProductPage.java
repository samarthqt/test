package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import .util.List;

public class ProductPage extends WebReusableComponents {

    protected By adminLoginButton = By.id("adminLogin");
    protected By productNameField = By.id("productName");
    protected By productDescriptionField = By.id("productDescription");
    protected By productPriceField = By.id("productPrice");
    protected By productImageField = By.id("productImage");
    protected By productStockField = By.id("productStock");
    protected By productCategoryField = By.id("productCategory");
    protected By addProductButton = By.id("addProduct");
    protected By editProductButton = By.id("editProduct");
    protected By deleteProductButton = By.id("deleteProduct");
    protected By confirmationPrompt = By.id("confirmationPrompt");
    protected By notificationMessage = By.id("notificationMessage");
    protected By errorMessage = By.id("errorMessage");

    public ProductPage() {
        PageFactory.initElements(driver, this);
    }

    public void loginAsAdmin() {
        waitUntilElementVisible(adminLoginButton, 3);
        clickElement(adminLoginButton);
    }

    public void addProduct(String name, String description, String price, String image, String stock, String category) {
        waitUntilElementVisible(productNameField, 3);
        enterText(productNameField, name);
        enterText(productDescriptionField, description);
        enterText(productPriceField, price);
        enterText(productImageField, image);
        enterText(productStockField, stock);
        enterText(productCategoryField, category);
        clickElement(addProductButton);
    }

    public void verifyProductAdded() {
        waitUntilElementVisible(notificationMessage, 3);
        String message = getTextFromElement(notificationMessage);
        Assert.assertEquals(message, "Product successfully added.", "Product addition failed.");
    }

    public void verifyNotificationReceived() {
        waitUntilElementVisible(notificationMessage, 3);
        String message = getTextFromElement(notificationMessage);
        Assert.assertTrue(message.contains("successfully"), "Notification not received.");
    }

    public void verifyChangeLogged() {
        // Implement logic to verify change logged
    }

    public void verifyProductExists(String name) {
        waitUntilElementVisible(productNameField, 3);
        String actualName = getTextFromElement(productNameField);
        Assert.assertEquals(actualName, name, "Product does not exist.");
    }

    public void editProduct(String name, String description, String price, String image, String stock, String category) {
        waitUntilElementVisible(editProductButton, 3);
        enterText(productNameField, name);
        enterText(productDescriptionField, description);
        enterText(productPriceField, price);
        enterText(productImageField, image);
        enterText(productStockField, stock);
        enterText(productCategoryField, category);
        clickElement(editProductButton);
    }

    public void verifyProductUpdated() {
        waitUntilElementVisible(notificationMessage, 3);
        String message = getTextFromElement(notificationMessage);
        Assert.assertEquals(message, "Product successfully updated.", "Product update failed.");
    }

    public void attemptDeleteProduct() {
        waitUntilElementVisible(deleteProductButton, 3);
        clickElement(deleteProductButton);
    }

    public void verifyConfirmationPrompt() {
        waitUntilElementVisible(confirmationPrompt, 3);
        String prompt = getTextFromElement(confirmationPrompt);
        Assert.assertTrue(prompt.contains("Are you sure"), "Confirmation prompt not displayed.");
    }

    public void confirmDeletion() {
        // Implement logic to confirm deletion
    }

    public void verifyProductDeleted() {
        waitUntilElementVisible(notificationMessage, 3);
        String message = getTextFromElement(notificationMessage);
        Assert.assertEquals(message, "Product successfully deleted.", "Product deletion failed.");
    }

    public void verifyErrorMessages() {
        waitUntilElementVisible(errorMessage, 3);
        String message = getTextFromElement(errorMessage);
        Assert.assertTrue(message.contains("invalid"), "Error messages not displayed.");
    }

    public void logoutAdmin() {
        // Implement logic to logout admin
    }

    public void attemptUnauthorizedActions() {
        // Implement logic to attempt unauthorized actions
    }

    public void verifyUnauthorizedAccess() {
        // Implement logic to verify unauthorized access
    }

    public void verifyUnauthorizedAccessError() {
        waitUntilElementVisible(errorMessage, 3);
        String message = getTextFromElement(errorMessage);
        Assert.assertTrue(message.contains("unauthorized"), "Unauthorized access error not displayed.");
    }

    public void verifyProductDetails() {
        waitUntilElementVisible(productNameField, 3);
        waitUntilElementVisible(productDescriptionField, 3);
        waitUntilElementVisible(productPriceField, 3);
        waitUntilElementVisible(productImageField, 3);
        waitUntilElementVisible(productStockField, 3);
        waitUntilElementVisible(productCategoryField, 3);
    }

    public void verifyProductDetailsContent() {
        String name = getTextFromElement(productNameField);
        String description = getTextFromElement(productDescriptionField);
        String price = getTextFromElement(productPriceField);
        String image = getAttributeFromElement(productImageField, "src");
        String stock = getTextFromElement(productStockField);
        String category = getTextFromElement(productCategoryField);
        Assert.assertNotNull(name, "Product name is missing.");
        Assert.assertNotNull(description, "Product description is missing.");
        Assert.assertNotNull(price, "Product price is missing.");
        Assert.assertNotNull(image, "Product image is missing.");
        Assert.assertNotNull(stock, "Product stock is missing.");
        Assert.assertNotNull(category, "Product category is missing.");
    }

    public void accessProductDetails() {
        verifyProductDetails();
    }

    public void verifyProductDataSecurity() {
        // Implement security verification logic
    }

    public void retrieveProductDetails() {
        verifyProductDetails();
    }

    public void verifyDatabaseIntegration() {
        // Implement database integration verification logic
    }
}