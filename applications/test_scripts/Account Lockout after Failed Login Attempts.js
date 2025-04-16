describe('Account Lockout after Failed Login Attempts', () => {
  const loginPage = new LoginPage();

  before(() => {
    cy.visit('/login');
  });

  it('should lock account after 5 failed login attempts', () => {
    for (let attempt = 0; attempt < 5; attempt++) {
      loginPage.login('user', 'wrongpassword');
      loginPage.verifyErrorMessage('Incorrect login credentials');
    }
    loginPage.verifyAccountLockedMessage('Your account is locked');
  });

  it('should prevent login with correct password after lockout', () => {
    loginPage.login('user', 'correctpassword');
    loginPage.verifyAccountLockedMessage('Your account is locked');
  });

  it('should unlock account after customer support intervention', () => {
    // Simulate customer support unlocking the account
    cy.unlockAccount('user');
    loginPage.verifyAccountUnlocked();
  });

  it('should allow login with correct password after unlocking', () => {
    loginPage.login('user', 'correctpassword');
    loginPage.verifySuccessfulLogin();
  });

  it('should allow access to account features post-unlocking', () => {
    loginPage.verifyAccountFeaturesAccessible();
  });

  it('should allow password change for enhanced security', () => {
    loginPage.changePassword('newpassword');
    loginPage.verifyPasswordChangeSuccess();
  });

  it('should allow login with new password', () => {
    loginPage.logout();
    loginPage.login('user', 'newpassword');
    loginPage.verifySuccessfulLogin();
  });

  it('should display error for login attempt with old password', () => {
    loginPage.logout();
    loginPage.login('user', 'oldpassword');
    loginPage.verifyErrorMessage('Incorrect login credentials');
  });

  it('should verify account lockout policy documentation', () => {
    loginPage.verifyAccountLockoutPolicy();
  });
});