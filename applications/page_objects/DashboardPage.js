class DashboardPage {
  navigateToDashboard() {
    cy.visit('/dashboard');
  }

  clickCustomize() {
    cy.get('.customize-button').click();
  }

  addWidget() {
    cy.get('.add-widget-button').click();
  }
}

export default DashboardPage;