import 'cypress-xpath';

class SupportTeamDashboardPage {

  static visitDashboard() {
    cy.visit('/support-team-dashboard');
  }

  static verifyDashboardAccess() {
    cy.get('#dashboardAccess').should('be.visible');
  }

  static respondToSupportRequest() {
    cy.get('#respondBtn').click();
  }

  static verifyResponseSuccess() {
    cy.get('#responseSuccess').should('be.visible');
  }

  static searchSupportRequest(requestId) {
    cy.get('#searchInput').type(requestId);
    cy.get('#searchButton').click();
  }

  static verifyRequestDetails(requestId) {
    cy.get('#requestDetails').should('contain', requestId);
  }

  static filterRequestsByStatus(status) {
    cy.get('#statusFilter').select(status);
  }

  static verifyFilteredRequests(status) {
    cy.get('.requestStatus').each(($el) => {
      cy.wrap($el).should('contain', status);
    });
  }

  static navigateToRequestDetails(requestId) {
    this.searchSupportRequest(requestId);
    cy.get(`#request-${requestId}`).click();
  }

  static verifyNoRequestsFound() {
    cy.get('#noRequestsMessage').should('be.visible');
  }

}

export default SupportTeamDashboardPage;