describe('Subscription Cancellation', () => {
  const subscriptionPage = new SubscriptionPage();

  before(() => {
    cy.login('67890');
  });

  it('should navigate to subscription management page', () => {
    subscriptionPage.visit();
    subscriptionPage.verifyActiveSubscriptionsDisplayed();
  });

  it('should select the active subscription to cancel', () => {
    subscriptionPage.selectSubscription('111');
    subscriptionPage.verifySubscriptionDetailsDisplayed();
  });

  it('should confirm the cancellation', () => {
    subscriptionPage.confirmCancellation();
    subscriptionPage.verifyCancellationConfirmationDisplayed();
  });

  it('should verify subscription status in user account', () => {
    subscriptionPage.verifySubscriptionStatusCancelled();
  });

  it('should check refund policy details', () => {
    subscriptionPage.verifyRefundPolicyDisplayed();
  });
});