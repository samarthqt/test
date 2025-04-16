describe('Rent Payment History Reports', () => {
  const tenantId = 'T12345';
  const landlordId = 'L67890';
  const validDateRange = { start: '01/01/2023', end: '12/31/2023' };
  const invalidTenantId = 'INVALID';
  const invalidDateRange = { start: '01/01/2024', end: '12/31/2024' };

  beforeEach(() => {
    cy.visit('/login');
    cy.login('validUser', 'validPassword');
    cy.get('.dashboard').should('be.visible');
  });

  it('should generate rent payment history report successfully', () => {
    cy.navigateToReportingModule();
    cy.selectReportOption('Rent Payment History');
    cy.enterTenantId(tenantId);
    cy.enterLandlordId(landlordId);
    cy.setDateRange(validDateRange.start, validDateRange.end);
    cy.generateReport();
    cy.verifyReportContent(tenantId, landlordId, validDateRange);
    cy.checkReportForDiscrepancies();
    cy.downloadReport('PDF');
    cy.openDownloadedReport();
    cy.shareReportViaEmail('test@example.com');
  });

  it('should display error for invalid Tenant ID', () => {
    cy.navigateToReportingModule();
    cy.selectReportOption('Rent Payment History');
    cy.enterTenantId(invalidTenantId);
    cy.enterLandlordId(landlordId);
    cy.setDateRange(validDateRange.start, validDateRange.end);
    cy.generateReport();
    cy.verifyErrorMessage('Invalid Tenant ID');
  });

  it('should display error for invalid date range', () => {
    cy.navigateToReportingModule();
    cy.selectReportOption('Rent Payment History');
    cy.enterTenantId(tenantId);
    cy.enterLandlordId(landlordId);
    cy.setDateRange(invalidDateRange.start, invalidDateRange.end);
    cy.generateReport();
    cy.verifyErrorMessage('Invalid Date Range');
  });

  afterEach(() => {
    cy.logout();
    cy.login('validUser', 'validPassword');
    cy.verifyReportHistory(tenantId, landlordId, validDateRange);
    cy.logout();
  });
});