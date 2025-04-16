describe('TC-253 197 Edge Case: Maximum Suspension Period', () => {
  const adminPage = new AdminPage();
  const userAccountPage = new UserAccountPage();

  before(() => {
    cy.visit('/login');
    adminPage.login('admin', 'password');
  });

  it('should navigate to user account section and search for User ID U12345', () => {
    adminPage.navigateToAccountManagement();
    userAccountPage.searchUser('U12345');
    userAccountPage.verifyUserDetails('U12345', 'Minor');
  });

  it('should suspend the account temporarily for 365 days', () => {
    userAccountPage.selectSuspendAccount();
    userAccountPage.enterSuspensionPeriod(365);
    userAccountPage.confirmSuspension();
    userAccountPage.verifySuspensionSuccess(365);
  });
});