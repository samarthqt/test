package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import com.page_objects.ProductManagementPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductManagementSteps extends ProductManagementPage {

    private TestHarness testHarness = new TestHarness();

    @Given("Admin access to the product management system")
    public void adminAccessToTheProductManagementSystem() {
        navigateToProductManagementSystem();
    }

    @When("Admin logs in as an admin")
    public void adminLogsInAsAnAdmin() {
        String username = testHarness.getData("AdminData", "Username");
        String password = testHarness.getData("AdminData", "Password");
        loginAsAdmin(username, password);
    }

    @Then("Admin successfully logs into the system")
    public void adminSuccessfullyLogsIntoTheSystem() {
        verifyAdminLoginSuccess();
    }

    @Then("Existing products are available in the system")
    public void existingProductsAreAvailableInTheSystem() {
        verifyProductsAvailable();
    }

    @When("Admin navigates to the product management section")
    public void adminNavigatesToTheProductManagementSection() {
        navigateToProductManagementSection();
    }

    @Then("Product management section is displayed")
    public void productManagementSectionIsDisplayed() {
        verifyProductManagementSectionDisplayed();
    }

    @When("Admin selects an existing product to edit")
    public void adminSelectsAnExistingProductToEdit() {
        selectProductToEdit();
    }

    @Then("Existing product details are displayed")
    public void existingProductDetailsAreDisplayed() {
        verifyProductDetailsDisplayed();
    }

    @When("Admin edits the product name")
    public void adminEditsTheProductName() {
        String newName = testHarness.getData("ProductData", "NewName");
        editProductName(newName);
    }

    @Then("Product name is updated successfully")
    public void productNameIsUpdatedSuccessfully() {
        verifyProductNameUpdated();
    }

    @When("Admin edits the product description")
    public void adminEditsTheProductDescription() {
        String newDescription = testHarness.getData("ProductData", "NewDescription");
        editProductDescription(newDescription);
    }

    @Then("Product description is updated successfully")
    public void productDescriptionIsUpdatedSuccessfully() {
        verifyProductDescriptionUpdated();
    }

    @When("Admin edits the product price")
    public void adminEditsTheProductPrice() {
        String newPrice = testHarness.getData("ProductData", "NewPrice");
        editProductPrice(newPrice);
    }

    @Then("Product price is updated successfully")
    public void productPriceIsUpdatedSuccessfully() {
        verifyProductPriceUpdated();
    }

    @When("Admin edits the product category")
    public void adminEditsTheProductCategory() {
        String newCategory = testHarness.getData("ProductData", "NewCategory");
        editProductCategory(newCategory);
    }

    @Then("Product category is updated successfully")
    public void productCategoryIsUpdatedSuccessfully() {
        verifyProductCategoryUpdated();
    }

    @When("Admin uploads a new product image")
    public void adminUploadsANewProductImage() {
        String imagePath = testHarness.getData("ProductData", "ImagePath");
        uploadProductImage(imagePath);
    }

    @Then("Product image is updated successfully")
    public void productImageIsUpdatedSuccessfully() {
        verifyProductImageUpdated();
    }

    @When("Admin submits the updated product details")
    public void adminSubmitsTheUpdatedProductDetails() {
        submitUpdatedProductDetails();
    }

    @Then("Product details are updated successfully")
    public void productDetailsAreUpdatedSuccessfully() {
        verifyProductDetailsUpdated();
    }

    @Then("Verify the updated product appears in the product listing")
    public void verifyTheUpdatedProductAppearsInTheProductListing() {
        verifyUpdatedProductInListing();
    }

    @Then("Updated product details are visible in the product listing")
    public void updatedProductDetailsAreVisibleInTheProductListing() {
        verifyUpdatedProductDetailsVisible();
    }

    @Then("Check for any error messages during product editing")
    public void checkForAnyErrorMessagesDuringProductEditing() {
        verifyNoErrorMessagesDuringEditing();
    }

    @Then("No error messages are displayed during product editing")
    public void noErrorMessagesAreDisplayedDuringProductEditing() {
        verifyNoErrorMessagesDisplayed();
    }

    @Then("Verify updated product details are saved correctly")
    public void verifyUpdatedProductDetailsAreSavedCorrectly() {
        verifyProductDetailsSavedCorrectly();
    }

    @Then("Updated product details are saved accurately")
    public void updatedProductDetailsAreSavedAccurately() {
        verifyProductDetailsSavedAccurately();
    }

    @Then("Test product editing with different categories")
    public void testProductEditingWithDifferentCategories() {
        verifyProductEditingWithDifferentCategories();
    }

    @Then("Product details can be edited under different categories")
    public void productDetailsCanBeEditedUnderDifferentCategories() {
        verifyProductDetailsEditableUnderDifferentCategories();
    }

    @Then("Check system logs for product editing events")
    public void checkSystemLogsForProductEditingEvents() {
        verifySystemLogsForEditingEvents();
    }

    @Then("Logs contain entries for successful product editing")
    public void logsContainEntriesForSuccessfulProductEditing() {
        verifyLogsContainSuccessfulEditingEntries();
    }

    @Then("Verify product editing handling on mobile devices")
    public void verifyProductEditingHandlingOnMobileDevices() {
        verifyProductEditingOnMobileDevices();
    }

    @Then("Product editing behaves consistently on mobile devices")
    public void productEditingBehavesConsistentlyOnMobileDevices() {
        verifyProductEditingConsistencyOnMobileDevices();
    }
}