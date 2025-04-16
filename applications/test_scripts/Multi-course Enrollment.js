describe('Multi-course Enrollment', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const courseEnrollmentPage = new CourseEnrollmentPage();

  before(() => {
    cy.visit('/');
  });

  it('should log in with valid credentials', () => {
    loginPage.enterUsername('USER12345');
    loginPage.enterPassword('password');
    loginPage.clickLogin();
    dashboardPage.verifyDashboard();
  });

  it('should navigate to Course Enrollment section', () => {
    dashboardPage.goToCourseEnrollment();
    courseEnrollmentPage.verifyCourseEnrollmentPage();
  });

  it('should enroll in CSE101', () => {
    courseEnrollmentPage.enrollInCourse('CSE101');
    courseEnrollmentPage.verifyEnrollmentConfirmation('CSE101');
  });

  it('should enroll in MAT202', () => {
    courseEnrollmentPage.enrollInCourse('MAT202');
    courseEnrollmentPage.verifyEnrollmentConfirmation('MAT202');
  });

  it('should enroll in PHY303', () => {
    courseEnrollmentPage.enrollInCourse('PHY303');
    courseEnrollmentPage.verifyEnrollmentConfirmation('PHY303');
  });

  it('should verify all enrolled courses are listed', () => {
    courseEnrollmentPage.verifyEnrolledCourses(['CSE101', 'MAT202', 'PHY303']);
  });

  it('should enroll in an additional course', () => {
    courseEnrollmentPage.enrollInCourse('ENG404');
    courseEnrollmentPage.verifyEnrollmentConfirmation('ENG404');
  });

  it('should log out', () => {
    dashboardPage.logout();
    loginPage.verifyLogout();
  });
});