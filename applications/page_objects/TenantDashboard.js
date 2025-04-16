class TenantDashboard {
    goToDashboard() {
        cy.visit('/dashboard');
    }

    verifyDashboardDisplayed() {
        cy.get('.dashboard-header').should('be.visible');
    }

    selectFilter(filterName) {
        cy.get('.filter-dropdown').select(filterName);
    }

    verifyRentHistoryDisplayed() {
        cy.get('.rent-history').should('be.visible');
    }

    verifyUpcomingPaymentsDisplayed() {
        cy.get('.upcoming-payments').should('be.visible');
    }

    verifyMaintenanceRequestsDisplayed() {
        cy.get('.maintenance-requests').should('be.visible');
    }

    reviewRentHistoryDetails() {
        cy.get('.rent-history-details').should('contain', 'Payment Date').and('contain', 'Amount');
    }

    reviewUpcomingPaymentSchedule() {
        cy.get('.upcoming-payment-schedule').should('contain', 'Due Date').and('contain', 'Amount');
    }

    reviewMaintenanceRequestStatus() {
        cy.get('.maintenance-status').should('contain', 'Status');
    }

    accessDetailedMaintenanceRequest() {
        cy.get('.maintenance-request').first().click();
        cy.get('.maintenance-details').should('be.visible');
    }
}