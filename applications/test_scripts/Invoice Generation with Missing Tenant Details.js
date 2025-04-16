describe('Invoice Generation with Missing Tenant Details', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const invoicePage = new InvoicePage();

  before(() => {
    cy.visit('/login');
  });

  it('should log in as administrator', () => {
    loginPage.enterUsername('admin');
    loginPage.enterPassword('password');
    loginPage.submit();
    dashboardPage.verifyDashboardIsDisplayed();
  });

  it('should navigate to Invoices sub-module', () => {
    dashboardPage.goToInvoices();
    invoicePage.verifyInvoicePageIsDisplayed();
  });

  it('should attempt to generate invoices and verify error for missing tenant details', () => {
    invoicePage.generateInvoicesForCurrentMonth();
    invoicePage.verifyErrorForMissingTenantDetails();
    invoicePage.verifyNoInvoiceGeneratedForTenantC();
  });

  it('should log out from the system', () => {
    dashboardPage.logout();
    loginPage.verifyLogoutSuccessful();
  });
});