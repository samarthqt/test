class GreenBankingPage {
  login() {
    cy.get('#loginButton').click();
  }

  visitGreenBankingInitiative() {
    cy.get('#greenBankingLink').click();
  }

  visitHomePage() {
    cy.get('#homeLink').click();
  }

  initiateCarbonReductionActions() {
    cy.get('#carbonReductionButton').click();
  }

  checkNotifications() {
    cy.get('#notificationsLink').click();
  }

  simulateDataTrackingError() {
    cy.get('#simulateErrorButton').click();
  }

  checkCarbonFootprint() {
    cy.get('#carbonFootprintLink').click();
  }

  useExistingBankingFeatures() {
    cy.get('#existingFeaturesLink').click();
  }

  accessGreenBankingInitiative() {
    cy.get('#accessGreenBankingButton').click();
  }

  useBankingAppOnDesktopOrMobile() {
    cy.get('#desktopMobileToggle').click();
  }

  includeGreenBankingInitiative() {
    cy.get('#includeGreenInitiativeButton').click();
  }

  useFeature() {
    cy.get('#useFeatureButton').click();
  }
}

export default GreenBankingPage;