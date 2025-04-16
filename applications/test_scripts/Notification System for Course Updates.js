describe('Notification System for Course Updates', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const notificationsPage = new NotificationsPage();
  const coursePage = new CoursePage();

  before(() => {
    cy.visit('/login');
  });

  it('should log in with valid credentials', () => {
    loginPage.login('user456', 'pass456');
    dashboardPage.verifyDashboard();
  });

  it('should navigate to Notifications settings page', () => {
    dashboardPage.goToNotifications();
    notificationsPage.verifyNotificationsPage();
  });

  it('should ensure email and SMS notifications are enabled', () => {
    notificationsPage.enableEmailNotifications();
    notificationsPage.enableSmsNotifications();
  });

  it('should simulate a course update by posting a new assignment', () => {
    coursePage.postNewAssignment();
  });

  it('should check email for notification about new assignment', () => {
    notificationsPage.checkEmailNotification('user456@example.com');
  });

  it('should check phone for SMS notification about new assignment', () => {
    notificationsPage.checkSmsNotification('+1234567890');
  });

  after(() => {
    dashboardPage.logout();
  });
});