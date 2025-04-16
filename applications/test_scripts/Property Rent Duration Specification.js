describe('Property Rent Duration Specification', () => {
    const loginPage = new LoginPage();
    const dashboardPage = new DashboardPage();
    const propertyListingPage = new PropertyListingPage();
    const notificationPage = new NotificationPage();

    before(() => {
        cy.visit('/login');
    });

    it('should log in to the system', () => {
        loginPage.login('validUser', 'validPassword');
        dashboardPage.verifyDashboard();
    });

    it('should navigate to the property listing page', () => {
        dashboardPage.goToPropertyListing();
        propertyListingPage.verifyPropertyListingPage();
    });

    it('should enter property details and specify a rental duration', () => {
        propertyListingPage.enterPropertyDetails('56789', '12 months');
        propertyListingPage.submitPropertyListing();
    });

    it('should simulate time passage and verify notification', () => {
        cy.simulateTimePassage('11 months');
        notificationPage.verifyNotificationReceived();
        notificationPage.openNotification();
        notificationPage.verifyNotificationContent();
        notificationPage.verifyNotificationTimestamp();
    });

    it('should log out of the system', () => {
        dashboardPage.logout();
        loginPage.verifyLogout();
    });
});