class FeedbackPage {
  navigateToCustomerService() {
    cy.get('#customer-service-link').click();
  }

  verifyFeedbackOptionVisible() {
    cy.get('#feedback-option').should('be.visible');
  }

  navigateToFeedbackForm() {
    cy.get('#feedback-form-link').click();
  }

  enterFeedbackComments(comments) {
    cy.get('#feedback-comments').type(comments);
  }

  submitFeedbackForm() {
    cy.get('#submit-feedback').click();
  }

  verifyFeedbackSubmissionSuccess() {
    cy.get('#feedback-success-message').should('contain', 'Feedback submitted successfully');
  }

  verifyFeedbackSubmissionError() {
    cy.get('#feedback-error-message').should('contain', 'Feedback not submitted');
  }

  verifyFeedbackPrompt() {
    cy.get('#feedback-prompt').should('contain', 'Please enter feedback comments');
  }

  navigateToFeedbackHistory() {
    cy.get('#feedback-history-link').click();
  }

  verifyFeedbackHistoryVisible() {
    cy.get('#feedback-history-list').should('be.visible');
  }

  selectFeedbackEntry() {
    cy.get('#feedback-entry-1').click();
  }

  editFeedbackComments(updatedComments) {
    cy.get('#feedback-comments').clear().type(updatedComments);
  }

  verifyFeedbackUpdateSuccess() {
    cy.get('#feedback-update-success-message').should('contain', 'Feedback updated successfully');
  }
}

export default FeedbackPage;