describe('Subscription Edge Case for Large Payment Amounts', () => {
  before(() => {
    cy.login('67890'); // Assuming a custom command for login
  });

  it('should handle large payment amounts for subscriptions', () => {
    const subscriptionPage = new SubscriptionPage();
    const userAccountPage = new UserAccountPage();

    subscriptionPage.navigateToSubscriptionPage();
    subscriptionPage.selectPremiumPlan('111');
    subscriptionPage.enterPaymentDetails('10000');
    subscriptionPage.confirmSubscription();

    userAccountPage.verifySubscriptionStatus('active');
    cy.checkSystemLogsForPayment('10000'); // Assuming a custom command for log verification
  });
});