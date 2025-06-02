package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.ProductPage;

public class ProductSteps extends ProductPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into the admin panel")
    public void theUserIsLoggedIntoTheAdminPanel() {
        loginToAdminPanel();
    }

    @When("the user navigates to the product addition page")
    public void theUserNavigatesToTheProductAdditionPage() {
        navigateToProductAdditionPage();
    }

    @Then("the product addition page is displayed successfully")
    public void theProductAdditionPageIsDisplayedSuccessfully() {
        verifyProductAdditionPageDisplayed();
    }

    @Then("the product addition interface must be accessible")
    public void theProductAdditionInterfaceMustBeAccessible() {
        verifyProductAdditionInterfaceAccessible();
    }

    @Given("the 'Product Name' field is empty")
    public void theProductNameFieldIsEmpty() {
        verifyProductNameFieldIsEmpty();
    }

    @When("the user enters '100' in the 'Product Price' field")
    public void theUserEntersInTheProductPriceField() {
        enterProductPrice("100");
    }

    @Then("the 'Product Price' field is populated with '100'")
    public void theProductPriceFieldIsPopulatedWith() {
        verifyProductPriceFieldPopulated("100");
    }

    @When("the user enters 'Sample Description' in the 'Product Description' field")
    public void theUserEntersInTheProductDescriptionField() {
        enterProductDescription("Sample Description");
    }

    @Then("the 'Product Description' field is populated with 'Sample Description'")
    public void theProductDescriptionFieldIsPopulatedWith() {
        verifyProductDescriptionFieldPopulated("Sample Description");
    }

    @When("the user selects 'Electronics' from the 'Product Category' dropdown")
    public void theUserSelectsFromTheProductCategoryDropdown() {
        selectProductCategory("Electronics");
    }

    @Then("the 'Product Category' field is set to 'Electronics'")
    public void theProductCategoryFieldIsSetTo() {
        verifyProductCategoryFieldSet("Electronics");
    }

    @When("the user clicks on the 'Save' button to attempt to add the product")
    public void theUserClicksOnTheSaveButtonToAttemptToAddTheProduct() {
        clickSaveButton();
    }

    @Then("an error message is displayed indicating that the 'Product Name' field cannot be empty")
    public void anErrorMessageIsDisplayedIndicatingThatTheProductNameFieldCannotBeEmpty() {
        verifyErrorMessageForEmptyProductName();
    }

    @Then("the product does not appear in the product list")
    public void theProductDoesNotAppearInTheProductList() {
        verifyProductNotInList();
    }

    @Then("system logs or alerts indicate a validation error due to the missing product name")
    public void systemLogsOrAlertsIndicateAValidationErrorDueToTheMissingProductName() {
        verifySystemLogsForValidationError();
    }

    @When("the user refreshes the page and re-enters the same data")
    public void theUserRefreshesThePageAndReEntersTheSameData() {
        refreshPageAndReEnterData();
    }

    @Then("the same validation error is displayed indicating the 'Product Name' field is required")
    public void theSameValidationErrorIsDisplayedIndicatingTheProductNameFieldIsRequired() {
        verifySameValidationErrorDisplayed();
    }

    @When("the user attempts to navigate away from the page without saving")
    public void theUserAttemptsToNavigateAwayFromThePageWithoutSaving() {
        attemptToNavigateAwayWithoutSaving();
    }

    @Then("a warning message is displayed asking to confirm navigation without saving")
    public void aWarningMessageIsDisplayedAskingToConfirmNavigationWithoutSaving() {
        verifyWarningMessageForUnsavedChanges();
    }

    @Given("the user enters a valid name in the 'Product Name' field")
    public void theUserEntersAValidNameInTheProductNameField() {
        enterValidProductName();
    }

    @When("the user saves the product")
    public void theUserSavesTheProduct() {
        clickSaveButton();
    }

    @Then("the product is successfully added to the product list with a valid name")
    public void theProductIsSuccessfullyAddedToTheProductListWithAValidName() {
        verifyProductAddedToList();
    }

    @Given("the product was attempted to be added without a name")
    public void theProductWasAttemptedToBeAddedWithoutAName() {
        attemptToAddProductWithoutName();
    }

    @Then("no entry is found in the database for the product without a name")
    public void noEntryIsFoundInTheDatabaseForTheProductWithoutAName() {
        verifyNoDatabaseEntryForProductWithoutName();
    }

    @Given("the user encounters a validation error")
    public void theUserEncountersAValidationError() {
        triggerValidationError();
    }

    @Then("the system remains stable and responsive after the validation error")
    public void theSystemRemainsStableAndResponsiveAfterTheValidationError() {
        verifySystemStabilityAfterError();
    }

    @Given("an error message is displayed")
    public void anErrorMessageIsDisplayed() {
        triggerErrorMessageDisplay();
    }

    @Then("the user interface displays the error message correctly without any layout issues")
    public void theUserInterfaceDisplaysTheErrorMessageCorrectlyWithoutAnyLayoutIssues() {
        verifyErrorMessageLayout();
    }

    @Given("the user logs out and logs back in")
    public void theUserLogsOutAndLogsBackIn() {
        logoutAndLogin();
    }

    @Then("the system state is consistent and no product without a name is added")
    public void theSystemStateIsConsistentAndNoProductWithoutANameIsAdded() {
        verifySystemStateConsistency();
    }
}