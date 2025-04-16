describe('Hospital Discharge Summary Provision', () => {
  const dischargePage = new DischargePage();

  before(() => {
    cy.visit('/login');
    cy.login('healthcareProvider', 'validPassword');
  });

  it('should navigate to discharge summary section', () => {
    dischargePage.goToDischargeSummary();
    dischargePage.verifyDischargeSummaryPage();
  });

  it('should select patient and verify treatment details', () => {
    dischargePage.selectPatient('D12345');
    dischargePage.verifyTreatmentDetails('Appendectomy');
  });

  it('should enter medications and follow-up care instructions', () => {
    dischargePage.enterMedications('Painkillers');
    dischargePage.enterFollowUpCare('Check-up in 2 weeks');
  });

  it('should finalize and generate discharge summary', () => {
    dischargePage.finalizeDischargeSummary();
    dischargePage.verifyDischargeSummaryGenerated();
  });

  it('should provide discharge summary to the patient', () => {
    dischargePage.provideDischargeSummary();
    dischargePage.verifyDischargeSummaryProvided();
  });
});