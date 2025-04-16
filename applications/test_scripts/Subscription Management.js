describe('Subscription Management', () => {
  const subscriptionPage = new SubscriptionPage();

  beforeEach(() => {
    cy.visit('/subscription-management');
  });

  it('should display current subscription details', () => {
    subscriptionPage.getCurrentPlan().should('contain', 'Basic');
  });

  it('should upgrade subscription to Premium', () => {
    subscriptionPage.selectUpgradePlan('Premium');
    subscriptionPage.confirmUpgrade();
    subscriptionPage.getNotification().should('contain', 'Subscription upgraded to Premium');
  });

  it('should cancel subscription', () => {
    subscriptionPage.navigateBackToManagement();
    subscriptionPage.selectCancelSubscription();
    subscriptionPage.enterCancellationReason('No longer needed');
    subscriptionPage.confirmCancellation();
    subscriptionPage.getNotification().should('contain', 'Subscription canceled');
  });

  it('should verify receipt of notifications', () => {
    subscriptionPage.getNotifications().should('contain', 'Subscription upgraded to Premium');
    subscriptionPage.getNotifications().should('contain', 'Subscription canceled');
  });
});