describe('Email Notifications - Negative Test', () => {
  const userId = '67890';
  const invalidEmail = 'invalid@domain';
  const validEmail = 'valid@domain.com';

  before(() => {
    cy.login(userId);
    cy.triggerSubscriptionRenewal(userId);
  });

  it('should attempt to send an email notification and fail due to invalid email', () => {
    cy.checkEmailQueue(userId, invalidEmail)
      .then((isQueued) => {
        expect(isQueued).to.be.false;
      });
    cy.getSystemLogs()
      .should('contain', 'Error: Failed to send email to ' + invalidEmail);
  });

  it('should resend the email notification with a valid email address', () => {
    cy.updateEmail(userId, validEmail);
    cy.triggerSubscriptionRenewal(userId);
    cy.checkEmailQueue(userId, validEmail)
      .then((isQueued) => {
        expect(isQueued).to.be.true;
      });
  });
});