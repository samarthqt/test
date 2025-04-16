describe('MFA with SMS', () => {
  const loginPage = new LoginPage();
  const mfaPage = new MFAPage();

  it('should allow user to login and complete MFA using SMS', () => {
    // Step 1: Navigate to the login page
    loginPage.visit();

    // Step 2: Enter username and password
    loginPage.enterUsername('testuser');
    loginPage.enterPassword('password123');
    loginPage.submit();

    // Step 3: Select SMS as the MFA method
    mfaPage.selectSMS();

    // Step 4: Enter the received verification code
    cy.task('getSMSCode', '+1234567890').then((code) => {
      mfaPage.enterVerificationCode(code);
      mfaPage.submit();
    });

    // Assertion: Verify access to the user dashboard
    cy.url().should('include', '/dashboard');
  });
});