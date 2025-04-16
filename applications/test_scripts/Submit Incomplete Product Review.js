describe('Submit Incomplete Product Review', () => {
  beforeEach(() => {
    cy.login('user202', 'password');
    cy.visit('/product/101');
  });

  it('should display error when submitting an empty review text', () => {
    const productPage = new ProductPage();
    productPage.clickWriteReview();
    productPage.submitReview('', 5);
    productPage.getErrorMessage().should('contain', 'Review text is required');
  });

  it('should display error when submitting a review without a rating', () => {
    const productPage = new ProductPage();
    productPage.clickWriteReview();
    productPage.submitReview('Great product!', null);
    productPage.getErrorMessage().should('contain', 'Rating is required');
  });

  it('should reject review with a rating of 0', () => {
    const productPage = new ProductPage();
    productPage.clickWriteReview();
    productPage.submitReview('Great product!', 0);
    productPage.getErrorMessage().should('contain', 'Invalid rating');
  });

  afterEach(() => {
    cy.checkSystemLogsForErrors();
  });
});