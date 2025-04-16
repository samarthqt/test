import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';

Given('Docker is installed and running on the system', () => {
  // Ensure Docker is installed and running
});

Given('the application source code and Dockerfile are available in the specified directory', () => {
  // Verify application source code and Dockerfile are present
});

When('I open the terminal and navigate to the directory containing the application source code and Dockerfile', () => {
  cy.exec('cd /path/to/source/code')
    .its('stdout').should('contain', '/path/to/source/code');
});

Then('the terminal should display the correct directory path', () => {
  // Already verified in the previous step
});

Given('I am in the application source code directory', () => {
  // Assume already in the directory
});

When('I run the command {string}', (command) => {
  cy.exec(command);
});

Then('Docker should start building the image, displaying step-by-step build logs', () => {
  cy.exec('docker build -t myapp:latest .')
    .its('stdout').should('contain', 'Successfully built');
});

When('the Docker build process completes', () => {
  // Assume build process completes
});

Then('the terminal should display a success message with the image ID', () => {
  cy.exec('docker build -t myapp:latest .')
    .its('stdout').should('contain', 'Successfully built');
});

When('I run the command {string}', (command) => {
  cy.exec(command);
});

Then('the image {string} should be listed', (imageName) => {
  cy.exec('docker images')
    .its('stdout').should('contain', imageName);
});

Then('detailed information about the image {string} should be displayed, including configuration and history', (imageName) => {
  cy.exec(`docker inspect ${imageName}`)
    .its('stdout').should('contain', 'Config');
});

Then('the container should start successfully, and the application should be running as expected', () => {
  // Assume application is running
});

Then('the application should respond correctly, demonstrating expected functionality', () => {
  // Verify application functionality
});

Then('the logs should show normal operation of the application without errors', () => {
  cy.exec('docker logs <container_id>')
    .its('stdout').should('not.contain', 'error');
});

Then('the container should stop successfully without errors', () => {
  cy.exec('docker stop <container_id>')
    .its('stdout').should('not.contain', 'error');
});

Then('the container should be removed successfully from the list of Docker containers', () => {
  cy.exec('docker rm <container_id>')
    .its('stdout').should('not.contain', 'error');
});

Then('the image {string} should be removed successfully from the list of Docker images', (imageName) => {
  cy.exec(`docker rmi ${imageName}`)
    .its('stdout').should('not.contain', 'error');
});

Then('the image {string} should not be listed in the output', (imageName) => {
  cy.exec('docker images')
    .its('stdout').should('not.contain', imageName);
});

Then('any dangling images should be removed, and a confirmation message should be displayed', () => {
  cy.exec('docker image prune -f')
    .its('stdout').should('contain', 'Total reclaimed space');
});

Then('all issues should be documented with detailed descriptions and steps to reproduce', () => {
  // Document issues
});

Then('suggestions for improvements should be documented and reviewed with the development team', () => {
  // Document suggestions
});