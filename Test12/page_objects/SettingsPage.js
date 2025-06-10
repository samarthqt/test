import { expect } from 'chai';
import 'cypress';

class SettingsPage {
  static visit() {
    cy.visit('/settings');
  }

  static selectLanguage(language) {
    cy.get('#languageDropdown').select(language);
  }

  static verifyLanguageChange(language) {
    cy.get('body').should('contain.text', language);
  }

  static selectCurrency(currency) {
    cy.get('#currencyDropdown').select(currency);
  }

  static verifyCurrencyChange(currency) {
    cy.get('.price').each(($el) => {
      cy.wrap($el).should('contain.text', currency);
    });
  }

  static navigateApplication() {
    cy.get('#homeLink').click();
  }

  static verifyContentAndCurrency(language, currency) {
    cy.get('body').should('contain.text', language);
    cy.get('.price').each(($el) => {
      cy.wrap($el).should('contain.text', currency);
    });
  }

  static changeSettings(language, currency) {
    this.selectLanguage(language);
    this.selectCurrency(currency);
  }

  static confirmChanges() {
    cy.get('#confirmButton').click();
  }

  static verifyImmediateChanges(language, currency) {
    this.verifyContentAndCurrency(language, currency);
  }

  static triggerCurrencyConversion() {
    cy.get('#convertButton').click();
  }

  static verifyConversionRates(currency) {
    cy.get('.conversionRate').should('contain.text', currency);
  }

  static selectUnsupportedLanguageOrCurrency(language, currency) {
    cy.get('#languageDropdown').select(language);
    cy.get('#currencyDropdown').select(currency);
  }

  static applyUnsupportedSettings() {
    cy.get('#applySettingsButton').click();
  }

  static verifyFallbackToDefault() {
    cy.get('body').should('contain.text', 'English');
    cy.get('.price').each(($el) => {
      cy.wrap($el).should('contain.text', 'USD');
    });
  }

  static accessDifferentInterfaces() {
    cy.get('#profileLink').click();
    cy.get('#dashboardLink').click();
  }

  static verifyConsistency(language, currency) {
    this.verifyContentAndCurrency(language, currency);
  }

  static accessOnDevice() {
    cy.viewport('iphone-6');
    cy.visit('/settings');
  }

  static navigateToSettings() {
    cy.get('#settingsLink').click();
  }

  static verifyLocalizationFeatures() {
    cy.get('#languageDropdown').should('be.visible');
    cy.get('#currencyDropdown').should('be.visible');
  }
}

export default SettingsPage;