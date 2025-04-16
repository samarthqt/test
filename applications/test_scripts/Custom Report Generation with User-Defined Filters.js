describe('Custom Report Generation with User-Defined Filters', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const customReportsPage = new CustomReportsPage();

  before(() => {
    cy.visit('/');
  });

  it('should log in to the system', () => {
    loginPage.login('validUser', 'validPassword');
    dashboardPage.verifyDashboardPage();
  });

  it('should navigate to the Custom Reports module', () => {
    dashboardPage.goToCustomReports();
    customReportsPage.verifyCustomReportsPage();
  });

  it('should create a new report with selected filters', () => {
    customReportsPage.createNewReport();
    customReportsPage.selectProductType(['Type1', 'Type2']);
    customReportsPage.selectRegion(['Region1', 'Region2']);
    customReportsPage.selectTimePeriod('2023-01-01', '2023-12-31');
    customReportsPage.generateReport();
    customReportsPage.verifyReportData(['Type1', 'Type2'], ['Region1', 'Region2'], '2023-01-01', '2023-12-31');
  });

  it('should save, modify, and verify the report', () => {
    customReportsPage.saveReport('ReportName');
    customReportsPage.modifyReportFilters(['Type3'], ['Region3'], '2023-06-01', '2023-06-30');
    customReportsPage.regenerateReport();
    customReportsPage.verifyModifiedReportData(['Type3'], ['Region3'], '2023-06-01', '2023-06-30');
  });

  it('should export the report and verify CSV contents', () => {
    customReportsPage.exportReportToCSV('ReportName.csv');
    customReportsPage.verifyCSVContents('ReportName.csv', ['Type3'], ['Region3'], '2023-06-01', '2023-06-30');
  });

  it('should delete the report and verify it is no longer accessible', () => {
    customReportsPage.deleteReport('ReportName');
    customReportsPage.verifyReportDeletion('ReportName');
  });
});