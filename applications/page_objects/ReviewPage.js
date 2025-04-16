class ReviewPage {
  visitProductPage() {
    cy.visit('/product-page');
  }

  verifyReviewNotVisible(reviewId) {
    cy.get(`#review-${reviewId}`).should('not.exist');
  }

  attemptToPublishReview(reviewId) {
    cy.get(`#publish-review-${reviewId}`).click();
  }

  verifyPublishErrorMessage() {
    cy.get('.error-message').should('contain', 'The review must be approved before publishing');
  }
}

export default ReviewPage;