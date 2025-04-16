describe('TC-764 335 Generate Asset Value Report', () => {
  const loginPage = new LoginPage();
  const reportingPage = new ReportingPage();
  const assetValueReportPage = new AssetValueReportPage();

  before(() => {
    cy.visit('/');
  });

  it('should log in to the Dynamics 365 system as Jane Smith', () => {
    loginPage.login('Jane Smith');
    cy.url().should('include', '/dashboard');
  });

  it('should navigate to the Reporting module', () => {
    reportingPage.navigateToReportingModule();
    cy.url().should('include', '/reporting');
  });

  it('should select Asset Value Reports from the sub-module menu', () => {
    reportingPage.selectAssetValueReports();
    cy.url().should('include', '/asset-value-reports');
  });

  it('should choose IT Equipment from the asset category dropdown', () => {
    assetValueReportPage.selectAssetCategory('IT Equipment');
    cy.get('#asset-category').should('have.value', 'IT Equipment');
  });

  it('should select Depreciation Report as the report type', () => {
    assetValueReportPage.selectReportType('Depreciation Report');
    cy.get('#report-type').should('have.value', 'Depreciation Report');
  });

  it('should click on Generate Report', () => {
    assetValueReportPage.clickGenerateReport();
    cy.get('#report-status').should('contain', 'Processing');
  });

  it('should verify that the report includes asset values and depreciation details', () => {
    cy.get('#report-content').should('contain', 'Asset Values').and('contain', 'Depreciation Details');
  });

  it('should check if the report can be saved as a PDF', () => {
    assetValueReportPage.saveReportAsPDF();
    cy.get('#pdf-status').should('contain', 'Saved successfully');
  });

  it('should open the saved PDF and verify its contents', () => {
    assetValueReportPage.openSavedPDF();
    cy.get('#pdf-content').should('contain', 'Asset Values').and('contain', 'Depreciation Details');
  });

  it('should verify if the report can be sent via email to the user', () => {
    assetValueReportPage.sendReportViaEmail();
    cy.get('#email-status').should('contain', 'Email sent successfully');
  });
});