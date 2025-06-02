import { expect } from 'chai';

class LanguageSettingsPage {
  static navigateToSettings() {
    cy.get('#language-settings').click();
  }

  static verifySettingsScreen() {
    cy.url().should('include', '/language-settings');
    cy.get('#language-settings-screen').should('be.visible');
  }

  static selectLanguage(language) {
    cy.get('#language-dropdown').select(language);
    cy.get('#save-language-btn').click();
  }

  static verifyLanguageUpdate(language) {
    cy.get('body').should('have.attr', 'lang', language === 'English' ? 'en' : 'ar');
  }

  static verifyTextAlignment(alignment) {
    cy.get('body').should('have.css', 'text-align', alignment);
  }

  static verifyNavigationDirection(direction) {
    cy.get('html').should('have.attr', 'dir', direction);
  }

  static navigateThroughModules() {
    cy.get('#module1').click();
    cy.get('#module2').click();
  }

  static verifyModulesInRTL() {
    cy.get('#module-container').should('have.css', 'direction', 'rtl');
  }

  static verifyUserDataConsistency() {
    cy.get('#user-data').then(userData => {
      expect(userData).to.have.length.greaterThan(0);
    });
  }

  static verifyFunctionalityInBothModes() {
    this.selectLanguage('English');
    this.verifyLanguageUpdate('English');
    this.selectLanguage('Arabic');
    this.verifyLanguageUpdate('Arabic');
  }

  static verifyLanguagePersistence() {
    cy.reload();
    cy.get('#language-dropdown').should('have.value', 'selectedLanguage');
  }

  static verifyInputFieldsDirection() {
    cy.get('input').each(input => {
      cy.wrap(input).should('have.css', 'direction', 'rtl');
    });
  }

  static verifyErrorMessagesAndAlerts() {
    cy.get('.error-message').should('be.visible');
    cy.get('.alert').should('contain', 'Error');
  }

  static verifyLayoutIntegrity() {
    cy.get('#layout-container').should('be.visible');
    cy.get('#layout-container').children().should('have.length.greaterThan', 0);
  }

  static verifyLanguageSwitchAcrossDevices() {
    cy.viewport('iphone-6');
    this.verifyLanguageUpdate('Arabic');
    cy.viewport('macbook-15');
    this.verifyLanguageUpdate('Arabic');
  }

  static verifySessionAndSecurity() {
    cy.getCookie('session_id').should('exist');
    cy.request('/session/validate').its('status').should('eq', 200);
  }
}

export default LanguageSettingsPage;