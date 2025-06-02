package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.ProductAdditionPage;

public class ProductAdditionSteps extends ProductAdditionPage {

    private TestHarness testHarness = new TestHarness();

    @Given("I am logged in as an admin")
    public void iAmLoggedInAsAnAdmin() {
        loginAsAdmin();
    }

    @Given("I navigate to the product addition section")
    public void iNavigateToTheProductAdditionSection() {
        navigateToProductAdditionSection();
    }

    @When("I attempt to add a product with a missing name field")
    public void iAttemptToAddAProductWithAMissingNameField() {
        addProductWithMissingName();
    }

    @Then("the system displays an error message indicating missing required fields")
    public void theSystemDisplaysAnErrorMessageIndicatingMissingRequiredFields() {
        verifyErrorMessage("Missing required fields");
    }

    @When("I attempt to add a product with an invalid price format")
    public void iAttemptToAddAProductWithAnInvalidPriceFormat() {
        addProductWithInvalidPrice();
    }

    @Then("the system displays an error message indicating invalid price format")
    public void theSystemDisplaysAnErrorMessageIndicatingInvalidPriceFormat() {
        verifyErrorMessage("Invalid price format");
    }

    @When("I attempt to add a product with missing category information")
    public void iAttemptToAddAProductWithMissingCategoryInformation() {
        addProductWithMissingCategory();
    }

    @Then("the system displays an error message indicating missing category information")
    public void theSystemDisplaysAnErrorMessageIndicatingMissingCategoryInformation() {
        verifyErrorMessage("Missing category information");
    }

    @When("I attempt to add a product with an excessively long description")
    public void iAttemptToAddAProductWithAnExcessivelyLongDescription() {
        addProductWithLongDescription();
    }

    @Then("the system displays an error message indicating description exceeds maximum length")
    public void theSystemDisplaysAnErrorMessageIndicatingDescriptionExceedsMaximumLength() {
        verifyErrorMessage("Description exceeds maximum length");
    }

    @Given("I attempt to add products with invalid details")
    public void iAttemptToAddProductsWithInvalidDetails() {
        attemptInvalidProductAdditions();
    }

    @When("I check the system logs")
    public void iCheckTheSystemLogs() {
        checkSystemLogs();
    }

    @Then("the system logs record all invalid attempts with appropriate error messages")
    public void theSystemLogsRecordAllInvalidAttemptsWithAppropriateErrorMessages() {
        verifySystemLogsForErrors();
    }

    @When("I check the database")
    public void iCheckTheDatabase() {
        checkDatabaseForInvalidEntries();
    }

    @Then("the database remains unchanged; no invalid product entries are stored")
    public void theDatabaseRemainsUnchangedNoInvalidProductEntriesAreStored() {
        verifyDatabaseUnchanged();
    }

    @Given("I repeatedly attempt to add products with invalid details")
    public void iRepeatedlyAttemptToAddProductsWithInvalidDetails() {
        repeatInvalidProductAdditions();
    }

    @When("I monitor the system alerts")
    public void iMonitorTheSystemAlerts() {
        monitorSystemAlerts();
    }

    @Then("alerts are triggered for repeated invalid attempts")
    public void alertsAreTriggeredForRepeatedInvalidAttempts() {
        verifyAlertsTriggered();
    }

    @Given("I am an admin attempting to add products with invalid details")
    public void iAmAnAdminAttemptingToAddProductsWithInvalidDetails() {
        attemptInvalidProductAdditions();
    }

    @When("I receive feedback from the system")
    public void iReceiveFeedbackFromTheSystem() {
        receiveSystemFeedback();
    }

    @Then("the admin receives clear feedback on invalid input without system crashes")
    public void theAdminReceivesClearFeedbackOnInvalidInputWithoutSystemCrashes() {
        verifyClearFeedback();
    }

    @When("I check the security protocols")
    public void iCheckTheSecurityProtocols() {
        checkSecurityProtocols();
    }

    @Then("security protocols are enforced without compromise")
    public void securityProtocolsAreEnforcedWithoutCompromise() {
        verifySecurityProtocols();
    }

    @Given("I accidentally add a product with invalid details")
    public void iAccidentallyAddAProductWithInvalidDetails() {
        addProductAccidentally();
    }

    @When("I attempt to undo the addition")
    public void iAttemptToUndoTheAddition() {
        attemptUndoAddition();
    }

    @Then("admins can undo invalid product additions successfully")
    public void adminsCanUndoInvalidProductAdditionsSuccessfully() {
        verifyUndoSuccess();
    }

    @When("I review the audit trails")
    public void iReviewTheAuditTrails() {
        reviewAuditTrails();
    }

    @Then("audit trails accurately record all invalid attempts by admin")
    public void auditTrailsAccuratelyRecordAllInvalidAttemptsByAdmin() {
        verifyAuditTrails();
    }

    @When("I check synchronization with external systems")
    public void iCheckSynchronizationWithExternalSystems() {
        checkExternalSystemSync();
    }

    @Then("no invalid product updates are synchronized with external systems")
    public void noInvalidProductUpdatesAreSynchronizedWithExternalSystems() {
        verifyNoExternalSync();
    }

    @When("I monitor system performance")
    public void iMonitorSystemPerformance() {
        monitorSystemPerformance();
    }

    @Then("system performance remains stable without degradation")
    public void systemPerformanceRemainsStableWithoutDegradation() {
        verifySystemPerformance();
    }

    @When("I receive error messages")
    public void iReceiveErrorMessages() {
        receiveErrorMessages();
    }

    @Then("error messages provide clear guidance on correcting invalid input")
    public void errorMessagesProvideClearGuidanceOnCorrectingInvalidInput() {
        verifyErrorMessageGuidance();
    }
}