import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import ProjectPage from '../page_objects/ProjectPage';

const projectPage = new ProjectPage();

Given('Node.js and npm are installed on the system', () => {
  cy.exec('node -v').its('code').should('eq', 0);
  cy.exec('npm -v').its('code').should('eq', 0);
});

Given('the project repository is cloned and available locally', () => {
  cy.exec('git clone <repository-url> /path/to/project');
});

When('I open the terminal and navigate to the project directory using {string}', (command) => {
  cy.exec(command);
});

Then('the terminal should be open in the specified project directory', () => {
  cy.exec('pwd').its('stdout').should('contain', '/path/to/project');
});

Given('I open {string} using a text editor', (file) => {
  cy.readFile(`/path/to/project/${file}`).should('exist');
});

When('I locate the endpoint that will handle data processing', () => {
  projectPage.locateDataProcessingEndpoint();
});

Then('the correct endpoint for data processing should be located in {string}', (file) => {
  projectPage.verifyDataProcessingEndpoint(file);
});

Given('the necessary dependencies are installed using {string}', (command) => {
  cy.exec(command);
});

When('I implement logic in the endpoint to process incoming data', () => {
  projectPage.implementDataProcessingLogic();
});

Then('data processing logic should be implemented successfully in the endpoint', () => {
  projectPage.verifyDataProcessingImplementation();
});

When('I add validation checks for incoming data', () => {
  projectPage.addValidationChecks();
});

Then('validation checks should validate incoming data correctly', () => {
  projectPage.verifyValidationChecks();
});

When('I modify the endpoint to return processed data with an additional field {string} set to {string}', (field, value) => {
  projectPage.modifyEndpointToReturnProcessedData(field, value);
});

Then('the endpoint should return processed data as per the defined logic', () => {
  projectPage.verifyProcessedDataReturn();
});

When('I start the server using the command {string}', (command) => {
  cy.exec(command);
});

Then('the server should start successfully without any errors', () => {
  cy.wait(5000); // wait for server to start
  cy.request('http://localhost:3000').its('status').should('eq', 200);
});

Given('I use a REST client like Postman', () => {
  cy.log('Using REST client');
});

When('I send a POST request with sample data to the endpoint URL {string}', (url) => {
  cy.request('POST', url, { sample: 'data' }).as('postRequest');
});

Then('the POST request should be successfully sent to the endpoint', () => {
  cy.get('@postRequest').its('status').should('eq', 200);
});

When('I check the response for processed data', () => {
  cy.get('@postRequest').its('body').should('have.property', 'status', 'processed');
});

Then('the {string} field should be set to {string}', (field, value) => {
  cy.get('@postRequest').its('body').should('have.property', field, value);
});

When('I verify the response status code', () => {
  cy.get('@postRequest').its('status').should('eq', 200);
});

Then('the response status code should be 200 OK', () => {
  cy.get('@postRequest').its('status').should('eq', 200);
});

When('I validate the JSON structure of the processed response against the expected format', () => {
  projectPage.validateJSONStructure();
});

Then('the JSON structure should match the expected processed format', () => {
  projectPage.verifyJSONStructure();
});

When('I check server logs for any errors related to data processing', () => {
  projectPage.checkServerLogs();
});

Then('server logs should not contain any errors related to data processing', () => {
  projectPage.verifyServerLogs();
});

When('I test the endpoint with invalid data (e.g., missing {string} field)', (field) => {
  projectPage.testEndpointWithInvalidData(field);
});

Then('the endpoint should return appropriate error messages for invalid data', () => {
  projectPage.verifyErrorMessageForInvalidData();
});

When('I send concurrent requests to the server', () => {
  projectPage.sendConcurrentRequests();
});

Then('the server should handle multiple requests efficiently without errors', () => {
  projectPage.verifyMultipleRequestHandling();
});

When('I document the data processing logic and response details in the project documentation', () => {
  projectPage.documentDataProcessingLogic();
});

Then('data processing logic and response details should be documented for future reference', () => {
  projectPage.verifyDocumentation();
});

When('I review and refactor code for optimization', () => {
  projectPage.reviewAndRefactorCode();
});

Then('the code should be optimized and refactored as necessary for better performance', () => {
  projectPage.verifyCodeOptimization();
});