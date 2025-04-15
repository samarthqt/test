describe('Submit User Feedback without Email', () => {
  beforeEach(() => {
    cy.login(); // Assuming a custom command for logging in
    cy.visit('/feedback');
  });

  it('should allow submission of feedback without email', () => {
    const feedbackText = 'Improvement needed in delivery times.';
    const starRating = 3;

    const feedbackPage = new FeedbackPage();
    feedbackPage.enterFeedbackText(feedbackText);
    feedbackPage.selectStarRating(starRating);
    feedbackPage.submitFeedback();

    feedbackPage.verifyFeedbackSubmission();

    cy.task('verifyFeedbackInDatabase', {
      text: feedbackText,
      rating: starRating
    }).should('be.true');
  });
});