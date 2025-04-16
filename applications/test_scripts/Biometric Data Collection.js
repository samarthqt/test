describe('Biometric Data Collection Test Suite', () => {
  const loginPage = new LoginPage();
  const homePage = new HomePage();
  const dataManagementPage = new DataManagementPage();
  const biometricDataPage = new BiometricDataPage();

  before(() => {
    // Setup: Navigate to the application
    cy.visit('/');
  });

  it('should log in to the system using valid credentials', () => {
    loginPage.enterUsername('validUsername');
    loginPage.enterPassword('validPassword');
    loginPage.clickLoginButton();
    homePage.verifyHomePage();
  });

  it('should navigate to the Data Management module', () => {
    homePage.clickDataManagementModule();
    dataManagementPage.verifyBiometricDataCollectionScreen();
  });

  it("should select participant 'P001' from the list", () => {
    dataManagementPage.selectParticipant('P001');
    biometricDataPage.verifyParticipantDetails('P001');
  });

  it('should verify biometric data collection for heart rate and blood pressure', () => {
    biometricDataPage.verifyHeartRateData();
    biometricDataPage.verifyBloodPressureData();
  });

  it('should monitor real-time data updates', () => {
    biometricDataPage.monitorRealTimeDataUpdates();
  });

  after(() => {
    // Teardown: Log out of the system
    homePage.clickLogoutButton();
    loginPage.verifyLogout();
  });
});