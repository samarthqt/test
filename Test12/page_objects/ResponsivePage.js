import { Selector } from 'testcafe'; 
class ResponsivePage {
  static useDifferentScreenSizes(size) {
    cy.viewport(size);
  }

  static viewApplication(url = '/') {
    cy.visit(url);
  }

  static verifyUIResponsiveness(selector = '.responsive-element') {
    cy.get(selector).should('be.visible');
  }

  static clickElement(selector) {
    cy.get(selector).click();
  }

  static inputText(selector, text) {
    cy.get(selector).type(text);
  }

  static assertText(selector, expectedText) {
    cy.get(selector).should('have.text', expectedText);
  }

  static assertElementExists(selector) {
    cy.get(selector).should('exist');
  }

  static assertElementNotExists(selector) {
    cy.get(selector).should('not.exist');
  }

  static assertElementVisible(selector) {
    cy.get(selector).should('be.visible');
  }

  static assertElementNotVisible(selector) {
    cy.get(selector).should('not.be.visible');
  }

  static assertElementEnabled(selector) {
    cy.get(selector).should('be.enabled');
  }

  static assertElementDisabled(selector) {
    cy.get(selector).should('be.disabled');
  }

  static selectDropdownOption(selector, option) {
    cy.get(selector).select(option);
  }

  static assertDropdownSelectedOption(selector, expectedOption) {
    cy.get(selector).should('have.value', expectedOption);
  }

  static scrollToElement(selector) {
    cy.get(selector).scrollIntoView();
  }
}
export default ResponsivePage;