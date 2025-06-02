import { should } from 'chai';

class ErrorPage {
  static verifyErrorMessageDisplayed() {
    cy.get('#errorMessage').should('be.visible');
  }

  static verifyRetryOrContactOptions() {
    cy.get('#retryBtn').should('be.visible');
    cy.get('#contactSupportBtn').should('be.visible');
  }

  static retryGettingQuotes() {
    cy.get('#retryBtn').click();
  }

  static verifyErrorMessageContent(expectedMessage) {
    cy.get('#errorMessage').should('contain.text', expectedMessage);
  }

  static contactSupport() {
    cy.get('#contactSupportBtn').click();
  }

  static verifyPageTitle(expectedTitle) {
    cy.title().should('eq', expectedTitle);
  }

  static captureScreenshot(filename) {
    cy.screenshot(filename);
  }
}

export default ErrorPage;