class DiscussionPage {
  navigateToDiscussionSection() {
    cy.get('.discussion-section').click();
  }

  initiateDiscussion() {
    cy.get('.initiate-discussion-btn').click();
  }

  verifyDiscussionPostAllowed() {
    cy.get('.post-discussion-btn').should('be.enabled');
  }

  postDiscussion() {
    cy.get('.post-discussion-btn').click();
  }

  viewDiscussion() {
    cy.get('.view-discussion-link').click();
  }

  provideFeedback() {
    cy.get('.feedback-input').type('Great job!');
    cy.get('.submit-feedback-btn').click();
  }

  verifyFeedbackNotification() {
    cy.get('.notification').should('contain', 'You have new feedback');
  }

  verifyFeedbackVisible() {
    cy.get('.discussion-thread').should('contain', 'Great job!');
  }

  receiveFeedback() {
    cy.get('.feedback-received').should('exist');
  }

  reviewFeedback() {
    cy.get('.review-feedback-btn').click();
  }

  updateApproach() {
    cy.get('.update-approach-input').type('Updated approach based on feedback');
    cy.get('.submit-updated-approach-btn').click();
  }

  verifyUpdatedApproachPost() {
    cy.get('.discussion-thread').should('contain', 'Updated approach based on feedback');
  }

  verifyUpdatedApproachVisible() {
    cy.get('.discussion-thread').should('contain', 'Updated approach based on feedback');
  }

  receiveMultipleFeedback() {
    cy.get('.multiple-feedback').should('exist');
  }

  findHelpfulFeedback() {
    cy.get('.feedback-entry').contains('helpful').click();
  }

  markFeedbackHelpful() {
    cy.get('.mark-helpful-btn').click();
  }

  verifyFeedbackHighlighted() {
    cy.get('.feedback-entry-helpful').should('have.class', 'highlighted');
  }

  receiveMultipleDiscussionFeedback() {
    cy.get('.feedback-summary').should('exist');
  }

  navigateToFeedbackSummary() {
    cy.get('.feedback-summary-section').click();
  }

  verifyFeedbackSummary() {
    cy.get('.feedback-summary-content').should('exist');
  }

  verifyFeedbackStatistics() {
    cy.get('.feedback-statistics').should('contain', 'Most helpful feedback');
  }
}

export default DiscussionPage;