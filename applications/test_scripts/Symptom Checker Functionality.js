describe('Symptom Checker Functionality', () => {
  const symptoms = ['Headache', 'Nausea'];

  before(() => {
    // Assuming user is already logged in
    cy.visit('/symptom-checker');
  });

  it('should display the Symptom Checker interface', () => {
    cy.url().should('include', '/symptom-checker');
    cy.get('.symptom-checker-interface').should('be.visible');
  });

  symptoms.forEach((symptom) => {
    it(`should accept and display the symptom: ${symptom}`, () => {
      cy.get('.symptom-input').type(symptom);
      cy.get('.symptom-input').should('have.value', symptom);
    });
  });

  it('should process symptoms and display potential diagnoses', () => {
    cy.get('.check-symptoms-button').click();
    cy.get('.diagnosis-list').should('be.visible');
    cy.get('.diagnosis-item').each(($el) => {
      cy.wrap($el).find('.diagnosis-description').should('not.be.empty');
    });
  });

  it('should provide instructions to see a doctor for serious symptoms', () => {
    cy.get('.doctor-instructions').should('contain.text', 'consult a doctor');
  });

  after(() => {
    cy.get('.logout-button').click();
    cy.url().should('not.include', '/symptom-checker');
  });
});