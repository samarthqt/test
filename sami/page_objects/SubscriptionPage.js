class SubscriptionPage {
  visit() {
    cy.visit('/subscription-page');
  }

  selectProductForSubscription() {
    cy.get('.product-select').click();
  }

  chooseSubscriptionFrequency() {
    cy.get('.frequency-select').select('Monthly');
  }

  providePaymentDetails() {
    cy.get('#payment-details').type('Valid Payment Details');
  }

  confirmSubscription() {
    cy.get('#confirm-subscription').click();
  }

  receiveConfirmationEmail() {
    cy.get('#confirmation-email').should('contain', 'Subscription Confirmed');
  }

  modifySubscription() {
    cy.get('#modify-subscription').click();
  }

  changeSubscriptionDetails() {
    cy.get('.subscription-details').clear().type('New Details');
  }

  updateSubscriptionDetails() {
    cy.get('#update-subscription').click();
  }

  receiveUpdateConfirmationEmail() {
    cy.get('#update-confirmation-email').should('contain', 'Subscription Updated');
  }

  cancelSubscription() {
    cy.get('#cancel-subscription').click();
  }

  confirmCancellation() {
    cy.get('#confirmation-cancellation').should('contain', 'Subscription Cancelled');
  }

  receiveCancellationConfirmationEmail() {
    cy.get('#cancellation-email').should('contain', 'Cancellation Confirmed');
  }

  viewSubscriptionDetails() {
    cy.get('#subscription-details').should('contain', 'Subscription Details');
  }

  enterInvalidPaymentDetails() {
    cy.get('#payment-details').type('Invalid Payment Details');
  }

  displayErrorMessage() {
    cy.get('#error-message').should('contain', 'Error Processing Subscription');
  }

  ensureSubscriptionNotProcessed() {
    cy.get('#subscription-status').should('not.contain', 'Subscription Processed');
  }
}

export default SubscriptionPage;