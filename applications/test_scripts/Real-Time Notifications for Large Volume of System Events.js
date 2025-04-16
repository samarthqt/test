describe('Real-Time Notifications for Large Volume of System Events', () => {
  before(() => {
    cy.login(); // Custom command for logging in
    cy.subscribeToSystemAlerts(); // Custom command to ensure user is subscribed to alerts
  });

  it('should trigger a large volume of system events and receive notifications', () => {
    cy.triggerSystemEvents([54321, 54322, 54323]); // Custom command to trigger events
    cy.get(NotificationPage.notificationList).should('have.length.greaterThan', 0);
  });

  it('should display all notifications with correct event details', () => {
    cy.get(NotificationPage.notificationList).each(($el, index) => {
      cy.wrap($el).within(() => {
        cy.get('.event-id').should('have.text', `5432${index + 1}`);
      });
    });
  });

  it('should check system performance metrics', () => {
    cy.checkSystemPerformance().should('be.stable'); // Custom command for performance check
  });

  it('should open multiple notifications simultaneously and redirect correctly', () => {
    cy.get(NotificationPage.notificationList).each(($el) => {
      cy.wrap($el).click();
      cy.url().should('include', '/event-details');
      cy.go('back');
    });
  });

  it('should verify event details for each notification', () => {
    cy.get(NotificationPage.notificationList).each(($el, index) => {
      cy.wrap($el).click();
      cy.get(EventDetailsPage.eventDetails).should('contain', `5432${index + 1}`);
      cy.go('back');
    });
  });
});