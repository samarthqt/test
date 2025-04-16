describe('Tenant Screening Process - Missing Information', () => {
  const tenantManagementPage = new TenantManagementPage();

  before(() => {
    cy.login();
  });

  it('should navigate to Tenant Management module', () => {
    tenantManagementPage.navigateToTenantManagement();
    tenantManagementPage.verifyTenantManagementModuleDisplayed();
  });

  it('should select the Screening sub-module', () => {
    tenantManagementPage.selectScreeningSubModule();
    tenantManagementPage.verifyScreeningSubModuleDisplayed();
  });

  it('should enter tenant information with missing SSN and attempt screening', () => {
    tenantManagementPage.enterTenantInformation({
      name: 'Bob Brown High',
      address: '321 Pine St, Anothertown, USA',
      ssn: '' // Missing SSN
    });
    tenantManagementPage.initiateScreeningProcess();
    tenantManagementPage.verifyMissingSSNErrorMessage();
  });

  after(() => {
    cy.logout();
  });
});