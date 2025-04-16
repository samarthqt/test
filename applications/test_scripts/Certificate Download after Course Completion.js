describe('Certificate Download after Course Completion', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const completedCoursesPage = new CompletedCoursesPage();

  before(() => {
    cy.visit('/');
  });

  it('should log in to the Course Management system', () => {
    loginPage.login('U09876', 'password');
    dashboardPage.verifyDashboard();
  });

  it('should navigate to Completed Courses section', () => {
    dashboardPage.goToCompletedCourses();
    completedCoursesPage.verifyCompletedCoursesList();
  });

  it('should select a completed course and download the certificate', () => {
    completedCoursesPage.selectCourse('C54321');
    completedCoursesPage.downloadCertificate();
    completedCoursesPage.verifyCertificateDownloaded();
  });

  it('should open and print the downloaded certificate', () => {
    completedCoursesPage.openCertificate();
    completedCoursesPage.verifyCertificateDetails();
    completedCoursesPage.printCertificate();
  });

  it('should check for email confirmation', () => {
    completedCoursesPage.verifyEmailConfirmation();
  });

  it('should log out from the system', () => {
    dashboardPage.logout();
    loginPage.verifyLoggedOut();
  });
});