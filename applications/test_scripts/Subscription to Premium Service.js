describe('Subscription to Premium Service', () => {
  const subscriptionPage = new SubscriptionPage();
  const userAccountPage = new UserAccountPage();
  
  before(() => {
    cy.login('67890');
  });

  it('should navigate to the subscription service page', () => {
    subscriptionPage.visit();
    subscriptionPage.verifyPageLoaded();
  });

  it('should select a premium service plan', () => {
    subscriptionPage.selectPlan('111');
    subscriptionPage.verifyPlanSelected('111');
  });

  it('should enter payment details', () => {
    subscriptionPage.enterPaymentDetails('Credit Card');
    subscriptionPage.verifyPaymentDetailsAccepted();
  });

  it('should confirm the subscription', () => {
    subscriptionPage.confirmSubscription();
    subscriptionPage.verifySubscriptionConfirmation();
  });

  it('should verify subscription status in user account', () => {
    userAccountPage.visit();
    userAccountPage.verifySubscriptionStatus('active');
  });
});