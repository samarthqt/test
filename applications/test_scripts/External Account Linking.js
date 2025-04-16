describe('External Account Linking', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const accountManagementPage = new AccountManagementPage();

  beforeEach(() => {
    cy.visit('/');
  });

  it('should link an external bank account successfully', () => {
    loginPage.login('validUsername', 'validPassword');
    dashboardPage.verifyDashboard();

    dashboardPage.goToAccountManagement();
    accountManagementPage.verifyAccountManagementPage();

    accountManagementPage.selectLinkExternalAccount();
    accountManagementPage.enterExternalAccountDetails('3456789', '987654321');
    accountManagementPage.submitLinkingRequest();
    accountManagementPage.verifyAccountLinked();

    accountManagementPage.checkLinkedAccounts();
    accountManagementPage.verifyExternalAccountInList('3456789');

    accountManagementPage.initiateFundTransfer('3456789', '789012', 100);
    accountManagementPage.verifyTransferSuccess();

    accountManagementPage.verifyExternalAccountBalance('3456789', 900);
  });
});