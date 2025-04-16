describe('Email Subscription Feature Verification', () => {
  const emailSubscriptionPage = new EmailSubscriptionPage();

  beforeEach(() => {
    cy.visit('/marketing/email-subscription');
  });

  it('should subscribe user with valid email address', () => {
    const emails = ['user@example.com', 'test.user@domain.com'];

    emails.forEach(email => {
      // Step 2: Enter valid email address
      emailSubscriptionPage.enterEmail(email);

      // Step 3: Click on the 'Subscribe' button
      emailSubscriptionPage.clickSubscribe();

      // Assert confirmation message is displayed
      emailSubscriptionPage.getConfirmationMessage().should('contain', 'successfully subscribed');

      // Step 4: Check email inbox for confirmation (mocked)
      cy.task('checkEmail', email).should('contain', 'Subscription Confirmation');
    });
  });
});