class ParkingTicketsPage {
  navigateToTickets() {
    cy.get('.main-menu').contains('Parking Tickets').click();
  }

  selectFirstOutstandingTicket() {
    cy.get('.ticket-list .ticket-item').first().click();
  }

  verifyTicketDetailsVisible() {
    cy.get('.ticket-details').should('be.visible');
  }

  verifyTotalAmountDue() {
    cy.get('.ticket-details .total-amount').should('contain', '$');
  }

  payTicketWithCreditCard(cardNumber, expiryDate, cvv) {
    cy.get('.ticket-details .pay-ticket').click();
    cy.get('.payment-options .credit-card-option').click();
    cy.get('.payment-form').within(() => {
      cy.get('input[name="cardNumber"]').type(cardNumber);
      cy.get('input[name="expiryDate"]').type(expiryDate);
      cy.get('input[name="cvv"]').type(cvv);
      cy.get('button[type="submit"]').click();
    });
  }

  verifyPaymentSuccess() {
    cy.get('.confirmation-message').should('contain', 'Payment successful');
  }

  verifyTicketStatusPaid() {
    cy.get('.ticket-list .ticket-item.paid').should('be.visible');
  }

  verifyNoOutstandingTicketsMessage() {
    cy.get('.no-tickets-message').should('contain', 'No outstanding tickets');
  }

  verifyErrorMessageForInvalidPayment() {
    cy.get('.error-message').should('contain', 'Invalid card details');
  }

  verifyErrorMessageForExpiredCard() {
    cy.get('.error-message').should('contain', 'Expired card');
  }

  verifyPaymentFailureNotification() {
    cy.get('.failure-notification').should('contain', 'Payment failed');
  }

  verifyEmailConfirmationSent() {
    cy.get('.email-confirmation').should('contain', 'Payment confirmation sent');
  }

  downloadReceipt() {
    cy.get('.download-receipt').should('be.visible').click();
  }

  verifyPaidTicketsHistoryVisible() {
    cy.get('.paid-tickets-history').should('be.visible');
  }

  verifySecurePaymentHandling() {
    cy.get('.payment-form').within(() => {
      cy.get('input[name="cardNumber"]').should('not.have.value');
    });
  }
}

export default ParkingTicketsPage;