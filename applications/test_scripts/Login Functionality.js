describe('Login Functionality Tests', () => {
  const loginPage = new LoginPage();

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should display login page', () => {
    loginPage.verifyLoginPageDisplayed();
  });

  it('should login successfully with correct credentials for User E', () => {
    loginPage.login('userE', 'correctPassword');
    loginPage.verifySuccessfulLogin();
  });

  it('should login successfully with correct credentials for User F', () => {
    loginPage.login('userF', 'correctPassword');
    loginPage.verifySuccessfulLogin();
  });

  it('should display error for incorrect credentials for User E', () => {
    loginPage.login('userE', 'wrongPassword');
    loginPage.verifyErrorMessageDisplayed();
  });

  it('should display error for incorrect credentials for User F', () => {
    loginPage.login('userF', 'wrongPassword');
    loginPage.verifyErrorMessageDisplayed();
  });

  it('should limit login attempts for User E and display lockout message', () => {
    loginPage.simulateExceedingLoginAttempts('userE');
    loginPage.verifyLockoutMessageDisplayed();
  });

  it('should limit login attempts for User F and display lockout message', () => {
    loginPage.simulateExceedingLoginAttempts('userF');
    loginPage.verifyLockoutMessageDisplayed();
  });

  it('should display maintenance message during login attempt for User E', () => {
    loginPage.simulateSystemMaintenance('userE');
    loginPage.verifyMaintenanceMessageDisplayed();
  });

  it('should display maintenance message during login attempt for User F', () => {
    loginPage.simulateSystemMaintenance('userF');
    loginPage.verifyMaintenanceMessageDisplayed();
  });

  it('should remain functional during peak usage for User E', () => {
    loginPage.simulatePeakUsage('userE');
    loginPage.verifyResponsiveLogin();
  });

  it('should remain functional during peak usage for User F', () => {
    loginPage.simulatePeakUsage('userF');
    loginPage.verifyResponsiveLogin();
  });

  it('should persist session for User E after login', () => {
    loginPage.login('userE', 'correctPassword');
    loginPage.verifySessionPersistence();
  });

  it('should persist session for User F after login', () => {
    loginPage.login('userF', 'correctPassword');
    loginPage.verifySessionPersistence();
  });

  it('should handle simultaneous login attempts for User E', () => {
    loginPage.simulateSimultaneousLoginAttempts('userE');
    loginPage.verifyNoErrors();
  });

  it('should handle simultaneous login attempts for User F', () => {
    loginPage.simulateSimultaneousLoginAttempts('userF');
    loginPage.verifyNoErrors();
  });
});