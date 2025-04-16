class SettingsPage {
  navigateToSettings() {
    cy.get('#settings-menu').click();
  }

  selectLanguagePreferences() {
    cy.get('#language-preferences').click();
  }

  selectUnsupportedLanguage(language) {
    cy.get('#language-select').select(language).should('not.exist');
  }

  verifyUnsupportedLanguageError() {
    cy.get('.error-message').should('contain', 'Language not supported');
  }
}

export default SettingsPage;