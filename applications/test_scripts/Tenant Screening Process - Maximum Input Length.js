describe('Tenant Screening Process - Maximum Input Length', () => {
  const tenantManagementPage = new TenantManagementPage();

  before(() => {
    cy.login();
  });

  it('should navigate to the Tenant Management module', () => {
    tenantManagementPage.navigate();
    tenantManagementPage.verifyModuleDisplayed();
  });

  it('should select the Screening sub-module', () => {
    tenantManagementPage.selectScreeningSubModule();
    tenantManagementPage.verifyScreeningSubModuleDisplayed();
  });

  it('should display error for exceeding maximum input length', () => {
    tenantManagementPage.enterTenantInfo({
      name: 'A very long name exceeding normal input length requirements',
      ssn: '123-45-6789',
      address: '123 Main St, Anytown, USA'
    });
    tenantManagementPage.verifyErrorMessageDisplayed();
  });

  after(() => {
    cy.logout();
  });
});