package com.cucumber.steps;

import com.page_objects.ProductManagementPage;
import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductManagementSteps extends ProductManagementPage {

    private TestHarness testHarness = new TestHarness();

    @Given("admin access to the product management system")
    public void adminAccessToTheProductManagementSystem() {
        navigateToProductManagementSystem();
    }

    @When("the admin logs in")
    public void theAdminLogsIn() {
        String username = testHarness.getData("AdminData", "Username");
        String password = testHarness.getData("AdminData", "Password");
        login(username, password);
    }

    @Then("the admin successfully logs into the system")
    public void theAdminSuccessfullyLogsIntoTheSystem() {
        verifyLoginSuccess();
    }

    @When("the admin navigates to the product management section")
    public void theAdminNavigatesToTheProductManagementSection() {
        navigateToProductManagementSection();
    }

    @Then("the product management section is displayed")
    public void theProductManagementSectionIsDisplayed() {
        verifyProductManagementSectionDisplayed();
    }

    @When("the admin selects the option to add a new product")
    public void theAdminSelectsTheOptionToAddANewProduct() {
        selectAddNewProductOption();
    }

    @Then("the add new product form is displayed")
    public void theAddNewProductFormIsDisplayed() {
        verifyAddNewProductFormDisplayed();
    }

    @When("the admin enters a valid product name")
    public void theAdminEntersAValidProductName() {
        String productName = testHarness.getData("ProductData", "ProductName");
        enterProductName(productName);
    }

    @Then("the product name is entered successfully")
    public void theProductNameIsEnteredSuccessfully() {
        verifyProductNameEntered();
    }

    @When("the admin enters a valid product description")
    public void theAdminEntersAValidProductDescription() {
        String productDescription = testHarness.getData("ProductData", "ProductDescription");
        enterProductDescription(productDescription);
    }

    @Then("the product description is entered successfully")
    public void theProductDescriptionIsEnteredSuccessfully() {
        verifyProductDescriptionEntered();
    }

    @When("the admin enters a valid product price")
    public void theAdminEntersAValidProductPrice() {
        String productPrice = testHarness.getData("ProductData", "ProductPrice");
        enterProductPrice(productPrice);
    }

    @Then("the product price is entered successfully")
    public void theProductPriceIsEnteredSuccessfully() {
        verifyProductPriceEntered();
    }

    @When("the admin selects a valid product category {string}")
    public void theAdminSelectsAValidProductCategory(String category) {
        selectProductCategory(category);
    }

    @Then("the product category is selected successfully")
    public void theProductCategoryIsSelectedSuccessfully() {
        verifyProductCategorySelected();
    }

    @When("the admin uploads a valid product image")
    public void theAdminUploadsAValidProductImage() {
        String productImagePath = testHarness.getData("ProductData", "ProductImagePath");
        uploadProductImage(productImagePath);
    }

    @Then("the product image is uploaded successfully")
    public void theProductImageIsUploadedSuccessfully() {
        verifyProductImageUploaded();
    }

    @When("the admin submits the new product form")
    public void theAdminSubmitsTheNewProductForm() {
        submitNewProductForm();
    }

    @Then("the new product is added successfully")
    public void theNewProductIsAddedSuccessfully() {
        verifyNewProductAdded();
    }

    @Then("the new product appears in the product listing")
    public void theNewProductAppearsInTheProductListing() {
        verifyProductInListing();
    }

    @Then("no error messages are displayed during product addition")
    public void noErrorMessagesAreDisplayedDuringProductAddition() {
        verifyNoErrorMessages();
    }

    @Then("product details are saved accurately")
    public void productDetailsAreSavedAccurately() {
        verifyProductDetailsSaved();
    }

    @Then("the system logs contain entries for successful product addition")
    public void theSystemLogsContainEntriesForSuccessfulProductAddition() {
        verifySystemLogsForProductAddition();
    }

    @Then("product addition behaves consistently on mobile devices")
    public void productAdditionBehavesConsistentlyOnMobileDevices() {
        verifyProductAdditionOnMobileDevices();
    }
}