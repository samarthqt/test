import { expect } from 'chai';
import { visit, get } from 'cypress';

class LanguageCurrencyPage {
  static visit() {
    cy.visit('/application');
  }

  static detectRegion() {
    cy.get('#regionDetection').invoke('detect');
  }

  static verifyAutomaticAdjustment() {
    cy.get('#languageSetting').should('have.value', 'auto');
    cy.get('#currencySetting').should('have.value', 'auto');
  }

  static changeSettingsManually() {
    cy.get('#manualSettingsBtn').click();
  }

  static verifyManualSelection() {
    cy.get('#languageDropdown').should('be.visible');
    cy.get('#currencyDropdown').should('be.visible');
  }

  static viewConversionRates() {
    cy.get('#conversionRates').click();
  }

  static verifyConversionRates() {
    cy.get('#conversionRates').should('contain', 'accurate');
  }

  static selectLanguageRegion(language, region) {
    cy.get('#languageDropdown').select(language);
    cy.get('#regionDropdown').select(region);
  }

  static verifyDisplayFormats(language, currency) {
    cy.get('#textFormats').should('contain', language);
    cy.get('#currencyFormats').should('contain', currency);
  }

  static selectUnsupportedLanguageCurrency(language, currency) {
    cy.get('#languageDropdown').select(language);
    cy.get('#currencyDropdown').select(currency);
  }

  static verifyErrorMessage() {
    cy.get('#errorMessage').should('be.visible').and('contain', 'unsupported');
  }

  static performConversion() {
    cy.get('#conversionBtn').click();
  }

  static verifySecurityMeasures() {
    cy.get('#securityStatus').should('contain', 'secure');
  }

  static changeSettings() {
    cy.get('#changeSettingsBtn').click();
  }

  static verifyLogging() {
    cy.get('#logStatus').should('contain', 'logged');
  }

  static requireConversion() {
    cy.get('#requireConversionBtn').click();
  }

  static verifyThirdPartyIntegration() {
    cy.get('#thirdPartyStatus').should('contain', 'integrated');
  }

  static autoChangeRegionSettings() {
    cy.get('#autoRegionChange').invoke('change');
  }

  static verifyNotifications() {
    cy.get('#notificationStatus').should('contain', 'notified');
  }

  static verifySupport() {
    cy.get('#supportStatus').should('contain', 'multiple');
  }

  static performTesting() {
    cy.get('#performTesting').click();
  }

  static verifyFunctionality() {
    cy.get('#functionalityStatus').should('contain', 'confirmed');
  }
}

export default LanguageCurrencyPage;