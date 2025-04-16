describe('Bandwidth Management Based on Subscription Tier', () => {
  const userId = '12345';
  const subscriptionTier = 'Basic';
  const bandwidthLimit = 100; // in GB

  beforeEach(() => {
    cy.visit('/login');
    cy.login(userId);
  });

  it('should limit service usage based on subscription tier', () => {
    cy.get('nav').contains('Usage').click();
    cy.url().should('include', '/usage');

    // Simulate data usage to reach 80GB
    cy.simulateDataUsage(80);
    cy.get('.usage-info').should('contain', '80GB used');

    // Continue data usage to exceed 100GB
    cy.simulateDataUsage(21); // Using 21GB to exceed the 100GB limit
    cy.get('.warning-message').should('be.visible')
      .and('contain', 'Usage limit exceeded. Service is restricted.');
  });
});