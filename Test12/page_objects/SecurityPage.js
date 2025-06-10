import { Selector } from 'testcafe';

class SecurityPage {
  constructor() {
    this.purchaseUrl = '/purchase';
    this.securityProtocolsButton = '#securityProtocols';
    this.securityStatus = '#securityStatus';
    this.securityAlert = '#securityAlert';
    this.securitySettings = '#securitySettings';
  }

  static initiatePurchase() {
    cy.visit(this.purchaseUrl);
  }

  static applySecurityProtocols() {
    cy.get(this.securityProtocolsButton).click();
  }

  static verifySecurityConsistency() {
    cy.get(this.securityStatus).should('contain', 'consistent');
  }

  static checkSecurityAlert() {
    cy.get(this.securityAlert).should('not.exist');
  }

  static openSecuritySettings() {
    cy.get(this.securitySettings).click();
  }

  static validateSecuritySettings(expectedSettings) {
    cy.get(this.securitySettings).should('contain', expectedSettings);
  }
}

export default SecurityPage;