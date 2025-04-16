describe('Invalid Subscription Upgrade', () => {
  const subscriptionPage = new SubscriptionPage();

  beforeEach(() => {
    cy.login(); // Assuming a custom command for login
    subscriptionPage.navigateTo();
  });

  it('should display an error message for invalid plan upgrade attempt', () => {
    subscriptionPage.selectPlan('Super Premium');
    subscriptionPage.submitUpgrade();
    subscriptionPage.getErrorMessage().should('contain', 'The plan does not exist.');
  });
});