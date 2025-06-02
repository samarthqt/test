package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class ProductManagementPage extends WebReusableComponents {

    protected By loginButton = By.id("loginButton");
    protected By adminLoginButton = By.id("adminLogin");
    protected By usernameField = By.id("username");
    protected By passwordField = By.id("password");
    protected By productManagementSection = By.id("productManagementSection");
    protected By addNewProductButton = By.id("addNewProductButton");
    protected By productNameField = By.id("productName");
    protected By productDescriptionField = By.id("productDescription");
    protected By productPriceField = By.id("productPrice");
    protected By productCategoryDropdown = By.id("productCategory");
    protected By productImageUpload = By.id("productImageUpload");
    protected By submitProductButton = By.id("submitProductButton");
    protected By productListing = By.cssSelector(".product-listing");
    protected By errorMessage = By.cssSelector(".error-message");
    protected By productEditButton = By.cssSelector(".edit-product");
    protected By submitButton = By.id("submitProductDetails");

    public ProductManagementPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToProductManagementSystem() {
        driver.get("http://productmanagementsystem.com");
    }

    public void login(String username, String password) {
        waitUntilElementVisible(usernameField, 3);
        enterText(usernameField, username);
        waitUntilElementVisible(passwordField, 3);
        enterText(passwordField, password);
        clickElement(loginButton);
    }

    public void loginAsAdmin(String username, String password) {
        waitUntilElementVisible(adminLoginButton, 3);
        clickElement(adminLoginButton);
        enterText(usernameField, username);
        enterText(passwordField, password);
        clickElement(adminLoginButton);
    }

    public void verifyLoginSuccess() {
        Assert.assertTrue(elementVisible(productManagementSection), "Login failed.");
    }

    public void verifyAdminLoginSuccess() {
        Assert.assertTrue(elementVisible(productManagementSection), "Admin login failed.");
    }

    public void navigateToProductManagementSection() {
        waitUntilElementVisible(productManagementSection, 3);
        clickElement(productManagementSection);
    }

    public void verifyProductManagementSectionDisplayed() {
        Assert.assertTrue(elementVisible(addNewProductButton), "Product management section not displayed.");
    }

    public void selectAddNewProductOption() {
        waitUntilElementVisible(addNewProductButton, 3);
        clickElement(addNewProductButton);
    }

    public void verifyAddNewProductFormDisplayed() {
        Assert.assertTrue(elementVisible(productNameField), "Add new product form not displayed.");
    }

    public void enterProductName(String productName) {
        waitUntilElementVisible(productNameField, 3);
        enterText(productNameField, productName);
    }

    public void verifyProductNameEntered() {
        String enteredName = getTextFromElement(productNameField);
        Assert.assertFalse(enteredName.isEmpty(), "Product name not entered.");
    }

    public void enterProductDescription(String productDescription) {
        waitUntilElementVisible(productDescriptionField, 3);
        enterText(productDescriptionField, productDescription);
    }

    public void verifyProductDescriptionEntered() {
        String enteredDescription = getTextFromElement(productDescriptionField);
        Assert.assertFalse(enteredDescription.isEmpty(), "Product description not entered.");
    }

    public void enterProductPrice(String productPrice) {
        waitUntilElementVisible(productPriceField, 3);
        enterText(productPriceField, productPrice);
    }

    public void verifyProductPriceEntered() {
        String enteredPrice = getTextFromElement(productPriceField);
        Assert.assertFalse(enteredPrice.isEmpty(), "Product price not entered.");
    }

    public void selectProductCategory(String category) {
        waitUntilElementVisible(productCategoryDropdown, 3);
        selectByValue(productCategoryDropdown, category);
    }

    public void verifyProductCategorySelected() {
        String selectedCategory = getSelectedValue(productCategoryDropdown);
        Assert.assertFalse(selectedCategory.isEmpty(), "Product category not selected.");
    }

    public void uploadProductImage(String imagePath) {
        waitUntilElementVisible(productImageUpload, 3);
        uploadFile(productImageUpload, imagePath);
    }

    public void verifyProductImageUploaded() {
        WebElement imageElement = driver.findElement(productImageUpload);
        Assert.assertTrue(imageElement.getAttribute("value").contains(".jpg"), "Product image not uploaded.");
    }

    public void submitNewProductForm() {
        waitUntilElementVisible(submitProductButton, 3);
        clickElement(submitProductButton);
    }

    public void verifyNewProductAdded() {
        Assert.assertTrue(elementVisible(productListing), "New product not added.");
    }

    public void verifyProductInListing() {
        waitUntilElementVisible(productListing, 3);
        Assert.assertTrue(getWebElementList(productListing).size() > 0, "Product not in listing.");
    }

    public void verifyNoErrorMessages() {
        Assert.assertFalse(elementVisible(errorMessage), "Error messages displayed.");
    }

    public void editProductName(String newName) {
        waitUntilElementVisible(productEditButton, 3);
        clickElement(productEditButton);
        enterText(productNameField, newName);
        clickElement(submitButton);
    }

    public void verifyProductNameUpdated(String expectedName) {
        String actualName = getTextFromElement(productNameField);
        Assert.assertEquals(actualName, expectedName, "Product name not updated.");
    }

    public void editProductDescription(String newDescription) {
        waitUntilElementVisible(productEditButton, 3);
        clickElement(productEditButton);
        enterText(productDescriptionField, newDescription);
        clickElement(submitButton);
    }

    public void verifyProductDescriptionUpdated(String expectedDescription) {
        String actualDescription = getTextFromElement(productDescriptionField);
        Assert.assertEquals(actualDescription, expectedDescription, "Product description not updated.");
    }

    public void editProductPrice(String newPrice) {
        waitUntilElementVisible(productEditButton, 3);
        clickElement(productEditButton);
        enterText(productPriceField, newPrice);
        clickElement(submitButton);
    }

    public void verifyProductPriceUpdated(String expectedPrice) {
        String actualPrice = getTextFromElement(productPriceField);
        Assert.assertEquals(actualPrice, expectedPrice, "Product price not updated.");
    }

    public void editProductCategory(String newCategory) {
        waitUntilElementVisible(productEditButton, 3);
        clickElement(productEditButton);
        selectByValue(productCategoryDropdown, newCategory);
        clickElement(submitButton);
    }

    public void verifyProductCategoryUpdated(String expectedCategory) {
        String actualCategory = getSelectedValue(productCategoryDropdown);
        Assert.assertEquals(actualCategory, expectedCategory, "Product category not updated.");
    }

    public void verifyProductDetailsSaved() {
        // Logic to verify product details saved accurately
    }

    public void verifySystemLogsForProductAddition() {
        // Logic to verify system logs for product addition
    }

    public void verifyProductAdditionOnMobileDevices() {
        // Logic to verify product addition on mobile devices
    }

    public void verifyProductDetailsUpdated() {
        // Logic to verify product details updated accurately
    }

    public void verifyAuditLogs() {
        // Logic to verify audit logs for product changes
    }

    public void verifyChangesSavedSuccessfully() {
        // Logic to verify changes saved successfully
    }

    public void verifyDescriptionEnteredCorrectly() {
        // Logic to verify description entered correctly
    }

    public void verifyNoErrorMessagesDuringEditing() {
        // Logic to verify no error messages during editing
    }

    public void verifyProductDetailsSavedAccurately() {
        // Logic to verify product details saved accurately
    }

    public void verifyLogsContainSuccessfulEditingEntries() {
        // Logic to verify logs contain successful editing entries
    }

    public void enterMaxLengthDescription(String description) {
        // Logic to enter maximum length description
    }

    public void verifyDescriptionFieldEditable() {
        // Logic to verify description field is editable
    }

    public void enterHTMLTagsDescription(String description) {
        // Logic to enter HTML tags in description
    }

    public void verifyCustomerFacingDescription() {
        // Logic to verify customer-facing description
    }

    public void checkDatabaseForDescription() {
        // Logic to check database for description
    }

    public void verifyProductDetailsDisplayed() {
        // Logic to verify product details displayed
    }

    public void selectProductById(String productId) {
        // Logic to select product by ID
    }

    public void verifyDatabaseDescription() {
        // Logic to verify database description
    }

    public void checkCustomerFacingProductPage() {
        // Logic to check customer-facing product page
    }

    public void verifySystemLogsForEditingEvents() {
        // Logic to verify system logs for editing events
    }

    public void enterSpecialCharactersDescription(String description) {
        // Logic to enter special characters in description
    }

    public void logoutAdmin() {
        // Logic to logout admin
    }

    public void checkForNotifications() {
        // Logic to check for notifications
    }

    public void verifyUpdatedProductInListing() {
        // Logic to verify updated product in listing
    }

    public void verifyProductDetailsEditableUnderDifferentCategories() {
        // Logic to verify product details editable under different categories
    }

    public void checkAuditLogsForDescriptionChange() {
        // Logic to check audit logs for description change
    }

    public void selectProductToEdit(String productName) {
        // Logic to select product to edit
    }

    public void verifyHTMLTagsSanitized() {
        // Logic to verify HTML tags sanitized
    }

    public void verifyProductEditingOnMobileDevices() {
        // Logic to verify product editing on mobile devices
    }

    public void verifyProductEditingWithDifferentCategories() {
        // Logic to verify product editing with different categories
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void verifyNoUnexpectedNotifications() {
        // Logic to verify no unexpected notifications
    }

    public void verifyProductDetailsPageDisplayed() {
        // Logic to verify product details page displayed
    }

    public void verifyProductsAvailable() {
        Assert.assertTrue(getWebElementList(productListing).size() > 0, "No products available.");
    }

    public void verifyProductEditingConsistencyOnMobileDevices() {
        // Logic to verify product editing consistency on mobile devices
    }

    public void verifyErrorMessageDisplayed() {
        Assert.assertTrue(elementVisible(errorMessage), "Error message not displayed.");
    }

    public void clickEditDescriptionButton() {
        // Logic to click edit description button
    }

    public void saveDescriptionChanges() {
        // Logic to save description changes
    }

    public void verifyAdminLoggedOut() {
        // Logic to verify admin logged out
    }

    public void verifyProductDetailsSavedCorrectly() {
        // Logic to verify product details saved correctly
    }

    public void verifyUpdatedProductDetailsVisible() {
        // Logic to verify updated product details visible
    }

    public void verifySpecialCharactersSaved() {
        // Logic to verify special characters saved
    }
}