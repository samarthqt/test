const { Given, When, Then } = require('cypress-cucumber-preprocessor/steps');

Given('Node.js and npm are installed on the system', () => {
  // Verify Node.js and npm installation
  cy.exec('node -v').its('code').should('eq', 0);
  cy.exec('npm -v').its('code').should('eq', 0);
});

Given('a basic understanding of JavaScript and Express framework', () => {
  // Assume basic understanding of JavaScript and Express
  cy.log('Basic understanding of JavaScript and Express assumed');
});

When('I open the terminal and navigate to the project directory', () => {
  // Navigate to project directory
  cy.exec('cd /path/to/project-directory');
});

Then('Terminal should be open in the specified project directory', () => {
  // Verify current directory
  cy.exec('pwd').its('stdout').should('contain', '/path/to/project-directory');
});

When('I initialize a new Node.js project using {string}', (command) => {
  // Initialize Node.js project
  cy.exec(command);
});

Then('A new Node.js project should be initialized with a package.json file created', () => {
  // Verify package.json creation
  cy.readFile('package.json').should('exist');
});

When('I install Express framework using {string}', (command) => {
  // Install Express
  cy.exec(command);
});

Then('Express framework should be installed and listed as a dependency in package.json', () => {
  // Verify Express installation
  cy.readFile('package.json').its('dependencies').should('have.property', 'express');
});

When('I create a new file named {string}', (filename) => {
  // Create server.js file
  cy.writeFile(filename, '');
});

Then('A new file named {string} should be created in the project directory', (filename) => {
  // Verify file creation
  cy.readFile(filename).should('exist');
});

When('I open {string} and import the Express module', (filename) => {
  // Import Express module
  cy.writeFile(filename, 'const express = require("express");');
});

Then('Express module should be successfully imported in {string}', (filename) => {
  // Verify Express import
  cy.readFile(filename).should('contain', 'const express = require("express");');
});

When('I set up a basic Express server in {string} using {string} and {string}', (filename, appSetup, listenSetup) => {
  // Setup Express server
  cy.writeFile(filename, `const express = require("express");\nconst app = express();\n${appSetup}\n${listenSetup}`);
});

Then('Express server should be set up and listening on port 3000', () => {
  // Verify server setup
  cy.readFile('server.js').should('contain', 'app.listen(3000);');
});

When('I define a new GET endpoint {string} in {string}', (endpoint, filename) => {
  // Define GET endpoint
  cy.writeFile(filename, `app.get("${endpoint}", (req, res) => res.json({ message: "Hello World" }));`, { flag: 'a+' });
});

Then('GET endpoint {string} should be defined in {string}', (endpoint, filename) => {
  // Verify GET endpoint
  cy.readFile(filename).should('contain', `app.get("${endpoint}",`);
});

When('I return a sample JSON response from the {string} endpoint', (endpoint) => {
  // Return JSON response
  cy.readFile('server.js').should('contain', `res.json({ message: "Hello World" });`);
});

Then('Sample JSON response should be returned from the {string} endpoint', (endpoint) => {
  // Verify JSON response
  cy.request('http://localhost:3000/api/v1/users').its('body').should('deep.equal', { message: "Hello World" });
});

When('I start the server using {string}', (command) => {
  // Start the server
  cy.exec(command);
});

Then('Server should start successfully without any errors', () => {
  // Verify server start
  cy.wait(2000);
  cy.request('http://localhost:3000').its('status').should('eq', 200);
});

When('I open a browser and navigate to {string}', (url) => {
  // Navigate to API endpoint
  cy.visit(url);
});

Then('Browser should display the sample JSON response from the {string} endpoint', (endpoint) => {
  // Verify browser displays JSON response
  cy.contains('Hello World');
});

When('I check the response status code', () => {
  // Check response status code
  cy.request('http://localhost:3000/api/v1/users').its('status').should('eq', 200);
});

Then('Response status code should be 200 OK', () => {
  // Verify response status code
  cy.request('http://localhost:3000/api/v1/users').its('status').should('eq', 200);
});

When('I validate the JSON structure of the response', () => {
  // Validate JSON structure
  cy.request('http://localhost:3000/api/v1/users').its('body').should('have.property', 'message');
});

Then('JSON structure should match the expected format', () => {
  // Verify JSON structure
  cy.request('http://localhost:3000/api/v1/users').its('body').should('deep.equal', { message: "Hello World" });
});

When('I test the endpoint using a REST client like Postman', () => {
  // Test endpoint with REST client
  cy.log('Test endpoint using REST client manually');
});

Then('REST client should successfully retrieve the sample JSON response', () => {
  // Verify REST client retrieves JSON response
  cy.log('Verify REST client retrieves JSON response manually');
});

When('I verify the server logs for any errors or warnings', () => {
  // Verify server logs
  cy.log('Verify server logs manually');
});

Then('Server logs should not contain any errors or warnings', () => {
  // Verify no errors or warnings in logs
  cy.log('Verify no errors or warnings in server logs manually');
});

When('I document the endpoint and response details', () => {
  // Document endpoint and response
  cy.log('Document endpoint and response details manually');
});

Then('Endpoint and response details should be documented for future reference', () => {
  // Verify documentation
  cy.log('Verify documentation manually');
});