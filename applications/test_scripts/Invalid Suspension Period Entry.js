describe('Invalid Suspension Period Entry', () => {
  const adminPage = new AdminPage();

  before(() => {
    cy.visit('/login');
    adminPage.login('admin', 'password');
  });

  it('should handle invalid suspension period gracefully', () => {
    adminPage.navigateToUserAccount('U12345');
    adminPage.selectSuspendAccount();
    adminPage.enterSuspensionPeriod('-5');
    adminPage.confirmSuspension();
    adminPage.verifyErrorMessage('Invalid suspension period');
    adminPage.verifySuspensionNotExecuted();
  });
});