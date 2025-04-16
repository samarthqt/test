describe('Access Tenant Dashboard', () => {
    const tenantDashboard = new TenantDashboard();

    before(() => {
        cy.login('tenant', 'password');
    });

    it('should navigate to the dashboard', () => {
        tenantDashboard.goToDashboard();
        tenantDashboard.verifyDashboardDisplayed();
    });

    it('should display rent history', () => {
        tenantDashboard.selectFilter('Rent History');
        tenantDashboard.verifyRentHistoryDisplayed();
    });

    it('should display upcoming payments', () => {
        tenantDashboard.selectFilter('Upcoming Payments');
        tenantDashboard.verifyUpcomingPaymentsDisplayed();
    });

    it('should display maintenance requests', () => {
        tenantDashboard.selectFilter('Maintenance Requests');
        tenantDashboard.verifyMaintenanceRequestsDisplayed();
    });

    it('should review rent history details', () => {
        tenantDashboard.reviewRentHistoryDetails();
    });

    it('should review upcoming payment schedule', () => {
        tenantDashboard.reviewUpcomingPaymentSchedule();
    });

    it('should review maintenance request status', () => {
        tenantDashboard.reviewMaintenanceRequestStatus();
    });

    it('should access detailed view of maintenance request', () => {
        tenantDashboard.accessDetailedMaintenanceRequest();
    });

    after(() => {
        cy.logout();
    });
});