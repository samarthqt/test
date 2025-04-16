describe('Offline Mode Access', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const courseContentPage = new CourseContentPage();

  before(() => {
    cy.visit('/login');
  });

  it('should log in and access the dashboard', () => {
    loginPage.login('user', 'password');
    dashboardPage.verifyDashboard();
  });

  it('should navigate to Course Content section and select course C202', () => {
    dashboardPage.goToCourseContent();
    courseContentPage.selectCourse('C202');
  });

  it('should download course content for offline access', () => {
    courseContentPage.downloadAllContent();
  });

  it('should switch to offline mode and access downloaded content', () => {
    courseContentPage.switchToOfflineMode();
    courseContentPage.verifyOfflineContentUsability();
  });

  it('should log out from the system', () => {
    dashboardPage.logout();
  });
});