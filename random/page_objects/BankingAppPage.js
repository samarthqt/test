class BankingAppPage {
  openApp() {
    cy.visit('/');
  }

  verifyAppLoadTime(maxTime) {
    cy.window().then((win) => {
      const loadTime = win.performance.timing.domContentLoadedEventEnd - win.performance.timing.navigationStart;
      expect(loadTime).to.be.lessThan(maxTime);
    });
  }

  login() {
    cy.get('#username').type('user');
    cy.get('#password').type('password');
    cy.get('#loginButton').click();
  }

  navigateToAccountSection() {
    cy.get('#accountSection').click();
  }

  verifyCheckBalancesSteps() {
    cy.get('#balance').should('be.visible');
  }

  selectTransferFundsOption() {
    cy.get('#transferFunds').click();
  }

  verifyTransferFundsSteps() {
    cy.get('#transferConfirmation').should('be.visible');
  }

  selectPayBillsOption() {
    cy.get('#payBills').click();
  }

  verifyPayBillsSteps() {
    cy.get('#paymentConfirmation').should('be.visible');
  }

  viewOnTabletOrDesktop() {
    // Assume this adjusts viewport for testing
  }

  verifyResponsiveDesign() {
    cy.get('body').should('have.class', 'responsive');
  }

  navigateThroughApp() {
    cy.get('#menu').click();
  }

  verifyIntuitiveUI() {
    cy.get('#navigation').should('be.visible');
  }

  accessVariousFunctionalities() {
    cy.get('#features').click();
  }

  verifyAllFunctionalitiesAccessible() {
    cy.get('#mobileFeatures').should('contain', 'All Features Available');
  }
}

export default BankingAppPage;