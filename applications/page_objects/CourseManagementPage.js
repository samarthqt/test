class CourseManagementPage {
  navigateToCourseManagement() {
    cy.get('#courseManagementNav').click();
  }

  selectCourse(courseId) {
    cy.get(`#course-${courseId}`).click();
  }

  checkPrerequisites() {
    return cy.get('.prerequisites').should('be.visible');
  }

  attemptEnrollment() {
    cy.get('#enrollButton').click();
  }

  verifyEnrollmentSuccess() {
    cy.get('.enrollment-status').should('contain', 'Enrollment Successful');
  }
}

module.exports = new CourseManagementPage();