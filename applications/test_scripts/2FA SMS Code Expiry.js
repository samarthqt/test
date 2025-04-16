describe('2FA SMS Code Expiry Test', () => {
  beforeEach(() => {
    cy.visit('/login');
  });

  it('should prompt user to request a new SMS code when expired code is used', () => {
    const loginPage = new LoginPage();
    loginPage.enterPhoneNumber('1234567890');
    loginPage.submitPhoneNumber();
    loginPage.enterSmsCode('123456'); // Expired SMS Code
    loginPage.submitSmsCode();

    loginPage.getErrorMessage().should('contain', 'Your code has expired. Please request a new code.');
  });
});