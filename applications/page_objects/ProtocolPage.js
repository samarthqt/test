class ProtocolPage {
  navigateToProtocols() {
    cy.get('nav').contains('Protocols').click();
  }

  clickCreateNewProtocol() {
    cy.get('button').contains('Create New Protocol').click();
  }

  enterProtocolDetails(protocolID, objective, methods, timeline) {
    cy.get('#protocolID').type(protocolID);
    cy.get('#objective').type(objective);
    cy.get('#methods').type(methods);
    cy.get('#timeline').type(timeline);
  }

  submitProtocolForm() {
    cy.get('button').contains('Submit').click();
  }

  verifyProtocolInList(protocolID, objective, methods, timeline) {
    cy.get('.protocol-list').should('contain', protocolID);
    cy.get('.protocol-list').should('contain', objective);
    cy.get('.protocol-list').should('contain', methods);
    cy.get('.protocol-list').should('contain', timeline);
  }

  editProtocolDetails(updatedObjective) {
    cy.get('#objective').clear().type(updatedObjective);
    cy.get('button').contains('Save').click();
  }
}

export default ProtocolPage;