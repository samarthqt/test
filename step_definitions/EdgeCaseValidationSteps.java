package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import com.pageobjects.EdgeCaseValidationPage;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class EdgeCaseValidationSteps extends EdgeCaseValidationPage {

    @Given("the user uploads an inbound file containing Site_ID {string} and CMO_ID {string}")
    public void theUserUploadsAnInboundFileContainingSiteIDAndCMOID(String siteId, String cmoId) {
        uploadInboundFile(siteId, cmoId);
    }

    @When("the user triggers the inbound interface processing manually")
    public void theUserTriggersTheInboundInterfaceProcessingManually() {
        triggerInboundProcessing();
    }

    @Then("the system starts processing without any issues")
    public void theSystemStartsProcessingWithoutAnyIssues() {
        verifyProcessingStartsSuccessfully();
    }

    @Then("the Plant is determined accurately based on the CMO_ID {string}")
    public void thePlantIsDeterminedAccuratelyBasedOnTheCMOID(String cmoId) {
        verifyPlantDetermination(cmoId);
    }

    @Then("the Ship To and Sold To partners are resolved correctly using the Site_ID {string}")
    public void theShipToAndSoldToPartnersAreResolvedCorrectlyUsingTheSiteID(String siteId) {
        verifyPartnerResolution(siteId);
    }

    @Then("no warnings or errors related to field length are observed in the logs")
    public void noWarningsOrErrorsRelatedToFieldLengthAreObservedInTheLogs() {
        verifyNoFieldLengthWarningsOrErrors();
    }

    @Then("the maximum length values are stored correctly in the database")
    public void theMaximumLengthValuesAreStoredCorrectlyInTheDatabase() {
        verifyDatabaseStorageForMaxLengthValues();
    }

    @Then("the system processes all maximum length records successfully")
    public void theSystemProcessesAllMaximumLengthRecordsSuccessfully() {
        verifySuccessfulProcessingOfMaxLengthRecords();
    }

    @Then("the processed data matches the input file exactly")
    public void theProcessedDataMatchesTheInputFileExactly() {
        verifyProcessedDataMatchesInputFile();
    }

    @Then("the system performs efficiently without degradation")
    public void theSystemPerformsEfficientlyWithoutDegradation() {
        verifySystemPerformance();
    }

    @Then("the system adheres to the defined field length validation rules")
    public void theSystemAdheresToTheDefinedFieldLengthValidationRules() {
        verifyFieldLengthValidationRules();
    }

    @Then("the downstream workflows process the data without issues")
    public void theDownstreamWorkflowsProcessTheDataWithoutIssues() {
        verifyDownstreamWorkflowProcessing();
    }

    @Then("the audit trail captures all processing details accurately")
    public void theAuditTrailCapturesAllProcessingDetailsAccurately() {
        verifyAuditTrailDetails();
    }
}