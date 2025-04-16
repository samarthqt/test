class CourseEnrollmentPage {
  visit() {
    cy.visit('/courses/enrollment');
  }

  getCourseSearchBar() {
    return cy.get('#course-search-bar');
  }

  getCourseList() {
    return cy.get('#course-list');
  }

  selectCourse(courseId) {
    return cy.get(`#course-${courseId}`).click();
  }

  getEnrollButton() {
    return cy.get('#enroll-button');
  }

  getErrorMessage() {
    return cy.get('.error-message');
  }
}

export default CourseEnrollmentPage;