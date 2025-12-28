package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import com.pageobjects.PlantPartnerPage;
import com.framework.cucumber.TestHarness;

public class PlantPartnerSteps extends PlantPartnerPage {

    @Given("the user uploads an inbound file with CMO_ID {string} and Site_ID {string} into the SAP system")
    public void uploadInboundFile(String cmoId, String siteId) {
        uploadInboundFileWithDetails(cmoId, siteId);
    }

    @Then("the file is successfully uploaded without any errors")
    public void verifyFileUpload() {
        validateFileUpload();
    }

    @Given("the user triggers the inbound interface processing manually")
    public void triggerInboundProcessing() {
        triggerInterfaceProcessing();
    }

    @Then("the interface processing starts without any issues")
    public void verifyInterfaceProcessing() {
        validateInterfaceProcessing();
    }

    @Given("the user has uploaded the inbound file and triggered processing")
    public void uploadAndTriggerProcessing() {
        uploadAndTriggerFileProcessing();
    }

    @Then("the Plant is determined correctly based on the CMO_ID and Sofie/Petnet logic")
    public void verifyPlantDetermination() {
        validatePlantDetermination();
    }

    @Then("the Ship To and Sold To partners are resolved correctly using Site_ID and KNVP lookups")
    public void verifyPartnerResolution() {
        validatePartnerResolution();
    }

    @Then("the Bill To and Payer partners are assigned correctly as per Sofie/Petnet rules")
    public void verifyBillToAndPayerAssignment() {
        validateBillToAndPayerAssignment();
    }

    @Then("a 3rd party/central ordering partner row is added successfully when Site_ID is present")
    public void verifyThirdPartyPartnerRow() {
        validateThirdPartyPartnerRow();
    }

    @Given("the user checks the logs after processing the inbound file")
    public void checkProcessingLogs() {
        checkLogsForProcessing();
    }

    @Then("no errors or warnings are observed in the logs")
    public void verifyLogs() {
        validateLogs();
    }

    @Given("the user reviews the processed data in the system")
    public void reviewProcessedData() {
        reviewProcessedDataInSystem();
    }

    @Then("the processed data matches the input file accurately")
    public void verifyProcessedData() {
        validateProcessedData();
    }

    @Given("the user checks the database after processing")
    public void checkDatabase() {
        checkDatabaseForUpdates();
    }

    @Then("the database is updated with accurate partner and Plant information")
    public void verifyDatabaseUpdates() {
        validateDatabaseUpdates();
    }

    @Given("the user cross-checks the Plant and partner assignments")
    public void crossCheckAssignments() {
        crossCheckPlantAndPartnerAssignments();
    }

    @Then("the assignments comply with the defined business rules")
    public void verifyAssignmentsCompliance() {
        validateAssignmentsCompliance();
    }

    @Given("the user uploads an inbound file with {string} records")
    public void uploadFileWithMultipleRecords(String recordCount) {
        uploadFileWithRecords(recordCount);
    }

    @When("the user triggers the processing of the file")
    public void triggerFileProcessing() {
        triggerProcessingOfFile();
    }

    @Then("the system processes all records without errors")
    public void verifyMultipleRecordsProcessing() {
        validateMultipleRecordsProcessing();
    }

    @Given("the user reviews the processed data")
    public void reviewProcessedDataForWorkflows() {
        reviewDataForWorkflows();
    }

    @Then("the data is prepared for further processing without issues")
    public void verifyDataPreparation() {
        validateDataPreparation();
    }
}