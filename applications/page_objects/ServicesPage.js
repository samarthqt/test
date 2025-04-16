class ServicesPage {
  login(userId) {
    cy.get('#userId').type(userId);
    cy.get('#loginButton').click();
  }

  navigateToATMLocator() {
    cy.get('#atmLocatorLink').click();
  }
}

class ATMLocatorPage {
  verifyATMSectionDisplayed() {
    cy.get('#atmLocatorSection').should('be.visible');
  }

  enableLocationServices() {
    cy.get('#enableLocationButton').click();
  }

  verifyLocationServicesEnabled() {
    cy.get('#locationStatus').should('contain', 'Enabled');
  }

  searchATMs() {
    cy.get('#searchATMButton').click();
  }

  verifyATMsDisplayedOnMap() {
    cy.get('#atmMap').should('contain', 'ATM');
  }

  selectATM() {
    cy.get('#atmMap .atm').first().click();
  }

  verifyATMDetailsDisplayed() {
    cy.get('#atmDetails').should('be.visible');
  }

  verifyATMLocationAccuracy() {
    cy.get('#atmMap .atm').first().should('have.attr', 'data-location', 'accurate');
  }
}