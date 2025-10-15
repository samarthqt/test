package com.cucumber.steps;

import com.pageobjects.VBRPTablePage;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class VBRPTableSteps extends VBRPTablePage {

    @Given("the user has access to billing document data")
    public void theUserHasAccessToBillingDocumentData() {
        verifyBillingDocumentAccess();
    }

    @When("the user logs into the SAP S/4HANA system")
    public void theUserLogsIntoTheSAPSystem() {
        loginToSAPSystem();
    }

    @Then("the user is successfully logged into the system")
    public void theUserIsSuccessfullyLoggedIn() {
        verifySuccessfulLogin();
    }

    @Given("the user is logged into the SAP S/4HANA system")
    public void theUserIsLoggedIntoTheSAPSystem() {
        verifyUserLoggedIn();
    }

    @When("the user navigates to the VBRP table using transaction code SE16N")
    public void theUserNavigatesToTheVBRPTable() {
        navigateToVBRPTable();
    }

    @Then("the VBRP table is displayed")
    public void theVBRPTableIsDisplayed() {
        verifyVBRPTableDisplayed();
    }

    @Given("the user is on the VBRP table")
    public void theUserIsOnTheVBRPTable() {
        verifyOnVBRPTable();
    }

    @When("the user searches for the billing document {string}")
    public void theUserSearchesForTheBillingDocument(String billingDocument) {
        searchBillingDocument(billingDocument);
    }

    @Then("the billing document {string} is found in the VBRP table")
    public void theBillingDocumentIsFoundInTheVBRPTable(String billingDocument) {
        verifyBillingDocumentFound(billingDocument);
    }

    @Given("the user has located the billing document {string} in the VBRP table")
    public void theUserHasLocatedTheBillingDocument(String billingDocument) {
        verifyBillingDocumentLocated(billingDocument);
    }

    @When("the user verifies the PSTYV field for item category {string}")
    public void theUserVerifiesThePSTYVField(String itemCategory) {
        verifyPSTYVField(itemCategory);
    }

    @Then("the PSTYV field for {string} items shows {string}")
    public void thePSTYVFieldShowsExpectedValue(String itemCategory, String expectedValue) {
        verifyPSTYVFieldValue(itemCategory, expectedValue);
    }

    @When("the user checks the linkage between the billing document and the original document")
    public void theUserChecksTheLinkage() {
        verifyDocumentLinkage();
    }

    @Then("the linkage is accurate and consistent")
    public void theLinkageIsAccurate() {
        verifyLinkageConsistency();
    }

    @When("the user validates the financial impact of the billing document data")
    public void theUserValidatesFinancialImpact() {
        validateFinancialImpact();
    }

    @Then("the financial data is accurate and consistent with the billing document details")
    public void theFinancialDataIsAccurate() {
        verifyFinancialDataConsistency();
    }

    @When("the user generates a report to verify the consistency of data")
    public void theUserGeneratesAReport() {
        generateDataConsistencyReport();
    }

    @Then("the report shows consistent data with no discrepancies")
    public void theReportShowsConsistentData() {
        verifyReportConsistency();
    }

    @When("the user exports the VBRP table data for the billing document to a file")
    public void theUserExportsData() {
        exportVBRPTableData();
    }

    @Then("the data is successfully exported")
    public void theDataIsExported() {
        verifyDataExportSuccess();
    }

    @Given("the user has successfully exported the VBRP table data for the billing document")
    public void theUserHasExportedData() {
        verifyDataExported();
    }

    @When("the user shares the exported file with the audit team for review")
    public void theUserSharesExportedFile() {
        shareExportedFileWithAuditTeam();
    }

    @Then("the audit team confirms the accuracy of the data")
    public void theAuditTeamConfirmsAccuracy() {
        verifyAuditTeamConfirmation();
    }

    @Given("the user has completed the required actions")
    public void theUserHasCompletedActions() {
        verifyActionsCompleted();
    }

    @When("the user logs out of the SAP S/4HANA system")
    public void theUserLogsOut() {
        logoutFromSAPSystem();
    }

    @Then("the user is logged out successfully")
    public void theUserIsLoggedOutSuccessfully() {
        verifySuccessfulLogout();
    }

    @Given("the user has completed the validation and verification tasks")
    public void theUserHasCompletedValidationTasks() {
        verifyValidationTasksCompleted();
    }

    @When("the user documents the test results and observations")
    public void theUserDocumentsResults() {
        documentTestResults();
    }

    @Then("the test results and observations are documented successfully")
    public void theTestResultsAreDocumented() {
        verifyResultsDocumented();
    }
}