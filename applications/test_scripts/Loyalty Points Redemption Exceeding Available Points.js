describe('Loyalty Points Redemption Exceeding Available Points', () => {
  it('should display an error when trying to redeem more points than available', () => {
    const loginPage = new LoginPage();
    const dashboardPage = new DashboardPage();
    const loyaltyProgramPage = new LoyaltyProgramPage();

    // Step 1: Log in to the user account using valid credentials
    loginPage.visit();
    loginPage.enterUserId('65432');
    loginPage.enterPassword('password'); // Assume a valid password
    loginPage.submit();

    // Verify successful login
    dashboardPage.verifySuccessfulLogin();

    // Step 2: Navigate to the 'Loyalty Program' section
    dashboardPage.goToLoyaltyProgram();

    // Verify loyalty points balance
    loyaltyProgramPage.verifyPointsBalance(50);

    // Step 3: Attempt to redeem more points than available
    loyaltyProgramPage.redeemPoints(100);

    // Verify error message
    loyaltyProgramPage.verifyErrorMessage('Insufficient points for redemption');
  });
});