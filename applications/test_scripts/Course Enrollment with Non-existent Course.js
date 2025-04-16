describe('Course Enrollment with Non-existent Course', () => {
  beforeEach(() => {
    cy.login();
    cy.visit('/course-enrollment');
  });

  it('should prevent enrollment in a non-existent course', () => {
    const courseName = 'Advanced Quantum Mechanics';
    const courseId = 'QM-999';
    
    const courseEnrollmentPage = new CourseEnrollmentPage();
    
    courseEnrollmentPage.searchCourse(courseName);
    courseEnrollmentPage.verifyCourseNotListed(courseName);
    
    courseEnrollmentPage.attemptEnrollment(courseId);
    courseEnrollmentPage.verifyEnrollmentFailure();
  });
});