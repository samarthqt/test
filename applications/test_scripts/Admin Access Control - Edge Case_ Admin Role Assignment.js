describe('Admin Access Control - Edge Case: Admin Role Assignment', () => {
  const username = 'restricted_user';
  const password = 'restricted_pass';

  before(() => {
    cy.visit('/login');
  });

  it('Log in as an admin user', () => {
    cy.get(LoginPage.usernameField).type('admin');
    cy.get(LoginPage.passwordField).type('admin_pass');
    cy.get(LoginPage.loginButton).click();
    cy.url().should('include', '/dashboard');
  });

  it('Navigate to the user management section', () => {
    cy.get(AdminDashboard.userManagementLink).click();
    cy.url().should('include', '/user-management');
  });

  it('Locate the user with restricted access', () => {
    cy.get(UserManagementPage.searchField).type(username);
    cy.get(UserManagementPage.searchButton).click();
    cy.get(UserManagementPage.userList).should('contain', username);
  });

  it('Assign the admin role to the user with restricted access', () => {
    cy.get(UserManagementPage.assignRoleButton(username)).click();
    cy.get(UserManagementPage.roleDropdown).select('Admin');
    cy.get(UserManagementPage.saveButton).click();
    cy.get(UserManagementPage.successMessage).should('be.visible');
  });

  it('Log out the current admin user', () => {
    cy.get(AdminDashboard.logoutButton).click();
    cy.url().should('include', '/login');
  });

  it('Log in as the user with newly assigned admin role', () => {
    cy.get(LoginPage.usernameField).type(username);
    cy.get(LoginPage.passwordField).type(password);
    cy.get(LoginPage.loginButton).click();
    cy.url().should('include', '/dashboard');
  });

  it('Verify the user's access to restricted sections previously inaccessible', () => {
    cy.get(AdminDashboard.restrictedSectionLink).click();
    cy.url().should('include', '/restricted-section');
  });
});