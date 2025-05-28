import { expect } from 'chai';
import { Cypress } from 'cypress';

class WishlistPage {
  static login(username, password) {
    cy.visit('/login');
    cy.get('#username').type(username);
    cy.get('#password').type(password);
    cy.get('#loginBtn').click();
  }

  static logout() {
    cy.get('#logoutBtn').click();
  }

  static visitProductPage() {
    cy.visit('/product');
  }

  static addToWishlist() {
    cy.get('#addToWishlistBtn').click();
  }

  static verifyProductAdded(productName) {
    cy.get('#wishlist').should('contain', productName);
  }

  static verifyConfirmationMessage() {
    cy.get('#confirmationMessage').should('be.visible');
  }

  static verifyProductsInWishlist() {
    cy.get('#wishlist').should('not.be.empty');
  }

  static visitWishlistPage() {
    cy.visit('/wishlist');
  }

  static verifyWishlistProducts() {
    cy.get('#wishlist').children().should('have.length.at.least', 1);
  }

  static removeProduct(productName) {
    cy.get(`#removeBtn[data-product=${productName}]`).click();
  }

  static verifyProductRemoved(productName) {
    cy.get('#wishlist').should('not.contain', productName);
  }

  static attemptAddToWishlist() {
    cy.get('#addToWishlistBtn').click();
  }

  static verifyLoginPrompt() {
    cy.get('#loginPrompt').should('be.visible');
  }

  static verifyWishlistPersistence() {
    cy.get('#wishlist').children().should('have.length.at.least', 1);
  }

  static verifyProductAlreadyInWishlist(productName) {
    cy.get('#wishlist').should('contain', productName);
  }

  static attemptAddDuplicateProduct() {
    cy.get('#addToWishlistBtn').click();
  }

  static verifyNoDuplicateEntries() {
    cy.get('#wishlist').children().should('have.length', 1);
  }

  static verifyDuplicateMessage() {
    cy.get('#duplicateMessage').should('be.visible');
  }
}

export default WishlistPage;