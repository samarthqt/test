describe('Submit Product Review', () => {
  const productPage = new ProductPage();

  before(() => {
    cy.login('user202', 'password');
  });

  it('should navigate to the purchased product page', () => {
    productPage.visitProductPage(101);
    productPage.verifyProductDetailsDisplayed();
  });

  it('should display review submission form when clicking write review button', () => {
    productPage.clickWriteReviewButton();
    productPage.verifyReviewFormDisplayed();
  });

  it('should allow entering review text and selecting a rating', () => {
    productPage.enterReviewText('Great product!');
    productPage.selectRating(5);
  });

  it('should submit the review and display confirmation message', () => {
    productPage.submitReview();
    productPage.verifyReviewSubmissionSuccess();
  });

  it('should display submitted review under product reviews section after refresh', () => {
    cy.reload();
    productPage.verifyReviewDisplayed('Great product!', 5);
  });
});