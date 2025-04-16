class FinancialManagementPage {
    loginAsAdmin() {
        cy.get('#username').type('admin');
        cy.get('#password').type('password');
        cy.get('#loginButton').click();
        cy.get('.admin-dashboard').should('be.visible');
    }

    navigateToInvoices() {
        cy.get('#invoicesSubModule').click();
    }

    logout() {
        cy.get('#logoutButton').click();
        cy.get('#loginPage').should('be.visible');
    }
}

class InvoicesPage {
    verifyInvoiceManagementInterface() {
        cy.get('.invoice-management-interface').should('be.visible');
    }

    generateInvoicesForCurrentMonth() {
        cy.get('#generateInvoiceButton').click();
    }

    verifyInvoiceGeneratedForTenantD() {
        cy.get('.invoice-tenantD').should('contain', 'Rent: $999999');
        cy.get('.invoice-tenantD').should('contain', 'Service Charge: $99999');
        cy.get('.invoice-tenantD').should('contain', 'Maintenance Fee: $9999');
    }

    verifyInvoiceAmountWithinLimits() {
        cy.get('.invoice-tenantD').should('not.contain', 'exceeds system limits');
    }
}