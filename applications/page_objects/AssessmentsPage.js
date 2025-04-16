class AssessmentsPage {
  visit() {
    cy.visit('/assessments');
  }

  selectQuiz(quizId) {
    cy.get(`[data-quiz-id="${quizId}"]`).click();
  }
}

class QuizPage {
  startQuiz() {
    cy.get('#startQuizButton').click();
  }

  waitForTimeLimit() {
    cy.wait(1800000); // Wait for 30 minutes
  }

  verifyTimeExceededResponse() {
    cy.get('#timeExceededMessage').should('be.visible');
  }

  verifyResultsRecorded() {
    cy.get('#resultsRecordedMessage').should('be.visible');
  }
}