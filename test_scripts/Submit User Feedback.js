describe('Submit User Feedback', () => {
  const feedbackPage = new FeedbackPage();

  before(() => {
    cy.login(); // Assume a custom command for logging in
  });

  it('should navigate to feedback section', () => {
    feedbackPage.navigateToFeedbackSection();
    cy.url().should('include', '/feedback');
  });

  it('should enter feedback text', () => {
    feedbackPage.enterFeedbackText('Great service!');
    feedbackPage.feedbackTextArea().should('have.value', 'Great service!');
  });

  it('should select 5-star rating', () => {
    feedbackPage.selectRating(5);
    feedbackPage.ratingStars(5).should('have.class', 'selected');
  });

  it('should enter optional email', () => {
    feedbackPage.enterEmail('user@example.com');
    feedbackPage.emailField().should('have.value', 'user@example.com');
  });

  it('should submit feedback', () => {
    feedbackPage.submitFeedback();
    feedbackPage.confirmationMessage().should('be.visible');
  });

  it('should verify feedback in the database', () => {
    cy.verifyFeedbackInDatabase({
      text: 'Great service!',
      rating: 5,
      email: 'user@example.com'
    });
  });
});