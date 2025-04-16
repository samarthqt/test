describe('User Authentication with Invalid Email', () => {
  const loginPage = new LoginPage();
  it('should prevent login with an incorrect email', () => {
    loginPage.navigate();
    loginPage.enterEmail('invaliduser@example.com');
    loginPage.enterPassword('ValidPassword123');
    loginPage.clickLogin();
    loginPage.verifyErrorMessage('Incorrect email or password');
  });
});