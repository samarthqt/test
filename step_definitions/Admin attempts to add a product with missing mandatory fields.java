package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.AdminProductPage;

public class AdminProductSteps extends AdminProductPage {

    private TestHarness testHarness = new TestHarness();

    @Given("an admin account exists")
    public void anAdminAccountExists() {
        // Assume admin account setup is done
    }

    @Given("the admin has necessary permissions to add products")
    public void theAdminHasNecessaryPermissionsToAddProducts() {
        // Assume permissions are granted
    }

    @When("the admin logs in using valid credentials")
    public void theAdminLogsInUsingValidCredentials() {
        String username = testHarness.getData("AdminData", "Username");
        String password = testHarness.getData("AdminData", "Password");
        login(username, password);
    }

    @Then("the admin successfully logs into the account")
    public void theAdminSuccessfullyLogsIntoTheAccount() {
        verifyLoginSuccess();
    }

    @When("the admin navigates to the 'Product Management' section in the admin dashboard")
    public void theAdminNavigatesToTheProductManagementSectionInTheAdminDashboard() {
        navigateToProductManagement();
    }

    @Then("the admin is directed to the 'Product Management' page")
    public void theAdminIsDirectedToTheProductManagementPage() {
        verifyProductManagementPage();
    }

    @When("the admin clicks on the 'Add New Product' button")
    public void theAdminClicksOnTheAddNewProductButton() {
        clickAddNewProduct();
    }

    @Then("the admin is redirected to the 'Add New Product' form")
    public void theAdminIsRedirectedToTheAddNewProductForm() {
        verifyAddNewProductForm();
    }

    @When("the admin leaves the 'Product Name' field empty")
    public void theAdminLeavesTheProductNameFieldEmpty() {
        leaveProductNameEmpty();
    }

    @When("selects the appropriate category \"Electronics\" from the 'Category' dropdown")
    public void selectsTheAppropriateCategoryFromTheCategoryDropdown() {
        selectCategory("Electronics");
    }

    @When("leaves the 'Price' field empty")
    public void leavesThePriceFieldEmpty() {
        leavePriceEmpty();
    }

    @When("enters the stock quantity \"50\" in the 'Stock Quantity' field")
    public void entersTheStockQuantityInTheStockQuantityField() {
        enterStockQuantity("50");
    }

    @When("leaves the 'Description' field empty")
    public void leavesTheDescriptionFieldEmpty() {
        leaveDescriptionEmpty();
    }

    @When("leaves the image field empty")
    public void leavesTheImageFieldEmpty() {
        leaveImageFieldEmpty();
    }

    @When("attempts to save the product with missing mandatory fields")
    public void attemptsToSaveTheProductWithMissingMandatoryFields() {
        saveProductWithMissingFields();
    }

    @Then("the system displays validation errors for missing mandatory fields")
    public void theSystemDisplaysValidationErrorsForMissingMandatoryFields() {
        verifyValidationErrors();
    }

    @When("the admin checks for specific error messages for each missing field")
    public void theAdminChecksForSpecificErrorMessagesForEachMissingField() {
        checkSpecificErrorMessages();
    }

    @Then("specific error messages are displayed for each missing field")
    public void specificErrorMessagesAreDisplayedForEachMissingField() {
        verifySpecificErrorMessages();
    }

    @When("the admin attempts to navigate away from the form without saving")
    public void theAdminAttemptsToNavigateAwayFromTheFormWithoutSaving() {
        attemptNavigationWithoutSaving();
    }

    @Then("the system prompts to confirm navigation, warning about unsaved changes")
    public void theSystemPromptsToConfirmNavigationWarningAboutUnsavedChanges() {
        verifyUnsavedChangesWarning();
    }

    @When("the admin fills in all mandatory fields and saves the product")
    public void theAdminFillsInAllMandatoryFieldsAndSavesTheProduct() {
        fillMandatoryFieldsAndSave();
    }

    @Then("the product is saved successfully once all mandatory fields are filled")
    public void theProductIsSavedSuccessfullyOnceAllMandatoryFieldsAreFilled() {
        verifyProductSavedSuccessfully();
    }

    @When("the admin verifies that the product does not appear in the product list when mandatory fields are missing")
    public void theAdminVerifiesThatTheProductDoesNotAppearInTheProductListWhenMandatoryFieldsAreMissing() {
        verifyProductNotInListWhenFieldsMissing();
    }

    @Then("the product is not listed when mandatory fields are missing")
    public void theProductIsNotListedWhenMandatoryFieldsAreMissing() {
        verifyProductNotListed();
    }

    @When("the admin logs out of the admin account")
    public void theAdminLogsOutOfTheAdminAccount() {
        logout();
    }

    @Then("the admin is successfully logged out and redirected to the login page")
    public void theAdminIsSuccessfullyLoggedOutAndRedirectedToTheLoginPage() {
        verifyLogoutSuccess();
    }
}