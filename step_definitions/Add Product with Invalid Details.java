package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.CatalogManagementPage;

public class CatalogManagementSteps extends CatalogManagementPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the admin is logged in using valid credentials {string} and {string}")
    public void theAdminIsLoggedInUsingValidCredentials(String email, String password) {
        loginAsAdmin(email, password);
    }

    @When("the admin navigates to the catalog management section")
    public void theAdminNavigatesToTheCatalogManagementSection() {
        navigateToCatalogManagement();
    }

    @When("the admin clicks on the 'Add Product' button")
    public void theAdminClicksOnTheAddProductButton() {
        clickAddProductButton();
    }

    @Then("the admin is directed to the product addition form at {string}")
    public void theAdminIsDirectedToTheProductAdditionFormAt(String url) {
        verifyProductAdditionFormUrl(url);
    }

    @When("the admin enters invalid product details: Name: '', Price: 'abc', SKU: '12345'")
    public void theAdminEntersInvalidProductDetails() {
        enterProductDetails("", "abc", "12345");
    }

    @When("the admin attempts to submit the form")
    public void theAdminAttemptsToSubmitTheForm() {
        submitProductForm();
    }

    @Then("error messages are displayed for invalid inputs")
    public void errorMessagesAreDisplayedForInvalidInputs() {
        verifyErrorMessagesForInvalidInputs();
    }

    @Then("detailed error messages are shown for empty name, non-numeric price, etc.")
    public void detailedErrorMessagesAreShown() {
        verifyDetailedErrorMessages();
    }

    @When("the admin attempts to correct one field at a time and resubmits")
    public void theAdminAttemptsToCorrectOneFieldAtATimeAndResubmits() {
        correctFieldsAndResubmit();
    }

    @Then("error messages update to reflect remaining invalid fields")
    public void errorMessagesUpdateToReflectRemainingInvalidFields() {
        verifyUpdatedErrorMessages();
    }

    @Then("no product is added to the catalog")
    public void noProductIsAddedToTheCatalog() {
        verifyNoProductAdded();
    }

    @Then("the database contains no new entries")
    public void theDatabaseContainsNoNewEntries() {
        verifyDatabaseNoNewEntries();
    }

    @Then("audit logs reflect failed attempts with error details")
    public void auditLogsReflectFailedAttempts() {
        verifyAuditLogsForFailedAttempts();
    }

    @When("the admin attempts to add a product with valid details")
    public void theAdminAttemptsToAddAProductWithValidDetails() {
        enterValidProductDetails();
    }

    @Then("the product is successfully added without errors")
    public void theProductIsSuccessfullyAddedWithoutErrors() {
        verifyProductAddedSuccessfully();
    }

    @Then("the admin logs out from the admin account")
    public void theAdminLogsOutFromTheAdminAccount() {
        logoutAdmin();
    }

    @Then("the admin is successfully logged out")
    public void theAdminIsSuccessfullyLoggedOut() {
        verifyAdminLoggedOut();
    }

    @Then("system performance remains stable and unaffected during invalid submissions")
    public void systemPerformanceRemainsStable() {
        verifySystemPerformance();
    }

    @Then("error messages provide clear guidance for correction")
    public void errorMessagesProvideClearGuidance() {
        verifyErrorMessagesGuidance();
    }

    @Then("no notifications are sent for invalid submissions")
    public void noNotificationsAreSentForInvalidSubmissions() {
        verifyNoNotificationsSent();
    }
}