describe('Low-Stock Notification Trigger', () => {
  it('should send a low-stock notification when stock levels fall below the threshold', () => {
    const productId = '56789';
    const currentStockLevel = 5;
    const lowStockThreshold = 10;
    
    cy.visit('/inventory');
    
    // Simulate a stock level drop for a product to below the threshold
    cy.get(`[data-product-id="${productId}"]`).within(() => {
      cy.get('.stock-level').clear().type(currentStockLevel);
      cy.get('.update-stock').click();
    });
    
    // Check the notification system for new alerts
    cy.visit('/notifications');
    cy.get('.notification-list').within(() => {
      cy.contains('Low Stock Alert').should('exist');
    });
    
    // Verify the notification content
    cy.get('.notification-list .notification-item').first().within(() => {
      cy.contains(`Product ID: ${productId}`).should('exist');
      cy.contains(`Current Stock Level: ${currentStockLevel}`).should('exist');
      cy.contains(`Threshold: ${lowStockThreshold}`).should('exist');
    });
  });
});