class LanguageSettingsPage {
  navigateTo() {
    cy.get('nav').contains('Settings').click();
    cy.get('.settings-menu').contains('Language').click();
  }

  selectLanguage(language) {
    cy.get('.language-select').select(language);
    cy.get('.save-button').click();
  }

  verifyLanguageChange(language) {
    cy.get('body').should('have.class', language.toLowerCase());
    cy.get('.menu-items').each(($el) => {
      cy.wrap($el).should('have.attr', 'lang', language.toLowerCase());
    });
  }

  selectNonExistentLanguage() {
    cy.get('.language-select').select('NonExistent');
    cy.get('.save-button').click();
  }

  saveLanguageWithoutSelection() {
    cy.get('.save-button').click();
  }

  verifyLanguageSyncAcrossDevices(language) {
    // This would ideally be a more complex test involving multiple sessions or devices
    cy.get('body').should('have.class', language.toLowerCase());
  }
}

export default LanguageSettingsPage;