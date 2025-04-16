class MicroclassPage {
  navigateToMicroclassSection() {
    cy.visit('/microclass-section');
  }

  verifyListOfExercises() {
    cy.get('.exercise-list').should('be.visible');
  }

  verifyExercisesAccessibility() {
    cy.get('.exercise-list .exercise-item').each(($el) => {
      cy.wrap($el).should('have.attr', 'href');
    });
  }

  accessMicroclassExercise() {
    cy.get('.exercise-list .exercise-item').first().click();
  }

  startExercise() {
    cy.get('.start-exercise-button').click();
  }

  completeAllTasks() {
    cy.get('.task').each(($task) => {
      cy.wrap($task).find('.complete-task-button').click();
    });
  }

  verifyFeedbackReceived() {
    cy.get('.feedback-section').should('be.visible');
  }

  accessAndCompleteExamRelatedExercise() {
    cy.get('.exam-related-exercise').click();
    this.completeAllTasks();
  }

  completeMicroclassExercise() {
    this.accessMicroclassExercise();
    this.completeAllTasks();
  }

  reviewExerciseFeedback() {
    cy.get('.review-feedback-button').click();
  }

  verifyConceptUnderstanding() {
    cy.get('.concept-understanding').should('contain', 'better understanding');
  }

  verifyExamPreparation() {
    cy.get('.exam-preparation').should('contain', 'prepared for the examination');
  }
}

export default MicroclassPage;