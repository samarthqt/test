describe('Course Enrollment with Available Courses', () => {
  const courseEnrollmentPage = new CourseEnrollmentPage();
  const userProfilePage = new UserProfilePage();

  beforeEach(() => {
    cy.login(); // Assume a custom command for logging in
    courseEnrollmentPage.navigateTo();
  });

  it('should enroll in an available course', () => {
    courseEnrollmentPage.searchCourse('Introduction to Dynamics 365');
    courseEnrollmentPage.selectCourse('Introduction to Dynamics 365');
    courseEnrollmentPage.enrollInCourse();
    courseEnrollmentPage.verifyEnrollmentConfirmation();
    userProfilePage.verifyEnrolledCourse('Introduction to Dynamics 365');
  });
});