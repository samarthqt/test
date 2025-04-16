describe('User Activity Logging', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const adminPanelPage = new AdminPanelPage();

  before(() => {
    cy.visit('/login');
  });

  it('should log in successfully', () => {
    loginPage.enterUsername('validUser');
    loginPage.enterPassword('validPassword');
    loginPage.submit();
    dashboardPage.verifyLoginSuccess();
  });

  it('should perform actions and log out', () => {
    dashboardPage.viewProduct();
    dashboardPage.addToCart();
    dashboardPage.logout();
  });

  it('should verify user activity logs', () => {
    adminPanelPage.accessAdminPanel();
    adminPanelPage.navigateToActivityLogs();
    adminPanelPage.searchUserId('12345');
    adminPanelPage.verifyUserActivities(['Login', 'View Product', 'Add to Cart', 'Logout']);
  });
});