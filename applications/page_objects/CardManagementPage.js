class CardManagementPage {
  navigateToCardManagement() {
    cy.get('#cardManagementMenu').click();
  }

  selectCard(cardNumber) {
    cy.get(`#card-${cardNumber}`).click();
  }

  lockCard() {
    cy.get('#lockCardButton').click();
    cy.get('#confirmLockButton').click();
  }

  unlockCard() {
    cy.get('#unlockCardButton').click();
    cy.get('#confirmUnlockButton').click();
  }

  verifyCardStatus(status) {
    cy.contains(`Card Status: ${status}`).should('be.visible');
  }
}

class TransactionPage {
  attemptTransaction(cardNumber, amount) {
    cy.get('#cardNumber').type(cardNumber);
    cy.get('#amount').type(amount);
    cy.get('#submitTransaction').click();
  }

  verifyTransactionStatus(status) {
    cy.contains(`Transaction ${status}`).should('be.visible');
  }
}