import { Selector } from 'testcafe';

class page_objects/AccessibilityPage {

  static useAssistiveTech() {
    cy.get('body').invoke('attr', 'aria-label').should('exist');
  }

  static interactWithApp() {
    cy.get('#main-content').focus();
  }

  static verifyAccessibilityStandards() {
    cy.get(\[role='button']\).should('have.attr', 'aria-pressed');
  }

  static checkAltTextForImages() {
    cy.get('img').each(($el) => {
      cy.wrap($el).should('have.attr', 'alt');
    });
  }

  static ensureKeyboardNavigation() {
    cy.get('a, button, input, select, textarea').each(($el) => {
      cy.wrap($el).focus().should('be.focused');
    });
  }

  static validateColorContrast() {
    cy.get('body').should('have.css', 'color-contrast', '4.5:1');
  }

  static checkFormLabels() {
    cy.get('input, select, textarea').each(($el) => {
      const id = $el.attr('id');
      if (id) {
        cy.get(`label[for='${id}']`).should('exist');
      }
    });
  }

  static verifyAriaRoles() {
    cy.get('[role]').each(($el) => {
      cy.wrap($el).invoke('attr', 'role').should('not.be.empty');
    });
  }

}

export default page_objects/AccessibilityPage;