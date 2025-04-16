describe('MFA with Invalid SMS Code', () => {
  const loginPage = new LoginPage();
  const mfaPage = new MfaPage();

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should handle incorrect SMS code entry gracefully', () => {
    loginPage.enterUsername('testuser');
    loginPage.enterPassword('password123');
    loginPage.submit();

    mfaPage.selectSmsMethod();
    mfaPage.enterSmsCode('000000');
    mfaPage.submit();

    mfaPage.getErrorMessage().should('contain', 'The code is incorrect');
  });
});