describe('Subscription Notifications Edge Case', () => {
  before(() => {
    // Setup: Ensure user has an active subscription
    cy.login();
    cy.visit('/subscription');
    cy.get('.active-subscription').should('exist');
  });

  it('should send notifications for multiple subscription changes without delay or error', () => {
    const subscriptionPage = new SubscriptionPage();

    // Change 1: Upgrade to Premium High
    subscriptionPage.upgradeToPremiumHigh();
    cy.get('.notification').should('contain', 'Subscription upgraded to Premium High');

    // Change 2: Cancel Subscription
    subscriptionPage.cancelSubscription();
    cy.get('.notification').should('contain', 'Subscription cancelled');
  });

  after(() => {
    // Teardown: Reset subscription to original state if needed
    cy.resetSubscription();
  });
});