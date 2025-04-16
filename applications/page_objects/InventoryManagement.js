class InventoryManagement {
  getDashboard() {
    return cy.get('.inventory-dashboard');
  }

  goToExpiryAlerts() {
    cy.get('.expiry-alerts-nav').click();
  }

  getExpiryAlertsSection() {
    return cy.get('.expiry-alerts-section');
  }

  checkNotificationSettings() {
    return cy.get('.notification-settings');
  }

  getProductsNearExpiry() {
    return cy.get('.products-near-expiry');
  }

  simulateCurrentDate(date) {
    cy.clock(new Date(date));
  }

  verifyNotificationsWithinDays(days) {
    return cy.get(`.notifications-within-${days}-days`);
  }

  getNotificationLog() {
    return cy.get('.notification-log');
  }

  changeNotificationThreshold(days) {
    cy.get('.notification-threshold-input').clear().type(days);
    cy.get('.save-threshold-button').click();
  }
}