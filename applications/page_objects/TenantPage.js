class TenantPage {
  login(username, password) {
    cy.get('#username').type(username);
    cy.get('#password').type(password);
    cy.get('#loginButton').click();
  }

  updateAccountDetails() {
    cy.get('#accountSettings').click();
    cy.get('#updateDetailsButton').click();
  }
}

class PaymentPage {
  navigateToRentPaymentSection() {
    cy.get('#rentPaymentSection').click();
  }

  verifyRentPaymentSectionDisplayed() {
    cy.get('#paymentOptions').should('be.visible');
  }

  selectRecurringPaymentsOption() {
    cy.get('#recurringPaymentOption').click();
  }

  enterPaymentMethodDetails(method) {
    cy.get('#paymentMethod').type(method);
    cy.get('#validateButton').click();
  }

  scheduleRecurringPayment(amount, dueDate) {
    cy.get('#rentAmount').type(amount);
    cy.get('#dueDate').type(dueDate);
    cy.get('#scheduleButton').click();
  }

  confirmRecurringPaymentSetup() {
    cy.get('#confirmSetupButton').click();
  }

  verifyRecurringPaymentProcessed(dueDate) {
    cy.get(`#paymentHistory .dueDate-${dueDate}`).should('contain', 'Processed');
  }

  verifyPaymentConfirmationNotification() {
    cy.get('#notification').should('contain', 'Payment Successful');
  }

  attemptSetupWithInvalidPaymentMethod() {
    cy.get('#paymentMethod').type('invalidMethod');
    cy.get('#validateButton').click();
  }

  verifyErrorMessageDisplayed() {
    cy.get('#errorMessage').should('be.visible');
  }

  modifyOrCancelRecurringPayments() {
    cy.get('#modifyPayment').click();
    cy.get('#cancelPayment').click();
  }

  simulatePaymentFailure() {
    cy.get('#simulateFailure').click();
  }

  verifyRetryMechanism() {
    cy.get('#retryStatus').should('contain', 'Retrying');
  }

  viewPaymentHistory() {
    cy.get('#viewHistory').click();
  }

  verifyPaymentHistoryDisplayed() {
    cy.get('#paymentHistory').should('be.visible');
  }

  verifyRecurringPaymentsPersist() {
    cy.get('#recurringPaymentStatus').should('contain', 'Active');
  }

  attemptSetupWithInsufficientFunds() {
    cy.get('#paymentMethod').type('insufficientFunds');
    cy.get('#validateButton').click();
  }

  verifyRecurringPaymentsSynchronized() {
    cy.get('#syncStatus').should('contain', 'Synchronized');
  }
}