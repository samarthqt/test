class EmailPage {
  checkEmailInbox(email) {
    return cy.task('getEmails', email);
  }
}

class OrderPage {
  placeOrder() {
    cy.get('#add-to-cart-button').click();
    cy.get('#checkout-button').click();
    cy.get('#confirm-order-button').click();
  }

  getOrderID() {
    return cy.get('#order-id').invoke('text');
  }
}

module.exports = { EmailPage, OrderPage };