describe('Study Protocol Creation', () => {
  beforeEach(() => {
    cy.visit('https://trialmanagementportal.com');
    cy.login('authorized_user', 'password');
  });

  it('should allow authorized user to create a study protocol', () => {
    const protocolID = 'SP001';
    const objective = 'Assess drug efficacy';
    const methods = 'Double-blind trial';
    const timeline = '01/01/2023 to 12/31/2023';

    cy.get('nav').contains('Protocols').click();
    cy.url().should('include', '/protocols');

    cy.get('button').contains('Create New Protocol').click();
    cy.url().should('include', '/protocols/create');

    cy.get('#protocolID').type(protocolID);
    cy.get('#objective').type(objective);
    cy.get('#methods').type(methods);
    cy.get('#timeline').type(timeline);

    cy.get('button').contains('Submit').click();

    cy.get('.protocol-list').should('contain', protocolID);
    cy.get('.protocol-list').should('contain', objective);
    cy.get('.protocol-list').should('contain', methods);
    cy.get('.protocol-list').should('contain', timeline);
  });

  it('should allow authorized user to edit a study protocol', () => {
    const updatedObjective = 'Updated drug efficacy';

    cy.get('.protocol-list').contains('SP001').click();
    cy.url().should('include', '/protocols/SP001/edit');

    cy.get('#objective').clear().type(updatedObjective);
    cy.get('button').contains('Save').click();

    cy.get('.protocol-list').should('contain', updatedObjective);
  });
});