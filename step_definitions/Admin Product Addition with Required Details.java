package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.AdminProductPage;

public class AdminProductSteps extends AdminProductPage {

    private TestHarness testHarness = new TestHarness();

    @Given("an admin account with product management privileges")
    public void anAdminAccountWithProductManagementPrivileges() {
        // Assume admin account setup is done
    }

    @When("the admin logs in with product management privileges")
    public void theAdminLogsInWithProductManagementPrivileges() {
        String username = testHarness.getData("AdminData", "Username");
        String password = testHarness.getData("AdminData", "Password");
        loginAsAdmin(username, password);
    }

    @Then("the admin is successfully logged in and redirected to the admin dashboard")
    public void theAdminIsSuccessfullyLoggedInAndRedirectedToTheAdminDashboard() {
        verifyAdminDashboard();
    }

    @When("the admin navigates to the product management section")
    public void theAdminNavigatesToTheProductManagementSection() {
        navigateToProductManagement();
    }

    @Then("the product management interface is displayed")
    public void theProductManagementInterfaceIsDisplayed() {
        verifyProductManagementInterface();
    }

    @When("the admin clicks on 'Add New Product' button")
    public void theAdminClicksOnAddNewProductButton() {
        clickAddNewProductButton();
    }

    @Then("the product addition form is displayed")
    public void theProductAdditionFormIsDisplayed() {
        verifyProductAdditionForm();
    }

    @When("the admin enters product name {string}")
    public void theAdminEntersProductName(String productName) {
        enterProductName(productName);
    }

    @Then("the product name is entered without error")
    public void theProductNameIsEnteredWithoutError() {
        verifyProductNameEntered();
    }

    @When("the admin selects product category {string} from the dropdown")
    public void theAdminSelectsProductCategoryFromTheDropdown(String category) {
        selectProductCategory(category);
    }

    @Then("the product category is selected")
    public void theProductCategoryIsSelected() {
        verifyProductCategorySelected();
    }

    @When("the admin enters product price {string}")
    public void theAdminEntersProductPrice(String price) {
        enterProductPrice(price);
    }

    @Then("the product price is entered without error")
    public void theProductPriceIsEnteredWithoutError() {
        verifyProductPriceEntered();
    }

    @When("the admin enters stock quantity {string}")
    public void theAdminEntersStockQuantity(String quantity) {
        enterStockQuantity(quantity);
    }

    @Then("the stock quantity is entered without error")
    public void theStockQuantityIsEnteredWithoutError() {
        verifyStockQuantityEntered();
    }

    @When("the admin enters product description {string}")
    public void theAdminEntersProductDescription(String description) {
        enterProductDescription(description);
    }

    @Then("the product description is entered without error")
    public void theProductDescriptionIsEnteredWithoutError() {
        verifyProductDescriptionEntered();
    }

    @When("the admin enters SKU {string}")
    public void theAdminEntersSKU(String sku) {
        enterSKU(sku);
    }

    @Then("the SKU is entered without error")
    public void theSKUIsEnteredWithoutError() {
        verifySKUEntered();
    }

    @When("the admin uploads product image")
    public void theAdminUploadsProductImage() {
        uploadProductImage();
    }

    @Then("the product image is uploaded successfully")
    public void theProductImageIsUploadedSuccessfully() {
        verifyProductImageUploaded();
    }

    @When("the admin reviews all entered details for accuracy")
    public void theAdminReviewsAllEnteredDetailsForAccuracy() {
        reviewEnteredDetails();
    }

    @Then("all details are accurate and complete")
    public void allDetailsAreAccurateAndComplete() {
        verifyDetailsAccuracy();
    }

    @When("the admin clicks on 'Save' or 'Add Product' button")
    public void theAdminClicksOnSaveOrAddProductButton() {
        clickSaveProductButton();
    }

    @Then("the product is successfully added to the inventory")
    public void theProductIsSuccessfullyAddedToTheInventory() {
        verifyProductAddedToInventory();
    }

    @When("the admin verifies the newly added product in the product list")
    public void theAdminVerifiesTheNewlyAddedProductInTheProductList() {
        verifyProductInProductList();
    }

    @Then("the new product is listed with correct details")
    public void theNewProductIsListedWithCorrectDetails() {
        verifyProductDetailsInList();
    }

    @When("the admin logs out from the admin account")
    public void theAdminLogsOutFromTheAdminAccount() {
        logoutAdminAccount();
    }

    @Then("the admin is logged out and redirected to the login page")
    public void theAdminIsLoggedOutAndRedirectedToTheLoginPage() {
        verifyAdminLoggedOut();
    }

    @When("the admin verifies product visibility on the customer-facing site")
    public void theAdminVerifiesProductVisibilityOnTheCustomerFacingSite() {
        verifyProductVisibilityOnCustomerSite();
    }

    @Then("the new product is visible to customers with accurate details")
    public void theNewProductIsVisibleToCustomersWithAccurateDetails() {
        verifyProductDetailsOnCustomerSite();
    }
}