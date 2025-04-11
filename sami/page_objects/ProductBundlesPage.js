class ProductBundlesPage {
  navigate() {
    cy.visit('/product-bundles');
  }

  selectProducts() {
    cy.get('.product-checkbox').check();
  }

  applyDiscount(discount) {
    cy.get('#discountField').type(discount);
    cy.get('#applyDiscountButton').click();
  }

  verifyDiscountedPrice() {
    cy.get('#totalPrice').should('contain', 'Discounted Price');
  }

  addToCart() {
    cy.get('#cart').should('contain', 'Product Bundle');
  }

  browseBundles() {
    cy.get('.bundle-list').should('be.visible');
  }

  verifyBundleDiscounts() {
    cy.get('.bundle-discount').should('contain', 'Discount');
  }

  editBundle() {
    cy.get('#editBundleButton').click();
  }

  updateProducts() {
    cy.get('.product-checkbox').uncheck();
    cy.get('.product-checkbox').check();
  }

  updateDiscount(discount) {
    cy.get('#discountField').clear().type(discount);
    cy.get('#applyDiscountButton').click();
  }

  verifyUpdatedBundle() {
    cy.get('#updatedBundle').should('contain', 'Updated Products');
  }

  verifyNewTotalPrice() {
    cy.get('#newTotalPrice').should('contain', 'New Price');
  }

  removeBundle() {
    cy.get('#removeBundleButton').click();
  }

  verifyBundleRemoved() {
    cy.get('#cart').should('not.contain', 'Product Bundle');
  }

  proceedToCheckout() {
    cy.get('#checkoutButton').click();
  }

  completePayment() {
    cy.get('#paymentForm').submit();
  }

  verifyPurchaseConfirmation() {
    cy.get('#confirmationMessage').should('contain', 'Purchase Confirmed');
  }

  verifyBundlePurchased() {
    cy.get('#purchasedBundles').should('contain', 'Purchased Bundle');
  }
}