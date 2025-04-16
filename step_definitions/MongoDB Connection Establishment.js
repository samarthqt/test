import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import MongoDBPage from '../page_objects/MongoDBPage';

const mongoDBPage = new MongoDBPage();

Given('the MongoDB server is running and accessible', () => {
  // Code to ensure MongoDB server is running
});

Given('the MongoDB client or application is installed', () => {
  // Code to ensure MongoDB client is installed
});

When('I open the MongoDB client or application interface', () => {
  mongoDBPage.openClientInterface();
});

Then('the MongoDB client or application interface should open successfully', () => {
  mongoDBPage.verifyClientInterfaceOpen();
});

When('I enter the MongoDB connection string {string} in the connection setup field', (connectionString) => {
  mongoDBPage.enterConnectionString(connectionString);
});

Then('the connection string should be entered without errors', () => {
  mongoDBPage.verifyConnectionStringEntered();
});

When('I click on the {string} button to establish a connection to the MongoDB server', (button) => {
  mongoDBPage.clickConnectButton(button);
});

Then('the connection to the MongoDB server should be established successfully', () => {
  mongoDBPage.verifyConnectionEstablished();
});

When('I verify the database {string} is accessible', (database) => {
  mongoDBPage.verifyDatabaseAccessible(database);
});

Then('the database {string} should be accessible and listed in the database explorer', (database) => {
  mongoDBPage.verifyDatabaseListed(database);
});

When('I check for the collection {string} within the {string} database', (collection, database) => {
  mongoDBPage.checkCollectionInDatabase(collection, database);
});

Then('the collection {string} should be present within the {string} database', (collection, database) => {
  mongoDBPage.verifyCollectionPresent(collection, database);
});

When('I attempt to insert a sample document into the {string}', (collection) => {
  mongoDBPage.insertSampleDocument(collection);
});

Then('the sample document should be inserted successfully into the {string}', (collection) => {
  mongoDBPage.verifyDocumentInserted(collection);
});

When('I query the {string} to retrieve the inserted document', (collection) => {
  mongoDBPage.queryCollection(collection);
});

Then('the inserted document should be retrieved successfully from the {string}', (collection) => {
  mongoDBPage.verifyDocumentRetrieved(collection);
});

When('I update a field in the inserted document in the {string}', (collection) => {
  mongoDBPage.updateDocumentField(collection);
});

Then('the field in the inserted document should be updated successfully', () => {
  mongoDBPage.verifyDocumentFieldUpdated();
});

When('I delete the inserted document from the {string}', (collection) => {
  mongoDBPage.deleteDocument(collection);
});

Then('the inserted document should be deleted successfully from the {string}', (collection) => {
  mongoDBPage.verifyDocumentDeleted(collection);
});

When('I close the connection to the MongoDB server', () => {
  mongoDBPage.closeConnection();
});

Then('the connection to the MongoDB server should be closed successfully', () => {
  mongoDBPage.verifyConnectionClosed();
});

When('I re-open the MongoDB client or application', () => {
  mongoDBPage.reopenClient();
});

And('I verify that the connection can be re-established', () => {
  mongoDBPage.verifyReconnection();
});

Then('the MongoDB client or application should re-open and the connection should be re-established successfully', () => {
  mongoDBPage.verifyClientReopened();
});

When('I verify the {string} database is still accessible after re-establishing the connection', (database) => {
  mongoDBPage.verifyDatabaseAccessibleAfterReconnect(database);
});

Then('the {string} database should be accessible and listed as expected', (database) => {
  mongoDBPage.verifyDatabaseListedAfterReconnect(database);
});

When('I ensure that no residual data from previous operations remains in the {string}', (collection) => {
  mongoDBPage.ensureNoResidualData(collection);
});

Then('the {string} should be empty, confirming no residual data remains', (collection) => {
  mongoDBPage.verifyCollectionEmpty(collection);
});

When('I log out from the MongoDB client or application interface', () => {
  mongoDBPage.logout();
});

Then('the user should log out successfully from the MongoDB client or application interface', () => {
  mongoDBPage.verifyLogoutSuccessful();
});

When('I verify that the MongoDB client or application closes without errors', () => {
  mongoDBPage.verifyClientClosesWithoutErrors();
});

Then('the MongoDB client or application should close successfully without any errors', () => {
  mongoDBPage.verifyClientClosedSuccessfully();
});