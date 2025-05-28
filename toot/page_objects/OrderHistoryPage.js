{
  class: page_objects/OrderHistoryPage.js,
  methods: [
    {
      name: visit,
      logic: cy.visit('/order-history');
    },
    {
      name: verifyPageLoad,
      logic: cy.get('#orderHistory').should('be.visible');
    },
    {
      name: verifyOrderListVisible,
      logic: cy.get('.order-list').should('be.visible');
    },
    {
      name: selectOrder,
      logic: cy.get('.order-item').first().click();
    },
    {
      name: verifyOrderDetails,
      logic: cy.get('.order-details').should('be.visible'); cy.get('.invoice').should('be.visible');
    },
    {
      name: setNoOrders,
      logic: cy.intercept('GET', '/api/orders', { body: [] });
    },
    {
      name: verifyNoOrdersMessage,
      logic: cy.get('.no-orders-message').should('be.visible');
    },
    {
      name: setMultiplePages,
      logic: cy.intercept('GET', '/api/orders', { body: this.generateOrders(50) });
    },
    {
      name: navigatePages,
      logic: cy.get('.pagination-next').click();
    },
    {
      name: verifyAllOrdersVisible,
      logic: cy.get('.order-item').should('have.length', 50);
    },
    {
      name: applyDateFilter,
      logic: cy.get('.date-filter').type('2023-01-01 to 2023-12-31'); cy.get('.apply-filter').click();
    },
    {
      name: verifyFilteredOrdersVisible,
      logic: cy.get('.filtered-orders').should('be.visible');
    },
    {
      name: downloadInvoice,
      logic: cy.get('.download-invoice').click();
    },
    {
      name: verifyInvoiceDownloaded,
      logic: cy.readFile('cypress/downloads/invoice.pdf').should('exist');
    },
    {
      name: generateOrders,
      logic: return Array.from({ length: count }, (_, index) => ({ id: index + 1, date: '2023-01-01', total: '$100' }));
    }
  ]
}