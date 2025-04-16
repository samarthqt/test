describe('Tenant Screening Process - Invalid SSN', () => {
  const tenantManagementPage = new TenantManagementPage();
  const screeningPage = new ScreeningPage();

  before(() => {
    cy.visit('/');
    cy.login('username', 'password');
  });

  it('Navigates to Tenant Management module', () => {
    tenantManagementPage.navigate();
    tenantManagementPage.verifyPageDisplayed();
  });

  it('Selects the Screening sub-module', () => {
    tenantManagementPage.selectScreeningSubModule();
    screeningPage.verifyPageDisplayed();
  });

  it('Enters tenant information and attempts screening with invalid SSN', () => {
    screeningPage.enterTenantInformation('Alice Johnson High', '000-00-0000', '789 Oak St, Sometown, USA');
    screeningPage.initiateScreening();
    screeningPage.verifyInvalidSSNError();
  });

  after(() => {
    cy.logout();
  });
});