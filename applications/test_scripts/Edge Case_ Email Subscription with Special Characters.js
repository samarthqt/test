describe('Email Subscription with Special Characters', () => {
  const emailPage = new EmailSubscriptionPage();

  beforeEach(() => {
    cy.visit('/email-subscription');
  });

  it('should accept and display email with special characters', () => {
    const email1 = 'user+test@example.com';
    emailPage.enterEmail(email1);
    emailPage.clickSubscribe();
    emailPage.verifySubscriptionSuccess();
    emailPage.checkEmailInbox(email1);
  });

  it('should accept and display another email with special characters', () => {
    const email2 = 'test.user@domain.co.uk';
    emailPage.enterEmail(email2);
    emailPage.clickSubscribe();
    emailPage.verifySubscriptionSuccess();
    emailPage.checkEmailInbox(email2);
  });
});