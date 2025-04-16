describe('Course Enrollment Without Prerequisites', () => {
  it('should prevent enrollment without meeting prerequisites', () => {
    const loginPage = new LoginPage();
    const courseManagementPage = new CourseManagementPage();

    // Step 1: Log in to the system
    loginPage.navigateToLoginPage();
    loginPage.enterUserId('23456');
    loginPage.submitLogin();

    // Step 2: Navigate to Course Management module
    courseManagementPage.navigateToCourseManagement();

    // Step 3: Select the course with Course ID CRS001
    courseManagementPage.selectCourse('CRS001');

    // Step 4: Attempt to enroll in the course without meeting prerequisites
    courseManagementPage.attemptEnrollment();
    courseManagementPage.verifyEnrollmentPrevention();
  });
});