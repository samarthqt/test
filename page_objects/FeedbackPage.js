class FeedbackPage {
  enterFeedbackText(text) {
    cy.get('#feedback-textarea').type(text);
  }

  selectStarRating(rating) {
    cy.get(`.star-rating [data-rating='${rating}']`).click();
  }

  submitFeedback() {
    cy.get('#submit-feedback').click();
  }

  verifyFeedbackSubmission() {
    cy.get('.confirmation-message').should('contain', 'Feedback submitted successfully');
  }
}

export default FeedbackPage;