class ApiEndpointPage {
  navigateToProjectDirectory() {
    return cy.exec('cd /path/to/project-directory');
  }

  initializeNodeProject() {
    return cy.exec('npm init -y');
  }

  installExpress() {
    return cy.exec('npm install express');
  }

  createServerFile() {
    return cy.writeFile('server.js', '');
  }

  importExpressModule() {
    return cy.writeFile('server.js', 'const express = require("express");');
  }

  setupExpressServer() {
    return cy.writeFile('server.js', 'const express = require("express");\nconst app = express();\napp.listen(3000);', { flag: 'a+' });
  }

  defineGetEndpoint() {
    return cy.writeFile('server.js', 'app.get("/api/v1/users", (req, res) => res.json({ message: "Hello World" }));', { flag: 'a+' });
  }

  startServer() {
    return cy.exec('node server.js');
  }

  visitApiEndpoint() {
    return cy.visit('http://localhost:3000/api/v1/users');
  }

  checkResponseStatusCode() {
    return cy.request('http://localhost:3000/api/v1/users').its('status');
  }

  validateJsonResponse() {
    return cy.request('http://localhost:3000/api/v1/users').its('body');
  }
}

module.exports = new ApiEndpointPage();