describe('Activity Log Functionality', () => {
  const user1 = { username: 'User1', password: 'password1' };
  const admin = { username: 'Admin', password: 'adminpass' };

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should log user actions and verify them as admin', () => {
    // User1 logs in
    cy.login(user1.username, user1.password);
    cy.url().should('include', '/dashboard');

    // Navigate to New Message section
    cy.get('[data-cy=new-message]').click();
    cy.url().should('include', '/new-message');

    // Send a message to User2
    cy.get('[data-cy=recipient]').type('User2');
    cy.get('[data-cy=message-body]').type('Hello User2!');
    cy.get('[data-cy=send-message]').click();
    cy.contains('Message sent successfully').should('be.visible');

    // Navigate to Subscription section
    cy.get('[data-cy=subscription]').click();
    cy.url().should('include', '/subscription');

    // Change subscription plan
    cy.get('[data-cy=change-plan]').click();
    cy.contains('Subscription changed successfully').should('be.visible');

    // Log out User1
    cy.logout();

    // Admin logs in
    cy.login(admin.username, admin.password);
    cy.url().should('include', '/admin-dashboard');

    // Navigate to Activity Logs section
    cy.get('[data-cy=activity-logs]').click();
    cy.url().should('include', '/activity-logs');

    // Search for User1's activities
    cy.get('[data-cy=search-user]').type('User1');
    cy.get('[data-cy=search-button]').click();
    cy.contains('Login').should('be.visible');
    cy.contains('Send Message').should('be.visible');
    cy.contains('Change Subscription').should('be.visible');

    // Verify timestamp of each activity
    cy.get('.activity-timestamp').each(($el) => {
      expect($el.text()).to.match(/\d{4}-\d{2}-\d{2} \d{2}:\d{2}:\d{2}/);
    });

    // Check for any missing activities
    cy.get('.activity-entry').should('have.length', 3);

    // Log out Admin
    cy.logout();

    // Attempt to access logs as a non-admin user
    cy.login(user1.username, user1.password);
    cy.visit('/activity-logs');
    cy.contains('Access denied').should('be.visible');
    cy.logout();

    // Review log integrity by attempting unauthorized changes
    // This step would require backend validation and is usually not covered by UI tests

    // Ensure log data is backed up securely
    // This step would require backend validation and is usually not covered by UI tests
  });
});