describe('Order History Test Suite', () => {
  beforeEach(() => {
    cy.login('U123456'); // Assumes a custom command for logging in
    cy.visit('/dashboard');
  });

  it('should display the order history page', () => {
    cy.get('[data-test=order-history-tab]').click();
    cy.url().should('include', '/order-history');
    cy.get('[data-test=order-list]').should('be.visible');
  });

  it('should verify the presence of order details', () => {
    cy.get('[data-test=order-history-tab]').click();
    cy.get('[data-test=order-id]').contains('O987654');
    cy.get('[data-test=order-date]').should('be.visible');
    cy.get('[data-test=order-total]').should('be.visible');
  });

  it('should display invoice details for selected order', () => {
    cy.get('[data-test=order-history-tab]').click();
    cy.get('[data-test=view-invoice-button]').first().click();
    cy.get('[data-test=invoice-id]').contains('INV654321');
    cy.get('[data-test=invoice-items]').should('be.visible');
    cy.get('[data-test=invoice-total]').should('be.visible');
  });

  it('should download the invoice as a PDF', () => {
    cy.get('[data-test=order-history-tab]').click();
    cy.get('[data-test=download-pdf-button]').first().click();
    cy.verifyDownload('invoice.pdf'); // Assumes a custom command for verifying downloads
  });

  it('should search for a specific order ID', () => {
    cy.get('[data-test=order-history-tab]').click();
    cy.get('[data-test=search-input]').type('O987654');
    cy.get('[data-test=search-button]').click();
    cy.get('[data-test=order-id]').contains('O987654');
  });

  it('should navigate through multiple pages of orders', () => {
    cy.get('[data-test=order-history-tab]').click();
    cy.get('[data-test=next-page-button]').click();
    cy.get('[data-test=previous-page-button]').click();
  });

  it('should filter orders by date range', () => {
    cy.get('[data-test=order-history-tab]').click();
    cy.get('[data-test=date-filter]').click();
    cy.get('[data-test=start-date]').type('2023-01-01');
    cy.get('[data-test=end-date]').type('2023-12-31');
    cy.get('[data-test=apply-filter]').click();
  });

  it('should sort orders by date and amount', () => {
    cy.get('[data-test=order-history-tab]').click();
    cy.get('[data-test=sort-by-date]').click();
    cy.get('[data-test=sort-by-amount]').click();
  });

  it('should display order status for each order', () => {
    cy.get('[data-test=order-history-tab]').click();
    cy.get('[data-test=order-status]').should('be.visible');
  });

  it('should be responsive on different devices', () => {
    cy.viewport('iphone-6');
    cy.visit('/order-history');
    cy.get('[data-test=order-list]').should('be.visible');
    cy.viewport('ipad-2');
    cy.get('[data-test=order-list]').should('be.visible');
  });

  it('should prevent unauthorized access', () => {
    cy.logout();
    cy.visit('/order-history');
    cy.url().should('not.include', '/order-history');
  });

  it('should display customer support contact information', () => {
    cy.get('[data-test=order-history-tab]').click();
    cy.get('[data-test=customer-support]').should('be.visible');
  });

  it('should export order history data to CSV', () => {
    cy.get('[data-test=order-history-tab]').click();
    cy.get('[data-test=export-csv-button]').click();
    cy.verifyDownload('order-history.csv'); // Assumes a custom command for verifying downloads
  });
});