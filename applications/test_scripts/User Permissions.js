describe('User Permissions', () => {
  const adminUsername = 'admin';
  const adminPassword = 'password';
  const warehouseManagerRole = 'Warehouse Manager';
  const userJohnDoe = 'John Doe';

  beforeEach(() => {
    cy.visit('/login');
    cy.get('#username').type(adminUsername);
    cy.get('#password').type(adminPassword);
    cy.get('button[type=submit]').click();
    cy.url().should('include', '/admin-dashboard');
  });

  it('should create a new role and assign permissions', () => {
    cy.get('a[href="/roles-permissions"]').click();
    cy.url().should('include', '/roles-permissions');
    cy.get('button#create-role').click();
    cy.get('#role-name').type(warehouseManagerRole);
    cy.get('#permissions').select(['View inventory', 'Adjust stock', 'Generate reports']);
    cy.get('button#save-role').click();
    cy.contains('Role is created successfully');
  });

  it('should assign role to user', () => {
    cy.get('a[href="/user-list"]').click();
    cy.url().should('include', '/user-list');
    cy.contains(userJohnDoe).click();
    cy.get('#assign-role').select(warehouseManagerRole);
    cy.get('button#assign-role').click();
    cy.contains('Role is assigned successfully');
  });

  it('should verify user access to inventory management', () => {
    cy.logout();
    cy.login(userJohnDoe, 'johnpassword');
    cy.visit('/inventory-management');
    cy.url().should('include', '/inventory-management');
  });

  it('should fail to assign role without permissions', () => {
    cy.logout();
    cy.login('userWithoutPermission', 'password');
    cy.visit('/roles-permissions');
    cy.get('button#create-role').should('not.exist');
  });

  it('should not allow duplicate role assignment', () => {
    cy.get('a[href="/user-list"]').click();
    cy.contains(userJohnDoe).click();
    cy.get('#assign-role').select(warehouseManagerRole);
    cy.get('button#assign-role').click();
    cy.contains('Role assignment fails and an error message is displayed');
  });

  it('should not assign role to non-existent user', () => {
    cy.get('a[href="/user-list"]').click();
    cy.get('#search-user').type('NonExistentUser');
    cy.contains('No users found');
  });

  it('should verify audit logs for role assignments', () => {
    cy.get('a[href="/audit-logs"]').click();
    cy.url().should('include', '/audit-logs');
    cy.contains('Role assignment details are recorded');
  });

  it('should check role permissions for Warehouse Manager', () => {
    cy.get('a[href="/roles-permissions"]').click();
    cy.contains(warehouseManagerRole).click();
    cy.get('#permissions').should('contain', 'View inventory');
    cy.get('#permissions').should('contain', 'Adjust stock');
    cy.get('#permissions').should('contain', 'Generate reports');
  });

  it('should verify notification to user after role assignment', () => {
    cy.get('a[href="/user-list"]').click();
    cy.contains(userJohnDoe).click();
    cy.contains('User receives notification of new role assignment');
  });

  it('should fail role assignment during system downtime', () => {
    cy.visit('/system-status');
    cy.get('#downtime-status').should('contain', 'System is down');
    cy.get('a[href="/roles-permissions"]').click();
    cy.get('button#create-role').should('not.exist');
  });

  it('should check system logs for unauthorized role assignments', () => {
    cy.get('a[href="/system-logs"]').click();
    cy.url().should('include', '/system-logs');
    cy.contains('Unauthorized attempts are logged and flagged for review');
  });
});