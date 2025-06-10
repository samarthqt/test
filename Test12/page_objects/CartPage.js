import { login, logout } from '../helpers/authHelpers';

class CartPage {

  static visitProductPage() {
    cy.visit('/product');
  }

  static addProductToCart() {
    cy.get('#add-to-cart-button').click();
  }

  static verifyProductAdded() {
    cy.get('#cart').should('contain', 'Product Name');
  }

  static ensureProductsInCart() {
    cy.get('#cart').should('not.be.empty');
  }

  static removeProductFromCart() {
    cy.get('#remove-product-button').click();
  }

  static verifyProductRemoved() {
    cy.get('#cart').should('not.contain', 'Product Name');
  }

  static updateProductQuantity(quantity) {
    cy.get('#product-quantity').clear().type(quantity);
    cy.get('#update-quantity-button').click();
  }

  static verifyQuantityUpdated(expectedQuantity) {
    cy.get('#product-quantity').should('have.value', expectedQuantity.toString());
  }

  static viewCart() {
    cy.get('#view-cart-button').click();
  }

  static verifyCartDetails() {
    cy.get('#cart-details').should('contain', 'Product Name')
      .and('contain', 'Price')
      .and('contain', 'Quantity')
      .and('contain', 'Subtotal');
  }

  static modifyCart() {
    cy.get('#modify-cart-button').click();
  }

  static verifyImmediateChanges() {
    cy.get('#cart').should('contain', 'Updated Info');
  }

  static performInvalidOperation() {
    cy.get('#invalid-operation-button').click();
  }

  static executeOperation() {
    cy.get('#execute-operation-button').click();
  }

  static verifyErrorMessage() {
    cy.get('#error-message').should('be.visible');
  }

  static ensureLoggedInWithProducts() {
    login();
    cy.get('#cart').should('not.be.empty');
  }

  static logoutAndLogin() {
    logout();
    login();
  }

  static verifyCartSavedAcrossSessions() {
    cy.get('#cart').should('contain', 'Product Name');
  }

  static accessCart() {
    cy.get('#access-cart-button').click();
  }

  static interactWithCartInterface() {
    cy.get('#cart-interface').click();
  }

  static verifyUserFriendlyInterface() {
    cy.get('#cart-interface').should('be.visible');
  }

  static performCartOperations() {
    cy.get('#cart-operations-button').click();
  }

  static completeOperations() {
    cy.get('#complete-operations-button').click();
  }

  static verifyOperationsLogged() {
    cy.get('#operations-log').should('contain', 'Operation Details');
  }

  static verifyComplianceWithStandards() {
    cy.get('#compliance').should('contain', 'Privacy and Security Standards');
  }

}

export default CartPage;