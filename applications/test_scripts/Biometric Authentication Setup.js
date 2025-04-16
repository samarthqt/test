describe('Biometric Authentication Setup', () => {
  const loginPage = new LoginPage();
  const authSettingsPage = new AuthSettingsPage();
  const biometricPage = new BiometricPage();

  before(() => {
    cy.visit('/login');
  });

  it('should log in using valid credentials', () => {
    loginPage.enterUsername('validUsername');
    loginPage.enterPassword('validPassword');
    loginPage.submit();
    authSettingsPage.verifyNavigationToAuthSettings();
  });

  it('should navigate to Biometric Authentication section', () => {
    authSettingsPage.navigateToBiometricSection();
    biometricPage.verifyBiometricPageLoaded();
  });

  it('should select Fingerprint as biometric authentication method', () => {
    biometricPage.selectBiometricType('Fingerprint');
    biometricPage.verifySelectedBiometricType('Fingerprint');
  });

  it('should register fingerprint successfully', () => {
    biometricPage.registerFingerprint();
    biometricPage.verifyFingerprintRegistration();
  });

  it('should log out and authenticate using registered fingerprint', () => {
    authSettingsPage.logout();
    loginPage.authenticateWithFingerprint();
    authSettingsPage.verifySuccessfulLogin();
  });
});