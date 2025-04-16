describe('Location-Based Asset Report Test Suite', () => {
  beforeEach(() => {
    cy.visit('/asset-management/reports');
  });

  it('Generate and verify location-based asset report for San Francisco', () => {
    const reportsPage = new ReportsPage();

    reportsPage.selectLocationBasedReport();
    reportsPage.filterByLocation('San Francisco');
    reportsPage.generateReport();

    reportsPage.verifyAssetInReport('A123');
    reportsPage.exportReportToPDF();
  });
});