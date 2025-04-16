describe('User Login with Maximum Length Credentials', () => {
    const loginPage = new LoginPage();
    const maxUsername = 'A'.repeat(255); // Replace 255 with the actual max length if different
    const maxPassword = 'P'.repeat(255); // Replace 255 with the actual max length if different

    beforeEach(() => {
        cy.visit('/login');
    });

    it('should display an error for maximum length credentials', () => {
        loginPage.enterUsername(maxUsername);
        loginPage.enterPassword(maxPassword);
        loginPage.clickLoginButton();
        loginPage.verifyErrorMessage('Invalid credentials');
    });
});