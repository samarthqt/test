package com.cucumber.steps;

import com.pageobjects.AccessSequencePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class AccessSequenceSteps {

    private AccessSequencePage accessSequencePage = new AccessSequencePage();
    private TestHarness testHarness = new TestHarness();

    @Given("the user navigates to transaction {string} for maintaining access sequences")
    public void theUserNavigatesToTransactionForMaintainingAccessSequences(String transactionCode) {
        accessSequencePage.navigateToTransaction(transactionCode);
    }

    @Then("the access sequence maintenance screen is displayed")
    public void theAccessSequenceMaintenanceScreenIsDisplayed() {
        accessSequencePage.verifyAccessSequenceScreenDisplayed();
    }

    @Given("the access sequence {string} exists in the system")
    public void theAccessSequenceExistsInTheSystem(String accessSequence) {
        accessSequencePage.verifyAccessSequenceExists(accessSequence);
    }

    @When("the user searches for and selects access sequence {string}")
    public void theUserSearchesForAndSelectsAccessSequence(String accessSequence) {
        accessSequencePage.searchAndSelectAccessSequence(accessSequence);
    }

    @Then("the access sequence {string} is displayed for editing")
    public void theAccessSequenceIsDisplayedForEditing(String accessSequence) {
        accessSequencePage.verifyAccessSequenceDisplayedForEditing(accessSequence);
    }

    @Given("the condition table {string} exists with field mapping {string}")
    public void theConditionTableExistsWithFieldMapping(String conditionTable, String fieldMapping) {
        accessSequencePage.verifyConditionTableExists(conditionTable, fieldMapping);
    }

    @When("the user adds condition table {string} to the access sequence {string}")
    public void theUserAddsConditionTableToTheAccessSequence(String conditionTable, String accessSequence) {
        accessSequencePage.addConditionTableToAccessSequence(conditionTable, accessSequence);
    }

    @Then("the condition table {string} is added to the access sequence")
    public void theConditionTableIsAddedToTheAccessSequence(String conditionTable) {
        accessSequencePage.verifyConditionTableAdded(conditionTable);
    }

    @Given("the condition table {string} is added to the access sequence {string}")
    public void theConditionTableIsAddedToTheAccessSequence(String conditionTable, String accessSequence) {
        accessSequencePage.verifyConditionTableAddedToAccessSequence(conditionTable, accessSequence);
    }

    @When("the user defines the field mapping for condition table {string} as {string}")
    public void theUserDefinesTheFieldMappingForConditionTableAs(String conditionTable, String fieldMapping) {
        accessSequencePage.defineFieldMappingForConditionTable(conditionTable, fieldMapping);
    }

    @Then("the field mapping is defined successfully")
    public void theFieldMappingIsDefinedSuccessfully() {
        accessSequencePage.verifyFieldMappingDefinedSuccessfully();
    }

    @Given("the user has defined field mapping for condition table {string} in access sequence {string}")
    public void theUserHasDefinedFieldMappingForConditionTableInAccessSequence(String conditionTable, String accessSequence) {
        accessSequencePage.verifyFieldMappingDefined(conditionTable, accessSequence);
    }

    @When("the user saves the changes to access sequence {string} without activating it")
    public void theUserSavesTheChangesToAccessSequenceWithoutActivatingIt(String accessSequence) {
        accessSequencePage.saveAccessSequenceWithoutActivation(accessSequence);
    }

    @Then("the changes are saved successfully, but the access sequence is not activated")
    public void theChangesAreSavedSuccessfullyButTheAccessSequenceIsNotActivated() {
        accessSequencePage.verifyChangesSavedWithoutActivation();
    }

    @Given("the access sequence {string} is saved without activation")
    public void theAccessSequenceIsSavedWithoutActivation(String accessSequence) {
        accessSequencePage.verifyAccessSequenceSavedWithoutActivation(accessSequence);
    }

    @When("the user attempts to use the access sequence {string} in a billing scenario")
    public void theUserAttemptsToUseTheAccessSequenceInABillingScenario(String accessSequence) {
        accessSequencePage.attemptToUseAccessSequenceInBillingScenario(accessSequence);
    }

    @Then("the system displays an error message indicating that the access sequence is not activated")
    public void theSystemDisplaysAnErrorMessageIndicatingThatTheAccessSequenceIsNotActivated() {
        accessSequencePage.verifyErrorMessageForUnactivatedAccessSequence();
    }

    @When("the user activates the access sequence {string}")
    public void theUserActivatesTheAccessSequence(String accessSequence) {
        accessSequencePage.activateAccessSequence(accessSequence);
    }

    @When("the user retries the billing scenario")
    public void theUserRetriesTheBillingScenario() {
        accessSequencePage.retryBillingScenario();
    }

    @Then("the billing scenario works correctly after activation")
    public void theBillingScenarioWorksCorrectlyAfterActivation() {
        accessSequencePage.verifyBillingScenarioWorksAfterActivation();
    }

    @Given("the condition table {string} is created and activated")
    public void theConditionTableIsCreatedAndActivated(String conditionTable) {
        accessSequencePage.verifyConditionTableCreatedAndActivated(conditionTable);
    }

    @When("the user defines the maximum number of field mappings with the following fields:")
    public void theUserDefinesTheMaximumNumberOfFieldMappingsWithTheFollowingFields(io.cucumber.datatable.DataTable dataTable) {
        accessSequencePage.defineMaximumFieldMappings(dataTable);
    }

    @Then("the maximum field mappings are defined successfully")
    public void theMaximumFieldMappingsAreDefinedSuccessfully() {
        accessSequencePage.verifyMaximumFieldMappingsDefined();
    }

    @Given("the maximum field mappings are defined for condition table {string}")
    public void theMaximumFieldMappingsAreDefinedForConditionTable(String conditionTable) {
        accessSequencePage.verifyMaximumFieldMappingsDefinedForConditionTable(conditionTable);
    }

    @When("the user saves and activates the access sequence {string}")
    public void theUserSavesAndActivatesTheAccessSequence(String accessSequence) {
        accessSequencePage.saveAndActivateAccessSequence(accessSequence);
    }

    @Then("the access sequence {string} is saved and activated successfully")
    public void theAccessSequenceIsSavedAndActivatedSuccessfully(String accessSequence) {
        accessSequencePage.verifyAccessSequenceSavedAndActivated(accessSequence);
    }

    @Given("the access sequence {string} is saved and activated with condition table {string}")
    public void theAccessSequenceIsSavedAndActivatedWithConditionTable(String accessSequence, String conditionTable) {
        accessSequencePage.verifyAccessSequenceSavedAndActivatedWithConditionTable(accessSequence, conditionTable);
    }

    @When("the user creates a billing document and tests output determination")
    public void theUserCreatesABillingDocumentAndTestsOutputDetermination() {
        accessSequencePage.createBillingDocumentAndTestOutputDetermination();
    }

    @Then("the output determination works correctly with maximum field mappings")
    public void theOutputDeterminationWorksCorrectlyWithMaximumFieldMappings() {
        accessSequencePage.verifyOutputDeterminationWithMaximumFieldMappings();
    }

    @Given("the output determination works correctly with maximum field mappings")
    public void theOutputDeterminationWorksCorrectlyWithMaximumFieldMappingsGiven() {
        accessSequencePage.verifyOutputDeterminationWithMaximumFieldMappings();
    }

    @When("the user reviews the logs")
    public void theUserReviewsTheLogs() {
        accessSequencePage.reviewLogs();
    }

    @Then("the logs indicate successful processing without errors")
    public void theLogsIndicateSuccessfulProcessingWithoutErrors() {
        accessSequencePage.verifyLogsIndicateSuccessfulProcessing();
    }

    @Given("the user has authorized credentials")
    public void theUserHasAuthorizedCredentials() {
        accessSequencePage.authorizeCredentials();
    }

    @When("the user logs into the SAP system")
    public void theUserLogsIntoTheSAPSystem() {
        accessSequencePage.loginToSAPSystem();
    }

    @Then("the user successfully logs into the system")
    public void theUserSuccessfullyLogsIntoTheSystem() {
        accessSequencePage.verifySuccessfulLogin();
    }

    @Given("the user is logged into the SAP system")
    public void theUserIsLoggedIntoTheSAPSystem() {
        accessSequencePage.verifyUserLoggedIn();
    }

    @When("the user navigates to transaction V/07")
    public void theUserNavigatesToTransactionV07() {
        accessSequencePage.navigateToTransactionV07();
    }

    @Then("the transaction V/07 screen is displayed")
    public void theTransactionV07ScreenIsDisplayed() {
        accessSequencePage.verifyTransactionScreenDisplayed();
    }

    @Given("the user is on the transaction V/07 screen")
    public void theUserIsOnTheTransactionV07Screen() {
        accessSequencePage.verifyTransactionScreenDisplayed();
    }

    @When("the user selects access sequence Z002 for editing")
    public void theUserSelectsAccessSequenceZ002ForEditing() {
        accessSequencePage.selectAccessSequenceZ002();
    }

    @Then("access sequence Z002 is opened for editing")
    public void accessSequenceZ002IsOpenedForEditing() {
        accessSequencePage.verifyAccessSequenceOpened();
    }

    @Given("the user is editing access sequence Z002")
    public void theUserIsEditingAccessSequenceZ002() {
        accessSequencePage.verifyAccessSequenceEditing();
    }

    @When("the user adds condition table 911 and other relevant tables to the access sequence")
    public void theUserAddsConditionTable911AndOtherRelevantTablesToTheAccessSequence() {
        accessSequencePage.addConditionTablesToAccessSequence();
    }

    @Then("the condition tables are added to the access sequence successfully")
    public void theConditionTablesAreAddedToTheAccessSequenceSuccessfully() {
        accessSequencePage.verifyConditionTablesAdded();
    }

    @Given("the user has added condition tables to the access sequence")
    public void theUserHasAddedConditionTablesToTheAccessSequence() {
        accessSequencePage.verifyConditionTablesAdded();
    }

    @When("the user defines the sequence order and field mappings for all tables")
    public void theUserDefinesTheSequenceOrderAndFieldMappingsForAllTables() {
        accessSequencePage.defineSequenceOrderAndFieldMappings();
    }

    @Then("the sequence order and field mappings are defined correctly")
    public void theSequenceOrderAndFieldMappingsAreDefinedCorrectly() {
        accessSequencePage.verifySequenceOrderAndFieldMappings();
    }

    @Given("the user has defined the sequence order and field mappings")
    public void theUserHasDefinedTheSequenceOrderAndFieldMappings() {
        accessSequencePage.verifySequenceOrderAndFieldMappings();
    }

    @When("the user saves the changes made to the access sequence")
    public void theUserSavesTheChangesMadeToTheAccessSequence() {
        accessSequencePage.saveAccessSequenceChanges();
    }

    @Then("the changes are saved successfully")
    public void theChangesAreSavedSuccessfully() {
        accessSequencePage.verifyChangesSavedSuccessfully();
    }

    @Given("the user has saved the changes made to the access sequence")
    public void theUserHasSavedTheChangesMadeToTheAccessSequence() {
        accessSequencePage.verifyChangesSavedSuccessfully();
    }

    @When("the user activates the updated access sequence Z002")
    public void theUserActivatesTheUpdatedAccessSequenceZ002() {
        accessSequencePage.activateAccessSequenceZ002();
    }

    @Then("the access sequence Z002 is activated without errors")
    public void theAccessSequenceZ002IsActivatedWithoutErrors() {
        accessSequencePage.verifyAccessSequenceActivated();
    }

    @Given("the user has activated the updated access sequence Z002")
    public void theUserHasActivatedTheUpdatedAccessSequenceZ002() {
        accessSequencePage.verifyAccessSequenceActivated();
    }

    @When("the user creates a test billing document that will utilize access sequence Z002")
    public void theUserCreatesATestBillingDocumentThatWillUtilizeAccessSequenceZ002() {
        accessSequencePage.createTestBillingDocument();
    }

    @Then("the billing document is created successfully")
    public void theBillingDocumentIsCreatedSuccessfully() {
        accessSequencePage.verifyBillingDocumentCreated();
    }

    @Given("the user has created a test billing document")
    public void theUserHasCreatedATestBillingDocument() {
        accessSequencePage.verifyBillingDocumentCreated();
    }

    @When("the user triggers output determination for the test billing document")
    public void theUserTriggersOutputDeterminationForTheTestBillingDocument() {
        accessSequencePage.triggerOutputDetermination();
    }

    @Then("the output determination process is executed")
    public void theOutputDeterminationProcessIsExecuted() {
        accessSequencePage.verifyOutputDeterminationExecuted();
    }

    @Given("the user has triggered output determination for the test billing document")
    public void theUserHasTriggeredOutputDeterminationForTheTestBillingDocument() {
        accessSequencePage.verifyOutputDeterminationExecuted();
    }

    @When("the user verifies the condition table referenced based on the defined sequence")
    public void theUserVerifiesTheConditionTableReferencedBasedOnTheDefinedSequence() {
        accessSequencePage.verifyConditionTableReferenced();
    }

    @Then("condition table 911 is referenced correctly")
    public void conditionTable911IsReferencedCorrectly() {
        accessSequencePage.verifyConditionTable911Referenced();
    }

    @Given("the user has verified the correct condition table is referenced")
    public void theUserHasVerifiedTheCorrectConditionTableIsReferenced() {
        accessSequencePage.verifyConditionTable911Referenced();
    }

    @When("the user confirms that ZPDT output determination prioritizes tables based on the defined sequence")
    public void theUserConfirmsThatZPDTOutputDeterminationPrioritizesTablesBasedOnTheDefinedSequence() {
        accessSequencePage.confirmZPDTOutputDetermination();
    }

    @Then("ZPDT output determination works as expected without errors")
    public void zpdtOutputDeterminationWorksAsExpectedWithoutErrors() {
        accessSequencePage.verifyZPDTOutputDetermination();
    }

    @Given("the user has confirmed ZPDT output determination works as expected")
    public void theUserHasConfirmedZPDTOutputDeterminationWorksAsExpected() {
        accessSequencePage.verifyZPDTOutputDetermination();
    }

    @When("the user checks for any performance or functionality issues during the determination process")
    public void theUserChecksForAnyPerformanceOrFunctionalityIssuesDuringTheDeterminationProcess() {
        accessSequencePage.checkPerformanceAndFunctionalityIssues();
    }

    @Then("no performance or functionality issues are observed")
    public void noPerformanceOrFunctionalityIssuesAreObserved() {
        accessSequencePage.verifyNoPerformanceIssues();
    }
}
