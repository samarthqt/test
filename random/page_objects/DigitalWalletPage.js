class DigitalWalletPage {
  static visit() {
    cy.visit('/digital-wallet');
  }

  static verifyAccess() {
    cy.get('#wallet-access').should('be.visible');
  }

  static addDigitalAssets() {
    cy.get('#add-assets-button').click();
    cy.get('#loyalty-points').type('100');
    cy.get('#gift-cards').type('50');
    cy.get('#add-assets-confirm').click();
  }

  static verifyDigitalAssetsManagement() {
    cy.get('#assets-list').should('contain', 'Loyalty Points');
    cy.get('#assets-list').should('contain', 'Gift Cards');
  }

  static initiateApplePayPayment() {
    cy.get('#apple-pay-button').click();
  }

  static verifyApplePayTransaction() {
    cy.get('#transaction-status').should('contain', 'Apple Pay Successful');
  }

  static initiateGoogleWalletPayment() {
    cy.get('#google-wallet-button').click();
  }

  static verifyGoogleWalletTransaction() {
    cy.get('#transaction-status').should('contain', 'Google Wallet Successful');
  }

  static performTransaction() {
    cy.get('#perform-transaction-button').click();
  }

  static verifyPCIDSSCompliance() {
    cy.get('#security-status').should('contain', 'PCI-DSS Compliant');
  }

  static completeTransaction() {
    cy.get('#complete-transaction-button').click();
  }

  static verifyTransactionNotification() {
    cy.get('#notification').should('be.visible');
  }

  static initiatePayment() {
    cy.get('#initiate-payment-button').click();
  }

  static verifyIntegrationWithPaymentSystems() {
    cy.get('#integration-status').should('contain', 'Integration Successful');
  }
}

export default DigitalWalletPage;