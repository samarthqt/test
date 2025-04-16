class SubscriptionPage {
  navigateToSubscriptionPage() {
    cy.visit('/subscription');
    cy.contains('Subscription Service').should('be.visible');
  }

  selectPremiumPlan(serviceId) {
    cy.get(`[data-service-id="${serviceId}"]`).click();
    cy.contains('Plan Details').should('be.visible');
  }

  enterPaymentDetails(amount) {
    cy.get('#payment-amount').type(amount);
    cy.get('#payment-details-form').submit();
    cy.contains('Payment details accepted').should('be.visible');
  }

  confirmSubscription() {
    cy.get('#confirm-subscription').click();
    cy.contains('Subscription confirmed').should('be.visible');
  }
}

class UserAccountPage {
  verifySubscriptionStatus(expectedStatus) {
    cy.visit('/user-account');
    cy.get('#subscription-status').should('have.text', expectedStatus);
  }
}