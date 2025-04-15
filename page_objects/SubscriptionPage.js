class SubscriptionPage {
  navigateToSubscriptions() {
    cy.visit('/user/subscriptions');
  }

  findSubscription(subscriptionName) {
    cy.contains(subscriptionName).should('be.visible');
  }

  cancelSubscription() {
    cy.contains('Cancel Subscription').click();
  }

  confirmCancellation() {
    cy.contains('Are you sure you want to cancel?').should('be.visible');
    cy.contains('Yes, Cancel').click();
    cy.contains('Subscription canceled successfully').should('be.visible');
  }

  verifySubscriptionRemoved(subscriptionName) {
    cy.contains(subscriptionName).should('not.exist');
  }
}