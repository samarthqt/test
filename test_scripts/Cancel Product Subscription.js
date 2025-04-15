describe('Cancel Product Subscription', () => {
  const subscriptionPage = new SubscriptionPage();

  beforeEach(() => {
    cy.login();
    subscriptionPage.navigateToSubscriptions();
  });

  it('should cancel a product subscription', () => {
    subscriptionPage.findSubscription('Monthly Coffee Subscription');
    subscriptionPage.cancelSubscription();
    subscriptionPage.confirmCancellation();
    subscriptionPage.verifySubscriptionRemoved('Monthly Coffee Subscription');
  });
});