describe('Customizable Lease Agreements Functionality', () => {
  const landlordCredentials = { username: 'landlordUser', password: 'securePassword' };
  const propertyDetails = { address: '123 Main St', rent: 1500 };

  beforeEach(() => {
    cy.visit('/login');
    cy.login(landlordCredentials.username, landlordCredentials.password);
  });

  it('should allow landlords to customize lease agreements', () => {
    cy.visit('/lease-management');
    cy.contains('Create New Lease Agreement').click();
    cy.contains('Standard Lease Template').click();
    cy.get('#customClauses').type('No pets allowed.');
    cy.get('#existingClauses').clear().type('Rent due on the first of every month.');
    cy.get('#propertyAddress').type(propertyDetails.address);
    cy.get('#rentAmount').type(propertyDetails.rent);
    cy.contains('Review Lease Agreement').click();
    cy.contains('Save Lease Agreement').click();
    cy.contains('Error').should('not.exist');
    cy.contains('Share with Tenants').click();
    cy.logout();
    cy.login(landlordCredentials.username, landlordCredentials.password);
    cy.visit('/lease-management');
    cy.contains('123 Main St').click();
    cy.contains('Revert to Standard Template').click();
    cy.contains('Create New Lease Agreement').click();
    cy.get('#customClauses').type('Invalid clause.');
    cy.contains('Save Lease Agreement').click();
    cy.contains('Invalid clause detected').should('exist');
  });
});