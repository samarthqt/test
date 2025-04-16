describe('Tenant Screening Process - Background Check', () => {
  before(() => {
    cy.login();
  });

  it('Navigate to Tenant Management module', () => {
    cy.visit('/dynamics365/tenant-management');
    cy.contains('Tenant Management').should('be.visible');
  });

  it('Select Screening sub-module', () => {
    cy.get('[data-test=screening-sub-module]').click();
    cy.contains('Screening Options').should('be.visible');
  });

  it('Enter tenant information', () => {
    cy.get('[data-test=tenant-name]').type('John Doe High');
    cy.get('[data-test=tenant-ssn]').type('123-45-6789');
    cy.get('[data-test=tenant-address]').type('123 Main St, Anytown, USA');
    cy.contains('Information entered correctly').should('be.visible');
  });

  it('Initiate background check', () => {
    cy.get('[data-test=initiate-background-check]').click();
    cy.contains('Background check initiated').should('be.visible');
  });

  it('Verify background check completion', () => {
    cy.get('[data-test=background-check-status]').should('contain', 'Completed');
    cy.contains('Results displayed').should('be.visible');
  });

  it('Check results stored securely', () => {
    cy.get('[data-test=background-check-results]').should('be.visible');
    cy.get('[data-test=results-secure]').should('contain', 'Secure');
  });

  after(() => {
    cy.logout();
  });
});