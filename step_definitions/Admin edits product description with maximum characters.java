package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.ProductManagementPage;

public class ProductManagementSteps extends ProductManagementPage {

    private TestHarness testHarness = new TestHarness();

    @Given("Admin is logged in and product management module is accessible")
    public void adminIsLoggedInAndProductManagementModuleIsAccessible() {
        loginAsAdmin();
        navigateToProductManagementModule();
    }

    @When("Admin selects the product with ID 12345 from the list")
    public void adminSelectsTheProductWithIDFromTheList() {
        selectProductById("12345");
    }

    @Then("Product details page is displayed")
    public void productDetailsPageIsDisplayed() {
        verifyProductDetailsPageDisplayed();
    }

    @When("Admin clicks on the 'Edit' button for the product description field")
    public void adminClicksOnTheEditButtonForTheProductDescriptionField() {
        clickEditDescriptionButton();
    }

    @Then("Description field becomes editable")
    public void descriptionFieldBecomesEditable() {
        verifyDescriptionFieldEditable();
    }

    @When("Admin enters a description with the maximum allowed characters")
    public void adminEntersADescriptionWithTheMaximumAllowedCharacters() {
        enterMaxLengthDescription();
    }

    @Then("Description is entered without any truncation")
    public void descriptionIsEnteredWithoutAnyTruncation() {
        verifyDescriptionEnteredCorrectly();
    }

    @When("Admin saves the changes")
    public void adminSavesTheChanges() {
        saveDescriptionChanges();
    }

    @Then("Changes are saved successfully and confirmation message is displayed")
    public void changesAreSavedSuccessfullyAndConfirmationMessageIsDisplayed() {
        verifyChangesSavedSuccessfully();
    }

    @When("Admin refreshes the page")
    public void adminRefreshesThePage() {
        refreshPage();
    }

    @Then("Updated description is displayed correctly")
    public void updatedDescriptionIsDisplayedCorrectly() {
        verifyUpdatedDescriptionDisplayed();
    }

    @When("Admin logs out from admin account")
    public void adminLogsOutFromAdminAccount() {
        logoutAdmin();
    }

    @Then("Admin is logged out successfully")
    public void adminIsLoggedOutSuccessfully() {
        verifyAdminLoggedOut();
    }

    @When("Admin logs in again and navigates to the product")
    public void adminLogsInAgainAndNavigatesToTheProduct() {
        loginAsAdmin();
        navigateToProductManagementModule();
        selectProductById("12345");
    }

    @Then("Description remains updated")
    public void descriptionRemainsUpdated() {
        verifyUpdatedDescriptionDisplayed();
    }

    @When("Admin attempts to edit description with more than maximum characters")
    public void adminAttemptsToEditDescriptionWithMoreThanMaximumCharacters() {
        enterOverMaxLengthDescription();
    }

    @Then("System prevents saving and displays error message")
    public void systemPreventsSavingAndDisplaysErrorMessage() {
        verifyErrorMessageDisplayed();
    }

    @When("Admin checks the database entry for the product description")
    public void adminChecksTheDatabaseEntryForTheProductDescription() {
        checkDatabaseForDescription();
    }

    @Then("Database reflects the updated description accurately")
    public void databaseReflectsTheUpdatedDescriptionAccurately() {
        verifyDatabaseDescription();
    }

    @When("Admin attempts to edit description with special characters")
    public void adminAttemptsToEditDescriptionWithSpecialCharacters() {
        enterSpecialCharactersDescription();
    }

    @Then("Special characters are accepted and saved correctly")
    public void specialCharactersAreAcceptedAndSavedCorrectly() {
        verifySpecialCharactersSaved();
    }

    @When("Admin verifies audit logs for the description change")
    public void adminVerifiesAuditLogsForTheDescriptionChange() {
        checkAuditLogsForDescriptionChange();
    }

    @Then("Audit logs show the change made with timestamp and admin ID")
    public void auditLogsShowTheChangeMadeWithTimestampAndAdminID() {
        verifyAuditLogs();
    }

    @When("Admin checks if description is correctly displayed on the customer-facing product page")
    public void adminChecksIfDescriptionIsCorrectlyDisplayedOnTheCustomerFacingProductPage() {
        checkCustomerFacingProductPage();
    }

    @Then("Updated description is visible on the product page")
    public void updatedDescriptionIsVisibleOnTheProductPage() {
        verifyCustomerFacingDescription();
    }

    @When("Admin attempts to edit description with HTML tags")
    public void adminAttemptsToEditDescriptionWithHTMLTags() {
        enterHTMLTagsDescription();
    }

    @Then("HTML tags are sanitized or displayed as text")
    public void htmlTagsAreSanitizedOrDisplayedAsText() {
        verifyHTMLTagsSanitized();
    }

    @When("Admin checks if the description update triggers any notification")
    public void adminChecksIfTheDescriptionUpdateTriggersAnyNotification() {
        checkForNotifications();
    }

    @Then("No unexpected notifications are triggered")
    public void noUnexpectedNotificationsAreTriggered() {
        verifyNoUnexpectedNotifications();
    }
}