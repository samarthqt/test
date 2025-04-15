class WishlistPage {
  getProductById(productId) {
    return cy.get(`[data-product-id="${productId}"]`);
  }

  removeProductById(productId) {
    this.getProductById(productId).find('.remove-button').click();
  }

  getConfirmationMessage() {
    return cy.get('.confirmation-message');
  }

  getErrorMessage() {
    return cy.get('.error-message');
  }
}

module.exports = new WishlistPage();