describe('Mobile App Access - Service Usage', () => {
  const servicesPage = new ServicesPage();

  beforeEach(() => {
    // Assuming user is already logged in
    cy.visit('/');
  });

  it('should allow user to access and start a service', () => {
    servicesPage.navigateToServicesSection();
    servicesPage.verifyServicesSectionDisplayed();
    servicesPage.selectService('Streaming High');
    servicesPage.verifyServiceOptionsDisplayed();
    servicesPage.startService();
    servicesPage.verifyServiceStarted();
  });
});