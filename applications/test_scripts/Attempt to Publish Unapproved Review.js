describe('TC-66142 Attempt to Publish Unapproved Review', () => {
  const reviewPage = new ReviewPage();

  before(() => {
    cy.loginAsModerator();
  });

  it('should not display unapproved review on product page', () => {
    reviewPage.visitProductPage();
    reviewPage.verifyReviewNotVisible(103);
  });

  it('should display error when attempting to publish unapproved review', () => {
    reviewPage.attemptToPublishReview(103);
    reviewPage.verifyPublishErrorMessage();
  });
});