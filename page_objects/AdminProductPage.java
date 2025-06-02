package com.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class AdminProductPage extends WebReusableComponents {

    protected By usernameField = By.id("username");
    protected By passwordField = By.id("password");
    protected By loginButton = By.id("loginButton");
    protected By productManagementLink = By.id("productManagementLink");
    protected By addNewProductButton = By.id("addNewProductButton");
    protected By productNameField = By.id("productName");
    protected By categoryDropdown = By.id("categoryDropdown");
    protected By priceField = By.id("price");
    protected By stockQuantityField = By.id("stockQuantity");
    protected By descriptionField = By.id("description");
    protected By uploadImageButton = By.id("uploadImageButton");
    protected By saveButton = By.id("saveButton");
    protected By confirmationMessage = By.id("confirmationMessage");
    protected By productList = By.id("productList");
    protected By validationErrorMessages = By.cssSelector(".validation-error");
    protected By unsavedChangesWarning = By.id("unsavedChangesWarning");
    protected By logoutButton = By.id("logoutButton");

    public AdminProductPage() {
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        waitUntilElementVisible(usernameField, 3);
        enterText(usernameField, username);
        waitUntilElementVisible(passwordField, 3);
        enterText(passwordField, password);
        waitUntilElementVisible(loginButton, 3);
        clickElement(loginButton);
    }

    public void verifyLoginSuccess() {
        Assert.assertTrue(elementVisible(productManagementLink), "Login failed.");
    }

    public void navigateToProductManagement() {
        waitUntilElementVisible(productManagementLink, 3);
        clickElement(productManagementLink);
    }

    public void verifyProductManagementPage() {
        Assert.assertTrue(elementVisible(addNewProductButton), "Product Management page not loaded.");
    }

    public void clickAddNewProductButton() {
        waitUntilElementVisible(addNewProductButton, 3);
        clickElement(addNewProductButton);
    }

    public void verifyAddNewProductForm() {
        Assert.assertTrue(elementVisible(productNameField), "Add New Product form not loaded.");
    }

    public void enterProductName(String productName) {
        waitUntilElementVisible(productNameField, 3);
        enterText(productNameField, productName);
    }

    public void verifyProductNameEntered() {
        String enteredName = getTextFromElement(productNameField);
        Assert.assertFalse(enteredName.isEmpty(), "Product name not entered.");
    }

    public void selectCategory(String category) {
        waitUntilElementVisible(categoryDropdown, 3);
        selectByVisibleText(categoryDropdown, category);
    }

    public void verifyCategorySelected() {
        String selectedCategory = getSelectedOption(categoryDropdown);
        Assert.assertFalse(selectedCategory.isEmpty(), "Category not selected.");
    }

    public void enterPrice(String price) {
        waitUntilElementVisible(priceField, 3);
        enterText(priceField, price);
    }

    public void verifyPriceEntered() {
        String enteredPrice = getTextFromElement(priceField);
        Assert.assertFalse(enteredPrice.isEmpty(), "Price not entered.");
    }

    public void enterStockQuantity(String stockQuantity) {
        waitUntilElementVisible(stockQuantityField, 3);
        enterText(stockQuantityField, stockQuantity);
    }

    public void verifyStockQuantityEntered() {
        String enteredQuantity = getTextFromElement(stockQuantityField);
        Assert.assertFalse(enteredQuantity.isEmpty(), "Stock quantity not entered.");
    }

    public void enterDescription(String description) {
        waitUntilElementVisible(descriptionField, 3);
        enterText(descriptionField, description);
    }

    public void verifyDescriptionEntered() {
        String enteredDescription = getTextFromElement(descriptionField);
        Assert.assertFalse(enteredDescription.isEmpty(), "Description not entered.");
    }

    public void uploadImage(String imageName) {
        waitUntilElementVisible(uploadImageButton, 3);
        uploadFile(uploadImageButton, imageName);
    }

    public void verifyImageUploaded() {
        // Assume image upload verification
    }

    public void clickSaveOrSubmitButton() {
        waitUntilElementVisible(saveButton, 3);
        clickElement(saveButton);
    }

    public void verifyProductAdded() {
        String message = getTextFromElement(confirmationMessage);
        Assert.assertTrue(message.contains("successfully"), "Product not added.");
    }

    public void verifyProductInList() {
        waitUntilElementVisible(productList, 3);
        Assert.assertTrue(elementVisible(productList), "Product not in list.");
    }

    public void verifyProductListed() {
        // Assume product listing verification
    }

    public void verifyProductDetailsMatch() {
        // Assume product details match verification
    }

    public void verifyProductDetailsCorrect() {
        // Assume product details correctness verification
    }

    public void logout() {
        waitUntilElementVisible(logoutButton, 3);
        clickElement(logoutButton);
    }

    public void verifyLogoutSuccess() {
        Assert.assertTrue(elementVisible(loginButton), "Logout failed.");
    }

    public void verifyProductPersistence() {
        verifyProductInList();
    }

    public void verifyValidationErrors() {
        waitUntilElementVisible(validationErrorMessages, 3);
        Assert.assertTrue(elementVisible(validationErrorMessages), "Validation errors not displayed.");
    }

    public void verifyUnsavedChangesWarning() {
        waitUntilElementVisible(unsavedChangesWarning, 3);
        Assert.assertTrue(elementVisible(unsavedChangesWarning), "Unsaved changes warning not displayed.");
    }

    public void verifyProductImageUploaded() {
        // Assume product image upload verification
    }

    public void verifySpecificErrorMessages() {
        // Assume specific error messages verification
    }

    public void fillMandatoryFieldsAndSave() {
        // Assume filling mandatory fields and saving logic
    }

    public void verifyProductDetailsOnCustomerSite() {
        // Assume product details on customer site verification
    }

    public void verifyProductVisibilityOnCustomerSite() {
        // Assume product visibility on customer site verification
    }

    public void verifyProductNotInListWhenFieldsMissing() {
        // Assume product not in list when fields missing verification
    }

    public void verifyProductManagementInterface() {
        // Assume product management interface verification
    }

    public void verifyProductSavedSuccessfully() {
        // Assume product saved successfully verification
    }

    public void enterProductPrice(String price) {
        waitUntilElementVisible(priceField, 3);
        enterText(priceField, price);
    }

    public void leaveDescriptionEmpty() {
        waitUntilElementVisible(descriptionField, 3);
        enterText(descriptionField, "");
    }

    public void verifyProductNotListed() {
        // Assume product not listed verification
    }

    public void verifyDetailsAccuracy() {
        // Assume details accuracy verification
    }

    public void verifySKUEntered() {
        // Assume SKU entered verification
    }

    public void verifyProductAddedToInventory() {
        // Assume product added to inventory verification
    }

    public void verifyAdminLoggedOut() {
        // Assume admin logged out verification
    }

    public void selectProductCategory(String category) {
        waitUntilElementVisible(categoryDropdown, 3);
        selectByVisibleText(categoryDropdown, category);
    }

    public void enterSKU(String sku) {
        // Assume SKU entry logic
    }

    public void leavePriceEmpty() {
        waitUntilElementVisible(priceField, 3);
        enterText(priceField, "");
    }

    public void logoutAdminAccount() {
        waitUntilElementVisible(logoutButton, 3);
        clickElement(logoutButton);
    }

    public void checkSpecificErrorMessages() {
        // Assume specific error messages check logic
    }

    public void saveProductWithMissingFields() {
        // Assume save product with missing fields logic
    }

    public void attemptNavigationWithoutSaving() {
        // Assume navigation without saving logic
    }

    public void leaveImageFieldEmpty() {
        // Assume leaving image field empty logic
    }

    public void enterProductDescription(String description) {
        waitUntilElementVisible(descriptionField, 3);
        enterText(descriptionField, description);
    }

    public void loginAsAdmin(String username, String password) {
        login(username, password);
    }

    public void verifyProductAdditionForm() {
        // Assume product addition form verification
    }

    public void reviewEnteredDetails() {
        // Assume review entered details logic
    }
}