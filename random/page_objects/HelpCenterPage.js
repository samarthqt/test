class HelpCenterPage {
  visitMainMenu() {
    cy.visit('/main-menu');
  }

  selectHelpCenter() {
    cy.get('button[aria-label="Help Center"]').click();
  }

  verifyHelpCenterAccessible() {
    cy.url().should('include', '/help-center');
  }

  viewFAQsSection() {
    cy.get('.faqs-section').should('contain', '90% of common user queries');
  }

  viewTroubleshootingGuidesSection() {
    cy.get('.troubleshooting-guides-section').should('contain', 'comprehensive and up-to-date');
  }

  searchFAQsAndGuides(keywords) {
    cy.get('input[aria-label="Search FAQs and guides"]').type(keywords);
    cy.get('.search-results').should('contain', 'relevant to the keywords');
  }

  verifyHelpCenterResponsive() {
    cy.get('.help-center').should('be.visible');
    cy.get('.help-center').should('have.css', 'transition-duration', '2s');
  }
}