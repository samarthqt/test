class StudentDashboard {
  visitLogin() {
    cy.visit('/login');
  }

  login(studentId) {
    cy.get('#student-id').type(studentId);
    cy.get('#login-button').click();
  }

  navigateToDashboard() {
    cy.url().should('include', '/dashboard');
  }

  navigateToAssignments() {
    cy.get('#assignments-section').click();
  }

  selectAssignment(assignmentId) {
    cy.get(`#assignment-${assignmentId}`).click();
  }

  submitAssignment() {
    cy.get('#submit-assignment').click();
  }

  verifyAssignmentConfirmation() {
    cy.get('#assignment-confirmation').should('be.visible');
  }

  navigateToQuizzes() {
    cy.get('#quizzes-section').click();
  }

  selectQuiz(quizId) {
    cy.get(`#quiz-${quizId}`).click();
  }

  submitQuiz() {
    cy.get('#submit-quiz').click();
  }

  verifyQuizConfirmation() {
    cy.get('#quiz-confirmation').should('be.visible');
  }

  navigateToCourses() {
    cy.get('#courses-section').click();
  }

  selectCourse(courseId) {
    cy.get(`#course-${courseId}`).click();
  }

  submitCourse() {
    cy.get('#submit-course').click();
  }

  verifyCourseConfirmation() {
    cy.get('#course-confirmation').should('be.visible');
  }

  checkProfileForBadgesPoints() {
    cy.get('#profile').click();
    cy.get('#badges-points').should('be.visible');
  }

  claimBadge() {
    cy.get('#claim-badge').click();
  }

  claimPoints() {
    cy.get('#claim-points').click();
  }

  verifyErrorMessage(message) {
    cy.get('#error-message').should('contain', message);
  }

  logout() {
    cy.get('#logout').click();
  }

  adminLogin() {
    cy.get('#admin-login').click();
  }

  adjustBadgesPoints() {
    cy.get('#adjust-badges-points').click();
  }

  awardBadge() {
    cy.get('#award-badge').click();
  }
}

module.exports = new StudentDashboard();