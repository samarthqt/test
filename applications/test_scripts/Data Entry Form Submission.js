describe('Data Entry Form Submission', () => {
  beforeEach(() => {
    cy.visit('/login');
    cy.login('clinician', 'password');
  });

  it('should allow clinicians to submit data through the forms', () => {
    const dataEntryPage = new DataEntryPage();

    dataEntryPage.accessDataEntryForms();
    dataEntryPage.fillOutForm('12345', 'P001', 'Sample Data');
    dataEntryPage.submitForm();

    cy.get('.confirmation-message').should('contain', 'Data successfully submitted');
  });
});