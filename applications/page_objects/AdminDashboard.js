class AdminDashboard {
  loginAsAdmin(credentials) {
    cy.visit('/login');
    cy.get('[data-cy=username]').type(credentials.username);
    cy.get('[data-cy=password]').type(credentials.password);
    cy.get('[data-cy=login-button]').click();
  }

  navigateToThrottlingSection() {
    cy.get('[data-cy=throttling-section]').click();
  }

  selectUser(userId) {
    cy.get('[data-cy=user-list]').contains(userId).click();
  }

  applyThrottlingSettings() {
    cy.get('[data-cy=apply-throttling]').click();
  }

  monitorSpeed() {
    cy.get('[data-cy=monitor-speed]').click();
  }

  checkNotifications() {
    cy.get('[data-cy=notifications]').click();
  }

  checkSystemLogs() {
    cy.get('[data-cy=system-logs]').click();
  }

  applyIncorrectThrottling() {
    cy.get('[data-cy=apply-incorrect-throttling]').click();
  }

  adjustBandwidthSettings() {
    cy.get('[data-cy=adjust-bandwidth]').click();
  }

  reviewUserFeedback() {
    cy.get('[data-cy=user-feedback]').click();
  }

  checkCompliance() {
    cy.get('[data-cy=compliance-check]').click();
  }

  simulateNetworkCongestion() {
    cy.get('[data-cy=simulate-congestion]').click();
  }

  checkPeakHourThrottling() {
    cy.get('[data-cy=peak-hour-check]').click();
  }

  gatherServiceQualityFeedback() {
    cy.get('[data-cy=service-quality-feedback]').click();
  }
}

export default AdminDashboard;