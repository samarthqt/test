describe('User Feedback Surveys', () => {
  const feedbackPage = new FeedbackPage();

  before(() => {
    cy.login('24680'); // Assuming a custom command for login
  });

  it('should navigate to Feedback Surveys module', () => {
    feedbackPage.navigateToFeedbackSurveys();
    feedbackPage.verifyFeedbackSurveysInterface();
  });

  it('should select and start Service Experience Feedback survey', () => {
    feedbackPage.selectSurvey('Service Experience Feedback');
    feedbackPage.startSurvey();
  });

  it('should answer survey questions and submit', () => {
    feedbackPage.answerSatisfactionQuestion('5'); // Assuming 5 is a rating
    feedbackPage.provideSuggestions('Great service, but room for improvement.');
    feedbackPage.submitSurvey();
    feedbackPage.verifySurveySubmission();
  });

  it('should verify survey results in user profile', () => {
    feedbackPage.verifySurveyResultsInProfile();
  });

  it('should prevent retaking the same survey', () => {
    feedbackPage.attemptRetakeSurvey();
    feedbackPage.verifyRetakePrevention();
  });

  it('should check for new surveys available', () => {
    feedbackPage.checkForNewSurveys();
  });

  after(() => {
    cy.logout(); // Assuming a custom command for logout
  });
});