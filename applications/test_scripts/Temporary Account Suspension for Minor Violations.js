describe('Temporary Account Suspension for Minor Violations', () => {
  const adminPage = new AdminPage();
  before(() => {
    cy.visit('/login');
    adminPage.login('admin', 'password');
  });

  it('should suspend account temporarily for minor violations', () => {
    adminPage.navigateToUserAccount('U12345');
    adminPage.suspendAccount('U12345', '7 days');
    adminPage.verifySuspensionNotification('U12345');
  });
});