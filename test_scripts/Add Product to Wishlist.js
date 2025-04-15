describe('Add Product to Wishlist', () => {
  const productId = 'ABC123';
  const userId = '12345';

  before(() => {
    cy.login(userId);
  });

  it('should navigate to the product page and verify details', () => {
    cy.visit(`/product/${productId}`);
    cy.get(ProductPage.productDetails).should('be.visible');
  });

  it('should add product to wishlist and verify confirmation message', () => {
    cy.get(ProductPage.addToWishlistButton).click();
    cy.get(ProductPage.confirmationMessage).should('contain', 'added to the wishlist');
  });

  it('should verify product in wishlist', () => {
    cy.visit('/wishlist');
    cy.get(WishlistPage.productDetails(productId)).should('be.visible');
  });

  it('should verify product details match on wishlist and product page', () => {
    cy.get(WishlistPage.productDetails(productId)).then(wishlistDetails => {
      cy.visit(`/product/${productId}`);
      cy.get(ProductPage.productDetails).should('have.text', wishlistDetails.text());
    });
  });

  it('should prevent adding duplicate product to wishlist', () => {
    cy.visit(`/product/${productId}`);
    cy.get(ProductPage.addToWishlistButton).click();
    cy.get(ProductPage.duplicateMessage).should('contain', 'already in the wishlist');
  });
});