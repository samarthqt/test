describe('Boundary Test for Maximum Invoice Amount', () => {
    const financialManagementPage = new FinancialManagementPage();
    const invoicesPage = new InvoicesPage();

    before(() => {
        cy.visit('/login');
        financialManagementPage.loginAsAdmin();
    });

    it('should navigate to the Invoices sub-module', () => {
        financialManagementPage.navigateToInvoices();
        invoicesPage.verifyInvoiceManagementInterface();
    });

    it('should generate invoices for the current month', () => {
        invoicesPage.generateInvoicesForCurrentMonth();
        invoicesPage.verifyInvoiceGeneratedForTenantD();
    });

    it('should ensure the invoice amount does not exceed system limits', () => {
        invoicesPage.verifyInvoiceAmountWithinLimits();
    });

    after(() => {
        financialManagementPage.logout();
    });
});