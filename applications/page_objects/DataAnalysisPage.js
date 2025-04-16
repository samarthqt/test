class DataAnalysisPage {
  login(username, password) {
    cy.get('#username').type(username);
    cy.get('#password').type(password);
    cy.get('#loginButton').click();
  }

  goToStatisticalTools() {
    cy.get('#statisticalToolsLink').click();
  }

  selectHypothesisTesting() {
    cy.get('#hypothesisTestingOption').click();
  }

  inputHypothesisTestingParameters(dataSet) {
    cy.get('#hypothesisParameters').type(dataSet);
  }

  runAnalysis() {
    cy.get('#runAnalysisButton').click();
  }

  selectSampleSizeCalculation() {
    cy.get('#sampleSizeCalculationOption').click();
  }

  inputSampleSizeCalculationParameters(dataSet) {
    cy.get('#sampleSizeParameters').type(dataSet);
  }

  calculateSampleSize() {
    cy.get('#calculateButton').click();
  }

  verifyAnalysisResults() {
    cy.get('#verifyResultsButton').click();
  }

  inputInvalidData() {
    cy.get('#invalidDataInput').type('Invalid Data');
  }

  verifyDataSecurity() {
    cy.get('#dataSecurityCheck').click();
  }

  logout() {
    cy.get('#logoutButton').click();
  }

  reviewAuditTrail() {
    cy.get('#auditTrailLink').click();
  }

  exportResults() {
    cy.get('#exportResultsButton').click();
  }

  verifyCompliance() {
    cy.get('#complianceCheck').click();
  }
}