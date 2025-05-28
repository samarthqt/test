import { expect } from 'chai';

class UserReviewsPage {
  static navigateToPage(page) {
    cy.visit(`/${page.toLowerCase().replace(/ /g, '-')}`);
  }

  static navigateToProductPage() {
    cy.visit('/product-page');
  }

  static verifyOnProductPage() {
    cy.url().should('include', '/product-page');
  }

  static selectCompletedPurchase() {
    cy.get('.completed-purchase').click();
  }

  static clickButton(button) {
    cy.contains(button).click();
  }

  static verifyReviewFormIsPresent() {
    cy.get('#review-form').should('be.visible');
  }

  static enterRating(rating) {
    cy.get(`.star-rating[data-value=\${rating}\]`).click();
  }

  static enterFeedback(feedback) {
    cy.get('#feedback-section').type(feedback);
  }

  static submitReview() {
    cy.get('#submit-review').click();
  }

  static verifyReviewIsDisplayed(content = 'Great product!') {
    cy.get('.review-display').should('contain', content);
  }

  static verifyReviewModification() {
    cy.get('#modify-review').should('be.visible');
  }

  static submitUpdatedReview() {
    cy.get('#submit-updated-review').click();
  }

  static verifyUpdatedReview(content = 'Updated review content') {
    cy.get('.review-display').should('contain', content);
  }

  static verifyDeletionPrompt() {
    cy.get('.deletion-prompt').should('be.visible');
  }

  static confirmDeletion() {
    cy.get('#confirm-deletion').click();
  }

  static verifyReviewIsRemoved() {
    cy.get('.review-display').should('not.exist');
  }

  static verifyExistingReviews() {
    cy.get('.existing-reviews').should('be.visible');
  }

  static verifyAverageRating() {
    cy.get('.average-rating').should('be.visible');
  }

  static verifyIndividualReviews() {
    cy.get('.individual-reviews').should('be.visible');
  }

  static attemptReviewWithoutPurchase() {
    cy.get('#leave-review').click();
  }

  static verifyPurchaseRequirementNotification() {
    cy.get('.purchase-required-notification').should('be.visible');
  }
}

export default UserReviewsPage;