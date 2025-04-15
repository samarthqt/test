class MobileApp {
  launchApp() {
    cy.get('#launchButton').click();
  }

  verifyHomeScreen() {
    cy.get('#homeScreen').should('be.visible');
  }

  login(username, password) {
    cy.get('#username').type(username);
    cy.get('#password').type(password);
    cy.get('#loginButton').click();
  }

  verifyDashboard() {
    cy.get('#dashboard').should('be.visible');
  }

  navigateToSection(sectionName) {
    cy.get(`#${sectionName.toLowerCase()}Section`).click();
  }

  verifySectionLoaded(sectionName) {
    cy.get(`#${sectionName.toLowerCase()}Content`).should('be.visible');
  }

  searchProduct(query) {
    cy.get('#searchBox').type(query);
    cy.get('#searchButton').click();
  }

  verifySearchResults() {
    cy.get('#searchResults').should('contain', 'Laptop');
  }

  addProductToCart(productName) {
    cy.get(`#add${productName}ToCart`).click();
  }

  proceedToCheckout() {
    cy.get('#checkoutButton').click();
  }

  verifyCartSynchronization() {
    cy.get('#cartContents').should('match', '#webCartContents');
  }

  makePayment() {
    cy.get('#paymentButton').click();
  }

  verifyPaymentConfirmation() {
    cy.get('#paymentConfirmation').should('be.visible');
  }

  logout() {
    cy.get('#logoutButton').click();
  }

  verifyLogout() {
    cy.get('#loginScreen').should('be.visible');
  }

  checkNotifications() {
    cy.get('#notifications').should('be.visible');
  }

  switchOrientation(orientation) {
    cy.viewport(orientation === 'landscape' ? 'iphone-6+' : 'iphone-6');
  }

  verifyLayout() {
    cy.get('#appLayout').should('be.visible');
  }

  testNetworkPerformance() {
    cy.intercept('GET', '/api/data', { delay: 1000 }).as('slowNetwork');
    cy.wait('@slowNetwork');
  }

  verifyDataSynchronization() {
    cy.get('#syncStatus').should('contain', 'Synchronized');
  }

  checkAppResponsiveness() {
    cy.get('#app').should('have.css', 'transition', 'all 0.3s ease');
  }

  verifySecurityMeasures() {
    cy.get('#securityCheck').should('contain', 'Secure');
  }

  testErrorHandling() {
    cy.get('#errorButton').click();
    cy.get('#errorMessage').should('be.visible');
  }
}