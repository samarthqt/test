class LanguagePage {
  selectLanguage(language) {
    cy.get('#language-dropdown').select(language);
  }

  verifyContentLanguage(language) {
    cy.get('body').should('contain.text', language);
  }

  verifyDefaultLanguage() {
    cy.get('body').should('contain.text', 'English');
  }

  navigateToAnotherPage() {
    cy.get('a').contains('Another Page').click();
  }

  navigateToPage(pageName) {
    cy.get('a').contains(pageName).click();
  }

  verifyPageContentLanguage(pageName, language) {
    this.navigateToPage(pageName);
    this.verifyContentLanguage(language);
  }

  verifyLanguageDropdownVisibility() {
    cy.get('#language-dropdown').should('be.visible');
  }
}

export default LanguagePage;