describe('Electronic Patient Consent', () => {
  const patientName = 'John Doe';
  const procedureName = 'Appendectomy';
  const consentFormId = 'CF12345';

  beforeEach(() => {
    cy.visit('/login');
    cy.login('validUsername', 'validPassword');
    cy.url().should('include', '/dashboard');
  });

  it('should allow a patient to sign a consent form electronically', () => {
    // Step 2: Navigate to the 'Consent Forms' section
    cy.get('.consent-forms-link').click();
    cy.url().should('include', '/consent-forms');

    // Step 3: Select the consent form for the procedure
    cy.contains(procedureName).click();
    cy.url().should('include', `/consent-forms/${consentFormId}`);

    // Step 4: Review the consent form details
    cy.get('.consent-form-details').should('be.visible');

    // Step 5: Click on 'Sign Electronically' button
    cy.get('.sign-electronically-button').click();
    cy.get('.signature-interface').should('be.visible');

    // Step 6: Provide electronic signature
    cy.get('.signature-pad').trigger('mousedown').trigger('mousemove', { clientX: 100, clientY: 100 }).trigger('mouseup');
    cy.get('.signature-display').should('be.visible');

    // Step 7: Submit the signed consent form
    cy.get('.submit-button').click();
    cy.get('.confirmation-message').should('contain', 'Submission successful');

    // Step 8: Verify the signed consent form in the system records
    cy.get('.system-records-link').click();
    cy.contains(consentFormId).should('exist');
  });

  afterEach(() => {
    // Step 9: Log out from the patient portal
    cy.get('.logout-button').click();
    cy.url().should('include', '/login');
  });
});