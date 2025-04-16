describe('Property Management Dashboard Access', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();

  before(() => {
    cy.visit('/login');
  });

  it('should log in as admin user', () => {
    loginPage.login('admin_user', 'admin_pass');
    cy.url().should('include', '/dashboard');
  });

  it('should display all listed properties', () => {
    dashboardPage.navigateToProperties();
    dashboardPage.verifyPropertiesListed();
  });

  it('should view and edit property details', () => {
    dashboardPage.selectProperty('Property Name');
    dashboardPage.verifyPropertyDetails('Property Name');
    dashboardPage.editPropertyDetails('New Property Details');
    dashboardPage.saveChanges();
    dashboardPage.verifyUpdatedDetails('New Property Details');
  });

  it('should delete a property and verify deletion in logs', () => {
    dashboardPage.deleteProperty('Property Name');
    dashboardPage.verifyPropertyDeletion('Property Name');
    dashboardPage.verifyDeletionInLogs('Property Name');
  });

  it('should check and use dashboard filters and sort options', () => {
    dashboardPage.checkFiltersAndSortOptions();
    dashboardPage.filterPropertiesByStatus('For Sale');
    dashboardPage.sortPropertiesByPriceDescending();
  });

  it('should verify admin permissions and real-time updates', () => {
    dashboardPage.verifyAdminPermissions();
    dashboardPage.checkRealTimeUpdates();
  });

  it('should verify dashboard performance under high load', () => {
    dashboardPage.verifyPerformanceUnderLoad();
  });

  it('should ensure secure access for admin users', () => {
    dashboardPage.verifySecureAccess();
  });
});