describe('TC-198 161 Data Encryption - Negative Test', () => {
  const userId = '12345';
  const incorrectKey = 'XYZ123';

  before(() => {
    // Setup: Ensure user data exists and encryption keys are configured
    cy.setupUserData(userId);
    cy.configureEncryptionKeys();
  });

  it('should fail to decrypt with incorrect key and show error message', () => {
    cy.decryptUserData(userId, incorrectKey)
      .then(response => {
        expect(response.success).to.be.false;
        expect(response.errorMessage).to.exist;
      });
  });

  it('should log unauthorized access attempt', () => {
    cy.checkSystemLogs()
      .then(logs => {
        const logEntry = logs.find(log => log.userId === userId && log.key === incorrectKey);
        expect(logEntry).to.exist;
        expect(logEntry.status).to.equal('failed');
      });
  });

  it('should verify user account remains secure', () => {
    cy.verifyUserAccountSecurity(userId)
      .then(isSecure => {
        expect(isSecure).to.be.true;
      });
  });
});