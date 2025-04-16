class CreditScorePage {
  navigateToCreditScoreSection() {
    cy.get('#financialTools').click();
    cy.get('#creditScoreSection').click();
  }

  verifyCreditScoreSectionDisplayed() {
    cy.get('#creditScoreOptions').should('be.visible');
  }

  viewCurrentCreditScore() {
    cy.get('#viewCreditScore').click();
  }

  verifyCreditScoreDisplayed() {
    cy.get('#currentCreditScore').should('be.visible');
  }

  reviewCreditScoreHistory() {
    cy.get('#creditScoreHistory').click();
  }

  verifyCreditScoreHistoryDisplayed() {
    cy.get('#creditScoreHistoryDetails').should('be.visible');
  }

  setupCreditScoreAlerts(threshold) {
    cy.get('#alertSettings').click();
    cy.get('#thresholdInput').clear().type(threshold);
    cy.get('#saveAlertSettings').click();
  }

  verifyAlertSetupConfirmation() {
    cy.get('#alertConfirmation').should('be.visible');
  }

  simulateCreditScoreChange(change) {
    cy.get('#simulateChange').click();
    cy.get('#changeAmount').clear().type(change);
    cy.get('#submitChange').click();
  }

  verifyAlertNotificationReceived() {
    cy.get('#alertNotification').should('be.visible');
  }

  accessAlertNotification() {
    cy.get('#alertNotification').click();
  }

  verifyCreditScoreChangeDetails() {
    cy.get('#changeDetails').should('be.visible');
  }

  verifyCreditScoreAlertsActive() {
    cy.get('#alertStatus').should('contain', 'Active');
  }

  modifyAlertThreshold(newThreshold) {
    cy.get('#modifyThreshold').click();
    cy.get('#newThresholdInput').clear().type(newThreshold);
    cy.get('#saveNewThreshold').click();
  }

  verifyAlertThresholdModification() {
    cy.get('#thresholdModificationConfirmation').should('be.visible');
  }

  verifyNoAlertGenerated() {
    cy.get('#noAlertMessage').should('be.visible');
  }

  verifyCreditScoreDetailsUpdated() {
    cy.get('#creditScoreDetails').should('contain', 'Updated');
  }

  verifyFeatureDocumentation() {
    cy.get('#documentation').should('contain', 'Credit Score Monitoring');
  }

  accessCreditScoreWithoutLogin() {
    cy.get('#creditScoreSection').click();
  }

  verifyAccessDenied() {
    cy.get('#loginPrompt').should('be.visible');
  }
}