describe('Wishlist Functionality', () => {
  beforeEach(() => {
    cy.visit('/wishlist'); // Navigate to the user's wishlist page
  });

  it('should remove a product from the wishlist', () => {
    const productId = 'ABC123';

    // Verify product is visible in the wishlist
    cy.getWishlistPage().getProductById(productId).should('be.visible');

    // Click on the 'Remove from Wishlist' button
    cy.getWishlistPage().removeProductById(productId);

    // Verify confirmation message
    cy.getWishlistPage().getConfirmationMessage().should('contain', 'has been removed from the wishlist');

    // Refresh the wishlist page
    cy.reload();

    // Verify product is no longer in the wishlist
    cy.getWishlistPage().getProductById(productId).should('not.exist');
  });

  it('should display an error when removing a non-existent product', () => {
    const nonExistentProductId = 'XYZ789';

    // Attempt to remove a product not present in the wishlist
    cy.getWishlistPage().removeProductById(nonExistentProductId);

    // Verify error message
    cy.getWishlistPage().getErrorMessage().should('contain', 'product is not found in the wishlist');
  });
});