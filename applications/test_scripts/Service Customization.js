describe('Service Customization Test Suite', () => {
  before(() => {
    cy.visit('https://example.com/login');
  });

  it('should log in with valid credentials', () => {
    const loginPage = new LoginPage();
    loginPage.enterUsername('user2@example.com');
    loginPage.enterPassword('password');
    loginPage.submit();
    cy.url().should('include', '/dashboard');
  });

  it('should navigate to the Account Settings', () => {
    const dashboardPage = new DashboardPage();
    dashboardPage.goToAccountSettings();
    cy.url().should('include', '/account-settings');
  });

  it('should locate and select the Service Customization option', () => {
    const accountSettingsPage = new AccountSettingsPage();
    accountSettingsPage.selectServiceCustomization();
    accountSettingsPage.verifyCustomizationOptionsVisible();
  });

  it('should change UI preference to Dark Mode', () => {
    const serviceCustomizationPage = new ServiceCustomizationPage();
    serviceCustomizationPage.setUIPreference('Dark Mode');
    serviceCustomizationPage.verifyUIPreference('Dark Mode');
  });

  it('should enable Email Alerts for notifications', () => {
    const serviceCustomizationPage = new ServiceCustomizationPage();
    serviceCustomizationPage.setNotificationPreference('Email Alerts');
    serviceCustomizationPage.verifyNotificationPreference('Email Alerts');
  });

  it('should save the customization changes', () => {
    const serviceCustomizationPage = new ServiceCustomizationPage();
    serviceCustomizationPage.saveChanges();
    serviceCustomizationPage.verifySaveConfirmation();
  });

  it('should log out and log back in', () => {
    const dashboardPage = new DashboardPage();
    dashboardPage.logout();
    cy.visit('https://example.com/login');
    const loginPage = new LoginPage();
    loginPage.enterUsername('user2@example.com');
    loginPage.enterPassword('password');
    loginPage.submit();
    cy.url().should('include', '/dashboard');
  });

  it('should verify UI preference is Dark Mode after re-login', () => {
    const dashboardPage = new DashboardPage();
    dashboardPage.verifyUIPreference('Dark Mode');
  });

  it('should verify Email Alerts are enabled after re-login', () => {
    const dashboardPage = new DashboardPage();
    dashboardPage.verifyNotificationPreference('Email Alerts');
  });
});