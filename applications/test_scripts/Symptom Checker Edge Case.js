describe('Symptom Checker Edge Case', () => {
  const symptoms = ['Headache', 'Nausea', 'Cough', 'Fever', 'Sore Throat', 'Fatigue', 'Dizziness', 'Loss of Appetite', 'Muscle Pain', 'Shortness of Breath'];

  before(() => {
    cy.visit('/login');
    cy.login('registeredUser', 'password');
  });

  it('should navigate to Symptom Checker and input symptoms', () => {
    cy.visit('/symptom-checker');
    cy.get(SymptomCheckerPage.symptomInputField).should('be.visible');

    symptoms.forEach((symptom) => {
      cy.get(SymptomCheckerPage.symptomInputField).type(symptom);
      cy.get(SymptomCheckerPage.symptomInputField).should('have.value', symptom);
    });

    cy.get(SymptomCheckerPage.checkSymptomsButton).click();
    cy.get(SymptomCheckerPage.diagnosisList).should('be.visible');
  });

  it('should verify system performance', () => {
    cy.get(SymptomCheckerPage.diagnosisList).should('not.have.class', 'loading');
  });

  after(() => {
    cy.logout();
  });
});