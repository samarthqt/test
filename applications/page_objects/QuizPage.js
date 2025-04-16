class QuizPage {
  login(userId) {
    cy.visit('/login');
    cy.get('#userId').type(userId);
    cy.get('#loginButton').click();
  }

  visitDashboard() {
    cy.url().should('include', '/dashboard');
  }

  navigateToQuizzes() {
    cy.get('#quizzesSection').click();
  }

  verifyQuizList() {
    cy.get('.quizList').should('be.visible');
  }

  selectQuiz(quizId) {
    cy.get(`#quiz-${quizId}`).click();
  }

  verifyQuizDetails() {
    cy.get('.quizDetails').should('be.visible');
  }

  startQuiz() {
    cy.get('#startQuizButton').click();
  }

  answerAllQuestions() {
    cy.get('.question').each(($el) => {
      cy.wrap($el).find('.answer').click();
    });
  }

  submitQuiz() {
    cy.get('#submitQuizButton').click();
  }

  verifySubmissionConfirmation() {
    cy.get('.submissionConfirmation').should('be.visible');
  }

  verifyFeedback() {
    cy.get('.feedback').should('be.visible');
  }

  checkScore() {
    cy.get('.score').should('be.visible');
  }

  verifySystemLogs() {
    cy.readFile('systemLogs.txt').should('contain', 'Quiz Completion');
  }

  checkEmailNotification() {
    cy.get('#emailNotification').should('contain', 'Quiz Score');
  }

  checkLeaderboard() {
    cy.get('.leaderboard').should('contain', 'User Score');
  }

  verifyTimeLimitAdherence() {
    cy.get('.timeLimit').should('contain', '20 minutes');
  }

  attemptRetakeQuiz() {
    cy.get('#retakeQuizButton').click();
  }

  validateFeedbackAccuracy() {
    cy.get('.feedback').each(($el, index) => {
      cy.wrap($el).should('contain', `Answer ${index + 1}`);
    });
  }

  checkForErrors() {
    cy.get('.errorLogs').should('not.exist');
  }
}

module.exports = new QuizPage();