import { expect } from 'chai';

class CurrencyPage {

  static visitLoginPage() {
    cy.visit('/login');
  }

  static login(username = 'user', password = 'pass') {
    cy.get('#username').type(username);
    cy.get('#password').type(password);
    cy.get('#loginBtn').click();
  }

  static verifyLogin() {
    cy.url().should('include', '/dashboard');
  }

  static navigateToCurrencySettings() {
    cy.get('#currencySettingsLink').click();
  }

  static verifyCurrencySettingsPage() {
    cy.url().should('include', '/currency-settings');
  }

  static selectCurrency(currency = 'EUR') {
    cy.get('#currencyDropdown').select(currency);
  }

  static verifyCurrencySelection(currency = 'EUR') {
    cy.get('#selectedCurrency').should('have.text', currency);
  }

  static ensureCurrencyNotSelected(currency = 'USD') {
    cy.get('#selectedCurrency').should('not.have.text', currency);
  }

  static updatePrices() {
    cy.reload();
  }

  static verifyPricesInCurrency(symbol = '€') {
    cy.get('.price').each(($el) => {
      expect($el.text()).to.include(symbol);
    });
  }

  static verifyProductPriceFormat(symbol = '€') {
    cy.get('.productPrice').each(($el) => {
      expect($el.text()).to.match(new RegExp(`${symbol}\\d+\\.\\d{2}`));
    });
  }

  static verifyCurrencySymbols() {
    cy.get('.currencySymbol').each(($el) => {
      expect($el.text()).to.be.oneOf(['€', '$', '£']);
    });
  }

  static verifyTransactionAmounts(symbol = '€') {
    cy.get('.transactionAmount').each(($el) => {
      expect($el.text()).to.include(symbol);
    });
  }

  static logoutAndLogin() {
    cy.get('#logoutBtn').click();
    cy.get('#loginBtn').click();
  }

  static verifyCurrencyPersistence(currency = 'EUR') {
    cy.get('#selectedCurrency').should('have.text', currency);
  }

  static accessOnDevice(device = 'iphone-x') {
    cy.viewport(device);
    cy.reload();
  }

  static accessOnBrowser(userAgent) {
    cy.visit('/currency-settings', {
      headers: { 'User-Agent': userAgent }
    });
  }

  static accessMobileApp() {
    cy.visit('/mobile-app');
  }

  static verifyCurrencySettingsMobileApp(currency = 'EUR') {
    cy.get('#selectedCurrency').should('have.text', currency);
  }

  static verifyCurrencyConversionRates() {
    cy.get('.conversionRate').each(($el) => {
      expect($el.text()).to.match(/1 EUR = \\d+\\.\\d{2} USD/);
    });
  }

  static interactWithApplication() {
    cy.get('#interactionElement').click();
  }

  static verifyApplicationPerformance(threshold = 100) {
    cy.get('#performanceMetric').should('be.below', threshold);
  }

  static switchToDefaultCurrency() {
    cy.get('#currencyDropdown').select('USD');
  }

  static verifySwitchBackToDefaultCurrency() {
    cy.get('#selectedCurrency').should('have.text', 'USD');
  }

  static selectUnsupportedCurrency() {
    cy.get('#currencyDropdown').select('XYZ');
  }

  static verifyUnsupportedCurrencyHandling() {
    cy.get('#unsupportedCurrencyMessage').should('be.visible');
  }
}

export default CurrencyPage;