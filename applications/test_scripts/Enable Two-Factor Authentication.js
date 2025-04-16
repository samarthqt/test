describe('Enable Two-Factor Authentication', () => {
  const securitySettingsPage = new SecuritySettingsPage();

  before(() => {
    cy.login(); // Assuming a login method is available
  });

  it('should navigate to Security Settings page', () => {
    securitySettingsPage.navigateTo();
    securitySettingsPage.verifyPageDisplayed();
  });

  it('should enable two-factor authentication', () => {
    securitySettingsPage.selectTwoFactorAuthentication();
    securitySettingsPage.enterPhoneNumber('+1234567890');
    securitySettingsPage.clickSendVerificationCode();
    cy.wait(5000); // Wait for verification code to be received
    securitySettingsPage.enterVerificationCode('123456'); // Replace with actual code received
    securitySettingsPage.clickVerify();
    securitySettingsPage.verifyTwoFactorEnabled();
  });
});