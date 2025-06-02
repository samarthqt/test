package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.CatalogPage;

public class CatalogManagementSteps extends CatalogPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the admin is logged in with valid credentials {string} and {string}")
    public void theAdminIsLoggedInWithValidCredentials(String email, String password) {
        loginAsAdmin(email, password);
    }

    @Given("the product with ID {string} exists in the catalog")
    public void theProductWithIDExistsInTheCatalog(String productId) {
        verifyProductExistsInCatalog(productId);
    }

    @When("the admin navigates to the catalog management section at {string}")
    public void theAdminNavigatesToTheCatalogManagementSectionAt(String url) {
        navigateToCatalogManagement(url);
    }

    @When("the admin searches for the product using the product ID {string}")
    public void theAdminSearchesForTheProductUsingTheProductID(String productId) {
        searchProductById(productId);
    }

    @Then("the product details are displayed correctly")
    public void theProductDetailsAreDisplayedCorrectly() {
        verifyProductDetailsDisplayed();
    }

    @When("the admin selects the product to be deleted")
    public void theAdminSelectsTheProductToBeDeleted() {
        selectProductForDeletion();
    }

    @Then("the delete option is visible")
    public void theDeleteOptionIsVisible() {
        verifyDeleteOptionVisible();
    }

    @When("the admin clicks on the delete button")
    public void theAdminClicksOnTheDeleteButton() {
        clickDeleteButton();
    }

    @Then("a confirmation dialog appears asking for confirmation to delete the product")
    public void aConfirmationDialogAppearsAskingForConfirmationToDeleteTheProduct() {
        verifyConfirmationDialogAppears();
    }

    @When("the admin confirms the deletion in the dialog")
    public void theAdminConfirmsTheDeletionInTheDialog() {
        confirmDeletionInDialog();
    }

    @Then("the product is successfully deleted from the catalog")
    public void theProductIsSuccessfullyDeletedFromTheCatalog() {
        verifyProductDeletedFromCatalog();
    }

    @Then("the product is no longer listed in the catalog")
    public void theProductIsNoLongerListedInTheCatalog() {
        verifyProductNotListedInCatalog();
    }

    @Then("no error messages or alerts are displayed")
    public void noErrorMessagesOrAlertsAreDisplayed() {
        verifyNoErrorMessagesOrAlerts();
    }

    @When("the admin logs out from the admin account")
    public void theAdminLogsOutFromTheAdminAccount() {
        logoutAdminAccount();
    }

    @Then("the admin is successfully logged out")
    public void theAdminIsSuccessfullyLoggedOut() {
        verifyAdminLoggedOut();
    }

    @When("the admin attempts to access the deleted product via direct URL")
    public void theAdminAttemptsToAccessTheDeletedProductViaDirectURL() {
        accessDeletedProductViaURL();
    }

    @Then("an error message indicating the product does not exist is displayed")
    public void anErrorMessageIndicatingTheProductDoesNotExistIsDisplayed() {
        verifyProductDoesNotExistErrorMessage();
    }

    @When("the admin checks the database for the product entry")
    public void theAdminChecksTheDatabaseForTheProductEntry() {
        checkDatabaseForProductEntry();
    }

    @Then("the product entry is removed from the database")
    public void theProductEntryIsRemovedFromTheDatabase() {
        verifyProductEntryRemovedFromDatabase();
    }

    @When("the admin verifies audit logs for the deletion action")
    public void theAdminVerifiesAuditLogsForTheDeletionAction() {
        verifyAuditLogsForDeletion();
    }

    @Then("audit logs show the product deletion action with admin details")
    public void auditLogsShowTheProductDeletionActionWithAdminDetails() {
        verifyAuditLogsShowDeletionAction();
    }

    @When("the admin checks for any automatic notifications sent regarding the deletion")
    public void theAdminChecksForAnyAutomaticNotificationsSentRegardingTheDeletion() {
        checkAutomaticNotificationsForDeletion();
    }

    @Then("notifications are sent to relevant stakeholders if applicable")
    public void notificationsAreSentToRelevantStakeholdersIfApplicable() {
        verifyNotificationsSentToStakeholders();
    }

    @When("the admin reviews system performance post-deletion")
    public void theAdminReviewsSystemPerformancePostDeletion() {
        reviewSystemPerformancePostDeletion();
    }

    @Then("system performance remains stable and unaffected")
    public void systemPerformanceRemainsStableAndUnaffected() {
        verifySystemPerformanceStable();
    }

    @Then("no dependent products or categories are affected by the deletion")
    public void noDependentProductsOrCategoriesAreAffectedByTheDeletion() {
        verifyNoDependentProductsAffected();
    }
}