describe('Two-Factor Authentication on Login', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();

  it('should correctly implement two-factor authentication during login', () => {
    // Step 1: Navigate to the login page
    loginPage.visit();

    // Step 2: Enter User ID and Password
    loginPage.enterUserId('12345');
    loginPage.enterPassword('Password123');

    // Step 3: Click on 'Login' button
    loginPage.clickLoginButton();

    // Step 4: Enter the authentication code
    loginPage.enterAuthCode('678910');

    // Step 5: Verify that the user is redirected to the dashboard
    dashboardPage.verifyDashboardIsDisplayed();
  });
});