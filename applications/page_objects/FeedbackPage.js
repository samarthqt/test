class FeedbackPage {
  navigateToFeedbackSurveys() {
    cy.visit('/feedback-surveys');
  }

  verifyFeedbackSurveysInterface() {
    cy.url().should('include', '/feedback-surveys');
    cy.contains('Feedback Surveys').should('be.visible');
  }

  selectSurvey(surveyTitle) {
    cy.contains(surveyTitle).click();
  }

  startSurvey() {
    cy.contains('Begin Survey').click();
  }

  answerSatisfactionQuestion(rating) {
    cy.get('#satisfaction-rating').select(rating);
  }

  provideSuggestions(suggestions) {
    cy.get('#suggestions-textbox').type(suggestions);
  }

  submitSurvey() {
    cy.contains('Submit Survey').click();
  }

  verifySurveySubmission() {
    cy.contains('Survey submitted successfully').should('be.visible');
  }

  verifySurveyResultsInProfile() {
    cy.visit('/user-profile');
    cy.contains('Survey Results').should('be.visible');
  }

  attemptRetakeSurvey() {
    cy.contains('Service Experience Feedback').click();
  }

  verifyRetakePrevention() {
    cy.contains('You have already completed this survey').should('be.visible');
  }

  checkForNewSurveys() {
    cy.contains('New Surveys').should('be.visible');
  }
}