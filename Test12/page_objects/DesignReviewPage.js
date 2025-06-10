import { expect } from 'chai';

class DesignReviewPage {
  static visit() {
    cy.visit('/design-review');
  }

  static reviewDesign() {
    cy.get('#design-review').should('be.visible');
  }

  static compareWithBranding() {
    cy.get('#branding-guidelines').should('exist');
  }

  static verifyDesignAlignment() {
    cy.get('.branding').should('have.class', 'aligned');
  }

  static validateDesignDetails(designDetails) {
    cy.get('.design-details').within(() => {
      cy.get('.title').should('contain.text', designDetails.title);
      cy.get('.description').should('contain.text', designDetails.description);
    });
  }

  static checkReviewStatus(expectedStatus) {
    cy.get('.review-status').should('have.text', expectedStatus);
  }

  static submitFeedback(feedback) {
    cy.get('#feedback-input').type(feedback);
    cy.get('#submit-feedback').click();
  }

  static ensureFeedbackSubmission() {
    cy.get('.feedback-confirmation').should('be.visible');
  }

  static navigateToSection(sectionId) {
    cy.get(`#${sectionId}`).scrollIntoView();
  }
}

export default DesignReviewPage;