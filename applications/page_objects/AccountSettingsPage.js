class AccountSettingsPage {
  navigateToAccountSettings() {
    cy.visit('/account/settings');
  }

  verifyEmailPreferencesVisible() {
    cy.get('#email-preferences-section').should('be.visible');
  }

  unsubscribeFromMarketingEmails() {
    cy.get('#unsubscribe-marketing-emails').click();
  }

  confirmUnsubscription() {
    cy.get('#confirmation-message').should('contain', 'You have successfully unsubscribed');
  }
}