describe('2FA SMS Code Verification', () => {
  it('should display an error message for incorrect SMS code', () => {
    const loginPage = new LoginPage();
    const twoFaPage = new TwoFaPage();

    loginPage.visit();
    loginPage.enterCredentials('testuser', 'password123');
    loginPage.submit();

    twoFaPage.enterSmsCode('654321');
    twoFaPage.submit();

    twoFaPage.verifyErrorMessage('The SMS code is incorrect.');
  });
});