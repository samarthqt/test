describe('Monthly Invoice Generation for Tenants', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const invoicesPage = new InvoicesPage();

  before(() => {
    cy.visit('/login');
  });

  it('should log in as administrator', () => {
    loginPage.login('admin', 'password');
    dashboardPage.verifyDashboardIsDisplayed();
  });

  it('should navigate to Invoices sub-module', () => {
    dashboardPage.navigateToInvoices();
    invoicesPage.verifyInvoicesInterfaceIsDisplayed();
  });

  it('should generate invoices for the current month', () => {
    invoicesPage.selectGenerateInvoices();
    invoicesPage.confirmInvoiceGeneration();
  });

  it('should verify invoice for Tenant A', () => {
    invoicesPage.verifyInvoiceDetails('Tenant A', 1000, 100, 50);
  });

  it('should verify invoice for Tenant B', () => {
    invoicesPage.verifyInvoiceDetails('Tenant B', 1200, 150, 60);
  });

  it('should check invoice date is the first of the current month', () => {
    invoicesPage.verifyInvoiceDate();
  });

  it('should ensure invoices are saved in the system', () => {
    invoicesPage.verifyInvoicesSaved();
  });

  it('should send generated invoices to tenants via email', () => {
    invoicesPage.sendInvoicesViaEmail();
  });

  after(() => {
    dashboardPage.logout();
  });
});