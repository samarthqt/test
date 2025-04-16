describe('Product Filtering with Invalid Data', () => {
  beforeEach(() => {
    cy.login(); // Assume cy.login() is a custom command for logging in
    cy.visit('/products');
  });

  it('should display error for invalid price range', () => {
    ProductPage.selectFilterOption();
    ProductPage.setPriceRange('-10', '0');
    ProductPage.getErrorMessage().should('contain', 'invalid price range');
  });

  it('should display error or no products for non-existent brand', () => {
    ProductPage.selectFilterOption();
    ProductPage.selectBrand('NonExistentBrand');
    ProductPage.getErrorMessageOrNoProducts().should('exist');
  });

  it('should display error or no products for non-existent category', () => {
    ProductPage.selectFilterOption();
    ProductPage.selectCategory('NonExistentCategory');
    ProductPage.getErrorMessageOrNoProducts().should('exist');
  });

  it('should display error for invalid rating', () => {
    ProductPage.selectFilterOption();
    ProductPage.setRating(6);
    ProductPage.getErrorMessage().should('contain', 'invalid rating');
  });
});