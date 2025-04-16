describe('Account Suspension for Inactivity', () => {
  const adminCredentials = { username: 'admin123', password: 'password' };
  const userCredentials = { email: 'inactiveuser@example.com', userId: '11223' };

  before(() => {
    cy.visit('/admin-login');
    cy.get(AdminLoginPage.usernameInput).type(adminCredentials.username);
    cy.get(AdminLoginPage.passwordInput).type(adminCredentials.password);
    cy.get(AdminLoginPage.loginButton).click();
    cy.url().should('include', '/admin-dashboard');
  });

  it('should suspend user account for inactivity', () => {
    cy.get(AdminDashboardPage.userManagementLink).click();
    cy.url().should('include', '/user-management');

    cy.get(UserManagementPage.searchInput).type(userCredentials.userId);
    cy.get(UserManagementPage.searchButton).click();
    cy.get(UserManagementPage.userRow).contains(userCredentials.email).click();

    cy.get(UserDetailPage.suspendAccountButton).should('be.visible').click();
    cy.get(UserDetailPage.confirmSuspendButton).click();
    cy.get(UserDetailPage.confirmationMessage).should('contain', 'Account has been suspended');

    cy.task('checkEmailNotification', userCredentials.email).should('be.sent');

    cy.visit('/login');
    cy.get(LoginPage.emailInput).type(userCredentials.email);
    cy.get(LoginPage.passwordInput).type('userpassword');
    cy.get(LoginPage.loginButton).click();
    cy.get(LoginPage.errorMessage).should('contain', 'Account is suspended');

    cy.get(AdminDashboardPage.adminLogsLink).click();
    cy.get(AdminLogsPage.logEntries).should('contain', `Suspension of user account ${userCredentials.userId}`);
  });
});