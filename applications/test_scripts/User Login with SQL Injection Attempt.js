describe('TC-494 377 User Login with SQL Injection Attempt', () => {
  it('should not allow login with SQL injection', () => {
    const loginPage = new LoginPage();
    loginPage.navigateToLoginPage();
    loginPage.enterUsername("' OR '1'='1");
    loginPage.enterPassword("' OR '1'='1");
    loginPage.clickLoginButton();
    loginPage.verifyErrorMessage();
  });
});