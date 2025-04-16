describe('Order Tracking with Special Characters', () => {
    const loginPage = new LoginPage();
    const dashboardPage = new DashboardPage();
    const orderTrackingPage = new OrderTrackingPage();

    beforeEach(() => {
        cy.visit('/login');
    });

    it('should display an error message for special characters in the order number', () => {
        loginPage.login('user@example.com', 'password123');
        dashboardPage.navigateToOrderTracking();
        orderTrackingPage.enterOrderNumber('#$%&');
        orderTrackingPage.submitOrderNumber();
        orderTrackingPage.verifyErrorMessage('Invalid characters in the order number');
    });
});