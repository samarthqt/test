import { expect } from 'chai';

class ARTryOnPage {

  static visit() {
    cy.visit('/ar-try-on');
  }

  static login() {
    cy.get('#login').click();
    cy.get('#username').type('user');
    cy.get('#password').type('password');
    cy.get('#submit').click();
  }

  static verifyMainInterface() {
    cy.get('#main-interface').should('be.visible');
  }

  static verifyLogin() {
    cy.get('#logged-in').should('exist');
  }

  static navigateToProductCatalog() {
    cy.get('#product-catalog').click();
  }

  static verifyProductCatalog() {
    cy.get('#catalog').should('be.visible');
  }

  static selectProduct() {
    cy.get('.ar-product').first().click();
  }

  static verifyProductDetailsPage() {
    cy.get('#product-details').should('be.visible');
  }

  static activateARTryOn() {
    cy.get('#activate-ar').click();
  }

  static verifyARTryOnInterface() {
    cy.get('#ar-interface').should('be.visible');
  }

  static alignProductWithImage() {
    cy.get('#align-product').click();
  }

  static verifyAlignment() {
    cy.get('#alignment-success').should('exist');
  }

  static verifyMultipleProductsAccess() {
    cy.get('.ar-products').should('have.length.greaterThan', 1);
  }

  static testARTryOnWithDifferentProducts() {
    cy.get('.ar-product').each(($el) => {
      cy.wrap($el).click();
      cy.get('#ar-interface').should('be.visible');
    });
  }

  static verifyConsistencyAcrossProducts() {
    cy.get('#consistency-report').should('exist');
  }

  static evaluateRealismAndAccuracy() {
    cy.get('#evaluate-realism').click();
  }

  static verifyRealismAndAccuracy() {
    cy.get('#realism-accurate').should('exist');
  }

  static checkForPerformanceIssues() {
    cy.get('#performance-check').click();
  }

  static verifyNoPerformanceIssues() {
    cy.get('#no-performance-issues').should('exist');
  }

  static testInDifferentLightingConditions() {
    cy.get('#test-lighting').click();
  }

  static verifyPerformanceInLightingConditions() {
    cy.get('#lighting-performance').should('exist');
  }

  static verifyNoCameraDevice() {
    cy.get('#no-camera').should('exist');
  }

  static attemptARTryOnWithoutCamera() {
    cy.get('#try-on').click();
  }

  static verifyCameraRequirementMessage() {
    cy.get('#camera-required').should('exist');
  }

  static verifyARTryOnDisabled() {
    cy.get('#ar-disabled').should('exist');
  }

  static attemptARTryOnWhenDisabled() {
    cy.get('#try-on').click();
  }

  static verifyARTryOnNotAvailableMessage() {
    cy.get('#try-on-not-available').should('exist');
  }

  static checkARTryOnContent() {
    cy.get('#check-content').click();
  }

  static verifyContentAccuracy() {
    cy.get('#content-current').should('exist');
  }

  static verifyTestingARTryOn() {
    cy.get('#testing-ar').should('exist');
  }

  static observeIssues() {
    cy.get('#observe-issues').click();
  }

  static documentIssuesAndSuggestions() {
    cy.get('#document-issues').should('exist');
  }

  static verifyCompletedTesting() {
    cy.get('#completed-testing').should('exist');
  }

  static concludeTest() {
    cy.get('#conclude-test').click();
  }

  static createEvaluationReport() {
    cy.get('#evaluation-report').should('exist');
  }

  static verifyCompletedEvaluation() {
    cy.get('#completed-evaluation').should('exist');
  }

  static provideFeedbackAndSuggestions() {
    cy.get('#feedback').click();
  }

  static verifyFeedbackDocumentation() {
    cy.get('#feedback-documented').should('exist');
  }

}

export default ARTryOnPage;