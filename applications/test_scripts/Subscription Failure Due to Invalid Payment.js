describe('Subscription Failure Due to Invalid Payment', () => {
  const subscriptionServicePage = new SubscriptionServicePage();
  const userAccountPage = new UserAccountPage();

  before(() => {
    cy.login('67890'); // Assuming a login command is available
  });

  it('should navigate to the subscription service page', () => {
    subscriptionServicePage.visit();
    subscriptionServicePage.verifyPageLoaded();
  });

  it('should select a premium service plan', () => {
    subscriptionServicePage.selectPlan('111');
    subscriptionServicePage.verifyPlanSelected('111');
  });

  it('should enter invalid payment details', () => {
    subscriptionServicePage.enterPaymentDetails('Invalid Credit Card');
    subscriptionServicePage.verifyPaymentRejected();
  });

  it('should attempt to confirm the subscription', () => {
    subscriptionServicePage.confirmSubscription();
    subscriptionServicePage.verifySubscriptionFailure();
  });

  it('should verify subscription status in user account', () => {
    userAccountPage.visit();
    userAccountPage.verifySubscriptionStatusInactive();
  });
});