class PaymentTerminalPage {
  isReadyToAcceptPayments() {
    cy.get('#terminal-status').should('contain', 'Ready to accept contactless payments');
  }

  detectNFCSignal() {
    cy.get('#nfc-signal').should('be.visible');
  }

  verifyPaymentConfirmation() {
    cy.get('#confirmation').should('contain', 'Payment authorized');
  }
}

class SmartphonePage {
  activateNFC() {
    cy.get('#nfc-toggle').click();
    cy.get('#nfc-status').should('contain', 'NFC is active');
  }

  holdNearTerminal() {
    cy.get('#hold-near-terminal').click();
  }

  authorizePayment() {
    cy.get('#authorize-payment').click();
    cy.get('#payment-status').should('contain', 'Payment authorized');
  }
}