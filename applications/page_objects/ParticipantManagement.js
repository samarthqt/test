class ParticipantManagement {
  navigateToParticipantManagement() {
    cy.get('nav').contains('Participant Management').click();
  }

  selectWithdrawalsSubModule() {
    cy.get('nav').contains('Withdrawals').click();
  }

  clickAddNewWithdrawal() {
    cy.get('button').contains('Add New Withdrawal').click();
  }

  enterParticipantId(id) {
    cy.get('input[name="participantId"]').type(id);
  }

  selectWithdrawalReason(reason) {
    cy.get('select[name="withdrawalReason"]').select(reason);
  }

  enterWithdrawalDate(date) {
    cy.get('input[name="withdrawalDate"]').type(date);
  }

  saveWithdrawal() {
    cy.get('button').contains('Save').click();
  }

  verifyWithdrawalInLog(id, reason, date) {
    cy.get('table').contains('td', id).siblings().should('contain', reason).and('contain', date);
  }

  verifyWithdrawalDetails(id, reason, date) {
    cy.get('table').contains('td', id).siblings().should('contain', reason).and('contain', date);
  }

  verifyWithdrawalRecordPersistence(id) {
    cy.get('table').contains('td', id);
  }

  generateWithdrawalReport() {
    cy.get('button').contains('Generate Report').click();
  }

  verifyReportAccuracy(id, reason, date) {
    cy.get('report').contains(id).siblings().should('contain', reason).and('contain', date);
  }
}

export default new ParticipantManagement();