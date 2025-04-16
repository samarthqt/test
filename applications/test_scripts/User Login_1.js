describe('User Login Test Suite', () => {
    const loginPage = new LoginPage();
    const dashboardPage = new DashboardPage();

    beforeEach(() => {
        cy.visit('/login');
    });

    it('should login with valid credentials', () => {
        loginPage.enterUsername('testuser');
        loginPage.enterPassword('Test@123');
        loginPage.clickLoginButton();
        dashboardPage.verifyUserAccess();
    });

    it('should logout successfully', () => {
        loginPage.enterUsername('testuser');
        loginPage.enterPassword('Test@123');
        loginPage.clickLoginButton();
        dashboardPage.logout();
        loginPage.verifyLoginPageDisplayed();
    });

    it('should display error for invalid username', () => {
        loginPage.enterUsername('wronguser');
        loginPage.enterPassword('Test@123');
        loginPage.clickLoginButton();
        loginPage.verifyErrorMessage('Invalid username');
    });

    it('should display error for invalid password', () => {
        loginPage.enterUsername('testuser');
        loginPage.enterPassword('WrongPass');
        loginPage.clickLoginButton();
        loginPage.verifyErrorMessage('Invalid password');
    });

    it('should display error for empty fields', () => {
        loginPage.clickLoginButton();
        loginPage.verifyErrorMessage('Please fill in all fields');
    });

    it('should lock account after multiple failed attempts', () => {
        for (let i = 0; i < 5; i++) {
            loginPage.enterUsername('testuser');
            loginPage.enterPassword('WrongPass');
            loginPage.clickLoginButton();
        }
        loginPage.verifyErrorMessage('Account locked');
    });

    it('should have a functional password recovery option', () => {
        loginPage.verifyPasswordRecoveryOption();
    });

    it('should log login attempts for audit', () => {
        loginPage.enterUsername('testuser');
        loginPage.enterPassword('Test@123');
        loginPage.clickLoginButton();
        loginPage.verifyLoginAttemptsLogged();
    });

    it('should adhere to security standards', () => {
        loginPage.verifySecurityStandards();
    });

    it('should allow login from multiple devices', () => {
        loginPage.verifyMultiDeviceLogin();
    });

    it('should integrate with other authentication modules', () => {
        loginPage.verifyAuthenticationIntegration();
    });
});