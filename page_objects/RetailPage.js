import { Selector } from 'testcafe';

class RetailPage {

  static visitLoginPage() {
    cy.visit('/login');
  }

  static login(username = 'user', password = 'password') {
    this.visitLoginPage();
    cy.get('#username').type(username);
    cy.get('#password').type(password);
    cy.get('#loginBtn').click();
  }

  static logout() {
    cy.get('#logoutBtn').click();
  }

  static verifyLogout() {
    cy.url().should('include', '/login');
  }

  static navigateToSearchBar() {
    cy.get('#searchBar').click();
  }

  static enterSearchQuery(query) {
    cy.get('#searchInput').type(query);
    cy.get('#searchBtn').click();
  }

  static performSearchOperation(query = 'test') {
    this.enterSearchQuery(query);
  }

  static performRapidSearches() {
    for (let i = 0; i < 5; i++) {
      this.enterSearchQuery('product' + i);
    }
  }

  static navigateToSearchBarOnBrowser(browser) {
    cy.visit(`/catalog?browser=${browser}`);
    this.navigateToSearchBar();
  }

  static navigateToSearchBarOnDevice(device) {
    cy.visit(`/catalog?device=${device}`);
    this.navigateToSearchBar();
  }

  static verifyNoResultsMessage() {
    cy.get('#noResultsMessage').should('be.visible');
  }

  static verifyUIElementsIntact() {
    cy.get('#header').should('be.visible');
    cy.get('#footer').should('be.visible');
  }

  static verifyAlternativeSuggestions() {
    cy.get('#suggestions').should('exist');
  }

  static verifySpecialCharactersHandling() {
    cy.get('#specialCharMessage').should('be.visible');
  }

  static verifyLongQueryHandling() {
    cy.get('#longQueryMessage').should('be.visible');
  }

  static verifyPerformance() {
    cy.get('#performanceMessage').should('be.visible');
  }

  static verifySearchConsistency() {
    cy.get('#searchConsistencyMessage').should('be.visible');
  }

  static verifyBrowserConsistency() {
    cy.get('#browserConsistencyMessage').should('be.visible');
  }

  static verifyMobileDeviceSearch() {
    cy.get('#mobileSearchMessage').should('be.visible');
  }

  static verifyInvalidDataHandling() {
    cy.get('#invalidDataMessage').should('be.visible');
  }

  static verifySystemLogs() {
    cy.readFile('system.log').should('not.contain', 'error');
  }
}

export default RetailPage;