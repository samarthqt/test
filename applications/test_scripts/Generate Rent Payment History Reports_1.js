describe('Generate Rent Payment History Reports', () => {
  const reportingPage = new ReportingPage();

  before(() => {
    cy.login();
  });

  it('should navigate to the Reporting module', () => {
    reportingPage.navigateToReportingModule();
    reportingPage.verifyDashboardDisplayed();
  });

  it('should select Rent Payment History Reports', () => {
    reportingPage.selectRentPaymentHistoryReports();
    reportingPage.verifyRentPaymentHistoryPageDisplayed();
  });

  it('should enter tenant ID and select date range', () => {
    reportingPage.enterTenantID('T001');
    reportingPage.verifyTenantIDDisplayed('T001');
    reportingPage.selectDateRange('01/01/2023', '12/31/2023');
    reportingPage.verifyDateRangeDisplayed('01/01/2023', '12/31/2023');
  });

  it('should choose PDF format and generate the report', () => {
    reportingPage.selectReportFormat('PDF');
    reportingPage.verifyFormatSelected('PDF');
    reportingPage.clickGenerateReport();
    reportingPage.verifyLoadingIndicatorDisplayed();
  });

  it('should download and open the report', () => {
    reportingPage.waitForReportGeneration();
    reportingPage.verifyReportGenerated();
    reportingPage.downloadReport();
    reportingPage.openDownloadedReport();
    reportingPage.verifyReportContents();
  });

  it('should verify report data accuracy and formatting', () => {
    reportingPage.verifyPaymentsWithinDateRange();
    reportingPage.verifyPaymentDetails();
    reportingPage.verifyReportFormatting();
    reportingPage.crossCheckReportDataWithSystem();
    reportingPage.validateTotalPaymentAmount();
  });

  after(() => {
    cy.logout();
  });
});