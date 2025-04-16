describe('Bandwidth Throttling for Lower-Tier Users', () => {
  const adminCredentials = { username: 'admin', password: 'admin123' };
  const lowerTierUserId = '67890';
  const lowerTierSubscription = 'Basic';
  const lowerTierBandwidthLimit = '1Mbps';
  const higherTierUserId = '12345';

  before(() => {
    cy.loginAsAdmin(adminCredentials);
  });

  it('should navigate to throttling section', () => {
    cy.visit('/admin/dashboard');
    cy.get('[data-cy=throttling-section]').click();
    cy.contains('Throttling Section').should('be.visible');
  });

  it('should select a lower-tier user and apply throttling settings', () => {
    cy.get('[data-cy=user-list]').contains(lowerTierUserId).click();
    cy.get('[data-cy=subscription-tier]').should('contain', lowerTierSubscription);
    cy.get('[data-cy=bandwidth-limit]').should('contain', lowerTierBandwidthLimit);
    cy.get('[data-cy=apply-throttling]').click();
    cy.contains('Throttling settings applied successfully').should('be.visible');
  });

  it('should monitor user speed post-throttling', () => {
    cy.get('[data-cy=monitor-speed]').click();
    cy.contains('Current Speed: 1Mbps').should('be.visible');
  });

  it('should verify higher-tier user speed remains unaffected', () => {
    cy.get('[data-cy=user-list]').contains(higherTierUserId).click();
    cy.get('[data-cy=monitor-speed]').click();
    cy.contains('Speed unaffected and faster').should('be.visible');
  });

  it('should verify user notification of bandwidth throttling', () => {
    cy.get('[data-cy=notifications]').click();
    cy.contains('Bandwidth limitation notification sent').should('be.visible');
  });

  it('should check system logs for throttling actions', () => {
    cy.get('[data-cy=system-logs]').click();
    cy.contains('Throttling settings applied').should('be.visible');
  });

  it('should test system behavior with incorrect throttling settings', () => {
    cy.get('[data-cy=apply-incorrect-throttling]').click();
    cy.contains('Error: Incorrect settings').should('be.visible');
  });

  it('should ensure option to adjust bandwidth settings for different tiers', () => {
    cy.get('[data-cy=adjust-bandwidth]').click();
    cy.contains('Modify bandwidth settings').should('be.visible');
  });

  it('should review user feedback on throttling experience', () => {
    cy.get('[data-cy=user-feedback]').click();
    cy.contains('User awareness of throttling impact').should('be.visible');
  });

  it('should ensure compliance with regulations', () => {
    cy.get('[data-cy=compliance-check]').click();
    cy.contains('Compliance with regulations').should('be.visible');
  });

  it('should test system behavior with simulated network congestion', () => {
    cy.get('[data-cy=simulate-congestion]').click();
    cy.contains('Handles congestion gracefully').should('be.visible');
  });

  it('should verify throttling effectiveness during peak hours', () => {
    cy.get('[data-cy=peak-hour-check]').click();
    cy.contains('Effective throttling during peak hours').should('be.visible');
  });

  it('should gather user feedback on service quality despite throttling', () => {
    cy.get('[data-cy=service-quality-feedback]').click();
    cy.contains('User satisfaction with service quality').should('be.visible');
  });
});