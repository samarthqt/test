class UnsupportedPage {
  getUnsupportedMessage() {
    return cy.get('.unsupported-browser-message');
  }

  getLimitedFunctionalityMessage() {
    return cy.get('.limited-functionality-message');
  }

  navigateToSection(sectionId) {
    cy.get(`#${sectionId}`).click();
  }
}