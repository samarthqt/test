describe('Balance Inquiry Edge Case Test', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const accountManagementPage = new AccountManagementPage();
  const balanceInquiryPage = new BalanceInquiryPage();

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should log in and verify zero balance without errors', () => {
    // Step 1: Log into the account management system using valid credentials
    loginPage.login('67890', 'password');
    dashboardPage.verifyDashboardIsDisplayed();

    // Step 2: Navigate to the 'Account Management' section
    dashboardPage.navigateToAccountManagement();
    accountManagementPage.verifyAccountManagementSectionIsDisplayed();

    // Step 3: Select the 'Balance Inquiry' option
    accountManagementPage.selectBalanceInquiry();
    balanceInquiryPage.verifyBalanceInquiryPageIsDisplayed();

    // Step 4: Check the current balance displayed on the screen
    balanceInquiryPage.verifyBalanceIsZero();

    // Step 5: Verify that no error messages are shown for zero balance
    balanceInquiryPage.verifyNoErrorMessages();
  });
});