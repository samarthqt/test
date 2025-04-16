describe('Email Notifications - Positive Test', () => {
  const userEmail = 'user@example.com';
  const userId = '67890';

  before(() => {
    cy.login(userId);
  });

  it('Trigger subscription renewal event', () => {
    cy.triggerSubscriptionRenewal(userId);
  });

  it('Check email notifications queue', () => {
    cy.checkEmailQueue(userEmail).should('contain', 'Subscription Renewal');
  });

  it('Verify email is sent', () => {
    cy.verifyEmailSent(userEmail).should('be.true');
  });

  it('Open received email and verify content', () => {
    cy.openEmail(userEmail).then(email => {
      expect(email.content).to.include('Subscription Renewal Details');
    });
  });

  it('Check notification history', () => {
    cy.checkNotificationHistory(userId).should('contain', 'Email sent');
  });

  after(() => {
    cy.logout();
  });
});