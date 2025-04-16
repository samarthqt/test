describe('Advanced Encryption - Encrypt Sensitive Data', () => {
  const sensitiveDataPage = new SensitiveDataPage();

  beforeEach(() => {
    cy.visit('/login');
    cy.login('sensitive_user', 'sensitive_pass');
  });

  it('should store data in an encrypted format', () => {
    sensitiveDataPage.accessDatabase();
    sensitiveDataPage.verifyDataIsEncrypted();
  });

  it('should deny unauthorized decryption access', () => {
    sensitiveDataPage.attemptUnauthorizedDecryption();
    sensitiveDataPage.verifyDecryptionFails();
  });

  it('should encrypt data packets during login session', () => {
    sensitiveDataPage.captureDataPackets();
    sensitiveDataPage.verifyDataPacketsAreEncrypted();
  });

  it('should manage encryption keys securely', () => {
    sensitiveDataPage.verifyEncryptionKeyManagement();
  });
});