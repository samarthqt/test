describe('Account Reinstatement Request', () => {
  beforeEach(() => {
    cy.visit('/account-management');
  });

  it('should allow users to request reinstatement of a closed account', () => {
    const accountManagementPage = new AccountManagementPage();
    accountManagementPage.selectRequestReinstatement();
    accountManagementPage.enterReinstatementReason('Account Closure Error');
    accountManagementPage.submitReinstatementRequest();
    accountManagementPage.verifyConfirmationMessage();
  });
});