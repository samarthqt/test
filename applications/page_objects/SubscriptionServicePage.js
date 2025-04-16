class SubscriptionServicePage {
  visit() {
    cy.visit('/subscription');
  }

  verifyPageLoaded() {
    cy.contains('Available Plans').should('be.visible');
  }

  selectPlan(serviceId) {
    cy.get(`#plan-${serviceId}`).click();
  }

  verifyPlanSelected(serviceId) {
    cy.get(`#plan-${serviceId}`).should('have.class', 'selected');
  }

  enterPaymentDetails(paymentMethod) {
    cy.get('#payment-method').type(paymentMethod);
  }

  verifyPaymentRejected() {
    cy.contains('Payment details are rejected').should('be.visible');
  }

  confirmSubscription() {
    cy.get('#confirm-subscription').click();
  }

  verifySubscriptionFailure() {
    cy.contains('Subscription fails with error message').should('be.visible');
  }
}

class UserAccountPage {
  visit() {
    cy.visit('/user-account');
  }

  verifySubscriptionStatusInactive() {
    cy.contains('Subscription status: Inactive').should('be.visible');
  }
}