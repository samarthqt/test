class DatabasePage {
  login(username, password) {
    cy.get('#username').type(username);
    cy.get('#password').type(password);
    cy.get('#loginButton').click();
  }

  verifyDashboard() {
    cy.url().should('include', '/dashboard');
    cy.get('#dashboard').should('be.visible');
  }

  navigateToDataUpload() {
    cy.get('#dataUploadLink').click();
  }

  verifyDataUploadSection() {
    cy.get('#dataUploadSection').should('be.visible');
  }

  selectUploadNewData(dataSet) {
    cy.get('#uploadNewData').click();
    cy.get('#dataSetSelect').select(dataSet);
  }

  applyEncryption(key) {
    cy.get('#encryptionKey').type(key);
    cy.get('#applyEncryption').click();
  }

  uploadData() {
    cy.get('#uploadButton').click();
  }

  verifyDataUpload() {
    cy.get('#uploadSuccessMessage').should('be.visible');
  }

  checkDataLogs() {
    cy.get('#dataLogs').click();
  }

  verifyDataIntegrity() {
    cy.get('#dataIntegrityStatus').should('contain', 'Intact');
  }

  checkEncryptionStatus() {
    cy.get('#encryptionStatus').should('contain', 'Encrypted');
  }

  attemptAccessWithoutDecryption() {
    cy.get('#accessDataWithoutDecryption').click();
    cy.get('#accessDeniedMessage').should('be.visible');
  }

  decryptData(key) {
    cy.get('#decryptionKey').type(key);
    cy.get('#decryptButton').click();
  }

  verifyDecryptedData() {
    cy.get('#decryptedData').should('be.visible');
  }

  verifyAuthorizedAccess() {
    cy.get('#authorizedAccess').should('be.visible');
  }

  verifyAccessDenied() {
    cy.get('#accessDeniedMessage').should('be.visible');
  }

  checkUnauthorizedAccess() {
    cy.get('#unauthorizedAccessAttempts').should('not.exist');
  }

  logout() {
    cy.get('#logoutButton').click();
  }

  verifyLogout() {
    cy.url().should('not.include', '/dashboard');
  }

  reviewAuditTrail() {
    cy.get('#auditTrail').click();
    cy.get('#auditTrailDetails').should('be.visible');
  }

  verifyCompliance() {
    cy.get('#complianceStatus').should('contain', 'Compliant');
  }
}