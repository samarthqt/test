class LoginPage {
  login(customerId, password) {
    cy.get('#customerId').type(customerId);
    cy.get('#password').type(password);
    cy.get('#loginButton').click();
  }

  verifyUserIsLoggedOut() {
    cy.url().should('include', '/login');
  }
}

class DashboardPage {
  verifyUserIsLoggedIn() {
    cy.url().should('include', '/dashboard');
  }

  navigateToTrackShipment() {
    cy.get('#trackShipmentLink').click();
  }

  logout() {
    cy.get('#logoutButton').click();
  }
}

class TrackShipmentPage {
  verifyTrackShipmentSectionIsDisplayed() {
    cy.get('#trackShipmentSection').should('be.visible');
  }

  enterShipmentID(shipmentId) {
    cy.get('#shipmentIdInput').type(shipmentId);
    cy.get('#searchButton').click();
  }

  verifySystemProcessesInputWithoutErrors() {
    cy.get('#processingIndicator').should('not.exist');
  }

  verifyFeedbackOrErrorMessageForLongID() {
    cy.get('#errorMessage').should('exist').or('#successMessage').should('exist');
  }
}