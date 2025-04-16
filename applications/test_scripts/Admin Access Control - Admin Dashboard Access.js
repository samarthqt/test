describe('Admin Access Control - Admin Dashboard Access', () => {
  const adminUsername = 'admin_user';
  const adminPassword = 'admin_pass';
  const regularUsername = 'regular_user';
  const regularPassword = 'regular_pass';

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should allow admin user to access admin dashboard', () => {
    cy.login(adminUsername, adminPassword);
    cy.url().should('include', '/admin-dashboard');
    cy.get('.admin-feature').should('be.visible');
    cy.logout();
  });

  it('should not allow regular user to access admin dashboard', () => {
    cy.login(regularUsername, regularPassword);
    cy.url().should('include', '/user-dashboard');
    cy.visit('/admin-dashboard');
    cy.get('.error-message').should('contain', 'insufficient permissions');
  });
});