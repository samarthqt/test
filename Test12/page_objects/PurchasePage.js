import { Selector } from 'testcafe';

class PurchasePage {
  constructor() {
    this.purchaseButton = Selector('#completePurchaseBtn');
    this.purchaseFlow = Selector('#purchaseFlow');
    this.desktopUrl = '/purchase-desktop';
    this.mobileUrl = '/purchase-mobile';
  }

  visitDesktop() {
    cy.visit(this.desktopUrl);
  }

  completePurchase() {
    cy.get(this.purchaseButton).click();
  }

  verifyMobileFlow() {
    cy.visit(this.mobileUrl);
    cy.get(this.purchaseFlow).should('have.class', 'identical');
  }
}

export default PurchasePage;