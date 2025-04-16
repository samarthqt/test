describe('Manage Participant Withdrawals', () => {
  const participantId = 'P001';
  const withdrawalReason = 'Personal Reasons';
  const withdrawalDate = '2023-11-01';

  beforeEach(() => {
    cy.visit('/login');
    cy.login('validUsername', 'validPassword');
    cy.url().should('include', '/dashboard');
  });

  it('should track and manage participant withdrawals', () => {
    cy.navigateToParticipantManagement();
    cy.selectWithdrawalsSubModule();
    cy.clickAddNewWithdrawal();
    cy.enterParticipantId(participantId);
    cy.selectWithdrawalReason(withdrawalReason);
    cy.enterWithdrawalDate(withdrawalDate);
    cy.saveWithdrawal();
    cy.verifyWithdrawalInLog(participantId, withdrawalReason, withdrawalDate);
    cy.verifyWithdrawalDetails(participantId, withdrawalReason, withdrawalDate);
    cy.logout();
    cy.login('validUsername', 'validPassword');
    cy.navigateToParticipantManagement();
    cy.verifyWithdrawalRecordPersistence(participantId);
    cy.generateWithdrawalReport();
    cy.verifyReportAccuracy(participantId, withdrawalReason, withdrawalDate);
  });
});