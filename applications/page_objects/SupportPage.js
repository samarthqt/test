class SupportPage {
  verifyDashboardAccessible() {
    cy.get('.dashboard').should('be.visible');
  }

  navigateToDocumentation() {
    cy.get('.documentation-link').click();
  }
}

class DocumentationPage {
  verifyDocumentationOptionsDisplayed() {
    cy.get('.documentation-options').should('be.visible');
  }

  accessExtensiveDocumentation() {
    cy.get('.extensive-doc-link').click();
  }

  verifyExtensiveDocumentationAccessible() {
    cy.get('.extensive-documentation').should('be.visible');
  }

  verifyDocumentationComprehensiveness() {
    cy.get('.documentation-content').should('contain', 'extensive system functionalities and features');
  }

  verifySystemPerformance() {
    cy.window().then((win) => {
      expect(win.performance.now()).to.be.lessThan(1000);
    });
  }
}