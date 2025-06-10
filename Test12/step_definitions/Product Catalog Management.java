package com.cucumber.steps;

import com.page_objects.ProductCatalogPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductCatalogSteps extends ProductCatalogPage {

    @Given("the admin has access to the product catalog management interface")
    public void theAdminHasAccessToTheProductCatalogManagementInterface() {
        navigateToCatalogManagementInterface();
    }

    @When("the admin adds a new product with name, description, price, image, stock, and category")
    public void theAdminAddsANewProductWithCompleteDetails() {
        addNewProduct();
    }

    @Then("the product is saved with complete details")
    public void theProductIsSavedWithCompleteDetails() {
        verifyProductSaved();
    }

    @Given("there is an existing product in the catalog")
    public void thereIsAnExistingProductInTheCatalog() {
        verifyExistingProduct();
    }

    @When("the admin edits the product details such as name, description, price, image, stock, or category")
    public void theAdminEditsExistingProductDetails() {
        editProductDetails();
    }

    @Then("the product details are updated successfully")
    public void theProductDetailsAreUpdatedSuccessfully() {
        verifyProductDetailsUpdated();
    }

    @When("the admin deletes the product")
    public void theAdminDeletesTheProduct() {
        deleteProduct();
    }

    @Then("the product is removed from the catalog")
    public void theProductIsRemovedFromTheCatalog() {
        verifyProductRemoved();
    }

    @Given("the admin is adding or editing a product")
    public void theAdminIsAddingOrEditingAProduct() {
        initiateProductModification();
    }

    @When("the admin attempts to save the product details")
    public void theAdminAttemptsToSaveTheProductDetails() {
        saveProductDetails();
    }

    @Then("the application validates the details for correctness and completeness")
    public void theApplicationValidatesTheDetailsForCorrectnessAndCompleteness() {
        validateProductDetails();
    }

    @Given("the admin uploads a product image")
    public void theAdminUploadsAProductImage() {
        uploadProductImage();
    }

    @When("the image is saved in the system")
    public void theImageIsSavedInTheSystem() {
        saveImageInSystem();
    }

    @Then("the system ensures the image is stored securely")
    public void theSystemEnsuresTheImageIsStoredSecurely() {
        verifyImageStoredSecurely();
    }

    @Given("the admin updates the stock information for a product")
    public void theAdminUpdatesTheStockInformationForAProduct() {
        updateStockInformation();
    }

    @When("the update is saved")
    public void theUpdateIsSaved() {
        saveStockUpdate();
    }

    @Then("the application reflects the updated stock information in real-time")
    public void theApplicationReflectsTheUpdatedStockInformationInRealTime() {
        verifyStockUpdatedRealTime();
    }

    @When("the admin assigns a category to the product")
    public void theAdminAssignsACategoryToTheProduct() {
        assignProductCategory();
    }

    @Then("the product is categorized accurately")
    public void theProductIsCategorizedAccurately() {
        verifyProductCategorizedAccurately();
    }

    @Given("the admin makes changes to product details")
    public void theAdminMakesChangesToProductDetails() {
        makeChangesToProductDetails();
    }

    @When("the changes are saved")
    public void theChangesAreSaved() {
        saveChanges();
    }

    @Then("the system logs all changes made")
    public void theSystemLogsAllChangesMade() {
        verifyChangesLogged();
    }

    @Given("the admin accesses the product catalog management interface")
    public void theAdminAccessesTheProductCatalogManagementInterface() {
        navigateToCatalogManagementInterface();
    }

    @Then("the interface is user-friendly and easy to navigate")
    public void theInterfaceIsUserFriendlyAndEasyToNavigate() {
        verifyInterfaceUserFriendly();
    }

    @Given("the admin adds, edits, or deletes product details")
    public void theAdminAddsEditsOrDeletesProductDetails() {
        modifyProductDetails();
    }

    @Then("the system ensures data consistency across all product details")
    public void theSystemEnsuresDataConsistencyAcrossAllProductDetails() {
        verifyDataConsistency();
    }
}