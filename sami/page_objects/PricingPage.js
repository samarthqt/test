class PricingPage {
  visitPricingPage() {
    cy.visit('/product-pricing');
  }

  setOriginalPrice(price) {
    cy.get('#original-price').type(price);
  }

  setDiscount(discount) {
    cy.get('#discount').type(discount);
  }

  setNoDiscount() {
    cy.get('#discount').clear();
  }

  setMultipleProducts(products) {
    products.forEach(product => {
      cy.get(`#${product['Product Name']}-original-price`).type(product['Original Price']);
      cy.get(`#${product['Product Name']}-discount`).type(product['Discount']);
    });
  }

  setInvalidDiscount(invalidDiscount) {
    cy.get('#discount').type(invalidDiscount);
  }

  viewPricingDetails() {
    cy.get('#view-pricing-details').click();
  }

  calculateDiscountedPrice() {
    cy.get('#calculate-discounted-price').click();
  }

  verifyOriginalPrice(expectedPrice) {
    cy.get('#original-price-display').should('have.text', expectedPrice);
  }

  verifyDiscountedPrice(expectedPrice) {
    cy.get('#discounted-price-display').should('have.text', expectedPrice);
  }

  verifyNoDiscountedPrice() {
    cy.get('#discounted-price-display').should('not.exist');
  }

  verifyProductOriginalPrice(productName, expectedPrice) {
    cy.get(`#${productName}-original-price-display`).should('have.text', expectedPrice);
  }

  verifyProductDiscountedPrice(productName, expectedPrice) {
    cy.get(`#${productName}-discounted-price-display`).should('have.text', expectedPrice);
  }

  verifyCalculatedDiscountedPrice(expectedPrice) {
    cy.get('#calculated-discounted-price').should('have.text', expectedPrice);
  }

  verifyInvalidDiscountMessage(expectedMessage) {
    cy.get('#invalid-discount-message').should('have.text', expectedMessage);
  }
}

export default PricingPage;