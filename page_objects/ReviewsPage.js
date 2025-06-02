import { expect } from 'chai';

class ReviewsPage {
  static submitRating() {
    cy.get('.star-rating').click();
  }

  static verifyRatingSubmissionSuccess() {
    cy.get('.rating-success').should('be.visible');
  }

  static enterReviewText(text = 'Great product!') {
    cy.get('#reviewText').clear().type(text);
  }

  static submitReview() {
    cy.get('#submitReview').click();
  }

  static verifyReviewSubmissionSuccess() {
    cy.get('.review-success').should('be.visible');
  }

  static verifyReviewAndRatingSubmitted() {
    cy.get('.review-item').should('exist');
  }

  static editOrDeleteReview() {
    cy.get('.edit-review').click();
  }

  static verifyEditOrDeleteSuccess() {
    cy.get('.edit-success').should('be.visible');
  }

  static submitDuplicateReview() {
    cy.get('#submitReview').click();
  }

  static verifyDuplicateReviewPrevention() {
    cy.get('.duplicate-error').should('be.visible');
  }

  static startReviewSubmission() {
    cy.get('#reviewText').click();
  }

  static enterInappropriateLanguage() {
    cy.get('#reviewText').type('bad language');
  }

  static verifyInappropriateLanguageHandling() {
    cy.get('.language-warning').should('be.visible');
  }

  static viewReview() {
    cy.get('.review-item').click();
  }

  static verifyCorrectTimestamps(expectedYear = '2023') {
    cy.get('.timestamp').should('contain', expectedYear);
  }

  static verifyNotificationSent() {
    cy.get('.notification').should('be.visible');
  }

  static useModerationTools() {
    cy.get('.moderation-tools').click();
  }

  static verifyModerationToolsFunctionality() {
    cy.get('.moderation-success').should('be.visible');
  }
}

export default ReviewsPage;