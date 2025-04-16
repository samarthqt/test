describe('Order Cancellation within 30 Minutes', () => {
  beforeEach(() => {
    cy.visit('/login');
    cy.login('validUser', 'validPassword');
  });

  it('should allow users to cancel orders within 30 minutes if not processed or shipped', () => {
    const orderId = '54321';
    cy.get('.order-history-link').click();
    cy.url().should('include', '/order-history');
    cy.get(`.order-item[data-order-id="${orderId}"]`).within(() => {
      cy.get('.order-time').invoke('text').then((text) => {
        const orderTime = new Date(text);
        const currentTime = new Date();
        const timeDifference = (currentTime - orderTime) / 1000 / 60;
        expect(timeDifference).to.be.lessThan(30);
      });
      cy.get('.cancel-order-button').click();
    });
    cy.get('.cancellation-confirmation').should('be.visible');
    cy.get('.confirm-cancellation-button').click();
    cy.get('.cancellation-success-message').should('contain', 'Order successfully canceled');
  });
});