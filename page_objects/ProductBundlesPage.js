class ProductBundlesPage {
  navigateToProductBundles() {
    cy.visit('/product-bundles');
  }

  verifyOnProductBundlesPage() {
    cy.url().should('include', '/product-bundles');
  }

  selectBundle(bundleName) {
    cy.contains(bundleName).click();
  }

  verifyBundleSelected(bundleName) {
    cy.get('.bundle-details').should('contain', bundleName);
  }

  verifyDiscountedPrice() {
    cy.get('.discounted-price').then(($price) => {
      const discountedPrice = parseFloat($price.text().replace('$', ''));
      cy.get('.individual-prices').each(($el) => {
        const individualPrice = parseFloat($el.text().replace('$', ''));
        expect(discountedPrice).to.be.lessThan(individualPrice);
      });
    });
  }

  addBundleToCart() {
    cy.get('.add-to-cart').click();
  }
}

class ShoppingCartPage {
  verifyBundleInCart(bundleName) {
    cy.get('.cart-items').should('contain', bundleName);
  }

  verifyDiscountedPriceInCart(bundleName) {
    cy.get('.cart-item').contains(bundleName).parent().find('.price').then(($price) => {
      const cartPrice = parseFloat($price.text().replace('$', ''));
      cy.get('.individual-prices').each(($el) => {
        const individualPrice = parseFloat($el.text().replace('$', ''));
        expect(cartPrice).to.be.lessThan(individualPrice);
      });
    });
  }
}