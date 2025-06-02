import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import BackendOperationsPage from "../pages/backendOperationsPage";

Given("the PostgreSQL database is accessible", () => {
 BackendOperationsPage.checkDatabaseAccessibility();
});

When("I set up the database with sample records", () => {
 BackendOperationsPage.setupDatabaseWithSampleRecords();
});

Then("the database should be set up correctly with sample records", () => {
 BackendOperationsPage.verifyDatabaseSetup();
});

Given("the Node.js and Express environment is configured", () => {
 BackendOperationsPage.checkNodeEnvironment();
});

When("I start the Node.js server", () => {
 BackendOperationsPage.startNodeServer();
});

Then("the server should start without errors", () => {
 BackendOperationsPage.verifyServerStart();
});

Given("the Node.js application is running", () => {
 BackendOperationsPage.checkNodeApplicationRunning();
});

When("I connect to the PostgreSQL database", () => {
 BackendOperationsPage.connectToDatabase();
});

Then("the connection should be established successfully", () => {
 BackendOperationsPage.verifyDatabaseConnection();
});

Given("the API endpoint for data retrieval is available", () => {
 BackendOperationsPage.checkDataRetrievalEndpoint();
});

When("I perform a data retrieval operation", () => {
 BackendOperationsPage.performDataRetrieval();
});

Then("the data should be retrieved successfully from the database", () => {
 BackendOperationsPage.verifyDataRetrieval();
});

Given("data has been retrieved from the database", () => {
 BackendOperationsPage.checkDataRetrieved();
});

When("I verify the retrieved data", () => {
 BackendOperationsPage.verifyRetrievedData();
});

Then("the data should match the sample records in the database", () => {
 BackendOperationsPage.verifyDataIntegrity();
});

Given("the API endpoint for data insertion is available", () => {
 BackendOperationsPage.checkDataInsertionEndpoint();
});

When("I perform a data insertion operation", () => {
 BackendOperationsPage.performDataInsertion();
});

Then("the data should be inserted successfully into the database", () => {
 BackendOperationsPage.verifyDataInsertion();
});

Given("data has been inserted into the database", () => {
 BackendOperationsPage.checkDataInserted();
});

When("I verify the inserted data", () => {
 BackendOperationsPage.verifyInsertedData();
});

Then("the data should be correctly stored in the database", () => {
 BackendOperationsPage.verifyDataStorage();
});

Given("the API endpoint for data update is available", () => {
 BackendOperationsPage.checkDataUpdateEndpoint();
});

When("I perform a data update operation", () => {
 BackendOperationsPage.performDataUpdate();
});

Then("the data should be updated successfully in the database", () => {
 BackendOperationsPage.verifyDataUpdate();
});

Given("data has been updated in the database", () => {
 BackendOperationsPage.checkDataUpdated();
});

When("I verify the updated data", () => {
 BackendOperationsPage.verifyUpdatedData();
});

Then("the data should reflect changes in the database", () => {
 BackendOperationsPage.verifyDataChanges();
});

Given("the API endpoint for data deletion is available", () => {
 BackendOperationsPage.checkDataDeletionEndpoint();
});

When("I perform a data deletion operation", () => {
 BackendOperationsPage.performDataDeletion();
});

Then("the data should be deleted successfully from the database", () => {
 BackendOperationsPage.verifyDataDeletion();
});

Given("data has been deleted from the database", () => {
 BackendOperationsPage.checkDataDeleted();
});

When("I verify the deleted data", () => {
 BackendOperationsPage.verifyDeletedData();
});

Then("the data should no longer exist in the database", () => {
 BackendOperationsPage.verifyDataNonExistence();
});

Given("the API endpoints require authentication", () => {
 BackendOperationsPage.checkApiAuthentication();
});

When("I attempt to access the API endpoints", () => {
 BackendOperationsPage.attemptApiAccess();
});

Then("only authenticated users should be able to access them", () => {
 BackendOperationsPage.verifyApiAccess();
});

Given("the API endpoints are accessible", () => {
 BackendOperationsPage.checkApiAccessibility();
});

When("I send invalid API requests", () => {
 BackendOperationsPage.sendInvalidApiRequests();
});

Then("appropriate error messages should be returned", () => {
 BackendOperationsPage.verifyErrorMessages();
});

Given("the server is running", () => {
 BackendOperationsPage.checkServerRunning();
});

When("I perform data operations", () => {
 BackendOperationsPage.performDataOperations();
});

Then("the server performance should remain stable", () => {
 BackendOperationsPage.verifyServerPerformance();
});

Given("I am testing the backend operations", () => {
 BackendOperationsPage.checkBackendTesting();
});

When("I encounter any issues", () => {
 BackendOperationsPage.encounterIssues();
});

Then("I should document them clearly for further analysis and report to the development team", () => {
 BackendOperationsPage.documentIssues();
});