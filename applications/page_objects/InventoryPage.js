class InventoryPage {
  navigateToStockAlerts() {
    cy.get('#stock-alerts-link').click();
  }
}

class StockAlertsPage {
  selectInventoryItem(itemId) {
    cy.get(`#item-${itemId}`).click();
  }

  verifyStockLevelBelowThreshold(currentLevel, threshold) {
    cy.get('#stock-level').should('have.text', currentLevel);
    cy.get('#threshold-level').should('have.text', threshold);
  }

  checkAlertGenerated(itemId) {
    cy.get('#alert-message').should('contain.text', `low stock for Item ID: ${itemId}`);
  }

  reviewNotificationSettings() {
    cy.get('#notification-settings').should('contain.text', 'email and SMS');
  }

  verifyEmailAlert(itemId) {
    cy.get('#email-alert').should('contain.text', `low stock for Item ID: ${itemId}`);
  }

  verifySMSAlert(itemId) {
    cy.get('#sms-alert').should('contain.text', `low stock for Item ID: ${itemId}`);
  }

  checkAlertHistory() {
    cy.get('#alert-history').click();
    cy.get('#alert-history-log').should('exist');
  }

  adjustThresholdLevel(itemId, newThreshold) {
    cy.get(`#threshold-input-${itemId}`).clear().type(newThreshold);
    cy.get('#save-threshold').click();
  }

  simulateStockLevelUpdate(newLevel) {
    cy.get('#simulate-stock-update').click();
    cy.get('#new-stock-level').clear().type(newLevel);
    cy.get('#process-update').click();
  }

  verifyNoNewAlertGenerated() {
    cy.get('#alert-message').should('not.exist');
  }

  deactivateAlerts() {
    cy.get('#deactivate-alerts').click();
  }

  reactivateAlerts() {
    cy.get('#reactivate-alerts').click();
  }

  verifyNotificationSettings() {
    cy.get('#notification-settings').should('contain.text', 'email and SMS');
  }
}