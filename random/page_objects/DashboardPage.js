class DashboardPage {
  visit() {
    cy.visit('/dashboard');
  }

  selectWidgetToAdd() {
    cy.get('.widget-selector').click();
  }

  verifyWidgetAdded() {
    cy.get('.dashboard').should('contain', 'New Widget');
  }

  ensureWidgetPresent() {
    cy.get('.dashboard .widget').should('exist');
  }

  removeWidget() {
    cy.get('.dashboard .widget .remove-button').click();
  }

  verifyWidgetRemoved() {
    cy.get('.dashboard .widget').should('not.exist');
  }

  ensureMultipleWidgetsPresent() {
    cy.get('.dashboard .widget').should('have.length.greaterThan', 1);
  }

  dragWidgetToNewPosition() {
    cy.get('.dashboard .widget').first().trigger('dragstart');
    cy.get('.dashboard .widget').last().trigger('drop');
  }

  verifyWidgetRearranged() {
    cy.get('.dashboard .widget').first().should('have.class', 'rearranged');
  }

  ensureFrequentWidgetsUsage() {
    cy.get('.dashboard .widget').each(($el) => {
      cy.wrap($el).should('have.class', 'frequent');
    });
  }

  accessDashboard() {
    cy.visit('/dashboard');
  }

  verifyLayoutSuggestions() {
    cy.get('.layout-suggestion').should('be.visible');
  }

  makeLayoutChanges() {
    cy.get('.dashboard .widget').first().find('.settings').click();
  }

  logoutAndLogin() {
    cy.get('.logout-button').click();
    cy.get('.login-button').click();
  }

  verifyChangesPersist() {
    cy.get('.dashboard .changed-layout').should('exist');
  }

  customizeDashboard() {
    cy.get('.customize-button').click();
  }

  selectWidgetsToAdd() {
    cy.get('.widget-selector').each(($el) => {
      cy.wrap($el).click();
    });
  }

  verifyQuickTransfersAndRecentTransactions() {
    cy.get('.dashboard').should('contain', 'Quick Transfers');
    cy.get('.dashboard').should('contain', 'Recent Transactions');
  }

  viewDashboard() {
    cy.visit('/dashboard');
  }

  updateAccountInformation() {
    cy.server();
    cy.route('GET', '/account-info', 'fixture:accountInfo.json').as('getAccountInfo');
    cy.wait('@getAccountInfo');
  }

  verifyRealTimeUpdates() {
    cy.get('.dashboard .account-info').should('contain', 'Updated Info');
  }
}

export default DashboardPage;