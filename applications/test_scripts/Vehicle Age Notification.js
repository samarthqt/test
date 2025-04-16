describe('Vehicle Age Notification', () => {
  const vehiclePage = new VehiclePage();
  const notificationPage = new NotificationPage();

  before(() => {
    cy.login();
  });

  it('should navigate to Vehicle Profiles section', () => {
    vehiclePage.navigateToVehicleProfiles();
    vehiclePage.verifyVehicleListIsVisible();
  });

  it('should select vehicle with ID V12345', () => {
    vehiclePage.selectVehicleById('V12345');
    vehiclePage.verifyVehicleDetailsDisplayed();
  });

  it('should ensure notification settings are enabled', () => {
    vehiclePage.verifyNotificationSettingsEnabled();
  });

  it('should simulate vehicle reaching 5 years of age', () => {
    vehiclePage.simulateVehicleAge(5);
    notificationPage.verifyNotificationTriggered();
  });

  it('should check notification center for alerts', () => {
    notificationPage.checkNotificationCenter();
    notificationPage.verifyNotificationPresent();
  });

  it('should verify notification content for clarity and accuracy', () => {
    notificationPage.verifyNotificationContent();
  });

  after(() => {
    cy.logout();
  });
});