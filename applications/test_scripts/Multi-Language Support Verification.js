describe('Multi-language Support Verification', () => {
  const tenantCredentials = { username: 'tenantUser', password: 'tenantPass' };
  const landlordCredentials = { username: 'landlordUser', password: 'landlordPass' };
  const languages = ['Spanish', 'French', 'German', 'Chinese', 'English'];

  beforeEach(() => {
    cy.visit('/');
  });

  it('should allow tenant to change language to Spanish and verify', () => {
    cy.login(tenantCredentials);
    cy.get('.homepage').should('be.visible');
    cy.navigateToLanguageSettings();
    cy.selectLanguage('Spanish');
    cy.verifyLanguageChange('Spanish');
  });

  it('should allow landlord to change language to multiple languages and verify', () => {
    cy.login(landlordCredentials);
    cy.get('.homepage').should('be.visible');
    cy.navigateToLanguageSettings();

    languages.forEach(language => {
      cy.selectLanguage(language);
      cy.verifyLanguageChange(language);
    });
  });

  it('should prevent selecting a non-existent language', () => {
    cy.login(tenantCredentials);
    cy.navigateToLanguageSettings();
    cy.selectNonExistentLanguage();
    cy.get('.error-message').should('contain', 'Invalid language selection');
  });

  it('should prompt user to select a language before saving', () => {
    cy.login(tenantCredentials);
    cy.navigateToLanguageSettings();
    cy.saveLanguageWithoutSelection();
    cy.get('.error-message').should('contain', 'Please select a language');
  });

  it('should retain language selection after logout and login', () => {
    cy.login(tenantCredentials);
    cy.navigateToLanguageSettings();
    cy.selectLanguage('French');
    cy.logout();
    cy.login(tenantCredentials);
    cy.verifyLanguageChange('French');
  });

  it('should synchronize language settings across devices', () => {
    cy.login(tenantCredentials);
    cy.navigateToLanguageSettings();
    cy.selectLanguage('German');
    cy.verifyLanguageSyncAcrossDevices('German');
  });
});