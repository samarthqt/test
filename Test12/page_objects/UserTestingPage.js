import { expect } from 'chai';

class UserTestingPage {
  
  static visitPage(url) {
    cy.visit(url);
  }

  static conductUserTesting() {
    cy.get('#user-test').should('be.visible');
  }

  static testNavigation() {
    cy.get('#navigation-test').click();
  }

  static verifyNavigationEase() {
    cy.get('.ease-of-use').should('exist');
  }

  static verifyPageTitle(expectedTitle) {
    cy.title().should('eq', expectedTitle);
  }

  static fillForm(fieldSelector, value) {
    cy.get(fieldSelector).type(value);
  }

  static submitForm(formSelector) {
    cy.get(formSelector).submit();
  }

  static verifyFormSubmissionSuccess(successMessageSelector) {
    cy.get(successMessageSelector).should('contain.text', 'Success');
  }

  static clickButton(buttonSelector) {
    cy.get(buttonSelector).click();
  }

  static verifyElementVisible(elementSelector) {
    cy.get(elementSelector).should('be.visible');
  }

  static verifyElementExists(elementSelector) {
    cy.get(elementSelector).should('exist');
  }

  static verifyUrlContains(text) {
    cy.url().should('include', text);
  }
}

export default UserTestingPage;