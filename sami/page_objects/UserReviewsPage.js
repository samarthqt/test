class UserReviewsPage {
  login() {
    cy.get('#loginButton').click();
  }

  completePurchase() {
    cy.get('#completePurchaseButton').click();
  }

  visitOrderHistory() {
    cy.visit('/order-history');
  }

  selectCompletedPurchase() {
    cy.get('.completed-purchase').first().click();
  }

  clickLeaveReview() {
    cy.get('.leave-review-button').click();
  }

  verifyReviewForm() {
    cy.get('#reviewForm').should('be.visible');
  }

  enterRating(stars) {
    cy.get('.rating-stars').select(stars);
  }

  enterFeedback(comment) {
    cy.get('#feedbackSection').type(comment);
  }

  submitReview() {
    cy.get('#submitReviewButton').click();
  }

  verifyReviewSaved() {
    cy.get('.review').should('contain', 'Great product!');
  }

  submitInitialReview() {
    this.enterRating(4);
    this.enterFeedback('Good product.');
    this.submitReview();
  }

  visitProductPage() {
    cy.visit('/product-page');
  }

  clickEditReview() {
    cy.get('.edit-review-button').click();
  }

  modifyReview() {
    this.enterRating(3);
    this.enterFeedback('Updated feedback.');
  }

  submitUpdatedReview() {
    cy.get('#submitUpdatedReviewButton').click();
  }

  verifyUpdatedReview() {
    cy.get('.review').should('contain', 'Updated feedback.');
  }

  clickDeleteReview() {
    cy.get('.delete-review-button').click();
  }

  verifyDeletePrompt() {
    cy.get('#deletePrompt').should('be.visible');
  }

  confirmDeletion() {
    cy.get('#confirmDeleteButton').click();
  }

  verifyReviewRemoved() {
    cy.get('.review').should('not.exist');
  }

  checkExistingReviews() {
    cy.get('.reviews').should('exist');
  }

  verifyAverageRating() {
    cy.get('.average-rating').should('be.visible');
  }

  verifyIndividualReviews() {
    cy.get('.individual-review').should('be.visible');
  }

  browseProductPage() {
    cy.visit('/product-page');
  }

  attemptLeaveReviewWithoutPurchase() {
    cy.get('.leave-review-button').click();
  }

  verifyPurchaseNotification() {
    cy.get('.notification').should('contain', 'Only verified purchasers can leave reviews');
  }
}

export default UserReviewsPage;