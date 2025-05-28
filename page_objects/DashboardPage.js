import { DashboardPage } from 'cypress';

class DashboardPage {

  verifyDashboardIsDisplayed() {
    cy.get('#dashboard').should('be.visible');
  }

  verifyLoginSuccess() {
    cy.url().should('include', '/dashboard');
    cy.get('#welcomeMessage').should('contain', 'Welcome');
  }

  navigateToOrdersModule() {
    cy.get('#ordersModule').click();
  }

  navigateToOrderDetails() {
    cy.get('#order-details-link').click();
  }

  navigateToTrackShipment() {
    cy.get('#trackShipmentLink').click();
  }

  logout() {
    cy.get('#logoutButton').click();
  }

}

export default DashboardPage;