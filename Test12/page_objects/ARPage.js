import { ARPage } from './page_objects/ARPage.js';

class ARPage {
  static visitProductPage() {
    cy.visit('/product');
  }

  static checkARSupport() {
    cy.get('.ar-support').should('exist');
  }

  static verifyARFeatureAccessible() {
    cy.get('.ar-feature').should('be.visible');
  }

  static accessARFeature() {
    cy.get('.ar-feature').click();
  }

  static viewProductInAR() {
    cy.get('.ar-view').should('be.visible');
  }

  static verifyRealismAndAccuracy() {
    cy.get('.ar-realism').should('contain', 'realistic');
  }

  static openARInterface() {
    cy.get('.ar-interface').click();
  }

  static interactWithARControls() {
    cy.get('.ar-controls').click();
  }

  static verifyInterfaceIntuitiveness() {
    cy.get('.ar-intuitive').should('exist');
  }

  static useARFeature() {
    cy.get('.ar-feature').click();
  }

  static navigateARExperience() {
    cy.get('.ar-experience').click();
  }

  static verifySystemPerformance() {
    cy.get('.ar-performance').should('contain', 'smooth');
  }

  static encounterIssue() {
    cy.get('.ar-issue').should('exist');
  }

  static seekTroubleshootingSupport() {
    cy.get('.troubleshooting-support').click();
  }

  static verifyTroubleshootingSupport() {
    cy.get('.support-adequate').should('exist');
  }
}

export default ARPage;