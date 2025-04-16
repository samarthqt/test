describe('Track Site Visits for Monitoring', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const siteManagementPage = new SiteManagementPage();
  const visitTrackingPage = new VisitTrackingPage();

  before(() => {
    cy.visit('/');
  });

  it('should log in and navigate to Site Management module', () => {
    loginPage.login('validUsername', 'validPassword');
    dashboardPage.verifyDashboard();
    dashboardPage.navigateToSiteManagement();
    siteManagementPage.verifySiteManagementPage();
  });

  it('should add a new site visit', () => {
    siteManagementPage.selectVisitTracking();
    visitTrackingPage.verifyVisitTrackingPage();
    visitTrackingPage.clickAddNewVisit();
    visitTrackingPage.enterVisitDetails('001', 'Monitoring', '2023-11-01', '10:00 AM', 'John Doe');
    visitTrackingPage.saveVisit();
    visitTrackingPage.verifyVisitSaved();
  });

  it('should verify visit is listed and complete', () => {
    visitTrackingPage.verifyVisitInLog('001', 'Monitoring', '2023-11-01', '10:00 AM', 'John Doe');
  });

  it('should log out and log back in to verify visit persistence', () => {
    dashboardPage.logout();
    loginPage.login('validUsername', 'validPassword');
    dashboardPage.navigateToSiteManagement();
    siteManagementPage.selectVisitTracking();
    visitTrackingPage.verifyVisitInLog('001', 'Monitoring', '2023-11-01', '10:00 AM', 'John Doe');
  });
});