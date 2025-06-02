package com.cucumber.steps;

import com.page_objects.BackendOperationsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BackendOperationsSteps extends BackendOperationsPage {

    @Given("the PostgreSQL database is accessible")
    public void thePostgreSQLDatabaseIsAccessible() {
        verifyDatabaseAccessibility();
    }

    @When("I set up the database with sample records")
    public void iSetUpTheDatabaseWithSampleRecords() {
        setupDatabaseWithSampleRecords();
    }

    @Then("the database should be set up correctly with sample records")
    public void theDatabaseShouldBeSetUpCorrectlyWithSampleRecords() {
        verifyDatabaseSetup();
    }

    @Given("the Node.js and Express environment is configured")
    public void theNodeJsAndExpressEnvironmentIsConfigured() {
        verifyNodeJsExpressConfiguration();
    }

    @When("I start the Node.js server")
    public void iStartTheNodeJsServer() {
        startNodeJsServer();
    }

    @Then("the server should start without errors")
    public void theServerShouldStartWithoutErrors() {
        verifyServerStart();
    }

    @Given("the Node.js application is running")
    public void theNodeJsApplicationIsRunning() {
        verifyNodeJsApplicationRunning();
    }

    @When("I connect to the PostgreSQL database")
    public void iConnectToThePostgreSQLDatabase() {
        connectToDatabase();
    }

    @Then("the connection should be established successfully")
    public void theConnectionShouldBeEstablishedSuccessfully() {
        verifyDatabaseConnection();
    }

    @Given("the API endpoint for data retrieval is available")
    public void theAPIEndpointForDataRetrievalIsAvailable() {
        verifyDataRetrievalEndpoint();
    }

    @When("I perform a data retrieval operation")
    public void iPerformADataRetrievalOperation() {
        performDataRetrieval();
    }

    @Then("the data should be retrieved successfully from the database")
    public void theDataShouldBeRetrievedSuccessfullyFromTheDatabase() {
        verifyDataRetrievalSuccess();
    }

    @Given("data has been retrieved from the database")
    public void dataHasBeenRetrievedFromTheDatabase() {
        verifyDataRetrieved();
    }

    @When("I verify the retrieved data")
    public void iVerifyTheRetrievedData() {
        verifyRetrievedDataIntegrity();
    }

    @Then("the data should match the sample records in the database")
    public void theDataShouldMatchTheSampleRecordsInTheDatabase() {
        verifyDataMatchesSampleRecords();
    }

    @Given("the API endpoint for data insertion is available")
    public void theAPIEndpointForDataInsertionIsAvailable() {
        verifyDataInsertionEndpoint();
    }

    @When("I perform a data insertion operation")
    public void iPerformADataInsertionOperation() {
        performDataInsertion();
    }

    @Then("the data should be inserted successfully into the database")
    public void theDataShouldBeInsertedSuccessfullyIntoTheDatabase() {
        verifyDataInsertionSuccess();
    }

    @Given("data has been inserted into the database")
    public void dataHasBeenInsertedIntoTheDatabase() {
        verifyDataInserted();
    }

    @When("I verify the inserted data")
    public void iVerifyTheInsertedData() {
        verifyInsertedDataIntegrity();
    }

    @Then("the data should be correctly stored in the database")
    public void theDataShouldBeCorrectlyStoredInTheDatabase() {
        verifyDataStorageCorrectness();
    }

    @Given("the API endpoint for data update is available")
    public void theAPIEndpointForDataUpdateIsAvailable() {
        verifyDataUpdateEndpoint();
    }

    @When("I perform a data update operation")
    public void iPerformADataUpdateOperation() {
        performDataUpdate();
    }

    @Then("the data should be updated successfully in the database")
    public void theDataShouldBeUpdatedSuccessfullyInTheDatabase() {
        verifyDataUpdateSuccess();
    }

    @Given("data has been updated in the database")
    public void dataHasBeenUpdatedInTheDatabase() {
        verifyDataUpdated();
    }

    @When("I verify the updated data")
    public void iVerifyTheUpdatedData() {
        verifyUpdatedDataIntegrity();
    }

    @Then("the data should reflect changes in the database")
    public void theDataShouldReflectChangesInTheDatabase() {
        verifyDataReflectsChanges();
    }

    @Given("the API endpoint for data deletion is available")
    public void theAPIEndpointForDataDeletionIsAvailable() {
        verifyDataDeletionEndpoint();
    }

    @When("I perform a data deletion operation")
    public void iPerformADataDeletionOperation() {
        performDataDeletion();
    }

    @Then("the data should be deleted successfully from the database")
    public void theDataShouldBeDeletedSuccessfullyFromTheDatabase() {
        verifyDataDeletionSuccess();
    }

    @Given("data has been deleted from the database")
    public void dataHasBeenDeletedFromTheDatabase() {
        verifyDataDeleted();
    }

    @When("I verify the deleted data")
    public void iVerifyTheDeletedData() {
        verifyDeletedDataIntegrity();
    }

    @Then("the data should no longer exist in the database")
    public void theDataShouldNoLongerExistInTheDatabase() {
        verifyDataNoLongerExists();
    }

    @Given("the API endpoints require authentication")
    public void theAPIEndpointsRequireAuthentication() {
        verifyAPIAuthenticationRequirement();
    }

    @When("I attempt to access the API endpoints")
    public void iAttemptToAccessTheAPIEndpoints() {
        attemptAPIEndpointAccess();
    }

    @Then("only authenticated users should be able to access them")
    public void onlyAuthenticatedUsersShouldBeAbleToAccessThem() {
        verifyAuthenticatedAccess();
    }

    @Given("the API endpoints are accessible")
    public void theAPIEndpointsAreAccessible() {
        verifyAPIEndpointsAccessibility();
    }

    @When("I send invalid API requests")
    public void iSendInvalidAPIRequests() {
        sendInvalidAPIRequests();
    }

    @Then("appropriate error messages should be returned")
    public void appropriateErrorMessagesShouldBeReturned() {
        verifyErrorMessagesReturned();
    }

    @Given("the server is running")
    public void theServerIsRunning() {
        verifyServerRunning();
    }

    @When("I perform data operations")
    public void iPerformDataOperations() {
        performDataOperations();
    }

    @Then("the server performance should remain stable")
    public void theServerPerformanceShouldRemainStable() {
        verifyServerPerformanceStability();
    }

    @Given("I am testing the backend operations")
    public void iAmTestingTheBackendOperations() {
        verifyBackendOperationsTesting();
    }

    @When("I encounter any issues")
    public void iEncounterAnyIssues() {
        encounterIssues();
    }

    @Then("I should document them clearly for further analysis and report to the development team")
    public void iShouldDocumentThemClearlyForFurtherAnalysisAndReportToTheDevelopmentTeam() {
        documentAndReportIssues();
    }
}