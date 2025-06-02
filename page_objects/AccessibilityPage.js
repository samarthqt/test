import { simulateHighLoad, simulateLowBandwidth, simulateDisabilities } from '../helpers/simulations';
import { checkColorContrast, checkImagesForAltText } from '../helpers/accessibilityChecks';

class AccessibilityPage {
  static visit() {
    cy.visit('/user-interface');
  }

  static simulateHighLoad() {
    simulateHighLoad();
  }

  static visitMobile() {
    cy.viewport('iphone-x');
    cy.visit('/user-interface');
  }

  static simulateLowBandwidth() {
    simulateLowBandwidth();
  }

  static enableAccessibilityFeatures() {
    cy.get('#enable-accessibility').click();
  }

  static useScreenReader() {
    cy.get('body').trigger('keydown', { keyCode: 9 });
  }

  static navigateWithKeyboard() {
    cy.get('body').tab();
  }

  static checkColorContrast() {
    checkColorContrast();
  }

  static checkImagesForAltText() {
    checkImagesForAltText();
  }

  static useVoiceCommands() {
    cy.get('#voice-command-input').type('open menu');
  }

  static accessForms() {
    cy.get('form').should('be.visible');
  }

  static verifyCompliance() {
    cy.get('#compliance-status').should('contain', 'compliant');
  }

  static simulateDisabilities() {
    simulateDisabilities();
  }

  static checkDocumentation() {
    cy.get('#documentation').should('contain', 'accessibility');
  }

  static accessWithDifferentRoles() {
    cy.loginAs('admin');
    cy.visit('/user-interface');
  }

  static verifyAccessibilityEnabled() {
    cy.get('#accessibility-status').should('contain', 'enabled');
  }

  static verifyScreenReaderCompatibility() {
    this.useScreenReader();
    cy.get('#screen-reader-compatible').should('exist');
  }

  static verifyKeyboardNavigation() {
    this.navigateWithKeyboard();
    cy.focused().should('have.attr', 'tabindex');
  }

  static verifyColorContrast() {
    this.checkColorContrast();
    cy.get('#color-contrast').should('be.visible');
  }

  static verifyAltTextForImages() {
    this.checkImagesForAltText();
    cy.get('img').each(($img) => {
      cy.wrap($img).should('have.attr', 'alt');
    });
  }

  static verifyVoiceCommands() {
    this.useVoiceCommands();
    cy.get('#voice-command-status').should('contain', 'success');
  }

  static verifyFormsAccessibility() {
    this.accessForms();
    cy.get('form').should('have.attr', 'aria-label');
  }

  static verifyHighLoadAccessibility() {
    this.simulateHighLoad();
    cy.get('#high-load').should('contain', 'accessible');
  }

  static verifyGuidelineCompliance() {
    this.verifyCompliance();
    cy.get('#guideline-compliance').should('contain', 'passed');
  }

  static verifyMobileAccessibility() {
    this.visitMobile();
    cy.get('#mobile-accessibility').should('contain', 'enabled');
  }

  static verifyDisabilitySimulations() {
    this.simulateDisabilities();
    cy.get('#disability-simulation').should('contain', 'successful');
  }

  static verifyDocumentation() {
    this.checkDocumentation();
    cy.get('#documentation-check').should('contain', 'complete');
  }

  static verifyRoleAccessibility() {
    this.accessWithDifferentRoles();
    cy.get('#role-accessibility').should('contain', 'accessible');
  }

  static verifyDefaultAccessibilityFeatures() {
    this.enableAccessibilityFeatures();
    cy.get('#default-accessibility').should('contain', 'enabled');
  }

  static verifyLowBandwidthAccessibility() {
    this.simulateLowBandwidth();
    cy.get('#low-bandwidth').should('contain', 'functional');
  }
}

export default AccessibilityPage;