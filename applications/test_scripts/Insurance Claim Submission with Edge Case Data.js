describe('Insurance Claim Submission with Edge Case Data', () => {
  const patientId = 'P12345';
  const insuranceProvider = 'HealthInsure';
  const medicalService = 'Consultation';
  const dateOfService = '1900-01-01';
  const claimAmount = '0';

  before(() => {
    cy.visit('/login');
    cy.get('#username').type('validPatientUsername');
    cy.get('#password').type('validPatientPassword');
    cy.get('#loginButton').click();
    cy.url().should('include', '/dashboard');
  });

  it('Navigates to Insurance Claims section', () => {
    cy.get('#insuranceClaimsLink').click();
    cy.url().should('include', '/insurance-claims');
  });

  it('Files a new claim with edge case data', () => {
    cy.get('#fileNewClaimButton').click();
    cy.url().should('include', '/file-claim');

    cy.get('#patientId').type(patientId);
    cy.get('#insuranceProvider').select(insuranceProvider);
    cy.get('#medicalService').type(medicalService);
    cy.get('#dateOfService').type(dateOfService);
    cy.get('#claimAmount').type(claimAmount);

    cy.get('#submitClaimButton').click();

    cy.get('.error-message').should('contain', 'Date is outside acceptable range.');
    cy.get('.error-message').should('contain', 'Claim amount must be greater than zero.');
  });
});