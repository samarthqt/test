describe('Tenant Screening Process - Credit Check', () => {
  const tenantName = 'Jane Smith';
  const tenantSSN = '987-65-4321';
  const tenantAddress = '456 Elm St, Othertown, USA';

  before(() => {
    cy.visit('/login');
    cy.login('username', 'password');
  });

  it('should navigate to Tenant Management module', () => {
    cy.visit('/tenant-management');
    cy.url().should('include', '/tenant-management');
  });

  it('should select the Screening sub-module', () => {
    TenantManagementPage.selectScreeningSubModule();
    cy.url().should('include', '/screening');
  });

  it('should enter tenant information', () => {
    ScreeningPage.enterTenantInformation(tenantName, tenantSSN, tenantAddress);
    ScreeningPage.verifyTenantInformation(tenantName, tenantSSN, tenantAddress);
  });

  it('should initiate credit check process', () => {
    ScreeningPage.initiateCreditCheck();
    ScreeningPage.verifyCreditCheckInitiated();
  });

  it('should verify credit check completes successfully', () => {
    ScreeningPage.verifyCreditCheckCompletion();
  });

  it('should check that results are stored securely', () => {
    ScreeningPage.verifyResultsStoredSecurely();
  });

  after(() => {
    cy.logout();
  });
});