import { should } from 'chai';

class WishlistPage {
  static visit() {
    cy.visit('/wishlist');
  }

  static addProductToWishlist(productName) {
    cy.get('.product-list').contains(productName).parent().find('.add-to-wishlist').click();
  }

  static removeProductFromWishlist(productName) {
    cy.get('.wishlist-items').contains(productName).parent().find('.remove-from-wishlist').click();
  }

  static verifyProductInWishlist(productName) {
    cy.get('.wishlist-items').should('contain', productName);
  }

  static verifyProductNotInWishlist(productName) {
    cy.get('.wishlist-items').should('not.contain', productName);
  }

  static verifyWishlistUpdated() {
    cy.contains('Wishlist updated').should('be.visible');
  }

  static manageWishlist() {
    cy.get('#addProduct').click();
    cy.get('#removeProduct').click();
  }
}

export default WishlistPage;