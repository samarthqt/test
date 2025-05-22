describe('Instant Shipment Tracking Alert for Delivery Confirmation', () => {
    const loginPage = new LoginPage();
    const dashboardPage = new DashboardPage();
    const ordersPage = new OrdersPage();
    const orderDetailsPage = new OrderDetailsPage();
    const alertSystem = new AlertSystem();

    before(() => {
        cy.visit('/');
    });

    it('should log in to the Dynamics 365 system', () => {
        loginPage.login('validUsername', 'validPassword');
        dashboardPage.verifyDashboardIsDisplayed();
    });

    it('should navigate to the Orders module', () => {
        dashboardPage.navigateToOrdersModule();
        ordersPage.verifyOrdersModuleIsDisplayed();
    });

    it('should select the order with ID 12345', () => {
        ordersPage.selectOrderById('12345');
        orderDetailsPage.verifyOrderDetailsDisplayed('12345');
    });

    it('should update the shipment status to Delivered', () => {
        orderDetailsPage.updateShipmentStatus('Delivered');
        orderDetailsPage.verifyShipmentStatus('Delivered');
    });

    it('should check the alert system for outgoing alerts', () => {
        alertSystem.verifyAlertSent('customer@example.com', 'Your shipment has been delivered.');
    });

    it('should verify the alert received by the customer', () => {
        alertSystem.verifyCustomerReceivedAlert('customer@example.com', 'Your shipment has been delivered.');
    });
});