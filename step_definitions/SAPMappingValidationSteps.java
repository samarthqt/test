package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;

import com.pageobjects.SAPMappingValidationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class SAPMappingValidationSteps extends SAPMappingValidationPage {

    @Given("the user is logged into the SAP S/4HANA Cloud system")
    public void theUserIsLoggedIntoTheSAPSystem() {
        loginToSAPSystem();
    }

    @Given("the user navigates to the Sales Order to Billing Document copy process screen")
    public void theUserNavigatesToSalesOrderScreen() {
        navigateToSalesOrderScreen();
    }

    @When("the user selects a sales order with KATR1 {string} and KATR2 {string}")
    public void theUserSelectsSalesOrder(String katr1, String katr2) {
        selectSalesOrder(katr1, katr2);
    }

    @When("the user initiates the copy process to generate a billing document")
    public void theUserInitiatesCopyProcess() {
        initiateCopyProcess();
    }

    @Then("the system generates a meaningful error message indicating missing mapping rules for KATR1 {string} and KATR2 {string}")
    public void theSystemGeneratesErrorMessage(String katr1, String katr2) {
        verifyErrorMessage(katr1, katr2);
    }

    @Given("the user navigates to the system logs")
    public void theUserNavigatesToSystemLogs() {
        navigateToSystemLogs();
    }

    @When("the user verifies the logs for missing configuration entries")
    public void theUserVerifiesLogsForMissingConfiguration() {
        verifyLogsForMissingConfiguration();
    }

    @Then("the logs capture the missing configuration for troubleshooting")
    public void theLogsCaptureMissingConfiguration() {
        verifyLogsCaptureMissingConfiguration();
    }

    @When("the user reviews the error messages or warnings displayed in the logs")
    public void theUserReviewsErrorMessagesInLogs() {
        reviewErrorMessagesInLogs();
    }

    @Then("the error messages or warnings clearly indicate the absence of mapping rules for KATR1/KATR2")
    public void theErrorMessagesIndicateAbsenceOfMappingRules() {
        verifyErrorMessagesIndicateAbsenceOfMappingRules();
    }

    @Given("the user has completed the validation of error messages and system logs")
    public void theUserHasCompletedValidation() {
        completeValidation();
    }

    @When("the user documents the results of the test cases for each sales order")
    public void theUserDocumentsResults() {
        documentTestResults();
    }

    @Then("the results are documented successfully")
    public void theResultsAreDocumentedSuccessfully() {
        verifyResultsDocumentedSuccessfully();
    }

    @Given("the user has completed documenting the test results")
    public void theUserHasCompletedDocumentingResults() {
        completeDocumentingResults();
    }

    @When("the user logs out of the SAP S/4HANA Cloud system")
    public void theUserLogsOut() {
        logoutOfSAPSystem();
    }

    @When("the user submits the test results for review")
    public void theUserSubmitsTestResults() {
        submitTestResults();
    }

    @Then("the test results are submitted successfully")
    public void theTestResultsAreSubmittedSuccessfully() {
        verifyTestResultsSubmittedSuccessfully();
    }
}