class InstructorPortal {
  login(username, password) {
    cy.visit('/login');
    cy.get('#username').type(username);
    cy.get('#password').type(password);
    cy.get('#loginButton').click();
  }

  goToCourseManagement() {
    cy.get('#courseManagementLink').click();
  }

  logout() {
    cy.get('#logoutButton').click();
  }
}

class CourseManagement {
  verifyCourseListDisplayed() {
    cy.get('#courseList').should('be.visible');
  }

  selectCourse(courseId) {
    cy.get(`#course-${courseId}`).click();
  }

  verifyCourseDetailsDisplayed(courseId) {
    cy.get(`#courseDetails-${courseId}`).should('be.visible');
  }

  goToDeadlinesTab() {
    cy.get('#deadlinesTab').click();
  }

  setAssignmentDeadline(date) {
    cy.get('#assignmentDeadline').type(date);
    cy.get('#saveAssignmentDeadline').click();
  }

  verifyAssignmentDeadline(date) {
    cy.get('#assignmentDeadlineDisplay').should('contain', date);
  }

  setQuizDeadline(date) {
    cy.get('#quizDeadline').type(date);
    cy.get('#saveQuizDeadline').click();
  }

  verifyQuizDeadline(date) {
    cy.get('#quizDeadlineDisplay').should('contain', date);
  }

  setCourseCompletionDeadline(date) {
    cy.get('#courseCompletionDeadline').type(date);
    cy.get('#saveCourseCompletionDeadline').click();
  }

  verifyCourseCompletionDeadline(date) {
    cy.get('#courseCompletionDeadlineDisplay').should('contain', date);
  }

  verifyDeadlinesInOverview(deadlines) {
    cy.get('#overviewAssignmentDeadline').should('contain', deadlines.assignment);
    cy.get('#overviewQuizDeadline').should('contain', deadlines.quiz);
    cy.get('#overviewCourseCompletionDeadline').should('contain', deadlines.completion);
  }
}