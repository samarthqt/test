package com.cucumber.steps;

import com.page_objects.AdminProductPage;
import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminProductSteps extends AdminProductPage {

    private TestHarness testHarness = new TestHarness();

    @Given("an admin account exists")
    public void anAdminAccountExists() {
        // Assume admin account exists
    }

    @Given("admin has necessary permissions to add products")
    public void adminHasNecessaryPermissionsToAddProducts() {
        // Assume admin has permissions
    }

    @When("admin logs in using valid credentials")
    public void adminLogsInUsingValidCredentials() {
        String username = testHarness.getData("AdminData", "Username");
        String password = testHarness.getData("AdminData", "Password");
        login(username, password);
    }

    @Then("admin successfully logs into the account")
    public void adminSuccessfullyLogsIntoTheAccount() {
        verifyLoginSuccess();
    }

    @When("admin navigates to the 'Product Management' section in the admin dashboard")
    public void adminNavigatesToTheProductManagementSectionInTheAdminDashboard() {
        navigateToProductManagement();
    }

    @Then("admin is directed to the 'Product Management' page")
    public void adminIsDirectedToTheProductManagementPage() {
        verifyProductManagementPage();
    }

    @When("admin clicks on the 'Add New Product' button")
    public void adminClicksOnTheAddNewProductButton() {
        clickAddNewProductButton();
    }

    @Then("admin is redirected to the 'Add New Product' form")
    public void adminIsRedirectedToTheAddNewProductForm() {
        verifyAddNewProductForm();
    }

    @When("admin enters the product name {string} in the 'Product Name' field")
    public void adminEntersTheProductNameInTheProductNameField(String productName) {
        enterProductName(productName);
    }

    @Then("product name is entered successfully")
    public void productNameIsEnteredSuccessfully() {
        verifyProductNameEntered();
    }

    @When("admin selects the category {string} from the 'Category' dropdown")
    public void adminSelectsTheCategoryFromTheCategoryDropdown(String category) {
        selectCategory(category);
    }

    @Then("category is selected successfully")
    public void categoryIsSelectedSuccessfully() {
        verifyCategorySelected();
    }

    @When("admin enters the price {string} in the 'Price' field")
    public void adminEntersThePriceInThePriceField(String price) {
        enterPrice(price);
    }

    @Then("price is entered successfully")
    public void priceIsEnteredSuccessfully() {
        verifyPriceEntered();
    }

    @When("admin enters the stock quantity {string} in the 'Stock Quantity' field")
    public void adminEntersTheStockQuantityInTheStockQuantityField(String stockQuantity) {
        enterStockQuantity(stockQuantity);
    }

    @Then("stock quantity is entered successfully")
    public void stockQuantityIsEnteredSuccessfully() {
        verifyStockQuantityEntered();
    }

    @When("admin enters the description {string} in the 'Description' field")
    public void adminEntersTheDescriptionInTheDescriptionField(String description) {
        enterDescription(description);
    }

    @Then("description is entered successfully")
    public void descriptionIsEnteredSuccessfully() {
        verifyDescriptionEntered();
    }

    @When("admin uploads an image {string} for the product using the 'Upload Image' button")
    public void adminUploadsAnImageForTheProductUsingTheUploadImageButton(String imageName) {
        uploadImage(imageName);
    }

    @Then("image is uploaded successfully")
    public void imageIsUploadedSuccessfully() {
        verifyImageUploaded();
    }

    @When("admin reviews all entered details for accuracy")
    public void adminReviewsAllEnteredDetailsForAccuracy() {
        reviewEnteredDetails();
    }

    @Then("all details are accurate and complete")
    public void allDetailsAreAccurateAndComplete() {
        verifyDetailsAccuracy();
    }

    @When("admin clicks on the 'Save' or 'Submit' button to add the product")
    public void adminClicksOnTheSaveOrSubmitButtonToAddTheProduct() {
        clickSaveOrSubmitButton();
    }

    @Then("product is added successfully and a confirmation message is displayed")
    public void productIsAddedSuccessfullyAndAConfirmationMessageIsDisplayed() {
        verifyProductAdded();
    }

    @When("admin verifies the new product appears in the product list")
    public void adminVerifiesTheNewProductAppearsInTheProductList() {
        verifyProductInList();
    }

    @Then("new product is listed in the product management section")
    public void newProductIsListedInTheProductManagementSection() {
        verifyProductListed();
    }

    @When("admin checks the product details to ensure they match the entered data")
    public void adminChecksTheProductDetailsToEnsureTheyMatchTheEnteredData() {
        verifyProductDetailsMatch();
    }

    @Then("product details are correct and match the entered data")
    public void productDetailsAreCorrectAndMatchTheEnteredData() {
        verifyProductDetailsCorrect();
    }

    @When("admin logs out of the admin account")
    public void adminLogsOutOfTheAdminAccount() {
        logout();
    }

    @Then("admin is successfully logged out and redirected to the login page")
    public void adminIsSuccessfullyLoggedOutAndRedirectedToTheLoginPage() {
        verifyLogoutSuccess();
    }

    @When("admin logs in again")
    public void adminLogsInAgain() {
        String username = testHarness.getData("AdminData", "Username");
        String password = testHarness.getData("AdminData", "Password");
        login(username, password);
    }

    @Then("newly added product persists and is visible after re-login")
    public void newlyAddedProductPersistsAndIsVisibleAfterReLogin() {
        verifyProductPersistence();
    }
}