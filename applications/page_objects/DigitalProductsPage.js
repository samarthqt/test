class DigitalProductsPage {
  visit() {
    cy.visit('/digital-products');
  }

  verifyPageLoaded() {
    cy.get('.products-list').should('be.visible');
  }

  selectProduct(productName) {
    cy.contains('.product-item', productName).click();
  }

  verifyNoRefundPolicyConsistency() {
    cy.get('.product-item').each(($el) => {
      cy.wrap($el).click();
      cy.get('.no-refund-policy').should('be.visible');
      cy.go('back');
    });
  }

  verifyNoRefundPolicyInMultipleLanguages() {
    cy.get('.language-selector').select('French');
    cy.get('.no-refund-policy').should('contain', 'Non remboursable');
  }

  verifyNoRefundPolicyDuringPromotions() {
    cy.get('.promotion-banner').should('be.visible');
    cy.get('.no-refund-policy').should('be.visible');
  }
}

class ProductDetailPage {
  verifyNoRefundPolicyVisible() {
    cy.get('.no-refund-policy').should('be.visible');
  }

  addToCart() {
    cy.get('.add-to-cart-button').click();
  }
}

class CartPage {
  verifyProductAddedWithNoRefundPolicy() {
    cy.get('.cart-item').should('contain', 'E-book');
    cy.get('.no-refund-policy').should('be.visible');
  }

  proceedToCheckout() {
    cy.get('.checkout-button').click();
  }
}

class CheckoutPage {
  verifyNoRefundPolicyInOrderSummary() {
    cy.get('.order-summary').should('contain', 'No refund policy');
  }

  completePurchase() {
    cy.get('.complete-purchase-button').click();
  }

  verifyNoRefundPolicyForGuestCheckout() {
    cy.get('.guest-checkout').click();
    cy.get('.no-refund-policy').should('be.visible');
  }
}

class OrderConfirmationPage {
  verifyNoRefundPolicyReiterated() {
    cy.get('.order-confirmation').should('contain', 'No refund policy');
  }
}

class EmailPage {
  verifyNoRefundPolicyInEmail() {
    cy.get('.email-content').should('contain', 'No refund policy');
  }
}

class CustomerServicePage {
  requestRefund(productName) {
    cy.get('.refund-request').click();
    cy.get('.product-name').select(productName);
    cy.get('.submit-refund').click();
  }

  verifyRefundDeniedDueToPolicy() {
    cy.get('.refund-status').should('contain', 'Refund denied');
  }

  requestReturn(productName) {
    cy.get('.return-request').click();
    cy.get('.product-name').select(productName);
    cy.get('.submit-return').click();
  }

  verifyReturnDeniedDueToPolicy() {
    cy.get('.return-status').should('contain', 'Return denied');
  }
}

class UserAccountPage {
  visitOrderHistory() {
    cy.visit('/user-account/order-history');
  }

  verifyNoRefundPolicyInOrderHistory() {
    cy.get('.order-history').should('contain', 'No refund policy');
  }
}