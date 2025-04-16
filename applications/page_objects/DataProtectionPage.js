class DataProtectionPage {
  verifyDataAtRestEncryption(expectedProtocol) {
    cy.get('#data-at-rest-encryption').should('have.text', expectedProtocol);
  }

  verifyDataInTransitEncryption(expectedProtocol) {
    cy.get('#data-in-transit-encryption').should('have.text', expectedProtocol);
  }

  attemptUnauthorizedAccess() {
    cy.request({
      method: 'GET',
      url: '/sensitive-data',
      failOnStatusCode: false
    }).then((response) => {
      expect(response.status).to.eq(403);
    });
  }

  verifyAccessDeniedAndLog() {
    // Assuming there's a log entry for unauthorized access
    cy.get('#log-entries').should('contain', 'Unauthorized access attempt');
  }

  checkEncryptionLogsForAnomalies() {
    cy.get('#encryption-logs').should('not.contain', 'Anomaly');
  }
}