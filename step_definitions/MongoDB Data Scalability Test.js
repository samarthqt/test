import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import MongoDBPage from '../pageObjects/MongoDBPage';

const mongoDBPage = new MongoDBPage();

Given('MongoDB server is installed and running', () => {
  // Assume MongoDB server is already installed and running
});

Given('MongoDB client or application interface is accessible', () => {
  // Assume MongoDB client or application interface is accessible
});

Given('a large dataset file is available', () => {
  // Assume a large dataset file is available
});

When('I open the MongoDB client or application interface', () => {
  mongoDBPage.openClientInterface();
});

Then('the MongoDB client or application interface is opened successfully', () => {
  mongoDBPage.verifyClientInterfaceOpened();
});

When('I connect to the MongoDB server using the appropriate connection string', () => {
  mongoDBPage.connectToServer();
});

Then('the connection to the MongoDB server is established successfully', () => {
  mongoDBPage.verifyConnectionEstablished();
});

When('I create a new database named {string}', (dbName) => {
  mongoDBPage.createDatabase(dbName);
});

Then('the database {string} is created successfully', (dbName) => {
  mongoDBPage.verifyDatabaseCreated(dbName);
});

When('I create a collection named {string} within {string}', (collectionName, dbName) => {
  mongoDBPage.createCollection(dbName, collectionName);
});

Then('the collection {string} is created successfully within {string}', (collectionName, dbName) => {
  mongoDBPage.verifyCollectionCreated(dbName, collectionName);
});

When('I prepare the large dataset file for insertion into {string}', (collectionName) => {
  mongoDBPage.prepareDatasetForInsertion(collectionName);
});

Then('the large dataset file is prepared and ready for insertion', () => {
  mongoDBPage.verifyDatasetPrepared();
});

When('I insert the large dataset into {string}', (collectionName) => {
  mongoDBPage.insertDataset(collectionName);
});

Then('the dataset is inserted successfully into {string}', (collectionName) => {
  mongoDBPage.verifyDatasetInserted(collectionName);
});

When('I monitor the performance metrics during the data insertion process', () => {
  mongoDBPage.monitorPerformanceMetrics();
});

Then('the performance metrics are within acceptable limits', () => {
  mongoDBPage.verifyPerformanceMetrics();
});

When('I query {string} to retrieve a subset of the inserted data', (collectionName) => {
  mongoDBPage.queryCollection(collectionName);
});

Then('the subset of data is retrieved successfully and promptly', () => {
  mongoDBPage.verifyDataRetrieved();
});

When('I perform a bulk update on a specific field in the dataset within {string}', (collectionName) => {
  mongoDBPage.bulkUpdate(collectionName);
});

Then('the bulk update is completed successfully without significant performance degradation', () => {
  mongoDBPage.verifyBulkUpdate();
});

When('I delete a subset of the dataset from {string}', (collectionName) => {
  mongoDBPage.deleteSubset(collectionName);
});

Then('the subset of data is deleted successfully from {string}', (collectionName) => {
  mongoDBPage.verifyDataDeleted(collectionName);
});

When('I verify the remaining data in {string} after deletion', (collectionName) => {
  mongoDBPage.verifyRemainingData(collectionName);
});

Then('the remaining data in {string} is accurate and consistent', (collectionName) => {
  mongoDBPage.verifyDataConsistency(collectionName);
});

When('I close the connection to the MongoDB server', () => {
  mongoDBPage.closeConnection();
});

Then('the connection to the MongoDB server is closed successfully', () => {
  mongoDBPage.verifyConnectionClosed();
});